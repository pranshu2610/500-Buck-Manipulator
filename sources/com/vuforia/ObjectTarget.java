package com.vuforia;

public class ObjectTarget extends Trackable {
    private long swigCPtr;

    protected ObjectTarget(long j, boolean z) {
        super(VuforiaJNI.ObjectTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTarget objectTarget) {
        return objectTarget == null ? 0 : objectTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ObjectTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ObjectTarget) && ((ObjectTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTarget_getClassType(), true);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.ObjectTarget_getUniqueTargetId(this.swigCPtr, this);
    }

    public Vec3F getSize() {
        return new Vec3F(VuforiaJNI.ObjectTarget_getSize(this.swigCPtr, this), true);
    }

    public boolean setSize(Vec3F vec3F) {
        return VuforiaJNI.ObjectTarget_setSize(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }
}
