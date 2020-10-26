// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public abstract class LuminanceSource
{
    private final int height;
    private final int width;
    
    protected LuminanceSource(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    public LuminanceSource crop(final int n, final int n2, final int n3, final int n4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    public abstract byte[] getMatrix();
    
    public abstract byte[] getRow(final int p0, final byte[] p1);
    
    public final int getWidth() {
        return this.width;
    }
    
    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }
    
    public boolean isCropSupported() {
        return false;
    }
    
    public boolean isRotateSupported() {
        return false;
    }
    
    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }
    
    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }
    
    @Override
    public final String toString() {
        byte[] row = new byte[this.width];
        final StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; ++i) {
            row = this.getRow(i, row);
            for (int j = 0; j < this.width; ++j) {
                final int n = row[j] & 0xFF;
                char c;
                if (n < 64) {
                    c = '#';
                }
                else if (n < 128) {
                    c = '+';
                }
                else if (n < 192) {
                    c = '.';
                }
                else {
                    c = ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
