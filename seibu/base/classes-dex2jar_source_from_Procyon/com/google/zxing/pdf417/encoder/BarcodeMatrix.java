// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

public final class BarcodeMatrix
{
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;
    
    BarcodeMatrix(final int height, final int n) {
        this.matrix = new BarcodeRow[height];
        for (int i = 0; i < this.matrix.length; ++i) {
            this.matrix[i] = new BarcodeRow((n + 4) * 17 + 1);
        }
        this.width = n * 17;
        this.height = height;
        this.currentRow = -1;
    }
    
    BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }
    
    public byte[][] getMatrix() {
        return this.getScaledMatrix(1, 1);
    }
    
    public byte[][] getScaledMatrix(final int n, final int n2) {
        final byte[][] array = (byte[][])Array.newInstance(Byte.TYPE, this.height * n2, this.width * n);
        for (int n3 = this.height * n2, i = 0; i < n3; ++i) {
            array[n3 - i - 1] = this.matrix[i / n2].getScaledRow(n);
        }
        return array;
    }
    
    void set(final int n, final int n2, final byte b) {
        this.matrix[n2].set(n, b);
    }
    
    void startRow() {
        ++this.currentRow;
    }
}
