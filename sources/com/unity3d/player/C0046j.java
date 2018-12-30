package com.unity3d.player;

import android.os.Build.VERSION;

/* renamed from: com.unity3d.player.j */
public final class C0046j {
    /* renamed from: a */
    static final boolean f145a = (VERSION.SDK_INT >= 19);
    /* renamed from: b */
    static final boolean f146b = (VERSION.SDK_INT >= 21);
    /* renamed from: c */
    static final boolean f147c;
    /* renamed from: d */
    static final C0042e f148d;

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 23) {
            z = false;
        }
        f147c = z;
        f148d = z ? new C0082h() : null;
    }
}
