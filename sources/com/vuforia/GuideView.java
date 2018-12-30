package com.vuforia;

public class GuideView {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected GuideView(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GuideView guideView) {
        return guideView == null ? 0 : guideView.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GuideView(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GuideView) && ((GuideView) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public CameraCalibration getIntrinsics() {
        return new CameraCalibration(VuforiaJNI.GuideView_getIntrinsics(this.swigCPtr, this), false);
    }

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.GuideView_getPose(this.swigCPtr, this), false);
    }

    public void setPose(Matrix34F matrix34F) {
        VuforiaJNI.GuideView_setPose(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Image getImage() {
        long GuideView_getImage = VuforiaJNI.GuideView_getImage(this.swigCPtr, this);
        return GuideView_getImage == 0 ? null : new Image(GuideView_getImage, false);
    }
}
