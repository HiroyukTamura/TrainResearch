// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import java.util.Iterator;
import java.util.LinkedList;
import com.google.zxing.common.BitArray;

final class State
{
    static final State INITIAL_STATE;
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;
    
    static {
        INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    }
    
    private State(final Token token, final int mode, final int binaryShiftByteCount, final int bitCount) {
        this.token = token;
        this.mode = mode;
        this.binaryShiftByteCount = binaryShiftByteCount;
        this.bitCount = bitCount;
    }
    
    State addBinaryShiftChar(final int n) {
        final Token token = this.token;
        final int mode = this.mode;
        final int bitCount = this.bitCount;
        int n2 = 0;
        int n3 = 0;
        Token add = null;
        Label_0077: {
            if (this.mode != 4) {
                n2 = bitCount;
                n3 = mode;
                add = token;
                if (this.mode != 2) {
                    break Label_0077;
                }
            }
            final int n4 = HighLevelEncoder.LATCH_TABLE[mode][0];
            add = token.add(0xFFFF & n4, n4 >> 16);
            n2 = bitCount + (n4 >> 16);
            n3 = 0;
        }
        int n5;
        if (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount == 31) {
            n5 = 18;
        }
        else if (this.binaryShiftByteCount == 62) {
            n5 = 9;
        }
        else {
            n5 = 8;
        }
        State endBinaryShift;
        final State state = endBinaryShift = new State(add, n3, this.binaryShiftByteCount + 1, n2 + n5);
        if (state.binaryShiftByteCount == 2078) {
            endBinaryShift = state.endBinaryShift(n + 1);
        }
        return endBinaryShift;
    }
    
    State endBinaryShift(final int n) {
        if (this.binaryShiftByteCount == 0) {
            return this;
        }
        return new State(this.token.addBinaryShift(n - this.binaryShiftByteCount, this.binaryShiftByteCount), this.mode, 0, this.bitCount);
    }
    
    int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }
    
    int getBitCount() {
        return this.bitCount;
    }
    
    int getMode() {
        return this.mode;
    }
    
    Token getToken() {
        return this.token;
    }
    
    boolean isBetterThanOrEqualTo(final State state) {
        int n2;
        final int n = n2 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        if (state.binaryShiftByteCount > 0) {
            if (this.binaryShiftByteCount != 0) {
                n2 = n;
                if (this.binaryShiftByteCount <= state.binaryShiftByteCount) {
                    return n2 <= state.bitCount;
                }
            }
            n2 = n + 10;
        }
        return n2 <= state.bitCount;
    }
    
    State latchAndAppend(final int n, final int n2) {
        final int bitCount = this.bitCount;
        final Token token = this.token;
        int n3 = bitCount;
        Token add = token;
        if (n != this.mode) {
            final int n4 = HighLevelEncoder.LATCH_TABLE[this.mode][n];
            add = token.add(0xFFFF & n4, n4 >> 16);
            n3 = bitCount + (n4 >> 16);
        }
        int n5;
        if (n == 2) {
            n5 = 4;
        }
        else {
            n5 = 5;
        }
        return new State(add.add(n2, n5), n, 0, n3 + n5);
    }
    
    State shiftAndAppend(final int n, final int n2) {
        final Token token = this.token;
        int n3;
        if (this.mode == 2) {
            n3 = 4;
        }
        else {
            n3 = 5;
        }
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][n], n3).add(n2, 5), this.mode, 0, this.bitCount + n3 + 5);
    }
    
    BitArray toBitArray(final byte[] array) {
        final LinkedList<Token> list = new LinkedList<Token>();
        for (Token token = this.endBinaryShift(array.length).token; token != null; token = token.getPrevious()) {
            list.addFirst(token);
        }
        final BitArray bitArray = new BitArray();
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().appendTo(bitArray, array);
        }
        return bitArray;
    }
    
    @Override
    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], this.bitCount, this.binaryShiftByteCount);
    }
}
