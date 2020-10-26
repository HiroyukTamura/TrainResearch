// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder extends AI013x0xDecoder
{
    AI013103decoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    @Override
    protected void addWeightCode(final StringBuilder sb, final int n) {
        sb.append("(3103)");
    }
    
    @Override
    protected int checkWeight(final int n) {
        return n;
    }
}
