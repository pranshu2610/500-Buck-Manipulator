package com.vuforia;

public class VideoMode {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoMode(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoMode videoMode) {
        return videoMode == null ? 0 : videoMode.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoMode(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VideoMode) && ((VideoMode) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public VideoMode() {
        this(VuforiaJNI.new_VideoMode__SWIG_0(), true);
    }

    public int getWidth() {
        return VuforiaJNI.VideoMode_Width_get(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.VideoMode_Height_get(this.swigCPtr, this);
    }

    public float getFramerate() {
        return VuforiaJNI.VideoMode_Framerate_get(this.swigCPtr, this);
    }

    public VideoMode(VideoMode videoMode) {
        this(VuforiaJNI.new_VideoMode__SWIG_1(getCPtr(videoMode), videoMode), true);
    }
}
