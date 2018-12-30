package com.vuforia;

public class VuMarkTarget extends ObjectTarget {
    private long swigCPtr;

    protected VuMarkTarget(long j, boolean z) {
        super(VuforiaJNI.VuMarkTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(VuMarkTarget vuMarkTarget) {
        return vuMarkTarget == null ? 0 : vuMarkTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VuMarkTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VuMarkTarget) && ((VuMarkTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTarget_getClassType(), true);
    }

    public VuMarkTemplate getTemplate() {
        return new VuMarkTemplate(VuforiaJNI.VuMarkTarget_getTemplate(this.swigCPtr, this), false);
    }

    public InstanceId getInstanceId() {
        return new InstanceId(VuforiaJNI.VuMarkTarget_getInstanceId(this.swigCPtr, this), false);
    }

    public Image getInstanceImage() {
        return new Image(VuforiaJNI.VuMarkTarget_getInstanceImage(this.swigCPtr, this), false);
    }
}
