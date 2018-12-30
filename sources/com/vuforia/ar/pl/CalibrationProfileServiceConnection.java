package com.vuforia.ar.pl;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.vuforia.eyewear.Calibration.service.ICalibrationProfileService;
import com.vuforia.eyewear.Calibration.service.ICalibrationProfileService.Stub;
import java.nio.charset.Charset;

public class CalibrationProfileServiceConnection {
    private static final ComponentName CPS_COMPONENT_NAME = new ComponentName("com.vuforia.eyewear.Calibration", "com.vuforia.eyewear.Calibration.service.CalibrationProfileService");
    private static final String SUBTAG = "CalibrationProfileServiceConn";
    private VuforiaServiceConnection mConnection = new VuforiaServiceConnection();

    public boolean bind(Context context) {
        if (context != null) {
            return this.mConnection.bindService(context, CPS_COMPONENT_NAME);
        }
        DebugLog.LOGD(SUBTAG, "Activity is null");
        return false;
    }

    public boolean unbind(Context context) {
        if (context != null) {
            return this.mConnection.unbindService(context);
        }
        DebugLog.LOGD(SUBTAG, "Activity is null");
        return false;
    }

    public ICalibrationProfileService getCalibrationProfileClient() {
        IBinder awaitService = this.mConnection.awaitService();
        if (awaitService != null) {
            return Stub.asInterface(awaitService);
        }
        DebugLog.LOGD(SUBTAG, "getCalibrationProfileClient IBinder is null; returning null");
        return null;
    }

    int getMaxProfileCount() {
        try {
            return getCalibrationProfileClient().getMaxProfileCount();
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getMaxProfileCount; Remote Exception" + e.getCause());
            return 0;
        }
    }

    int getUsedProfileCount() {
        try {
            return getCalibrationProfileClient().getUsedProfileCount();
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getUsedProfileCount; Remote Exception" + e.getCause());
            return 0;
        }
    }

    boolean isProfileUsed(int i) {
        try {
            return getCalibrationProfileClient().isProfileUsed(i);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "isProfileUsed; Remote Exception" + e.getCause());
            return false;
        }
    }

    int getActiveProfile() {
        try {
            return getCalibrationProfileClient().getActiveProfile();
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getActiveProfile; Remote Exception" + e.getCause());
            return 0;
        }
    }

    boolean setActiveProfile(int i) {
        try {
            return getCalibrationProfileClient().setActiveProfile(i);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "setActiveProfile; Remote Exception" + e.getCause());
            return false;
        }
    }

    byte[] getProfileName(int i) {
        try {
            return getCalibrationProfileClient().getProfileName(i).getBytes(Charset.forName("UTF-16LE"));
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getProfileName; Remote Exception" + e.getCause());
            return null;
        }
    }

    boolean setProfileName(int i, byte[] bArr) {
        try {
            return getCalibrationProfileClient().setProfileName(i, new String(bArr, Charset.forName("UTF-16LE")));
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "setProfileName; Remote Exception" + e.getCause());
            return false;
        }
    }

    float[] getCameraToEyePose(int i, int i2) {
        try {
            return getCalibrationProfileClient().getCameraToEyePose(i, i2);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getCameraToEyePose; Remote Exception" + e.getCause());
            return null;
        }
    }

    float[] getEyeProjection(int i, int i2) {
        try {
            return getCalibrationProfileClient().getEyeProjection(i, i2);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "getEyeProjection; Remote Exception" + e.getCause());
            return null;
        }
    }

    boolean setCameraToEyePose(int i, int i2, float[] fArr) {
        try {
            return getCalibrationProfileClient().setCameraToEyePose(i, i2, fArr);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "setCameraToEyePose; Remote Exception" + e.getCause());
            return false;
        }
    }

    boolean setEyeProjection(int i, int i2, float[] fArr) {
        try {
            return getCalibrationProfileClient().setEyeProjection(i, i2, fArr);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "setEyeProjection; Remote Exception" + e.getCause());
            return false;
        }
    }

    boolean clearProfile(int i) {
        try {
            return getCalibrationProfileClient().clearProfile(i);
        } catch (RemoteException e) {
            DebugLog.LOGD(SUBTAG, "clearProfile; Remote Exception" + e.getCause());
            return false;
        }
    }
}
