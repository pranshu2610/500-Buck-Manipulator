package com.vuforia;

public class Vec4I {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec4I(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec4I vec4I) {
        return vec4I == null ? 0 : vec4I.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec4I(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Vec4I) && ((Vec4I) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec4I() {
        this(VuforiaJNI.new_Vec4I__SWIG_0(), true);
    }

    public Vec4I(int[] iArr) {
        this(VuforiaJNI.new_Vec4I__SWIG_1(iArr), true);
    }

    public void setData(int[] iArr) {
        VuforiaJNI.Vec4I_data_set(this.swigCPtr, this, iArr);
    }

    public int[] getData() {
        return VuforiaJNI.Vec4I_data_get(this.swigCPtr, this);
    }
}
