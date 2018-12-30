package com.vuforia;

public class TrackerManager {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TrackerManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackerManager trackerManager) {
        return trackerManager == null ? 0 : trackerManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackerManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TrackerManager) && ((TrackerManager) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static TrackerManager getInstance() {
        if (Vuforia.wasInitializedJava()) {
            return new TrackerManager(VuforiaJNI.TrackerManager_getInstance(), false);
        }
        throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
    }

    public Tracker initTracker(Type type) {
        long TrackerManager_initTracker = VuforiaJNI.TrackerManager_initTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (TrackerManager_initTracker == 0) {
            return null;
        }
        Tracker tracker = new Tracker(TrackerManager_initTracker, false);
        if (tracker.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(TrackerManager_initTracker, false);
        }
        if (tracker.isOfType(SmartTerrain.getClassType())) {
            return new SmartTerrain(TrackerManager_initTracker, false);
        }
        if (tracker.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(TrackerManager_initTracker, false);
        }
        return tracker.isOfType(PositionalDeviceTracker.getClassType()) ? new PositionalDeviceTracker(TrackerManager_initTracker, false) : null;
    }

    public Tracker getTracker(Type type) {
        long TrackerManager_getTracker = VuforiaJNI.TrackerManager_getTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (TrackerManager_getTracker == 0) {
            return null;
        }
        Tracker tracker = new Tracker(TrackerManager_getTracker, false);
        if (tracker.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(TrackerManager_getTracker, false);
        }
        if (tracker.isOfType(SmartTerrain.getClassType())) {
            return new SmartTerrain(TrackerManager_getTracker, false);
        }
        if (tracker.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(TrackerManager_getTracker, false);
        }
        return tracker.isOfType(PositionalDeviceTracker.getClassType()) ? new PositionalDeviceTracker(TrackerManager_getTracker, false) : null;
    }

    public boolean deinitTracker(Type type) {
        return VuforiaJNI.TrackerManager_deinitTracker(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public StateUpdater getStateUpdater() {
        return new StateUpdater(VuforiaJNI.TrackerManager_getStateUpdater(this.swigCPtr, this), false);
    }
}
