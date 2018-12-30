package com.vuforia;

public class TargetFinderQueryResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TargetFinderQueryResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TargetFinderQueryResult targetFinderQueryResult) {
        return targetFinderQueryResult == null ? 0 : targetFinderQueryResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetFinderQueryResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TargetFinderQueryResult) && ((TargetFinderQueryResult) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public void setStatus(int i) {
        VuforiaJNI.TargetFinderQueryResult_status_set(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return VuforiaJNI.TargetFinderQueryResult_status_get(this.swigCPtr, this);
    }

    public void setResults(TargetSearchResultList targetSearchResultList) {
        VuforiaJNI.TargetFinderQueryResult_results_set(this.swigCPtr, this, TargetSearchResultList.getCPtr(targetSearchResultList), targetSearchResultList);
    }

    public TargetSearchResultList getResults() {
        long TargetFinderQueryResult_results_get = VuforiaJNI.TargetFinderQueryResult_results_get(this.swigCPtr, this);
        return TargetFinderQueryResult_results_get == 0 ? null : new TargetSearchResultList(TargetFinderQueryResult_results_get, false);
    }
}
