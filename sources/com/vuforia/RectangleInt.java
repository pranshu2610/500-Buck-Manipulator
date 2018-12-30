package com.vuforia;

public class RectangleInt extends Area {
    private long swigCPtr;

    protected RectangleInt(long j, boolean z) {
        super(VuforiaJNI.RectangleInt_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(RectangleInt rectangleInt) {
        return rectangleInt == null ? 0 : rectangleInt.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RectangleInt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof RectangleInt) && ((RectangleInt) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public RectangleInt() {
        this(VuforiaJNI.new_RectangleInt__SWIG_0(), true);
    }

    public RectangleInt(RectangleInt rectangleInt) {
        this(VuforiaJNI.new_RectangleInt__SWIG_1(getCPtr(rectangleInt), rectangleInt), true);
    }

    public RectangleInt(int i, int i2, int i3, int i4) {
        this(VuforiaJNI.new_RectangleInt__SWIG_2(i, i2, i3, i4), true);
    }

    public int getLeftTopX() {
        return VuforiaJNI.RectangleInt_getLeftTopX(this.swigCPtr, this);
    }

    public int getLeftTopY() {
        return VuforiaJNI.RectangleInt_getLeftTopY(this.swigCPtr, this);
    }

    public int getRightBottomX() {
        return VuforiaJNI.RectangleInt_getRightBottomX(this.swigCPtr, this);
    }

    public int getRightBottomY() {
        return VuforiaJNI.RectangleInt_getRightBottomY(this.swigCPtr, this);
    }

    public int getWidth() {
        return VuforiaJNI.RectangleInt_getWidth(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.RectangleInt_getHeight(this.swigCPtr, this);
    }

    public int getAreaSize() {
        return VuforiaJNI.RectangleInt_getAreaSize(this.swigCPtr, this);
    }

    public int getType() {
        return VuforiaJNI.RectangleInt_getType(this.swigCPtr, this);
    }
}
