package com.vuforia;

public class EyewearCalibrationReading {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class AlignmentType {
        public static final int HORIZONTAL_LINE = 1;
        public static final int RECTANGLE = 0;
        public static final int VERTICAL_LINE = 2;
    }

    protected EyewearCalibrationReading(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(EyewearCalibrationReading eyewearCalibrationReading) {
        return eyewearCalibrationReading == null ? 0 : eyewearCalibrationReading.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearCalibrationReading(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    protected static long[] cArrayUnwrap(EyewearCalibrationReading[] eyewearCalibrationReadingArr) {
        long[] jArr = new long[eyewearCalibrationReadingArr.length];
        for (int i = 0; i < eyewearCalibrationReadingArr.length; i++) {
            jArr[i] = getCPtr(eyewearCalibrationReadingArr[i]);
        }
        return jArr;
    }

    protected static EyewearCalibrationReading[] cArrayWrap(long[] jArr, boolean z) {
        EyewearCalibrationReading[] eyewearCalibrationReadingArr = new EyewearCalibrationReading[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            eyewearCalibrationReadingArr[i] = new EyewearCalibrationReading(jArr[i], z);
        }
        return eyewearCalibrationReadingArr;
    }

    public void setPose(Matrix34F matrix34F) {
        VuforiaJNI.EyewearCalibrationReading_Pose_set(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Matrix34F getPose() {
        long EyewearCalibrationReading_Pose_get = VuforiaJNI.EyewearCalibrationReading_Pose_get(this.swigCPtr, this);
        return EyewearCalibrationReading_Pose_get == 0 ? null : new Matrix34F(EyewearCalibrationReading_Pose_get, false);
    }

    public void setScale(float f) {
        VuforiaJNI.EyewearCalibrationReading_Scale_set(this.swigCPtr, this, f);
    }

    public float getScale() {
        return VuforiaJNI.EyewearCalibrationReading_Scale_get(this.swigCPtr, this);
    }

    public void setCenterX(float f) {
        VuforiaJNI.EyewearCalibrationReading_CenterX_set(this.swigCPtr, this, f);
    }

    public float getCenterX() {
        return VuforiaJNI.EyewearCalibrationReading_CenterX_get(this.swigCPtr, this);
    }

    public void setCenterY(float f) {
        VuforiaJNI.EyewearCalibrationReading_CenterY_set(this.swigCPtr, this, f);
    }

    public float getCenterY() {
        return VuforiaJNI.EyewearCalibrationReading_CenterY_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        VuforiaJNI.EyewearCalibrationReading_Type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return VuforiaJNI.EyewearCalibrationReading_Type_get(this.swigCPtr, this);
    }

    public EyewearCalibrationReading() {
        this(VuforiaJNI.new_EyewearCalibrationReading(), true);
    }
}
