package com.vuforia;

public class Matrix44F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Matrix44F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Matrix44F matrix44F) {
        return matrix44F == null ? 0 : matrix44F.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Matrix44F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Matrix44F) && ((Matrix44F) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Matrix44F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Matrix44F_data_get(this.swigCPtr, this);
    }

    public Matrix44F() {
        this(VuforiaJNI.new_Matrix44F__SWIG_0(), true);
    }

    public Matrix44F(Matrix44F matrix44F) {
        this(VuforiaJNI.new_Matrix44F__SWIG_1(getCPtr(matrix44F), matrix44F), true);
    }
}
