package com.vuforia.ar.pl;

import android.app.Activity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.InvocationTargetException;

public class EpsonBT200Controller {
    private static final String MODULENAME = "EpsonBT200Controller";
    private boolean stereoEnabled = false;

    public EpsonBT200Controller() {
        final Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative != null) {
            activityFromNative.runOnUiThread(new Runnable() {
                public void run() {
                    Window window = activityFromNative.getWindow();
                    LayoutParams attributes = window.getAttributes();
                    attributes.flags |= Integer.MIN_VALUE;
                    window.setAttributes(attributes);
                }
            });
        }
    }

    public boolean setStereo(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        try {
            Activity activityFromNative = SystemTools.getActivityFromNative();
            if (activityFromNative == null) {
                return false;
            }
            Display defaultDisplay = ((WindowManager) activityFromNative.getSystemService("window")).getDefaultDisplay();
            boolean booleanValue = ((Boolean) Display.class.getDeclaredMethod("setDisplayMode", new Class[]{Integer.TYPE}).invoke(defaultDisplay, new Object[]{Integer.valueOf(i)})).booleanValue();
            if (!booleanValue) {
                return booleanValue;
            }
            this.stereoEnabled = z;
            return booleanValue;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (IllegalAccessException e2) {
            return false;
        } catch (InvocationTargetException e3) {
            return false;
        }
    }

    public boolean getStereo() {
        return this.stereoEnabled;
    }
}
