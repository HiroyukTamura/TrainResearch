// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded;

import java.io.Serializable;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair
{
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;
    
    ExpandedPair(final DataCharacter leftChar, final DataCharacter rightChar, final FinderPattern finderPattern, final boolean mayBeLast) {
        this.leftChar = leftChar;
        this.rightChar = rightChar;
        this.finderPattern = finderPattern;
        this.mayBeLast = mayBeLast;
    }
    
    private static boolean equalsOrNull(final Object o, final Object obj) {
        if (o == null) {
            return obj == null;
        }
        return o.equals(obj);
    }
    
    private static int hashNotNull(final Object o) {
        if (o == null) {
            return 0;
        }
        return o.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof ExpandedPair) {
            final ExpandedPair expandedPair = (ExpandedPair)o;
            if (equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern)) {
                return true;
            }
        }
        return false;
    }
    
    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }
    
    DataCharacter getLeftChar() {
        return this.leftChar;
    }
    
    DataCharacter getRightChar() {
        return this.rightChar;
    }
    
    @Override
    public int hashCode() {
        return hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar) ^ hashNotNull(this.finderPattern);
    }
    
    boolean mayBeLast() {
        return this.mayBeLast;
    }
    
    public boolean mustBeLast() {
        return this.rightChar == null;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder("[ ").append(this.leftChar).append(" , ").append(this.rightChar).append(" : ");
        Serializable value;
        if (this.finderPattern == null) {
            value = "null";
        }
        else {
            value = this.finderPattern.getValue();
        }
        return append.append(value).append(" ]").toString();
    }
}
