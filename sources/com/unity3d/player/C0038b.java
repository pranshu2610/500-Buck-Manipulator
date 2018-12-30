package com.unity3d.player;

import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.unity3d.player.b */
public final class C0038b extends SSLSocketFactory {
    /* renamed from: c */
    private static volatile SSLSocketFactory f128c;
    /* renamed from: d */
    private static volatile X509TrustManager f129d;
    /* renamed from: e */
    private static final Object f130e = new Object[0];
    /* renamed from: f */
    private static final Object f131f = new Object[0];
    /* renamed from: g */
    private static final boolean f132g;
    /* renamed from: a */
    private final SSLSocketFactory f133a;
    /* renamed from: b */
    private final C0036a f134b = null;

    /* renamed from: com.unity3d.player.b$a */
    class C0036a implements HandshakeCompletedListener {
        public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            SSLSession session = handshakeCompletedEvent.getSession();
            session.getCipherSuite();
            session.getProtocol();
            try {
                session.getPeerPrincipal().getName();
            } catch (SSLPeerUnverifiedException e) {
            }
        }
    }

    /* renamed from: com.unity3d.player.b$b */
    public static abstract class C0037b implements X509TrustManager {
        /* renamed from: a */
        protected X509TrustManager f127a = C0038b.m58c();

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f127a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f127a.checkServerTrusted(x509CertificateArr, str);
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return this.f127a.getAcceptedIssuers();
        }
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT < 20) {
            z = true;
        }
        f132g = z;
    }

    private C0038b(C0037b[] c0037bArr) {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, c0037bArr, null);
        this.f133a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private Socket m54a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            if (f132g) {
                ((SSLSocket) socket).setEnabledProtocols(((SSLSocket) socket).getSupportedProtocols());
            }
            if (this.f134b != null) {
                ((SSLSocket) socket).addHandshakeCompletedListener(this.f134b);
            }
        }
        return socket;
    }

    /* renamed from: a */
    public static SSLSocketFactory m55a(C0037b c0037b) {
        if (c0037b == null) {
            try {
                return C0038b.m57b();
            } catch (Exception e) {
                C0044g.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e.getMessage() + ")");
                return null;
            }
        }
        return new C0038b(new C0037b[]{c0037b});
    }

    /* renamed from: b */
    private static SSLSocketFactory m57b() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (f130e) {
            if (f128c != null) {
                sSLSocketFactory = f128c;
            } else {
                sSLSocketFactory = new C0038b(null);
                f128c = sSLSocketFactory;
            }
        }
        return sSLSocketFactory;
    }

    /* renamed from: c */
    private static X509TrustManager m58c() {
        synchronized (f131f) {
            if (f129d != null) {
                return f129d;
            }
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(null);
                for (TrustManager trustManager : instance.getTrustManagers()) {
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        f129d = x509TrustManager;
                        return x509TrustManager;
                    }
                }
            } catch (Exception e) {
                C0044g.Log(5, "CustomSSLSocketFactory: Failed to find X509TrustManager (" + e.getMessage() + ")");
                return null;
            }
        }
    }

    public final Socket createSocket() {
        return m54a(this.f133a.createSocket());
    }

    public final Socket createSocket(String str, int i) {
        return m54a(this.f133a.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m54a(this.f133a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m54a(this.f133a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m54a(this.f133a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m54a(this.f133a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f133a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f133a.getSupportedCipherSuites();
    }
}
