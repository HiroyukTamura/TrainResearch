// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Strings
{
    private Strings() {
    }
    
    public static String commonPrefix(final CharSequence charSequence, final CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min;
        int n;
        for (min = Math.min(charSequence.length(), charSequence2.length()), n = 0; n < min && charSequence.charAt(n) == charSequence2.charAt(n); ++n) {}
        if (!validSurrogatePairAt(charSequence, n - 1)) {
            final int n2 = n;
            if (!validSurrogatePairAt(charSequence2, n - 1)) {
                return charSequence.subSequence(0, n2).toString();
            }
        }
        final int n2 = n - 1;
        return charSequence.subSequence(0, n2).toString();
    }
    
    public static String commonSuffix(final CharSequence charSequence, final CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min;
        int n;
        for (min = Math.min(charSequence.length(), charSequence2.length()), n = 0; n < min && charSequence.charAt(charSequence.length() - n - 1) == charSequence2.charAt(charSequence2.length() - n - 1); ++n) {}
        if (!validSurrogatePairAt(charSequence, charSequence.length() - n - 1)) {
            final int n2 = n;
            if (!validSurrogatePairAt(charSequence2, charSequence2.length() - n - 1)) {
                return charSequence.subSequence(charSequence.length() - n2, charSequence.length()).toString();
            }
        }
        final int n2 = n - 1;
        return charSequence.subSequence(charSequence.length() - n2, charSequence.length()).toString();
    }
    
    @Nullable
    public static String emptyToNull(@Nullable final String s) {
        String s2 = s;
        if (isNullOrEmpty(s)) {
            s2 = null;
        }
        return s2;
    }
    
    public static boolean isNullOrEmpty(@Nullable final String s) {
        return s == null || s.length() == 0;
    }
    
    public static String nullToEmpty(@Nullable final String s) {
        String s2 = s;
        if (s == null) {
            s2 = "";
        }
        return s2;
    }
    
    public static String padEnd(final String str, final int capacity, final char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= capacity) {
            return str;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        sb.append(str);
        for (int i = str.length(); i < capacity; ++i) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static String padStart(final String str, final int capacity, final char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= capacity) {
            return str;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        for (int i = str.length(); i < capacity; ++i) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }
    
    public static String repeat(String s, int i) {
        Preconditions.checkNotNull(s);
        if (i <= 1) {
            Preconditions.checkArgument(i >= 0, "invalid count: %s", i);
            if (i == 0) {
                s = "";
            }
            return s;
        }
        final int length = s.length();
        final long lng = length * (long)i;
        final int n = (int)lng;
        if (n != lng) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(51).append("Required array size too large: ").append(lng).toString());
        }
        final char[] array = new char[n];
        s.getChars(0, length, array, 0);
        for (i = length; i < n - i; i <<= 1) {
            System.arraycopy(array, 0, array, i, i);
        }
        System.arraycopy(array, 0, array, i, n - i);
        return new String(array);
    }
    
    @VisibleForTesting
    static boolean validSurrogatePairAt(final CharSequence charSequence, final int n) {
        return n >= 0 && n <= charSequence.length() - 2 && Character.isHighSurrogate(charSequence.charAt(n)) && Character.isLowSurrogate(charSequence.charAt(n + 1));
    }
}
