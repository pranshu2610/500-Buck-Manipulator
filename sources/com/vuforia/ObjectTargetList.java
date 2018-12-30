package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectTargetList implements Cloneable, Iterable<ObjectTarget> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class ListIterator implements Iterator<ObjectTarget> {
        private int cur = 0;
        private int end = 0;

        ListIterator() {
            this.end = ObjectTargetList.this.size();
        }

        public boolean hasNext() {
            return this.cur < this.end;
        }

        public ObjectTarget next() throws NoSuchElementException {
            if (this.cur < this.end) {
                int i = this.cur;
                this.cur++;
                return ObjectTargetList.this.at(i);
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected ObjectTargetList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTargetList objectTargetList) {
        return objectTargetList == null ? 0 : objectTargetList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ObjectTargetList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ObjectTargetList clone() {
        return new ObjectTargetList(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ObjectTargetList) && ((ObjectTargetList) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Iterator<ObjectTarget> iterator() {
        return new ListIterator();
    }

    public ObjectTargetList(ObjectTargetList objectTargetList) {
        this(VuforiaJNI.new_ObjectTargetList(getCPtr(objectTargetList), objectTargetList), true);
    }

    public ObjectTarget at(int i) {
        long ObjectTargetList_at = VuforiaJNI.ObjectTargetList_at(this.swigCPtr, this, i);
        if (ObjectTargetList_at == 0) {
            return null;
        }
        ObjectTarget objectTarget = new ObjectTarget(ObjectTargetList_at, false);
        if (objectTarget.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(ObjectTargetList_at, false);
        }
        if (objectTarget.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(ObjectTargetList_at, false);
        }
        return null;
    }

    public int size() {
        return VuforiaJNI.ObjectTargetList_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return VuforiaJNI.ObjectTargetList_empty(this.swigCPtr, this);
    }
}
