package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VirtualButtonList implements Cloneable, Iterable<VirtualButton> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<VirtualButton> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = VirtualButtonList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public VirtualButton next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return VirtualButtonList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected VirtualButtonList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButtonList virtualButtonList) {
        return virtualButtonList == null ? 0 : virtualButtonList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VirtualButtonList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public VirtualButtonList clone() {
        return new VirtualButtonList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VirtualButtonList) && ((VirtualButtonList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<VirtualButton> iterator() {
        return new ListIterator();
    }

    public VirtualButtonList(VirtualButtonList virtualButtonList) {
        this(VuforiaJNI.new_VirtualButtonList(getCPtr(virtualButtonList), virtualButtonList), true);
    }

    public VirtualButton at(int i) {
        long VirtualButtonList_at = VuforiaJNI.VirtualButtonList_at(this.swigCPtr, this, i);
        return VirtualButtonList_at == 0 ? null : new VirtualButton(VirtualButtonList_at, false);
    }

    public int size() {
        return VuforiaJNI.VirtualButtonList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.VirtualButtonList_empty(this.swigCPtr, this);
    }
}
