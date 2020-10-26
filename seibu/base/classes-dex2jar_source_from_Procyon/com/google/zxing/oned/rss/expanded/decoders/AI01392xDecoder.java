// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder extends AI01decoder
{
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;
    
    AI01392xDecoder(final BitArray bitArray) {
        super(bitArray);
    }
    
    @Override
    public String parseInformation() throws NotFoundException, FormatException {
        if (this.getInformation().getSize() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        final StringBuilder sb = new StringBuilder();
        this.encodeCompressedGtin(sb, 8);
        final int numericValueFromBitArray = this.getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        sb.append("(392");
        sb.append(numericValueFromBitArray);
        sb.append(')');
        sb.append(this.getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
        return sb.toString();
    }
}
