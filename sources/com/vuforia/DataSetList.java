package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataSetList implements Cloneable, Iterable<DataSet> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<DataSet> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = DataSetList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public DataSet next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return DataSetList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected DataSetList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DataSetList dataSetList) {
        return dataSetList == null ? 0 : dataSetList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DataSetList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DataSetList clone() {
        return new DataSetList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DataSetList) && ((DataSetList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<DataSet> iterator() {
        return new ListIterator();
    }

    public DataSetList(DataSetList dataSetList) {
        this(VuforiaJNI.new_DataSetList(getCPtr(dataSetList), dataSetList), true);
    }

    public DataSet at(int i) {
        long DataSetList_at = VuforiaJNI.DataSetList_at(this.swigCPtr, this, i);
        return DataSetList_at == 0 ? null : new DataSet(DataSetList_at, false);
    }

    public int size() {
        return VuforiaJNI.DataSetList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.DataSetList_empty(this.swigCPtr, this);
    }
}
