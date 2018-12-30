package com.vuforia;

public class Matrix34F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Matrix34F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Matrix34F matrix34F) {
        return matrix34F == null ? 0 : matrix34F.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Matrix34F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Matrix34F) && ((Matrix34F) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public void setData(float[] fArr) {
        VuforiaJNI.Matrix34F_data_set(this.swigCPtr, this, fArr);
    }

    public float[] getData() {
        return VuforiaJNI.Matrix34F_data_get(this.swigCPtr, this);
    }

    public Matrix34F() {
        this(VuforiaJNI.new_Matrix34F__SWIG_0(), true);
    }

    public Matrix34F(Matrix34F matrix34F) {
        this(VuforiaJNI.new_Matrix34F__SWIG_1(getCPtr(matrix34F), matrix34F), true);
    }
}
