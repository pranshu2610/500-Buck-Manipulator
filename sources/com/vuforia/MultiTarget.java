package com.vuforia;

public class MultiTarget extends ObjectTarget {
    private long swigCPtr;

    protected MultiTarget(long j, boolean z) {
        super(VuforiaJNI.MultiTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(MultiTarget multiTarget) {
        return multiTarget == null ? 0 : multiTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_MultiTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MultiTarget) && ((MultiTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTarget_getClassType(), true);
    }

    public int getNumParts() {
        return VuforiaJNI.MultiTarget_getNumParts(this.swigCPtr, this);
    }

    public Trackable getPart(int i) {
        long MultiTarget_getPart__SWIG_0 = VuforiaJNI.MultiTarget_getPart__SWIG_0(this.swigCPtr, this, i);
        if (MultiTarget_getPart__SWIG_0 == 0) {
            return null;
        }
        Trackable trackable = new Trackable(MultiTarget_getPart__SWIG_0, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(getClassType())) {
            return new MultiTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(MultiTarget_getPart__SWIG_0, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(MultiTarget_getPart__SWIG_0, false);
        }
        return null;
    }

    public TrackableList getParts() {
        return new TrackableList(VuforiaJNI.MultiTarget_getParts(this.swigCPtr, this), true);
    }

    public Trackable getPart(String str) {
        long MultiTarget_getPart__SWIG_1 = VuforiaJNI.MultiTarget_getPart__SWIG_1(this.swigCPtr, this, str);
        if (MultiTarget_getPart__SWIG_1 == 0) {
            return null;
        }
        Trackable trackable = new Trackable(MultiTarget_getPart__SWIG_1, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(getClassType())) {
            return new MultiTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(MultiTarget_getPart__SWIG_1, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(MultiTarget_getPart__SWIG_1, false);
        }
        return null;
    }

    public int addPart(Trackable trackable) {
        return VuforiaJNI.MultiTarget_addPart(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean removePart(int i) {
        return VuforiaJNI.MultiTarget_removePart(this.swigCPtr, this, i);
    }

    public boolean setPartOffset(int i, Matrix34F matrix34F) {
        return VuforiaJNI.MultiTarget_setPartOffset(this.swigCPtr, this, i, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public boolean getPartOffset(int i, Matrix34F matrix34F) {
        return VuforiaJNI.MultiTarget_getPartOffset(this.swigCPtr, this, i, Matrix34F.getCPtr(matrix34F), matrix34F);
    }
}
