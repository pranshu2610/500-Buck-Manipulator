package com.unity3d.player;

import java.util.concurrent.atomic.AtomicReference;

public class GoogleVrApi {
    /* renamed from: a */
    private static AtomicReference f8a = new AtomicReference();

    private GoogleVrApi() {
    }

    /* renamed from: a */
    static void m2a() {
        f8a.set(null);
    }

    /* renamed from: a */
    static void m3a(C0043f c0043f) {
        f8a.compareAndSet(null, new GoogleVrProxy(c0043f));
    }

    /* renamed from: b */
    static GoogleVrProxy m4b() {
        return (GoogleVrProxy) f8a.get();
    }

    public static GoogleVrVideo getGoogleVrVideo() {
        return (GoogleVrVideo) f8a.get();
    }
}
