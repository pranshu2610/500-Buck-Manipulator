package com.vuforia;

public class Vec2F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec2F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec2F vec2F) {
        return vec2F == null ? 0 : vec2F.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Vec2F) && ((Vec2F) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec2F() {
        this(VuforiaJNI.new_Vec2F__SWIG_0(), true);
    }

    public Vec2F(float[] fArr) {
        this(VuforiaJNI.new_Vec2F__SWIG_1(fArr), true);
    }

    public Vec2F(float f, float f2) {
        this(VuforiaJNI.new_Vec2F__SWIG_2(f, f2), true);
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Vec2F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Vec2F_data_get(this.swigCPtr, this);
    }

    public Vec2F(Vec2F vec2F) {
        this(VuforiaJNI.new_Vec2F__SWIG_3(getCPtr(vec2F), vec2F), true);
    }
}
