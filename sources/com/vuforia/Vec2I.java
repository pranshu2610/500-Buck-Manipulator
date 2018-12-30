package com.vuforia;

public class Vec2I {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec2I(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec2I vec2I) {
        return vec2I == null ? 0 : vec2I.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2I(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Vec2I) && ((Vec2I) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec2I() {
        this(VuforiaJNI.new_Vec2I__SWIG_0(), true);
    }

    public Vec2I(int[] iArr) {
        this(VuforiaJNI.new_Vec2I__SWIG_1(iArr), true);
    }

    public Vec2I(int i, int i2) {
        this(VuforiaJNI.new_Vec2I__SWIG_2(i, i2), true);
    }

    public void setData(int[] iArr) {
        VuforiaJNI.Vec2I_data_set(this.swigCPtr, this, iArr);
    }

    public int[] getData() {
        return VuforiaJNI.Vec2I_data_get(this.swigCPtr, this);
    }

    public Vec2I(Vec2I vec2I) {
        this(VuforiaJNI.new_Vec2I__SWIG_3(getCPtr(vec2I), vec2I), true);
    }
}
