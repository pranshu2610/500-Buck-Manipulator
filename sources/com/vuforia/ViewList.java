package com.vuforia;

public class ViewList {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ViewList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ViewList viewList) {
        return viewList == null ? 0 : viewList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ViewList) && ((ViewList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public long getNumViews() {
        return VuforiaJNI.ViewList_getNumViews(this.swigCPtr, this);
    }

    public int getView(int i) {
        return VuforiaJNI.ViewList_getView(this.swigCPtr, this, i);
    }

    public boolean contains(int i) {
        return VuforiaJNI.ViewList_contains(this.swigCPtr, this, i);
    }
}
