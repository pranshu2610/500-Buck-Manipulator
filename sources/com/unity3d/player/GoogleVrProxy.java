package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

class GoogleVrProxy extends C0040c implements GoogleVrVideo {
    /* renamed from: f */
    private boolean f252f = false;
    /* renamed from: g */
    private boolean f253g = false;
    /* renamed from: h */
    private Runnable f254h = null;
    /* renamed from: i */
    private Vector f255i = new Vector();
    /* renamed from: j */
    private SurfaceView f256j = null;
    /* renamed from: k */
    private C0010a f257k = new C0010a(this);
    /* renamed from: l */
    private Thread f258l = null;
    /* renamed from: m */
    private Handler f259m = new Handler(this, Looper.getMainLooper()) {
        /* renamed from: a */
        final /* synthetic */ GoogleVrProxy f9a;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 135711:
                    switch (message.arg1) {
                        case 2147483645:
                            Iterator it = this.f9a.f255i.iterator();
                            while (it.hasNext()) {
                                ((GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                            }
                            return;
                        case 2147483646:
                            Surface surface = (Surface) message.obj;
                            Iterator it2 = this.f9a.f255i.iterator();
                            while (it2.hasNext()) {
                                ((GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                            }
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: com.unity3d.player.GoogleVrProxy$4 */
    class C00094 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ GoogleVrProxy f19a;

        C00094(GoogleVrProxy googleVrProxy) {
            this.f19a = googleVrProxy;
        }

        public final void run() {
            try {
                if (this.f19a.a != null) {
                    this.f19a.a.m83a("unload", new Object[0]);
                    this.f19a.a.m83a("deinitialize", new Object[0]);
                    this.f19a.a = null;
                }
                this.f19a.f257k.f21b = false;
            } catch (Exception e) {
                this.f19a.reportError("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
            }
        }
    }

    /* renamed from: com.unity3d.player.GoogleVrProxy$a */
    class C0010a {
        /* renamed from: a */
        public boolean f20a = false;
        /* renamed from: b */
        public boolean f21b = false;
        /* renamed from: c */
        public boolean f22c = false;
        /* renamed from: d */
        public boolean f23d = false;
        /* renamed from: e */
        public boolean f24e = true;
        /* renamed from: f */
        public boolean f25f = false;
        /* renamed from: g */
        final /* synthetic */ GoogleVrProxy f26g;

        C0010a(GoogleVrProxy googleVrProxy) {
            this.f26g = googleVrProxy;
        }

        /* renamed from: a */
        public final boolean m5a() {
            return this.f20a && this.f21b;
        }

        /* renamed from: b */
        public final void m6b() {
            this.f20a = false;
            this.f21b = false;
            this.f23d = false;
            this.f24e = true;
            this.f25f = false;
        }
    }

    public GoogleVrProxy(C0043f c0043f) {
        super("Google VR", c0043f);
        initVrJni();
    }

    /* renamed from: a */
    private void m125a(boolean z) {
        this.f257k.f23d = z;
    }

    /* renamed from: a */
    private static boolean m126a(int i) {
        return VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private boolean m127a(ClassLoader classLoader) {
        try {
            Class loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            C0057o c0057o = new C0057o(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            c0057o.m84a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE, Handler.class});
            c0057o.m84a("deinitialize", new Class[0]);
            c0057o.m84a("load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            c0057o.m84a("enable", new Class[]{Boolean.TYPE});
            c0057o.m84a("unload", new Class[0]);
            c0057o.m84a("pause", new Class[0]);
            c0057o.m84a("resume", new Class[0]);
            c0057o.m84a("getGvrLayout", new Class[0]);
            c0057o.m84a("getVideoSurfaceId", new Class[0]);
            c0057o.m84a("getVideoSurface", new Class[0]);
            this.a = c0057o;
            return true;
        } catch (Exception e) {
            reportError("Exception initializing GoogleVR from Unity library. " + e.getLocalizedMessage());
            return false;
        }
    }

    /* renamed from: d */
    private boolean m130d() {
        return this.f257k.f23d;
    }

    /* renamed from: e */
    private void m132e() {
        Activity activity = (Activity) this.c;
        if (this.f253g && !this.f257k.f25f && activity != null) {
            this.f257k.f25f = true;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            activity.startActivity(intent);
        }
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    /* renamed from: a */
    public final void m133a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            this.f253g = true;
        }
    }

    /* renamed from: a */
    public final boolean m134a() {
        return this.f257k.f20a;
    }

    /* renamed from: a */
    public final boolean m135a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            reportError("Invalid parameters passed to Google VR initiialization.");
            return false;
        }
        this.f257k.m6b();
        this.c = context;
        this.f254h = runnable;
        if (!m126a(19)) {
            reportError("Google VR requires a device that supports an api version of 19 (KitKat) or better.");
            return false;
        } else if (this.f253g && !m126a(24)) {
            reportError("Daydream requires a device that supports an api version of 24 (Nougat) or better.");
            return false;
        } else if (!m127a(UnityPlayer.class.getClassLoader())) {
            return false;
        } else {
            boolean booleanValue;
            try {
                booleanValue = ((Boolean) this.a.m83a("initialize", activity, context, surfaceView, Boolean.valueOf(this.f253g), this.f259m)).booleanValue();
            } catch (Exception e) {
                reportError("Exception while trying to intialize Unity Google VR Library. " + e.getLocalizedMessage());
                booleanValue = false;
            }
            if (booleanValue) {
                this.f256j = surfaceView;
                this.f257k.f20a = true;
                this.d = "";
                return true;
            }
            reportError("Unable to initialize GoogleVR library.");
            return false;
        }
    }

    /* renamed from: b */
    public final void m136b() {
        resumeGvrLayout();
    }

    /* renamed from: c */
    public final void m137c() {
        if (this.f256j != null) {
            this.f256j.getHolder().setSizeFromLayout();
        }
    }

    public void deregisterGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.f255i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.f255i.remove(googleVrVideoCallbacks);
        }
    }

    protected Object getVideoSurface() {
        Object obj = null;
        if (m130d() && !this.f257k.f24e) {
            try {
                obj = this.a.m83a("getVideoSurface", new Object[0]);
            } catch (Exception e) {
                reportError("Exception caught while Getting GoogleVR Video Surface. " + e.getLocalizedMessage());
            }
        }
        return obj;
    }

    protected int getVideoSurfaceId() {
        if (!m130d() || this.f257k.f24e) {
            return -1;
        }
        try {
            return ((Integer) this.a.m83a("getVideoSurfaceId", new Object[0])).intValue();
        } catch (Exception e) {
            reportError("Exception caught while getting Video Surface ID from GoogleVR. " + e.getLocalizedMessage());
            return -1;
        }
    }

    protected long loadGoogleVr(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.f257k.f20a) {
            return 0;
        }
        final AtomicLong atomicLong = new AtomicLong(0);
        String str = (z || z2) ? "Daydream" : "Cardboard";
        this.d = str;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        if (!runOnUiThreadWithSync(new Runnable(this) {
            /* renamed from: g */
            final /* synthetic */ GoogleVrProxy f16g;

            public final void run() {
                try {
                    atomicLong.set(((Long) this.f16g.a.m83a("load", Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), this.f16g.f254h)).longValue());
                    this.f16g.f257k.f21b = true;
                } catch (Exception e) {
                    this.f16g.reportError("Exception caught while loading GoogleVR. " + e.getLocalizedMessage());
                    atomicLong.set(0);
                }
            }
        }) || atomicLong.longValue() == 0) {
            reportError("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    protected void pauseGvrLayout() {
        if (this.f257k.m5a() && !this.f257k.f24e) {
            if (m130d()) {
                Iterator it = this.f255i.iterator();
                while (it.hasNext()) {
                    ((GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            if (this.a != null) {
                this.a.m83a("pause", new Object[0]);
            }
            this.f257k.f24e = true;
        }
    }

    public void registerGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (!this.f255i.contains(googleVrVideoCallbacks)) {
            this.f255i.add(googleVrVideoCallbacks);
            Surface surface = (Surface) getVideoSurface();
            if (surface != null) {
                googleVrVideoCallbacks.onSurfaceAvailable(surface);
            }
        }
    }

    protected void resumeGvrLayout() {
        if (this.f257k.m5a() && this.f257k.f24e) {
            if (this.a != null) {
                this.a.m83a("resume", new Object[0]);
            }
            this.f257k.f24e = false;
        }
    }

    protected void setGoogleVrModeEnabled(final boolean z) {
        if (this.f257k.m5a() && this.b != null && this.c != null) {
            if (!z && isQuiting()) {
                m132e();
            }
            runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ GoogleVrProxy f18b;

                public final void run() {
                    if (z != this.f18b.m130d()) {
                        try {
                            if (!z || this.f18b.m130d()) {
                                if (!z && this.f18b.m130d()) {
                                    this.f18b.m125a(false);
                                    if (this.f18b.a != null) {
                                        this.f18b.a.m83a("enable", Boolean.valueOf(false));
                                    }
                                    if (this.f18b.a != null && this.f18b.b != null) {
                                        this.f18b.b.removeViewFromPlayer((View) this.f18b.a.m83a("getGvrLayout", new Object[0]));
                                    }
                                }
                            } else if (this.f18b.a == null || this.f18b.b == null || this.f18b.b.addViewToPlayer((View) this.f18b.a.m83a("getGvrLayout", new Object[0]), true)) {
                                if (this.f18b.a != null) {
                                    this.f18b.a.m83a("enable", Boolean.valueOf(true));
                                }
                                this.f18b.m125a(true);
                            } else {
                                this.f18b.reportError("Unable to add Google VR to view hierarchy.");
                            }
                        } catch (Exception e) {
                            this.f18b.reportError("Exception enabling Google VR on UI Thread. " + e.getLocalizedMessage());
                        }
                    }
                }
            });
        }
    }

    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{4, 4});
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                fArr2[i][i2] = fArr[(i * 4) + i2];
            }
        }
        setVrVideoTransform(fArr2);
    }

    protected void unloadGoogleVr() {
        if (this.f257k.f23d) {
            setGoogleVrModeEnabled(false);
        }
        if (this.f257k.f22c) {
            this.f257k.f22c = false;
        }
        this.f256j = null;
        runOnUiThread(new C00094(this));
    }
}
