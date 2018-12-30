package com.vuforia;

public class TrackableResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class STATUS {
        public static final int DETECTED = 2;
        public static final int EXTENDED_TRACKED = 4;
        public static final int LIMITED = 1;
        public static final int NO_POSE = 0;
        public static final int TRACKED = 3;

        private STATUS() {
        }
    }

    public static final class STATUS_INFO {
        public static final int EXCESSIVE_MOTION = 3;
        public static final int INITIALIZING = 2;
        public static final int INSUFFICIENT_FEATURES = 4;
        public static final int NORMAL = 0;
        public static final int UNKNOWN = 1;
    }

    protected TrackableResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrackableResult trackableResult) {
        return trackableResult == null ? 0 : trackableResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TrackableResult) && ((TrackableResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.TrackableResult_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.TrackableResult_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.TrackableResult_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public double getTimeStamp() {
        return VuforiaJNI.TrackableResult_getTimeStamp(this.swigCPtr, this);
    }

    public int getStatus() {
        return VuforiaJNI.TrackableResult_getStatus(this.swigCPtr, this);
    }

    public int getStatusInfo() {
        return VuforiaJNI.TrackableResult_getStatusInfo(this.swigCPtr, this);
    }

    public Trackable getTrackable() {
        long TrackableResult_getTrackable = VuforiaJNI.TrackableResult_getTrackable(this.swigCPtr, this);
        if (TrackableResult_getTrackable == 0) {
            return null;
        }
        Trackable trackable = new Trackable(TrackableResult_getTrackable, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(TrackableResult_getTrackable, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(TrackableResult_getTrackable, false);
        }
        return null;
    }

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.TrackableResult_getPose(this.swigCPtr, this), false);
    }
}
