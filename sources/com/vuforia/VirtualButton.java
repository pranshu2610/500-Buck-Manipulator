package com.vuforia;

public class VirtualButton {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class SENSITIVITY {
        public static final int HIGH = 0;
        public static final int LOW = 2;
        public static final int MEDIUM = 1;

        private SENSITIVITY() {
        }
    }

    protected VirtualButton(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VirtualButton virtualButton) {
        return virtualButton == null ? 0 : virtualButton.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VirtualButton) && ((VirtualButton) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public boolean setArea(Area area) {
        return VuforiaJNI.VirtualButton_setArea(this.swigCPtr, this, Area.getCPtr(area), area);
    }

    public Area getArea() {
        long VirtualButton_getArea = VuforiaJNI.VirtualButton_getArea(this.swigCPtr, this);
        if (VirtualButton_getArea == 0) {
            return null;
        }
        switch (new Area(VirtualButton_getArea, false).getType()) {
            case 0:
                return new Rectangle(VirtualButton_getArea, false);
            case 1:
                return new RectangleInt(VirtualButton_getArea, false);
            default:
                return null;
        }
    }

    public boolean setSensitivity(int i) {
        return VuforiaJNI.VirtualButton_setSensitivity(this.swigCPtr, this, i);
    }

    public boolean setEnabled(boolean z) {
        return VuforiaJNI.VirtualButton_setEnabled(this.swigCPtr, this, z);
    }

    public boolean isEnabled() {
        return VuforiaJNI.VirtualButton_isEnabled(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.VirtualButton_getName(this.swigCPtr, this);
    }

    public int getID() {
        return VuforiaJNI.VirtualButton_getID(this.swigCPtr, this);
    }
}
