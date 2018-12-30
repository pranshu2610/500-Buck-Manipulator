package com.vuforia;

public class ObjectTargetResult extends TrackableResult {
    private long swigCPtr;

    protected ObjectTargetResult(long j, boolean z) {
        super(VuforiaJNI.ObjectTargetResult_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ObjectTargetResult objectTargetResult) {
        return objectTargetResult == null ? 0 : objectTargetResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ObjectTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ObjectTargetResult) && ((ObjectTargetResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTargetResult_getClassType(), true);
    }

    public Trackable getTrackable() {
        long ObjectTargetResult_getTrackable = VuforiaJNI.ObjectTargetResult_getTrackable(this.swigCPtr, this);
        if (ObjectTargetResult_getTrackable == 0) {
            return null;
        }
        ObjectTarget objectTarget = new ObjectTarget(ObjectTargetResult_getTrackable, false);
        if (objectTarget.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(ObjectTargetResult_getTrackable, false);
        }
        if (objectTarget.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(ObjectTargetResult_getTrackable, false);
        }
        return null;
    }
}
