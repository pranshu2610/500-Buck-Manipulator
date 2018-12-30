package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.a */
public final class C0035a {
    /* renamed from: b */
    private static CameraManager f112b = null;
    /* renamed from: c */
    private static String[] f113c = null;
    /* renamed from: e */
    private static Semaphore f114e = new Semaphore(1);
    /* renamed from: a */
    private C0041d f115a = null;
    /* renamed from: d */
    private CameraDevice f116d;
    /* renamed from: f */
    private HandlerThread f117f;
    /* renamed from: g */
    private Handler f118g;
    /* renamed from: h */
    private Rect f119h;
    /* renamed from: i */
    private Range f120i;
    /* renamed from: j */
    private ImageReader f121j;
    /* renamed from: k */
    private Builder f122k;
    /* renamed from: l */
    private CameraCaptureSession f123l;
    /* renamed from: m */
    private final StateCallback f124m = new C00322(this);
    /* renamed from: n */
    private final OnImageAvailableListener f125n = new C00333(this);
    /* renamed from: o */
    private CaptureCallback f126o = new C00344(this);

    /* renamed from: com.unity3d.player.a$1 */
    class C00311 extends CameraCaptureSession.StateCallback {
        /* renamed from: a */
        final /* synthetic */ C0035a f108a;

        C00311(C0035a c0035a) {
            this.f108a = c0035a;
        }

        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            C0044g.Log(6, "Camera2: CaptureSession configuration failed.");
        }

        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            C0044g.Log(4, "Camera2: CaptureSession is configured.");
            if (this.f108a.f116d != null) {
                this.f108a.f123l = cameraCaptureSession;
                try {
                    this.f108a.f122k = this.f108a.f116d.createCaptureRequest(1);
                    this.f108a.f122k.addTarget(this.f108a.f121j.getSurface());
                    this.f108a.f122k.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                    this.f108a.f122k.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.f108a.f120i);
                    this.f108a.f123l.setRepeatingRequest(this.f108a.f122k.build(), this.f108a.f126o, this.f108a.f118g);
                } catch (CameraAccessException e) {
                    C0044g.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* renamed from: com.unity3d.player.a$2 */
    class C00322 extends StateCallback {
        /* renamed from: a */
        final /* synthetic */ C0035a f109a;

        C00322(C0035a c0035a) {
            this.f109a = c0035a;
        }

        public final void onClosed(CameraDevice cameraDevice) {
            C0044g.Log(4, "Camera2: CameraDevice closed.");
            C0035a.f114e.release();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            this.f109a.f116d = null;
            C0044g.Log(5, "Camera2: CameraDevice disconnected.");
            C0035a.f114e.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            this.f109a.f116d = null;
            C0044g.Log(6, "Camera2: Error opeining CameraDevice " + i);
            C0035a.f114e.release();
        }

        public final void onOpened(CameraDevice cameraDevice) {
            this.f109a.f116d = cameraDevice;
            C0044g.Log(4, "Camera2: CameraDevice opened.");
            C0035a.f114e.release();
        }
    }

    /* renamed from: com.unity3d.player.a$3 */
    class C00333 implements OnImageAvailableListener {
        /* renamed from: a */
        final /* synthetic */ C0035a f110a;

        C00333(C0035a c0035a) {
            this.f110a = c0035a;
        }

        public final void onImageAvailable(ImageReader imageReader) {
            if (C0035a.f114e.tryAcquire()) {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                if (acquireLatestImage != null) {
                    Plane[] planes = acquireLatestImage.getPlanes();
                    if (acquireLatestImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        this.f110a.f115a.mo1a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        C0044g.Log(6, "Camera2: Wrong image format.");
                    }
                    acquireLatestImage.close();
                }
                C0035a.f114e.release();
            }
        }
    }

    /* renamed from: com.unity3d.player.a$4 */
    class C00344 extends CaptureCallback {
        /* renamed from: a */
        final /* synthetic */ C0035a f111a;

        C00344(C0035a c0035a) {
            this.f111a = c0035a;
        }

        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            C0044g.Log(5, "Camera2: Capture session failed " + captureFailure.getReason());
        }

        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            C0044g.Log(4, "Camera2: Capture sequence aborted.");
        }

        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            C0044g.Log(4, "Camera2: Capture sequence completed.");
        }
    }

    protected C0035a(C0041d c0041d) {
        this.f115a = c0041d;
        m44f();
    }

    /* renamed from: a */
    public static int m27a(Context context) {
        return C0035a.m39c(context).length;
    }

    /* renamed from: a */
    public static int m28a(Context context, int i) {
        try {
            return ((Integer) C0035a.m35b(context).getCameraCharacteristics(C0035a.m39c(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            C0044g.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    /* renamed from: a */
    private static Rect m29a(Size[] sizeArr, double d, double d2) {
        int i = 0;
        int i2 = 0;
        double d3 = Double.MAX_VALUE;
        for (int i3 = 0; i3 < sizeArr.length; i3++) {
            int width = sizeArr[i3].getWidth();
            int height = sizeArr[i3].getHeight();
            double abs = Math.abs(Math.log(d / ((double) width))) + Math.abs(Math.log(d2 / ((double) height)));
            if (abs < d3) {
                d3 = abs;
                i2 = height;
                i = width;
            }
            C0044g.Log(4, "Camera2: FrameSize " + width + " x " + height + " [" + abs + "]");
        }
        return new Rect(0, 0, i, i2);
    }

    /* renamed from: a */
    private static Range m34a(Range[] rangeArr, double d) {
        double d2 = Double.MAX_VALUE;
        int i = -1;
        for (int i2 = 0; i2 < rangeArr.length; i2++) {
            int intValue = ((Integer) rangeArr[i2].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i2].getUpper()).intValue();
            double abs = Math.abs(Math.log(d / ((double) intValue))) + Math.abs(Math.log(d / ((double) intValue2)));
            if (abs < d2) {
                d2 = abs;
                i = i2;
            }
            C0044g.Log(4, "Camera2: Frame rate[" + i2 + "] = " + intValue + "-" + intValue2 + " [" + abs + "]");
        }
        return rangeArr[i];
    }

    /* renamed from: b */
    private static CameraManager m35b(Context context) {
        if (f112b == null) {
            f112b = (CameraManager) context.getSystemService("camera");
        }
        return f112b;
    }

    /* renamed from: b */
    public static boolean m37b(Context context, int i) {
        try {
            return ((Integer) C0035a.m35b(context).getCameraCharacteristics(C0035a.m39c(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            C0044g.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: c */
    private static String[] m39c(Context context) {
        if (f113c == null) {
            try {
                f113c = C0035a.m35b(context).getCameraIdList();
            } catch (CameraAccessException e) {
                C0044g.Log(6, "Camera2: CameraAccessException " + e);
                f113c = new String[0];
            }
        }
        return f113c;
    }

    /* renamed from: f */
    private void m44f() {
        this.f117f = new HandlerThread("CameraBackground");
        this.f117f.start();
        this.f118g = new Handler(this.f117f.getLooper());
    }

    /* renamed from: g */
    private void m46g() {
        this.f117f.quit();
        try {
            this.f117f.join(4000);
            this.f117f = null;
            this.f118g = null;
        } catch (InterruptedException e) {
            this.f117f.interrupt();
            C0044g.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    /* renamed from: h */
    private void m48h() {
        try {
            if (f114e.tryAcquire(4, TimeUnit.SECONDS)) {
                this.f116d.close();
                try {
                    if (!f114e.tryAcquire(4, TimeUnit.SECONDS)) {
                        C0044g.Log(5, "Camera2: Timeout waiting to close camera.");
                    }
                } catch (InterruptedException e) {
                    C0044g.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
                }
                f114e.release();
                return;
            }
            C0044g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
        } catch (InterruptedException e2) {
            C0044g.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* renamed from: a */
    public final Rect m49a() {
        return this.f119h;
    }

    /* renamed from: a */
    public final boolean m50a(Context context, int i, int i2, int i3, int i4) {
        try {
            CameraCharacteristics cameraCharacteristics = f112b.getCameraCharacteristics(C0035a.m39c(context)[i]);
            C0044g.Log(4, "Camera2: Hardware level: " + cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL));
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                C0044g.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                C0044g.Log(6, "Camera2: configuration map is not available.");
                return false;
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes == null || outputSizes.length == 0) {
                C0044g.Log(6, "Camera2: output sizes for YUV_420_888 format are not avialable.");
                return false;
            }
            this.f119h = C0035a.m29a(outputSizes, (double) i2, (double) i3);
            Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                C0044g.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            this.f120i = C0035a.m34a(rangeArr, (double) i4);
            try {
                if (f114e.tryAcquire(4, TimeUnit.SECONDS)) {
                    try {
                        f112b.openCamera(C0035a.m39c(context)[i], this.f124m, this.f118g);
                        try {
                            if (f114e.tryAcquire(4, TimeUnit.SECONDS)) {
                                f114e.release();
                                return this.f116d != null;
                            } else {
                                C0044g.Log(5, "Camera2: Timeout waiting to open camera.");
                                return false;
                            }
                        } catch (InterruptedException e) {
                            C0044g.Log(6, "Camera2: Interrupted while waiting to open camera " + e);
                        }
                    } catch (CameraAccessException e2) {
                        C0044g.Log(6, "Camera2: CameraAccessException " + e2);
                        f114e.release();
                        return false;
                    }
                }
                C0044g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                return false;
            } catch (InterruptedException e3) {
                C0044g.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                return false;
            }
        } catch (CameraAccessException e22) {
            C0044g.Log(6, "Camera2: CameraAccessException " + e22);
            return false;
        }
    }

    /* renamed from: b */
    public final void m51b() {
        C0044g.Log(4, "Camera2: Close.");
        if (this.f116d != null) {
            m53d();
            m48h();
            this.f116d = null;
            this.f121j.close();
            this.f121j = null;
        }
        m46g();
    }

    /* renamed from: c */
    public final void m52c() {
        C0044g.Log(4, "Camera2: Start preview.");
        if (this.f121j == null) {
            this.f121j = ImageReader.newInstance(this.f119h.width(), this.f119h.height(), 35, 2);
            this.f121j.setOnImageAvailableListener(this.f125n, this.f118g);
        }
        try {
            this.f116d.createCaptureSession(Arrays.asList(new Surface[]{this.f121j.getSurface()}), new C00311(this), this.f118g);
        } catch (CameraAccessException e) {
            C0044g.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: d */
    public final void m53d() {
        C0044g.Log(4, "Camera2: Stop preview.");
        if (this.f123l != null) {
            try {
                this.f123l.abortCaptures();
            } catch (CameraAccessException e) {
                C0044g.Log(6, "Camera2: CameraAccessException " + e);
            }
            this.f123l.close();
            this.f123l = null;
        }
    }
}
