// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder extends AI01weightDecoder
{
    private static final int HEADER_SIZE = 5;
    private static final int WEIGHT_SIZE = 15;
    
    AI013x0xDecoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    @Override
    public String parseInformation() throws NotFoundException {
        if (this.getInformation().getSize() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        final StringBuilder sb = new StringBuilder();
        this.encodeCompressedGtin(sb, 5);
        this.encodeCompressedWeight(sb, 45, 15);
        return sb.toString();
    }
}
