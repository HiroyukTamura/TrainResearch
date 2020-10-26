// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken extends Token
{
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;
    
    BinaryShiftToken(final Token token, final int n, final int n2) {
        super(token);
        this.binaryShiftStart = (short)n;
        this.binaryShiftByteCount = (short)n2;
    }
    
    public void appendTo(final BitArray bitArray, final byte[] array) {
        for (int i = 0; i < this.binaryShiftByteCount; ++i) {
            if (i == 0 || (i == 31 && this.binaryShiftByteCount <= 62)) {
                bitArray.appendBits(31, 5);
                if (this.binaryShiftByteCount > 62) {
                    bitArray.appendBits(this.binaryShiftByteCount - 31, 16);
                }
                else if (i == 0) {
                    bitArray.appendBits(Math.min(this.binaryShiftByteCount, 31), 5);
                }
                else {
                    bitArray.appendBits(this.binaryShiftByteCount - 31, 5);
                }
            }
            bitArray.appendBits(array[this.binaryShiftStart + i], 8);
        }
    }
    
    @Override
    public String toString() {
        return "<" + this.binaryShiftStart + "::" + (this.binaryShiftStart + this.binaryShiftByteCount - 1) + '>';
    }
}
