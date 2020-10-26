// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class CharEscaperBuilder
{
    private final Map<Character, String> map;
    private int max;
    
    public CharEscaperBuilder() {
        this.max = -1;
        this.map = new HashMap<Character, String>();
    }
    
    public CharEscaperBuilder addEscape(final char c, final String s) {
        this.map.put(c, Preconditions.checkNotNull(s));
        if (c > this.max) {
            this.max = c;
        }
        return this;
    }
    
    public CharEscaperBuilder addEscapes(final char[] array, final String s) {
        Preconditions.checkNotNull(s);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.addEscape(array[i], s);
        }
        return this;
    }
    
    public char[][] toArray() {
        final char[][] array = new char[this.max + 1][];
        for (final Map.Entry<Character, String> entry : this.map.entrySet()) {
            array[(char)entry.getKey()] = entry.getValue().toCharArray();
        }
        return array;
    }
    
    public Escaper toEscaper() {
        return new CharArrayDecorator(this.toArray());
    }
    
    private static class CharArrayDecorator extends CharEscaper
    {
        private final int replaceLength;
        private final char[][] replacements;
        
        CharArrayDecorator(final char[][] replacements) {
            this.replacements = replacements;
            this.replaceLength = replacements.length;
        }
        
        @Override
        public String escape(final String s) {
            final int length = s.length();
            int index = 0;
            String escapeSlow;
            while (true) {
                escapeSlow = s;
                if (index >= length) {
                    break;
                }
                final char char1 = s.charAt(index);
                if (char1 < this.replacements.length && this.replacements[char1] != null) {
                    escapeSlow = this.escapeSlow(s, index);
                    break;
                }
                ++index;
            }
            return escapeSlow;
        }
        
        @Override
        protected char[] escape(final char c) {
            if (c < this.replaceLength) {
                return this.replacements[c];
            }
            return null;
        }
    }
}
