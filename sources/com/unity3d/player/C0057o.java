package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.unity3d.player.o */
final class C0057o {
    /* renamed from: a */
    private HashMap f176a = new HashMap();
    /* renamed from: b */
    private Class f177b = null;
    /* renamed from: c */
    private Object f178c = null;

    /* renamed from: com.unity3d.player.o$a */
    class C0056a {
        /* renamed from: a */
        public Class[] f173a;
        /* renamed from: b */
        public Method f174b = null;
        /* renamed from: c */
        final /* synthetic */ C0057o f175c;

        public C0056a(C0057o c0057o, Class[] clsArr) {
            this.f175c = c0057o;
            this.f173a = clsArr;
        }
    }

    public C0057o(Class cls, Object obj) {
        this.f177b = cls;
        this.f178c = obj;
    }

    /* renamed from: a */
    private void m82a(String str, C0056a c0056a) {
        try {
            c0056a.f174b = this.f177b.getMethod(str, c0056a.f173a);
        } catch (Exception e) {
            C0044g.Log(6, "Exception while trying to get method " + str + ". " + e.getLocalizedMessage());
            c0056a.f174b = null;
        }
    }

    /* renamed from: a */
    public final Object m83a(String str, Object... objArr) {
        if (this.f176a.containsKey(str)) {
            C0056a c0056a = (C0056a) this.f176a.get(str);
            if (c0056a.f174b == null) {
                m82a(str, c0056a);
            }
            if (c0056a.f174b == null) {
                C0044g.Log(6, "Unable to create method: " + str);
                return null;
            }
            Object invoke;
            try {
                invoke = objArr.length == 0 ? c0056a.f174b.invoke(this.f178c, new Object[0]) : c0056a.f174b.invoke(this.f178c, objArr);
            } catch (Exception e) {
                C0044g.Log(6, "Error trying to call delegated method " + str + ". " + e.getLocalizedMessage());
                invoke = null;
            }
            return invoke;
        }
        C0044g.Log(6, "No definition for method " + str + " can be found");
        return null;
    }

    /* renamed from: a */
    public final void m84a(String str, Class[] clsArr) {
        this.f176a.put(str, new C0056a(this, clsArr));
    }
}
