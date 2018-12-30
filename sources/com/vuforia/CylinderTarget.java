package com.vuforia;

public class CylinderTarget extends ObjectTarget {
    private long swigCPtr;

    protected CylinderTarget(long j, boolean z) {
        super(VuforiaJNI.CylinderTarget_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(CylinderTarget cylinderTarget) {
        return cylinderTarget == null ? 0 : cylinderTarget.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CylinderTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof CylinderTarget) && ((CylinderTarget) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTarget_getClassType(), true);
    }

    public float getSideLength() {
        return VuforiaJNI.CylinderTarget_getSideLength(this.swigCPtr, this);
    }

    public boolean setSideLength(float f) {
        return VuforiaJNI.CylinderTarget_setSideLength(this.swigCPtr, this, f);
    }

    public float getTopDiameter() {
        return VuforiaJNI.CylinderTarget_getTopDiameter(this.swigCPtr, this);
    }

    public boolean setTopDiameter(float f) {
        return VuforiaJNI.CylinderTarget_setTopDiameter(this.swigCPtr, this, f);
    }

    public float getBottomDiameter() {
        return VuforiaJNI.CylinderTarget_getBottomDiameter(this.swigCPtr, this);
    }

    public boolean setBottomDiameter(float f) {
        return VuforiaJNI.CylinderTarget_setBottomDiameter(this.swigCPtr, this, f);
    }
}
