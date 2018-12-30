package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VirtualButtonResultList implements Cloneable, Iterable<VirtualButtonResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<VirtualButtonResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = VirtualButtonResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public VirtualButtonResult next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return VirtualButtonResultList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected VirtualButtonResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButtonResultList virtualButtonResultList) {
        return virtualButtonResultList == null ? 0 : virtualButtonResultList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VirtualButtonResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public VirtualButtonResultList clone() {
        return new VirtualButtonResultList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VirtualButtonResultList) && ((VirtualButtonResultList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<VirtualButtonResult> iterator() {
        return new ListIterator();
    }

    public VirtualButtonResultList(VirtualButtonResultList virtualButtonResultList) {
        this(VuforiaJNI.new_VirtualButtonResultList(getCPtr(virtualButtonResultList), virtualButtonResultList), true);
    }

    public VirtualButtonResult at(int i) {
        long VirtualButtonResultList_at = VuforiaJNI.VirtualButtonResultList_at(this.swigCPtr, this, i);
        return VirtualButtonResultList_at == 0 ? null : new VirtualButtonResult(VirtualButtonResultList_at, false);
    }

    public int size() {
        return VuforiaJNI.VirtualButtonResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.VirtualButtonResultList_empty(this.swigCPtr, this);
    }
}
