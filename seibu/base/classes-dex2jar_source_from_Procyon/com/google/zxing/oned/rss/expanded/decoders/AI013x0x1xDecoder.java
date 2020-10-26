// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder extends AI01weightDecoder
{
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;
    
    AI013x0x1xDecoder(final BitArray bitArray, final String firstAIdigits, final String dateCode) {
        super(bitArray);
        this.dateCode = dateCode;
        this.firstAIdigits = firstAIdigits;
    }
    
    private void encodeCompressedDate(final StringBuilder sb, int i) {
        final int numericValueFromBitArray = this.getGeneralDecoder().extractNumericValueFromBitArray(i, 16);
        if (numericValueFromBitArray == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.dateCode);
        sb.append(')');
        i = numericValueFromBitArray % 32;
        final int n = numericValueFromBitArray / 32;
        final int j = n % 12 + 1;
        final int k = n / 12;
        if (k / 10 == 0) {
            sb.append('0');
        }
        sb.append(k);
        if (j / 10 == 0) {
            sb.append('0');
        }
        sb.append(j);
        if (i / 10 == 0) {
            sb.append('0');
        }
        sb.append(i);
    }
    
    @Override
    protected void addWeightCode(final StringBuilder sb, final int n) {
        sb.append('(');
        sb.append(this.firstAIdigits);
        sb.append(n / 100000);
        sb.append(')');
    }
    
    @Override
    protected int checkWeight(final int n) {
        return n % 100000;
    }
    
    @Override
    public String parseInformation() throws NotFoundException {
        if (this.getInformation().getSize() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        final StringBuilder sb = new StringBuilder();
        this.encodeCompressedGtin(sb, 8);
        this.encodeCompressedWeight(sb, 48, 20);
        this.encodeCompressedDate(sb, 68);
        return sb.toString();
    }
}
