package com.vuforia;

public class VirtualButtonResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VirtualButtonResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButtonResult virtualButtonResult) {
        return virtualButtonResult == null ? 0 : virtualButtonResult.swigCPtr;
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
        if ((obj instanceof VirtualButtonResult) && ((VirtualButtonResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public VirtualButton getVirtualButton() {
        return new VirtualButton(VuforiaJNI.VirtualButtonResult_getVirtualButton(this.swigCPtr, this), false);
    }

    public boolean isPressed() {
        return VuforiaJNI.VirtualButtonResult_isPressed(this.swigCPtr, this);
    }
}
