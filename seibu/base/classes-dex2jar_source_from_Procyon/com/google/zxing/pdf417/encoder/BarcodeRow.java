// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.encoder;

final class BarcodeRow
{
    private int currentLocation;
    private final byte[] row;
    
    BarcodeRow(final int n) {
        this.row = new byte[n];
        this.currentLocation = 0;
    }
    
    private void set(final int n, final boolean b) {
        final byte[] row = this.row;
        int n2;
        if (b) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        row[n] = (byte)n2;
    }
    
    void addBar(final boolean b, final int n) {
        for (int i = 0; i < n; ++i) {
            this.set(this.currentLocation++, b);
        }
    }
    
    byte[] getScaledRow(final int n) {
        final byte[] array = new byte[this.row.length * n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.row[i / n];
        }
        return array;
    }
    
    void set(final int n, final byte b) {
        this.row[n] = b;
    }
}
