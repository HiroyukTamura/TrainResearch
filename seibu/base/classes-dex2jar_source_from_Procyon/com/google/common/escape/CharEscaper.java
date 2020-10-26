// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public abstract class CharEscaper extends Escaper
{
    private static final int DEST_PAD_MULTIPLIER = 2;
    
    protected CharEscaper() {
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
        int index = 0;
        String escapeSlow;
        while (true) {
            escapeSlow = s;
            if (index >= length) {
                break;
            }
            if (this.escape(s.charAt(index)) != null) {
                escapeSlow = this.escapeSlow(s, index);
                break;
            }
            ++index;
        }
        return escapeSlow;
    }
    
    protected abstract char[] escape(final char p0);
    
    protected final String escapeSlow(final String s, int n) {
        final int length = s.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = charBufferFromThreadLocal.length;
        final int n2 = 0;
        int n3 = 0;
        int i = n;
        n = n2;
        while (i < length) {
            final char[] escape = this.escape(s.charAt(i));
            if (escape != null) {
                final int length3 = escape.length;
                final int n4 = i - n3;
                final int n5 = n + n4 + length3;
                char[] growBuffer = charBufferFromThreadLocal;
                int n6;
                if ((n6 = length2) < n5) {
                    n6 = n5 + (length - i) * 2;
                    growBuffer = growBuffer(charBufferFromThreadLocal, n, n6);
                }
                int n7 = n;
                if (n4 > 0) {
                    s.getChars(n3, i, growBuffer, n);
                    n7 = n + n4;
                }
                n = n7;
                if (length3 > 0) {
                    System.arraycopy(escape, 0, growBuffer, n7, length3);
                    n = n7 + length3;
                }
                n3 = i + 1;
                charBufferFromThreadLocal = growBuffer;
                length2 = n6;
            }
            ++i;
        }
        final int n8 = length - n3;
        char[] growBuffer2 = charBufferFromThreadLocal;
        int count = n;
        if (n8 > 0) {
            count = n + n8;
            growBuffer2 = charBufferFromThreadLocal;
            if (length2 < count) {
                growBuffer2 = growBuffer(charBufferFromThreadLocal, n, count);
            }
            s.getChars(n3, length, growBuffer2, n);
        }
        return new String(growBuffer2, 0, count);
    }
}
