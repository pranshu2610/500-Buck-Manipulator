package com.vuforia;

public class Vec4F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec4F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec4F vec4F) {
        return vec4F == null ? 0 : vec4F.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec4F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Vec4F) && ((Vec4F) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec4F() {
        this(VuforiaJNI.new_Vec4F__SWIG_0(), true);
    }

    public Vec4F(float[] fArr) {
        this(VuforiaJNI.new_Vec4F__SWIG_1(fArr), true);
    }

    public Vec4F(float f, float f2, float f3, float f4) {
        this(VuforiaJNI.new_Vec4F__SWIG_2(f, f2, f3, f4), true);
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Vec4F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Vec4F_data_get(this.swigCPtr, this);
    }

    public Vec4F(Vec4F vec4F) {
        this(VuforiaJNI.new_Vec4F__SWIG_3(getCPtr(vec4F), vec4F), true);
    }
}
