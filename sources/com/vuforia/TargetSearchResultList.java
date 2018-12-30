package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TargetSearchResultList implements Cloneable, Iterable<TargetSearchResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<TargetSearchResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = TargetSearchResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public TargetSearchResult next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return TargetSearchResultList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected TargetSearchResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetSearchResultList targetSearchResultList) {
        return targetSearchResultList == null ? 0 : targetSearchResultList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetSearchResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TargetSearchResultList clone() {
        return new TargetSearchResultList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TargetSearchResultList) && ((TargetSearchResultList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<TargetSearchResult> iterator() {
        return new ListIterator();
    }

    public TargetSearchResultList(TargetSearchResultList targetSearchResultList) {
        this(VuforiaJNI.new_TargetSearchResultList(getCPtr(targetSearchResultList), targetSearchResultList), true);
    }

    public TargetSearchResult at(int i) {
        long TargetSearchResultList_at = VuforiaJNI.TargetSearchResultList_at(this.swigCPtr, this, i);
        return TargetSearchResultList_at == 0 ? null : new TargetSearchResult(TargetSearchResultList_at, false);
    }

    public int size() {
        return VuforiaJNI.TargetSearchResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.TargetSearchResultList_empty(this.swigCPtr, this);
    }
}
