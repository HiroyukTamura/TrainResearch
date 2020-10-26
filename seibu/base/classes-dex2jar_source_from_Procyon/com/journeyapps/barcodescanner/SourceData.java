// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.PlanarYUVLuminanceSource;
import android.graphics.Matrix;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import android.graphics.YuvImage;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class SourceData
{
    private Rect cropRect;
    private byte[] data;
    private int dataHeight;
    private int dataWidth;
    private int imageFormat;
    private int rotation;
    
    public SourceData(final byte[] data, final int n, final int n2, final int imageFormat, final int rotation) {
        this.data = data;
        this.dataWidth = n;
        this.dataHeight = n2;
        this.rotation = rotation;
        this.imageFormat = imageFormat;
        if (n * n2 > data.length) {
            throw new IllegalArgumentException("Image data does not match the resolution. " + n + "x" + n2 + " > " + data.length);
        }
    }
    
    private Bitmap getBitmap(final Rect rect, final int inSampleSize) {
        Rect rect2 = rect;
        if (this.isRotated()) {
            rect2 = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        final YuvImage yuvImage = new YuvImage(this.data, this.imageFormat, this.dataWidth, this.dataHeight, (int[])null);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect2, 90, (OutputStream)byteArrayOutputStream);
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inSampleSize = inSampleSize;
        Bitmap bitmap2;
        final Bitmap bitmap = bitmap2 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, bitmapFactory$Options);
        if (this.rotation != 0) {
            final Matrix matrix = new Matrix();
            matrix.postRotate((float)this.rotation);
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        }
        return bitmap2;
    }
    
    public static byte[] rotate180(final byte[] array, int i, int n) {
        final int n2 = i * n;
        final byte[] array2 = new byte[n2];
        n = n2 - 1;
        for (i = 0; i < n2; ++i) {
            array2[n] = array[i];
            --n;
        }
        return array2;
    }
    
    public static byte[] rotateCCW(final byte[] array, final int n, final int n2) {
        final int n3 = n * n2;
        final byte[] array2 = new byte[n3];
        int n4 = n3 - 1;
        for (int i = 0; i < n; ++i) {
            for (int j = n2 - 1; j >= 0; --j) {
                array2[n4] = array[j * n + i];
                --n4;
            }
        }
        return array2;
    }
    
    public static byte[] rotateCW(final byte[] array, final int n, final int n2) {
        final byte[] array2 = new byte[n * n2];
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = n2 - 1; j >= 0; --j) {
                array2[n3] = array[j * n + i];
                ++n3;
            }
        }
        return array2;
    }
    
    public static byte[] rotateCameraPreview(final int n, final byte[] array, final int n2, final int n3) {
        switch (n) {
            default: {
                return array;
            }
            case 90: {
                return rotateCW(array, n2, n3);
            }
            case 180: {
                return rotate180(array, n2, n3);
            }
            case 270: {
                return rotateCCW(array, n2, n3);
            }
        }
    }
    
    public PlanarYUVLuminanceSource createSource() {
        final byte[] rotateCameraPreview = rotateCameraPreview(this.rotation, this.data, this.dataWidth, this.dataHeight);
        if (this.isRotated()) {
            return new PlanarYUVLuminanceSource(rotateCameraPreview, this.dataHeight, this.dataWidth, this.cropRect.left, this.cropRect.top, this.cropRect.width(), this.cropRect.height(), false);
        }
        return new PlanarYUVLuminanceSource(rotateCameraPreview, this.dataWidth, this.dataHeight, this.cropRect.left, this.cropRect.top, this.cropRect.width(), this.cropRect.height(), false);
    }
    
    public Bitmap getBitmap() {
        return this.getBitmap(1);
    }
    
    public Bitmap getBitmap(final int n) {
        return this.getBitmap(this.cropRect, n);
    }
    
    public Rect getCropRect() {
        return this.cropRect;
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public int getDataHeight() {
        return this.dataHeight;
    }
    
    public int getDataWidth() {
        return this.dataWidth;
    }
    
    public int getImageFormat() {
        return this.imageFormat;
    }
    
    public boolean isRotated() {
        return this.rotation % 180 != 0;
    }
    
    public void setCropRect(final Rect cropRect) {
        this.cropRect = cropRect;
    }
}
