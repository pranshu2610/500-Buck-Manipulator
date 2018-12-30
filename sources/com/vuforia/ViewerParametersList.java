package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ViewerParametersList implements Iterable<ViewerParameters> {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    private class VPIterator implements Iterator<ViewerParameters> {
        private ViewerParameters next = null;

        VPIterator() {
            if (ViewerParametersList.this.size() > 0) {
                this.next = ViewerParametersList.this.begin();
            }
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public ViewerParameters next() throws NoSuchElementException {
            if (this.next != null) {
                ViewerParameters viewerParameters = this.next;
                this.next = ViewerParametersList.this.next(viewerParameters);
                return viewerParameters;
            }
            throw new NoSuchElementException();
        }

        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    protected ViewerParametersList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ViewerParametersList viewerParametersList) {
        return viewerParametersList == null ? 0 : viewerParametersList.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewerParametersList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public Iterator<ViewerParameters> iterator() {
        return new VPIterator();
    }

    public static ViewerParametersList getListForAuthoringTools() {
        return new ViewerParametersList(VuforiaJNI.ViewerParametersList_getListForAuthoringTools(), false);
    }

    public void setSDKFilter(String str) {
        VuforiaJNI.ViewerParametersList_setSDKFilter(this.swigCPtr, this, str);
    }

    public long size() {
        return VuforiaJNI.ViewerParametersList_size(this.swigCPtr, this);
    }

    public ViewerParameters get(long j) {
        long ViewerParametersList_get__SWIG_0 = VuforiaJNI.ViewerParametersList_get__SWIG_0(this.swigCPtr, this, j);
        return ViewerParametersList_get__SWIG_0 == 0 ? null : new ViewerParameters(ViewerParametersList_get__SWIG_0, false);
    }

    public ViewerParameters get(String str, String str2) {
        long ViewerParametersList_get__SWIG_1 = VuforiaJNI.ViewerParametersList_get__SWIG_1(this.swigCPtr, this, str, str2);
        return ViewerParametersList_get__SWIG_1 == 0 ? null : new ViewerParameters(ViewerParametersList_get__SWIG_1, false);
    }

    private ViewerParameters begin() {
        long ViewerParametersList_begin = VuforiaJNI.ViewerParametersList_begin(this.swigCPtr, this);
        return ViewerParametersList_begin == 0 ? null : new ViewerParameters(ViewerParametersList_begin, false);
    }

    private ViewerParameters end() {
        long ViewerParametersList_end = VuforiaJNI.ViewerParametersList_end(this.swigCPtr, this);
        return ViewerParametersList_end == 0 ? null : new ViewerParameters(ViewerParametersList_end, false);
    }

    private ViewerParameters next(ViewerParameters viewerParameters) {
        long ViewerParametersList_next = VuforiaJNI.ViewerParametersList_next(this.swigCPtr, this, ViewerParameters.getCPtr(viewerParameters), viewerParameters);
        return ViewerParametersList_next == 0 ? null : new ViewerParameters(ViewerParametersList_next, false);
    }
}
