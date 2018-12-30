package com.vuforia;

public class RendererHelper {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected RendererHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RendererHelper rendererHelper) {
        return rendererHelper == null ? 0 : rendererHelper.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RendererHelper(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof RendererHelper) && ((RendererHelper) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static boolean drawVideoBackground() {
        return VuforiaJNI.RendererHelper_drawVideoBackground();
    }

    public RendererHelper() {
        this(VuforiaJNI.new_RendererHelper(), true);
    }
}
