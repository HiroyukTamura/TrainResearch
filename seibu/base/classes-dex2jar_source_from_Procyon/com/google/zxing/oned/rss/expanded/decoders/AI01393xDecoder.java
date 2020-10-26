// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder extends AI01decoder
{
    private static final int FIRST_THREE_DIGITS_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;
    
    AI01393xDecoder(final BitArray bitArray) {
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
        sb.append("(393");
        sb.append(numericValueFromBitArray);
        sb.append(')');
        final int numericValueFromBitArray2 = this.getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
        if (numericValueFromBitArray2 / 100 == 0) {
            sb.append('0');
        }
        if (numericValueFromBitArray2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(numericValueFromBitArray2);
        sb.append(this.getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
        return sb.toString();
    }
}
