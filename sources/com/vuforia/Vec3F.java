package com.vuforia;

public class Vec3F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec3F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Vec3F vec3F) {
        return vec3F == null ? 0 : vec3F.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec3F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Vec3F) && ((Vec3F) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec3F() {
        this(VuforiaJNI.new_Vec3F__SWIG_0(), true);
    }

    public Vec3F(float[] fArr) {
        this(VuforiaJNI.new_Vec3F__SWIG_1(fArr), true);
    }

    public Vec3F(float f, float f2, float f3) {
        this(VuforiaJNI.new_Vec3F__SWIG_2(f, f2, f3), true);
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Vec3F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Vec3F_data_get(this.swigCPtr, this);
    }

    public Vec3F(Vec3F vec3F) {
        this(VuforiaJNI.new_Vec3F__SWIG_3(getCPtr(vec3F), vec3F), true);
    }
}
