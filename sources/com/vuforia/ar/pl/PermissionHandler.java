package com.vuforia.ar.pl;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public class PermissionHandler {
    private static final int AR_PERMISSIONS_STATUS_DENIED = 2;
    private static final int AR_PERMISSIONS_STATUS_FAILED = 0;
    private static final int AR_PERMISSIONS_STATUS_GRANTED = 3;
    private static final int AR_PERMISSIONS_STATUS_REQUESTED = 1;
    private static final String MODULENAME = "PermissionHandler";
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    private static boolean mIsPermissionsRequested = false;
    private static String[] mPermissionsArrayToRequest;
    private static int mPermissionsStatus = 0;

    public static class PermissionsRequestFragment extends Fragment {
        public void onStart() {
            super.onStart();
            if (!PermissionHandler.mIsPermissionsRequested) {
                requestPermissions(PermissionHandler.mPermissionsArrayToRequest, PermissionHandler.PERMISSIONS_REQUEST_CODE);
                PermissionHandler.mIsPermissionsRequested = true;
            }
        }

        private void removeSelf() {
            FragmentTransaction beginTransaction = getActivity().getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commit();
        }

        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            if (i == PermissionHandler.PERMISSIONS_REQUEST_CODE) {
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        PermissionHandler.mPermissionsStatus = 2;
                        break;
                    }
                }
                if (PermissionHandler.mPermissionsStatus != 2) {
                    PermissionHandler.mPermissionsStatus = 3;
                }
                removeSelf();
            }
        }
    }

    public int requestPermissions(Activity activity, String[] strArr) {
        if (mPermissionsStatus == 3 || mPermissionsStatus == 1 || mPermissionsStatus == 2) {
            return mPermissionsStatus;
        }
        if (activity == null) {
            return 0;
        }
        PackageManager packageManager = activity.getPackageManager();
        List arrayList = new ArrayList(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if (packageManager.checkPermission(strArr[i], activity.getPackageName()) != 0) {
                arrayList.add(strArr[i]);
            }
        }
        if (arrayList.isEmpty()) {
            mPermissionsStatus = 3;
        }
        if (!(VERSION.SDK_INT < 23 || mIsPermissionsRequested || arrayList.isEmpty())) {
            try {
                FragmentManager fragmentManager = activity.getFragmentManager();
                mPermissionsArrayToRequest = (String[]) arrayList.toArray(new String[arrayList.size()]);
                Fragment permissionsRequestFragment = new PermissionsRequestFragment();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(0, permissionsRequestFragment);
                beginTransaction.commit();
                mPermissionsStatus = 1;
            } catch (Exception e) {
                DebugLog.LOGE(MODULENAME, "Failed to request permissions. Exception: " + e.getMessage());
                return 0;
            }
        }
        return mPermissionsStatus;
    }
}
