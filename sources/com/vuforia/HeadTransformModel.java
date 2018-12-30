package com.vuforia;

public class HeadTransformModel extends TransformModel {
    private long swigCPtr;

    protected HeadTransformModel(long j, boolean z) {
        super(VuforiaJNI.HeadTransformModel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(HeadTransformModel headTransformModel) {
        return headTransformModel == null ? 0 : headTransformModel.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HeadTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HeadTransformModel) && ((HeadTransformModel) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public int getType() {
        return VuforiaJNI.HeadTransformModel_getType(this.swigCPtr, this);
    }

    public HeadTransformModel() {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_0(), true);
    }

    public HeadTransformModel(HeadTransformModel headTransformModel) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_1(getCPtr(headTransformModel), headTransformModel), true);
    }

    public HeadTransformModel(Vec3F vec3F) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_2(Vec3F.getCPtr(vec3F), vec3F), true);
    }

    public boolean setPivotPoint(Vec3F vec3F) {
        return VuforiaJNI.HeadTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HeadTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}
