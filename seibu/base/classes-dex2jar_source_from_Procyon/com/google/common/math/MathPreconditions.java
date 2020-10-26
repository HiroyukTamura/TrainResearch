// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import java.math.BigInteger;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class MathPreconditions
{
    private MathPreconditions() {
    }
    
    static void checkInRange(final boolean b) {
        if (!b) {
            throw new ArithmeticException("not in range");
        }
    }
    
    static void checkNoOverflow(final boolean b) {
        if (!b) {
            throw new ArithmeticException("overflow");
        }
    }
    
    static double checkNonNegative(@Nullable String value, final double d) {
        if (d < 0.0) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 40).append(value).append(" (").append(d).append(") must be >= 0").toString());
        }
        return d;
    }
    
    static int checkNonNegative(@Nullable String value, final int i) {
        if (i < 0) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 27).append(value).append(" (").append(i).append(") must be >= 0").toString());
        }
        return i;
    }
    
    static long checkNonNegative(@Nullable String value, final long lng) {
        if (lng < 0L) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 36).append(value).append(" (").append(lng).append(") must be >= 0").toString());
        }
        return lng;
    }
    
    static BigInteger checkNonNegative(@Nullable String value, final BigInteger obj) {
        if (obj.signum() < 0) {
            value = String.valueOf(String.valueOf(value));
            final String value2 = String.valueOf(String.valueOf(obj));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 16 + value2.length()).append(value).append(" (").append(value2).append(") must be >= 0").toString());
        }
        return obj;
    }
    
    static int checkPositive(@Nullable String value, final int i) {
        if (i <= 0) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 26).append(value).append(" (").append(i).append(") must be > 0").toString());
        }
        return i;
    }
    
    static long checkPositive(@Nullable String value, final long lng) {
        if (lng <= 0L) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 35).append(value).append(" (").append(lng).append(") must be > 0").toString());
        }
        return lng;
    }
    
    static BigInteger checkPositive(@Nullable String value, final BigInteger obj) {
        if (obj.signum() <= 0) {
            value = String.valueOf(String.valueOf(value));
            final String value2 = String.valueOf(String.valueOf(obj));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 15 + value2.length()).append(value).append(" (").append(value2).append(") must be > 0").toString());
        }
        return obj;
    }
    
    static void checkRoundingUnnecessary(final boolean b) {
        if (!b) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
