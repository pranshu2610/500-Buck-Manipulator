package com.vuforia;

public class Rectangle extends Area {
    private long swigCPtr;

    protected Rectangle(long j, boolean z) {
        super(VuforiaJNI.Rectangle_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(Rectangle rectangle) {
        return rectangle == null ? 0 : rectangle.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Rectangle(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Rectangle) && ((Rectangle) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Rectangle() {
        this(VuforiaJNI.new_Rectangle__SWIG_0(), true);
    }

    public Rectangle(Rectangle rectangle) {
        this(VuforiaJNI.new_Rectangle__SWIG_1(getCPtr(rectangle), rectangle), true);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this(VuforiaJNI.new_Rectangle__SWIG_2(f, f2, f3, f4), true);
    }

    public float getLeftTopX() {
        return VuforiaJNI.Rectangle_getLeftTopX(this.swigCPtr, this);
    }

    public float getLeftTopY() {
        return VuforiaJNI.Rectangle_getLeftTopY(this.swigCPtr, this);
    }

    public float getRightBottomX() {
        return VuforiaJNI.Rectangle_getRightBottomX(this.swigCPtr, this);
    }

    public float getRightBottomY() {
        return VuforiaJNI.Rectangle_getRightBottomY(this.swigCPtr, this);
    }

    public float getWidth() {
        return VuforiaJNI.Rectangle_getWidth(this.swigCPtr, this);
    }

    public float getHeight() {
        return VuforiaJNI.Rectangle_getHeight(this.swigCPtr, this);
    }

    public float getAreaSize() {
        return VuforiaJNI.Rectangle_getAreaSize(this.swigCPtr, this);
    }

    public int getType() {
        return VuforiaJNI.Rectangle_getType(this.swigCPtr, this);
    }
}
