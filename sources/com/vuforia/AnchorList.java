package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AnchorList implements Cloneable, Iterable<Anchor> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<Anchor> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = AnchorList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public Anchor next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return AnchorList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected AnchorList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AnchorList anchorList) {
        return anchorList == null ? 0 : anchorList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_AnchorList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public AnchorList clone() {
        return new AnchorList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof AnchorList) && ((AnchorList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<Anchor> iterator() {
        return new ListIterator();
    }

    public AnchorList(AnchorList anchorList) {
        this(VuforiaJNI.new_AnchorList(getCPtr(anchorList), anchorList), true);
    }

    public Anchor at(int i) {
        long AnchorList_at = VuforiaJNI.AnchorList_at(this.swigCPtr, this, i);
        return AnchorList_at == 0 ? null : new Anchor(AnchorList_at, false);
    }

    public int size() {
        return VuforiaJNI.AnchorList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.AnchorList_empty(this.swigCPtr, this);
    }
}
