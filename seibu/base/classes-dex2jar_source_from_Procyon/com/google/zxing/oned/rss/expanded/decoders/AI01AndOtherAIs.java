// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01AndOtherAIs extends AI01decoder
{
    private static final int HEADER_SIZE = 4;
    
    AI01AndOtherAIs(final BitArray bitArray) {
        super(bitArray);
    }
    
    @Override
    public String parseInformation() throws NotFoundException, FormatException {
        final StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        final int length = sb.length();
        sb.append(this.getGeneralDecoder().extractNumericValueFromBitArray(4, 4));
        this.encodeCompressedGtinWithoutAI(sb, 8, length);
        return this.getGeneralDecoder().decodeAllCodes(sb, 48);
    }
}
