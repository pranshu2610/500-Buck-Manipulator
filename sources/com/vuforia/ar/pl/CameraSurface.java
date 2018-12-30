package com.vuforia.ar.pl;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.IOException;

class CameraSurface extends SurfaceView implements Callback {
    private static final String MODULENAME = "CameraSurface";
    Camera camera = null;
    SurfaceHolder surfaceHolder = getHolder();

    public CameraSurface(Context context) {
        super(context);
        this.surfaceHolder.addCallback(this);
        this.surfaceHolder.setType(3);
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            if (this.camera != null) {
                this.camera.setPreviewDisplay(surfaceHolder);
            }
        } catch (IOException e) {
            this.camera = null;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.camera = null;
    }
}
