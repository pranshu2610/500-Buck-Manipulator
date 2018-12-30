package com.vuforia;

public class CustomViewerParameters extends ViewerParameters {
    private long swigCPtr;

    protected CustomViewerParameters(long j, boolean z) {
        super(VuforiaJNI.CustomViewerParameters_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(CustomViewerParameters customViewerParameters) {
        return customViewerParameters == null ? 0 : customViewerParameters.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CustomViewerParameters(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof CustomViewerParameters) && ((CustomViewerParameters) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public CustomViewerParameters(float f, String str, String str2) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_0(f, str, str2), true);
    }

    public CustomViewerParameters(CustomViewerParameters customViewerParameters) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_1(getCPtr(customViewerParameters), customViewerParameters), true);
    }

    public void setButtonType(int i) {
        VuforiaJNI.CustomViewerParameters_setButtonType(this.swigCPtr, this, i);
    }

    public void setScreenToLensDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setScreenToLensDistance(this.swigCPtr, this, f);
    }

    public void setInterLensDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setInterLensDistance(this.swigCPtr, this, f);
    }

    public void setTrayAlignment(int i) {
        VuforiaJNI.CustomViewerParameters_setTrayAlignment(this.swigCPtr, this, i);
    }

    public void setLensCentreToTrayDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setLensCentreToTrayDistance(this.swigCPtr, this, f);
    }

    public void clearDistortionCoefficients() {
        VuforiaJNI.CustomViewerParameters_clearDistortionCoefficients(this.swigCPtr, this);
    }

    public void addDistortionCoefficient(float f) {
        VuforiaJNI.CustomViewerParameters_addDistortionCoefficient(this.swigCPtr, this, f);
    }

    public void setFieldOfView(Vec4F vec4F) {
        VuforiaJNI.CustomViewerParameters_setFieldOfView(this.swigCPtr, this, Vec4F.getCPtr(vec4F), vec4F);
    }

    public void setContainsMagnet(boolean z) {
        VuforiaJNI.CustomViewerParameters_setContainsMagnet(this.swigCPtr, this, z);
    }
}
