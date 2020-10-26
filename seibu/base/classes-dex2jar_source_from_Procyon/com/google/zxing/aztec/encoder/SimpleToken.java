// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class SimpleToken extends Token
{
    private final short bitCount;
    private final short value;
    
    SimpleToken(final Token token, final int n, final int n2) {
        super(token);
        this.value = (short)n;
        this.bitCount = (short)n2;
    }
    
    @Override
    void appendTo(final BitArray bitArray, final byte[] array) {
        bitArray.appendBits(this.value, this.bitCount);
    }
    
    @Override
    public String toString() {
        return "<" + Integer.toBinaryString(1 << this.bitCount | ((this.value & (1 << this.bitCount) - 1) | 1 << this.bitCount)).substring(1) + '>';
    }
}
