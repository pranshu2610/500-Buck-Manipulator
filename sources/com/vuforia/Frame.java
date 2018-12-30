package com.vuforia;

public class Frame implements Cloneable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Frame(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Frame frame) {
        return frame == null ? 0 : frame.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Frame(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public Frame clone() {
        return new Frame(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Frame) && ((Frame) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Frame() {
        this(VuforiaJNI.new_Frame__SWIG_0(), true);
    }

    public Frame(Frame frame) {
        this(VuforiaJNI.new_Frame__SWIG_1(getCPtr(frame), frame), true);
    }

    public double getTimeStamp() {
        return VuforiaJNI.Frame_getTimeStamp(this.swigCPtr, this);
    }

    public int getIndex() {
        return VuforiaJNI.Frame_getIndex(this.swigCPtr, this);
    }

    public long getNumImages() {
        return VuforiaJNI.Frame_getNumImages(this.swigCPtr, this);
    }

    public Image getImage(int i) {
        long Frame_getImage = VuforiaJNI.Frame_getImage(this.swigCPtr, this, i);
        return Frame_getImage == 0 ? null : new Image(Frame_getImage, false);
    }

    public ImageList getImages() {
        return new ImageList(VuforiaJNI.Frame_getImages(this.swigCPtr, this), true);
    }
}
