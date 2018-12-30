package com.vuforia;

public class State implements Cloneable {
    private Frame mFrame;
    private Object mFrameMutex;
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected State(long j, boolean z) {
        this.mFrame = null;
        this.mFrameMutex = new Object();
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(State state) {
        return state == null ? 0 : state.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_State(this.swigCPtr);
            }
            synchronized (this.mFrameMutex) {
                if (this.mFrame != null) {
                    this.mFrame.delete();
                    this.mFrame = null;
                }
            }
            this.swigCPtr = 0;
        }
    }

    public State clone() {
        return new State(this);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof State) && ((State) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public State() {
        this(VuforiaJNI.new_State__SWIG_0(), true);
    }

    public State(State state) {
        this(VuforiaJNI.new_State__SWIG_1(getCPtr(state), state), true);
    }

    public Frame getFrame() {
        synchronized (this.mFrameMutex) {
            if (this.mFrame == null) {
                this.mFrame = new Frame(VuforiaJNI.State_getFrame(this.swigCPtr, this), true);
            }
        }
        return this.mFrame;
    }

    public CameraCalibration getCameraCalibration() {
        long State_getCameraCalibration = VuforiaJNI.State_getCameraCalibration(this.swigCPtr, this);
        return State_getCameraCalibration == 0 ? null : new CameraCalibration(State_getCameraCalibration, false);
    }

    public Illumination getIllumination() {
        long State_getIllumination = VuforiaJNI.State_getIllumination(this.swigCPtr, this);
        return State_getIllumination == 0 ? null : new Illumination(State_getIllumination, false);
    }

    public DeviceTrackableResult getDeviceTrackableResult() {
        long State_getDeviceTrackableResult = VuforiaJNI.State_getDeviceTrackableResult(this.swigCPtr, this);
        return State_getDeviceTrackableResult == 0 ? null : new DeviceTrackableResult(State_getDeviceTrackableResult, false);
    }

    public int getNumTrackables() {
        return VuforiaJNI.State_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int i) {
        long State_getTrackable = VuforiaJNI.State_getTrackable(this.swigCPtr, this, i);
        if (State_getTrackable == 0) {
            return null;
        }
        Trackable trackable = new Trackable(State_getTrackable, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(State_getTrackable, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(State_getTrackable, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(State_getTrackable, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(State_getTrackable, false);
        }
        return null;
    }

    public int getNumTrackableResults() {
        return VuforiaJNI.State_getNumTrackableResults(this.swigCPtr, this);
    }

    public TrackableResult getTrackableResult(int i) {
        long State_getTrackableResult = VuforiaJNI.State_getTrackableResult(this.swigCPtr, this, i);
        if (State_getTrackableResult == 0) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(State_getTrackableResult, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(MultiTargetResult.getClassType())) {
            return new MultiTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(State_getTrackableResult, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(State_getTrackableResult, false);
        }
        return null;
    }

    public TrackableResultList getTrackableResults() {
        return new TrackableResultList(VuforiaJNI.State_getTrackableResults(this.swigCPtr, this), true);
    }
}
