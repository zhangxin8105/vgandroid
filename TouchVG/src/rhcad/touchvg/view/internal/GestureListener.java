﻿//! \file GestureListener.java
//! \brief Android绘图手势识别类
// Copyright (c) 2012-2013, https://github.com/rhcad/touchvg

package rhcad.touchvg.view.internal;

import rhcad.touchvg.IGraphView;
import rhcad.touchvg.IGraphView.OnDrawGestureListener;
import rhcad.touchvg.core.GiCoreView;
import rhcad.touchvg.core.GiGestureState;
import rhcad.touchvg.core.GiGestureType;
import rhcad.touchvg.core.GiView;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

//! Android绘图手势识别类
public class GestureListener extends SimpleOnGestureListener {
    private static final String TAG = "touchvg";
    private static final int M_STOPPED = 0;
    private static final int M_STARTED = 1;
    private static final int M_READY_MOVE = 2;
    private static final int M_MOVING = 3;
    private static final int M_END_MOVE = 4;
    private static final int M_PRESS_MOVING = 5;
    private static final int XY_COUNT = 20;         // 待分发的移动轨迹点数*2
    private GiCoreView mCoreView;                   // 内核视图分发器
    private GiView mAdapter;                        // 视图回调适配器
    private int mListenerType = 0;                  // OnDrawGestureListener 类型
    private int mMoving = M_STOPPED;                // 移动状态
    private int mFingerCount;                       // 上一次的触摸点数
    private int mXYCount = 0;                       // mPoints值个数
    private float[] mPoints = new float[XY_COUNT];  // 待分发的移动轨迹
    private VelocityTracker mVelocityTracker;       // 移动中判断速度
    private boolean mTrackerEnabled = false;
    private float mLastX;
    private float mLastY;
    private float mLastX2;
    private float mLastY2;
    private long mDownTime = 0;
    private long mTouchTime;

    public GestureListener(GiCoreView coreView, GiView adapter, Object view) {
        mCoreView = coreView;
        mAdapter = adapter;
    }

    protected void finalize() {
        Log.d(TAG, "GestureListener finalize");
    }

    public void release() {
        mCoreView = null;
        mAdapter = null;
    }

    public void setGestureEnabled(boolean enabled) {
        if (!enabled) {
            cancelDragging();
            mCoreView.setCommand(null);
        }
    }

    public void setVelocityTrackerEnabled(boolean enabled) {
        mTrackerEnabled = enabled;
    }

    public void cancelDragging() {
        if (mMoving == M_MOVING) {
            mMoving = M_STOPPED;
            onMoved(GiGestureState.kGiGestureCancel, mFingerCount, 0, 0, 0, 0, false);
        } else if (mMoving == M_PRESS_MOVING) {
            mMoving = M_STOPPED;
            mCoreView.onGesture(mAdapter, GiGestureType.kGiGesturePress,
                    GiGestureState.kGiGestureCancel, 0, 0);
        }
        onTouchEnded();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mMoving = M_STARTED;
        mXYCount = 0;
        if (e.getPointerCount() == 1) {
            mLastX = e.getX(0);
            mLastY = e.getY(0);
            mPoints[mXYCount++] = mLastX;
            mPoints[mXYCount++] = mLastY;
        }
        mLastX2 = mLastX;
        mLastY2 = mLastY;
        mDownTime = e.getDownTime();

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent downEv, MotionEvent e, float dx, float dy) {
        if (mMoving == M_STARTED) {
            mMoving = M_READY_MOVE;
        }
        return mMoving == M_READY_MOVE || mMoving == M_MOVING;
    }

    public boolean onTouch(View v, MotionEvent e) {
        int action = e.getActionMasked();
        float x1 = e.getPointerCount() > 0 ? e.getX(0) : 0;
        float y1 = e.getPointerCount() > 0 ? e.getY(0) : 0;
        float x2 = e.getPointerCount() > 1 ? e.getX(1) : x1;
        float y2 = e.getPointerCount() > 1 ? e.getY(1) : y1;

        mTouchTime = e.getEventTime();
        if (mVelocityTracker == null && mTrackerEnabled && action == MotionEvent.ACTION_DOWN) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(e);
            mVelocityTracker.computeCurrentVelocity(1000);
            final float velocityY = mVelocityTracker.getYVelocity(e.getPointerId(0));
            final float velocityX = mVelocityTracker.getXVelocity(e.getPointerId(0));
            mCoreView.setGestureVelocity(mAdapter, velocityY, velocityX);
        }

