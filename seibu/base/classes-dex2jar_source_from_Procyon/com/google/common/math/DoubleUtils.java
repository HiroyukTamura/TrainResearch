// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

final class DoubleUtils
{
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    private static final long ONE_BITS;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;
    
    static {
        ONE_BITS = Double.doubleToRawLongBits(1.0);
    }
    
    private DoubleUtils() {
    }
    
    static double bigToDouble(final BigInteger bigInteger) {
        final BigInteger abs = bigInteger.abs();
        final int n = abs.bitLength() - 1;
        if (n < 63) {
            return (double)bigInteger.longValue();
        }
        if (n > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        final int n2 = n - 52 - 1;
        final long longValue = abs.shiftRight(n2).longValue();
        long n3 = longValue >> 1 & 0xFFFFFFFFFFFFFL;
        int n4;
        if ((0x1L & longValue) != 0x0L && ((0x1L & n3) != 0x0L || abs.getLowestSetBit() < n2)) {
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        if (n4 != 0) {
            ++n3;
        }
        return Double.longBitsToDouble(((long)(n + 1023) << 52) + n3 | ((long)bigInteger.signum() & Long.MIN_VALUE));
    }
    
    static double ensureNonNegative(final double v) {
        Preconditions.checkArgument(!Double.isNaN(v));
        if (v > 0.0) {
            return v;
        }
        return 0.0;
    }
    
    static long getSignificand(final double d) {
        Preconditions.checkArgument(isFinite(d), (Object)"not a normal value");
        final int exponent = Math.getExponent(d);
        final long n = Double.doubleToRawLongBits(d) & 0xFFFFFFFFFFFFFL;
        if (exponent == -1023) {
            return n << 1;
        }
        return 0x10000000000000L | n;
    }
    
    static boolean isFinite(final double d) {
        return Math.getExponent(d) <= 1023;
    }
    
    static boolean isNormal(final double d) {
        return Math.getExponent(d) >= -1022;
    }
    
    static double nextDown(final double n) {
        return -Math.nextUp(-n);
    }
    
    static double scaleNormalize(final double n) {
        return Double.longBitsToDouble(DoubleUtils.ONE_BITS | (Double.doubleToRawLongBits(n) & 0xFFFFFFFFFFFFFL));
    }
}
