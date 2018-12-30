package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TrackableResultList implements Cloneable, Iterable<TrackableResult> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<TrackableResult> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = TrackableResultList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public TrackableResult next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return TrackableResultList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected TrackableResultList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackableResultList trackableResultList) {
        return trackableResultList == null ? 0 : trackableResultList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableResultList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TrackableResultList clone() {
        return new TrackableResultList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TrackableResultList) && ((TrackableResultList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<TrackableResult> iterator() {
        return new ListIterator();
    }

    public TrackableResultList(TrackableResultList trackableResultList) {
        this(VuforiaJNI.new_TrackableResultList(getCPtr(trackableResultList), trackableResultList), true);
    }

    public TrackableResult at(int i) {
        long TrackableResultList_at = VuforiaJNI.TrackableResultList_at(this.swigCPtr, this, i);
        if (TrackableResultList_at == 0) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(TrackableResultList_at, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(MultiTargetResult.getClassType())) {
            return new MultiTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(TrackableResultList_at, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(TrackableResultList_at, false);
        }
        return null;
    }

    public int size() {
        return VuforiaJNI.TrackableResultList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.TrackableResultList_empty(this.swigCPtr, this);
    }
}
