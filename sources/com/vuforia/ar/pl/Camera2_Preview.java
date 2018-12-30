package com.vuforia.ar.pl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import com.vuforia.PIXEL_FORMAT;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(21)
public class Camera2_Preview {
    private static final int AR_CAMERA_DIRECTION_BACK = 268443665;
    private static final int AR_CAMERA_DIRECTION_FRONT = 268443666;
    private static final int AR_CAMERA_DIRECTION_UNKNOWN = 268443664;
    private static final int AR_CAMERA_EXPOSUREMODE_AUTO = 805314560;
    private static final int AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO = 805322752;
    private static final int AR_CAMERA_EXPOSUREMODE_LOCKED = 805310464;
    private static final int AR_CAMERA_EXPOSUREMODE_MANUAL = 805339136;
    private static final int AR_CAMERA_EXPOSUREMODE_SHUTTER_PRIORITY = 805371904;
    private static final int AR_CAMERA_FOCUSMODE_AUTO = 805306400;
    private static final int AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO = 805306432;
    private static final int AR_CAMERA_FOCUSMODE_FIXED = 805306880;
    private static final int AR_CAMERA_FOCUSMODE_INFINITY = 805306624;
    private static final int AR_CAMERA_FOCUSMODE_MACRO = 805306496;
    private static final int AR_CAMERA_FOCUSMODE_NORMAL = 805306384;
    private static final int AR_CAMERA_IMAGE_FORMAT_ARGB32 = 268439813;
    private static final int AR_CAMERA_IMAGE_FORMAT_ARGB8888 = 268439813;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGR24 = 268439822;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGR888 = 268439822;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGRA32 = 268439814;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGRA8888 = 268439814;
    private static final int AR_CAMERA_IMAGE_FORMAT_LUM = 268439809;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV12 = 268439815;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV16 = 268439816;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV21 = 268439817;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB24 = 268439811;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB565 = 268439810;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB888 = 268439811;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA32 = 268439812;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA4444 = 268439821;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA5551 = 268439820;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA8888 = 268439812;
    private static final int AR_CAMERA_IMAGE_FORMAT_UNKNOWN = 268439808;
    private static final int AR_CAMERA_IMAGE_FORMAT_YUV420P = 268439828;
    private static final int AR_CAMERA_IMAGE_FORMAT_YV12 = 268439818;
    private static final int AR_CAMERA_IMAGE_FORMAT_YV16 = 268439819;
    private static final int AR_CAMERA_PARAMTYPE_BASE = 536870912;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSRANGE = 537133056;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE = 537001984;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTRANGE = 537919488;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTVALUE = 537395200;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREMODE = 536870944;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURETIME = 536871168;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURETIMERANGE = 536871424;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREVALUE = 536871936;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE = 536872960;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSMODE = 536870914;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSRANGE = 536870920;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSREGION = 536870928;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSVALUE = 536870916;
    private static final int AR_CAMERA_PARAMTYPE_ISO = 536870976;
    private static final int AR_CAMERA_PARAMTYPE_ISORANGE = 536871040;
    private static final int AR_CAMERA_PARAMTYPE_LENS_IS_ADJUSTING = 545259520;
    private static final int AR_CAMERA_PARAMTYPE_RECORDING_HINT = 541065216;
    private static final int AR_CAMERA_PARAMTYPE_ROTATION = 538968064;
    private static final int AR_CAMERA_PARAMTYPE_TORCHMODE = 536870913;
    private static final int AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION = 553648128;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE = 536875008;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE = 536887296;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE = 536879104;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMRANGE = 536936448;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMVALUE = 536903680;
    private static final int AR_CAMERA_PARAMVALUE_BASE = 805306368;
    private static final int AR_CAMERA_STATUS_CAPTURE_RUNNING = 268443651;
    private static final int AR_CAMERA_STATUS_OPENED = 268443650;
    private static final int AR_CAMERA_STATUS_UNINITIALIZED = 268443649;
    private static final int AR_CAMERA_STATUS_UNKNOWN = 268443648;
    private static final int AR_CAMERA_TORCHMODE_AUTO = 805306372;
    private static final int AR_CAMERA_TORCHMODE_CONTINUOUSAUTO = 805306376;
    private static final int AR_CAMERA_TORCHMODE_OFF = 805306369;
    private static final int AR_CAMERA_TORCHMODE_ON = 805306370;
    private static final int AR_CAMERA_TYPE_MONO = 268447761;
    private static final int AR_CAMERA_TYPE_STEREO = 268447762;
    private static final int AR_CAMERA_TYPE_UNKNOWN = 268447760;
    private static final int AR_CAMERA_WHITEBALANCEMODE_AUTO = 807403520;
    private static final int AR_CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO = 809500672;
    private static final int AR_CAMERA_WHITEBALANCEMODE_LOCKED = 806354944;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_FRAMERATES = 4;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGEFORMATS = 5;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGESIZES = 3;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_PARAMVALUES = 2;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_QUERYABLE_PARAMS = 0;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_SETTABLE_PARAMS = 1;
    private static final int CAMERA_CAPTUREINFO_VALUE_FORMAT = 2;
    private static final int CAMERA_CAPTUREINFO_VALUE_FRAMERATE = 3;
    private static final int CAMERA_CAPTUREINFO_VALUE_HEIGHT = 1;
    private static final int CAMERA_CAPTUREINFO_VALUE_PREVIEWSURFACEENABLED = 4;
    private static final int CAMERA_CAPTUREINFO_VALUE_WIDTH = 0;
    private static final int[] CAMERA_VALID_IMAGE_FORMAT_PL = new int[]{AR_CAMERA_IMAGE_FORMAT_NV21, AR_CAMERA_IMAGE_FORMAT_NV12, AR_CAMERA_IMAGE_FORMAT_YV12, AR_CAMERA_IMAGE_FORMAT_YUV420P};
    private static final Range<Integer> EMPTY_RANGE = new Range(Integer.valueOf(0), Integer.valueOf(0));
    private static final String FOCUS_MODE_NORMAL = "normal";
    private static final int MAX_HIGHEST_FPS_ALLOWED = 300;
    private static final int MAX_LOWEST_FPS_ALLOWED = 150;
    private static final String MODULENAME = "Camera2_Preview";
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final int _NUM_CAMERA_CAPSINFO_VALUE_ = 6;
    private static final int _NUM_CAMERA_CAPTUREINFO_VALUE_ = 5;
    private HashMap<ImageReader, Integer> mCameraCacheInfoIndexCache = null;
    private Vector<CameraCacheInfo> mCameraCacheInfos = null;
    private Vector<CameraCacheInfo> mCameraCacheInfosInProgress = null;
    private CameraManager mCameraManager;
    private Context mContext;
    private int mIsPermissionGranted = -1;
    private Semaphore mOpenCloseSemaphore = new Semaphore(1);

    /* renamed from: com.vuforia.ar.pl.Camera2_Preview$1 */
    class C00691 extends StateCallback {
        C00691() {
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraCacheInfo cameraCacheInfo = null;
            try {
                Iterator it = Camera2_Preview.this.mCameraCacheInfosInProgress.iterator();
                while (it.hasNext()) {
                    CameraCacheInfo cameraCacheInfo2 = (CameraCacheInfo) it.next();
                    if (cameraCacheInfo2.deviceIDString.equals(cameraDevice.getId())) {
                        try {
                            cameraCacheInfo2.device = cameraDevice;
                            cameraCacheInfo2.builder = cameraDevice.createCaptureRequest(1);
                        } catch (CameraAccessException e) {
                            cameraCacheInfo = cameraCacheInfo2;
                        } catch (IllegalArgumentException e2) {
                            cameraCacheInfo = cameraCacheInfo2;
                        } catch (IllegalStateException e3) {
                            cameraCacheInfo = cameraCacheInfo2;
                        }
                    } else {
                        cameraCacheInfo2 = cameraCacheInfo;
                    }
                    cameraCacheInfo = cameraCacheInfo2;
                }
                Camera2_Preview.this.mOpenCloseSemaphore.release();
            } catch (CameraAccessException e4) {
                try {
                    cameraCacheInfo.builder = null;
                    cameraCacheInfo.device = null;
                } finally {
                    Camera2_Preview.this.mOpenCloseSemaphore.release();
                }
            } catch (IllegalArgumentException e5) {
                cameraCacheInfo.builder = null;
                cameraCacheInfo.device = null;
                Camera2_Preview.this.mOpenCloseSemaphore.release();
            } catch (IllegalStateException e6) {
                cameraCacheInfo.builder = null;
                cameraCacheInfo.device = null;
                Camera2_Preview.this.mOpenCloseSemaphore.release();
            }
        }

