package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GuideViewList implements Cloneable, Iterable<GuideView> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<GuideView> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = GuideViewList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public GuideView next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return GuideViewList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected GuideViewList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GuideViewList guideViewList) {
        return guideViewList == null ? 0 : guideViewList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GuideViewList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public GuideViewList clone() {
        return new GuideViewList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GuideViewList) && ((GuideViewList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<GuideView> iterator() {
        return new ListIterator();
    }

    public GuideViewList(GuideViewList guideViewList) {
        this(VuforiaJNI.new_GuideViewList(getCPtr(guideViewList), guideViewList), true);
    }

    public GuideView at(int i) {
        long GuideViewList_at = VuforiaJNI.GuideViewList_at(this.swigCPtr, this, i);
        return GuideViewList_at == 0 ? null : new GuideView(GuideViewList_at, false);
    }

    public int size() {
        return VuforiaJNI.GuideViewList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.GuideViewList_empty(this.swigCPtr, this);
    }
}
