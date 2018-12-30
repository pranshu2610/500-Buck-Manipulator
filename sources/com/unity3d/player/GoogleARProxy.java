package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;

class GoogleARProxy extends C0040c {
    /* renamed from: f */
    private boolean f251f = false;

    /* renamed from: com.unity3d.player.GoogleARProxy$2 */
    class C00032 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ GoogleARProxy f5a;

        C00032(GoogleARProxy googleARProxy) {
            this.f5a = googleARProxy;
        }

        public final void run() {
            try {
                if (this.f5a.a != null) {
                    this.f5a.a.m83a("create", new Object[0]);
                }
            } catch (Exception e) {
                this.f5a.reportError("Exception creating " + this.f5a.e + " VR on UI Thread. " + e.getLocalizedMessage());
            }
        }
    }

    /* renamed from: com.unity3d.player.GoogleARProxy$3 */
    class C00043 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ GoogleARProxy f6a;

        C00043(GoogleARProxy googleARProxy) {
            this.f6a = googleARProxy;
        }

        public final void run() {
            try {
                if (this.f6a.a != null) {
                    this.f6a.a.m83a("pause", new Object[0]);
                }
            } catch (Exception e) {
                this.f6a.reportError("Exception pausing " + this.f6a.e + " VR on UI Thread. " + e.getLocalizedMessage());
            }
        }
    }

    /* renamed from: com.unity3d.player.GoogleARProxy$4 */
    class C00054 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ GoogleARProxy f7a;

        C00054(GoogleARProxy googleARProxy) {
            this.f7a = googleARProxy;
        }

        public final void run() {
            try {
                if (this.f7a.a != null) {
                    this.f7a.a.m83a("resume", new Object[0]);
                }
            } catch (Exception e) {
                this.f7a.reportError("Exception resuming " + this.f7a.e + " VR on UI Thread. " + e.getLocalizedMessage());
            }
        }
    }

    GoogleARProxy(C0043f c0043f) {
        super("Google AR", c0043f);
    }

    /* renamed from: a */
    public static boolean m116a() {
        try {
            Class loadClass = UnityPlayer.class.getClassLoader().loadClass("com.unity3d.unitygar.GoogleAR");
            C0057o c0057o = new C0057o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            c0057o.m84a("getClassVersion", new Class[0]);
            if (((Number) c0057o.m83a("getClassVersion", new Object[0])).intValue() > 0) {
                Log.d("Unity", "Loading ARCore V1+ path.");
                return false;
            }
            Log.d("Unity", "Loading ARCore Preview path (Version <= 1).");
            return true;
        } catch (Exception e) {
            Log.d("Unity", "Loading ARCore Preview path.");
            return true;
        }
    }

    /* renamed from: a */
    private boolean m117a(ClassLoader classLoader) {
        if (this.f251f) {
            return true;
        }
        try {
            Class loadClass = classLoader.loadClass("com.unity3d.unitygar.GoogleAR");
            C0057o c0057o = new C0057o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            c0057o.m84a("initialize", new Class[]{Activity.class});
            c0057o.m84a("create", new Class[0]);
            c0057o.m84a("pause", new Class[0]);
            c0057o.m84a("resume", new Class[0]);
            this.a = c0057o;
            this.f251f = true;
            return true;
        } catch (Exception e) {
            this.b.reportError("Google AR Error", e.toString() + e.getLocalizedMessage());
            return false;
        }
    }

    private final native void tangoOnCreate(Activity activity);

    private final native void tangoOnServiceConnected(IBinder iBinder);

    private final native void tangoOnStop();

    /* renamed from: a */
    final void m118a(final Activity activity, Context context) {
        if (m117a(UnityPlayer.class.getClassLoader())) {
            this.c = context;
            runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ GoogleARProxy f4b;

                public final void run() {
                    try {
                        if (this.f4b.a != null) {
                            this.f4b.a.m83a("initialize", activity);
                        }
                    } catch (Exception e) {
                        this.f4b.reportError("Exception creating " + this.f4b.e + " VR on UI Thread. " + e.getLocalizedMessage());
                    }
                }
            });
        }
    }

    /* renamed from: b */
    final void m119b() {
        runOnUiThread(new C00032(this));
    }

    /* renamed from: c */
    final void m120c() {
        runOnUiThread(new C00043(this));
    }

    /* renamed from: d */
    final void m121d() {
        runOnUiThread(new C00054(this));
    }

    /* renamed from: e */
    public final boolean m122e() {
        return this.f251f;
    }
}
