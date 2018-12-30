package com.vuforia;

public class ObjectTracker extends Tracker {
    private long swigCPtr;

    protected ObjectTracker(long j, boolean z) {
        super(VuforiaJNI.ObjectTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTracker objectTracker) {
        return objectTracker == null ? 0 : objectTracker.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ObjectTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ObjectTracker) && ((ObjectTracker) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTracker_getClassType(), true);
    }

    public DataSet createDataSet() {
        long ObjectTracker_createDataSet = VuforiaJNI.ObjectTracker_createDataSet(this.swigCPtr, this);
        return ObjectTracker_createDataSet == 0 ? null : new DataSet(ObjectTracker_createDataSet, false);
    }

    public boolean destroyDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_destroyDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean activateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_activateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean deactivateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_deactivateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public DataSet getActiveDataSet(int i) {
        long ObjectTracker_getActiveDataSet = VuforiaJNI.ObjectTracker_getActiveDataSet(this.swigCPtr, this, i);
        return ObjectTracker_getActiveDataSet == 0 ? null : new DataSet(ObjectTracker_getActiveDataSet, false);
    }

    public int getActiveDataSetCount() {
        return VuforiaJNI.ObjectTracker_getActiveDataSetCount(this.swigCPtr, this);
    }

    public DataSetList getActiveDataSets() {
        return new DataSetList(VuforiaJNI.ObjectTracker_getActiveDataSets(this.swigCPtr, this), true);
    }

    public ImageTargetBuilder getImageTargetBuilder() {
        long ObjectTracker_getImageTargetBuilder = VuforiaJNI.ObjectTracker_getImageTargetBuilder(this.swigCPtr, this);
        return ObjectTracker_getImageTargetBuilder == 0 ? null : new ImageTargetBuilder(ObjectTracker_getImageTargetBuilder, false);
    }

    public TargetFinder getTargetFinder() {
        long ObjectTracker_getTargetFinder = VuforiaJNI.ObjectTracker_getTargetFinder(this.swigCPtr, this);
        return ObjectTracker_getTargetFinder == 0 ? null : new TargetFinder(ObjectTracker_getTargetFinder, false);
    }
}
