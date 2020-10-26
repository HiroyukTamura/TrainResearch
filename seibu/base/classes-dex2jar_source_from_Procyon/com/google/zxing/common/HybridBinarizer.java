// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.google.zxing.Binarizer;
import java.lang.reflect.Array;
import com.google.zxing.LuminanceSource;

public final class HybridBinarizer extends GlobalHistogramBinarizer
{
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;
    
    public HybridBinarizer(final LuminanceSource luminanceSource) {
        super(luminanceSource);
    }
    
    private static int[][] calculateBlackPoints(final byte[] array, final int n, final int n2, final int n3, int n4) {
        final int n5 = n4 - 8;
        final int n6 = n3 - 8;
        final int[][] array2 = (int[][])Array.newInstance(Integer.TYPE, n2, n);
        for (int i = 0; i < n2; ++i) {
            n4 = i << 3;
            int n7;
            if ((n7 = n4) > n5) {
                n7 = n5;
            }
            for (int j = 0; j < n; ++j) {
                if ((n4 = j << 3) > n6) {
                    n4 = n6;
                }
                final int n8 = 0;
                int n9 = 255;
                int n10 = 0;
                int k = 0;
                final int n11 = n7 * n3 + n4;
                n4 = n8;
                int n12 = n11;
                while (k < 8) {
                    int n14;
                    int n15;
                    for (int l = 0; l < 8; ++l, n10 = n15, n9 = n4, n4 = n14) {
                        final int n13 = array[n12 + l] & 0xFF;
                        n14 = n4 + n13;
                        if (n13 < (n4 = n9)) {
                            n4 = n13;
                        }
                        if (n13 > (n15 = n10)) {
                            n15 = n13;
                        }
                    }
                    int n16 = n12;
                    int n17 = n4;
                    int n18 = k;
                    if (n10 - n9 > 24) {
                        final int n19 = k + 1;
                        final int n20 = n12 + n3;
                        int n21 = n19;
                        int n22 = n4;
                        n4 = n20;
                        while (true) {
                            n16 = n4;
                            n17 = n22;
                            n18 = n21;
                            if (n21 >= 8) {
                                break;
                            }
                            for (int n23 = 0; n23 < 8; ++n23) {
                                n22 += (array[n4 + n23] & 0xFF);
                            }
                            ++n21;
                            n4 += n3;
                        }
                    }
                    k = n18 + 1;
                    n12 = n16 + n3;
                    n4 = n17;
                }
                n4 >>= 6;
                if (n10 - n9 <= 24) {
                    final int n24 = n4 = n9 / 2;
                    if (i > 0) {
                        n4 = n24;
                        if (j > 0) {
                            final int n25 = (array2[i - 1][j] + array2[i][j - 1] * 2 + array2[i - 1][j - 1]) / 4;
                            n4 = n24;
                            if (n9 < n25) {
                                n4 = n25;
                            }
                        }
                    }
                }
                array2[i][j] = n4;
            }
        }
        return array2;
    }
    
    private static void calculateThresholdForBlock(final byte[] array, final int n, final int n2, final int n3, int i, final int[][] array2, final BitMatrix bitMatrix) {
        final int n4 = i - 8;
        final int n5 = n3 - 8;
        int n6;
        int cap;
        int j;
        int n7;
        int cap2;
        int n8;
        int k;
        int[] array3;
        for (i = 0; i < n2; ++i) {
            if ((n6 = i << 3) > n4) {
                n6 = n4;
            }
            cap = cap(i, 2, n2 - 3);
            for (j = 0; j < n; ++j) {
                if ((n7 = j << 3) > n5) {
                    n7 = n5;
                }
                cap2 = cap(j, 2, n - 3);
                n8 = 0;
                for (k = -2; k <= 2; ++k) {
                    array3 = array2[cap + k];
                    n8 += array3[cap2 - 2] + array3[cap2 - 1] + array3[cap2] + array3[cap2 + 1] + array3[cap2 + 2];
                }
                thresholdBlock(array, n7, n6, n8 / 25, n3, bitMatrix);
            }
        }
    }
    
    private static int cap(final int n, final int n2, final int n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    private static void thresholdBlock(final byte[] array, final int n, final int n2, final int n3, final int n4, final BitMatrix bitMatrix) {
        for (int i = 0, n5 = n2 * n4 + n; i < 8; ++i, n5 += n4) {
            for (int j = 0; j < 8; ++j) {
                if ((array[n5 + j] & 0xFF) <= n3) {
                    bitMatrix.set(n + j, n2 + i);
                }
            }
        }
    }
    
    @Override
    public Binarizer createBinarizer(final LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }
    
    @Override
    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.matrix != null) {
            return this.matrix;
        }
        final LuminanceSource luminanceSource = this.getLuminanceSource();
        final int width = luminanceSource.getWidth();
        final int height = luminanceSource.getHeight();
        if (width >= 40 && height >= 40) {
            final byte[] matrix = luminanceSource.getMatrix();
            int n2;
            final int n = n2 = width >> 3;
            if ((width & 0x7) != 0x0) {
                n2 = n + 1;
            }
            int n4;
            final int n3 = n4 = height >> 3;
            if ((height & 0x7) != 0x0) {
                n4 = n3 + 1;
            }
            final int[][] calculateBlackPoints = calculateBlackPoints(matrix, n2, n4, width, height);
            final BitMatrix matrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, n2, n4, width, height, calculateBlackPoints, matrix2);
            this.matrix = matrix2;
        }
        else {
            this.matrix = super.getBlackMatrix();
        }
        return this.matrix;
    }
}
