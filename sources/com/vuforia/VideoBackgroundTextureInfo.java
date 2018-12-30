package com.vuforia;

public class VideoBackgroundTextureInfo {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoBackgroundTextureInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(VideoBackgroundTextureInfo videoBackgroundTextureInfo) {
        return videoBackgroundTextureInfo == null ? 0 : videoBackgroundTextureInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoBackgroundTextureInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof VideoBackgroundTextureInfo) && ((VideoBackgroundTextureInfo) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public Vec2I getTextureSize() {
        long VideoBackgroundTextureInfo_TextureSize_get = VuforiaJNI.VideoBackgroundTextureInfo_TextureSize_get(this.swigCPtr, this);
        return VideoBackgroundTextureInfo_TextureSize_get == 0 ? null : new Vec2I(VideoBackgroundTextureInfo_TextureSize_get, false);
    }

    public Vec2I getImageSize() {
        long VideoBackgroundTextureInfo_ImageSize_get = VuforiaJNI.VideoBackgroundTextureInfo_ImageSize_get(this.swigCPtr, this);
        return VideoBackgroundTextureInfo_ImageSize_get == 0 ? null : new Vec2I(VideoBackgroundTextureInfo_ImageSize_get, false);
    }

    public int getPixelFormat() {
        return VuforiaJNI.VideoBackgroundTextureInfo_PixelFormat_get(this.swigCPtr, this);
    }

    public VideoBackgroundTextureInfo() {
        this(VuforiaJNI.new_VideoBackgroundTextureInfo(), true);
    }
}
