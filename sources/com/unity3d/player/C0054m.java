package com.unity3d.player;

import android.os.Build;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.unity3d.player.m */
final class C0054m implements UncaughtExceptionHandler {
    /* renamed from: a */
    private volatile UncaughtExceptionHandler f167a;

    C0054m() {
    }

    /* renamed from: a */
    final synchronized boolean m71a() {
        boolean z;
        C0054m defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f167a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Throwable error = new Error(String.format("FATAL EXCEPTION [%s]\n", new Object[]{thread.getName()}) + String.format("Unity version     : %s\n", new Object[]{"2018.2.17f1"}) + String.format("Device model      : %s %s\n", new Object[]{Build.MANUFACTURER, Build.MODEL}) + String.format("Device fingerprint: %s\n", new Object[]{Build.FINGERPRINT}));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f167a.uncaughtException(thread, error);
        } catch (Throwable th2) {
            this.f167a.uncaughtException(thread, th);
        }
    }
}
