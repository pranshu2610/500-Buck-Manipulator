package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
final class C0079a implements Runnable {
    /* renamed from: a */
    private final FMODAudioDevice f240a;
    /* renamed from: b */
    private final ByteBuffer f241b;
    /* renamed from: c */
    private final int f242c;
    /* renamed from: d */
    private final int f243d;
    /* renamed from: e */
    private final int f244e = 2;
    /* renamed from: f */
    private volatile Thread f245f;
    /* renamed from: g */
    private volatile boolean f246g;
    /* renamed from: h */
    private AudioRecord f247h;
    /* renamed from: i */
    private boolean f248i;

    C0079a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f240a = fMODAudioDevice;
        this.f242c = i;
        this.f243d = i2;
        this.f241b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: d */
    private void m110d() {
        if (this.f247h != null) {
            if (this.f247h.getState() == 1) {
                this.f247h.stop();
            }
            this.f247h.release();
            this.f247h = null;
        }
        this.f241b.position(0);
        this.f248i = false;
    }

    /* renamed from: a */
    public final int m111a() {
        return this.f241b.capacity();
    }

    /* renamed from: b */
    public final void m112b() {
        if (this.f245f != null) {
            m113c();
        }
        this.f246g = true;
        this.f245f = new Thread(this);
        this.f245f.start();
    }

    /* renamed from: c */
    public final void m113c() {
        while (this.f245f != null) {
            this.f246g = false;
            try {
                this.f245f.join();
                this.f245f = null;
            } catch (InterruptedException e) {
            }
        }
    }

    public final void run() {
        int i = 3;
        while (this.f246g) {
            int i2;
            if (!this.f248i && i > 0) {
                m110d();
                this.f247h = new AudioRecord(1, this.f242c, this.f243d, this.f244e, this.f241b.capacity());
                this.f248i = this.f247h.getState() == 1;
                if (this.f248i) {
                    this.f241b.position(0);
                    this.f247h.startRecording();
                    i2 = 3;
                    if (this.f248i || this.f247h.getRecordingState() != 3) {
                        i = i2;
                    } else {
                        this.f240a.fmodProcessMicData(this.f241b, this.f247h.read(this.f241b, this.f241b.capacity()));
                        this.f241b.position(0);
                        i = i2;
                    }
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f247h.getState() + ")");
                    i--;
                    m110d();
                }
            }
            i2 = i;
            if (this.f248i) {
            }
            i = i2;
        }
        m110d();
    }
}
