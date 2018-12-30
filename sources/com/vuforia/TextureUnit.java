package com.vuforia;

public class TextureUnit {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TextureUnit(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TextureUnit textureUnit) {
        return textureUnit == null ? 0 : textureUnit.swigCPtr;
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
        if ((obj instanceof TextureUnit) && ((TextureUnit) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public int type() {
        return VuforiaJNI.TextureUnit_type(this.swigCPtr, this);
    }
}
