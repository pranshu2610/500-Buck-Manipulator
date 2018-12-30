package com.vuforia;

public class RenderingPrimitives {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected RenderingPrimitives(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RenderingPrimitives renderingPrimitives) {
        return renderingPrimitives == null ? 0 : renderingPrimitives.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RenderingPrimitives(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof RenderingPrimitives) && ((RenderingPrimitives) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public RenderingPrimitives(RenderingPrimitives renderingPrimitives) {
        this(VuforiaJNI.new_RenderingPrimitives(getCPtr(renderingPrimitives), renderingPrimitives), true);
    }

    public ViewList getRenderingViews() {
        return new ViewList(VuforiaJNI.RenderingPrimitives_getRenderingViews(this.swigCPtr, this), false);
    }

    public Vec4I getViewport(int i) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getViewport(this.swigCPtr, this, i), true);
    }

    public Vec4F getNormalizedViewport(int i) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getNormalizedViewport(this.swigCPtr, this, i), true);
    }

    public Matrix34F getProjectionMatrix(int i, CameraCalibration cameraCalibration, boolean z) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_0(this.swigCPtr, this, i, CameraCalibration.getCPtr(cameraCalibration), cameraCalibration, z), true);
    }

    public Matrix34F getProjectionMatrix(int i, CameraCalibration cameraCalibration) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_1(this.swigCPtr, this, i, CameraCalibration.getCPtr(cameraCalibration), cameraCalibration), true);
    }

    public Vec4F getEffectiveFov(int i) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getEffectiveFov(this.swigCPtr, this, i), true);
    }

    public Vec2F getViewportCentreToEyeAxis(int i) {
        return new Vec2F(VuforiaJNI.RenderingPrimitives_getViewportCentreToEyeAxis(this.swigCPtr, this, i), true);
    }

    public Matrix34F getEyeDisplayAdjustmentMatrix(int i) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getEyeDisplayAdjustmentMatrix(this.swigCPtr, this, i), true);
    }

    public Vec2I getVideoBackgroundTextureSize() {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getVideoBackgroundTextureSize(this.swigCPtr, this), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int i, boolean z) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_0(this.swigCPtr, this, i, z), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int i) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_1(this.swigCPtr, this, i), true);
    }

    public Mesh getVideoBackgroundMesh(int i) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getVideoBackgroundMesh(this.swigCPtr, this, i), false);
    }

    public Vec2I getDistortionTextureSize(int i) {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getDistortionTextureSize(this.swigCPtr, this, i), true);
    }

    public Vec4I getDistortionTextureViewport(int i) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getDistortionTextureViewport(this.swigCPtr, this, i), true);
    }

    public Mesh getDistortionTextureMesh(int i) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getDistortionTextureMesh(this.swigCPtr, this, i), false);
    }
}
