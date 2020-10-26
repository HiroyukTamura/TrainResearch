// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder extends AbstractExpandedDecoder
{
    static final int GTIN_SIZE = 40;
    
    AI01decoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    private static void appendCheckDigit(final StringBuilder sb, int i) {
        int n = 0;
        for (int j = 0; j < 13; ++j) {
            int n2 = sb.charAt(j + i) - '0';
            if ((j & 0x1) == 0x0) {
                n2 *= 3;
            }
            n += n2;
        }
        if ((i = 10 - n % 10) == 10) {
            i = 0;
        }
        sb.append(i);
    }
    
    final void encodeCompressedGtin(final StringBuilder sb, final int n) {
        sb.append("(01)");
        final int length = sb.length();
        sb.append('9');
        this.encodeCompressedGtinWithoutAI(sb, n, length);
    }
    
    final void encodeCompressedGtinWithoutAI(final StringBuilder sb, final int n, final int n2) {
        for (int i = 0; i < 4; ++i) {
            final int numericValueFromBitArray = this.getGeneralDecoder().extractNumericValueFromBitArray(i * 10 + n, 10);
            if (numericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (numericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(numericValueFromBitArray);
        }
        appendCheckDigit(sb, n2);
    }
}
