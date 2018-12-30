package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;

public class Camera2Wrapper implements C0041d {
    /* renamed from: a */
    private Context f249a;
    /* renamed from: b */
    private C0035a f250b = null;

    public Camera2Wrapper(Context context) {
        this.f249a = context;
        initCamera2Jni();
    }

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    /* renamed from: a */
    public final void m114a() {
        closeCamera2();
    }

    /* renamed from: a */
    public final void mo1a(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    protected void closeCamera2() {
        if (this.f250b != null) {
            this.f250b.m51b();
        }
        this.f250b = null;
    }

    protected int getCamera2Count() {
        return C0046j.f146b ? C0035a.m27a(this.f249a) : 0;
    }

    protected int getCamera2SensorOrientation(int i) {
        return C0046j.f146b ? C0035a.m28a(this.f249a, i) : 0;
    }

    protected Rect getFrameSizeCamera2() {
        return this.f250b != null ? this.f250b.m49a() : new Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4) {
        if (!C0046j.f146b || this.f250b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        this.f250b = new C0035a(this);
        return this.f250b.m50a(this.f249a, i, i2, i3, i4);
    }

    protected boolean isCamera2FrontFacing(int i) {
        return C0046j.f146b ? C0035a.m37b(this.f249a, i) : false;
    }

    protected void startCamera2() {
        if (this.f250b != null) {
            this.f250b.m52c();
        }
    }

    protected void stopCamera2() {
        if (this.f250b != null) {
            this.f250b.m53d();
        }
    }
}
