/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package rhcad.touchvg.core;

public class MgCoreView {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MgCoreView(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MgCoreView obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        touchvgJNI.delete_MgCoreView(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static MgCoreView fromHandle(int h) {
    long cPtr = touchvgJNI.MgCoreView_fromHandle(h);
    return (cPtr == 0) ? null : new MgCoreView(cPtr, false);
  }

  public int toHandle() {
    return touchvgJNI.MgCoreView_toHandle(swigCPtr, this);
  }

  public void release() {
    touchvgJNI.MgCoreView_release(swigCPtr, this);
  }

  public void addRef() {
    touchvgJNI.MgCoreView_addRef(swigCPtr, this);
  }

  public int viewDataHandle() {
    return touchvgJNI.MgCoreView_viewDataHandle(swigCPtr, this);
  }

  public int viewAdapterHandle() {
    return touchvgJNI.MgCoreView_viewAdapterHandle(swigCPtr, this);
  }

  public int backDoc() {
    return touchvgJNI.MgCoreView_backDoc(swigCPtr, this);
  }

  public int backShapes() {
    return touchvgJNI.MgCoreView_backShapes(swigCPtr, this);
  }

  public int acquireFrontDoc() {
    return touchvgJNI.MgCoreView_acquireFrontDoc__SWIG_0(swigCPtr, this);
  }

  public int acquireFrontDoc(int playh) {
    return touchvgJNI.MgCoreView_acquireFrontDoc__SWIG_1(swigCPtr, this, playh);
  }

  public static void releaseDoc(int doc) {
    touchvgJNI.MgCoreView_releaseDoc(doc);
  }

  public int acquireDynamicShapes() {
    return touchvgJNI.MgCoreView_acquireDynamicShapes(swigCPtr, this);
  }

  public static void releaseShapes(int shapes) {
    touchvgJNI.MgCoreView_releaseShapes(shapes);
  }

  public boolean isDrawing() {
    return touchvgJNI.MgCoreView_isDrawing(swigCPtr, this);
  }

  public boolean isZooming() {
    return touchvgJNI.MgCoreView_isZooming(swigCPtr, this);
  }

  public boolean isStopping() {
    return touchvgJNI.MgCoreView_isStopping(swigCPtr, this);
  }

  public int stopDrawing(boolean stop) {
    return touchvgJNI.MgCoreView_stopDrawing__SWIG_0(swigCPtr, this, stop);
  }

  public int stopDrawing() {
    return touchvgJNI.MgCoreView_stopDrawing__SWIG_1(swigCPtr, this);
  }

  public boolean isUndoRecording() {
    return touchvgJNI.MgCoreView_isUndoRecording(swigCPtr, this);
  }

  public boolean isRecording() {
    return touchvgJNI.MgCoreView_isRecording(swigCPtr, this);
  }

  public boolean isPlaying() {
    return touchvgJNI.MgCoreView_isPlaying(swigCPtr, this);
  }

  public boolean isPaused() {
    return touchvgJNI.MgCoreView_isPaused(swigCPtr, this);
  }

  public int getRecordTick(boolean forUndo, int curTick) {
    return touchvgJNI.MgCoreView_getRecordTick(swigCPtr, this, forUndo, curTick);
  }

  public boolean isUndoLoading() {
    return touchvgJNI.MgCoreView_isUndoLoading(swigCPtr, this);
  }

  public boolean canUndo() {
    return touchvgJNI.MgCoreView_canUndo(swigCPtr, this);
  }

  public boolean canRedo() {
    return touchvgJNI.MgCoreView_canRedo(swigCPtr, this);
  }

  public int getRedoIndex() {
    return touchvgJNI.MgCoreView_getRedoIndex(swigCPtr, this);
  }

  public int getRedoCount() {
    return touchvgJNI.MgCoreView_getRedoCount(swigCPtr, this);
  }

  public int getPlayingTick(int curTick) {
    return touchvgJNI.MgCoreView_getPlayingTick(swigCPtr, this, curTick);
  }

  public int getFrameTick() {
    return touchvgJNI.MgCoreView_getFrameTick(swigCPtr, this);
  }

  public int getFrameFlags() {
    return touchvgJNI.MgCoreView_getFrameFlags(swigCPtr, this);
  }

  public int getFrameIndex() {
    return touchvgJNI.MgCoreView_getFrameIndex(swigCPtr, this);
  }

  public boolean isPressDragging() {
    return touchvgJNI.MgCoreView_isPressDragging(swigCPtr, this);
  }

  public boolean isDrawingCommand() {
    return touchvgJNI.MgCoreView_isDrawingCommand(swigCPtr, this);
  }

  public boolean isCommand(String name) {
    return touchvgJNI.MgCoreView_isCommand(swigCPtr, this, name);
  }

  public void getCommand(MgStringCallback c) {
    touchvgJNI.MgCoreView_getCommand(swigCPtr, this, MgStringCallback.getCPtr(c), c);
  }

  public boolean setCommand(String name, String params) {
    return touchvgJNI.MgCoreView_setCommand__SWIG_0(swigCPtr, this, name, params);
  }

  public boolean setCommand(String name) {
    return touchvgJNI.MgCoreView_setCommand__SWIG_1(swigCPtr, this, name);
  }

  public boolean switchCommand() {
    return touchvgJNI.MgCoreView_switchCommand(swigCPtr, this);
  }

  public boolean doContextAction(int action) {
    return touchvgJNI.MgCoreView_doContextAction(swigCPtr, this, action);
  }

  public void clearCachedData() {
    touchvgJNI.MgCoreView_clearCachedData(swigCPtr, this);
  }

  public int addShapesForTest(int n) {
    return touchvgJNI.MgCoreView_addShapesForTest__SWIG_0(swigCPtr, this, n);
  }

  public int addShapesForTest() {
    return touchvgJNI.MgCoreView_addShapesForTest__SWIG_1(swigCPtr, this);
  }

  public int getShapeCount() {
    return touchvgJNI.MgCoreView_getShapeCount__SWIG_0(swigCPtr, this);
  }

  public int getShapeCount(int doc) {
    return touchvgJNI.MgCoreView_getShapeCount__SWIG_1(swigCPtr, this, doc);
  }

  public int getUnlockedShapeCount(int type) {
    return touchvgJNI.MgCoreView_getUnlockedShapeCount__SWIG_0(swigCPtr, this, type);
  }

  public int getUnlockedShapeCount() {
    return touchvgJNI.MgCoreView_getUnlockedShapeCount__SWIG_1(swigCPtr, this);
  }

  public int getVisibleShapeCount(int type) {
    return touchvgJNI.MgCoreView_getVisibleShapeCount__SWIG_0(swigCPtr, this, type);
  }

  public int getVisibleShapeCount() {
    return touchvgJNI.MgCoreView_getVisibleShapeCount__SWIG_1(swigCPtr, this);
  }

  public int getChangeCount() {
    return touchvgJNI.MgCoreView_getChangeCount(swigCPtr, this);
  }

  public int getDrawCount() {
    return touchvgJNI.MgCoreView_getDrawCount(swigCPtr, this);
  }

  public int getSelectedShapeCount() {
    return touchvgJNI.MgCoreView_getSelectedShapeCount(swigCPtr, this);
  }

  public int getSelectedShapeType() {
    return touchvgJNI.MgCoreView_getSelectedShapeType(swigCPtr, this);
  }

  public int getSelectedShapeID() {
    return touchvgJNI.MgCoreView_getSelectedShapeID(swigCPtr, this);
  }

  public int getSelectedHandle() {
    return touchvgJNI.MgCoreView_getSelectedHandle(swigCPtr, this);
  }

  public void getSelectedShapeIDs(Ints ids) {
    touchvgJNI.MgCoreView_getSelectedShapeIDs(swigCPtr, this, Ints.getCPtr(ids), ids);
  }

  public void setSelectedShapeIDs(Ints ids) {
    touchvgJNI.MgCoreView_setSelectedShapeIDs(swigCPtr, this, Ints.getCPtr(ids), ids);
  }

  public void clear() {
    touchvgJNI.MgCoreView_clear(swigCPtr, this);
  }

  public boolean loadFromFile(String vgfile, boolean readOnly) {
    return touchvgJNI.MgCoreView_loadFromFile__SWIG_0(swigCPtr, this, vgfile, readOnly);
  }

  public boolean loadFromFile(String vgfile) {
    return touchvgJNI.MgCoreView_loadFromFile__SWIG_1(swigCPtr, this, vgfile);
  }

  public boolean saveToFile(int doc, String vgfile, boolean pretty) {
    return touchvgJNI.MgCoreView_saveToFile__SWIG_0(swigCPtr, this, doc, vgfile, pretty);
  }

  public boolean saveToFile(int doc, String vgfile) {
    return touchvgJNI.MgCoreView_saveToFile__SWIG_1(swigCPtr, this, doc, vgfile);
  }

  public boolean saveToFile(String vgfile, boolean pretty) {
    return touchvgJNI.MgCoreView_saveToFile__SWIG_2(swigCPtr, this, vgfile, pretty);
  }

  public boolean saveToFile(String vgfile) {
    return touchvgJNI.MgCoreView_saveToFile__SWIG_3(swigCPtr, this, vgfile);
  }

  public boolean loadShapes(MgStorage s, boolean readOnly) {
    return touchvgJNI.MgCoreView_loadShapes__SWIG_0(swigCPtr, this, MgStorage.getCPtr(s), s, readOnly);
  }

  public boolean loadShapes(MgStorage s) {
    return touchvgJNI.MgCoreView_loadShapes__SWIG_1(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public boolean saveShapes(int doc, MgStorage s) {
    return touchvgJNI.MgCoreView_saveShapes__SWIG_0(swigCPtr, this, doc, MgStorage.getCPtr(s), s);
  }

  public boolean saveShapes(MgStorage s) {
    return touchvgJNI.MgCoreView_saveShapes__SWIG_1(swigCPtr, this, MgStorage.getCPtr(s), s);
  }

  public void getContent(int doc, MgStringCallback c) {
    touchvgJNI.MgCoreView_getContent__SWIG_0(swigCPtr, this, doc, MgStringCallback.getCPtr(c), c);
  }

  public void getContent(MgStringCallback c) {
    touchvgJNI.MgCoreView_getContent__SWIG_1(swigCPtr, this, MgStringCallback.getCPtr(c), c);
  }

  public void freeContent() {
    touchvgJNI.MgCoreView_freeContent(swigCPtr, this);
  }

  public boolean setContent(String content, boolean readOnly) {
    return touchvgJNI.MgCoreView_setContent__SWIG_0(swigCPtr, this, content, readOnly);
  }

  public boolean setContent(String content) {
    return touchvgJNI.MgCoreView_setContent__SWIG_1(swigCPtr, this, content);
  }

  public boolean zoomToInitial() {
    return touchvgJNI.MgCoreView_zoomToInitial(swigCPtr, this);
  }

  public boolean zoomToExtent(float margin) {
    return touchvgJNI.MgCoreView_zoomToExtent__SWIG_0(swigCPtr, this, margin);
  }

  public boolean zoomToExtent() {
    return touchvgJNI.MgCoreView_zoomToExtent__SWIG_1(swigCPtr, this);
  }

  public boolean zoomToModel(float x, float y, float w, float h, float margin) {
    return touchvgJNI.MgCoreView_zoomToModel__SWIG_0(swigCPtr, this, x, y, w, h, margin);
  }

  public boolean zoomToModel(float x, float y, float w, float h) {
    return touchvgJNI.MgCoreView_zoomToModel__SWIG_1(swigCPtr, this, x, y, w, h);
  }

  public boolean zoomPan(float dxPixel, float dyPixel, boolean adjust) {
    return touchvgJNI.MgCoreView_zoomPan__SWIG_0(swigCPtr, this, dxPixel, dyPixel, adjust);
  }

  public boolean zoomPan(float dxPixel, float dyPixel) {
    return touchvgJNI.MgCoreView_zoomPan__SWIG_1(swigCPtr, this, dxPixel, dyPixel);
  }

  public GiContext getContext(boolean forChange) {
    return new GiContext(touchvgJNI.MgCoreView_getContext(swigCPtr, this, forChange), false);
  }

  public void setContext(int mask) {
    touchvgJNI.MgCoreView_setContext__SWIG_0(swigCPtr, this, mask);
  }

  public boolean getShapeFlag(int sid, int bit) {
    return touchvgJNI.MgCoreView_getShapeFlag(swigCPtr, this, sid, bit);
  }

  public boolean setShapeFlag(int sid, int bit, boolean on) {
    return touchvgJNI.MgCoreView_setShapeFlag(swigCPtr, this, sid, bit, on);
  }

  public void setContext(GiContext ctx, int mask, int apply) {
    touchvgJNI.MgCoreView_setContext__SWIG_1(swigCPtr, this, GiContext.getCPtr(ctx), ctx, mask, apply);
  }

  public void setContextEditing(boolean editing) {
    touchvgJNI.MgCoreView_setContextEditing(swigCPtr, this, editing);
  }

  public int addImageShape(String name, float width, float height) {
    return touchvgJNI.MgCoreView_addImageShape__SWIG_0(swigCPtr, this, name, width, height);
  }

  public int addImageShape(String name, float xc, float yc, float w, float h, int tag) {
    return touchvgJNI.MgCoreView_addImageShape__SWIG_1(swigCPtr, this, name, xc, yc, w, h, tag);
  }

  public boolean hasImageShape(int doc) {
    return touchvgJNI.MgCoreView_hasImageShape(swigCPtr, this, doc);
  }

  public boolean getImageSize(Floats info, int sid) {
    return touchvgJNI.MgCoreView_getImageSize(swigCPtr, this, Floats.getCPtr(info), info, sid);
  }

  public int findShapeByImageID(int doc, String name) {
    return touchvgJNI.MgCoreView_findShapeByImageID(swigCPtr, this, doc, name);
  }

  public int findShapeByTag(int doc, int tag) {
    return touchvgJNI.MgCoreView_findShapeByTag(swigCPtr, this, doc, tag);
  }

  public int traverseImageShapes(int doc, MgFindImageCallback c) {
    return touchvgJNI.MgCoreView_traverseImageShapes(swigCPtr, this, doc, MgFindImageCallback.getCPtr(c), c);
  }

  public boolean getViewModelBox(Floats box) {
    return touchvgJNI.MgCoreView_getViewModelBox(swigCPtr, this, Floats.getCPtr(box), box);
  }

  public boolean getModelBox(Floats box) {
    return touchvgJNI.MgCoreView_getModelBox__SWIG_0(swigCPtr, this, Floats.getCPtr(box), box);
  }

  public boolean getModelBox(Floats box, int shapeId) {
    return touchvgJNI.MgCoreView_getModelBox__SWIG_1(swigCPtr, this, Floats.getCPtr(box), box, shapeId);
  }

  public boolean getDisplayExtent(Floats box) {
    return touchvgJNI.MgCoreView_getDisplayExtent__SWIG_0(swigCPtr, this, Floats.getCPtr(box), box);
  }

  public boolean getDisplayExtent(int doc, int gs, Floats box) {
    return touchvgJNI.MgCoreView_getDisplayExtent__SWIG_1(swigCPtr, this, doc, gs, Floats.getCPtr(box), box);
  }

  public boolean getBoundingBox(Floats box) {
    return touchvgJNI.MgCoreView_getBoundingBox__SWIG_0(swigCPtr, this, Floats.getCPtr(box), box);
  }

  public boolean getBoundingBox(Floats box, int shapeId) {
    return touchvgJNI.MgCoreView_getBoundingBox__SWIG_1(swigCPtr, this, Floats.getCPtr(box), box, shapeId);
  }

  public boolean getBoundingBox(int doc, int gs, Floats box, int shapeId) {
    return touchvgJNI.MgCoreView_getBoundingBox__SWIG_2(swigCPtr, this, doc, gs, Floats.getCPtr(box), box, shapeId);
  }

  public boolean displayToModel(Floats d) {
    return touchvgJNI.MgCoreView_displayToModel(swigCPtr, this, Floats.getCPtr(d), d);
  }

  public int importSVGPath(int shapes, int sid, String d) {
    return touchvgJNI.MgCoreView_importSVGPath(swigCPtr, this, shapes, sid, d);
  }

  public int exportSVGPath(int shapes, int sid, String buf, int size) {
    return touchvgJNI.MgCoreView_exportSVGPath(swigCPtr, this, shapes, sid, buf, size);
  }

  public boolean exportSVGPath2(MgStringCallback c, int shapes, int sid) {
    return touchvgJNI.MgCoreView_exportSVGPath2(swigCPtr, this, MgStringCallback.getCPtr(c), c, shapes, sid);
  }

  public final static int kMgSquare = 0;
  public final static int kMgClosed = kMgSquare + 1;
  public final static int kMgFixedLength = kMgClosed + 1;
  public final static int kMgFixedSize = kMgFixedLength + 1;
  public final static int kMgRotateDisnable = kMgFixedSize + 1;
  public final static int kMgLocked = kMgRotateDisnable + 1;
  public final static int kMgNoSnap = kMgLocked + 1;
  public final static int kMgNoAction = kMgNoSnap + 1;
  public final static int kMgNoClone = kMgNoAction + 1;
  public final static int kMgHideContent = kMgNoClone + 1;
  public final static int kMgNoDel = kMgHideContent + 1;
  public final static int kMgCanSelLocked = kMgNoDel + 1;

}
