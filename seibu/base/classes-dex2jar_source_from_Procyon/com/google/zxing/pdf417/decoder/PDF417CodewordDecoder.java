// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import java.lang.reflect.Array;
import com.google.zxing.pdf417.PDF417Common;

final class PDF417CodewordDecoder
{
    private static final float[][] RATIOS_TABLE;
    
    static {
        RATIOS_TABLE = (float[][])Array.newInstance(Float.TYPE, PDF417Common.SYMBOL_TABLE.length, 8);
        for (int i = 0; i < PDF417Common.SYMBOL_TABLE.length; ++i) {
            int n = PDF417Common.SYMBOL_TABLE[i];
            int n2 = n & 0x1;
            for (int j = 0; j < 8; ++j) {
                float n3 = 0.0f;
                while ((n & 0x1) == n2) {
                    ++n3;
                    n >>= 1;
                }
                n2 = (n & 0x1);
                PDF417CodewordDecoder.RATIOS_TABLE[i][8 - j - 1] = n3 / 17.0f;
            }
        }
    }
    
    private PDF417CodewordDecoder() {
    }
    
    private static int getBitValue(final int[] array) {
        long n = 0L;
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i]; ++j) {
                boolean b;
                if (i % 2 == 0) {
                    b = true;
                }
                else {
                    b = false;
                }
                n = (n << 1 | (long)(b ? 1 : 0));
            }
        }
        return (int)n;
    }
    
    private static int getClosestDecodedValue(final int[] array) {
        final int sum = MathUtils.sum(array);
        final float[] array2 = new float[8];
        if (sum > 1) {
            for (int i = 0; i < 8; ++i) {
                array2[i] = array[i] / (float)sum;
            }
        }
        float n = Float.MAX_VALUE;
        int n2 = -1;
        float n7;
        for (int j = 0; j < PDF417CodewordDecoder.RATIOS_TABLE.length; ++j, n = n7) {
            float n3 = 0.0f;
            final float[] array3 = PDF417CodewordDecoder.RATIOS_TABLE[j];
            int n4 = 0;
            float n5;
            while (true) {
                n5 = n3;
                if (n4 >= 8) {
                    break;
                }
                final float n6 = array3[n4] - array2[n4];
                n3 = (n5 = n3 + n6 * n6);
                if (n3 >= n) {
                    break;
                }
                ++n4;
            }
            n7 = n;
            if (n5 < n) {
                n2 = PDF417Common.SYMBOL_TABLE[j];
                n7 = n5;
            }
        }
        return n2;
    }
    
    private static int getDecodedCodewordValue(final int[] array) {
        int bitValue;
        if (PDF417Common.getCodeword(bitValue = getBitValue(array)) == -1) {
            bitValue = -1;
        }
        return bitValue;
    }
    
    static int getDecodedValue(final int[] array) {
        final int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(array));
        if (decodedCodewordValue != -1) {
            return decodedCodewordValue;
        }
        return getClosestDecodedValue(array);
    }
    
    private static int[] sampleBitCounts(final int[] array) {
        final float n = (float)MathUtils.sum(array);
        final int[] array2 = new int[8];
        int n2 = 0;
        int n3 = 0;
        int n6;
        int n7;
        for (int i = 0; i < 17; ++i, n2 = n6, n3 = n7) {
            final float n4 = n / 34.0f;
            final float n5 = i * n / 17.0f;
            n6 = n2;
            n7 = n3;
            if (array[n2] + n3 <= n4 + n5) {
                n7 = n3 + array[n2];
                n6 = n2 + 1;
            }
            ++array2[n6];
        }
        return array2;
    }
}
