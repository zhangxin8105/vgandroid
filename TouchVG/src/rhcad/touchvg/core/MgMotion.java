/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package rhcad.touchvg.core;

public class MgMotion {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected MgMotion(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgMotion obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_MgMotion(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setView(MgView value) {
    touchvgJNI.MgMotion_view_set(swigCPtr, this, MgView.getCPtr(value), value);
  }

  public MgView getView() {
    long cPtr = touchvgJNI.MgMotion_view_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MgView(cPtr, false);
  }

  public void setGestureType(int value) {
    touchvgJNI.MgMotion_gestureType_set(swigCPtr, this, value);
  }

  public int getGestureType() {
    return touchvgJNI.MgMotion_gestureType_get(swigCPtr, this);
  }

  public void setGestureState(MgGestureState value) {
    touchvgJNI.MgMotion_gestureState_set(swigCPtr, this, value.swigValue());
  }

  public MgGestureState getGestureState() {
    return MgGestureState.swigToEnum(touchvgJNI.MgMotion_gestureState_get(swigCPtr, this));
  }

  public void setPressDrag(boolean value) {
    touchvgJNI.MgMotion_pressDrag_set(swigCPtr, this, value);
  }

  public boolean getPressDrag() {
    return touchvgJNI.MgMotion_pressDrag_get(swigCPtr, this);
  }

  public void setSwitchGesture(boolean value) {
    touchvgJNI.MgMotion_switchGesture_set(swigCPtr, this, value);
  }

  public boolean getSwitchGesture() {
    return touchvgJNI.MgMotion_switchGesture_get(swigCPtr, this);
  }

  public void setVelocity(Vector2d value) {
    touchvgJNI.MgMotion_velocity_set(swigCPtr, this, Vector2d.getCPtr(value), value);
  }

  public Vector2d getVelocity() {
    long cPtr = touchvgJNI.MgMotion_velocity_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Vector2d(cPtr, false);
  }

  public void setStartPt(Point2d value) {
    touchvgJNI.MgMotion_startPt_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getStartPt() {
    long cPtr = touchvgJNI.MgMotion_startPt_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setStartPtM(Point2d value) {
    touchvgJNI.MgMotion_startPtM_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getStartPtM() {
    long cPtr = touchvgJNI.MgMotion_startPtM_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setLastPt(Point2d value) {
    touchvgJNI.MgMotion_lastPt_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getLastPt() {
    long cPtr = touchvgJNI.MgMotion_lastPt_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setLastPtM(Point2d value) {
    touchvgJNI.MgMotion_lastPtM_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getLastPtM() {
    long cPtr = touchvgJNI.MgMotion_lastPtM_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setPoint(Point2d value) {
    touchvgJNI.MgMotion_point_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getPoint() {
    long cPtr = touchvgJNI.MgMotion_point_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setPointM(Point2d value) {
    touchvgJNI.MgMotion_pointM_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getPointM() {
    long cPtr = touchvgJNI.MgMotion_pointM_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setStartPt2(Point2d value) {
    touchvgJNI.MgMotion_startPt2_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getStartPt2() {
    long cPtr = touchvgJNI.MgMotion_startPt2_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setStartPt2M(Point2d value) {
    touchvgJNI.MgMotion_startPt2M_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getStartPt2M() {
    long cPtr = touchvgJNI.MgMotion_startPt2M_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setPoint2(Point2d value) {
    touchvgJNI.MgMotion_point2_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getPoint2() {
    long cPtr = touchvgJNI.MgMotion_point2_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setPoint2M(Point2d value) {
    touchvgJNI.MgMotion_point2M_set(swigCPtr, this, Point2d.getCPtr(value), value);
  }

  public Point2d getPoint2M() {
    long cPtr = touchvgJNI.MgMotion_point2M_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Point2d(cPtr, false);
  }

  public void setD2mgs(float value) {
    touchvgJNI.MgMotion_d2mgs_set(swigCPtr, this, value);
  }

  public float getD2mgs() {
    return touchvgJNI.MgMotion_d2mgs_get(swigCPtr, this);
  }

  public void setD2m(float value) {
    touchvgJNI.MgMotion_d2m_set(swigCPtr, this, value);
  }

  public float getD2m() {
    return touchvgJNI.MgMotion_d2m_get(swigCPtr, this);
  }

  public MgMotion() {
    this(touchvgJNI.new_MgMotion(), true);
  }

  public boolean dragging() {
    return touchvgJNI.MgMotion_dragging(swigCPtr, this);
  }

  public MgCmdManager cmds() {
    long cPtr = touchvgJNI.MgMotion_cmds(swigCPtr, this);
    return (cPtr == 0) ? null : new MgCmdManager(cPtr, false);
  }

  public Point2d startCenterM() {
    return new Point2d(touchvgJNI.MgMotion_startCenterM(swigCPtr, this), true);
  }

  public Point2d centerM() {
    return new Point2d(touchvgJNI.MgMotion_centerM(swigCPtr, this), true);
  }

  public float startDistanceM() {
    return touchvgJNI.MgMotion_startDistanceM(swigCPtr, this);
  }

  public float distanceM() {
    return touchvgJNI.MgMotion_distanceM(swigCPtr, this);
  }

  public float displayMmToModel(float mm, GiGraphics arg1) {
    return touchvgJNI.MgMotion_displayMmToModel__SWIG_0(swigCPtr, this, mm, GiGraphics.getCPtr(arg1), arg1);
  }

  public float displayMmToModel(float mm) {
    return touchvgJNI.MgMotion_displayMmToModel__SWIG_1(swigCPtr, this, mm);
  }

  public float displayMmToModel(String name, float mm) {
    return touchvgJNI.MgMotion_displayMmToModel__SWIG_2(swigCPtr, this, name, mm);
  }

  public Box2d displayMmToModelBox(float mm) {
    return new Box2d(touchvgJNI.MgMotion_displayMmToModelBox__SWIG_0(swigCPtr, this, mm), true);
  }

  public Box2d displayMmToModelBox(String name, float mm) {
    return new Box2d(touchvgJNI.MgMotion_displayMmToModelBox__SWIG_1(swigCPtr, this, name, mm), true);
  }

}
