// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import java.util.Map;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public abstract class ArrayBasedCharEscaper extends CharEscaper
{
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;
    
    protected ArrayBasedCharEscaper(final ArrayBasedEscaperMap arrayBasedEscaperMap, final char c, final char c2) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        this.replacements = arrayBasedEscaperMap.getReplacementArray();
        this.replacementsLength = this.replacements.length;
        char safeMin = c;
        char safeMax = c2;
        if (c2 < c) {
            safeMax = '\0';
            safeMin = '\uffff';
        }
        this.safeMin = safeMin;
        this.safeMax = safeMax;
    }
    
    protected ArrayBasedCharEscaper(final Map<Character, String> map, final char c, final char c2) {
        this(ArrayBasedEscaperMap.create(map), c, c2);
    }
    
    @Override
    public final String escape(final String s) {
        Preconditions.checkNotNull(s);
        int index = 0;
        String escapeSlow;
        while (true) {
            escapeSlow = s;
            if (index >= s.length()) {
                break;
            }
            final char char1 = s.charAt(index);
            if ((char1 < this.replacementsLength && this.replacements[char1] != null) || char1 > this.safeMax || char1 < this.safeMin) {
                escapeSlow = this.escapeSlow(s, index);
                break;
            }
            ++index;
        }
        return escapeSlow;
    }
    
    @Override
    protected final char[] escape(final char c) {
        if (c < this.replacementsLength) {
            final char[] array = this.replacements[c];
            if (array != null) {
                return array;
            }
        }
        if (c >= this.safeMin && c <= this.safeMax) {
            return null;
        }
        return this.escapeUnsafe(c);
    }
    
    protected abstract char[] escapeUnsafe(final char p0);
}
