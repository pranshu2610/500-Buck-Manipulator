package com.vuforia.ar.pl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ImageTools {
    private static final int CAMERA_IMAGE_FORMAT_LUM = 268439809;
    private static final int CAMERA_IMAGE_FORMAT_NV12 = 268439815;
    private static final int CAMERA_IMAGE_FORMAT_NV21 = 268439817;
    private static final int CAMERA_IMAGE_FORMAT_RGB565 = 268439810;
    private static final String MODULENAME = "ImageTools";

    public static byte[] encodeImage(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        if (bArr == null) {
            return null;
        }
        OutputStream byteArrayOutputStream;
        if (i3 == CAMERA_IMAGE_FORMAT_NV21) {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            if (yuvImage.compressToJpeg(new Rect(0, 0, i, i2), i5, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        } else if (i3 != CAMERA_IMAGE_FORMAT_LUM) {
            return null;
        } else {
            int i6 = i * i2;
            int[] iArr = new int[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i7] = (bArr[i7] << 24) | 16777215;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, 0, i, i, i2, Config.ARGB_8888);
            byteArrayOutputStream = new ByteArrayOutputStream();
            if (createBitmap.compress(CompressFormat.JPEG, i5, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
    }
}
