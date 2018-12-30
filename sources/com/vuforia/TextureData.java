package com.vuforia;

public class TextureData {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TextureData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TextureData textureData) {
        return textureData == null ? 0 : textureData.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TextureData) && ((TextureData) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public int type() {
        return VuforiaJNI.TextureData_type(this.swigCPtr, this);
    }
}
