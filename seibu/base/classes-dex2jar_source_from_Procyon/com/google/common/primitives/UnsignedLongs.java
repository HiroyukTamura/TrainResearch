// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.util.Comparator;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class UnsignedLongs
{
    public static final long MAX_VALUE = -1L;
    private static final int[] maxSafeDigits;
    private static final long[] maxValueDivs;
    private static final int[] maxValueMods;
    
    static {
        maxValueDivs = new long[37];
        maxValueMods = new int[37];
        maxSafeDigits = new int[37];
        final BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; ++i) {
            UnsignedLongs.maxValueDivs[i] = divide(-1L, i);
            UnsignedLongs.maxValueMods[i] = (int)remainder(-1L, i);
            UnsignedLongs.maxSafeDigits[i] = bigInteger.toString(i).length() - 1;
        }
    }
    
    private UnsignedLongs() {
    }
    
    public static int compare(final long n, final long n2) {
        return Longs.compare(flip(n), flip(n2));
    }
    
    public static long decode(String s) {
        final ParseRequest fromString = ParseRequest.fromString(s);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
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
    
    public static long divide(final long n, final long n2) {
        boolean b = true;
        if (n2 < 0L) {
            if (compare(n, n2) < 0) {
                return 0L;
            }
            return 1L;
        }
        else {
            if (n >= 0L) {
                return n / n2;
            }
            final long n3 = (n >>> 1) / n2 << 1;
            if (compare(n - n3 * n2, n2) < 0) {
                b = false;
            }
            return (b ? 1 : 0) + n3;
        }
    }
    
    private static long flip(final long n) {
        return Long.MIN_VALUE ^ n;
    }
    
    public static String join(final String str, final long... array) {
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
    
    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static long max(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long flip = flip(array[0]);
        long n;
        for (int i = 1; i < array.length; ++i, flip = n) {
            final long flip2 = flip(array[i]);
            n = flip;
            if (flip2 > flip) {
                n = flip2;
            }
        }
        return flip(flip);
    }
    
    public static long min(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long flip = flip(array[0]);
        long n;
        for (int i = 1; i < array.length; ++i, flip = n) {
            final long flip2 = flip(array[i]);
            n = flip;
            if (flip2 < flip) {
                n = flip2;
            }
        }
        return flip(flip);
    }
    
    private static boolean overflowInParse(final long n, final int n2, final int n3) {
        boolean b2;
        final boolean b = b2 = true;
        if (n >= 0L) {
            if (n < UnsignedLongs.maxValueDivs[n3]) {
                b2 = false;
            }
            else {
                b2 = b;
                if (n <= UnsignedLongs.maxValueDivs[n3]) {
                    b2 = b;
                    if (n2 <= UnsignedLongs.maxValueMods[n3]) {
                        return false;
                    }
                }
            }
        }
        return b2;
    }
    
    public static long parseUnsignedLong(final String s) {
        return parseUnsignedLong(s, 10);
    }
    
    public static long parseUnsignedLong(String o, final int n) {
        Preconditions.checkNotNull(o);
        if (((String)o).length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (n < 2 || n > 36) {
            throw new NumberFormatException(new StringBuilder(26).append("illegal radix: ").append(n).toString());
        }
        final int n2 = UnsignedLongs.maxSafeDigits[n];
        long n3 = 0L;
        for (int i = 0; i < ((String)o).length(); ++i) {
            final int digit = Character.digit(((String)o).charAt(i), n);
            if (digit == -1) {
                throw new NumberFormatException((String)o);
            }
            if (i > n2 - 1 && overflowInParse(n3, digit, n)) {
                o = String.valueOf(o);
                if (((String)o).length() != 0) {
                    o = "Too large for unsigned long: ".concat((String)o);
                }
                else {
                    o = new String("Too large for unsigned long: ");
                }
                throw new NumberFormatException((String)o);
            }
            n3 = n * n3 + digit;
        }
        return n3;
    }
    
    public static long remainder(long n, long n2) {
        if (n2 < 0L) {
            if (compare(n, n2) < 0) {
                return n;
            }
            return n - n2;
        }
        else {
            if (n >= 0L) {
                return n % n2;
            }
            n -= ((n >>> 1) / n2 << 1) * n2;
            if (compare(n, n2) < 0) {
                n2 = 0L;
            }
            return n - n2;
        }
    }
    
    public static String toString(final long n) {
        return toString(n, 10);
    }
    
    public static String toString(final long n, final int radix) {
        Preconditions.checkArgument(radix >= 2 && radix <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", radix);
        if (n == 0L) {
            return "0";
        }
        final char[] value = new char[64];
        int length;
        final int n2 = length = value.length;
        long divide = n;
        if (n < 0L) {
            divide = divide(n, radix);
            final long n3 = radix;
            length = n2 - 1;
            value[length] = Character.forDigit((int)(n - n3 * divide), radix);
        }
        while (divide > 0L) {
            --length;
            value[length] = Character.forDigit((int)(divide % radix), radix);
            divide /= radix;
        }
        return new String(value, length, value.length - length);
    }
    
    enum LexicographicalComparator implements Comparator<long[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final long[] array, final long[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                if (array[i] != array2[i]) {
                    return UnsignedLongs.compare(array[i], array2[i]);
                }
            }
            return array.length - array2.length;
        }
    }
}
