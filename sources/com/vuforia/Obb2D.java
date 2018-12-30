package com.vuforia;

public class Obb2D {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Obb2D(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Obb2D obb2D) {
        return obb2D == null ? 0 : obb2D.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb2D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Obb2D) && ((Obb2D) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Obb2D() {
        this(VuforiaJNI.new_Obb2D__SWIG_0(), true);
    }

    public Obb2D(Obb2D obb2D) {
        this(VuforiaJNI.new_Obb2D__SWIG_1(getCPtr(obb2D), obb2D), true);
    }

    public Obb2D(Vec2F vec2F, Vec2F vec2F2, float f) {
        this(VuforiaJNI.new_Obb2D__SWIG_2(Vec2F.getCPtr(vec2F), vec2F, Vec2F.getCPtr(vec2F2), vec2F2, f), true);
    }

    public Vec2F getCenter() {
        return new Vec2F(VuforiaJNI.Obb2D_getCenter(this.swigCPtr, this), false);
    }

    public Vec2F getHalfExtents() {
        return new Vec2F(VuforiaJNI.Obb2D_getHalfExtents(this.swigCPtr, this), false);
    }

    public float getRotation() {
        return VuforiaJNI.Obb2D_getRotation(this.swigCPtr, this);
    }
}
