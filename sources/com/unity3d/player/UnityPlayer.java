package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.unity3d.player.C0053l.C0052a;
import com.unity3d.player.C0067q.C0066a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements C0043f {
    public static Activity currentActivity = null;
    /* renamed from: t */
    private static boolean f267t;
    /* renamed from: a */
    C0028e f268a = new C0028e();
    /* renamed from: b */
    C0050k f269b = null;
    /* renamed from: c */
    private int f270c = -1;
    /* renamed from: d */
    private boolean f271d = false;
    /* renamed from: e */
    private boolean f272e = true;
    /* renamed from: f */
    private C0055n f273f = new C0055n();
    /* renamed from: g */
    private final ConcurrentLinkedQueue f274g = new ConcurrentLinkedQueue();
    /* renamed from: h */
    private BroadcastReceiver f275h = null;
    /* renamed from: i */
    private boolean f276i = false;
    /* renamed from: j */
    private C0024c f277j = new C0024c();
    /* renamed from: k */
    private TelephonyManager f278k;
    /* renamed from: l */
    private ClipboardManager f279l;
    /* renamed from: m */
    private C0053l f280m;
    /* renamed from: n */
    private GoogleARProxy f281n = null;
    /* renamed from: o */
    private GoogleARCoreApi f282o = null;
    /* renamed from: p */
    private C0022a f283p = new C0022a(this);
    /* renamed from: q */
    private Camera2Wrapper f284q = null;
    /* renamed from: r */
    private Context f285r;
    /* renamed from: s */
    private SurfaceView f286s;
    /* renamed from: u */
    private boolean f287u;
    /* renamed from: v */
    private boolean f288v;
    /* renamed from: w */
    private boolean f289w = false;
    /* renamed from: x */
    private C0067q f290x;

    /* renamed from: com.unity3d.player.UnityPlayer$1 */
    class C00141 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f50a;

        /* renamed from: com.unity3d.player.UnityPlayer$1$1 */
        class C00131 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C00141 f35a;

            C00131(C00141 c00141) {
                this.f35a = c00141;
            }

            public final void run() {
                this.f35a.f50a.f273f.m78d();
                this.f35a.f50a.m163f();
            }
        }

        C00141(UnityPlayer unityPlayer) {
            this.f50a = unityPlayer;
        }

        public final void run() {
            this.f50a.m186a(new C00131(this));
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$2 */
    class C00152 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f55a;

        C00152(UnityPlayer unityPlayer) {
            this.f55a = unityPlayer;
        }

        public final void run() {
            this.f55a.nativeLowMemory();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$3 */
    class C00163 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f56a;

        public void onReceive(Context context, Intent intent) {
            this.f56a.m157c();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$4 */
    class C00174 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f57a;

        C00174(UnityPlayer unityPlayer) {
            this.f57a = unityPlayer;
        }

        public final void run() {
            this.f57a.nativeResume();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$6 */
    class C00196 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f68a;

        C00196(UnityPlayer unityPlayer) {
            this.f68a = unityPlayer;
        }

        public final void run() {
            if (this.f68a.f269b != null) {
                this.f68a.f269b.dismiss();
                this.f68a.f269b = null;
            }
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$a */
    class C0022a implements SensorEventListener {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f73a;

        C0022a(UnityPlayer unityPlayer) {
            this.f73a = unityPlayer;
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$b */
    enum C0023b {
        ;

        static {
            f74a = 1;
            f75b = 2;
            f76c = 3;
            f77d = new int[]{f74a, f75b, f76c};
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$c */
    private class C0024c extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ UnityPlayer f78a;

        private C0024c(UnityPlayer unityPlayer) {
            this.f78a = unityPlayer;
        }

        public final void onCallStateChanged(int i, String str) {
            boolean z = true;
            UnityPlayer unityPlayer = this.f78a;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$d */
    enum C0025d {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME
    }

    /* renamed from: com.unity3d.player.UnityPlayer$e */
    private class C0028e extends Thread {
        /* renamed from: a */
        Handler f90a;
        /* renamed from: b */
        boolean f91b;
        /* renamed from: c */
        boolean f92c;
        /* renamed from: d */
        int f93d;
        /* renamed from: e */
        int f94e;
        /* renamed from: f */
        final /* synthetic */ UnityPlayer f95f;

        /* renamed from: com.unity3d.player.UnityPlayer$e$1 */
        class C00261 implements Callback {
            /* renamed from: a */
            final /* synthetic */ C0028e f88a;

            C00261(C0028e c0028e) {
                this.f88a = c0028e;
            }

            /* renamed from: a */
            private void m17a() {
                if (this.f88a.f93d == C0023b.f76c && this.f88a.f92c) {
                    this.f88a.f95f.nativeFocusChanged(true);
                    this.f88a.f93d = C0023b.f74a;
                }
            }

            public final boolean handleMessage(Message message) {
                if (message.what != 2269) {
                    return false;
                }
                C0025d c0025d = (C0025d) message.obj;
                if (c0025d == C0025d.NEXT_FRAME) {
                    return true;
                }
                if (c0025d == C0025d.QUIT) {
                    Looper.myLooper().quit();
                } else if (c0025d == C0025d.RESUME) {
                    this.f88a.f91b = true;
                } else if (c0025d == C0025d.PAUSE) {
                    this.f88a.f91b = false;
                } else if (c0025d == C0025d.SURFACE_LOST) {
                    this.f88a.f92c = false;
                } else if (c0025d == C0025d.SURFACE_ACQUIRED) {
                    this.f88a.f92c = true;
                    m17a();
                } else if (c0025d == C0025d.FOCUS_LOST) {
                    if (this.f88a.f93d == C0023b.f74a) {
                        this.f88a.f95f.nativeFocusChanged(false);
                    }
                    this.f88a.f93d = C0023b.f75b;
                } else if (c0025d == C0025d.FOCUS_GAINED) {
                    this.f88a.f93d = C0023b.f76c;
                    m17a();
                }
                return true;
            }
        }

        /* renamed from: com.unity3d.player.UnityPlayer$e$2 */
        class C00272 implements IdleHandler {
            /* renamed from: a */
            final /* synthetic */ C0028e f89a;

            C00272(C0028e c0028e) {
                this.f89a = c0028e;
            }

            public final boolean queueIdle() {
                this.f89a.f95f.executeGLThreadJobs();
                if (this.f89a.f91b && this.f89a.f92c) {
                    if (this.f89a.f94e >= 0) {
                        if (this.f89a.f94e == 0 && this.f89a.f95f.m169i()) {
                            this.f89a.f95f.m141a();
                        }
                        C0028e c0028e = this.f89a;
                        c0028e.f94e--;
                    }
                    if (!(this.f89a.f95f.isFinishing() || this.f89a.f95f.nativeRender())) {
                        this.f89a.f95f.m157c();
                    }
                    Message.obtain(this.f89a.f90a, 2269, C0025d.NEXT_FRAME).sendToTarget();
                }
                return true;
            }
        }

        private C0028e(UnityPlayer unityPlayer) {
            this.f95f = unityPlayer;
            this.f91b = false;
            this.f92c = false;
            this.f93d = C0023b.f75b;
            this.f94e = 5;
        }

        /* renamed from: a */
        private void m18a(C0025d c0025d) {
            Message.obtain(this.f90a, 2269, c0025d).sendToTarget();
        }

        /* renamed from: a */
        public final void m19a() {
            m18a(C0025d.QUIT);
        }

        /* renamed from: a */
        public final void m20a(Runnable runnable) {
            m18a(C0025d.PAUSE);
            Message.obtain(this.f90a, runnable).sendToTarget();
        }

        /* renamed from: b */
        public final void m21b() {
            m18a(C0025d.RESUME);
        }

        /* renamed from: b */
        public final void m22b(Runnable runnable) {
            m18a(C0025d.SURFACE_LOST);
            Message.obtain(this.f90a, runnable).sendToTarget();
        }

        /* renamed from: c */
        public final void m23c() {
            m18a(C0025d.FOCUS_GAINED);
        }

        /* renamed from: c */
        public final void m24c(Runnable runnable) {
            Message.obtain(this.f90a, runnable).sendToTarget();
            m18a(C0025d.SURFACE_ACQUIRED);
        }

        /* renamed from: d */
        public final void m25d() {
            m18a(C0025d.FOCUS_LOST);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f90a = new Handler(new C00261(this));
            Looper.myQueue().addIdleHandler(new C00272(this));
            Looper.loop();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$f */
    private abstract class C0029f implements Runnable {
        /* renamed from: e */
        final /* synthetic */ UnityPlayer f96e;

        private C0029f(UnityPlayer unityPlayer) {
            this.f96e = unityPlayer;
        }

        /* renamed from: a */
        public abstract void mo5a();

        public final void run() {
            if (!this.f96e.isFinishing()) {
                mo5a();
            }
        }
    }

    static {
        new C0054m().m71a();
        f267t = false;
        f267t = loadLibraryStatic("main");
    }

    public UnityPlayer(Context context) {
        super(context);
        if (context instanceof Activity) {
            currentActivity = (Activity) context;
            this.f270c = currentActivity.getRequestedOrientation();
        }
        m143a(currentActivity);
        this.f285r = context;
        if (currentActivity != null && m169i()) {
            this.f280m = new C0053l(this.f285r, C0052a.m70a()[getSplashMode()]);
            addView(this.f280m);
        }
        if (C0046j.f147c) {
            if (currentActivity != null) {
                C0046j.f148d.mo12a(currentActivity, new C00141(this));
            } else {
                this.f273f.m78d();
            }
        }
        m144a(this.f285r.getApplicationInfo());
        if (C0055n.m74c()) {
            initJni(context);
            this.f286s = m152b();
            addView(this.f286s);
            bringChildToFront(this.f280m);
            this.f287u = false;
            nativeInitWebRequest(UnityWebRequest.class);
            m173k();
            this.f278k = (TelephonyManager) this.f285r.getSystemService("phone");
            this.f279l = (ClipboardManager) this.f285r.getSystemService("clipboard");
            this.f284q = new Camera2Wrapper(this.f285r);
            this.f268a.start();
            return;
        }
        AlertDialog create = new Builder(this.f285r).setTitle("Failure to initialize!").setPositiveButton("OK", new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ UnityPlayer f41a;

            {
                this.f41a = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f41a.m157c();
            }
        }).setMessage("Your hardware does not support this application, sorry!").create();
        create.setCancelable(false);
        create.show();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (C0055n.m74c()) {
            nativeUnitySendMessage(str, str2, str3);
        } else {
            C0044g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
        }
    }

    /* renamed from: a */
    private void m141a() {
        m186a(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ UnityPlayer f43a;

            {
                this.f43a = r1;
            }

            public final void run() {
                this.f43a.removeView(this.f43a.f280m);
                this.f43a.f280m = null;
            }
        });
    }

    /* renamed from: a */
    private void m142a(int i, Surface surface) {
        if (!this.f271d) {
            m156b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m143a(Activity activity) {
        if (activity != null && activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(7);
            }
        }
    }

    /* renamed from: a */
    private static void m144a(ApplicationInfo applicationInfo) {
        if (f267t && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C0055n.m72a();
        }
    }

    /* renamed from: a */
    private void m145a(View view, View view2) {
        int i;
        if (this.f273f.m79e()) {
            i = 0;
        } else {
            pause();
            i = 1;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!((parent instanceof UnityPlayer) && ((UnityPlayer) parent) == this)) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (i != 0) {
            resume();
        }
    }

    /* renamed from: a */
    private void m146a(C0029f c0029f) {
        if (!isFinishing()) {
            m155b((Runnable) c0029f);
        }
    }

    /* renamed from: b */
    private SurfaceView m152b() {
        SurfaceView surfaceView = new SurfaceView(this.f285r);
        surfaceView.getHolder().setFormat(-3);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(this) {
            /* renamed from: a */
            final /* synthetic */ UnityPlayer f44a;

            {
                this.f44a = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                this.f44a.m142a(0, surfaceHolder.getSurface());
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                this.f44a.m142a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                this.f44a.m142a(0, null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* renamed from: b */
    private void m155b(Runnable runnable) {
        if (!C0055n.m74c()) {
            return;
        }
        if (Thread.currentThread() == this.f268a) {
            runnable.run();
        } else {
            this.f274g.add(runnable);
        }
    }

    /* renamed from: b */
    private boolean m156b(final int i, final Surface surface) {
        if (!C0055n.m74c()) {
            return false;
        }
        final Semaphore semaphore = new Semaphore(0);
        Runnable anonymousClass18 = new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ UnityPlayer f48d;

            public final void run() {
                this.f48d.nativeRecreateGfxState(i, surface);
                semaphore.release();
            }
        };
        if (i != 0) {
            anonymousClass18.run();
        } else if (surface == null) {
            this.f268a.m22b(anonymousClass18);
        } else {
            this.f268a.m24c(anonymousClass18);
        }
        if (surface == null && i == 0) {
            try {
                if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                    C0044g.Log(5, "Timeout while trying detaching primary window.");
                }
            } catch (InterruptedException e) {
                C0044g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            }
        }
        return true;
    }

    /* renamed from: c */
    private void m157c() {
        if ((this.f285r instanceof Activity) && !((Activity) this.f285r).isFinishing()) {
            ((Activity) this.f285r).finish();
        }
    }

    /* renamed from: d */
    private void m159d() {
        reportSoftInputStr(null, 1, true);
        if (this.f273f.m81g()) {
            if (C0055n.m74c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.f268a.m20a(isFinishing() ? new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ UnityPlayer f52b;

                    public final void run() {
                        this.f52b.m162e();
                        semaphore.release();
                    }
                } : new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ UnityPlayer f54b;

                    public final void run() {
                        if (this.f54b.nativePause()) {
                            this.f54b.f287u = true;
                            this.f54b.m162e();
                            semaphore.release(2);
                            return;
                        }
                        semaphore.release();
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C0044g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException e) {
                    C0044g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.f273f.m77c(false);
            this.f273f.m76b(true);
            if (this.f276i) {
                this.f278k.listen(this.f277j, 0);
            }
        }
    }

    /* renamed from: e */
    private void m162e() {
        this.f288v = nativeShouldQuit();
        this.f289w = true;
        nativeDone();
    }

    /* renamed from: f */
    private void m163f() {
        if (this.f273f.m80f()) {
            this.f273f.m77c(true);
            m155b(new C00174(this));
            this.f268a.m21b();
        }
    }

    /* renamed from: g */
    private static void m166g() {
        if (!C0055n.m74c()) {
            return;
        }
        if (NativeLoader.unload()) {
            C0055n.m73b();
            return;
        }
        throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
    }

    /* renamed from: h */
    private ApplicationInfo m167h() {
        return this.f285r.getPackageManager().getApplicationInfo(this.f285r.getPackageName(), 128);
    }

    /* renamed from: i */
    private boolean m169i() {
        try {
            return m167h().metaData.getBoolean("unity.splash-enable");
        } catch (Exception e) {
            return false;
        }
    }

    private final native void initJni(Context context);

    /* renamed from: j */
    private boolean m172j() {
        try {
            return m167h().metaData.getBoolean("unity.tango-enable");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: k */
    private void m173k() {
        if (this.f285r instanceof Activity) {
            ((Activity) this.f285r).getWindow().setFlags(1024, 1024);
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            C0044g.Log(6, "Unable to find " + str);
            return false;
        } catch (Exception e2) {
            C0044g.Log(6, "Unknown error " + e2);
            return false;
        }
    }

    private final native void nativeDone();

    private final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    private final native boolean nativeIsAutorotationOn();

    private final native void nativeLowMemory();

    private final native void nativeMuteMasterAudio(boolean z);

    private final native boolean nativePause();

    private final native void nativeRecreateGfxState(int i, Surface surface);

    private final native boolean nativeRender();

    private final native void nativeRestartActivityIndicator();

    private final native void nativeResume();

    private final native void nativeSetInputString(String str);

    private final native boolean nativeShouldQuit();

    private final native void nativeSoftInputCanceled();

    private final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, String str3);

    /* renamed from: a */
    final void m186a(Runnable runnable) {
        if (this.f285r instanceof Activity) {
            ((Activity) this.f285r).runOnUiThread(runnable);
        } else {
            C0044g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    protected void addPhoneCallListener() {
        this.f276i = true;
        this.f278k.listen(this.f277j, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        boolean z2 = true;
        m145a(view, z ? this.f286s : null);
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.f286s.getParent() == null;
        boolean z5 = this.f286s.getParent() == this;
        if (!(z3 && (z4 || z5))) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                C0044g.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!(z4 || z5)) {
                C0044g.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        if (this.f286s instanceof SurfaceView) {
            this.f286s.getHolder().setSizeFromLayout();
        }
        if (this.f290x != null) {
            this.f290x.m109c();
        }
        GoogleVrProxy b = GoogleVrApi.m4b();
        if (b != null) {
            b.m137c();
        }
    }

    protected void disableLogger() {
        C0044g.f143a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f271d = surface != null;
            m186a(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ UnityPlayer f49a;

                {
                    this.f49a = r1;
                }

                public final void run() {
                    if (this.f49a.f271d) {
                        this.f49a.removeView(this.f49a.f286s);
                    } else {
                        this.f49a.addView(this.f49a.f286s);
                    }
                }
            });
        }
        return m156b(i, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f274g.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    protected String getClipboardText() {
        String str = "";
        ClipData primaryClip = this.f279l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.f285r).toString() : str;
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    protected int getSplashMode() {
        try {
            return m167h().metaData.getInt("unity.splash-mode");
        } catch (Exception e) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        final Runnable c00196 = new C00196(this);
        if (C0046j.f146b) {
            m146a(new C0029f(this) {
                /* renamed from: b */
                final /* synthetic */ UnityPlayer f266b;

                /* renamed from: a */
                public final void mo5a() {
                    this.f266b.m186a(c00196);
                }
            });
        } else {
            m186a(c00196);
        }
    }

    public void init(int i, boolean z) {
    }

    protected boolean initializeGoogleAr() {
        if (this.f281n == null && currentActivity != null && m172j()) {
            if (GoogleARProxy.m116a()) {
                this.f281n = new GoogleARProxy(this);
                this.f281n.m118a(currentActivity, this.f285r);
                this.f281n.m119b();
                if (!this.f273f.m79e()) {
                    this.f281n.m121d();
                }
                return this.f281n.m122e();
            }
            this.f282o = new GoogleARCoreApi();
            this.f282o.initializeARCore(currentActivity);
            if (!this.f273f.m79e()) {
                this.f282o.resumeARCore();
            }
        }
        return false;
    }

    protected boolean initializeGoogleVr() {
        GoogleVrProxy b = GoogleVrApi.m4b();
        if (b == null) {
            GoogleVrApi.m3a(this);
            b = GoogleVrApi.m4b();
            if (b == null) {
                C0044g.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final Runnable anonymousClass11 = new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ UnityPlayer f36a;

            {
                this.f36a = r1;
            }

            public final void run() {
                this.f36a.injectEvent(new KeyEvent(0, 4));
                this.f36a.injectEvent(new KeyEvent(1, 4));
            }
        };
        m186a(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ UnityPlayer f40d;

            public final void run() {
                if (!b.m135a(UnityPlayer.currentActivity, this.f40d.f285r, this.f40d.m152b(), anonymousClass11)) {
                    C0044g.Log(6, "Unable to initialize Google VR subsystem.");
                }
                if (UnityPlayer.currentActivity != null) {
                    b.m133a(UnityPlayer.currentActivity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return b.m134a();
            }
            C0044g.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e) {
            C0044g.Log(5, "UI thread was interrupted while initializing Google VR. " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return !C0055n.m74c() ? false : nativeInjectEvent(inputEvent);
    }

    protected boolean isFinishing() {
        if (!this.f287u) {
            boolean z = (this.f285r instanceof Activity) && ((Activity) this.f285r).isFinishing();
            this.f287u = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (C0055n.m74c()) {
            m155b(new C00152(this));
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        if (this.f281n != null) {
            this.f281n.m120c();
        } else if (this.f282o != null) {
            this.f282o.pauseARCore();
        }
        if (this.f290x != null) {
            this.f290x.m106a();
        }
        GoogleVrProxy b = GoogleVrApi.m4b();
        if (b != null) {
            b.pauseGvrLayout();
        }
        m159d();
    }

    public void quit() {
        if (GoogleVrApi.m4b() != null) {
            GoogleVrApi.m2a();
        }
        if (this.f284q != null) {
            this.f284q.m114a();
            this.f284q = null;
        }
        this.f287u = true;
        if (!this.f273f.m79e()) {
            pause();
        }
        this.f268a.m19a();
        try {
            this.f268a.join(4000);
        } catch (InterruptedException e) {
            this.f268a.interrupt();
        }
        if (this.f275h != null) {
            this.f285r.unregisterReceiver(this.f275h);
        }
        this.f275h = null;
        if (C0055n.m74c()) {
            removeAllViews();
        }
        if (this.f288v || !this.f289w) {
            kill();
        }
        m166g();
    }

    public void removeViewFromPlayer(View view) {
        Object obj = 1;
        m145a(this.f286s, view);
        Object obj2 = view.getParent() == null ? 1 : null;
        Object obj3 = this.f286s.getParent() == this ? 1 : null;
        if (obj2 == null || obj3 == null) {
            obj = null;
        }
        if (obj == null) {
            if (obj2 == null) {
                C0044g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (obj3 == null) {
                C0044g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(str2);
        C0044g.Log(6, stringBuilder.toString());
    }

    protected void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m146a(new C0029f(this) {
            /* renamed from: d */
            final /* synthetic */ UnityPlayer f263d;

            /* renamed from: a */
            public final void mo5a() {
                if (z) {
                    this.f263d.nativeSoftInputCanceled();
                } else if (str != null) {
                    this.f263d.nativeSetInputString(str);
                }
                if (i == 1) {
                    this.f263d.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        if (this.f281n != null) {
            this.f281n.m121d();
        } else if (this.f282o != null) {
            this.f282o.resumeARCore();
        }
        this.f273f.m76b(false);
        if (this.f290x != null) {
            this.f290x.m108b();
        }
        m163f();
        nativeRestartActivityIndicator();
        GoogleVrProxy b = GoogleVrApi.m4b();
        if (b != null) {
            b.m136b();
        }
    }

    protected void setCharacterLimit(final int i) {
        m186a(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UnityPlayer f72b;

            public final void run() {
                if (this.f72b.f269b != null) {
                    this.f72b.f269b.m68a(i);
                }
            }
        });
    }

    protected void setClipboardText(String str) {
        this.f279l.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected void setSoftInputStr(final String str) {
        m186a(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ UnityPlayer f70b;

            public final void run() {
                if (this.f70b.f269b != null && str != null) {
                    this.f70b.f269b.m69a(str);
                }
            }
        });
    }

    protected void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        final UnityPlayer unityPlayer = this;
        final String str3 = str;
        final int i3 = i;
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final String str4 = str2;
        final int i4 = i2;
        m186a(new Runnable(this) {
            /* renamed from: j */
            final /* synthetic */ UnityPlayer f67j;

            public final void run() {
                this.f67j.f269b = new C0050k(this.f67j.f285r, unityPlayer, str3, i3, z5, z6, z7, str4, i4);
                this.f67j.f269b.show();
            }
        });
    }

    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.f290x == null) {
            this.f290x = new C0067q(this);
        }
        boolean a = this.f290x.m107a(this.f285r, str, i, i2, i3, z, (long) i4, (long) i5, new C0066a(this) {
            /* renamed from: a */
            final /* synthetic */ UnityPlayer f264a;

            {
                this.f264a = r1;
            }

            /* renamed from: a */
            public final void mo6a() {
                this.f264a.f290x = null;
            }
        });
        if (a) {
            m186a(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ UnityPlayer f42a;

                {
                    this.f42a = r1;
                }

                public final void run() {
                    if (this.f42a.nativeIsAutorotationOn() && (this.f42a.f285r instanceof Activity)) {
                        ((Activity) this.f42a.f285r).setRequestedOrientation(this.f42a.f270c);
                    }
                }
            });
        }
        return a;
    }

    public void start() {
    }

    public void stop() {
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.f285r.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.f283p, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.f283p);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f273f.m75a(z);
        if (z && this.f269b != null) {
            nativeSoftInputLostFocus();
            reportSoftInputStr(null, 1, false);
        }
        if (z) {
            this.f268a.m23c();
        } else {
            this.f268a.m25d();
        }
        m163f();
    }
}
