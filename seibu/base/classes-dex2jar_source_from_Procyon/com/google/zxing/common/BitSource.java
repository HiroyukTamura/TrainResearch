// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

public final class BitSource
{
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;
    
    public BitSource(final byte[] bytes) {
        this.bytes = bytes;
    }
    
    public int available() {
        return (this.bytes.length - this.byteOffset) * 8 - this.bitOffset;
    }
    
    public int getBitOffset() {
        return this.bitOffset;
    }
    
    public int getByteOffset() {
        return this.byteOffset;
    }
    
    public int readBits(int i) {
        if (i <= 0 || i > 32 || i > this.available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int n = 0;
        int j = i;
        if (this.bitOffset > 0) {
            final int n2 = 8 - this.bitOffset;
            int n3;
            if (i < n2) {
                n3 = i;
            }
            else {
                n3 = n2;
            }
            final int n4 = n2 - n3;
            final int n5 = (this.bytes[this.byteOffset] & 255 >> 8 - n3 << n4) >> n4;
            i -= n3;
            this.bitOffset += n3;
            n = n5;
            j = i;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                ++this.byteOffset;
                j = i;
                n = n5;
            }
        }
        i = n;
        if (j > 0) {
            while (j >= 8) {
                n = (n << 8 | (this.bytes[this.byteOffset] & 0xFF));
                ++this.byteOffset;
                j -= 8;
            }
            i = n;
            if (j > 0) {
                i = 8 - j;
                i = (n << j | (this.bytes[this.byteOffset] & 255 >> i << i) >> i);
                this.bitOffset += j;
            }
        }
        return i;
    }
}
