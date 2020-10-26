// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class Escapers
{
    private static final Escaper NULL_ESCAPER;
    
    static {
        NULL_ESCAPER = new CharEscaper() {
            @Override
            public String escape(final String s) {
                return Preconditions.checkNotNull(s);
            }
            
            @Override
            protected char[] escape(final char c) {
                return null;
            }
        };
    }
    
    private Escapers() {
    }
    
    static UnicodeEscaper asUnicodeEscaper(final Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper)escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper)escaper);
        }
        final String value = String.valueOf(escaper.getClass().getName());
        String concat;
        if (value.length() != 0) {
            concat = "Cannot create a UnicodeEscaper from: ".concat(value);
        }
        else {
            concat = new String("Cannot create a UnicodeEscaper from: ");
        }
        throw new IllegalArgumentException(concat);
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static String computeReplacement(final CharEscaper charEscaper, final char c) {
        return stringOrNull(charEscaper.escape(c));
    }
    
    public static String computeReplacement(final UnicodeEscaper unicodeEscaper, final int n) {
        return stringOrNull(unicodeEscaper.escape(n));
    }
    
    public static Escaper nullEscaper() {
        return Escapers.NULL_ESCAPER;
    }
    
    private static String stringOrNull(final char[] value) {
        if (value == null) {
            return null;
        }
        return new String(value);
    }
    
    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            @Override
            protected char[] escape(int length) {
                char[] escape;
                if (length < 65536) {
                    escape = charEscaper.escape((char)length);
                }
                else {
                    final char[] dst = new char[2];
                    Character.toChars(length, dst, 0);
                    final char[] escape2 = charEscaper.escape(dst[0]);
                    final char[] escape3 = charEscaper.escape(dst[1]);
                    if (escape2 == null && escape3 == null) {
                        return null;
                    }
                    if (escape2 != null) {
                        length = escape2.length;
                    }
                    else {
                        length = 1;
                    }
                    int length2;
                    if (escape3 != null) {
                        length2 = escape3.length;
                    }
                    else {
                        length2 = 1;
                    }
                    final char[] array = new char[length + length2];
                    if (escape2 != null) {
                        for (int i = 0; i < escape2.length; ++i) {
                            array[i] = escape2[i];
                        }
                    }
                    else {
                        array[0] = dst[0];
                    }
                    if (escape3 == null) {
                        array[length] = dst[1];
                        return array;
                    }
                    int n = 0;
                    while (true) {
                        escape = array;
                        if (n >= escape3.length) {
                            break;
                        }
                        array[length + n] = escape3[n];
                        ++n;
                    }
                }
                return escape;
            }
        };
    }
    
    @Beta
    public static final class Builder
    {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;
        
        private Builder() {
            this.replacementMap = new HashMap<Character, String>();
            this.safeMin = '\0';
            this.safeMax = '\uffff';
            this.unsafeReplacement = null;
        }
        
        public Builder addEscape(final char c, final String s) {
            Preconditions.checkNotNull(s);
            this.replacementMap.put(c, s);
            return this;
        }
        
        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                private final char[] replacementChars;
                
                {
                    char[] charArray;
                    if (Builder.this.unsafeReplacement != null) {
                        charArray = Builder.this.unsafeReplacement.toCharArray();
                    }
                    else {
                        charArray = null;
                    }
                    this.replacementChars = charArray;
                }
                
                @Override
                protected char[] escapeUnsafe(final char c) {
                    return this.replacementChars;
                }
            };
        }
        
        public Builder setSafeRange(final char safeMin, final char safeMax) {
            this.safeMin = safeMin;
            this.safeMax = safeMax;
            return this;
        }
        
        public Builder setUnsafeReplacement(@Nullable final String unsafeReplacement) {
            this.unsafeReplacement = unsafeReplacement;
            return this;
        }
    }
}
