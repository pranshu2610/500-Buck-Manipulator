package com.vuforia;

public class ImageTargetBuilder {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class FRAME_QUALITY {
        public static final int FRAME_QUALITY_HIGH = 2;
        public static final int FRAME_QUALITY_LOW = 0;
        public static final int FRAME_QUALITY_MEDIUM = 1;
        public static final int FRAME_QUALITY_NONE = -1;

        private FRAME_QUALITY() {
        }
    }

    protected ImageTargetBuilder(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageTargetBuilder imageTargetBuilder) {
        return imageTargetBuilder == null ? 0 : imageTargetBuilder.swigCPtr;
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
        if ((obj instanceof ImageTargetBuilder) && ((ImageTargetBuilder) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public boolean build(String str, float f) {
        return VuforiaJNI.ImageTargetBuilder_build(this.swigCPtr, this, str, f);
    }

    public void startScan() {
        VuforiaJNI.ImageTargetBuilder_startScan(this.swigCPtr, this);
    }

    public void stopScan() {
        VuforiaJNI.ImageTargetBuilder_stopScan(this.swigCPtr, this);
    }

    public int getFrameQuality() {
        return VuforiaJNI.ImageTargetBuilder_getFrameQuality(this.swigCPtr, this);
    }

    public TrackableSource getTrackableSource() {
        long ImageTargetBuilder_getTrackableSource = VuforiaJNI.ImageTargetBuilder_getTrackableSource(this.swigCPtr, this);
        return ImageTargetBuilder_getTrackableSource == 0 ? null : new TrackableSource(ImageTargetBuilder_getTrackableSource, false);
    }
}
