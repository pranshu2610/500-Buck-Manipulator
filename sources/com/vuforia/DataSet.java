package com.vuforia;

public class DataSet {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DataSet(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DataSet dataSet) {
        return dataSet == null ? 0 : dataSet.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DataSet(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DataSet) && ((DataSet) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static boolean exists(String str, int i) {
        return VuforiaJNI.DataSet_exists(str, i);
    }

    public boolean load(String str, int i) {
        return VuforiaJNI.DataSet_load(this.swigCPtr, this, str, i);
    }

    public int getNumTrackables() {
        return VuforiaJNI.DataSet_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int i) {
        long DataSet_getTrackable = VuforiaJNI.DataSet_getTrackable(this.swigCPtr, this, i);
        if (DataSet_getTrackable == 0) {
            return null;
        }
        Trackable trackable = new Trackable(DataSet_getTrackable, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(DataSet_getTrackable, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(DataSet_getTrackable, false);
        }
        return null;
    }

    public TrackableList getTrackables() {
        return new TrackableList(VuforiaJNI.DataSet_getTrackables(this.swigCPtr, this), true);
    }

    public Trackable createTrackable(TrackableSource trackableSource) {
        long DataSet_createTrackable = VuforiaJNI.DataSet_createTrackable(this.swigCPtr, this, TrackableSource.getCPtr(trackableSource), trackableSource);
        if (DataSet_createTrackable == 0) {
            return null;
        }
        Trackable trackable = new Trackable(DataSet_createTrackable, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(DataSet_createTrackable, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(DataSet_createTrackable, false);
        }
        return trackable.isOfType(DeviceTrackable.getClassType()) ? new DeviceTrackable(DataSet_createTrackable, false) : null;
    }

    public MultiTarget createMultiTarget(String str) {
        long DataSet_createMultiTarget = VuforiaJNI.DataSet_createMultiTarget(this.swigCPtr, this, str);
        return DataSet_createMultiTarget == 0 ? null : new MultiTarget(DataSet_createMultiTarget, false);
    }

    public boolean destroy(Trackable trackable) {
        return VuforiaJNI.DataSet_destroy(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean hasReachedTrackableLimit() {
        return VuforiaJNI.DataSet_hasReachedTrackableLimit(this.swigCPtr, this);
    }

    public boolean isActive() {
        return VuforiaJNI.DataSet_isActive(this.swigCPtr, this);
    }
}
