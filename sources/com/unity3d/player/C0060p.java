package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.unity3d.player.p */
public final class C0060p extends FrameLayout implements OnBufferingUpdateListener, OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener, Callback, MediaPlayerControl {
    /* renamed from: a */
    private static boolean f182a = false;
    /* renamed from: b */
    private final Context f183b;
    /* renamed from: c */
    private final SurfaceView f184c;
    /* renamed from: d */
    private final SurfaceHolder f185d;
    /* renamed from: e */
    private final String f186e;
    /* renamed from: f */
    private final int f187f;
    /* renamed from: g */
    private final int f188g;
    /* renamed from: h */
    private final boolean f189h;
    /* renamed from: i */
    private final long f190i;
    /* renamed from: j */
    private final long f191j;
    /* renamed from: k */
    private final FrameLayout f192k;
    /* renamed from: l */
    private final Display f193l;
    /* renamed from: m */
    private int f194m;
    /* renamed from: n */
    private int f195n;
    /* renamed from: o */
    private int f196o;
    /* renamed from: p */
    private int f197p;
    /* renamed from: q */
    private MediaPlayer f198q;
    /* renamed from: r */
    private MediaController f199r;
    /* renamed from: s */
    private boolean f200s = false;
    /* renamed from: t */
    private boolean f201t = false;
    /* renamed from: u */
    private int f202u = 0;
    /* renamed from: v */
    private boolean f203v = false;
    /* renamed from: w */
    private boolean f204w = false;
    /* renamed from: x */
    private C0058a f205x;
    /* renamed from: y */
    private C0059b f206y;
    /* renamed from: z */
    private volatile int f207z = 0;

    /* renamed from: com.unity3d.player.p$a */
    public interface C0058a {
        /* renamed from: a */
        void mo13a(int i);
    }

    /* renamed from: com.unity3d.player.p$b */
    public class C0059b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0060p f179a;
        /* renamed from: b */
        private C0060p f180b;
        /* renamed from: c */
        private boolean f181c = false;

        public C0059b(C0060p c0060p, C0060p c0060p2) {
            this.f179a = c0060p;
            this.f180b = c0060p2;
        }

        /* renamed from: a */
        public final void m86a() {
            this.f181c = true;
        }

