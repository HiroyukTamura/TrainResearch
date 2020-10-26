// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token
{
    static final Token EMPTY;
    private final Token previous;
    
    static {
        EMPTY = new SimpleToken(null, 0, 0);
    }
    
    Token(final Token previous) {
        this.previous = previous;
    }
    
    final Token add(final int n, final int n2) {
        return new SimpleToken(this, n, n2);
    }
    
    final Token addBinaryShift(final int n, final int n2) {
        return new BinaryShiftToken(this, n, n2);
    }
    
    abstract void appendTo(final BitArray p0, final byte[] p1);
    
    final Token getPrevious() {
        return this.previous;
    }
}
