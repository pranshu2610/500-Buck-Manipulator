package com.vuforia;

public class Obb3D {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Obb3D(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Obb3D obb3D) {
        return obb3D == null ? 0 : obb3D.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb3D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Obb3D) && ((Obb3D) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Obb3D() {
        this(VuforiaJNI.new_Obb3D__SWIG_0(), true);
    }

    public Obb3D(Obb3D obb3D) {
        this(VuforiaJNI.new_Obb3D__SWIG_1(getCPtr(obb3D), obb3D), true);
    }

    public Obb3D(Vec3F vec3F, Vec3F vec3F2, float f) {
        this(VuforiaJNI.new_Obb3D__SWIG_2(Vec3F.getCPtr(vec3F), vec3F, Vec3F.getCPtr(vec3F2), vec3F2, f), true);
    }

    public Vec3F getCenter() {
        return new Vec3F(VuforiaJNI.Obb3D_getCenter(this.swigCPtr, this), false);
    }

    public Vec3F getHalfExtents() {
        return new Vec3F(VuforiaJNI.Obb3D_getHalfExtents(this.swigCPtr, this), false);
    }

    public float getRotationZ() {
        return VuforiaJNI.Obb3D_getRotationZ(this.swigCPtr, this);
    }
}
