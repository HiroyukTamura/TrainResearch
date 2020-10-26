// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedInformation extends DecodedObject
{
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;
    
    DecodedInformation(final int n, final String newString) {
        super(n);
        this.newString = newString;
        this.remaining = false;
        this.remainingValue = 0;
    }
    
    DecodedInformation(final int n, final String newString, final int remainingValue) {
        super(n);
        this.remaining = true;
        this.remainingValue = remainingValue;
        this.newString = newString;
    }
    
    String getNewString() {
        return this.newString;
    }
    
    int getRemainingValue() {
        return this.remainingValue;
    }
    
    boolean isRemaining() {
        return this.remaining;
    }
}
