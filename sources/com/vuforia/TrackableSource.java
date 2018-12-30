package com.vuforia;

public class TrackableSource {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TrackableSource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackableSource trackableSource) {
        return trackableSource == null ? 0 : trackableSource.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableSource(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TrackableSource) && ((TrackableSource) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public TrackableSource() {
        this(VuforiaJNI.new_TrackableSource(), true);
    }
}
