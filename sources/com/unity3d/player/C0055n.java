package com.unity3d.player;

/* renamed from: com.unity3d.player.n */
final class C0055n {
    /* renamed from: a */
    private static boolean f168a = false;
    /* renamed from: b */
    private boolean f169b;
    /* renamed from: c */
    private boolean f170c;
    /* renamed from: d */
    private boolean f171d;
    /* renamed from: e */
    private boolean f172e;

    C0055n() {
        this.f169b = !C0046j.f147c;
        this.f170c = false;
        this.f171d = false;
        this.f172e = true;
    }

    /* renamed from: a */
    static void m72a() {
        f168a = true;
    }

    /* renamed from: b */
    static void m73b() {
        f168a = false;
    }

    /* renamed from: c */
    static boolean m74c() {
        return f168a;
    }

    /* renamed from: a */
    final void m75a(boolean z) {
        this.f170c = z;
    }

    /* renamed from: b */
    final void m76b(boolean z) {
        this.f172e = z;
    }

    /* renamed from: c */
    final void m77c(boolean z) {
        this.f171d = z;
    }

    /* renamed from: d */
    final void m78d() {
        this.f169b = true;
    }

    /* renamed from: e */
    final boolean m79e() {
        return this.f172e;
    }

    /* renamed from: f */
    final boolean m80f() {
        return f168a && this.f170c && this.f169b && !this.f172e && !this.f171d;
    }

    /* renamed from: g */
    final boolean m81g() {
        return this.f171d;
    }

    public final String toString() {
        return super.toString();
    }
}
