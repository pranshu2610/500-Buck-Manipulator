package com.vuforia;

public class HandheldTransformModel extends TransformModel {
    private long swigCPtr;

    protected HandheldTransformModel(long j, boolean z) {
        super(VuforiaJNI.HandheldTransformModel_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(HandheldTransformModel handheldTransformModel) {
        return handheldTransformModel == null ? 0 : handheldTransformModel.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HandheldTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HandheldTransformModel) && ((HandheldTransformModel) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public int getType() {
        return VuforiaJNI.HandheldTransformModel_getType(this.swigCPtr, this);
    }

    public HandheldTransformModel() {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_0(), true);
    }

    public HandheldTransformModel(HandheldTransformModel handheldTransformModel) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_1(getCPtr(handheldTransformModel), handheldTransformModel), true);
    }

    public HandheldTransformModel(Vec3F vec3F) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_2(Vec3F.getCPtr(vec3F), vec3F), true);
    }

    public boolean setPivotPoint(Vec3F vec3F) {
        return VuforiaJNI.HandheldTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HandheldTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}
