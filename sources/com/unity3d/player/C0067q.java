package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.C0060p.C0058a;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.q */
final class C0067q {
    /* renamed from: a */
    private UnityPlayer f220a = null;
    /* renamed from: b */
    private Context f221b = null;
    /* renamed from: c */
    private C0066a f222c;
    /* renamed from: d */
    private final Semaphore f223d = new Semaphore(0);
    /* renamed from: e */
    private final Lock f224e = new ReentrantLock();
    /* renamed from: f */
    private C0060p f225f = null;
    /* renamed from: g */
    private int f226g = 2;
    /* renamed from: h */
    private boolean f227h = false;
    /* renamed from: i */
    private boolean f228i = false;

    /* renamed from: com.unity3d.player.q$2 */
    class C00632 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0067q f217a;

        C00632(C0067q c0067q) {
            this.f217a = c0067q;
        }

        public final void run() {
            this.f217a.f220a.pause();
        }
    }

    /* renamed from: com.unity3d.player.q$3 */
    class C00643 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0067q f218a;

        C00643(C0067q c0067q) {
            this.f218a = c0067q;
        }

        public final void run() {
            if (this.f218a.f225f != null) {
                this.f218a.f220a.addViewToPlayer(this.f218a.f225f, true);
                this.f218a.f228i = true;
                this.f218a.f225f.requestFocus();
            }
        }
    }

    /* renamed from: com.unity3d.player.q$4 */
    class C00654 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0067q f219a;

        C00654(C0067q c0067q) {
            this.f219a = c0067q;
        }

        public final void run() {
            this.f219a.m101d();
            this.f219a.f220a.resume();
        }
    }

    /* renamed from: com.unity3d.player.q$a */
    public interface C0066a {
        /* renamed from: a */
        void mo6a();
    }

    C0067q(UnityPlayer unityPlayer) {
        this.f220a = unityPlayer;
    }

    /* renamed from: d */
    private void m101d() {
        if (this.f225f != null) {
            this.f220a.removeViewFromPlayer(this.f225f);
            this.f228i = false;
            this.f225f.destroyPlayer();
            this.f225f = null;
            if (this.f222c != null) {
                this.f222c.mo6a();
            }
        }
    }

    /* renamed from: a */
    public final void m106a() {
        this.f224e.lock();
        if (this.f225f != null) {
            if (this.f226g == 0) {
                this.f225f.CancelOnPrepare();
            } else if (this.f228i) {
                this.f227h = this.f225f.m93a();
                if (!this.f227h) {
                    this.f225f.pause();
                }
            }
        }
        this.f224e.unlock();
    }

    /* renamed from: a */
    public final boolean m107a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0066a c0066a) {
        this.f224e.lock();
        this.f222c = c0066a;
        this.f221b = context;
        this.f223d.drainPermits();
        this.f226g = 2;
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        runOnUiThread(new Runnable(this) {
            /* renamed from: h */
            final /* synthetic */ C0067q f216h;

            /* renamed from: com.unity3d.player.q$1$1 */
            class C00831 implements C0058a {
                /* renamed from: a */
                final /* synthetic */ C00621 f292a;

                /* renamed from: com.unity3d.player.q$1$1$1 */
                class C00611 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C00831 f208a;

                    C00611(C00831 c00831) {
                        this.f208a = c00831;
                    }

                    public final void run() {
                        this.f208a.f292a.f216h.m101d();
                        this.f208a.f292a.f216h.f220a.resume();
                    }
                }

                C00831(C00621 c00621) {
                    this.f292a = c00621;
                }

                /* renamed from: a */
                public final void mo13a(int i) {
                    this.f292a.f216h.f224e.lock();
                    this.f292a.f216h.f226g = i;
                    if (i == 3 && this.f292a.f216h.f228i) {
                        this.f292a.f216h.runOnUiThread(new C00611(this));
                    }
                    if (i != 0) {
                        this.f292a.f216h.f223d.release();
                    }
                    this.f292a.f216h.f224e.unlock();
                }
            }

            public final void run() {
                if (this.f216h.f225f != null) {
                    C0044g.Log(5, "Video already playing");
                    this.f216h.f226g = 2;
                    this.f216h.f223d.release();
                    return;
                }
                this.f216h.f225f = new C0060p(this.f216h.f221b, str2, i4, i5, i6, z2, j3, j4, new C00831(this));
                if (this.f216h.f225f != null) {
                    this.f216h.f220a.addView(this.f216h.f225f);
                }
            }
        });
        boolean z3 = false;
        try {
            this.f224e.unlock();
            this.f223d.acquire();
            this.f224e.lock();
            z3 = this.f226g != 2;
        } catch (InterruptedException e) {
        }
        runOnUiThread(new C00632(this));
        if (!z3 || this.f226g == 3) {
            runOnUiThread(new C00654(this));
        } else {
            runOnUiThread(new C00643(this));
        }
        this.f224e.unlock();
        return z3;
    }

    /* renamed from: b */
    public final void m108b() {
        this.f224e.lock();
        if (!(this.f225f == null || !this.f228i || this.f227h)) {
            this.f225f.start();
        }
        this.f224e.unlock();
    }

    /* renamed from: c */
    public final void m109c() {
        this.f224e.lock();
        if (this.f225f != null) {
            this.f225f.updateVideoLayout();
        }
        this.f224e.unlock();
    }

    protected final void runOnUiThread(Runnable runnable) {
        if (this.f221b instanceof Activity) {
            ((Activity) this.f221b).runOnUiThread(runnable);
        } else {
            C0044g.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
