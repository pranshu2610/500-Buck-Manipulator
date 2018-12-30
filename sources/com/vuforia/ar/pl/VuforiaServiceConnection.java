package com.vuforia.ar.pl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;

public class VuforiaServiceConnection implements ServiceConnection {
    private static final String SUBTAG = "VuforiaConn";
    private IBinder mService;
    private CountDownLatch mServiceLatch = null;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = iBinder;
        this.mServiceLatch.countDown();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mServiceLatch = null;
    }

    public boolean bindService(Context context, ComponentName componentName) {
        this.mServiceLatch = new CountDownLatch(1);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        boolean z = false;
        try {
            z = context.bindService(intent, this, 1);
        } catch (SecurityException e) {
            context.unbindService(this);
            DebugLog.LOGD(SUBTAG, "Not permitted to bind to service: " + componentName + e);
        }
        if (!z) {
            context.unbindService(this);
            DebugLog.LOGD(SUBTAG, "Bind to service " + componentName + " failed");
            this.mServiceLatch = null;
        }
        return z;
    }

    public boolean unbindService(Context context) {
        if (this.mService != null) {
            context.unbindService(this);
            this.mService = null;
        }
        return true;
    }

    public IBinder awaitService() {
        if (this.mServiceLatch == null) {
            DebugLog.LOGE(SUBTAG, "ERROR: awaitService called before bind()");
            return null;
        }
        try {
            this.mServiceLatch.await();
            return this.mService;
        } catch (InterruptedException e) {
            DebugLog.LOGD(SUBTAG, "bind failed to complete" + e);
            this.mServiceLatch = null;
            return null;
        }
    }
}
