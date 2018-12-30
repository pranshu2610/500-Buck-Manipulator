package com.vuforia.VuforiaUnityPlayer;

import android.app.Activity;
import com.vuforia.Vuforia;

public class VuforiaInitializer {
    private static final String NATIVE_LIB_UNITYPLAYER = "VuforiaUnityPlayer";
    private static final String NATIVE_LIB_VUFORIA = "Vuforia";
    private static final String NATIVE_LIB_VUFORIAWRAPPER = "VuforiaWrapper";

    private static native void initPlatformNative();

    public static void loadNativeLibraries() {
        loadLibrary(NATIVE_LIB_VUFORIA);
        loadLibrary(NATIVE_LIB_VUFORIAWRAPPER);
        loadLibrary(NATIVE_LIB_UNITYPLAYER);
    }

    public static void initPlatform() {
        initPlatformNative();
    }

    public static int initVuforia(Activity activity, int graphicsAPI, String licenseKey) {
        int progressValue;
        DebugLog.LOGD("Initializing Vuforia...");
        Vuforia.setInitParameters(activity, graphicsAPI, licenseKey);
        Vuforia.setHint(-858996736, 1747626);
        do {
            progressValue = Vuforia.init();
            if (progressValue < 0) {
                break;
            }
        } while (progressValue < 100);
        if (progressValue >= 0) {
            return 0;
        }
        DebugLog.LOGE("Vuforia initialization failed");
        return progressValue;
    }

    private static boolean loadLibrary(String nLibName) {
        try {
            System.loadLibrary(nLibName);
            return true;
        } catch (UnsatisfiedLinkError ulee) {
            DebugLog.LOGE("The library lib" + nLibName + ".so could not be loaded: " + ulee.toString());
            return false;
        } catch (SecurityException e) {
            DebugLog.LOGE("The library lib" + nLibName + ".so was not allowed to be loaded");
            return false;
        }
    }
}
