// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.util.Comparator;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class SignedBytes
{
    public static final byte MAX_POWER_OF_TWO = 64;
    
    private SignedBytes() {
    }
    
    public static byte checkedCast(final long lng) {
        final byte b = (byte)lng;
        if (b != lng) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(lng).toString());
        }
        return b;
    }
    
    public static int compare(final byte b, final byte b2) {
        return b - b2;
    }
    
    public static String join(final String str, final byte... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static byte max(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        byte b = array[0];
        byte b2;
        for (int i = 1; i < array.length; ++i, b = b2) {
            if (array[i] > (b2 = b)) {
                b2 = array[i];
            }
        }
        return b;
    }
    
    public static byte min(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        byte b = array[0];
        byte b2;
        for (int i = 1; i < array.length; ++i, b = b2) {
            if (array[i] < (b2 = b)) {
                b2 = array[i];
            }
        }
        return b;
    }
    
    public static byte saturatedCast(final long n) {
        if (n > 127L) {
            return 127;
        }
        if (n < -128L) {
            return -128;
        }
        return (byte)n;
    }
    
    private enum LexicographicalComparator implements Comparator<byte[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final byte[] array, final byte[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = SignedBytes.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
}
