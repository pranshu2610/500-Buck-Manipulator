package com.vuforia;

public class DeviceTrackableResult extends TrackableResult {
    private long swigCPtr;

    protected DeviceTrackableResult(long j, boolean z) {
        super(VuforiaJNI.DeviceTrackableResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DeviceTrackableResult deviceTrackableResult) {
        return deviceTrackableResult == null ? 0 : deviceTrackableResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DeviceTrackableResult) && ((DeviceTrackableResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackableResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new DeviceTrackable(VuforiaJNI.DeviceTrackableResult_getTrackable(this.swigCPtr, this), false);
    }
}
