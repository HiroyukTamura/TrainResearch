// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.WriterException;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.BarcodeFormat;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import com.google.zxing.common.BitMatrix;

public class BarcodeEncoder
{
    private static final int BLACK = -16777216;
    private static final int WHITE = -1;
    
    public Bitmap createBitmap(final BitMatrix bitMatrix) {
        final int width = bitMatrix.getWidth();
        final int height = bitMatrix.getHeight();
        final int[] array = new int[width * height];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int n;
                if (bitMatrix.get(j, i)) {
                    n = -16777216;
                }
                else {
                    n = -1;
                }
                array[i * width + j] = n;
            }
        }
        final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap$Config.ARGB_8888);
        bitmap.setPixels(array, 0, width, 0, 0, width, height);
        return bitmap;
    }
    
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        try {
            return new MultiFormatWriter().encode(s, barcodeFormat, n, n2);
        }
        catch (WriterException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            throw new WriterException(ex2);
        }
    }
    
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        try {
            return new MultiFormatWriter().encode(s, barcodeFormat, n, n2, map);
        }
        catch (WriterException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            throw new WriterException(ex2);
        }
    }
    
    public Bitmap encodeBitmap(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        return this.createBitmap(this.encode(s, barcodeFormat, n, n2));
    }
    
    public Bitmap encodeBitmap(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        return this.createBitmap(this.encode(s, barcodeFormat, n, n2, map));
    }
}
