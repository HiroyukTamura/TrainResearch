// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.WriterException;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.Writer;

public abstract class OneDimensionalCodeWriter implements Writer
{
    protected static int appendPattern(final boolean[] array, int n, final int[] array2, boolean b) {
        int n2 = 0;
        for (int length = array2.length, i = 0; i < length; ++i) {
            final int n3 = array2[i];
            for (int j = 0; j < n3; ++j, ++n) {
                array[n] = b;
            }
            n2 += n3;
            if (!b) {
                b = true;
            }
            else {
                b = false;
            }
        }
        return n2;
    }
    
    private static BitMatrix renderResult(final boolean[] array, int a, int i, int max) {
        final int length = array.length;
        final int b = length + max;
        final int max2 = Math.max(a, b);
        max = Math.max(1, i);
        final int n = max2 / b;
        a = (max2 - length * n) / 2;
        final BitMatrix bitMatrix = new BitMatrix(max2, max);
        for (i = 0; i < length; ++i, a += n) {
            if (array[i]) {
                bitMatrix.setRegion(a, 0, n, max);
            }
        }
        return bitMatrix;
    }
    
    @Override
    public final BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        return this.encode(s, barcodeFormat, n, n2, null);
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int i, final int j, final Map<EncodeHintType, ?> map) throws WriterException {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + j);
        }
        int n = this.getDefaultMargin();
        if (map != null) {
            n = n;
            if (map.containsKey(EncodeHintType.MARGIN)) {
                n = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
        }
        return renderResult(this.encode(s), i, j, n);
    }
    
    public abstract boolean[] encode(final String p0);
    
    public int getDefaultMargin() {
        return 10;
    }
}
