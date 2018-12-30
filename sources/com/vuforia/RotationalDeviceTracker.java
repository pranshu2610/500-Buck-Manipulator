package com.vuforia;

public class RotationalDeviceTracker extends DeviceTracker {
    private long swigCPtr;

    protected RotationalDeviceTracker(long j, boolean z) {
        super(VuforiaJNI.RotationalDeviceTracker_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(RotationalDeviceTracker rotationalDeviceTracker) {
        return rotationalDeviceTracker == null ? 0 : rotationalDeviceTracker.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RotationalDeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof RotationalDeviceTracker) && ((RotationalDeviceTracker) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.RotationalDeviceTracker_getClassType(), true);
    }

    public boolean recenter() {
        return VuforiaJNI.RotationalDeviceTracker_recenter(this.swigCPtr, this);
    }

    public boolean setPosePrediction(boolean z) {
        return VuforiaJNI.RotationalDeviceTracker_setPosePrediction(this.swigCPtr, this, z);
    }

    public boolean getPosePrediction() {
        return VuforiaJNI.RotationalDeviceTracker_getPosePrediction(this.swigCPtr, this);
    }

    public boolean setModelCorrection(TransformModel transformModel) {
        return VuforiaJNI.RotationalDeviceTracker_setModelCorrection(this.swigCPtr, this, TransformModel.getCPtr(transformModel), transformModel);
    }

    public TransformModel getModelCorrection() {
        long RotationalDeviceTracker_getModelCorrection = VuforiaJNI.RotationalDeviceTracker_getModelCorrection(this.swigCPtr, this);
        if (RotationalDeviceTracker_getModelCorrection == 0) {
            return null;
        }
        switch (new TransformModel(RotationalDeviceTracker_getModelCorrection, false).getType()) {
            case 0:
                return new HeadTransformModel(RotationalDeviceTracker_getModelCorrection, false);
            case 1:
                return new HandheldTransformModel(RotationalDeviceTracker_getModelCorrection, false);
            default:
                return null;
        }
    }

    public HeadTransformModel getDefaultHeadModel() {
        long RotationalDeviceTracker_getDefaultHeadModel = VuforiaJNI.RotationalDeviceTracker_getDefaultHeadModel(this.swigCPtr, this);
        return RotationalDeviceTracker_getDefaultHeadModel == 0 ? null : new HeadTransformModel(RotationalDeviceTracker_getDefaultHeadModel, false);
    }

    public HandheldTransformModel getDefaultHandheldModel() {
        long RotationalDeviceTracker_getDefaultHandheldModel = VuforiaJNI.RotationalDeviceTracker_getDefaultHandheldModel(this.swigCPtr, this);
        return RotationalDeviceTracker_getDefaultHandheldModel == 0 ? null : new HandheldTransformModel(RotationalDeviceTracker_getDefaultHandheldModel, false);
    }
}
