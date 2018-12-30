package com.vuforia;

public class TargetFinder {
    public static final int FILTER_CURRENTLY_TRACKED = 1;
    public static final int FILTER_NONE = 0;
    public static final int INIT_DEFAULT = 0;
    public static final int INIT_ERROR_NO_NETWORK_CONNECTION = -1;
    public static final int INIT_ERROR_SERVICE_NOT_AVAILABLE = -2;
    public static final int INIT_RUNNING = 1;
    public static final int INIT_SUCCESS = 2;
    public static final int UPDATE_ERROR_AUTHORIZATION_FAILED = -1;
    public static final int UPDATE_ERROR_BAD_FRAME_QUALITY = -5;
    public static final int UPDATE_ERROR_NO_NETWORK_CONNECTION = -3;
    public static final int UPDATE_ERROR_PROJECT_SUSPENDED = -2;
    public static final int UPDATE_ERROR_REQUEST_TIMEOUT = -8;
    public static final int UPDATE_ERROR_SERVICE_NOT_AVAILABLE = -4;
    public static final int UPDATE_ERROR_TIMESTAMP_OUT_OF_RANGE = -7;
    public static final int UPDATE_ERROR_UPDATE_SDK = -6;
    public static final int UPDATE_NO_MATCH = 0;
    public static final int UPDATE_NO_REQUEST = 1;
    public static final int UPDATE_RESULTS_AVAILABLE = 2;
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetFinder(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetFinder targetFinder) {
        return targetFinder == null ? 0 : targetFinder.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetFinder(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TargetFinder) && ((TargetFinder) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public boolean startInit(String str, String str2) {
        return VuforiaJNI.TargetFinder_startInit(this.swigCPtr, this, str, str2);
    }

    public int getInitState() {
        return VuforiaJNI.TargetFinder_getInitState(this.swigCPtr, this);
    }

    public void waitUntilInitFinished() {
        VuforiaJNI.TargetFinder_waitUntilInitFinished(this.swigCPtr, this);
    }

    public boolean deinit() {
        return VuforiaJNI.TargetFinder_deinit(this.swigCPtr, this);
    }

    public boolean startRecognition() {
        return VuforiaJNI.TargetFinder_startRecognition(this.swigCPtr, this);
    }

    public boolean stop() {
        return VuforiaJNI.TargetFinder_stop(this.swigCPtr, this);
    }

    public boolean isRequesting() {
        return VuforiaJNI.TargetFinder_isRequesting(this.swigCPtr, this);
    }

    public int updateSearchResults(int i) {
        return VuforiaJNI.TargetFinder_updateSearchResults__SWIG_0(this.swigCPtr, this, i);
    }

    public int updateSearchResults() {
        return VuforiaJNI.TargetFinder_updateSearchResults__SWIG_1(this.swigCPtr, this);
    }

    public int getResultCount() {
        return VuforiaJNI.TargetFinder_getResultCount(this.swigCPtr, this);
    }

    public TargetSearchResult getResult(int i) {
        long TargetFinder_getResult = VuforiaJNI.TargetFinder_getResult(this.swigCPtr, this, i);
        return TargetFinder_getResult == 0 ? null : new TargetSearchResult(TargetFinder_getResult, false);
    }

    public TargetFinderQueryResult updateQueryResults(int i) {
        return new TargetFinderQueryResult(VuforiaJNI.TargetFinder_updateQueryResults__SWIG_0(this.swigCPtr, this, i), true);
    }

    public TargetFinderQueryResult updateQueryResults() {
        return new TargetFinderQueryResult(VuforiaJNI.TargetFinder_updateQueryResults__SWIG_1(this.swigCPtr, this), true);
    }

    public ObjectTarget enableTracking(TargetSearchResult targetSearchResult) {
        long TargetFinder_enableTracking = VuforiaJNI.TargetFinder_enableTracking(this.swigCPtr, this, TargetSearchResult.getCPtr(targetSearchResult), targetSearchResult);
        if (TargetFinder_enableTracking == 0) {
            return null;
        }
        ObjectTarget objectTarget = new ObjectTarget(TargetFinder_enableTracking, false);
        if (objectTarget.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(TargetFinder_enableTracking, false);
        }
        if (objectTarget.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(TargetFinder_enableTracking, false);
        }
        if (objectTarget.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(TargetFinder_enableTracking, false);
        }
        if (objectTarget.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(TargetFinder_enableTracking, false);
        }
        if (objectTarget.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(TargetFinder_enableTracking, false);
        }
        if (objectTarget.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(TargetFinder_enableTracking, false);
        }
        return objectTarget.isOfType(ObjectTarget.getClassType()) ? new ObjectTarget(TargetFinder_enableTracking, false) : null;
    }

    public void clearTrackables() {
        VuforiaJNI.TargetFinder_clearTrackables(this.swigCPtr, this);
    }

    public int getNumImageTargets() {
        return VuforiaJNI.TargetFinder_getNumImageTargets(this.swigCPtr, this);
    }

    public ImageTarget getImageTarget(int i) {
        long TargetFinder_getImageTarget = VuforiaJNI.TargetFinder_getImageTarget(this.swigCPtr, this, i);
        return TargetFinder_getImageTarget == 0 ? null : new ImageTarget(TargetFinder_getImageTarget, false);
    }

    public ObjectTargetList getObjectTargets() {
        return new ObjectTargetList(VuforiaJNI.TargetFinder_getObjectTargets(this.swigCPtr, this), true);
    }
}
