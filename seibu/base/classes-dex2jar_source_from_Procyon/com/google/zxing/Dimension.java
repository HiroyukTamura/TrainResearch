// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class Dimension
{
    private final int height;
    private final int width;
    
    public Dimension(final int width, final int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof Dimension) {
            final Dimension dimension = (Dimension)o;
            b2 = b;
            if (this.width == dimension.width) {
                b2 = b;
                if (this.height == dimension.height) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public int hashCode() {
        return this.width * 32713 + this.height;
    }
    
    @Override
    public String toString() {
        return this.width + "x" + this.height;
    }
}
