// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler
{
    @Override
    public BitMatrix sampleGrid(final BitMatrix bitMatrix, final int n, final int n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14, final float n15, final float n16, final float n17, final float n18) throws NotFoundException {
        return this.sampleGrid(bitMatrix, n, n2, PerspectiveTransform.quadrilateralToQuadrilateral(n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18));
    }
    
    @Override
    public BitMatrix sampleGrid(final BitMatrix bitMatrix, int i, final int n, final PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i <= 0 || n <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        final BitMatrix bitMatrix2 = new BitMatrix(i, n);
        final float[] array = new float[i * 2];
        int length;
        float n2;
        int j;
        int k;
        for (i = 0; i < n; ++i) {
            length = array.length;
            n2 = (float)i;
            for (j = 0; j < length; j += 2) {
                array[j] = j / 2 + 0.5f;
                array[j + 1] = n2 + 0.5f;
            }
            perspectiveTransform.transformPoints(array);
            GridSampler.checkAndNudgePoints(bitMatrix, array);
            k = 0;
            while (k < length) {
                try {
                    if (bitMatrix.get((int)array[k], (int)array[k + 1])) {
                        bitMatrix2.set(k / 2, i);
                    }
                    k += 2;
                    continue;
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    throw NotFoundException.getNotFoundInstance();
                }
                break;
            }
        }
        return bitMatrix2;
    }
}
