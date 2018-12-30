package com.vuforia;

public class EyewearUserCalibrator {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class CONSISTENCY {
        public static final int BAD = 1;
        public static final int CONSISTENCY_LEN = 4;
        public static final int GOOD = 3;
        public static final int NONE = 0;
        public static final int OK = 2;
    }

    protected EyewearUserCalibrator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(EyewearUserCalibrator eyewearUserCalibrator) {
        return eyewearUserCalibrator == null ? 0 : eyewearUserCalibrator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearUserCalibrator(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean getProjectionMatrix(EyewearCalibrationReading[] eyewearCalibrationReadingArr, Matrix34F matrix34F, Matrix34F matrix34F2) {
        if (matrix34F != null && matrix34F2 != null) {
            return getProjectionMatrix(eyewearCalibrationReadingArr, eyewearCalibrationReadingArr.length, matrix34F, matrix34F2);
        }
        throw new NullPointerException("Matrix34F argument is null");
    }

    public int getProjectionMatrices(EyewearCalibrationReading[] eyewearCalibrationReadingArr, EyewearCalibrationReading[] eyewearCalibrationReadingArr2, Matrix34F matrix34F, Matrix34F matrix34F2, Matrix34F matrix34F3, Matrix34F matrix34F4) {
        if (matrix34F == null || matrix34F2 == null || matrix34F3 == null || matrix34F4 == null) {
            throw new NullPointerException("Matrix34F argument is null");
        }
        return getProjectionMatrices(eyewearCalibrationReadingArr, eyewearCalibrationReadingArr.length, eyewearCalibrationReadingArr2, eyewearCalibrationReadingArr2.length, matrix34F, matrix34F2, matrix34F3, matrix34F4);
    }

    public boolean init(long j, long j2, float f, float f2) {
        return VuforiaJNI.EyewearUserCalibrator_init(this.swigCPtr, this, j, j2, f, f2);
    }

    public float getMinScaleHint() {
        return VuforiaJNI.EyewearUserCalibrator_getMinScaleHint(this.swigCPtr, this);
    }

    public float getMaxScaleHint() {
        return VuforiaJNI.EyewearUserCalibrator_getMaxScaleHint(this.swigCPtr, this);
    }

    public float getDrawingAspectRatio(long j, long j2) {
        return VuforiaJNI.EyewearUserCalibrator_getDrawingAspectRatio(this.swigCPtr, this, j, j2);
    }

    public boolean isStereoStretched() {
        return VuforiaJNI.EyewearUserCalibrator_isStereoStretched(this.swigCPtr, this);
    }

    private boolean getProjectionMatrix(EyewearCalibrationReading[] eyewearCalibrationReadingArr, int i, Matrix34F matrix34F, Matrix34F matrix34F2) {
        return VuforiaJNI.EyewearUserCalibrator_getProjectionMatrix(this.swigCPtr, this, EyewearCalibrationReading.cArrayUnwrap(eyewearCalibrationReadingArr), i, Matrix34F.getCPtr(matrix34F), matrix34F, Matrix34F.getCPtr(matrix34F2), matrix34F2);
    }

    private int getProjectionMatrices(EyewearCalibrationReading[] eyewearCalibrationReadingArr, int i, EyewearCalibrationReading[] eyewearCalibrationReadingArr2, int i2, Matrix34F matrix34F, Matrix34F matrix34F2, Matrix34F matrix34F3, Matrix34F matrix34F4) {
        return VuforiaJNI.EyewearUserCalibrator_getProjectionMatrices(this.swigCPtr, this, EyewearCalibrationReading.cArrayUnwrap(eyewearCalibrationReadingArr), i, EyewearCalibrationReading.cArrayUnwrap(eyewearCalibrationReadingArr2), i2, Matrix34F.getCPtr(matrix34F), matrix34F, Matrix34F.getCPtr(matrix34F2), matrix34F2, Matrix34F.getCPtr(matrix34F3), matrix34F3, Matrix34F.getCPtr(matrix34F4), matrix34F4);
    }
}
