package com.vuforia;

public class DeviceTracker extends Tracker {
    private long swigCPtr;

    protected DeviceTracker(long j, boolean z) {
        super(VuforiaJNI.DeviceTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DeviceTracker deviceTracker) {
        return deviceTracker == null ? 0 : deviceTracker.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DeviceTracker) && ((DeviceTracker) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTracker_getClassType(), true);
    }

    public boolean setWorldToDeviceBaseTransform(Matrix34F matrix34F) {
        return VuforiaJNI.DeviceTracker_setWorldToDeviceBaseTransform(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Matrix34F getWorldToDeviceBaseTransform() {
        return new Matrix34F(VuforiaJNI.DeviceTracker_getWorldToDeviceBaseTransform(this.swigCPtr, this), true);
    }
}
