// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric extends DecodedObject
{
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;
    
    DecodedNumeric(final int n, final int firstDigit, final int secondDigit) throws FormatException {
        super(n);
        if (firstDigit < 0 || firstDigit > 10 || secondDigit < 0 || secondDigit > 10) {
            throw FormatException.getFormatInstance();
        }
        this.firstDigit = firstDigit;
        this.secondDigit = secondDigit;
    }
    
    int getFirstDigit() {
        return this.firstDigit;
    }
    
    int getSecondDigit() {
        return this.secondDigit;
    }
    
    int getValue() {
        return this.firstDigit * 10 + this.secondDigit;
    }
    
    boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }
    
    boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }
    
    boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