        public void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            Camera2_Preview.this.mOpenCloseSemaphore.release();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            Camera2_Preview.this.mOpenCloseSemaphore.release();
        }
    }

    /* renamed from: com.vuforia.ar.pl.Camera2_Preview$2 */
    class C00702 extends CameraCaptureSession.StateCallback {
        C00702() {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            CameraCacheInfo cameraCacheInfo = null;
            Iterator it = Camera2_Preview.this.mCameraCacheInfos.iterator();
            while (it.hasNext()) {
                CameraCacheInfo cameraCacheInfo2 = (CameraCacheInfo) it.next();
                if (cameraCacheInfo2.deviceIDString.equals(cameraCaptureSession.getDevice().getId())) {
                    cameraCacheInfo = cameraCacheInfo2;
                    break;
                }
            }
            cameraCacheInfo.session = cameraCaptureSession;
            for (Surface addTarget : cameraCacheInfo.surfaces) {
                cameraCacheInfo.builder.addTarget(addTarget);
            }
            Camera2_Preview.this.mOpenCloseSemaphore.release();
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            cameraCaptureSession.close();
            Camera2_Preview.this.mOpenCloseSemaphore.release();
        }
    }

    private class AutofocusRunner extends CaptureCallback {
        private CameraCacheInfo mCCI;
        private CaptureRequest mCancelRequest = null;
        private CaptureRequest mFocusRequest = null;

        public AutofocusRunner(CameraCacheInfo cameraCacheInfo) {
            this.mCCI = cameraCacheInfo;
        }

        public boolean triggerAutofocus() throws CameraAccessException {
            if (this.mCCI == null || this.mCCI.builder == null || this.mCCI.session == null) {
                return false;
            }
            Integer num = (Integer) this.mCCI.builder.get(CaptureRequest.CONTROL_AF_MODE);
            if (CaptureRequest.CONTROL_AF_MODE == null || num == null) {
                return false;
            }
            if (num.intValue() != 1 && num.intValue() != 2) {
                return false;
            }
            this.mCCI.isAutoFocusing = true;
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            this.mCancelRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
            this.mFocusRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
            this.mCCI.session.capture(this.mCancelRequest, this, this.mCCI.handler);
            return true;
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (captureRequest.equals(this.mCancelRequest) && num.intValue() == 0) {
                try {
                    cameraCaptureSession.capture(this.mFocusRequest, this, this.mCCI.handler);
                } catch (CameraAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (IllegalStateException e3) {
                }
            } else if (!captureRequest.equals(this.mFocusRequest)) {
            } else {
                if (num.intValue() == 4 || num.intValue() == 5) {
                    this.mCCI.isAutoFocusing = false;
                }
            }
        }
    }

    public class CameraCacheInfo {
        int bufferFormatPL;
        int bufferHeight;
        int bufferWidth;
        Builder builder;
        int[] caps;
        CameraCharacteristics characteristics;
        CameraDevice device;
        long deviceHandle;
        int deviceID;
        String deviceIDString;
        Handler handler;
        Semaphore imageSemaphore;
        Image[] images;
        boolean isAutoFocusing;
        CaptureResult lastResult;
        int overrideFormatAndroid;
        int overrideFormatPL;
        int overrideHeight;
        int overrideWidth;
        ImageReader reader;
        int requestFormatAndroid;
        int requestFormatPL;
        int requestFramerate;
        int requestHeight;
        int requestWidth;
        CameraCaptureSession session;
        int status;
        List<Surface> surfaces;
        HandlerThread thread;
    }

    public class FrameInfo {
        long exposureTime;
        int iso;
        long timestamp;
    }

    private class OnCameraDataAvailable implements OnImageAvailableListener {
        private int[] actualBufferSize;
        private int actualCaptureFormat;
        private long prevTimestamp;

        private OnCameraDataAvailable() {
            this.actualCaptureFormat = Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
            this.actualBufferSize = null;
            this.prevTimestamp = -1;
        }

        public void onImageAvailable(ImageReader imageReader) {
            Trace.beginSection("onImageAvailable (java)");
            Integer num = (Integer) Camera2_Preview.this.mCameraCacheInfoIndexCache.get(imageReader);
            if (num == null) {
                Trace.endSection();
                return;
            }
            CameraCacheInfo cameraCacheInfo = (CameraCacheInfo) Camera2_Preview.this.mCameraCacheInfos.get(num.intValue());
            if (cameraCacheInfo == null) {
                Trace.endSection();
            } else if (cameraCacheInfo.imageSemaphore.tryAcquire()) {
                if (imageReader.getMaxImages() > 0) {
                    Image acquireLatestImage = imageReader.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        FrameInfo frameInfo = new FrameInfo();
                        frameInfo.timestamp = acquireLatestImage.getTimestamp();
                        CaptureResult captureResult = cameraCacheInfo.lastResult;
                        if (captureResult != null) {
                            Long l = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                            if (l != null) {
                                frameInfo.exposureTime = l.longValue();
                                frameInfo.timestamp += l.longValue();
                            }
                            Integer num2 = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                            if (num2 != null) {
                                frameInfo.iso = num2.intValue();
                            }
                        }
                        if (frameInfo.timestamp > this.prevTimestamp) {
                            this.prevTimestamp = frameInfo.timestamp;
                            if (this.actualCaptureFormat == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN) {
                                this.actualCaptureFormat = getImageFormat(acquireLatestImage);
                            }
                            Camera2_Preview.this.newFrameAvailable(cameraCacheInfo.deviceHandle, num.intValue(), cameraCacheInfo.bufferWidth, cameraCacheInfo.bufferHeight, this.actualBufferSize, this.actualCaptureFormat, acquireLatestImage.getPlanes()[0].getBuffer(), frameInfo);
                        }
                        acquireLatestImage.close();
                    }
                }
                cameraCacheInfo.imageSemaphore.release();
                Trace.endSection();
            } else {
                DebugLog.LOGE(Camera2_Preview.MODULENAME, "Unable to aquire image semaphore, need to free some buffers!!");
                Trace.endSection();
            }
        }

        private int getImageFormat(Image image) {
            if (image == null || image.getPlanes().length != 3 || image.getFormat() != 35) {
                return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
            }
            Plane plane = image.getPlanes()[0];
            Plane plane2 = image.getPlanes()[1];
            Plane plane3 = image.getPlanes()[2];
            if (plane.getPixelStride() != 1 || plane2.getPixelStride() != plane3.getPixelStride() || plane2.getRowStride() != plane3.getRowStride()) {
                return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
            }
            long[] jArr = new long[]{Camera2_Preview.this.getBufferAddress(plane.getBuffer()), Camera2_Preview.this.getBufferAddress(plane2.getBuffer()), Camera2_Preview.this.getBufferAddress(plane3.getBuffer())};
            if (jArr[0] == 0 || jArr[1] == 0 || jArr[2] == 0) {
                return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
            }
            if (plane2.getPixelStride() == 2) {
                if (jArr[1] + 1 == jArr[2]) {
                    this.actualBufferSize = calculateActualBufferSize(jArr[0], jArr[1], jArr[2], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV12);
                    return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV12;
                } else if (jArr[2] + 1 == jArr[1]) {
                    this.actualBufferSize = calculateActualBufferSize(jArr[0], jArr[2], jArr[1], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV21);
                    return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV21;
                }
            }
            if (plane2.getPixelStride() != 1) {
                return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
            }
            if (jArr[1] < jArr[2]) {
                this.actualBufferSize = calculateActualBufferSize(jArr[0], jArr[1], jArr[2], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YV12);
                return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YV12;
            }
            this.actualBufferSize = calculateActualBufferSize(jArr[0], jArr[2], jArr[1], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YUV420P);
            return Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YUV420P;
        }

        private int[] calculateActualBufferSize(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5) {
            int[] iArr = null;
            Object obj = null;
            if ((i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV12 || i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV21) && ((long) (i4 * i3)) + j != j2) {
                obj = 1;
            } else if ((i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YV12 || i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YUV420P) && !(((long) (i4 * i3)) + j == j2 && ((long) ((i4 / 2) * (i3 / 2))) + j2 == j3)) {
                obj = 1;
            }
            if (obj != null) {
                iArr = new int[4];
                iArr[0] = i;
                iArr[1] = (int) ((j2 - j) / ((long) i));
                iArr[2] = i2;
                if (i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV12 || i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_NV21) {
                    iArr[3] = i4 / 2;
                } else if (i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YV12 || i5 == Camera2_Preview.AR_CAMERA_IMAGE_FORMAT_YUV420P) {
                    iArr[3] = (int) ((j3 - j2) / ((long) i2));
                }
            }
            return iArr;
        }
    }

    private class OnFrameCapturedCallback extends CaptureCallback {
        CameraCacheInfo mCCI;

        public OnFrameCapturedCallback(CameraCacheInfo cameraCacheInfo) {
            this.mCCI = cameraCacheInfo;
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (this.mCCI != null) {
                this.mCCI.lastResult = totalCaptureResult;
            }
        }
    }

    private native long getBufferAddress(ByteBuffer byteBuffer);

    private native void newFrameAvailable(long j, int i, int i2, int i3, int[] iArr, int i4, ByteBuffer byteBuffer, Object obj);

    private boolean checkPermission() {
        if (this.mIsPermissionGranted == 0) {
            return true;
        }
        try {
            Activity activityFromNative = SystemTools.getActivityFromNative();
            this.mIsPermissionGranted = activityFromNative.getPackageManager().checkPermission("android.permission.CAMERA", activityFromNative.getPackageName());
            if (this.mIsPermissionGranted == 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private int getCameraDeviceIndex(int i, int i2, int i3) {
        int i4 = 0;
        int i5;
        String[] cameraIdList;
        if (i2 != AR_CAMERA_TYPE_UNKNOWN) {
            switch (i3) {
                case AR_CAMERA_DIRECTION_UNKNOWN /*268443664*/:
                    i5 = -1;
                    break;
                case AR_CAMERA_DIRECTION_BACK /*268443665*/:
                    i5 = 1;
                    break;
                case AR_CAMERA_DIRECTION_FRONT /*268443666*/:
                    i5 = 0;
                    break;
                default:
                    SystemTools.setSystemErrorCode(2);
                    return -1;
            }
            try {
                cameraIdList = this.mCameraManager.getCameraIdList();
                while (i4 < cameraIdList.length) {
                    CameraCharacteristics cameraCharacteristics = this.mCameraManager.getCameraCharacteristics(cameraIdList[i4]);
                    if ((i5 >= 0 || i5 == ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue()) && (i < 0 || i == i4)) {
                        return i4;
                    }
                    i4++;
                }
            } catch (CameraAccessException e) {
            } catch (IllegalArgumentException e2) {
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        switch (i3) {
            case AR_CAMERA_DIRECTION_UNKNOWN /*268443664*/:
                i5 = -1;
                break;
            case AR_CAMERA_DIRECTION_BACK /*268443665*/:
                i5 = 1;
                break;
            case AR_CAMERA_DIRECTION_FRONT /*268443666*/:
                i5 = 0;
                break;
            default:
                SystemTools.setSystemErrorCode(2);
                return -1;
        }
        cameraIdList = this.mCameraManager.getCameraIdList();
        while (i4 < cameraIdList.length) {
            CameraCharacteristics cameraCharacteristics2 = this.mCameraManager.getCameraCharacteristics(cameraIdList[i4]);
            if (i5 >= 0) {
            }
            return i4;
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    private CameraCacheInfo getCameraCacheInfo(int i) {
        if (i < 0 || i >= this.mCameraCacheInfos.size()) {
            return null;
        }
        return (CameraCacheInfo) this.mCameraCacheInfos.get(i);
    }

    private boolean setCustomCameraParams(CameraCacheInfo cameraCacheInfo, String str) {
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                try {
                    Object obj = jSONObject.get(str2);
                    Class cls = obj.getClass();
                    if (cls != String.class && cls != Integer.class) {
                        return false;
                    }
                    if (mapStringToKey(str2, cameraCacheInfo.characteristics, obj) == null) {
                        return false;
                    }
                    cameraCacheInfo.builder.set(mapStringToKey(str2, cameraCacheInfo.characteristics, obj), obj);
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e2) {
            return false;
        }
    }

    private <T> Key<T> mapStringToKey(String str, CameraCharacteristics cameraCharacteristics, T t) {
        for (Key<T> key : cameraCharacteristics.getAvailableCaptureRequestKeys()) {
            if (key.getName().equals(str)) {
                return key;
            }
        }
        return null;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo cameraCacheInfo, int[] iArr, int[] iArr2) {
        if (!(iArr == null && iArr2 == null)) {
            cameraCacheInfo.overrideWidth = iArr2 != null ? iArr2[0] : iArr[0];
            cameraCacheInfo.overrideHeight = iArr2 != null ? iArr2[1] : iArr[1];
            cameraCacheInfo.overrideFormatPL = iArr2 != null ? iArr2[2] : iArr[2];
            cameraCacheInfo.overrideFormatAndroid = translateImageFormatPLToAndroid(iArr2 != null ? iArr2[2] : iArr[2]);
        }
        if (iArr == null) {
            return true;
        }
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            return false;
        }
        cameraCacheInfo.requestWidth = iArr[0];
        cameraCacheInfo.requestHeight = iArr[1];
        cameraCacheInfo.requestFormatPL = iArr[2];
        cameraCacheInfo.requestFormatAndroid = translateImageFormatPLToAndroid(iArr[2]);
        cameraCacheInfo.requestFramerate = iArr[3];
        Size[] outputSizes = ((StreamConfigurationMap) cameraCacheInfo.characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(cameraCacheInfo.requestFormatAndroid);
        if (outputSizes == null) {
            return false;
        }
        int intValue;
        boolean z = false;
        for (Size equals : outputSizes) {
            z = equals.equals(new Size(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight));
            if (z) {
                break;
            }
        }
        if (!z) {
            return false;
        }
        Range[] rangeArr = (Range[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        Range range = null;
        int i = Integer.MAX_VALUE;
        int length = rangeArr.length;
        int i2 = 0;
        while (i2 < length) {
            Range range2 = rangeArr[i2];
            if (((Integer) range2.getLower()).intValue() >= MAX_LOWEST_FPS_ALLOWED || ((Integer) range2.getUpper()).intValue() >= MAX_HIGHEST_FPS_ALLOWED) {
                DebugLog.LOGW(MODULENAME, String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using first fps range as default instead of searching for perfect fit.", new Object[]{range2.getLower(), range2.getUpper()}));
                Object obj = rangeArr[0];
                break;
            }
            Range range3;
            if (range2.contains(Integer.valueOf(cameraCacheInfo.requestFramerate))) {
                intValue = ((Integer) range2.getUpper()).intValue() - ((Integer) range2.getLower()).intValue();
                if (intValue < i) {
                    range3 = range2;
                    i2++;
                    range = range3;
                    i = intValue;
                }
            }
            intValue = i;
            range3 = range;
            i2++;
            range = range3;
            i = intValue;
        }
        if (obj == null) {
            return false;
        }
        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, obj);
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cameraCacheInfo) {
        cameraCacheInfo.reader = ImageReader.newInstance(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight, cameraCacheInfo.requestFormatAndroid, 2);
        cameraCacheInfo.imageSemaphore = new Semaphore(2);
        cameraCacheInfo.images = new Image[2];
        cameraCacheInfo.bufferWidth = cameraCacheInfo.requestWidth == cameraCacheInfo.overrideWidth ? cameraCacheInfo.reader.getWidth() : cameraCacheInfo.overrideWidth;
        cameraCacheInfo.bufferHeight = cameraCacheInfo.requestHeight == cameraCacheInfo.overrideHeight ? cameraCacheInfo.reader.getHeight() : cameraCacheInfo.overrideHeight;
        if (cameraCacheInfo.requestFormatAndroid == cameraCacheInfo.overrideFormatAndroid) {
            cameraCacheInfo.reader.getImageFormat();
        } else {
            int i = cameraCacheInfo.overrideFormatAndroid;
        }
        cameraCacheInfo.bufferFormatPL = cameraCacheInfo.requestFormatPL == cameraCacheInfo.overrideFormatPL ? cameraCacheInfo.requestFormatPL : cameraCacheInfo.overrideFormatPL;
        cameraCacheInfo.reader.setOnImageAvailableListener(new OnCameraDataAvailable(), cameraCacheInfo.handler);
        if (cameraCacheInfo.surfaces == null) {
            cameraCacheInfo.surfaces = new LinkedList();
        }
        cameraCacheInfo.surfaces.clear();
        cameraCacheInfo.surfaces.add(cameraCacheInfo.reader.getSurface());
        return true;
    }

    private void setCameraCapsBit(CameraCacheInfo cameraCacheInfo, int i, int i2, boolean z) {
        int i3;
        switch (i) {
            case 0:
            case 1:
                i3 = AR_CAMERA_PARAMTYPE_BASE;
                break;
            case 2:
                i3 = AR_CAMERA_PARAMVALUE_BASE;
                break;
            default:
                return;
        }
        i3 = (int) (Math.log((double) ((i3 ^ -1) & i2)) / Math.log(2.0d));
        if (z) {
            int[] iArr = cameraCacheInfo.caps;
            iArr[i] = (1 << i3) | iArr[i];
            return;
        }
        iArr = cameraCacheInfo.caps;
        iArr[i] = ((1 << i3) ^ -1) & iArr[i];
    }

    private int translateImageFormatPLToAndroid(int i) {
        for (int i2 : CAMERA_VALID_IMAGE_FORMAT_PL) {
            if (i == i2) {
                return 35;
            }
        }
        return 0;
    }

    int getBitsPerPixel(int i) {
        switch (i) {
            case 4:
            case PIXEL_FORMAT.RGBA8888 /*16*/:
                return 16;
            case 17:
                return 12;
            case 842094169:
                return 12;
            default:
                return 0;
        }
    }

    private List<Integer> getSupportedPreviewFrameRates(CameraCharacteristics cameraCharacteristics) {
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        int i = Integer.MAX_VALUE;
        int length = rangeArr.length;
        int i2 = 0;
        int i3 = Integer.MIN_VALUE;
        while (i2 < length) {
            Range range = rangeArr[i2];
            int min = Math.min(i, ((Integer) range.getLower()).intValue());
            i2++;
            i3 = Math.max(i3, ((Integer) range.getUpper()).intValue());
            i = min;
        }
        List<Integer> linkedList = new LinkedList();
        if (i < 0 || i >= MAX_LOWEST_FPS_ALLOWED || i3 < 0 || i3 >= MAX_HIGHEST_FPS_ALLOWED) {
            DebugLog.LOGW(MODULENAME, String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using saner defaults instead.", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)}));
            linkedList.add(Integer.valueOf(30));
        } else {
            for (int i4 = i; i4 <= i3; i4++) {
                for (Range contains : rangeArr) {
                    if (contains.contains(Integer.valueOf(i4))) {
                        linkedList.add(Integer.valueOf(i4));
                        break;
                    }
                }
            }
        }
        return linkedList;
    }

    private boolean checkCameraManager() {
        if (this.mCameraManager != null) {
            return true;
        }
        Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative == null) {
            return false;
        }
        Context application = activityFromNative.getApplication();
        if (application == null) {
            return false;
        }
        this.mCameraManager = (CameraManager) application.getSystemService("camera");
        if (this.mCameraManager == null) {
            return false;
        }
        return true;
    }

    private static int compareHardwareSupportLevel(int i, int i2) {
        int i3 = 1;
        if (i == i2) {
            return 0;
        }
        if (i == 2) {
            if (i2 < 0) {
                return 1;
            }
            return -1;
        } else if (i2 != 2) {
            return i - i2;
        } else {
            if (i < 0) {
                i3 = -1;
            }
            return i3;
        }
    }

    private void cleanupHandlerThread(CameraCacheInfo cameraCacheInfo) {
        cameraCacheInfo.handler = null;
        cameraCacheInfo.thread.quitSafely();
        cameraCacheInfo.thread = null;
    }

    public boolean init() {
        this.mCameraCacheInfos = new Vector();
        this.mCameraCacheInfosInProgress = new Vector();
        this.mCameraCacheInfoIndexCache = new HashMap();
        return true;
    }

    public int getNumberOfCameras() {
        int i = -1;
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
        } else if (checkCameraManager()) {
            if (SystemTools.checkMinimumApiLevel(21)) {
                try {
                    i = this.mCameraManager.getCameraIdList().length;
                } catch (Exception e) {
                }
            }
            SystemTools.setSystemErrorCode(6);
        } else {
            SystemTools.setSystemErrorCode(6);
        }
        return i;
    }

    public int getOrientation(int i) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (checkCameraManager()) {
            if (SystemTools.checkMinimumApiLevel(21)) {
                try {
                    String[] cameraIdList = this.mCameraManager.getCameraIdList();
                    if (i < cameraIdList.length) {
                        return ((Integer) this.mCameraManager.getCameraCharacteristics(cameraIdList[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                    }
                } catch (Exception e) {
                }
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
    }

    public int getDirection(int i) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (checkCameraManager()) {
            if (SystemTools.checkMinimumApiLevel(21)) {
                try {
                    String[] cameraIdList = this.mCameraManager.getCameraIdList();
                    if (i < cameraIdList.length) {
                        switch (((Integer) this.mCameraManager.getCameraCharacteristics(cameraIdList[i]).get(CameraCharacteristics.LENS_FACING)).intValue()) {
                            case 0:
                                return AR_CAMERA_DIRECTION_FRONT;
                            case 1:
                                return AR_CAMERA_DIRECTION_BACK;
                            default:
                                return AR_CAMERA_DIRECTION_UNKNOWN;
                        }
                    }
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            return AR_CAMERA_DIRECTION_BACK;
        } else {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
    }

    public int getDeviceID(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo != null) {
            return cameraCacheInfo.deviceID;
        }
        SystemTools.setSystemErrorCode(4);
        return -1;
    }

    public static boolean checkMinimumHardwareSupportLevel(int i, int i2) {
        boolean z;
        if (i == AR_CAMERA_DIRECTION_BACK) {
            z = true;
        } else if (i != AR_CAMERA_DIRECTION_FRONT) {
            return false;
        } else {
            z = false;
        }
        try {
            CameraManager cameraManager = (CameraManager) SystemTools.getActivityFromNative().getSystemService("camera");
            String[] cameraIdList = cameraManager.getCameraIdList();
            for (String cameraCharacteristics : cameraIdList) {
                CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(cameraCharacteristics);
                if (((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == z) {
                    boolean z2;
                    if (compareHardwareSupportLevel(((Integer) cameraCharacteristics2.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue(), i2) >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return z2;
                }
            }
            return false;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public int open(long j, int i, int i2, int i3, String str, int[] iArr, int[] iArr2) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (checkCameraManager()) {
            int cameraDeviceIndex = getCameraDeviceIndex(i, i2, i3);
            if (cameraDeviceIndex < 0) {
                return -1;
            }
            Object obj;
            CameraCacheInfo cameraCacheInfo = null;
            int size = this.mCameraCacheInfos.size();
            int i4 = 0;
            while (i4 < size) {
                cameraCacheInfo = (CameraCacheInfo) this.mCameraCacheInfos.get(i4);
                if (cameraCacheInfo.deviceID == cameraDeviceIndex) {
                    break;
                }
                i4++;
            }
            i4 = -1;
            if (i4 < 0) {
                try {
                    CameraCacheInfo cameraCacheInfo2 = new CameraCacheInfo();
                    cameraCacheInfo2.deviceID = cameraDeviceIndex;
                    cameraCacheInfo2.deviceHandle = j;
                    cameraCacheInfo2.deviceIDString = this.mCameraManager.getCameraIdList()[cameraCacheInfo2.deviceID];
                    cameraCacheInfo2.characteristics = this.mCameraManager.getCameraCharacteristics(cameraCacheInfo2.deviceIDString);
                    cameraCacheInfo2.device = null;
                    cameraCacheInfo2.session = null;
                    cameraCacheInfo2.builder = null;
                    cameraCacheInfo2.surfaces = null;
                    cameraCacheInfo2.reader = null;
                    cameraCacheInfo2.images = null;
                    cameraCacheInfo2.imageSemaphore = null;
                    cameraCacheInfo2.overrideWidth = 0;
                    cameraCacheInfo2.bufferWidth = 0;
                    cameraCacheInfo2.overrideHeight = 0;
                    cameraCacheInfo2.bufferHeight = 0;
                    cameraCacheInfo2.bufferFormatPL = AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
                    cameraCacheInfo2.overrideFormatPL = AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
                    cameraCacheInfo2.overrideFormatAndroid = 0;
                    cameraCacheInfo2.caps = null;
                    cameraCacheInfo2.status = AR_CAMERA_STATUS_UNINITIALIZED;
                    cameraCacheInfo2.isAutoFocusing = false;
                    cameraCacheInfo2.requestFormatPL = AR_CAMERA_IMAGE_FORMAT_NV21;
                    cameraCacheInfo2.requestFormatAndroid = 35;
                    Size[] outputSizes = ((StreamConfigurationMap) cameraCacheInfo2.characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(cameraCacheInfo2.requestFormatAndroid);
                    int width = (outputSizes == null || outputSizes.length <= 0) ? 0 : outputSizes[0].getWidth();
                    cameraCacheInfo2.requestWidth = width;
                    if (outputSizes == null || outputSizes.length <= 0) {
                        width = 0;
                    } else {
                        width = outputSizes[0].getHeight();
                    }
                    cameraCacheInfo2.requestHeight = width;
                    cameraCacheInfo = cameraCacheInfo2;
                } catch (CameraAccessException e) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                } catch (IllegalArgumentException e2) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            Object obj2 = null;
            int i5 = NUM_MAX_CAMERAOPEN_RETRY;
            cameraCacheInfo.thread = new HandlerThread(cameraCacheInfo.deviceIDString + "_camera_thread");
            cameraCacheInfo.thread.start();
            cameraCacheInfo.handler = new Handler(cameraCacheInfo.thread.getLooper());
            do {
                size = i5;
                try {
                    this.mOpenCloseSemaphore.acquire();
                    this.mCameraCacheInfosInProgress.add(cameraCacheInfo);
                    this.mCameraManager.openCamera(cameraCacheInfo.deviceIDString, new C00691(), cameraCacheInfo.handler);
                    this.mOpenCloseSemaphore.acquire();
                    this.mCameraCacheInfosInProgress.remove(cameraCacheInfo);
                    this.mOpenCloseSemaphore.release();
                    obj = (cameraCacheInfo.device == null || cameraCacheInfo.builder == null) ? null : 1;
                    obj2 = obj;
                } catch (Exception e3) {
                    obj2 = obj2;
                }
                if (obj2 == null && size > 0) {
                    try {
                        synchronized (this) {
                            wait(250);
                        }
                    } catch (Exception e4) {
                    }
                }
                if (obj2 != null) {
                    break;
                }
                i5 = size - 1;
            } while (size > 0);
            if (cameraCacheInfo.device == null || cameraCacheInfo.builder == null) {
                SystemTools.setSystemErrorCode(6);
                cleanupHandlerThread(cameraCacheInfo);
                return -1;
            }
            obj2 = ((iArr == null || iArr.length <= 0) && (iArr2 == null || iArr2.length <= 0)) ? null : 1;
            obj = (str == null || str.length() <= 0) ? null : 1;
            if (!(obj2 == null && obj == null)) {
                if (obj2 != null) {
                    if (iArr != null && iArr.length != 5) {
                        SystemTools.setSystemErrorCode(2);
                        cleanupHandlerThread(cameraCacheInfo);
                        return -1;
                    } else if (!setCameraCaptureParams(cameraCacheInfo, iArr, iArr2)) {
                        SystemTools.setSystemErrorCode(6);
                        cleanupHandlerThread(cameraCacheInfo);
                        return -1;
                    }
                }
                if (!(obj == null || setCustomCameraParams(cameraCacheInfo, str))) {
                    SystemTools.setSystemErrorCode(2);
                    cleanupHandlerThread(cameraCacheInfo);
                    return -1;
                }
            }
            cameraCacheInfo.status = AR_CAMERA_STATUS_OPENED;
            if (i4 >= 0) {
                return i4;
            }
            this.mCameraCacheInfos.add(cameraCacheInfo);
            return this.mCameraCacheInfos.size() - 1;
        } else {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
    }

    public boolean close(int i) {
        boolean z = false;
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
        } else {
            this.mCameraCacheInfoIndexCache.remove(cameraCacheInfo.reader);
            try {
                if (cameraCacheInfo.session != null) {
                    cameraCacheInfo.session.close();
                }
                if (cameraCacheInfo.device != null) {
                    cameraCacheInfo.device.close();
                }
                if (cameraCacheInfo.reader != null) {
                    cameraCacheInfo.reader.close();
                }
                z = true;
            } catch (Exception e) {
            }
            cameraCacheInfo.session = null;
            cameraCacheInfo.reader = null;
            cameraCacheInfo.images = null;
            cameraCacheInfo.status = AR_CAMERA_STATUS_UNINITIALIZED;
            cleanupHandlerThread(cameraCacheInfo);
            System.gc();
        }
        return z;
    }

    public int[] getCameraCapabilities(int i) {
        if (checkCameraManager()) {
            CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
            if (cameraCacheInfo == null) {
                SystemTools.setSystemErrorCode(4);
                return null;
            } else if (cameraCacheInfo.caps != null) {
                return cameraCacheInfo.caps;
            } else {
                try {
                    Boolean valueOf;
                    int length;
                    int i2;
                    Size[] outputSizes = ((StreamConfigurationMap) this.mCameraManager.getCameraCharacteristics(this.mCameraManager.getCameraIdList()[cameraCacheInfo.deviceID]).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
                    List<Integer> supportedPreviewFrameRates = getSupportedPreviewFrameRates(cameraCacheInfo.characteristics);
                    int[] iArr = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                    Arrays.sort(iArr);
                    int[] iArr2 = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
                    Arrays.sort(iArr2);
                    int length2 = outputSizes != null ? outputSizes.length : 0;
                    int size = supportedPreviewFrameRates != null ? supportedPreviewFrameRates.size() : 0;
                    int length3 = CAMERA_VALID_IMAGE_FORMAT_PL.length;
                    float[] fArr = (float[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                    boolean z = fArr != null && fArr.length > 0;
                    Boolean bool = (Boolean) cameraCacheInfo.characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                    if (bool == null) {
                        valueOf = Boolean.valueOf(false);
                    } else {
                        valueOf = bool;
                    }
                    Integer num = (Integer) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                    boolean z2 = num != null && num.intValue() > 0;
                    Range range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                    boolean z3 = (range == null || EMPTY_RANGE.equals(range)) ? false : true;
                    range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                    boolean z4 = (range == null || EMPTY_RANGE.equals(range)) ? false : true;
                    boolean z5 = (range == null || EMPTY_RANGE.equals((Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE))) ? false : true;
                    int[] iArr3 = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
                    int[] iArr4 = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                    boolean z6 = (iArr3 != null && iArr3.length > 1) || (iArr4 != null && iArr4.length > 1);
                    cameraCacheInfo.caps = new int[((((length2 * 2) + 6) + size) + length3)];
                    cameraCacheInfo.caps[0] = AR_CAMERA_PARAMTYPE_BASE;
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_TORCHMODE, valueOf.booleanValue());
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSMODE, iArr.length > 0);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSVALUE, z);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSREGION, z2);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSUREMODE, iArr2.length > 0);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSUREVALUE, z3);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE, z3);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ISO, z4);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ISORANGE, z4);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSURETIME, z5);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSURETIMERANGE, z5);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ZOOMVALUE, z);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ZOOMRANGE, z);
                    setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION, z6);
                    cameraCacheInfo.caps[1] = AR_CAMERA_PARAMTYPE_BASE;
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_TORCHMODE, valueOf.booleanValue());
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_FOCUSMODE, iArr.length > 0);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_FOCUSREGION, z2);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_EXPOSUREMODE, iArr2.length > 0);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_EXPOSUREVALUE, z3);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_ISO, z4);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_EXPOSURETIME, z5);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_ZOOMVALUE, z);
                    setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION, z6);
                    cameraCacheInfo.caps[2] = AR_CAMERA_PARAMVALUE_BASE;
                    if (valueOf.booleanValue()) {
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_TORCHMODE_OFF, true);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_TORCHMODE_ON, true);
                    }
                    if (iArr != null) {
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_NORMAL, Arrays.binarySearch(iArr, 1) != -1);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_AUTO, Arrays.binarySearch(iArr, 1) != -1);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO, Arrays.binarySearch(iArr, 3) != -1);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_MACRO, Arrays.binarySearch(iArr, 2) != -1);
                        z6 = (Arrays.binarySearch(iArr, 0) == -1 || CaptureRequest.LENS_FOCUS_DISTANCE == null) ? false : true;
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_INFINITY, z6);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_FIXED, Arrays.binarySearch(iArr, 0) != -1);
                    }
                    if (iArr2 != null) {
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_EXPOSUREMODE_LOCKED, Arrays.binarySearch(iArr2, 0) != -1);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_EXPOSUREMODE_MANUAL, Arrays.binarySearch(iArr2, 0) != -1);
                        setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO, Arrays.binarySearch(iArr2, 1) != -1);
                    }
                    cameraCacheInfo.caps[3] = length2;
                    cameraCacheInfo.caps[4] = size;
                    cameraCacheInfo.caps[5] = length3;
                    int i3 = 6;
                    if (length2 > 0) {
                        length = outputSizes.length;
                        i2 = 0;
                        while (i2 < length) {
                            Size size2 = outputSizes[i2];
                            cameraCacheInfo.caps[i3] = size2.getWidth();
                            cameraCacheInfo.caps[i3 + 1] = size2.getHeight();
                            i2++;
                            i3 += 2;
                        }
                    }
                    if (size > 0) {
                        i2 = i3;
                        for (Integer intValue : supportedPreviewFrameRates) {
                            cameraCacheInfo.caps[i2] = intValue.intValue();
                            i2++;
                        }
                    } else {
                        i2 = i3;
                    }
                    for (int size3 : CAMERA_VALID_IMAGE_FORMAT_PL) {
                        cameraCacheInfo.caps[i2] = Integer.valueOf(size3).intValue();
                        i2++;
                    }
                    return cameraCacheInfo.caps;
                } catch (CameraAccessException e) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } catch (IllegalArgumentException e2) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            }
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    public boolean setCaptureInfo(int i, int[] iArr, int[] iArr2) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (iArr.length != 5) {
            SystemTools.setSystemErrorCode(2);
            return false;
        } else if (setCameraCaptureParams(cameraCacheInfo, iArr, iArr2)) {
            return true;
        } else {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public int[] getCaptureInfo(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        try {
            int[] iArr = new int[5];
            if (cameraCacheInfo.reader != null) {
                iArr[0] = cameraCacheInfo.reader.getWidth();
                iArr[1] = cameraCacheInfo.reader.getHeight();
            } else {
                iArr[0] = cameraCacheInfo.requestWidth;
                iArr[1] = cameraCacheInfo.requestHeight;
            }
            iArr[2] = cameraCacheInfo.requestFormatPL;
            if (cameraCacheInfo.builder != null) {
                iArr[3] = ((Integer) ((Range) cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE)).getUpper()).intValue();
            } else {
                iArr[3] = cameraCacheInfo.requestFramerate;
            }
            iArr[4] = 1;
            return iArr;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    public boolean start(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (setupPreviewBuffer(cameraCacheInfo)) {
            try {
                if (cameraCacheInfo.session == null) {
                    this.mOpenCloseSemaphore.acquire();
                    cameraCacheInfo.device.createCaptureSession(cameraCacheInfo.surfaces, new C00702(), cameraCacheInfo.handler);
                    this.mOpenCloseSemaphore.acquire();
                    this.mOpenCloseSemaphore.release();
                    if (cameraCacheInfo.session == null) {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                }
                cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
                cameraCacheInfo.status = AR_CAMERA_STATUS_CAPTURE_RUNNING;
                this.mCameraCacheInfoIndexCache.put(cameraCacheInfo.reader, Integer.valueOf(i));
                return true;
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        } else {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean stop(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        try {
            cameraCacheInfo.session.abortCaptures();
            cameraCacheInfo.status = AR_CAMERA_STATUS_OPENED;
            return true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean setBatchParameters(int i, String str) {
        if (str == null) {
            return false;
        }
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (setCustomCameraParams(cameraCacheInfo, str)) {
            return true;
        } else {
            return false;
        }
    }

    boolean setUntypedCameraParameter(int i, String str, Object obj) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || str == null || obj == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        List availableCaptureRequestKeys = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (int i2 = 0; i2 < availableCaptureRequestKeys.size(); i2++) {
            Key key = (Key) availableCaptureRequestKeys.get(i2);
            if (key.getName().equals(str)) {
                Object obj2 = cameraCacheInfo.builder.get(key);
                if (!(obj2 instanceof Integer) && !(obj2 instanceof Float) && !(obj2 instanceof Boolean) && !(obj2 instanceof Byte) && !(obj2 instanceof Long)) {
                    return false;
                }
                Object b;
                if ((obj2 instanceof Byte) && (obj instanceof Long)) {
                    b = new Byte(((Long) obj).byteValue());
                } else {
                    b = obj;
                }
                if ((obj2 instanceof Integer) && (b instanceof Long)) {
                    b = new Integer(((Long) b).intValue());
                }
                if (!obj2.getClass().equals(b.getClass())) {
                    return false;
                }
                try {
                    cameraCacheInfo.builder.set(key, b);
                    if (cameraCacheInfo.session != null) {
                        cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
                    }
                    return true;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
        }
        SystemTools.setSystemErrorCode(6);
        return false;
    }

    Object getUntypedCameraParameter(int i, String str) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || str == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Object obj;
        Object obj2;
        List availableCaptureRequestKeys = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (int i2 = 0; i2 < availableCaptureRequestKeys.size(); i2++) {
            Key key = (Key) availableCaptureRequestKeys.get(i2);
            if (key.getName().equals(str)) {
                obj = cameraCacheInfo.builder.get(key);
                break;
            }
        }
        obj = null;
        List keys = cameraCacheInfo.characteristics.getKeys();
        for (int i3 = 0; i3 < keys.size(); i3++) {
            CameraCharacteristics.Key key2 = (CameraCharacteristics.Key) keys.get(i3);
            if (key2.getName().equals(str)) {
                obj2 = cameraCacheInfo.characteristics.get(key2);
                break;
            }
        }
        obj2 = obj;
        if (obj2 == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        } else if ((obj2 instanceof Long) || (obj2 instanceof Float) || (obj2 instanceof Boolean) || (obj2 instanceof String)) {
            return obj2;
        } else {
            if (obj2 instanceof Integer) {
                return new Long(((Integer) obj2).longValue());
            }
            if (obj2 instanceof Byte) {
                return new Long(((Byte) obj2).longValue());
            }
            if (obj2 instanceof Range) {
                Comparable lower = ((Range) obj2).getLower();
                Comparable upper = ((Range) obj2).getUpper();
                if (lower instanceof Integer) {
                    return new long[]{((Integer) lower).longValue(), ((Integer) upper).longValue()};
                } else if (lower instanceof Long) {
                    return new long[]{((Long) lower).longValue(), ((Long) upper).longValue()};
                } else {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            }
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    int getUntypedCameraParameterType(int i, String str) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || str == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        int i2;
        Object obj;
        Object obj2 = null;
        List availableCaptureRequestKeys = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (i2 = 0; i2 < availableCaptureRequestKeys.size(); i2++) {
            Key key = (Key) availableCaptureRequestKeys.get(i2);
            if (key.getName().equals(str)) {
                i2 = 1;
                obj2 = cameraCacheInfo.builder.get(key);
                break;
            }
        }
        i2 = 0;
        List keys = cameraCacheInfo.characteristics.getKeys();
        for (int i3 = 0; i3 < keys.size(); i3++) {
            CameraCharacteristics.Key key2 = (CameraCharacteristics.Key) keys.get(i3);
            if (key2.getName().equals(str)) {
                obj = cameraCacheInfo.characteristics.get(key2);
                i2 = 1;
                break;
            }
        }
        obj = obj2;
        if (i2 == 0) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (obj == null) {
            return -1;
        } else {
            if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Long)) {
                return 1;
            }
            if (obj instanceof Float) {
                return 2;
            }
            if (obj instanceof Boolean) {
                return 3;
            }
            if (obj instanceof String) {
                return 0;
            }
            if (obj instanceof Range) {
                Comparable lower = ((Range) obj).getLower();
                if (lower instanceof Integer) {
                    return 4;
                }
                if (lower instanceof Long) {
                    return 4;
                }
            }
            return -1;
        }
    }

    int getNamedParameterCount(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        List availableCaptureRequestKeys = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        List keys = cameraCacheInfo.characteristics.getKeys();
        return keys.size() + availableCaptureRequestKeys.size();
    }

    String getNamedParameter(int i, int i2) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        List availableCaptureRequestKeys = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        List keys = cameraCacheInfo.characteristics.getKeys();
        if (i2 < availableCaptureRequestKeys.size()) {
            Key key = (Key) availableCaptureRequestKeys.get(i2);
            if (key == null) {
                return null;
            }
            return key.getName();
        } else if (i2 - availableCaptureRequestKeys.size() < keys.size()) {
            CameraCharacteristics.Key key2 = (CameraCharacteristics.Key) keys.get(i2 - availableCaptureRequestKeys.size());
            if (key2 == null) {
                return null;
            }
            return key2.getName();
        } else {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    boolean setTypedCameraParameter(int i, int i2, Object obj) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        int intValue;
        int i3;
        int length;
        Object obj2 = null;
        int[] iArr;
        Object obj3;
        Object obj4;
        int intValue2;
        Range range;
        switch (i2) {
            case AR_CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                if (CaptureRequest.FLASH_MODE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                switch (((Number) obj).intValue()) {
                    case AR_CAMERA_TORCHMODE_OFF /*805306369*/:
                        cameraCacheInfo.builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
                        break;
                    case AR_CAMERA_TORCHMODE_ON /*805306370*/:
                        cameraCacheInfo.builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
                        break;
                    case AR_CAMERA_TORCHMODE_AUTO /*805306372*/:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                if (CaptureRequest.CONTROL_AF_MODE != null) {
                    iArr = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                    Arrays.sort(iArr);
                    switch (((Number) obj).intValue()) {
                        case AR_CAMERA_FOCUSMODE_NORMAL /*805306384*/:
                        case AR_CAMERA_FOCUSMODE_AUTO /*805306400*/:
                            if (Arrays.binarySearch(iArr, 1) != -1) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                                obj3 = 1;
                                break;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        case AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO /*805306432*/:
                            if (Arrays.binarySearch(iArr, 3) != -1) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
                                obj3 = null;
                                break;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        case AR_CAMERA_FOCUSMODE_MACRO /*805306496*/:
                            if (Arrays.binarySearch(iArr, 2) != -1) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(2));
                                obj3 = 1;
                                break;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        case AR_CAMERA_FOCUSMODE_INFINITY /*805306624*/:
                            if (CaptureRequest.LENS_FOCUS_DISTANCE != null) {
                                if (Arrays.binarySearch(iArr, 0) != -1) {
                                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                                    cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
                                    obj3 = null;
                                    break;
                                }
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        case AR_CAMERA_FOCUSMODE_FIXED /*805306880*/:
                            if (Arrays.binarySearch(iArr, 0) != -1) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                                obj3 = null;
                                break;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        default:
                            SystemTools.setSystemErrorCode(3);
                            return false;
                    }
                    obj2 = obj3;
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                if (CaptureRequest.LENS_FOCUS_DISTANCE != null) {
                    cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(((Number) obj).floatValue()));
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                float[] fArr = (float[]) obj;
                if (fArr.length == 5) {
                    if (fArr[0] >= 0.0f && fArr[0] <= 1.0f && fArr[1] >= 0.0f && fArr[1] <= 1.0f && fArr[2] >= 0.0f && fArr[2] <= 1.0f && fArr[3] >= 0.0f && fArr[3] <= 1.0f && fArr[4] >= 0.0f && fArr[4] <= 1.0f) {
                        Integer num = (Integer) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                        if (CaptureRequest.CONTROL_AF_REGIONS != null && num != null && num.intValue() != 0) {
                            if (((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) != null) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(new Rect(Math.min((int) (fArr[0] * ((float) ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).width())), ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).width() - 1), Math.min((int) (fArr[1] * ((float) ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).height())), ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).height() - 1), Math.min((int) (fArr[2] * ((float) ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).width())), ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).width() - 1), Math.min((int) (fArr[3] * ((float) ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).height())), ((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).height() - 1)), (int) ((fArr[4] * 1000.0f) + 0.0f))});
                                obj2 = 1;
                                break;
                            }
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    SystemTools.setSystemErrorCode(2);
                    return false;
                }
                SystemTools.setSystemErrorCode(2);
                return false;
                break;
            case AR_CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                intValue = ((Number) obj).intValue();
                iArr = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
                if (iArr == null || CaptureRequest.CONTROL_AE_MODE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                switch (intValue) {
                    case AR_CAMERA_EXPOSUREMODE_LOCKED /*805310464*/:
                    case AR_CAMERA_EXPOSUREMODE_MANUAL /*805339136*/:
                        obj4 = null;
                        for (int intValue3 : iArr) {
                            obj4 = intValue3 == 0 ? 1 : null;
                            if (obj4 != null) {
                                obj3 = obj4;
                                if (obj3 == null) {
                                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(0));
                                    break;
                                }
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                        }
                        obj3 = obj4;
                        if (obj3 == null) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(0));
                        } else {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                    case AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO /*805322752*/:
                        obj4 = null;
                        for (int intValue32 : iArr) {
                            obj4 = intValue32 == 1 ? 1 : null;
                            if (obj4 != null) {
                                obj3 = obj4;
                                if (obj3 == null) {
                                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                                    break;
                                }
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                        }
                        obj3 = obj4;
                        if (obj3 == null) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
                        } else {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
                break;
            case AR_CAMERA_PARAMTYPE_ISO /*536870976*/:
                range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                if (range == null || CaptureRequest.SENSOR_SENSITIVITY == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                intValue32 = ((Number) obj).intValue();
                if (range.contains(Integer.valueOf(intValue32))) {
                    cameraCacheInfo.builder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(intValue32));
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_ISORANGE /*536871040*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_EXPOSURETIME /*536871168*/:
                range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
                if (range == null || CaptureRequest.SENSOR_EXPOSURE_TIME == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                Comparable valueOf = Long.valueOf(Math.round(((double) ((Number) obj).floatValue()) * 1.0E9d));
                if (range.contains(valueOf)) {
                    cameraCacheInfo.builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, valueOf);
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_EXPOSURETIMERANGE /*536871424*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUE /*536871936*/:
                float floatValue = ((Number) obj).floatValue();
                range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                Rational rational = (Rational) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                if (EMPTY_RANGE.equals(range) || CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION == null || rational == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                intValue32 = Math.round(floatValue / rational.floatValue());
                if (range.contains(Integer.valueOf(intValue32))) {
                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(intValue32));
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE /*536872960*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE /*536875008*/:
                switch (((Number) obj).intValue()) {
                    case AR_CAMERA_WHITEBALANCEMODE_LOCKED /*806354944*/:
                        if (CaptureRequest.CONTROL_AWB_LOCK != null) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(true));
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    case AR_CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO /*809500672*/:
                        if (CaptureRequest.CONTROL_AWB_LOCK != null && ((Boolean) cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AWB_LOCK)).booleanValue()) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(false));
                        }
                        if (CaptureRequest.CONTROL_AWB_MODE != null) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
                            break;
                        }
                        break;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE /*536879104*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE /*536887296*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_ZOOMVALUE /*536903680*/:
                intValue2 = ((Number) obj).intValue();
                float[] fArr2 = (float[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                if (fArr2 == null || CaptureRequest.LENS_FOCAL_LENGTH == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                for (float f : fArr2) {
                    if (Math.abs(f - ((float) intValue2)) < 0.01f) {
                        obj3 = 1;
                        cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCAL_LENGTH, Float.valueOf(f));
                        if (obj3 == null) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                    }
                }
                obj3 = null;
                if (obj3 == null) {
                    SystemTools.setSystemErrorCode(2);
                    return false;
                }
                break;
            case AR_CAMERA_PARAMTYPE_ZOOMRANGE /*536936448*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE /*537001984*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_BRIGHTNESSRANGE /*537133056*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_CONTRASTVALUE /*537395200*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_CONTRASTRANGE /*537919488*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_ROTATION /*538968064*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_RECORDING_HINT /*541065216*/:
                try {
                    if (CaptureRequest.CONTROL_CAPTURE_INTENT != null) {
                        int intValue4 = ((Number) obj).intValue();
                        Builder builder = cameraCacheInfo.builder;
                        Key key = CaptureRequest.CONTROL_CAPTURE_INTENT;
                        if (intValue4 != 0) {
                            intValue4 = 3;
                        } else {
                            intValue4 = 1;
                        }
                        builder.set(key, Integer.valueOf(intValue4));
                        break;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return false;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            case AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION /*553648128*/:
                iArr = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                obj4 = (iArr == null || iArr.length <= 1 || CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE == null) ? null : 1;
                iArr = (int[]) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
                obj3 = (iArr == null || iArr.length <= 1 || CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE == null) ? null : 1;
                if (obj4 != null || obj3 != null) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (obj4 != null) {
                        cameraCacheInfo.builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(0));
                    }
                    if (obj3 != null) {
                        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(0));
                    }
                    if (booleanValue) {
                        if (obj4 == null) {
                            if (obj3 != null) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(1));
                                break;
                            }
                        }
                        cameraCacheInfo.builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
                        break;
                    }
                }
                SystemTools.setSystemErrorCode(6);
                return false;
                break;
            default:
                return false;
        }
        if (cameraCacheInfo.session != null) {
            try {
                cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
                if (obj2 != null) {
                    switch (i2) {
                        case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                            try {
                                num = (Integer) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                                if (!(num == null || CameraCharacteristics.CONTROL_MAX_REGIONS_AF == null || num.intValue() <= 0 || CaptureRequest.CONTROL_AF_REGIONS == null)) {
                                    MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AF_REGIONS);
                                    if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                                        Object obj5 = new MeteringRectangle[meteringRectangleArr.length];
                                        int i4 = 0;
                                        length = meteringRectangleArr.length;
                                        intValue32 = 0;
                                        while (intValue32 < length) {
                                            i3 = i4 + 1;
                                            obj5[i4] = new MeteringRectangle(meteringRectangleArr[intValue32].getRect(), 0);
                                            intValue32++;
                                            i4 = i3;
                                        }
                                        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_REGIONS, obj5);
                                        break;
                                    }
                                }
                            } catch (Exception e2) {
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                        case AR_CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                            break;
                    }
                    if (!new AutofocusRunner(cameraCacheInfo).triggerAutofocus()) {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                }
            } catch (CameraAccessException e3) {
                SystemTools.setSystemErrorCode(6);
                return false;
            } catch (IllegalArgumentException e4) {
                SystemTools.setSystemErrorCode(6);
                return false;
            } catch (IllegalStateException e5) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        return true;
    }

    Object getTypedCameraParameter(int i, int i2) {
        Object obj = null;
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        CaptureResult captureResult = cameraCacheInfo.lastResult;
        Integer num;
        Float f;
        Range range;
        Rational rational;
        switch (i2) {
            case AR_CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                if (captureResult == null) {
                    try {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    } catch (Exception e) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                }
                num = (Integer) captureResult.get(CaptureResult.FLASH_MODE);
                if (num == null || CaptureResult.FLASH_MODE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } else if (num.equals(Integer.valueOf(2))) {
                    return Integer.valueOf(AR_CAMERA_TORCHMODE_ON);
                } else {
                    if (num.equals(Integer.valueOf(0))) {
                        return Integer.valueOf(AR_CAMERA_TORCHMODE_OFF);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_MODE);
                if (num == null || CaptureResult.CONTROL_AF_MODE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } else if (num.equals(Integer.valueOf(1))) {
                    return Integer.valueOf(cameraCacheInfo.isAutoFocusing ? AR_CAMERA_FOCUSMODE_AUTO : AR_CAMERA_FOCUSMODE_NORMAL);
                } else if (num.equals(Integer.valueOf(3))) {
                    return Integer.valueOf(AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO);
                } else {
                    if (num.equals(Integer.valueOf(0))) {
                        f = (Float) captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                        if (f == null || CaptureResult.LENS_FOCUS_DISTANCE == null || !f.equals(Float.valueOf(0.0f))) {
                            return Integer.valueOf(AR_CAMERA_FOCUSMODE_FIXED);
                        }
                        return Integer.valueOf(AR_CAMERA_FOCUSMODE_INFINITY);
                    } else if (num.equals(Integer.valueOf(2))) {
                        return Integer.valueOf(AR_CAMERA_FOCUSMODE_MACRO);
                    } else {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                }
            case AR_CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                f = (Float) captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                if (f != null && CaptureResult.LENS_FOCAL_LENGTH != null) {
                    return f;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                if (((Pair) captureResult.get(CaptureResult.LENS_FOCUS_RANGE)) == null || CaptureResult.LENS_FOCUS_RANGE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                return new float[]{((Float) r0.first).floatValue(), ((Float) r0.second).floatValue()};
            case AR_CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                num = (Integer) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                if (num == null || CameraCharacteristics.CONTROL_MAX_REGIONS_AF == null || num.intValue() <= 0 || CaptureResult.CONTROL_AF_REGIONS == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) captureResult.get(CaptureResult.CONTROL_AF_REGIONS);
                if (meteringRectangleArr == null || meteringRectangleArr.length == 0) {
                    return null;
                }
                if (((Rect) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) == null) {
                    SystemTools.setSystemErrorCode(6);
                    return Boolean.valueOf(false);
                }
                Rect rect = meteringRectangleArr[0].getRect();
                return new float[]{(float) (rect.left / (r1.width() - 1)), (float) (rect.top / (r1.height() - 1)), (float) (rect.right / (r1.width() - 1)), (float) (rect.bottom / (r1.height() - 1)), (float) ((meteringRectangleArr[0].getMeteringWeight() + 0) / 1000)};
            case AR_CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_MODE);
                if (num == null || CaptureResult.CONTROL_AE_MODE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } else if (num.equals(Integer.valueOf(0))) {
                    return Integer.valueOf(AR_CAMERA_EXPOSUREMODE_MANUAL);
                } else {
                    if (num.equals(Integer.valueOf(1))) {
                        return Integer.valueOf(AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case AR_CAMERA_PARAMTYPE_ISO /*536870976*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                num = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                if (num != null && CaptureResult.SENSOR_SENSITIVITY != null) {
                    return Float.valueOf(num.floatValue());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_ISORANGE /*536871040*/:
                if (((Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null || CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                return new float[]{((Integer) range.getLower()).floatValue(), ((Integer) range.getUpper()).floatValue()};
            case AR_CAMERA_PARAMTYPE_EXPOSURETIME /*536871168*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                Long l = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                if (l != null && CaptureResult.SENSOR_EXPOSURE_TIME != null) {
                    return Float.valueOf((float) (l.doubleValue() / 1.0E9d));
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_EXPOSURETIMERANGE /*536871424*/:
                if (((Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null || CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                return new float[]{(float) (((Long) range.getLower()).doubleValue() / 1.0E9d), (float) (((Long) range.getUpper()).doubleValue() / 1.0E9d)};
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUE /*536871936*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                rational = (Rational) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                if (num == null || CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION == null || rational == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                return Float.valueOf(((float) num.intValue()) * rational.floatValue());
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE /*536872960*/:
                range = (Range) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                rational = (Rational) cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                if (range == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE == null || rational == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                r4 = new float[2];
                r4[0] = ((float) ((Integer) range.getLower()).intValue()) * rational.floatValue();
                r4[1] = ((float) ((Integer) range.getUpper()).intValue()) * rational.floatValue();
                return r4;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE /*536875008*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE /*536879104*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE /*536887296*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_ZOOMVALUE /*536903680*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                f = (Float) captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                if (f != null && CaptureResult.LENS_FOCAL_LENGTH != null) {
                    return f;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_ZOOMRANGE /*536936448*/:
                SystemTools.setSystemErrorCode(6);
                break;
            case AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE /*537001984*/:
                break;
            case AR_CAMERA_PARAMTYPE_BRIGHTNESSRANGE /*537133056*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_CONTRASTVALUE /*537395200*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_CONTRASTRANGE /*537919488*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_ROTATION /*538968064*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION /*553648128*/:
                if (captureResult == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                Object obj2;
                num = (Integer) captureResult.get(CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE);
                if (!(num == null || CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE == null)) {
                    if (num.equals(Integer.valueOf(1))) {
                        return Boolean.valueOf(true);
                    }
                    obj = 1;
                }
                num = (Integer) captureResult.get(CaptureResult.LENS_OPTICAL_STABILIZATION_MODE);
                if (num == null || CaptureResult.LENS_OPTICAL_STABILIZATION_MODE == null) {
                    obj2 = obj;
                } else if (num.equals(Integer.valueOf(1))) {
                    return Boolean.valueOf(true);
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    return Boolean.valueOf(false);
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            default:
                return null;
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    int getStatus(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo != null) {
            return cameraCacheInfo.status;
        }
        SystemTools.setSystemErrorCode(4);
        return AR_CAMERA_STATUS_UNKNOWN;
    }
}
