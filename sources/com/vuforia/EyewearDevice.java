package com.vuforia;

public class EyewearDevice extends Device {
    private long swigCPtr;

    public static final class ORIENTATION {
        public static final int ORIENTATION_LANDSCAPE_LEFT = 2;
        public static final int ORIENTATION_LANDSCAPE_RIGHT = 3;
        public static final int ORIENTATION_PORTRAIT = 1;
        public static final int ORIENTATION_UNDEFINED = 0;
    }

    protected EyewearDevice(long j, boolean z) {
        super(VuforiaJNI.EyewearDevice_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(EyewearDevice eyewearDevice) {
        return eyewearDevice == null ? 0 : eyewearDevice.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearDevice(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof EyewearDevice) && ((EyewearDevice) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.EyewearDevice_getClassType(), true);
    }

    public boolean isSeeThru() {
        return VuforiaJNI.EyewearDevice_isSeeThru(this.swigCPtr, this);
    }

    public boolean isDualDisplay() {
        return VuforiaJNI.EyewearDevice_isDualDisplay(this.swigCPtr, this);
    }

    public boolean setDisplayExtended(boolean z) {
        return VuforiaJNI.EyewearDevice_setDisplayExtended(this.swigCPtr, this, z);
    }

    public boolean isDisplayExtended() {
        return VuforiaJNI.EyewearDevice_isDisplayExtended(this.swigCPtr, this);
    }

    public boolean isDisplayExtendedGLOnly() {
        return VuforiaJNI.EyewearDevice_isDisplayExtendedGLOnly(this.swigCPtr, this);
    }

    public int getScreenOrientation() {
        return VuforiaJNI.EyewearDevice_getScreenOrientation(this.swigCPtr, this);
    }

    public boolean setPredictiveTracking(boolean z) {
        return VuforiaJNI.EyewearDevice_setPredictiveTracking(this.swigCPtr, this, z);
    }

    public boolean isPredictiveTrackingEnabled() {
        return VuforiaJNI.EyewearDevice_isPredictiveTrackingEnabled(this.swigCPtr, this);
    }

    public EyewearCalibrationProfileManager getCalibrationProfileManager() {
        return new EyewearCalibrationProfileManager(VuforiaJNI.EyewearDevice_getCalibrationProfileManager(this.swigCPtr, this), false);
    }

    public EyewearUserCalibrator getUserCalibrator() {
        return new EyewearUserCalibrator(VuforiaJNI.EyewearDevice_getUserCalibrator(this.swigCPtr, this), false);
    }
}
