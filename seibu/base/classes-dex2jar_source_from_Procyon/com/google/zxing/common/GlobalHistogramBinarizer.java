// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Binarizer;

public class GlobalHistogramBinarizer extends Binarizer
{
    private static final byte[] EMPTY;
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;
    
    static {
        EMPTY = new byte[0];
    }
    
    public GlobalHistogramBinarizer(final LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = GlobalHistogramBinarizer.EMPTY;
        this.buckets = new int[32];
    }
    
    private static int estimateBlackPoint(final int[] array) throws NotFoundException {
        final int length = array.length;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4;
        int n5;
        for (int i = 0; i < length; ++i, n3 = n4, n = n5) {
            if (array[i] > (n4 = n3)) {
                n2 = i;
                n4 = array[i];
            }
            if (array[i] > (n5 = n)) {
                n5 = array[i];
            }
        }
        int n6 = 0;
        int n7 = 0;
        int n10;
        for (int j = 0; j < length; ++j, n7 = n10) {
            final int n8 = j - n2;
            final int n9 = array[j] * n8 * n8;
            if (n9 > (n10 = n7)) {
                n6 = j;
                n10 = n9;
            }
        }
        int n11;
        int n12;
        if ((n11 = n2) > (n12 = n6)) {
            n12 = n2;
            n11 = n6;
        }
        if (n12 - n11 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int n13 = n12 - 1;
        int n14 = -1;
        int n17;
        for (int k = n12 - 1; k > n11; --k, n14 = n17) {
            final int n15 = k - n11;
            final int n16 = n15 * n15 * (n12 - k) * (n - array[k]);
            if (n16 > (n17 = n14)) {
                n13 = k;
                n17 = n16;
            }
        }
        return n13 << 3;
    }
    
    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (i = 0; i < 32; ++i) {
            this.buckets[i] = 0;
        }
    }
    
    @Override
    public Binarizer createBinarizer(final LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }
    
    @Override
    public BitMatrix getBlackMatrix() throws NotFoundException {
        final LuminanceSource luminanceSource = this.getLuminanceSource();
        final int width = luminanceSource.getWidth();
        final int height = luminanceSource.getHeight();
        final BitMatrix bitMatrix = new BitMatrix(width, height);
        this.initArrays(width);
        final int[] buckets = this.buckets;
        for (int i = 1; i < 5; ++i) {
            final byte[] row = luminanceSource.getRow(height * i / 5, this.luminances);
            for (int n = (width << 2) / 5, j = width / 5; j < n; ++j) {
                final int n2 = (row[j] & 0xFF) >> 3;
                ++buckets[n2];
            }
        }
        final int estimateBlackPoint = estimateBlackPoint(buckets);
        final byte[] matrix = luminanceSource.getMatrix();
        for (int k = 0; k < height; ++k) {
            for (int l = 0; l < width; ++l) {
                if ((matrix[k * width + l] & 0xFF) < estimateBlackPoint) {
                    bitMatrix.set(l, k);
                }
            }
        }
        return bitMatrix;
    }
    
    @Override
    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        final LuminanceSource luminanceSource = this.getLuminanceSource();
        final int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        }
        else {
            bitArray.clear();
        }
        this.initArrays(width);
        final byte[] row = luminanceSource.getRow(i, this.luminances);
        final int[] buckets = this.buckets;
        int n;
        for (i = 0; i < width; ++i) {
            n = (row[i] & 0xFF) >> 3;
            ++buckets[n];
        }
        final int estimateBlackPoint = estimateBlackPoint(buckets);
        if (width < 3) {
            for (i = 0; i < width; ++i) {
                if ((row[i] & 0xFF) < estimateBlackPoint) {
                    bitArray.set(i);
                }
            }
        }
        else {
            int n2 = row[0] & 0xFF;
            i = (row[1] & 0xFF);
            for (int j = 1; j < width - 1; ++j) {
                final int n3 = row[j + 1] & 0xFF;
                if (((i << 2) - n2 - n3) / 2 < estimateBlackPoint) {
                    bitArray.set(j);
                }
                n2 = i;
                i = n3;
            }
        }
        return bitArray;
    }
}
