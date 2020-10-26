// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss;

public class DataCharacter
{
    private final int checksumPortion;
    private final int value;
    
    public DataCharacter(final int value, final int checksumPortion) {
        this.value = value;
        this.checksumPortion = checksumPortion;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof DataCharacter) {
            final DataCharacter dataCharacter = (DataCharacter)o;
            if (this.value == dataCharacter.value && this.checksumPortion == dataCharacter.checksumPortion) {
                return true;
            }
        }
        return false;
    }
    
    public final int getChecksumPortion() {
        return this.checksumPortion;
    }
    
    public final int getValue() {
        return this.value;
    }
    
    @Override
    public final int hashCode() {
        return this.value ^ this.checksumPortion;
    }
    
    @Override
    public final String toString() {
        return this.value + "(" + this.checksumPortion + ')';
    }
}
