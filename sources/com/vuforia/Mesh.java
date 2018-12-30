package com.vuforia;

import java.nio.ByteBuffer;

public class Mesh {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Mesh(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Mesh mesh) {
        return mesh == null ? 0 : mesh.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Mesh(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Mesh) && ((Mesh) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public int getNumVertices() {
        return VuforiaJNI.Mesh_getNumVertices(this.swigCPtr, this);
    }

    public boolean hasPositions() {
        return VuforiaJNI.Mesh_hasPositions(this.swigCPtr, this);
    }

    public ByteBuffer getPositions() {
        return VuforiaJNI.Mesh_getPositions(this.swigCPtr, this);
    }

    public boolean hasNormals() {
        return VuforiaJNI.Mesh_hasNormals(this.swigCPtr, this);
    }

    public ByteBuffer getNormals() {
        return VuforiaJNI.Mesh_getNormals(this.swigCPtr, this);
    }

    public boolean hasUVs() {
        return VuforiaJNI.Mesh_hasUVs(this.swigCPtr, this);
    }

    public ByteBuffer getUVs() {
        return VuforiaJNI.Mesh_getUVs(this.swigCPtr, this);
    }

    public int getNumTriangles() {
        return VuforiaJNI.Mesh_getNumTriangles(this.swigCPtr, this);
    }

    public ByteBuffer getTriangles() {
        return VuforiaJNI.Mesh_getTriangles(this.swigCPtr, this);
    }
}
