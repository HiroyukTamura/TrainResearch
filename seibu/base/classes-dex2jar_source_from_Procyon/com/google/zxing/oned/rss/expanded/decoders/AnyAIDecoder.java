// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AnyAIDecoder extends AbstractExpandedDecoder
{
    private static final int HEADER_SIZE = 5;
    
    AnyAIDecoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    @Override
    public String parseInformation() throws NotFoundException, FormatException {
        return this.getGeneralDecoder().decodeAllCodes(new StringBuilder(), 5);
    }
}