        onTouch_(v, action, e.getPointerCount(), x1, y1, x2, y2);
        return false;   // to call GestureDetector.onTouchEvent
    }

    // ! 传递单指触摸事件，可用于拖放操作
    public boolean onTouchDrag(View v, int action, float x, float y) {
        if (action == MotionEvent.ACTION_DOWN) {
            mMoving = M_READY_MOVE;
            mXYCount = 0;
            mLastX = x;
            mLastY = y;
            mPoints[mXYCount++] = mLastX;
            mPoints[mXYCount++] = mLastY;
            mLastX2 = mLastX;
            mLastY2 = mLastY;
        }
        return onTouch_(v, action, 1, x, y, x, y);
    }

    private void onTouchEnded() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private boolean onTouch_(View v, int action, int count, float x1, float y1, float x2, float y2) {
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            v.getParent().requestDisallowInterceptTouchEvent(false);
        } else {        // 按下后不允许父视图拦截触摸事件
            v.getParent().requestDisallowInterceptTouchEvent(true);
        }

        boolean ret = false;

        switch (action) {
        case MotionEvent.ACTION_DOWN:
            ret = true;
            break;
        case MotionEvent.ACTION_MOVE:
            synchronized (mCoreView) {
                ret = onTouchMoved(count, x1, y1, x2, y2);
            }
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            synchronized (mCoreView) {
                ret = onTouchEnded(action == MotionEvent.ACTION_UP, x1, y1, x2, y2);
                onTouchEnded();
            }
            break;
        }

        return ret;
    }

    private boolean onTouchMoved(int fingerCount, float x1, float y1, float x2, float y2) {
        if (fingerCount == 1 && Math.abs(mLastX - x1) < 1 && Math.abs(mLastY - y1) < 1) {
            return false;
        }
        if (fingerCount == 2 && Math.abs(mLastX - x1) < 1 && Math.abs(mLastY - y1) < 1
                && Math.abs(mLastX2 - x2) < 1 && Math.abs(mLastY2 - y2) < 1) {
            return false;
        }
        if (mMoving == M_READY_MOVE || (mMoving == M_STARTED && fingerCount == 2)) {
            mFingerCount = fingerCount;
            mLastX = x1;
            mLastY = y1;
            mLastX2 = x2;
            mLastY2 = y2;

            if (mMoving == M_STARTED) {
                mMoving = M_READY_MOVE;
            } else if (fingerCount == 1 && mXYCount > 0) {
                mMoving = applyPendingPoints() ? M_MOVING : M_END_MOVE;
            } else {
                mMoving = (onMoved(GiGestureState.kGiGesturePossible, mFingerCount,
                                x1, y1, x2, y2, false)
                        && onMoved(GiGestureState.kGiGestureBegan, mFingerCount,
                                x1, y1, x2,y2, false)) ? M_MOVING : M_END_MOVE;
            }
            mXYCount = 0;
        } else if (mMoving == M_STARTED && fingerCount == 1
                && mXYCount > 0 && mXYCount + 1 < XY_COUNT) {
            mPoints[mXYCount++] = x1;
            mPoints[mXYCount++] = y1;
        } else if (mMoving == M_PRESS_MOVING) {
            mCoreView.onGesture(mAdapter, GiGestureType.kGiGesturePress,
                    GiGestureState.kGiGestureMoved, x1, y1);
        }
        if (mMoving != M_MOVING) {
            return false;
        }

        boolean ret = false;

        if (mFingerCount != fingerCount) {
            if (mFingerCount == 1) {                // 单指变为双指
                if (mTouchTime - mDownTime < 800) { // 双指先后触到屏
                    ret = onMoved(GiGestureState.kGiGestureCancel, 1, mLastX, mLastY, 0, 0, true);
                } else {                            // 单指移动一段时间后变为双指
                    ret = onMoved(GiGestureState.kGiGestureEnded, 1, mLastX, mLastY, 0, 0, true);
                }
                if (onMoved(GiGestureState.kGiGesturePossible, fingerCount, x1, y1, x2, y2, true)) {
                    mFingerCount = fingerCount;
                    ret = onMoved(GiGestureState.kGiGestureBegan, fingerCount, x1, y1, x2, y2, true);
                } else {
                    mMoving = M_END_MOVE;
                }
            } else {                                // 不允许双指变为单指
                mMoving = M_END_MOVE;
                ret = onMoved(GiGestureState.kGiGestureEnded, mFingerCount, x1, y1, x2, y2, true);
            }
        } else {
            ret = onMoved(GiGestureState.kGiGestureMoved, mFingerCount, x1, y1, x2, y2, false);
            mLastX = x1;
            mLastY = y1;
        }

        return ret;
    }

    private boolean onTouchEnded(boolean submit, float x1, float y1, float x2, float y2) {
        if (submit && mXYCount > 2 && applyPendingPoints()) {
            mMoving = M_MOVING;
        }
        boolean ret = false;
        if (mMoving == M_MOVING) {
            ret = onMoved(submit ? GiGestureState.kGiGestureEnded : GiGestureState.kGiGestureCancel,
                    mFingerCount, x1, y1, x2, y2, false);
        } else if (mMoving == M_PRESS_MOVING) {
            ret = mCoreView.onGesture(mAdapter, GiGestureType.kGiGesturePress,
                    submit ? GiGestureState.kGiGestureEnded : GiGestureState.kGiGestureCancel, 0, 0);
        }
        mMoving = M_STOPPED;
        mFingerCount = 0;

        return ret;
    }

    private boolean applyPendingPoints() {
        boolean ret = (onMoved(GiGestureState.kGiGesturePossible, mFingerCount,
                        mPoints[0], mPoints[1], 0, 0, false)
                && onMoved(GiGestureState.kGiGestureBegan, mFingerCount,
                        mPoints[0], mPoints[1], 0, 0, false));
        for (int i = 2; i + 1 < mXYCount && ret; i += 2) {
            onMoved(GiGestureState.kGiGestureMoved, mFingerCount,
                    mPoints[i], mPoints[i + 1], 0, 0, false);
        }
        return ret;
    }

    private boolean onMoved(GiGestureState state, int fingerCount, float x1, float y1, float x2,
            float y2, boolean s) {
        return fingerCount > 1 ? mCoreView.twoFingersMove(mAdapter, state, x1, y1, x2, y2, s)
                : mCoreView.onGesture(mAdapter, GiGestureType.kGiGesturePan, state, x1, y1, s);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        final OnDrawGestureListener notify = getNotify();

        if (notify != null && notify.onPreGesture(IGraphView.kGesturePress, e.getX(), e.getY())) {
        } else if (mXYCount > 1             // onDown called
                && mCoreView.onGesture(mAdapter, GiGestureType.kGiGesturePress,
                        GiGestureState.kGiGestureBegan, e.getX(), e.getY())) {
            mXYCount = 0;
            mMoving = M_PRESS_MOVING;
            if (notify != null)
                notify.onPostGesture(IGraphView.kGesturePress, e.getX(), e.getY());
        } else if (mMoving == M_STARTED) {  // onDown 后还未移动
            mMoving = M_READY_MOVE;         // onTouch 中将开始移动
        }
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        final OnDrawGestureListener notify = getNotify();

        if (mCoreView == null)
            return false;
        if (notify != null && notify.onPreGesture(IGraphView.kGestureTap, e.getX(), e.getY()))
            return true;
        synchronized (mCoreView) {
            boolean ret = mXYCount > 1 && onTap(mPoints[0], mPoints[1]);
            if (notify != null)
                notify.onPostGesture(IGraphView.kGestureTap, e.getX(), e.getY());
            return ret;
        }
    }

    // ! 传递单指轻击事件，可用于拖放操作
    public boolean onTap(float x, float y) {
        mMoving = M_STOPPED;
        if (mCoreView == null)
            return false;
        synchronized (mCoreView) {
            return mCoreView.onGesture(mAdapter, GiGestureType.kGiGestureTap,
                    GiGestureState.kGiGesturePossible, x, y)
                    && mCoreView.onGesture(mAdapter, GiGestureType.kGiGestureTap,
                            GiGestureState.kGiGestureEnded, x, y);
        }
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        boolean ret = mXYCount > 1;
        final OnDrawGestureListener notify = getNotify();

        if (mCoreView == null)
            return false;
        if (ret && (notify == null || !notify.onPreGesture(IGraphView.kGestureDblTap, e.getX(), e.getY()))) {
            ret = mCoreView.onGesture(mAdapter, GiGestureType.kGiGestureDblTap,
                    GiGestureState.kGiGesturePossible, mPoints[0], mPoints[1])
                    && mCoreView.onGesture(mAdapter, GiGestureType.kGiGestureDblTap,
                            GiGestureState.kGiGestureEnded, e.getX(), e.getY());
            if (notify != null)
                notify.onPostGesture(IGraphView.kGestureDblTap, e.getX(), e.getY());
        }
        mXYCount = 0;

        return ret;
    }

    private final OnDrawGestureListener getNotify() {
        OnDrawGestureListener listener = null;

        if (mListenerType == 0) {
            try {
                listener = (OnDrawGestureListener) mAdapter;
                mListenerType = 1;
            } catch (Exception e) {
                mListenerType = -1;
            }
        } else if (mListenerType > 0) {
            listener = (OnDrawGestureListener) mAdapter;
        }

        return listener;
    }
}
