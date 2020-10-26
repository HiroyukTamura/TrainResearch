// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;
import com.google.zxing.NotFoundException;

public final class EAN13Reader extends UPCEANReader
{
    static final int[] FIRST_DIGIT_ENCODINGS;
    private final int[] decodeMiddleCounters;
    
    static {
        FIRST_DIGIT_ENCODINGS = new int[] { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
    }
    
    public EAN13Reader() {
        this.decodeMiddleCounters = new int[4];
    }
    
    private static void determineFirstDigit(final StringBuilder sb, final int n) throws NotFoundException {
        for (int i = 0; i < 10; ++i) {
            if (n == EAN13Reader.FIRST_DIGIT_ENCODINGS[i]) {
                sb.insert(0, (char)(i + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    protected int decodeMiddle(final BitArray bitArray, final int[] array, final StringBuilder sb) throws NotFoundException {
        final int[] decodeMiddleCounters = this.decodeMiddleCounters;
        decodeMiddleCounters[1] = (decodeMiddleCounters[0] = 0);
        decodeMiddleCounters[3] = (decodeMiddleCounters[2] = 0);
        final int size = bitArray.getSize();
        int n = array[1];
        int n2 = 0;
        int n4;
        for (int n3 = 0; n3 < 6 && n < size; ++n3, n2 = n4) {
            final int decodeDigit = UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n, EAN13Reader.L_AND_G_PATTERNS);
            sb.append((char)(decodeDigit % 10 + 48));
            for (int length = decodeMiddleCounters.length, i = 0; i < length; ++i) {
                n += decodeMiddleCounters[i];
            }
            n4 = n2;
            if (decodeDigit >= 10) {
                n4 = (n2 | 1 << 5 - n3);
            }
        }
        determineFirstDigit(sb, n2);
        int n5 = UPCEANReader.findGuardPattern(bitArray, n, true, EAN13Reader.MIDDLE_PATTERN)[1];
        for (int n6 = 0; n6 < 6 && n5 < size; ++n6) {
            sb.append((char)(UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n5, EAN13Reader.L_PATTERNS) + 48));
            for (int length2 = decodeMiddleCounters.length, j = 0; j < length2; ++j) {
                n5 += decodeMiddleCounters[j];
            }
        }
        return n5;
    }
    
    @Override
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
