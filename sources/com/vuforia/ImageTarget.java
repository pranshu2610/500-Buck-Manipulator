package com.vuforia;

public class ImageTarget extends ObjectTarget {
    private long swigCPtr;

    protected ImageTarget(long j, boolean z) {
        super(VuforiaJNI.ImageTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageTarget imageTarget) {
        return imageTarget == null ? 0 : imageTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ImageTarget) && ((ImageTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTarget_getClassType(), true);
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTarget_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButton getVirtualButton(int i) {
        long ImageTarget_getVirtualButton__SWIG_0 = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_0(this.swigCPtr, this, i);
        return ImageTarget_getVirtualButton__SWIG_0 == 0 ? null : new VirtualButton(ImageTarget_getVirtualButton__SWIG_0, false);
    }

    public VirtualButtonList getVirtualButtons() {
        return new VirtualButtonList(VuforiaJNI.ImageTarget_getVirtualButtons(this.swigCPtr, this), true);
    }

    public VirtualButton getVirtualButton(String str) {
        long ImageTarget_getVirtualButton__SWIG_1 = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_1(this.swigCPtr, this, str);
        return ImageTarget_getVirtualButton__SWIG_1 == 0 ? null : new VirtualButton(ImageTarget_getVirtualButton__SWIG_1, false);
    }

    public VirtualButton createVirtualButton(String str, Area area) {
        long ImageTarget_createVirtualButton = VuforiaJNI.ImageTarget_createVirtualButton(this.swigCPtr, this, str, Area.getCPtr(area), area);
        return ImageTarget_createVirtualButton == 0 ? null : new VirtualButton(ImageTarget_createVirtualButton, false);
    }

    public boolean destroyVirtualButton(VirtualButton virtualButton) {
        return VuforiaJNI.ImageTarget_destroyVirtualButton(this.swigCPtr, this, VirtualButton.getCPtr(virtualButton), virtualButton);
    }

    public String getMetaData() {
        return VuforiaJNI.ImageTarget_getMetaData(this.swigCPtr, this);
    }
}
