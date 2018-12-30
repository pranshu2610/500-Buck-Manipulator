package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.vuforia.ar.pl.Camera1_Preview.CameraCacheInfo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceManager {
    private static final String MODULENAME = "SurfaceManager";
    Lock addSurfaceLock = new ReentrantLock();
    View cameraSurfaceParentView = null;
    CameraCacheInfo cciForSurface;
    GLSurfaceView glSurfaceView = null;
    int glSurfaceViewChildPosition = 0;
    boolean renderWhenDirtyEnabled = false;
    Lock viewLock = new ReentrantLock();

    /* renamed from: com.vuforia.ar.pl.SurfaceManager$1 */
    class C00751 implements Runnable {
        C00751() {
        }

        public void run() {
            SurfaceManager.this.addSurfaceLock.lock();
            SurfaceManager.this.retrieveGLSurfaceView();
            try {
                SurfaceManager.this.setupCameraSurface(SurfaceManager.this.cciForSurface);
                ((ViewGroup) SurfaceManager.this.cameraSurfaceParentView).addView(SurfaceManager.this.cciForSurface.surface, SurfaceManager.this.glSurfaceViewChildPosition + 1, new LayoutParams(-1, -1));
                SurfaceManager.this.cciForSurface.surface.setVisibility(0);
            } catch (Exception e) {
            } finally {
                SurfaceManager.this.addSurfaceLock.unlock();
            }
        }
    }

    private GLSurfaceView searchForGLSurfaceView(View view) {
        this.glSurfaceViewChildPosition = 0;
        try {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            GLSurfaceView gLSurfaceView = null;
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                GLSurfaceView gLSurfaceView2;
                if (childAt instanceof GLSurfaceView) {
                    gLSurfaceView2 = (GLSurfaceView) childAt;
                    this.glSurfaceViewChildPosition = i;
                    return gLSurfaceView2;
                }
                if (childAt instanceof ViewGroup) {
                    gLSurfaceView2 = searchForGLSurfaceView(childAt);
                    if (gLSurfaceView2 != null) {
                        return gLSurfaceView2;
                    }
                } else {
                    gLSurfaceView2 = gLSurfaceView;
                }
                i++;
                gLSurfaceView = gLSurfaceView2;
            }
            return gLSurfaceView;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean applyRenderWhenDirty() {
        int i = 0;
        if (this.glSurfaceView == null) {
            return false;
        }
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        if (!this.renderWhenDirtyEnabled) {
            i = 1;
        }
        gLSurfaceView.setRenderMode(i);
        return true;
    }

    private void setupCameraSurface(CameraCacheInfo cameraCacheInfo) {
        if (cameraCacheInfo.surface == null) {
            Context activityFromNative = SystemTools.getActivityFromNative();
            if (activityFromNative != null) {
                cameraCacheInfo.surface = new CameraSurface(activityFromNative);
            } else {
                return;
            }
        } else if (cameraCacheInfo.surface.getParent() != null && ViewGroup.class.isInstance(cameraCacheInfo.surface.getParent())) {
            ((ViewGroup) cameraCacheInfo.surface.getParent()).removeView(cameraCacheInfo.surface);
        }
        cameraCacheInfo.surface.setCamera(cameraCacheInfo.camera);
    }

    public boolean retrieveGLSurfaceView() {
        try {
            Activity activityFromNative = SystemTools.getActivityFromNative();
            if (activityFromNative == null) {
                return false;
            }
            boolean z;
            View decorView = activityFromNative.getWindow().getDecorView();
            this.glSurfaceView = searchForGLSurfaceView(decorView);
            if (this.glSurfaceView == null) {
                this.cameraSurfaceParentView = decorView;
            } else {
                this.cameraSurfaceParentView = (View) this.glSurfaceView.getParent();
            }
            if (this.glSurfaceView != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setEnableRenderWhenDirty(boolean z) {
        this.renderWhenDirtyEnabled = z;
        return applyRenderWhenDirty();
    }

    public void requestRender() {
        if (this.glSurfaceView != null) {
            this.glSurfaceView.requestRender();
        }
    }

    public boolean addCameraSurface(CameraCacheInfo cameraCacheInfo) {
        boolean z = true;
        boolean z2 = false;
        Activity activityFromNative = SystemTools.getActivityFromNative();
        if (activityFromNative == null) {
            return false;
        }
        boolean z3;
        this.cciForSurface = cameraCacheInfo;
        this.viewLock.lock();
        try {
            activityFromNative.runOnUiThread(new C00751());
            z3 = z2;
        } catch (Exception e) {
            z3 = true;
            if (z3) {
                z = z2;
            }
            return z;
        } finally {
            z2 = this.viewLock;
            z2.unlock();
        }
        if (z3) {
            z = z2;
        }
        return z;
    }
}
