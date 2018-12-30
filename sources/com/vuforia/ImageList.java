package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImageList implements Cloneable, Iterable<Image> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<Image> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = ImageList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public Image next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return ImageList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected ImageList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageList imageList) {
        return imageList == null ? 0 : imageList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ImageList clone() {
        return new ImageList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ImageList) && ((ImageList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<Image> iterator() {
        return new ListIterator();
    }

    public ImageList(ImageList imageList) {
        this(VuforiaJNI.new_ImageList(getCPtr(imageList), imageList), true);
    }

    public Image at(int i) {
        long ImageList_at = VuforiaJNI.ImageList_at(this.swigCPtr, this, i);
        return ImageList_at == 0 ? null : new Image(ImageList_at, false);
    }

    public int size() {
        return VuforiaJNI.ImageList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.ImageList_empty(this.swigCPtr, this);
    }
}
