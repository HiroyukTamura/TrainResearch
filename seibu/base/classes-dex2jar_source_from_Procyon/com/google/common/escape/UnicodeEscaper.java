// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public abstract class UnicodeEscaper extends Escaper
{
    private static final int DEST_PAD = 32;
    
    protected UnicodeEscaper() {
    }
    
    protected static int codePointAt(final CharSequence charSequence, final int n, final int n2) {
        Preconditions.checkNotNull(charSequence);
        if (n >= n2) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        final int i = n + 1;
        final char char1 = charSequence.charAt(n);
        if (char1 < '\ud800' || char1 > '\udfff') {
            return char1;
        }
        if (char1 > '\udbff') {
            final String value = String.valueOf(String.valueOf(charSequence));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 88).append("Unexpected low surrogate character '").append(char1).append("' with value ").append((int)char1).append(" at index ").append(i - 1).append(" in '").append(value).append("'").toString());
        }
        if (i == n2) {
            return -char1;
        }
        final char char2 = charSequence.charAt(i);
        if (Character.isLowSurrogate(char2)) {
            return Character.toCodePoint(char1, char2);
        }
        final String value2 = String.valueOf(String.valueOf(charSequence));
        throw new IllegalArgumentException(new StringBuilder(value2.length() + 89).append("Expected low surrogate but got char '").append(char2).append("' with value ").append((int)char2).append(" at index ").append(i).append(" in '").append(value2).append("'").toString());
    }
    
    private static char[] growBuffer(final char[] array, final int n, final int n2) {
        final char[] array2 = new char[n2];
        if (n > 0) {
            System.arraycopy(array, 0, array2, 0, n);
        }
        return array2;
    }
    
    @Override
    public String escape(final String s) {
        Preconditions.checkNotNull(s);
        final int length = s.length();
        final int nextEscapeIndex = this.nextEscapeIndex(s, 0, length);
        if (nextEscapeIndex == length) {
            return s;
        }
        return this.escapeSlow(s, nextEscapeIndex);
    }
    
    protected abstract char[] escape(final int p0);
    
    protected final String escapeSlow(final String s, int n) {
        final int length = s.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        final int n2 = 0;
        int n3 = 0;
        int i = n;
        n = n2;
        while (i < length) {
            final int codePoint = codePointAt(s, i, length);
            if (codePoint < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            final char[] escape = this.escape(codePoint);
            int n4;
            if (Character.isSupplementaryCodePoint(codePoint)) {
                n4 = 2;
            }
            else {
                n4 = 1;
            }
            final int n5 = i + n4;
            char[] growBuffer = charBufferFromThreadLocal;
            int n6 = n;
            int n7 = n3;
            if (escape != null) {
                final int n8 = i - n3;
                final int n9 = n + n8 + escape.length;
                growBuffer = charBufferFromThreadLocal;
                if (charBufferFromThreadLocal.length < n9) {
                    growBuffer = growBuffer(charBufferFromThreadLocal, n, length - i + n9 + 32);
                }
                int n10 = n;
                if (n8 > 0) {
                    s.getChars(n3, i, growBuffer, n);
                    n10 = n + n8;
                }
                n = n10;
                if (escape.length > 0) {
                    System.arraycopy(escape, 0, growBuffer, n10, escape.length);
                    n = n10 + escape.length;
                }
                n7 = n5;
                n6 = n;
            }
            i = this.nextEscapeIndex(s, n5, length);
            charBufferFromThreadLocal = growBuffer;
            n = n6;
            n3 = n7;
        }
        final int n11 = length - n3;
        char[] growBuffer2 = charBufferFromThreadLocal;
        int count = n;
        if (n11 > 0) {
            count = n + n11;
            growBuffer2 = charBufferFromThreadLocal;
            if (charBufferFromThreadLocal.length < count) {
                growBuffer2 = growBuffer(charBufferFromThreadLocal, n, count);
            }
            s.getChars(n3, length, growBuffer2, n);
        }
        return new String(growBuffer2, 0, count);
    }
    
    protected int nextEscapeIndex(final CharSequence charSequence, int i, final int n) {
        while (i < n) {
            final int codePoint = codePointAt(charSequence, i, n);
            if (codePoint < 0 || this.escape(codePoint) != null) {
                break;
            }
            int n2;
            if (Character.isSupplementaryCodePoint(codePoint)) {
                n2 = 2;
            }
            else {
                n2 = 1;
            }
            i += n2;
        }
        return i;
    }
}
