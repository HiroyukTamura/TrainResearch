// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader
{
    private final int[] decodeMiddleCounters;
    
    public EAN8Reader() {
        this.decodeMiddleCounters = new int[4];
    }
    
    @Override
    protected int decodeMiddle(final BitArray bitArray, final int[] array, final StringBuilder sb) throws NotFoundException {
        final int[] decodeMiddleCounters = this.decodeMiddleCounters;
        decodeMiddleCounters[1] = (decodeMiddleCounters[0] = 0);
        decodeMiddleCounters[3] = (decodeMiddleCounters[2] = 0);
        final int size = bitArray.getSize();
        int n = array[1];
        for (int n2 = 0; n2 < 4 && n < size; ++n2) {
            sb.append((char)(UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n, EAN8Reader.L_PATTERNS) + 48));
            for (int length = decodeMiddleCounters.length, i = 0; i < length; ++i) {
                n += decodeMiddleCounters[i];
            }
        }
        int n3 = UPCEANReader.findGuardPattern(bitArray, n, true, EAN8Reader.MIDDLE_PATTERN)[1];
        for (int n4 = 0; n4 < 4 && n3 < size; ++n4) {
            sb.append((char)(UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n3, EAN8Reader.L_PATTERNS) + 48));
            for (int length2 = decodeMiddleCounters.length, j = 0; j < length2; ++j) {
                n3 += decodeMiddleCounters[j];
            }
        }
        return n3;
    }
    
    @Override
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
