// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel
{
    private static final ErrorCorrectionLevel[] FOR_BITS;
    
    H(2), 
    L(1), 
    M(0), 
    Q(3);
    
    private final int bits;
    
    static {
        FOR_BITS = new ErrorCorrectionLevel[] { ErrorCorrectionLevel.M, ErrorCorrectionLevel.L, ErrorCorrectionLevel.H, ErrorCorrectionLevel.Q };
    }
    
    private ErrorCorrectionLevel(final int bits) {
        this.bits = bits;
    }
    
    public static ErrorCorrectionLevel forBits(final int n) {
        if (n < 0 || n >= ErrorCorrectionLevel.FOR_BITS.length) {
            throw new IllegalArgumentException();
        }
        return ErrorCorrectionLevel.FOR_BITS[n];
    }
    
    public int getBits() {
        return this.bits;
    }
}
