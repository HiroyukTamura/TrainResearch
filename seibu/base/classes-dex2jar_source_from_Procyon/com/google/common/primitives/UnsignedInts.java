// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.util.Comparator;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class UnsignedInts
{
    static final long INT_MASK = 4294967295L;
    
    private UnsignedInts() {
    }
    
    public static int compare(final int n, final int n2) {
        return Ints.compare(flip(n), flip(n2));
    }
    
    public static int decode(String s) {
        final ParseRequest fromString = ParseRequest.fromString(s);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        }
        catch (NumberFormatException cause) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "Error parsing value: ".concat(s);
            }
            else {
                s = new String("Error parsing value: ");
            }
            final NumberFormatException ex = new NumberFormatException(s);
            ex.initCause(cause);
            throw ex;
        }
    }
    
    public static int divide(final int n, final int n2) {
        return (int)(toLong(n) / toLong(n2));
    }
    
    static int flip(final int n) {
        return Integer.MIN_VALUE ^ n;
    }
    
    public static String join(final String str, final int... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(toString(array[0]));
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(toString(array[i]));
        }
        return sb.toString();
    }
    
    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static int max(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int flip = flip(array[0]);
        int n;
        for (int i = 1; i < array.length; ++i, flip = n) {
            final int flip2 = flip(array[i]);
            if (flip2 > (n = flip)) {
                n = flip2;
            }
        }
        return flip(flip);
    }
    
    public static int min(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int flip = flip(array[0]);
        int n;
        for (int i = 1; i < array.length; ++i, flip = n) {
            final int flip2 = flip(array[i]);
            if (flip2 < (n = flip)) {
                n = flip2;
            }
        }
        return flip(flip);
    }
    
    public static int parseUnsignedInt(final String s) {
        return parseUnsignedInt(s, 10);
    }
    
    public static int parseUnsignedInt(String value, final int n) {
        Preconditions.checkNotNull(value);
        final long long1 = Long.parseLong(value, n);
        if ((0xFFFFFFFFL & long1) != long1) {
            value = String.valueOf(String.valueOf(value));
            throw new NumberFormatException(new StringBuilder(value.length() + 69).append("Input ").append(value).append(" in base ").append(n).append(" is not in the range of an unsigned integer").toString());
        }
        return (int)long1;
    }
    
    public static int remainder(final int n, final int n2) {
        return (int)(toLong(n) % toLong(n2));
    }
    
    public static long toLong(final int n) {
        return (long)n & 0xFFFFFFFFL;
    }
    
    public static String toString(final int n) {
        return toString(n, 10);
    }
    
    public static String toString(final int n, final int radix) {
        return Long.toString((long)n & 0xFFFFFFFFL, radix);
    }
    
    enum LexicographicalComparator implements Comparator<int[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final int[] array, final int[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                if (array[i] != array2[i]) {
                    return UnsignedInts.compare(array[i], array2[i]);
                }
            }
            return array.length - array2.length;
        }
    }
}