        public final void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!this.f181c) {
                if (C0060p.f182a) {
                    C0060p.m89b("Stopping the video player due to timeout.");
                }
                this.f180b.CancelOnPrepare();
            }
        }
    }

    protected C0060p(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C0058a c0058a) {
        super(context);
        this.f205x = c0058a;
        this.f183b = context;
        this.f192k = this;
        this.f184c = new SurfaceView(context);
        this.f185d = this.f184c.getHolder();
        this.f185d.addCallback(this);
        this.f192k.setBackgroundColor(i);
        this.f192k.addView(this.f184c);
        this.f193l = ((WindowManager) this.f183b.getSystemService("window")).getDefaultDisplay();
        this.f186e = str;
        this.f187f = i2;
        this.f188g = i3;
        this.f189h = z;
        this.f190i = j;
        this.f191j = j2;
        if (f182a) {
            C0060p.m89b("fileName: " + this.f186e);
        }
        if (f182a) {
            C0060p.m89b("backgroundColor: " + i);
        }
        if (f182a) {
            C0060p.m89b("controlMode: " + this.f187f);
        }
        if (f182a) {
            C0060p.m89b("scalingMode: " + this.f188g);
        }
        if (f182a) {
            C0060p.m89b("isURL: " + this.f189h);
        }
        if (f182a) {
            C0060p.m89b("videoOffset: " + this.f190i);
        }
        if (f182a) {
            C0060p.m89b("videoLength: " + this.f191j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m87a(int i) {
        this.f207z = i;
        if (this.f205x != null) {
            this.f205x.mo13a(this.f207z);
        }
    }

    /* renamed from: b */
    private static void m89b(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    /* renamed from: c */
    private void m91c() {
        if (this.f198q != null) {
            this.f198q.setDisplay(this.f185d);
            if (!this.f203v) {
                if (f182a) {
                    C0060p.m89b("Resuming playback");
                }
                this.f198q.start();
                return;
            }
            return;
        }
        m87a(0);
        doCleanUp();
        try {
            this.f198q = new MediaPlayer();
            if (this.f189h) {
                this.f198q.setDataSource(this.f183b, Uri.parse(this.f186e));
            } else if (this.f191j != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.f186e);
                this.f198q.setDataSource(fileInputStream.getFD(), this.f190i, this.f191j);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f186e);
                    this.f198q.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                } catch (IOException e) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f186e);
                    this.f198q.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.f198q.setDisplay(this.f185d);
            this.f198q.setScreenOnWhilePlaying(true);
            this.f198q.setOnBufferingUpdateListener(this);
            this.f198q.setOnCompletionListener(this);
            this.f198q.setOnPreparedListener(this);
            this.f198q.setOnVideoSizeChangedListener(this);
            this.f198q.setAudioStreamType(3);
            this.f198q.prepareAsync();
            this.f206y = new C0059b(this, this);
            new Thread(this.f206y).start();
        } catch (Exception e2) {
            if (f182a) {
                C0060p.m89b("error: " + e2.getMessage() + e2);
            }
            m87a(2);
        }
    }

    /* renamed from: d */
    private void m92d() {
        if (!isPlaying()) {
            m87a(1);
            if (f182a) {
                C0060p.m89b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f203v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        m87a(2);
    }

    /* renamed from: a */
    final boolean m93a() {
        return this.f203v;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    protected final void destroyPlayer() {
        if (f182a) {
            C0060p.m89b("destroyPlayer");
        }
        if (!this.f203v) {
            pause();
        }
        doCleanUp();
    }

    protected final void doCleanUp() {
        if (this.f206y != null) {
            this.f206y.m86a();
            this.f206y = null;
        }
        if (this.f198q != null) {
            this.f198q.release();
            this.f198q = null;
        }
        this.f196o = 0;
        this.f197p = 0;
        this.f201t = false;
        this.f200s = false;
    }

    public final int getBufferPercentage() {
        return this.f189h ? this.f202u : 100;
    }

    public final int getCurrentPosition() {
        return this.f198q == null ? 0 : this.f198q.getCurrentPosition();
    }

    public final int getDuration() {
        return this.f198q == null ? 0 : this.f198q.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f201t && this.f200s;
        return this.f198q == null ? !z : this.f198q.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f182a) {
            C0060p.m89b("onBufferingUpdate percent:" + i);
        }
        this.f202u = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f182a) {
            C0060p.m89b("onCompletion called");
        }
        destroyPlayer();
        m87a(3);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f187f != 2 || i == 0 || keyEvent.isSystem())) {
            return this.f199r != null ? this.f199r.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        } else {
            destroyPlayer();
            m87a(3);
            return true;
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f182a) {
            C0060p.m89b("onPrepared called");
        }
        if (this.f206y != null) {
            this.f206y.m86a();
            this.f206y = null;
        }
        if (this.f187f == 0 || this.f187f == 1) {
            this.f199r = new MediaController(this.f183b);
            this.f199r.setMediaPlayer(this);
            this.f199r.setAnchorView(this);
            this.f199r.setEnabled(true);
            this.f199r.show();
        }
        this.f201t = true;
        if (this.f201t && this.f200s) {
            m92d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f187f != 2 || action != 0) {
            return this.f199r != null ? this.f199r.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        } else {
            destroyPlayer();
            m87a(3);
            return true;
        }
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f182a) {
            C0060p.m89b("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.f200s = true;
            this.f196o = i;
            this.f197p = i2;
            if (this.f201t && this.f200s) {
                m92d();
            }
        } else if (f182a) {
            C0060p.m89b("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    public final void pause() {
        if (this.f198q != null) {
            if (this.f204w) {
                this.f198q.pause();
            }
            this.f203v = true;
        }
    }

    public final void seekTo(int i) {
        if (this.f198q != null) {
            this.f198q.seekTo(i);
        }
    }

    public final void start() {
        if (f182a) {
            C0060p.m89b("Start");
        }
        if (this.f198q != null) {
            if (this.f204w) {
                this.f198q.start();
            }
            this.f203v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f182a) {
            C0060p.m89b("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f194m != i2 || this.f195n != i3) {
            this.f194m = i2;
            this.f195n = i3;
            if (this.f204w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f182a) {
            C0060p.m89b("surfaceCreated called");
        }
        this.f204w = true;
        m91c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f182a) {
            C0060p.m89b("surfaceDestroyed called");
        }
        this.f204w = false;
    }

    protected final void updateVideoLayout() {
        if (f182a) {
            C0060p.m89b("updateVideoLayout");
        }
        if (this.f198q != null) {
            if (this.f194m == 0 || this.f195n == 0) {
                WindowManager windowManager = (WindowManager) this.f183b.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.f194m = displayMetrics.widthPixels;
                this.f195n = displayMetrics.heightPixels;
            }
            int i = this.f194m;
            int i2 = this.f195n;
            if (this.f200s) {
                float f = ((float) this.f196o) / ((float) this.f197p);
                float f2 = ((float) this.f194m) / ((float) this.f195n);
                if (this.f188g == 1) {
                    if (f2 <= f) {
                        i2 = (int) (((float) this.f194m) / f);
                    } else {
                        i = (int) (((float) this.f195n) * f);
                    }
                } else if (this.f188g == 2) {
                    if (f2 >= f) {
                        i2 = (int) (((float) this.f194m) / f);
                    } else {
                        i = (int) (((float) this.f195n) * f);
                    }
                } else if (this.f188g == 0) {
                    i = this.f196o;
                    i2 = this.f197p;
                }
            } else if (f182a) {
                C0060p.m89b("updateVideoLayout: Video size is not known yet");
            }
            if (this.f194m != i || this.f195n != i2) {
                if (f182a) {
                    C0060p.m89b("frameWidth = " + i + "; frameHeight = " + i2);
                }
                this.f192k.updateViewLayout(this.f184c, new LayoutParams(i, i2, 17));
            }
        }
    }
}
