package com.vuforia;

public class DeviceTrackable extends Trackable {
    private long swigCPtr;

    protected DeviceTrackable(long j, boolean z) {
        super(VuforiaJNI.DeviceTrackable_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DeviceTrackable deviceTrackable) {
        return deviceTrackable == null ? 0 : deviceTrackable.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DeviceTrackable) && ((DeviceTrackable) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackable_getClassType(), true);
    }
}
