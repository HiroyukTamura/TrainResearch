// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler
{
    private static GridSampler gridSampler;
    
    static {
        GridSampler.gridSampler = new DefaultGridSampler();
    }
    
    protected static void checkAndNudgePoints(final BitMatrix bitMatrix, final float[] array) throws NotFoundException {
        final int width = bitMatrix.getWidth();
        final int height = bitMatrix.getHeight();
        for (int n = 1, n2 = 0; n2 < array.length && n != 0; n2 += 2) {
            final int n3 = (int)array[n2];
            final int n4 = (int)array[n2 + 1];
            if (n3 < -1 || n3 > width || n4 < -1 || n4 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            n = 0;
            if (n3 == -1) {
                array[n2] = 0.0f;
                n = 1;
            }
            else if (n3 == width) {
                array[n2] = (float)(width - 1);
                n = 1;
            }
            if (n4 == -1) {
                array[n2 + 1] = 0.0f;
                n = 1;
            }
            else if (n4 == height) {
                array[n2 + 1] = (float)(height - 1);
                n = 1;
            }
        }
        for (int n5 = 1, n6 = array.length - 2; n6 >= 0 && n5 != 0; n6 -= 2) {
            final int n7 = (int)array[n6];
            final int n8 = (int)array[n6 + 1];
            if (n7 < -1 || n7 > width || n8 < -1 || n8 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            n5 = 0;
            if (n7 == -1) {
                array[n6] = 0.0f;
                n5 = 1;
            }
            else if (n7 == width) {
                array[n6] = (float)(width - 1);
                n5 = 1;
            }
            if (n8 == -1) {
                array[n6 + 1] = 0.0f;
                n5 = 1;
            }
            else if (n8 == height) {
                array[n6 + 1] = (float)(height - 1);
                n5 = 1;
            }
        }
    }
    
    public static GridSampler getInstance() {
        return GridSampler.gridSampler;
    }
    
    public static void setGridSampler(final GridSampler gridSampler) {
        GridSampler.gridSampler = gridSampler;
    }
    
    public abstract BitMatrix sampleGrid(final BitMatrix p0, final int p1, final int p2, final float p3, final float p4, final float p5, final float p6, final float p7, final float p8, final float p9, final float p10, final float p11, final float p12, final float p13, final float p14, final float p15, final float p16, final float p17, final float p18) throws NotFoundException;
    
    public abstract BitMatrix sampleGrid(final BitMatrix p0, final int p1, final int p2, final PerspectiveTransform p3) throws NotFoundException;
}
