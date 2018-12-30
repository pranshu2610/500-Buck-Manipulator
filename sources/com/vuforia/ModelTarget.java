package com.vuforia;

public class ModelTarget extends ObjectTarget {
    private long swigCPtr;

    protected ModelTarget(long j, boolean z) {
        super(VuforiaJNI.ModelTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ModelTarget modelTarget) {
        return modelTarget == null ? 0 : modelTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ModelTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ModelTarget) && ((ModelTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ModelTarget_getClassType(), true);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.ModelTarget_getUniqueTargetId(this.swigCPtr, this);
    }

    public Vec3F getSize() {
        return new Vec3F(VuforiaJNI.ModelTarget_getSize(this.swigCPtr, this), true);
    }

    public boolean setSize(Vec3F vec3F) {
        return VuforiaJNI.ModelTarget_setSize(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Obb3D getBoundingBox() {
        return new Obb3D(VuforiaJNI.ModelTarget_getBoundingBox(this.swigCPtr, this), false);
    }

    public int getNumGuideViews() {
        return VuforiaJNI.ModelTarget_getNumGuideViews(this.swigCPtr, this);
    }

    public GuideView getGuideView(int i) {
        long ModelTarget_getGuideView = VuforiaJNI.ModelTarget_getGuideView(this.swigCPtr, this, i);
        return ModelTarget_getGuideView == 0 ? null : new GuideView(ModelTarget_getGuideView, false);
    }

    public GuideViewList getGuideViews() {
        return new GuideViewList(VuforiaJNI.ModelTarget_getGuideViews(this.swigCPtr, this), true);
    }
}
