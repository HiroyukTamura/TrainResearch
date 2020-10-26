// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class InvertedLuminanceSource extends LuminanceSource
{
    private final LuminanceSource delegate;
    
    public InvertedLuminanceSource(final LuminanceSource delegate) {
        super(delegate.getWidth(), delegate.getHeight());
        this.delegate = delegate;
    }
    
    @Override
    public LuminanceSource crop(final int n, final int n2, final int n3, final int n4) {
        return new InvertedLuminanceSource(this.delegate.crop(n, n2, n3, n4));
    }
    
    @Override
    public byte[] getMatrix() {
        final byte[] matrix = this.delegate.getMatrix();
        final int n = this.getWidth() * this.getHeight();
        final byte[] array = new byte[n];
        for (int i = 0; i < n; ++i) {
            array[i] = (byte)(255 - (matrix[i] & 0xFF));
        }
        return array;
    }
    
    @Override
    public byte[] getRow(int i, byte[] row) {
        row = this.delegate.getRow(i, row);
        int width;
        for (width = this.getWidth(), i = 0; i < width; ++i) {
            row[i] = (byte)(255 - (row[i] & 0xFF));
        }
        return row;
    }
    
    @Override
    public LuminanceSource invert() {
        return this.delegate;
    }
    
    @Override
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }
    
    @Override
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }
    
    @Override
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }
    
    @Override
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
