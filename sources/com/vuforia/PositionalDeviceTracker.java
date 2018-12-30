package com.vuforia;

public class PositionalDeviceTracker extends DeviceTracker {
    private long swigCPtr;

    protected PositionalDeviceTracker(long j, boolean z) {
        super(VuforiaJNI.PositionalDeviceTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(PositionalDeviceTracker positionalDeviceTracker) {
        return positionalDeviceTracker == null ? 0 : positionalDeviceTracker.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_PositionalDeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PositionalDeviceTracker) && ((PositionalDeviceTracker) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.PositionalDeviceTracker_getClassType(), true);
    }

    public Anchor createAnchor(String str, Matrix34F matrix34F) {
        long PositionalDeviceTracker_createAnchor__SWIG_0 = VuforiaJNI.PositionalDeviceTracker_createAnchor__SWIG_0(this.swigCPtr, this, str, Matrix34F.getCPtr(matrix34F), matrix34F);
        return PositionalDeviceTracker_createAnchor__SWIG_0 == 0 ? null : new Anchor(PositionalDeviceTracker_createAnchor__SWIG_0, false);
    }

    public Anchor createAnchor(String str, HitTestResult hitTestResult) {
        long PositionalDeviceTracker_createAnchor__SWIG_1 = VuforiaJNI.PositionalDeviceTracker_createAnchor__SWIG_1(this.swigCPtr, this, str, HitTestResult.getCPtr(hitTestResult), hitTestResult);
        return PositionalDeviceTracker_createAnchor__SWIG_1 == 0 ? null : new Anchor(PositionalDeviceTracker_createAnchor__SWIG_1, false);
    }

    public boolean destroyAnchor(Anchor anchor) {
        return VuforiaJNI.PositionalDeviceTracker_destroyAnchor(this.swigCPtr, this, Anchor.getCPtr(anchor), anchor);
    }

    public int getNumAnchors() {
        return VuforiaJNI.PositionalDeviceTracker_getNumAnchors(this.swigCPtr, this);
    }

    public Anchor getAnchor(int i) {
        long PositionalDeviceTracker_getAnchor = VuforiaJNI.PositionalDeviceTracker_getAnchor(this.swigCPtr, this, i);
        return PositionalDeviceTracker_getAnchor == 0 ? null : new Anchor(PositionalDeviceTracker_getAnchor, false);
    }

    public AnchorList getAnchors() {
        return new AnchorList(VuforiaJNI.PositionalDeviceTracker_getAnchors(this.swigCPtr, this), true);
    }

    public boolean reset() {
        return VuforiaJNI.PositionalDeviceTracker_reset(this.swigCPtr, this);
    }
}
