package com.vuforia;

public class GLTextureData extends TextureData {
    private long swigCPtr;

    protected GLTextureData(long j, boolean z) {
        super(VuforiaJNI.GLTextureData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(GLTextureData gLTextureData) {
        return gLTextureData == null ? 0 : gLTextureData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GLTextureData(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GLTextureData) && ((GLTextureData) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public GLTextureData(int i) {
        this(VuforiaJNI.new_GLTextureData__SWIG_0(i), true);
    }

    public GLTextureData() {
        this(VuforiaJNI.new_GLTextureData__SWIG_1(), true);
    }

    public void setVideoBackgroundTextureID(int i) {
        VuforiaJNI.GLTextureData_VideoBackgroundTextureID_set(this.swigCPtr, this, i);
    }

    public int getVideoBackgroundTextureID() {
        return VuforiaJNI.GLTextureData_VideoBackgroundTextureID_get(this.swigCPtr, this);
    }
}
