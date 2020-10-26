// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.encoder;

import java.util.Arrays;
import java.lang.reflect.Array;

public final class ByteMatrix
{
    private final byte[][] bytes;
    private final int height;
    private final int width;
    
    public ByteMatrix(final int width, final int height) {
        this.bytes = (byte[][])Array.newInstance(Byte.TYPE, height, width);
        this.width = width;
        this.height = height;
    }
    
    public void clear(final byte val) {
        final byte[][] bytes = this.bytes;
        for (int length = bytes.length, i = 0; i < length; ++i) {
            Arrays.fill(bytes[i], val);
        }
    }
    
    public byte get(final int n, final int n2) {
        return this.bytes[n2][n];
    }
    
    public byte[][] getArray() {
        return this.bytes;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void set(final int n, final int n2, final byte b) {
        this.bytes[n2][n] = b;
    }
    
    public void set(final int n, final int n2, final int n3) {
        this.bytes[n2][n] = (byte)n3;
    }
    
    public void set(final int n, int n2, final boolean b) {
        final byte[] array = this.bytes[n2];
        if (b) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        array[n] = (byte)n2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.width * 2 * this.height + 2);
        for (int i = 0; i < this.height; ++i) {
            final byte[] array = this.bytes[i];
            for (int j = 0; j < this.width; ++j) {
                switch (array[j]) {
                    default: {
                        sb.append("  ");
                        break;
                    }
                    case 0: {
                        sb.append(" 0");
                        break;
                    }
                    case 1: {
                        sb.append(" 1");
                        break;
                    }
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
