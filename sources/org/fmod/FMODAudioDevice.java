package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {
    /* renamed from: h */
    private static int f229h = 0;
    /* renamed from: i */
    private static int f230i = 1;
    /* renamed from: j */
    private static int f231j = 2;
    /* renamed from: k */
    private static int f232k = 3;
    /* renamed from: a */
    private volatile Thread f233a = null;
    /* renamed from: b */
    private volatile boolean f234b = false;
    /* renamed from: c */
    private AudioTrack f235c = null;
    /* renamed from: d */
    private boolean f236d = false;
    /* renamed from: e */
    private ByteBuffer f237e = null;
    /* renamed from: f */
    private byte[] f238f = null;
    /* renamed from: g */
    private volatile C0079a f239g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        if (this.f235c != null) {
            if (this.f235c.getState() == 1) {
                this.f235c.stop();
            }
            this.f235c.release();
            this.f235c = null;
        }
        this.f237e = null;
        this.f238f = null;
        this.f236d = false;
    }

    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f233a != null && this.f233a.isAlive();
    }

    public void run() {
        int i = 3;
        while (this.f234b) {
            int i2;
            if (this.f236d || i <= 0) {
                i2 = i;
            } else {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f229h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f230i);
                i2 = fmodGetInfo(f231j);
                if ((fmodGetInfo2 * i2) * 4 > round) {
                    round = (i2 * fmodGetInfo2) * 4;
                }
                this.f235c = new AudioTrack(3, fmodGetInfo, 3, 2, round, 1);
                this.f236d = this.f235c.getState() == 1;
                if (this.f236d) {
                    this.f237e = ByteBuffer.allocateDirect((fmodGetInfo2 * 2) * 2);
                    this.f238f = new byte[this.f237e.capacity()];
                    this.f235c.play();
                    i2 = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f235c.getState() + ")");
                    releaseAudioTrack();
                    i2 = i - 1;
                }
            }
            if (!this.f236d) {
                i = i2;
            } else if (fmodGetInfo(f232k) == 1) {
                fmodProcess(this.f237e);
                this.f237e.get(this.f238f, 0, this.f237e.capacity());
                this.f235c.write(this.f238f, 0, this.f237e.capacity());
                this.f237e.position(0);
                i = i2;
            } else {
                releaseAudioTrack();
                i = i2;
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f233a != null) {
            stop();
        }
        this.f233a = new Thread(this, "FMODAudioDevice");
        this.f233a.setPriority(10);
        this.f234b = true;
        this.f233a.start();
        if (this.f239g != null) {
            this.f239g.m112b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f239g == null) {
            this.f239g = new C0079a(this, i, i2);
            this.f239g.m112b();
        }
        return this.f239g.m111a();
    }

    public synchronized void stop() {
        while (this.f233a != null) {
            this.f234b = false;
            try {
                this.f233a.join();
                this.f233a = null;
            } catch (InterruptedException e) {
            }
        }
        if (this.f239g != null) {
            this.f239g.m113c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f239g != null) {
            this.f239g.m113c();
            this.f239g = null;
        }
    }
}
