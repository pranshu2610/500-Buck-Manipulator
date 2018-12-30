package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import java.io.File;

public class FileTools {
    private static final int FILE_PATHTYPEINDEX_ABSOLUTE = -1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_ASSETS = 0;
    private static final int FILE_PATHTYPEINDEX_ANDROID_DATALOCAL = 4;
    private static final int FILE_PATHTYPEINDEX_ANDROID_MEDIASTORAGE = 3;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPCACHE = 2;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPSTORAGE = 1;
    private static final String MODULENAME = "FileTools";

    public static String getAbsolutePath(int i, String str) {
        String absolutePath;
        Activity activityFromNative;
        File filesDir;
        switch (i) {
            case 1:
                activityFromNative = SystemTools.getActivityFromNative();
                if (activityFromNative != null) {
                    filesDir = activityFromNative.getFilesDir();
                    if (filesDir != null) {
                        absolutePath = filesDir.getAbsolutePath();
                        break;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case 2:
                activityFromNative = SystemTools.getActivityFromNative();
                if (activityFromNative != null) {
                    filesDir = activityFromNative.getCacheDir();
                    if (filesDir != null) {
                        absolutePath = filesDir.getAbsolutePath();
                        break;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            case 3:
                filesDir = Environment.getExternalStorageDirectory();
                if (filesDir != null) {
                    absolutePath = filesDir.getAbsolutePath();
                    break;
                }
                SystemTools.setSystemErrorCode(6);
                return null;
            default:
                SystemTools.setSystemErrorCode(6);
                return null;
        }
        if (absolutePath == null || str == null) {
            return absolutePath;
        }
        if (absolutePath.length() > 0 && absolutePath.charAt(absolutePath.length() - 1) != '/') {
            absolutePath = absolutePath + "/";
        }
        return absolutePath + str;
    }

    public static boolean mediastorage_isAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static AssetManager get_assetmanager() {
        Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative != null) {
            return activityFromNative.getAssets();
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }
}
