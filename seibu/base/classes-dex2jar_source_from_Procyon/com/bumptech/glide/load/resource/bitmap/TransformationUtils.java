// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import android.os.Build$VERSION;
import android.graphics.RectF;
import android.annotation.TargetApi;
import android.media.ExifInterface;
import android.graphics.Bitmap$Config;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Bitmap;

public final class TransformationUtils
{
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";
    
    private TransformationUtils() {
    }
    
    public static Bitmap centerCrop(Bitmap bitmap, final Bitmap bitmap2, final int n, final int n2) {
        if (bitmap2 != null) {
            if (bitmap2.getWidth() == n) {
                final Bitmap bitmap3 = bitmap2;
                if (bitmap2.getHeight() == n2) {
                    return bitmap3;
                }
            }
            float n3 = 0.0f;
            float n4 = 0.0f;
            final Matrix matrix = new Matrix();
            float n5;
            if (bitmap2.getWidth() * n2 > bitmap2.getHeight() * n) {
                n5 = n2 / (float)bitmap2.getHeight();
                n3 = (n - bitmap2.getWidth() * n5) * 0.5f;
            }
            else {
                n5 = n / (float)bitmap2.getWidth();
                n4 = (n2 - bitmap2.getHeight() * n5) * 0.5f;
            }
            matrix.setScale(n5, n5);
            matrix.postTranslate((float)(int)(n3 + 0.5f), (float)(int)(n4 + 0.5f));
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(n, n2, getSafeConfig(bitmap2));
            }
            setAlpha(bitmap2, bitmap);
            new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
            return bitmap;
        }
        return null;
    }
    
    public static Bitmap fitCenter(final Bitmap bitmap, final BitmapPool bitmapPool, final int i, final int j) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == j) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
        }
        else {
            final float min = Math.min(i / (float)bitmap.getWidth(), j / (float)bitmap.getHeight());
            final int n = (int)(bitmap.getWidth() * min);
            final int n2 = (int)(bitmap.getHeight() * min);
            if (bitmap.getWidth() != n || bitmap.getHeight() != n2) {
                final Bitmap$Config safeConfig = getSafeConfig(bitmap);
                Bitmap bitmap2;
                if ((bitmap2 = bitmapPool.get(n, n2, safeConfig)) == null) {
                    bitmap2 = Bitmap.createBitmap(n, n2, safeConfig);
                }
                setAlpha(bitmap, bitmap2);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i + "x" + j);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
                    Log.v("TransformationUtils", "minPct:   " + min);
                }
                final Canvas canvas = new Canvas(bitmap2);
                final Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                canvas.drawBitmap(bitmap, matrix, new Paint(6));
                return bitmap2;
            }
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return bitmap;
            }
        }
        return bitmap;
    }
    
    public static int getExifOrientationDegrees(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 5:
            case 6: {
                return 90;
            }
            case 3:
            case 4: {
                return 180;
            }
            case 7:
            case 8: {
                return 270;
            }
        }
    }
    
    @Deprecated
    @TargetApi(5)
    public static int getOrientation(final String str) {
        int exifOrientationDegrees = 0;
        try {
            exifOrientationDegrees = getExifOrientationDegrees(new ExifInterface(str).getAttributeInt("Orientation", 0));
            return exifOrientationDegrees;
        }
        catch (Exception ex) {
            if (Log.isLoggable("TransformationUtils", 6)) {
                Log.e("TransformationUtils", "Unable to get orientation for image with path=" + str, (Throwable)ex);
                return 0;
            }
            return exifOrientationDegrees;
        }
    }
    
    private static Bitmap$Config getSafeConfig(final Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap$Config.ARGB_8888;
    }
    
    static void initializeMatrixForRotation(final int n, final Matrix matrix) {
        switch (n) {
            default: {}
            case 2: {
                matrix.setScale(-1.0f, 1.0f);
            }
            case 3: {
                matrix.setRotate(180.0f);
            }
            case 4: {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
            }
            case 5: {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
            }
            case 6: {
                matrix.setRotate(90.0f);
            }
            case 7: {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
            }
            case 8: {
                matrix.setRotate(-90.0f);
            }
        }
    }
    
    @Deprecated
    public static Bitmap orientImage(final String s, final Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(s));
    }
    
    public static Bitmap rotateImage(final Bitmap bitmap, final int n) {
        Bitmap bitmap2 = bitmap;
        if (n == 0) {
            return bitmap2;
        }
        try {
            final Matrix matrix = new Matrix();
            matrix.setRotate((float)n);
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap2;
        }
        catch (Exception ex) {
            bitmap2 = bitmap;
            if (Log.isLoggable("TransformationUtils", 6)) {
                Log.e("TransformationUtils", "Exception when trying to orient image", (Throwable)ex);
                return bitmap;
            }
            return bitmap2;
        }
    }
    
    public static Bitmap rotateImageExif(final Bitmap bitmap, final BitmapPool bitmapPool, int round) {
        final Matrix matrix = new Matrix();
        initializeMatrixForRotation(round, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        final RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        round = Math.round(rectF.width());
        final int round2 = Math.round(rectF.height());
        final Bitmap$Config safeConfig = getSafeConfig(bitmap);
        Bitmap bitmap2;
        if ((bitmap2 = bitmapPool.get(round, round2, safeConfig)) == null) {
            bitmap2 = Bitmap.createBitmap(round, round2, safeConfig);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }
    
    @TargetApi(12)
    public static void setAlpha(final Bitmap bitmap, final Bitmap bitmap2) {
        if (Build$VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
