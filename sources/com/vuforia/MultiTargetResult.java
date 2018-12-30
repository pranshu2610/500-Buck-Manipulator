package com.vuforia;

public class MultiTargetResult extends ObjectTargetResult {
    private long swigCPtr;

    protected MultiTargetResult(long j, boolean z) {
        super(VuforiaJNI.MultiTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(MultiTargetResult multiTargetResult) {
        return multiTargetResult == null ? 0 : multiTargetResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_MultiTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MultiTargetResult) && ((MultiTargetResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        return new MultiTarget(VuforiaJNI.MultiTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getNumPartResults() {
        return VuforiaJNI.MultiTargetResult_getNumPartResults(this.swigCPtr, this);
    }

    public TrackableResult getPartResult(int i) {
        long MultiTargetResult_getPartResult__SWIG_0 = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_0(this.swigCPtr, this, i);
        if (MultiTargetResult_getPartResult__SWIG_0 == 0) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(MultiTargetResult_getPartResult__SWIG_0, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(getClassType())) {
            return new MultiTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(MultiTargetResult_getPartResult__SWIG_0, false);
        }
        return null;
    }

    public TrackableResult getPartResult(String str) {
        long MultiTargetResult_getPartResult__SWIG_1 = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_1(this.swigCPtr, this, str);
        if (MultiTargetResult_getPartResult__SWIG_1 == 0) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(MultiTargetResult_getPartResult__SWIG_1, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(getClassType())) {
            return new MultiTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(MultiTargetResult_getPartResult__SWIG_1, false);
        }
        return null;
    }

    public TrackableResultList getPartResults() {
        return new TrackableResultList(VuforiaJNI.MultiTargetResult_getPartResults(this.swigCPtr, this), true);
    }
}
