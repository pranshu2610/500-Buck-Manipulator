package com.vuforia;

public class Box3D {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Box3D(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Box3D box3D) {
        return box3D == null ? 0 : box3D.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Box3D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Box3D) && ((Box3D) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Box3D() {
        this(VuforiaJNI.new_Box3D__SWIG_0(), true);
    }

    public Box3D(Box3D box3D) {
        this(VuforiaJNI.new_Box3D__SWIG_1(getCPtr(box3D), box3D), true);
    }

    public Box3D(Vec3F vec3F, Vec3F vec3F2) {
        this(VuforiaJNI.new_Box3D__SWIG_2(Vec3F.getCPtr(vec3F), vec3F, Vec3F.getCPtr(vec3F2), vec3F2), true);
    }

    public Vec3F getMinimumPosition() {
        return new Vec3F(VuforiaJNI.Box3D_getMinimumPosition(this.swigCPtr, this), false);
    }

    public Vec3F getMaximumPosition() {
        return new Vec3F(VuforiaJNI.Box3D_getMaximumPosition(this.swigCPtr, this), false);
    }
}
