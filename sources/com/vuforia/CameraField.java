package com.vuforia;

public class CameraField {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class DataType {
        public static final int TypeBool = 3;
        public static final int TypeFloat = 2;
        public static final int TypeInt64 = 1;
        public static final int TypeInt64Range = 4;
        public static final int TypeString = 0;
        public static final int TypeUnknown = 5;

        private DataType() {
        }
    }

    protected CameraField(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CameraField cameraField) {
        return cameraField == null ? 0 : cameraField.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraField(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof CameraField) && ((CameraField) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public CameraField() {
        this(VuforiaJNI.new_CameraField(), true);
    }

    public int getType() {
        return VuforiaJNI.CameraField_Type_get(this.swigCPtr, this);
    }

    public String getKey() {
        return VuforiaJNI.CameraField_Key_get(this.swigCPtr, this);
    }
}
