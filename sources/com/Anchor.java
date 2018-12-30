package com.vuforia;

public class Anchor extends Trackable {
    private long swigCPtr;

    protected Anchor(long j, boolean z) {
        super(VuforiaJNI.Anchor_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(Anchor anchor) {
        return anchor == null ? 0 : anchor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Anchor(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Anchor) && ((Anchor) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Anchor_getClassType(), true);
    }
}
