package com.vuforia;

public class CameraCalibration {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected CameraCalibration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CameraCalibration cameraCalibration) {
        return cameraCalibration == null ? 0 : cameraCalibration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraCalibration(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof CameraCalibration) && ((CameraCalibration) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec2F getSize() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getSize(this.swigCPtr, this), true);
    }

    public Vec2F getFocalLength() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getFocalLength(this.swigCPtr, this), true);
    }

    public Vec2F getPrincipalPoint() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getPrincipalPoint(this.swigCPtr, this), true);
    }

    public Vec4F getDistortionParameters() {
        return new Vec4F(VuforiaJNI.CameraCalibration_getDistortionParameters(this.swigCPtr, this), true);
    }

    public Vec2F getFieldOfViewRads() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getFieldOfViewRads(this.swigCPtr, this), true);
    }
}
