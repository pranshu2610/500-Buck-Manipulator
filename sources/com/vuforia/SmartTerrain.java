package com.vuforia;

public class SmartTerrain extends Tracker {
    private long swigCPtr;

    public static final class HITTEST_HINT {
        public static final int HITTEST_HINT_HORIZONTAL_PLANE = 1;
        public static final int HITTEST_HINT_NONE = 0;
        public static final int HITTEST_HINT_VERTICAL_PLANE = 2;
    }

    protected SmartTerrain(long j, boolean z) {
        super(VuforiaJNI.SmartTerrain_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(SmartTerrain smartTerrain) {
        return smartTerrain == null ? 0 : smartTerrain.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SmartTerrain(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof SmartTerrain) && ((SmartTerrain) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrain_getClassType(), true);
    }

    public void hitTest(State state, Vec2F vec2F, float f, int i) {
        VuforiaJNI.SmartTerrain_hitTest__SWIG_0(this.swigCPtr, this, State.getCPtr(state), state, Vec2F.getCPtr(vec2F), vec2F, f, i);
    }

    public HitTestResultList hitTest(Vec2F vec2F, int i, State state, float f) {
        return new HitTestResultList(VuforiaJNI.SmartTerrain_hitTest__SWIG_1(this.swigCPtr, this, Vec2F.getCPtr(vec2F), vec2F, i, State.getCPtr(state), state, f), true);
    }

    public int getHitTestResultCount() {
        return VuforiaJNI.SmartTerrain_getHitTestResultCount(this.swigCPtr, this);
    }

    public HitTestResult getHitTestResult(int i) {
        long SmartTerrain_getHitTestResult = VuforiaJNI.SmartTerrain_getHitTestResult(this.swigCPtr, this, i);
        return SmartTerrain_getHitTestResult == 0 ? null : new HitTestResult(SmartTerrain_getHitTestResult, false);
    }
}
