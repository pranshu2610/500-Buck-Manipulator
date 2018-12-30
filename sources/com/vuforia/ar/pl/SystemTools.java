package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class SystemTools {
    public static final int AR_DEVICE_ORIENTATION_0 = 268455954;
    public static final int AR_DEVICE_ORIENTATION_180 = 268455955;
    public static final int AR_DEVICE_ORIENTATION_270 = 268455957;
    public static final int AR_DEVICE_ORIENTATION_90 = 268455956;
    public static final int AR_DEVICE_ORIENTATION_UNKNOWN = 268455952;
    public static final int AR_ERROR_INVALID_ENUM = 3;
    public static final int AR_ERROR_INVALID_HANDLE = 4;
    public static final int AR_ERROR_INVALID_OPERATION = 5;
    public static final int AR_ERROR_INVALID_VALUE = 2;
    public static final int AR_ERROR_NONE = 0;
    public static final int AR_ERROR_OPERATION_CANCELED = 7;
    public static final int AR_ERROR_OPERATION_FAILED = 6;
    public static final int AR_ERROR_OPERATION_TIMEOUT = 8;
    public static final int AR_ERROR_UNKNOWN = 1;
    public static final int AR_RENDERING_TEXTURE_ROTATION_AUTO = 268455953;
    public static final int AR_RENDERING_TEXTURE_ROTATION_LANDSCAPE_LEFT = 268455956;
    public static final int AR_RENDERING_TEXTURE_ROTATION_LANDSCAPE_RIGHT = 268455957;
    public static final int AR_RENDERING_TEXTURE_ROTATION_PORTRAIT = 268455954;
    public static final int AR_RENDERING_TEXTURE_ROTATION_PORTRAIT_UPSIDEDOWN = 268455955;
    public static final int AR_VIDEOTEXTURE_ROTATION_UNKNOWN = 268455952;
    private static final String MODULENAME = "SystemTools";

    public static native Activity getActivityFromNative();

    public static native void logSystemError(String str);

    public static native void setSystemErrorCode(int i);

    public static boolean checkMinimumApiLevel(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static void sendKillSignal(final int i) {
        final Activity activityFromNative = getActivityFromNative();
        if (activityFromNative != null) {
            activityFromNative.runOnUiThread(new Runnable() {
                public void run() {
                    activityFromNative.setResult(i);
                    activityFromNative.finish();
                }
            });
        }
    }

    public static Method retrieveClassMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Exception e) {
        }
        return method != null ? method : method;
    }

    public static int getDeviceOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        int rotation;
        activity.getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (checkMinimumApiLevel(8)) {
            rotation = defaultDisplay.getRotation();
        } else {
            rotation = defaultDisplay.getOrientation();
        }
        rotation = rotation == 0 ? 268455954 : rotation == 1 ? 268455956 : rotation == 2 ? 268455955 : rotation == 3 ? 268455957 : 268455952;
        return rotation;
    }

    public static int getActivityOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        int rotation;
        Configuration configuration = activity.getResources().getConfiguration();
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (checkMinimumApiLevel(8)) {
            rotation = defaultDisplay.getRotation();
        } else {
            rotation = defaultDisplay.getOrientation();
        }
        switch (configuration.orientation) {
            case 1:
            case 3:
                if (rotation != 0 && rotation != 3) {
                    rotation = 268455955;
                    break;
                }
                rotation = 268455954;
                break;
                break;
            case 2:
                if (rotation != 0 && rotation != 1) {
                    rotation = 268455957;
                    break;
                }
                rotation = 268455956;
                break;
                break;
            default:
                rotation = 268455952;
                break;
        }
        return rotation;
    }

    public static String getNativeLibraryPath(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            String str;
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            if (applicationInfo == null) {
                str = null;
            } else if (checkMinimumApiLevel(9)) {
                str = applicationInfo.nativeLibraryDir;
                if (!(str == null || str.length() <= 0 || str.charAt(str.length() - 1) == '/')) {
                    str = str + '/';
                }
            } else {
                str = "/data/data/" + activity.getPackageName() + "/lib/";
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static int[] getActivitySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new int[]{i, i2};
    }

    public static float[] getDisplayDpi(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (checkMinimumApiLevel(17)) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f = displayMetrics.xdpi;
        float f2 = displayMetrics.ydpi;
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        return new float[]{f, f2};
    }

    public static int[] getDisplaySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        Point point = new Point();
        try {
            activity.getWindowManager().getDefaultDisplay().getRealSize(point);
            if (point.x <= 0 || point.y <= 0) {
                return null;
            }
            int[] iArr = new int[2];
            if (point.y > point.x) {
                iArr[0] = point.y;
                iArr[1] = point.x;
            } else {
                iArr[0] = point.x;
                iArr[1] = point.y;
            }
            return iArr;
        } catch (NoSuchMethodError e) {
            DebugLog.LOGE(MODULENAME, "Display.getRealSize is not supported on this platform");
            return null;
        }
    }
}
