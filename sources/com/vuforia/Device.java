package com.vuforia;

public class Device {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class MODE {
        public static final int MODE_AR = 0;
        public static final int MODE_VR = 1;
    }

    protected Device(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Device device) {
        return device == null ? 0 : device.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Device(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Device) && ((Device) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Device getInstance() {
        if (Vuforia.wasInitializedJava()) {
            long Device_getInstance = VuforiaJNI.Device_getInstance();
            if (VuforiaJNI.Device_isOfType(Device_getInstance, null, Type.getCPtr(EyewearDevice.getClassType()), EyewearDevice.getClassType())) {
                return new EyewearDevice(Device_getInstance, false);
            }
            return new Device(Device_getInstance, false);
        }
        throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Device_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Device_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Device_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean setMode(int i) {
        return VuforiaJNI.Device_setMode(this.swigCPtr, this, i);
    }

    public int getMode() {
        return VuforiaJNI.Device_getMode(this.swigCPtr, this);
    }

    public void setViewerActive(boolean z) {
        VuforiaJNI.Device_setViewerActive(this.swigCPtr, this, z);
    }

    public boolean isViewerActive() {
        return VuforiaJNI.Device_isViewerActive(this.swigCPtr, this);
    }

    public ViewerParametersList getViewerList() {
        return new ViewerParametersList(VuforiaJNI.Device_getViewerList(this.swigCPtr, this), false);
    }

    public boolean selectViewer(ViewerParameters viewerParameters) {
        return VuforiaJNI.Device_selectViewer(this.swigCPtr, this, ViewerParameters.getCPtr(viewerParameters), viewerParameters);
    }

    public ViewerParameters getSelectedViewer() {
        return new ViewerParameters(VuforiaJNI.Device_getSelectedViewer(this.swigCPtr, this), true);
    }

    public void setConfigurationChanged() {
        VuforiaJNI.Device_setConfigurationChanged(this.swigCPtr, this);
    }

    public RenderingPrimitives getRenderingPrimitives() {
        return new RenderingPrimitives(VuforiaJNI.Device_getRenderingPrimitives(this.swigCPtr, this), true);
    }
}
