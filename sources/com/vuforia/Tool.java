package com.vuforia;

public class Tool {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Tool(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Tool tool) {
        return tool == null ? 0 : tool.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Tool(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Tool) && ((Tool) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Matrix44F convertPose2GLMatrix(Matrix34F matrix34F) {
        return new Matrix44F(VuforiaJNI.Tool_convertPose2GLMatrix(Matrix34F.getCPtr(matrix34F), matrix34F), true);
    }

    public static Matrix44F convert2GLMatrix(Matrix34F matrix34F) {
        return new Matrix44F(VuforiaJNI.Tool_convert2GLMatrix(Matrix34F.getCPtr(matrix34F), matrix34F), true);
    }

    public static Matrix44F convertPerspectiveProjection2GLMatrix(Matrix34F matrix34F, float f, float f2) {
        return new Matrix44F(VuforiaJNI.Tool_convertPerspectiveProjection2GLMatrix(Matrix34F.getCPtr(matrix34F), matrix34F, f, f2), true);
    }

    public static Matrix44F getProjectionGL(CameraCalibration cameraCalibration, float f, float f2) {
        return new Matrix44F(VuforiaJNI.Tool_getProjectionGL(CameraCalibration.getCPtr(cameraCalibration), cameraCalibration, f, f2), true);
    }

    public static Vec2F projectPoint(CameraCalibration cameraCalibration, Matrix34F matrix34F, Vec3F vec3F) {
        return new Vec2F(VuforiaJNI.Tool_projectPoint(CameraCalibration.getCPtr(cameraCalibration), cameraCalibration, Matrix34F.getCPtr(matrix34F), matrix34F, Vec3F.getCPtr(vec3F), vec3F), true);
    }

    public static Matrix34F multiply(Matrix34F matrix34F, Matrix34F matrix34F2) {
        return new Matrix34F(VuforiaJNI.Tool_multiply__SWIG_0(Matrix34F.getCPtr(matrix34F), matrix34F, Matrix34F.getCPtr(matrix34F2), matrix34F2), true);
    }

    public static Matrix44F multiply(Matrix44F matrix44F, Matrix44F matrix44F2) {
        return new Matrix44F(VuforiaJNI.Tool_multiply__SWIG_1(Matrix44F.getCPtr(matrix44F), matrix44F, Matrix44F.getCPtr(matrix44F2), matrix44F2), true);
    }

    public static Vec4F multiply(Vec4F vec4F, Matrix44F matrix44F) {
        return new Vec4F(VuforiaJNI.Tool_multiply__SWIG_2(Vec4F.getCPtr(vec4F), vec4F, Matrix44F.getCPtr(matrix44F), matrix44F), true);
    }

    public static Matrix44F multiplyGL(Matrix44F matrix44F, Matrix44F matrix44F2) {
        return new Matrix44F(VuforiaJNI.Tool_multiplyGL(Matrix44F.getCPtr(matrix44F), matrix44F, Matrix44F.getCPtr(matrix44F2), matrix44F2), true);
    }

    public static void setTranslation(Matrix34F matrix34F, Vec3F vec3F) {
        VuforiaJNI.Tool_setTranslation(Matrix34F.getCPtr(matrix34F), matrix34F, Vec3F.getCPtr(vec3F), vec3F);
    }

    public static void setRotation(Matrix34F matrix34F, Vec3F vec3F, float f) {
        VuforiaJNI.Tool_setRotation(Matrix34F.getCPtr(matrix34F), matrix34F, Vec3F.getCPtr(vec3F), vec3F, f);
    }

    public Tool() {
        this(VuforiaJNI.new_Tool(), true);
    }
}
