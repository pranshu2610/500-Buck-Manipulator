package com.vuforia;

public class Trackable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Trackable(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Trackable trackable) {
        return trackable == null ? 0 : trackable.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Trackable(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public Object getUserData() {
        return Vuforia.retrieveFromUserDataMap(Integer.valueOf(getId()));
    }

    public boolean setUserData(Object obj) {
        return Vuforia.updateUserDataMap(Integer.valueOf(getId()), obj);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Trackable) && ((Trackable) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Trackable_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Trackable_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Trackable_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public int getId() {
        return VuforiaJNI.Trackable_getId(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.Trackable_getName(this.swigCPtr, this);
    }
}
