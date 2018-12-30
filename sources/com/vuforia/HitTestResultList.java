package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HitTestResultList implements Cloneable, Iterable<HitTestResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<HitTestResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = HitTestResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public HitTestResult next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return HitTestResultList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected HitTestResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(HitTestResultList hitTestResultList) {
        return hitTestResultList == null ? 0 : hitTestResultList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HitTestResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public HitTestResultList clone() {
        return new HitTestResultList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HitTestResultList) && ((HitTestResultList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<HitTestResult> iterator() {
        return new ListIterator();
    }

    public HitTestResultList(HitTestResultList hitTestResultList) {
        this(VuforiaJNI.new_HitTestResultList(getCPtr(hitTestResultList), hitTestResultList), true);
    }

    public HitTestResult at(int i) {
        long HitTestResultList_at = VuforiaJNI.HitTestResultList_at(this.swigCPtr, this, i);
        return HitTestResultList_at == 0 ? null : new HitTestResult(HitTestResultList_at, false);
    }

    public int size() {
        return VuforiaJNI.HitTestResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.HitTestResultList_empty(this.swigCPtr, this);
    }
}
