package com.vuforia;

public class EyewearCalibrationProfileManager {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected EyewearCalibrationProfileManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(EyewearCalibrationProfileManager eyewearCalibrationProfileManager) {
        return eyewearCalibrationProfileManager == null ? 0 : eyewearCalibrationProfileManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearCalibrationProfileManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof EyewearCalibrationProfileManager) && ((EyewearCalibrationProfileManager) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public long getMaxCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getMaxCount(this.swigCPtr, this);
    }

    public long getUsedCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getUsedCount(this.swigCPtr, this);
    }

    public boolean isProfileUsed(int i) {
        return VuforiaJNI.EyewearCalibrationProfileManager_isProfileUsed(this.swigCPtr, this, i);
    }

    public int getActiveProfile() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getActiveProfile(this.swigCPtr, this);
    }

    public boolean setActiveProfile(int i) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setActiveProfile(this.swigCPtr, this, i);
    }

    public Matrix34F getCameraToEyePose(int i, int i2) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getCameraToEyePose(this.swigCPtr, this, i, i2), true);
    }

    public Matrix34F getEyeProjection(int i, int i2) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getEyeProjection(this.swigCPtr, this, i, i2), true);
    }

    public boolean setCameraToEyePose(int i, int i2, Matrix34F matrix34F) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setCameraToEyePose(this.swigCPtr, this, i, i2, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public boolean setEyeProjection(int i, int i2, Matrix34F matrix34F) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setEyeProjection(this.swigCPtr, this, i, i2, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public String getProfileName(int i) {
        short[] EyewearCalibrationProfileManager_getProfileName = VuforiaJNI.EyewearCalibrationProfileManager_getProfileName(this.swigCPtr, this, i);
        if (EyewearCalibrationProfileManager_getProfileName == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(EyewearCalibrationProfileManager_getProfileName.length);
        for (short appendCodePoint : EyewearCalibrationProfileManager_getProfileName) {
            stringBuilder.appendCodePoint(appendCodePoint);
        }
        return stringBuilder.toString();
    }

    public boolean setProfileName(int i, String str) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setProfileName(this.swigCPtr, this, i, Vuforia.convertStringToShortArray(str));
    }

    public boolean clearProfile(int i) {
        return VuforiaJNI.EyewearCalibrationProfileManager_clearProfile(this.swigCPtr, this, i);
    }
}
