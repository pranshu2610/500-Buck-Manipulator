package com.vuforia;

public class NonCopyable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected NonCopyable(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NonCopyable nonCopyable) {
        return nonCopyable == null ? 0 : nonCopyable.swigCPtr;
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
        if ((obj instanceof NonCopyable) && ((NonCopyable) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }
}
