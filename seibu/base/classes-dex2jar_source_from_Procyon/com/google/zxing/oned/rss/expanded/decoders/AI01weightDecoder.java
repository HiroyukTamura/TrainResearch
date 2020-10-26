// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder
{
    AI01weightDecoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    protected abstract void addWeightCode(final StringBuilder p0, final int p1);
    
    protected abstract int checkWeight(final int p0);
    
    final void encodeCompressedWeight(final StringBuilder sb, int i, int n) {
        i = this.getGeneralDecoder().extractNumericValueFromBitArray(i, n);
        this.addWeightCode(sb, i);
        final int checkWeight = this.checkWeight(i);
        n = 100000;
        for (i = 0; i < 5; ++i) {
            if (checkWeight / n == 0) {
                sb.append('0');
            }
            n /= 10;
        }
        sb.append(checkWeight);
    }
}
