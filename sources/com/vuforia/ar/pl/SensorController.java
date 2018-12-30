package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Vector;

public class SensorController extends HandlerThread implements SensorEventListener {
    private static final int AR_SENSOR_CONFIDENCE_HIGH = 4;
    private static final int AR_SENSOR_CONFIDENCE_LOW = 2;
    private static final int AR_SENSOR_CONFIDENCE_MEDIUM = 3;
    private static final int AR_SENSOR_CONFIDENCE_UNKNOWN = 0;
    private static final int AR_SENSOR_CONFIDENCE_UNRELIABLE = 1;
    private static int AR_SENSOR_INDEX_DONTCARE = -1;
    private static final int AR_SENSOR_PARAMTYPE_ACCURACY = -2147483640;
    private static final int AR_SENSOR_PARAMTYPE_BASE = Integer.MIN_VALUE;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MAX = -2147483646;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MIN = -2147483647;
    private static final int AR_SENSOR_PARAMTYPE_RESOLUTION = -2147483644;
    private static final int AR_SENSOR_PARAMTYPE_SENSITIVITY = -2147483632;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL = -2147483616;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ABSTRACT = -2147483584;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ENFORCED = -2147483392;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_MIN = -2147483520;
    private static final int AR_SENSOR_STATUS_IDLE = 1342242818;
    private static final int AR_SENSOR_STATUS_RUNNING = 1342242819;
    private static final int AR_SENSOR_STATUS_UNINITIALIZED = 1342242817;
    private static final int AR_SENSOR_STATUS_UNKNOWN = 1342242816;
    private static final int AR_SENSOR_TYPE_ACCELEROMETER = 1342177282;
    private static final int AR_SENSOR_TYPE_AMBIENT_LIGHT = 1342177286;
    private static final int AR_SENSOR_TYPE_DEVICE_ROTATION = 1342177288;
    private static final int AR_SENSOR_TYPE_GYROSCOPE = 1342177281;
    private static final int AR_SENSOR_TYPE_MAGNETOMETER = 1342177283;
    private static final int AR_SENSOR_TYPE_PROXIMITY = 1342177285;
    private static final int AR_SENSOR_TYPE_UNKNOWN = 1342177280;
    private static final int AR_SENSOR_UPDATEINTERVAL_HIGHESTRATE = 4;
    private static final int AR_SENSOR_UPDATEINTERVAL_HIGHRATE = 3;
    private static final int AR_SENSOR_UPDATEINTERVAL_LOWRATE = 1;
    private static final int AR_SENSOR_UPDATEINTERVAL_MEDIUMRATE = 2;
    private static final int AR_SENSOR_UPDATEINTERVAL_UNKNOWN = 0;
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static final String MODULENAME = "SensorController";
    private static final int SENSORINFO_VALUE_ANDROIDSENSORTYPE = 1;
    private static final int SENSORINFO_VALUE_ISDEFAULT = 2;
    private static final int SENSORINFO_VALUE_PLSENSORTYPE = 0;
    private static final int[] SENSOR_TYPE_CONVERSIONTABLE = new int[]{4, AR_SENSOR_TYPE_GYROSCOPE, 1, AR_SENSOR_TYPE_ACCELEROMETER, 2, AR_SENSOR_TYPE_MAGNETOMETER, 8, AR_SENSOR_TYPE_PROXIMITY, 5, AR_SENSOR_TYPE_AMBIENT_LIGHT, 11, AR_SENSOR_TYPE_DEVICE_ROTATION};
    private static final int _NUM_SENSORINFO_VALUE_ = 3;
    private Vector<SensorCacheInfo> sensorCacheInfo = null;
    private Handler sensorEventHandler;
    private HashMap<Sensor, Integer> sensorIndexMap = null;
    private SensorManager sensorManager;

    public class SensorCacheInfo {
        int cacheIndex;
        boolean isDefaultSensor;
        int plSensorType;
        int requestedAbstractUpdateRate;
        Sensor sensor;
        float[] valuesForForcedSensorEvent;
    }

    private native void newDataAvailable(int i, long j, int i2, float[] fArr);

    public SensorController() {
        super(MODULENAME);
    }

    private SensorCacheInfo getSensorCacheInfo(int i) {
        if (i < 0 || i >= this.sensorCacheInfo.size()) {
            return null;
        }
        return (SensorCacheInfo) this.sensorCacheInfo.get(i);
    }

