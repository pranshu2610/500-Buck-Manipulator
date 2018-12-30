package com.vuforia;

public class TargetSearchResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetSearchResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetSearchResult targetSearchResult) {
        return targetSearchResult == null ? 0 : targetSearchResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetSearchResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TargetSearchResult) && ((TargetSearchResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public String getTargetName() {
        return VuforiaJNI.TargetSearchResult_getTargetName(this.swigCPtr, this);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.TargetSearchResult_getUniqueTargetId(this.swigCPtr, this);
    }

    public float getTargetSize() {
        return VuforiaJNI.TargetSearchResult_getTargetSize(this.swigCPtr, this);
    }

    public String getMetaData() {
        return VuforiaJNI.TargetSearchResult_getMetaData(this.swigCPtr, this);
    }

    public short getTrackingRating() {
        return VuforiaJNI.TargetSearchResult_getTrackingRating(this.swigCPtr, this);
    }
}
