package com.vuforia.ar.pl;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.vuforia.PIXEL_FORMAT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class Camera1_Preview implements PreviewCallback {
    private static final int AR_CAMERA_DIRECTION_BACK = 268443665;
    private static final int AR_CAMERA_DIRECTION_FRONT = 268443666;
    private static final int AR_CAMERA_DIRECTION_UNKNOWN = 268443664;
    private static final int AR_CAMERA_EXPOSUREMODE_AUTO = 805314560;
    private static final int AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO = 805322752;
    private static final int AR_CAMERA_EXPOSUREMODE_LOCKED = 805310464;
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
    private static final int[] CAMERA_IMAGE_FORMAT_CONVERSIONTABLE = new int[]{16, AR_CAMERA_IMAGE_FORMAT_NV16, 17, AR_CAMERA_IMAGE_FORMAT_NV21, 4, AR_CAMERA_IMAGE_FORMAT_RGB565, 842094169, AR_CAMERA_IMAGE_FORMAT_YV12};
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static final String FOCUS_MODE_NORMAL = "normal";
    private static final String MODULENAME = "Camera1_Preview";
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_CAPTURE_BUFFERS_TO_ADD = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final String SAMSUNG_PARAM_FAST_FPS_MODE = "fast-fps-mode";
    private static final String SAMSUNG_PARAM_VRMODE = "vrmode";
    private static final String SAMSUNG_PARAM_VRMODE_SUPPORTED = "vrmode-supported";
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final int _NUM_CAMERA_CAPSINFO_VALUE_ = 6;
    private static final int _NUM_CAMERA_CAPTUREINFO_VALUE_ = 5;
    private Vector<CameraCacheInfo> cameraCacheInfo = null;
    private HashMap<Camera, Integer> cameraCacheInfoIndexCache = null;
    private SurfaceManager surfaceManager = null;

    /* renamed from: com.vuforia.ar.pl.Camera1_Preview$1 */
    class C00681 implements AutoFocusCallback {
        C00681() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            Object obj = Camera1_Preview.this.cameraCacheInfoIndexCache.get(camera);
            if (obj != null) {
                CameraCacheInfo access$100 = Camera1_Preview.this.getCameraCacheInfo(((Integer) obj).intValue());
                if (access$100 != null) {
                    access$100.isAutoFocusing = false;
                }
            }
        }
    }

    public class CameraCacheInfo {
        byte[][] buffer;
        int bufferFormatPL;
        int bufferHeight;
        int bufferSize;
        int bufferWidth;
        Camera camera;
        int[] caps;
        long deviceHandle;
        int deviceID;
        boolean isAutoFocusing;
        int overrideFormatAndroid;
        int overrideHeight;
        int overrideWidth;
        int requestFormatAndroid;
        int requestHeight;
        int requestWidth;
        int status;
        CameraSurface surface;
        SurfaceTexture surfaceTexture;
    }

    private native void newFrameAvailable(long j, int i, int i2, int i3, int i4, byte[] bArr, long j2);

    private boolean checkPermission() {
        try {
            Activity activityFromNative = SystemTools.getActivityFromNative();
            if (activityFromNative != null && activityFromNative.getPackageManager().checkPermission("android.permission.CAMERA", activityFromNative.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private int getCameraDeviceIndex(int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 0;
        if (i2 != AR_CAMERA_TYPE_UNKNOWN) {
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            switch (i3) {
                case AR_CAMERA_DIRECTION_UNKNOWN /*268443664*/:
                    i4 = -1;
                    break;
                case AR_CAMERA_DIRECTION_BACK /*268443665*/:
                    i4 = 0;
                    break;
                case AR_CAMERA_DIRECTION_FRONT /*268443666*/:
                    break;
                default:
                    SystemTools.setSystemErrorCode(2);
                    return -1;
            }
            int numberOfCameras = Camera.getNumberOfCameras();
            while (i5 < numberOfCameras) {
                CameraInfo cameraInfo = new CameraInfo();
                try {
                    Camera.getCameraInfo(i5, cameraInfo);
                    if ((i4 < 0 || i4 == cameraInfo.facing) && (i < 0 || i == i5)) {
                        return i5;
                    }
                } catch (Exception e) {
                }
                i5++;
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (i3 == AR_CAMERA_DIRECTION_FRONT) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        } else if (i < 1) {
            return 0;
        } else {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
    }

    private Parameters getCameraParameters(Camera camera) {
        Parameters parameters = null;
        try {
            parameters = camera.getParameters();
        } catch (Exception e) {
        }
        return parameters;
    }

    private CameraCacheInfo getCameraCacheInfo(int i) {
        if (i < 0 || i >= this.cameraCacheInfo.size()) {
            return null;
        }
        return (CameraCacheInfo) this.cameraCacheInfo.get(i);
    }

    private boolean setCustomCameraParams(Parameters parameters, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                try {
                    Object obj = jSONObject.get(str2);
                    if (obj.getClass() == String.class) {
                        parameters.set(str2, (String) obj);
                    } else if (obj.getClass() != Integer.class) {
                        return false;
                    } else {
                        parameters.set(str2, ((Integer) obj).intValue());
                    }
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e2) {
            return false;
        }
    }

    private boolean setCameraPreviewFps(int i, Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int i2 = i * 1000;
        int[] iArr = null;
        if ((i == 60 || i == 120) && "true".equalsIgnoreCase(parameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED))) {
            iArr = new int[2];
            parameters.set(SAMSUNG_PARAM_VRMODE, 1);
            parameters.setRecordingHint(true);
            parameters.set("focus-mode", "continuous-video");
            if (i == 60) {
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 1);
                iArr[0] = 60000;
                iArr[1] = 60000;
            }
            if (i == 120) {
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 2);
                iArr[0] = 120000;
                iArr[1] = 120000;
            }
        } else {
            if (!(!"true".equalsIgnoreCase(parameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED)) || parameters.get(SAMSUNG_PARAM_FAST_FPS_MODE) == null || parameters.getInt(SAMSUNG_PARAM_FAST_FPS_MODE) == 0)) {
                parameters.set(SAMSUNG_PARAM_VRMODE, 0);
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 0);
            }
            for (int[] iArr2 : supportedPreviewFpsRange) {
                int[] iArr22;
                if (iArr22[0] != i2 || iArr22[1] - iArr22[0] >= Integer.MAX_VALUE) {
                    iArr22 = iArr;
                }
                iArr = iArr22;
            }
        }
        if (iArr == null) {
            return false;
        }
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        return true;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo cameraCacheInfo, Parameters parameters, int[] iArr, int[] iArr2) {
        if (!(iArr == null && iArr2 == null)) {
            cameraCacheInfo.overrideWidth = iArr2 != null ? iArr2[0] : iArr[0];
            cameraCacheInfo.overrideHeight = iArr2 != null ? iArr2[1] : iArr[1];
            cameraCacheInfo.overrideFormatAndroid = translateImageFormat(iArr2 != null ? iArr2[2] : iArr[2], CONVERT_FORMAT_TO_ANDROID);
        }
        if (iArr == null) {
            return true;
        }
        cameraCacheInfo.requestWidth = iArr[0];
        cameraCacheInfo.requestHeight = iArr[1];
        cameraCacheInfo.requestFormatAndroid = translateImageFormat(iArr[2], CONVERT_FORMAT_TO_ANDROID);
        int i = iArr[3];
        try {
            if (cameraCacheInfo.requestWidth > 0 && cameraCacheInfo.requestHeight > 0) {
                parameters.setPreviewSize(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight);
            }
            if (i > 0) {
                if (!SystemTools.checkMinimumApiLevel(8)) {
                    parameters.setPreviewFrameRate(i);
                } else if (!setCameraPreviewFps(i, parameters)) {
                    parameters.setPreviewFrameRate(i);
                }
            }
            if (cameraCacheInfo.requestFormatAndroid != 0) {
                parameters.setPreviewFormat(cameraCacheInfo.requestFormatAndroid);
            }
            if (iArr[4] > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                if (SystemTools.checkMinimumApiLevel(11)) {
                    try {
                        cameraCacheInfo.surfaceTexture = new SurfaceTexture(-1);
                        try {
                            cameraCacheInfo.camera.setPreviewTexture(cameraCacheInfo.surfaceTexture);
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        return false;
                    }
                } else if (this.surfaceManager == null) {
                    return false;
                } else {
                    if (!this.surfaceManager.addCameraSurface(cameraCacheInfo)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e3) {
            return false;
        }
    }

    private boolean checkSamsungHighFPS(CameraCacheInfo cameraCacheInfo) {
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if ("true".equalsIgnoreCase(cameraParameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED)) && cameraCacheInfo.requestWidth > 0 && cameraCacheInfo.requestHeight > 0 && cameraParameters.get(SAMSUNG_PARAM_FAST_FPS_MODE) != null && cameraParameters.getInt(SAMSUNG_PARAM_FAST_FPS_MODE) != 0 && !(cameraCacheInfo.requestWidth == cameraParameters.getPreviewSize().width && cameraCacheInfo.requestHeight == cameraParameters.getPreviewSize().height)) {
            DebugLog.LOGW(MODULENAME, "Detected Samsung high fps camera driver bug.");
            DebugLog.LOGW(MODULENAME, "Preview size doesn't match request; width " + cameraCacheInfo.requestWidth + "!=" + cameraParameters.getPreviewSize().width + " or height " + cameraCacheInfo.requestHeight + "!=" + cameraParameters.getPreviewSize().height);
            setCameraPreviewFps(30, cameraParameters);
            cameraParameters.setPreviewSize(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight);
            try {
                cameraCacheInfo.camera.setParameters(cameraParameters);
                cameraParameters = getCameraParameters(cameraCacheInfo.camera);
                if (!(cameraCacheInfo.requestWidth == cameraParameters.getPreviewSize().width && cameraCacheInfo.requestHeight == cameraParameters.getPreviewSize().height)) {
                    DebugLog.LOGE(MODULENAME, "Unable to workaround Samsung high fps camera driver bug.");
                    DebugLog.LOGE(MODULENAME, "Preview size doesn't match request; width " + cameraCacheInfo.requestWidth + "!=" + cameraParameters.getPreviewSize().width + " or height " + cameraCacheInfo.requestHeight + "!=" + cameraParameters.getPreviewSize().height);
                    return false;
                }
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cameraCacheInfo) {
        int i = 0;
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            return false;
        }
        try {
            cameraCacheInfo.bufferWidth = cameraCacheInfo.requestWidth == cameraCacheInfo.overrideWidth ? cameraParameters.getPreviewSize().width : cameraCacheInfo.overrideWidth;
            cameraCacheInfo.bufferHeight = cameraCacheInfo.requestHeight == cameraCacheInfo.overrideHeight ? cameraParameters.getPreviewSize().height : cameraCacheInfo.overrideHeight;
            int previewFormat = cameraCacheInfo.requestFormatAndroid == cameraCacheInfo.overrideFormatAndroid ? cameraParameters.getPreviewFormat() : cameraCacheInfo.overrideFormatAndroid;
            cameraCacheInfo.bufferFormatPL = translateImageFormat(previewFormat, CONVERT_FORMAT_TO_PL);
            try {
                PixelFormat pixelFormat = new PixelFormat();
                PixelFormat.getPixelFormatInfo(previewFormat, pixelFormat);
                previewFormat = pixelFormat.bitsPerPixel;
            } catch (Exception e) {
                previewFormat = getBitsPerPixel(previewFormat);
                if (previewFormat == 0) {
                    return false;
                }
            }
            previewFormat = ((previewFormat * (cameraCacheInfo.bufferWidth * cameraCacheInfo.bufferHeight)) / 8) + 4096;
            if (previewFormat <= cameraCacheInfo.bufferSize) {
                cameraCacheInfo.camera.setPreviewCallbackWithBuffer(this);
                return true;
            }
            cameraCacheInfo.buffer = new byte[2][];
            while (i < 2) {
                cameraCacheInfo.buffer[i] = new byte[previewFormat];
                if (i < 2) {
                    cameraCacheInfo.camera.addCallbackBuffer(cameraCacheInfo.buffer[i]);
                }
                i++;
            }
            cameraCacheInfo.bufferSize = previewFormat;
            cameraCacheInfo.camera.setPreviewCallbackWithBuffer(this);
            System.gc();
            return true;
        } catch (Exception e2) {
            return false;
        }
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

    private int translateImageFormat(int i, boolean z) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < CAMERA_IMAGE_FORMAT_CONVERSIONTABLE.length / 2) {
            if (i != (z == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i3 * 2] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[(i3 * 2) + 1])) {
                i3++;
            } else if (z == CONVERT_FORMAT_TO_PL) {
                return CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[(i3 * 2) + 1];
            } else {
                return CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i3 * 2];
            }
        }
        if (z == CONVERT_FORMAT_TO_PL) {
            i2 = AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
        }
        return i2;
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

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Object obj;
        long nanoTime = System.nanoTime();
        if (SystemTools.checkMinimumApiLevel(18)) {
            obj = this.cameraCacheInfoIndexCache.get(camera);
        } else {
            obj = this.cameraCacheInfoIndexCache.get(camera);
        }
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(intValue);
            if (cameraCacheInfo != null) {
                newFrameAvailable(cameraCacheInfo.deviceHandle, intValue, cameraCacheInfo.bufferWidth, cameraCacheInfo.bufferHeight, cameraCacheInfo.bufferFormatPL, bArr, nanoTime);
                camera.addCallbackBuffer(bArr);
                if (!SystemTools.checkMinimumApiLevel(18)) {
                }
            } else if (!SystemTools.checkMinimumApiLevel(18)) {
            }
        } else if (!SystemTools.checkMinimumApiLevel(18)) {
        }
    }

    public boolean init() {
        this.cameraCacheInfo = new Vector();
        this.cameraCacheInfoIndexCache = new HashMap();
        return true;
    }

    public void setSurfaceManager(SurfaceManager surfaceManager) {
        this.surfaceManager = surfaceManager;
    }

    public int getNumberOfCameras() {
        int i = -1;
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return i;
        } else if (SystemTools.checkMinimumApiLevel(9)) {
            try {
                return Camera.getNumberOfCameras();
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return i;
            }
        } else {
            try {
                if (SystemTools.getActivityFromNative().getPackageManager().hasSystemFeature("android.hardware.camera")) {
                    return 1;
                }
                return 0;
            } catch (Exception e2) {
                SystemTools.setSystemErrorCode(6);
                return i;
            }
        }
    }

    public int getOrientation(int i) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (SystemTools.checkMinimumApiLevel(9)) {
            CameraInfo cameraInfo = new CameraInfo();
            try {
                Camera.getCameraInfo(i, cameraInfo);
                return cameraInfo.orientation;
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        } else {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
    }

    public int getDirection(int i) {
        if (!checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        } else if (!SystemTools.checkMinimumApiLevel(9)) {
            return AR_CAMERA_DIRECTION_BACK;
        } else {
            CameraInfo cameraInfo = new CameraInfo();
            try {
                Camera.getCameraInfo(i, cameraInfo);
                switch (cameraInfo.facing) {
                    case 0:
                        return AR_CAMERA_DIRECTION_BACK;
                    case 1:
                        return AR_CAMERA_DIRECTION_FRONT;
                    default:
                        return AR_CAMERA_DIRECTION_UNKNOWN;
                }
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
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

    public int open(long j, int i, int i2, int i3, String str, int[] iArr, int[] iArr2) {
        if (checkPermission()) {
            int cameraDeviceIndex = getCameraDeviceIndex(i, i2, i3);
            if (cameraDeviceIndex < 0) {
                return -1;
            }
            Object obj;
            int i4;
            CameraCacheInfo cameraCacheInfo = null;
            int size = this.cameraCacheInfo.size();
            int i5 = 0;
            while (i5 < size) {
                cameraCacheInfo = (CameraCacheInfo) this.cameraCacheInfo.get(i5);
                if (cameraCacheInfo.deviceID == cameraDeviceIndex) {
                    break;
                }
                i5++;
            }
            i5 = -1;
            if (i5 < 0) {
                CameraCacheInfo cameraCacheInfo2 = new CameraCacheInfo();
                cameraCacheInfo2.deviceID = cameraDeviceIndex;
                cameraCacheInfo2.deviceHandle = j;
                cameraCacheInfo2.camera = null;
                cameraCacheInfo2.surface = null;
                cameraCacheInfo2.buffer = (byte[][]) null;
                cameraCacheInfo2.overrideWidth = 0;
                cameraCacheInfo2.requestWidth = 0;
                cameraCacheInfo2.bufferWidth = 0;
                cameraCacheInfo2.overrideHeight = 0;
                cameraCacheInfo2.requestHeight = 0;
                cameraCacheInfo2.bufferHeight = 0;
                cameraCacheInfo2.bufferFormatPL = AR_CAMERA_IMAGE_FORMAT_UNKNOWN;
                cameraCacheInfo2.overrideFormatAndroid = 0;
                cameraCacheInfo2.requestFormatAndroid = 0;
                cameraCacheInfo2.caps = null;
                cameraCacheInfo2.status = AR_CAMERA_STATUS_UNINITIALIZED;
                cameraCacheInfo2.isAutoFocusing = false;
                cameraCacheInfo = cameraCacheInfo2;
            }
            cameraCacheInfo.bufferSize = 0;
            size = NUM_MAX_CAMERAOPEN_RETRY;
            Object obj2 = null;
            while (true) {
                try {
                    if (SystemTools.checkMinimumApiLevel(9)) {
                        cameraCacheInfo.camera = Camera.open(cameraCacheInfo.deviceID);
                    } else if (cameraCacheInfo.deviceID == 0) {
                        cameraCacheInfo.camera = Camera.open();
                    }
                    obj = cameraCacheInfo.camera != null ? 1 : null;
                } catch (Exception e) {
                    obj = obj2;
                }
                if (obj == null && size > 0) {
                    try {
                        synchronized (this) {
                            wait(250);
                        }
                    } catch (Exception e2) {
                    }
                }
                if (obj != null) {
                    break;
                }
                i4 = size - 1;
                if (size <= 0) {
                    break;
                }
                size = i4;
                obj2 = obj;
            }
            if (cameraCacheInfo.camera == null) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            obj = ((iArr == null || iArr.length <= 0) && (iArr2 == null || iArr2.length <= 0)) ? null : 1;
            obj2 = (str == null || str.length() <= 0) ? null : 1;
            if (!(obj == null && obj2 == null)) {
                Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
                if (cameraParameters == null) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
                if (obj != null) {
                    if (iArr != null && iArr.length != 5) {
                        SystemTools.setSystemErrorCode(2);
                        return -1;
                    } else if (!setCameraCaptureParams(cameraCacheInfo, cameraParameters, iArr, iArr2)) {
                        SystemTools.setSystemErrorCode(6);
                        return -1;
                    }
                }
                if (obj2 == null || setCustomCameraParams(cameraParameters, str)) {
                    try {
                        cameraCacheInfo.camera.setParameters(cameraParameters);
                        if (!checkSamsungHighFPS(cameraCacheInfo)) {
                            return -1;
                        }
                    } catch (Exception e3) {
                        SystemTools.setSystemErrorCode(6);
                        return -1;
                    }
                }
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
            cameraCacheInfo.status = AR_CAMERA_STATUS_OPENED;
            if (i5 < 0) {
                this.cameraCacheInfo.add(cameraCacheInfo);
                i4 = this.cameraCacheInfo.size() - 1;
            } else {
                i4 = i5;
            }
            this.cameraCacheInfoIndexCache.put(cameraCacheInfo.camera, Integer.valueOf(i4));
            return i4;
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public boolean close(int i) {
        boolean z = false;
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
        } else {
            this.cameraCacheInfoIndexCache.remove(cameraCacheInfo.camera);
            try {
                cameraCacheInfo.camera.release();
                z = true;
            } catch (Exception e) {
            }
            cameraCacheInfo.camera = null;
            cameraCacheInfo.buffer = (byte[][]) null;
            cameraCacheInfo.status = AR_CAMERA_STATUS_UNINITIALIZED;
            System.gc();
        }
        return z;
    }

    public int[] getCameraCapabilities(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        } else if (cameraCacheInfo.caps != null) {
            return cameraCacheInfo.caps;
        } else {
            Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
            if (cameraParameters == null) {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
            int size;
            List supportedPreviewSizes = cameraParameters.getSupportedPreviewSizes();
            List supportedPreviewFrameRates = cameraParameters.getSupportedPreviewFrameRates();
            List supportedPreviewFormats = cameraParameters.getSupportedPreviewFormats();
            List supportedFlashModes = cameraParameters.getSupportedFlashModes();
            List supportedFocusModes = cameraParameters.getSupportedFocusModes();
            int size2 = supportedPreviewSizes != null ? supportedPreviewSizes.size() : 0;
            int size3 = supportedPreviewFrameRates != null ? supportedPreviewFrameRates.size() : 0;
            if (supportedPreviewFormats != null) {
                size = supportedPreviewFormats.size();
            } else {
                size = 0;
            }
            cameraCacheInfo.caps = new int[((((size2 * 2) + 6) + size3) + size)];
            cameraCacheInfo.caps[0] = AR_CAMERA_PARAMTYPE_BASE;
            boolean z = supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false;
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_TORCHMODE, z);
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSMODE, true);
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSVALUE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_FOCUSREGION, SystemTools.checkMinimumApiLevel(14));
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSUREVALUE, SystemTools.checkMinimumApiLevel(8));
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE, SystemTools.checkMinimumApiLevel(8));
            z = SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported();
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ZOOMVALUE, z);
            z = SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported();
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_ZOOMRANGE, z);
            setCameraCapsBit(cameraCacheInfo, 0, AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION, SystemTools.checkMinimumApiLevel(15));
            cameraCacheInfo.caps[1] = AR_CAMERA_PARAMTYPE_BASE;
            z = supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false;
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_TORCHMODE, z);
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_FOCUSMODE, true);
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_FOCUSREGION, SystemTools.checkMinimumApiLevel(14));
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_EXPOSUREVALUE, SystemTools.checkMinimumApiLevel(8));
            z = SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported();
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_ZOOMVALUE, z);
            setCameraCapsBit(cameraCacheInfo, 1, AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION, SystemTools.checkMinimumApiLevel(15));
            cameraCacheInfo.caps[2] = AR_CAMERA_PARAMVALUE_BASE;
            if (supportedFlashModes != null && (supportedFlashModes.contains("torch") || supportedFlashModes.contains("on"))) {
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_TORCHMODE_OFF, true);
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_TORCHMODE_ON, true);
            }
            if (supportedFocusModes != null) {
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_NORMAL, true);
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_AUTO, supportedFocusModes.contains("auto"));
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO, supportedFocusModes.contains("continuous-video"));
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_MACRO, supportedFocusModes.contains("macro"));
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_INFINITY, supportedFocusModes.contains("infinity"));
                setCameraCapsBit(cameraCacheInfo, 2, AR_CAMERA_FOCUSMODE_FIXED, supportedFocusModes.contains("fixed"));
            }
            cameraCacheInfo.caps[3] = size2;
            cameraCacheInfo.caps[4] = size3;
            cameraCacheInfo.caps[5] = size;
            int i2 = 6;
            if (size2 > 0) {
                ListIterator listIterator = supportedPreviewSizes.listIterator();
                size2 = 6;
                while (listIterator.hasNext()) {
                    Size size4 = (Size) listIterator.next();
                    cameraCacheInfo.caps[size2] = size4.width;
                    cameraCacheInfo.caps[size2 + 1] = size4.height;
                    size2 += 2;
                }
                i2 = size2;
            }
            if (size3 > 0) {
                ListIterator listIterator2 = supportedPreviewFrameRates.listIterator();
                size2 = i2;
                while (listIterator2.hasNext()) {
                    cameraCacheInfo.caps[size2] = ((Integer) listIterator2.next()).intValue();
                    size2++;
                }
                i2 = size2;
            }
            if (size > 0) {
                ListIterator listIterator3 = supportedPreviewFormats.listIterator();
                size = i2;
                while (listIterator3.hasNext()) {
                    cameraCacheInfo.caps[size] = translateImageFormat(((Integer) listIterator3.next()).intValue(), true);
                    size++;
                }
            }
            return cameraCacheInfo.caps;
        }
    }

    public boolean setCaptureInfo(int i, int[] iArr, int[] iArr2) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        } else if (iArr.length != 5) {
            SystemTools.setSystemErrorCode(2);
            return false;
        } else {
            Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
            if (cameraParameters == null) {
                SystemTools.setSystemErrorCode(6);
                return false;
            } else if (setCameraCaptureParams(cameraCacheInfo, cameraParameters, iArr, iArr2)) {
                try {
                    cameraCacheInfo.camera.setParameters(cameraParameters);
                    if (checkSamsungHighFPS(cameraCacheInfo)) {
                        return true;
                    }
                    return false;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            } else {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
    }

    public int[] getCaptureInfo(int i) {
        int i2 = 0;
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        try {
            int[] iArr = new int[5];
            iArr[0] = cameraParameters.getPreviewSize().width;
            iArr[1] = cameraParameters.getPreviewSize().height;
            iArr[2] = translateImageFormat(cameraParameters.getPreviewFormat(), CONVERT_FORMAT_TO_PL);
            iArr[3] = cameraParameters.getPreviewFrameRate();
            if (!(cameraCacheInfo.surface == null && cameraCacheInfo.surfaceTexture == null)) {
                i2 = 1;
            }
            iArr[4] = i2;
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
                cameraCacheInfo.camera.startPreview();
                cameraCacheInfo.status = AR_CAMERA_STATUS_CAPTURE_RUNNING;
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
            cameraCacheInfo.camera.stopPreview();
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
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        } else if (!setCustomCameraParams(cameraParameters, str)) {
            return false;
        } else {
            cameraCacheInfo.camera.setParameters(cameraParameters);
            return true;
        }
    }

    boolean setUntypedCameraParameter(int i, String str, String str2) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cameraParameters.set(str, str2);
            cameraCacheInfo.camera.setParameters(cameraParameters);
            return true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    String getUntypedCameraParameter(int i, String str) {
        String str2 = null;
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
        } else {
            Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
            if (cameraParameters == null) {
                SystemTools.setSystemErrorCode(6);
            } else {
                str2 = cameraParameters.get(str);
                if (str2 == null) {
                    SystemTools.setSystemErrorCode(6);
                }
            }
        }
        return str2;
    }

    String getFlattenedParameters(int i) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return "";
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters != null) {
            return cameraParameters.flatten();
        }
        SystemTools.setSystemErrorCode(6);
        return "";
    }

    boolean setTypedCameraParameter(int i, int i2, Object obj) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        Object obj2 = null;
        int intValue;
        switch (i2) {
            case AR_CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                switch (((Number) obj).intValue()) {
                    case AR_CAMERA_TORCHMODE_OFF /*805306369*/:
                        cameraParameters.setFlashMode("off");
                        break;
                    case AR_CAMERA_TORCHMODE_ON /*805306370*/:
                        if (!cameraParameters.getSupportedFlashModes().contains("torch")) {
                            cameraParameters.setFlashMode("on");
                            break;
                        }
                        cameraParameters.setFlashMode("torch");
                        break;
                    case AR_CAMERA_TORCHMODE_AUTO /*805306372*/:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                cameraCacheInfo.camera.cancelAutoFocus();
                switch (((Number) obj).intValue()) {
                    case AR_CAMERA_FOCUSMODE_NORMAL /*805306384*/:
                        if (!cameraParameters.getSupportedFocusModes().contains(FOCUS_MODE_NORMAL)) {
                            cameraParameters.setFocusMode("auto");
                            obj2 = 1;
                            break;
                        }
                        cameraParameters.setFocusMode(FOCUS_MODE_NORMAL);
                        break;
                    case AR_CAMERA_FOCUSMODE_AUTO /*805306400*/:
                        cameraParameters.setFocusMode("auto");
                        obj2 = 1;
                        break;
                    case AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO /*805306432*/:
                        if (cameraParameters.getSupportedFocusModes().contains("continuous-video")) {
                            cameraParameters.setFocusMode("continuous-video");
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    case AR_CAMERA_FOCUSMODE_MACRO /*805306496*/:
                        cameraParameters.setFocusMode("macro");
                        break;
                    case AR_CAMERA_FOCUSMODE_INFINITY /*805306624*/:
                        cameraParameters.setFocusMode("infinity");
                        break;
                    case AR_CAMERA_FOCUSMODE_FIXED /*805306880*/:
                        cameraParameters.setFocusMode("fixed");
                        break;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                if (SystemTools.checkMinimumApiLevel(14)) {
                    float[] fArr = (float[]) obj;
                    if (fArr.length == 5) {
                        if (fArr[0] >= 0.0f && fArr[0] <= 1.0f && fArr[1] >= 0.0f && fArr[1] <= 1.0f && fArr[2] >= 0.0f && fArr[2] <= 1.0f && fArr[3] >= 0.0f && fArr[3] <= 1.0f && fArr[4] >= 0.0f && fArr[4] <= 1.0f) {
                            Rect rect = new Rect(((int) (((double) fArr[0]) * 2000.0d)) - 1000, ((int) (((double) fArr[1]) * 2000.0d)) - 1000, ((int) (((double) fArr[2]) * 2000.0d)) - 1000, ((int) (((double) fArr[3]) * 2000.0d)) - 1000);
                            List arrayList = new ArrayList();
                            arrayList.add(new Area(rect, (int) (((double) fArr[4]) * 1000.0d)));
                            if (cameraParameters.getMaxNumFocusAreas() > 0) {
                                cameraParameters.setFocusAreas(arrayList);
                                break;
                            }
                        }
                        SystemTools.setSystemErrorCode(2);
                        return false;
                    }
                    SystemTools.setSystemErrorCode(2);
                    return false;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
                break;
            case AR_CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                switch (((Number) obj).intValue()) {
                    case AR_CAMERA_EXPOSUREMODE_LOCKED /*805310464*/:
                        if (cameraParameters.isAutoExposureLockSupported()) {
                            cameraParameters.setAutoExposureLock(true);
                            break;
                        }
                        break;
                    case AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO /*805322752*/:
                        if (cameraParameters.isAutoExposureLockSupported()) {
                            cameraParameters.setAutoExposureLock(false);
                            break;
                        }
                        break;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_ISO /*536870976*/:
                try {
                    String num = Integer.toString(((Number) obj).intValue());
                    String str = cameraParameters.get("iso-values");
                    if (str != null) {
                        String[] split = str.split(",");
                        int i3 = 0;
                        while (i3 < split.length) {
                            if (split[i3].toLowerCase().contains(num.toLowerCase())) {
                                num = split[i3];
                            } else {
                                i3++;
                            }
                        }
                    }
                    cameraParameters.set("iso", num);
                    break;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUE /*536871936*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    float floatValue = ((Number) obj).floatValue();
                    float exposureCompensationStep = cameraParameters.getExposureCompensationStep();
                    if (exposureCompensationStep != 0.0f) {
                        cameraParameters.setExposureCompensation(Math.round(floatValue / exposureCompensationStep));
                        break;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE /*536872960*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE /*536875008*/:
                intValue = ((Number) obj).intValue();
                switch (intValue) {
                    case AR_CAMERA_WHITEBALANCEMODE_LOCKED /*806354944*/:
                        if (cameraParameters.isAutoWhiteBalanceLockSupported()) {
                            cameraParameters.setAutoWhiteBalanceLock(true);
                            break;
                        }
                        break;
                    case AR_CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO /*809500672*/:
                        if (cameraParameters.isAutoWhiteBalanceLockSupported()) {
                            cameraParameters.setAutoWhiteBalanceLock(false);
                            break;
                        }
                        break;
                    default:
                        SystemTools.setSystemErrorCode(3);
                        SystemTools.logSystemError("Cannot set unknown white balance mode (" + intValue + ")");
                        return false;
                }
            case AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE /*536879104*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE /*536887296*/:
                SystemTools.setSystemErrorCode(6);
                return false;
            case AR_CAMERA_PARAMTYPE_ZOOMVALUE /*536903680*/:
                if (SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported()) {
                    cameraParameters.setZoom(((Number) obj).intValue());
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return false;
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
                intValue = ((Number) obj).intValue();
                if (!SystemTools.checkMinimumApiLevel(14)) {
                    cameraParameters.set("recording-hint", intValue != 0 ? "true" : "false");
                    break;
                }
                boolean z;
                if (intValue != 0) {
                    z = true;
                } else {
                    z = false;
                }
                cameraParameters.setRecordingHint(z);
                break;
            case AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION /*553648128*/:
                if (!((Boolean) obj).booleanValue()) {
                    cameraParameters.setVideoStabilization(false);
                    break;
                }
                cameraParameters.setVideoStabilization(true);
                break;
            default:
                return false;
        }
        try {
            cameraCacheInfo.camera.setParameters(cameraParameters);
            if (obj2 != null) {
                switch (i2) {
                    case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                        try {
                            cameraCacheInfo.isAutoFocusing = true;
                            cameraCacheInfo.camera.autoFocus(new C00681());
                            break;
                        } catch (Exception e2) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                }
            }
            return true;
        } catch (Exception e3) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    Object getTypedCameraParameter(int i, int i2) {
        CameraCacheInfo cameraCacheInfo = getCameraCacheInfo(i);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Parameters cameraParameters = getCameraParameters(cameraCacheInfo.camera);
        if (cameraParameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        switch (i2) {
            case AR_CAMERA_PARAMTYPE_TORCHMODE /*536870913*/:
                try {
                    String flashMode = cameraParameters.getFlashMode();
                    if (flashMode.equals("torch") || flashMode.equals("on")) {
                        return Integer.valueOf(AR_CAMERA_TORCHMODE_ON);
                    }
                    if (flashMode.equals("off")) {
                        return Integer.valueOf(AR_CAMERA_TORCHMODE_OFF);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSMODE /*536870914*/:
                String focusMode = cameraParameters.getFocusMode();
                if (focusMode.equals("auto")) {
                    return Integer.valueOf(cameraCacheInfo.isAutoFocusing ? AR_CAMERA_FOCUSMODE_AUTO : AR_CAMERA_FOCUSMODE_NORMAL);
                } else if (focusMode.equals("continuous-video")) {
                    return Integer.valueOf(AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO);
                } else {
                    if (focusMode.equals("infinity")) {
                        return Integer.valueOf(AR_CAMERA_FOCUSMODE_INFINITY);
                    }
                    if (focusMode.equals("macro")) {
                        return Integer.valueOf(AR_CAMERA_FOCUSMODE_MACRO);
                    }
                    if (focusMode.equals("fixed")) {
                        return Integer.valueOf(AR_CAMERA_FOCUSMODE_FIXED);
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
            case AR_CAMERA_PARAMTYPE_FOCUSVALUE /*536870916*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    return Float.valueOf(cameraParameters.getFocalLength());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_FOCUSRANGE /*536870920*/:
                if (SystemTools.checkMinimumApiLevel(9)) {
                    r3 = new float[3];
                    cameraParameters.getFocusDistances(r3);
                    return new float[]{r3[0], r3[2]};
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_FOCUSREGION /*536870928*/:
                if (SystemTools.checkMinimumApiLevel(14) && cameraParameters.getMaxNumFocusAreas() > 0) {
                    List focusAreas = cameraParameters.getFocusAreas();
                    if (focusAreas.size() > 0) {
                        Area area = (Area) focusAreas.get(0);
                        return new float[]{(float) area.rect.left, (float) area.rect.top, (float) area.rect.right, (float) area.rect.bottom, (float) area.weight};
                    }
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_EXPOSUREMODE /*536870944*/:
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUE /*536871936*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    return Float.valueOf(cameraParameters.getExposureCompensationStep() * ((float) cameraParameters.getExposureCompensation()));
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE /*536872960*/:
                if (SystemTools.checkMinimumApiLevel(8)) {
                    Object obj = new float[2];
                    obj[0] = cameraParameters.getExposureCompensationStep() * ((float) cameraParameters.getMinExposureCompensation());
                    obj[1] = ((float) cameraParameters.getMaxExposureCompensation()) * cameraParameters.getExposureCompensationStep();
                    return obj;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
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
                if (SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported()) {
                    return Integer.valueOf(cameraParameters.getZoom());
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_ZOOMRANGE /*536936448*/:
                if (SystemTools.checkMinimumApiLevel(8) && cameraParameters.isZoomSupported()) {
                    return new int[]{null, cameraParameters.getMaxZoom()};
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE /*537001984*/:
                SystemTools.setSystemErrorCode(6);
                return null;
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
                if (cameraParameters.getVideoStabilization()) {
                    return Boolean.valueOf(true);
                }
                return Boolean.valueOf(false);
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
