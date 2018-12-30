package com.vuforia;

public class StateUpdater {
    private static State sState = null;
    private static final Object sStateMutex = new Object();
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected StateUpdater(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StateUpdater stateUpdater) {
        return stateUpdater == null ? 0 : stateUpdater.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_StateUpdater(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof StateUpdater) && ((StateUpdater) obj).swigCPtr == this.swigCPtr) {
            return true;
        }
        return false;
    }

    public State updateState() {
        synchronized (sStateMutex) {
            if (sState != null) {
                sState.delete();
            }
            sState = new State(VuforiaJNI.StateUpdater_updateState(this.swigCPtr, this), true);
        }
        return sState;
    }

    public State getLatestState() {
        State state;
        synchronized (sStateMutex) {
            state = sState;
        }
        return state;
    }

    public double getCurrentTimeStamp() {
        return VuforiaJNI.StateUpdater_getCurrentTimeStamp(this.swigCPtr, this);
    }
}
