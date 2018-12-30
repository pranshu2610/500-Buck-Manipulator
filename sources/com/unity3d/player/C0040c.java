package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.c */
class C0040c {
    /* renamed from: a */
    protected C0057o f138a = null;
    /* renamed from: b */
    protected C0043f f139b = null;
    /* renamed from: c */
    protected Context f140c = null;
    /* renamed from: d */
    protected String f141d = null;
    /* renamed from: e */
    protected String f142e = "";

    C0040c(String str, C0043f c0043f) {
        this.f142e = str;
        this.f139b = c0043f;
    }

    protected void reportError(String str) {
        if (this.f139b != null) {
            this.f139b.reportError(this.f142e + " Error [" + this.f141d + "]", str);
        } else {
            C0044g.Log(6, this.f142e + " Error [" + this.f141d + "]: " + str);
        }
    }

    protected void runOnUiThread(Runnable runnable) {
        if (this.f140c instanceof Activity) {
            ((Activity) this.f140c).runOnUiThread(runnable);
        } else {
            C0044g.Log(5, "Not running " + this.f142e + " from an Activity; Ignoring execution request...");
        }
    }

    protected boolean runOnUiThreadWithSync(final Runnable runnable) {
        boolean z = false;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        final Semaphore semaphore = new Semaphore(0);
        runOnUiThread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C0040c f137c;

            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    this.f137c.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                z = true;
            } else {
                reportError("Timeout waiting for vr state change!");
            }
        } catch (InterruptedException e) {
            reportError("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
        }
        return z;
    }
}