    private int translateSensorType(int i, boolean z) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < SENSOR_TYPE_CONVERSIONTABLE.length / 2) {
            if (i != (z == CONVERT_FORMAT_TO_PL ? SENSOR_TYPE_CONVERSIONTABLE[i3 * 2] : SENSOR_TYPE_CONVERSIONTABLE[(i3 * 2) + 1])) {
                i3++;
            } else if (z == CONVERT_FORMAT_TO_PL) {
                return SENSOR_TYPE_CONVERSIONTABLE[(i3 * 2) + 1];
            } else {
                return SENSOR_TYPE_CONVERSIONTABLE[i3 * 2];
            }
        }
        if (z == CONVERT_FORMAT_TO_PL) {
            i2 = AR_SENSOR_TYPE_UNKNOWN;
        }
        return i2;
    }

    private int translateSensorUpdateIntervalToAndroid(int i) {
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 0;
            default:
                return -1;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Object obj = this.sensorIndexMap.get(sensorEvent.sensor);
        if (obj != null) {
            SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(((Integer) obj).intValue());
            if (sensorCacheInfo != null) {
                int i = 0;
                switch (sensorEvent.accuracy) {
                    case 0:
                        i = 1;
                        break;
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 4;
                        break;
                }
                newDataAvailable(sensorCacheInfo.cacheIndex, sensorEvent.timestamp, i, sensorEvent.values);
            }
        }
    }

    public boolean init() {
        this.sensorManager = null;
        this.sensorCacheInfo = new Vector();
        this.sensorIndexMap = new HashMap();
        return true;
    }

    public int getAllSupportedSensors() {
        Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative == null) {
            SystemTools.logSystemError("No valid activity set in native!");
            return -1;
        }
        Context application = activityFromNative.getApplication();
        if (application == null) {
            return -1;
        }
        this.sensorManager = (SensorManager) application.getSystemService("sensor");
        if (this.sensorManager == null) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to retrieve Context's Sensor Service");
            return -1;
        } else if (this.sensorCacheInfo.size() > 0) {
            return this.sensorCacheInfo.size();
        } else {
            for (Sensor sensor : this.sensorManager.getSensorList(-1)) {
                int type = sensor.getType();
                boolean equals = sensor.equals(this.sensorManager.getDefaultSensor(type));
                type = translateSensorType(type, CONVERT_FORMAT_TO_PL);
                if (type != AR_SENSOR_TYPE_UNKNOWN) {
                    SensorCacheInfo sensorCacheInfo = new SensorCacheInfo();
                    sensorCacheInfo.sensor = sensor;
                    sensorCacheInfo.plSensorType = type;
                    sensorCacheInfo.isDefaultSensor = equals;
                    sensorCacheInfo.cacheIndex = this.sensorCacheInfo.size();
                    sensorCacheInfo.requestedAbstractUpdateRate = 0;
                    this.sensorCacheInfo.add(sensorCacheInfo);
                    this.sensorIndexMap.put(sensorCacheInfo.sensor, Integer.valueOf(sensorCacheInfo.cacheIndex));
                }
            }
            return this.sensorCacheInfo.size();
        }
    }

    boolean open(int i, int i2) {
        SensorCacheInfo sensorCacheInfo;
        if (i2 == AR_SENSOR_INDEX_DONTCARE) {
            for (int i3 = 0; i3 < this.sensorCacheInfo.size(); i3++) {
                sensorCacheInfo = (SensorCacheInfo) this.sensorCacheInfo.get(i3);
                if (sensorCacheInfo.plSensorType == i && sensorCacheInfo.isDefaultSensor) {
                    break;
                }
            }
            sensorCacheInfo = null;
        } else {
            sensorCacheInfo = (SensorCacheInfo) this.sensorCacheInfo.get(i2);
        }
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(2);
            SystemTools.logSystemError("No sensor matching the requested sensor device info has been found");
            return false;
        }
        if (this.sensorEventHandler == null) {
            try {
                start();
                this.sensorEventHandler = new Handler(getLooper());
            } catch (Exception e) {
                Exception exception = e;
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to " + (isAlive() ? "retrieve a handler for the sensor event handler thread" : "start Java handler thread for sensor events") + ": " + exception.toString());
                return false;
            }
        }
        return true;
    }

    boolean close(int i) {
        boolean z = false;
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
        } else {
            try {
                this.sensorManager.unregisterListener(this, sensorCacheInfo.sensor);
                z = true;
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to unregister sensor event listerer");
            }
            System.gc();
        }
        return z;
    }

    int[] getSensorInfoValues(int i) {
        int i2 = 1;
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            return null;
        }
        int[] iArr = new int[3];
        iArr[0] = sensorCacheInfo.plSensorType;
        iArr[1] = sensorCacheInfo.sensor.getType();
        if (!sensorCacheInfo.isDefaultSensor) {
            i2 = 0;
        }
        iArr[2] = i2;
        return iArr;
    }

    String getSensorName(int i) {
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            return null;
        }
        return sensorCacheInfo.sensor.getName();
    }

    Object getTypedSensorParameter(int i, int i2) {
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return null;
        }
        switch (i2) {
            case AR_SENSOR_PARAMTYPE_DATARANGE_MIN /*-2147483647*/:
            case AR_SENSOR_PARAMTYPE_ACCURACY /*-2147483640*/:
            case AR_SENSOR_PARAMTYPE_SENSITIVITY /*-2147483632*/:
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL /*-2147483616*/:
                SystemTools.setSystemErrorCode(3);
                SystemTools.logSystemError("Querying sensor parameter " + i2 + " is not supported for sensor type " + sensorCacheInfo.plSensorType + (i2 == AR_SENSOR_PARAMTYPE_UPDATEINTERVAL ? " when using the Java-based sensor API" : ""));
                return null;
            case AR_SENSOR_PARAMTYPE_DATARANGE_MAX /*-2147483646*/:
                return Float.valueOf(sensorCacheInfo.sensor.getMaximumRange());
            case AR_SENSOR_PARAMTYPE_RESOLUTION /*-2147483644*/:
                return Float.valueOf(sensorCacheInfo.sensor.getResolution());
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ABSTRACT /*-2147483584*/:
                return Integer.valueOf(sensorCacheInfo.requestedAbstractUpdateRate);
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_MIN /*-2147483520*/:
                if (SystemTools.checkMinimumApiLevel(9)) {
                    return Integer.valueOf(sensorCacheInfo.sensor.getMinDelay());
                }
                SystemTools.setSystemErrorCode(3);
                SystemTools.logSystemError("Unknown sensor parameter");
                return null;
            default:
                try {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Unknown sensor parameter");
                    return null;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
                    return null;
                }
        }
        SystemTools.setSystemErrorCode(6);
        SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
        return null;
    }

    boolean setTypedSensorParameter(int i, int i2, Object obj) {
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        switch (i2) {
            case AR_SENSOR_PARAMTYPE_DATARANGE_MIN /*-2147483647*/:
            case AR_SENSOR_PARAMTYPE_DATARANGE_MAX /*-2147483646*/:
            case AR_SENSOR_PARAMTYPE_RESOLUTION /*-2147483644*/:
            case AR_SENSOR_PARAMTYPE_ACCURACY /*-2147483640*/:
            case AR_SENSOR_PARAMTYPE_SENSITIVITY /*-2147483632*/:
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL /*-2147483616*/:
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_MIN /*-2147483520*/:
                SystemTools.setSystemErrorCode(3);
                SystemTools.logSystemError("Sensor parameter " + i2 + " cannot be set for sensor type " + sensorCacheInfo.plSensorType + (i2 == AR_SENSOR_PARAMTYPE_UPDATEINTERVAL ? " when using the Java-based sensor API" : ""));
                return false;
            case AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ABSTRACT /*-2147483584*/:
                int intValue = ((Number) obj).intValue();
                if (intValue < 1 || intValue > 4) {
                    SystemTools.setSystemErrorCode(2);
                    SystemTools.logSystemError("Invalid abstract sensor update interval (" + intValue + ")");
                    return false;
                }
                sensorCacheInfo.requestedAbstractUpdateRate = intValue;
                return true;
            default:
                try {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Unknown sensor parameter");
                    return false;
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
                    return false;
                }
        }
        SystemTools.setSystemErrorCode(6);
        SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
        return false;
    }

    boolean start(int i) {
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        boolean registerListener;
        int translateSensorUpdateIntervalToAndroid = translateSensorUpdateIntervalToAndroid(sensorCacheInfo.requestedAbstractUpdateRate);
        if (translateSensorUpdateIntervalToAndroid < 0) {
            translateSensorUpdateIntervalToAndroid = 1;
        }
        try {
            registerListener = this.sensorManager.registerListener(this, sensorCacheInfo.sensor, translateSensorUpdateIntervalToAndroid, this.sensorEventHandler);
        } catch (Exception e) {
            registerListener = false;
        }
        if (registerListener) {
            return registerListener;
        }
        SystemTools.setSystemErrorCode(6);
        SystemTools.logSystemError("Failed to start sensor, could not register sensor event listerer");
        return registerListener;
    }

    boolean stop(int i) {
        SensorCacheInfo sensorCacheInfo = getSensorCacheInfo(i);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        try {
            this.sensorManager.unregisterListener(this, sensorCacheInfo.sensor);
            return true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to stop sensor, could not unregister sensor event listerer");
            return false;
        }
    }
}
