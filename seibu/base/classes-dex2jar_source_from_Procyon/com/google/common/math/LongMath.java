// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import java.math.RoundingMode;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class LongMath
{
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final int[] biggestBinomials;
    @VisibleForTesting
    static final int[] biggestSimpleBinomials;
    static final long[] factorials;
    @GwtIncompatible("TODO")
    @VisibleForTesting
    static final long[] halfPowersOf10;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros;
    @GwtIncompatible("TODO")
    @VisibleForTesting
    static final long[] powersOf10;
    
    static {
        maxLog10ForLeadingZeros = new byte[] { 19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0 };
        powersOf10 = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
        halfPowersOf10 = new long[] { 3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
        factorials = new long[] { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
        biggestBinomials = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66 };
        biggestSimpleBinomials = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61 };
    }
    
    private LongMath() {
    }
    
    public static long binomial(int i, int log2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", log2);
        Preconditions.checkArgument(log2 <= i, "k (%s) > n (%s)", log2, i);
        int n = log2;
        if (log2 > i >> 1) {
            n = i - log2;
        }
        switch (n) {
            default: {
                long n2;
                if (i < LongMath.factorials.length) {
                    n2 = LongMath.factorials[i] / (LongMath.factorials[n] * LongMath.factorials[i - n]);
                }
                else {
                    if (n >= LongMath.biggestBinomials.length || i > LongMath.biggestBinomials[n]) {
                        return Long.MAX_VALUE;
                    }
                    if (n >= LongMath.biggestSimpleBinomials.length || i > LongMath.biggestSimpleBinomials[n]) {
                        log2 = log2(i, RoundingMode.CEILING);
                        long multiplyFraction = 1L;
                        long n3 = i;
                        long n4 = 1L;
                        final int n5 = log2;
                        final int n6 = 2;
                        int n7 = i - 1;
                        i = n5;
                        for (int j = n6; j <= n; ++j, --n7) {
                            if (i + log2 < 63) {
                                n3 *= n7;
                                n4 *= j;
                                i += log2;
                            }
                            else {
                                multiplyFraction = multiplyFraction(multiplyFraction, n3, n4);
                                n3 = n7;
                                n4 = j;
                                i = log2;
                            }
                        }
                        return multiplyFraction(multiplyFraction, n3, n4);
                    }
                    long n8 = i;
                    final int n9 = 2;
                    log2 = i - 1;
                    i = n9;
                    while (true) {
                        n2 = n8;
                        if (i > n) {
                            break;
                        }
                        n8 = n8 * log2 / i;
                        --log2;
                        ++i;
                    }
                }
                return n2;
            }
            case 0: {
                return 1L;
            }
            case 1: {
                return i;
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long checkedAdd(final long n, final long n2) {
        boolean b = true;
        final long n3 = n + n2;
        boolean b2;
        if ((n ^ n2) < 0L) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if ((n ^ n3) < 0L) {
            b = false;
        }
        MathPreconditions.checkNoOverflow(b | b2);
        return n3;
    }
    
    @GwtIncompatible("TODO")
    public static long checkedMultiply(final long i, final long j) {
        final boolean b = false;
        final int n = Long.numberOfLeadingZeros(i) + Long.numberOfLeadingZeros(~i) + Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j);
        if (n > 65) {
            return i * j;
        }
        MathPreconditions.checkNoOverflow(n >= 64);
        boolean b2;
        if (i >= 0L) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (j != Long.MIN_VALUE) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        MathPreconditions.checkNoOverflow(b3 | b2);
        final long n2 = i * j;
        boolean b4 = false;
        Label_0113: {
            if (i != 0L) {
                b4 = b;
                if (n2 / i != j) {
                    break Label_0113;
                }
            }
            b4 = true;
        }
        MathPreconditions.checkNoOverflow(b4);
        return n2;
    }
    
    @GwtIncompatible("TODO")
    public static long checkedPow(long n, int n2) {
        boolean b = true;
        MathPreconditions.checkNonNegative("exponent", n2);
        boolean b2;
        if (n >= -2L) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (n <= 2L) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (b3 & b2) {
            switch ((int)n) {
                default: {
                    throw new AssertionError();
                }
                case 0: {
                    if (n2 == 0) {
                        return 1L;
                    }
                    return 0L;
                }
                case 1: {
                    return 1L;
                }
                case -1: {
                    if ((n2 & 0x1) != 0x0) {
                        return -1L;
                    }
                    return 1L;
                }
                case 2: {
                    MathPreconditions.checkNoOverflow(n2 < 63);
                    return 1L << n2;
                }
                case -2: {
                    if (n2 >= 64) {
                        b = false;
                    }
                    MathPreconditions.checkNoOverflow(b);
                    if ((n2 & 0x1) == 0x0) {
                        return 1L << n2;
                    }
                    return -1L << n2;
                }
            }
        }
        else {
            long n3 = 1L;
            while (true) {
                switch (n2) {
                    default: {
                        long checkedMultiply = n3;
                        if ((n2 & 0x1) != 0x0) {
                            checkedMultiply = checkedMultiply(n3, n);
                        }
                        final int n4 = n2 >> 1;
                        n3 = checkedMultiply;
                        if ((n2 = n4) > 0) {
                            MathPreconditions.checkNoOverflow(n <= 3037000499L);
                            n *= n;
                            n3 = checkedMultiply;
                            n2 = n4;
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        return n3;
                    }
                    case 1: {
                        return checkedMultiply(n3, n);
                    }
                }
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long checkedSubtract(final long n, final long n2) {
        boolean b = true;
        final long n3 = n - n2;
        boolean b2;
        if ((n ^ n2) >= 0L) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if ((n ^ n3) < 0L) {
            b = false;
        }
        MathPreconditions.checkNoOverflow(b | b2);
        return n3;
    }
    
    @GwtIncompatible("TODO")
    public static long divide(long abs, final long a, final RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        final long n = abs / a;
        final long a2 = abs - a * n;
        if (a2 != 0L) {
            final int n2 = (int)((abs ^ a) >> 63) | 0x1;
            int n3 = 0;
            switch (roundingMode) {
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    MathPreconditions.checkRoundingUnnecessary(a2 == 0L);
                }
                case DOWN: {
                    n3 = 0;
                    break;
                }
                case UP: {
                    n3 = 1;
                    break;
                }
                case CEILING: {
                    if (n2 > 0) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    break;
                }
                case FLOOR: {
                    if (n2 < 0) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    break;
                }
                case HALF_DOWN:
                case HALF_UP:
                case HALF_EVEN: {
                    abs = Math.abs(a2);
                    abs -= Math.abs(a) - abs;
                    if (abs == 0L) {
                        boolean b;
                        if (roundingMode == RoundingMode.HALF_UP) {
                            b = true;
                        }
                        else {
                            b = false;
                        }
                        boolean b2;
                        if (roundingMode == RoundingMode.HALF_EVEN) {
                            b2 = true;
                        }
                        else {
                            b2 = false;
                        }
                        boolean b3;
                        if ((0x1L & n) != 0x0L) {
                            b3 = true;
                        }
                        else {
                            b3 = false;
                        }
                        n3 = ((b | (b3 & b2)) ? 1 : 0);
                        break;
                    }
                    if (abs > 0L) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    break;
                }
            }
            if (n3 != 0) {
                return n + n2;
            }
        }
        return n;
    }
    
    @GwtIncompatible("TODO")
    public static long factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n < LongMath.factorials.length) {
            return LongMath.factorials[n];
        }
        return Long.MAX_VALUE;
    }
    
    static boolean fitsInInt(final long n) {
        return (int)n == n;
    }
    
    public static long gcd(long i, long j) {
        MathPreconditions.checkNonNegative("a", i);
        MathPreconditions.checkNonNegative("b", j);
        long n;
        if (i == 0L) {
            n = j;
        }
        else {
            n = i;
            if (j != 0L) {
                final int numberOfTrailingZeros = Long.numberOfTrailingZeros(i);
                final long n2 = i >> numberOfTrailingZeros;
                final int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j);
                long n3;
                long k;
                for (i = j >> numberOfTrailingZeros2, j = n2; j != i; j = (n3 & n3 >> 63), k = n3 - j - j, i += j, j = k >> Long.numberOfTrailingZeros(k)) {
                    n3 = j - i;
                }
                return j << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
            }
        }
        return n;
    }
    
    public static boolean isPowerOfTwo(final long n) {
        boolean b = true;
        boolean b2;
        if (n > 0L) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if ((n - 1L & n) != 0x0L) {
            b = false;
        }
        return b & b2;
    }
    
    @VisibleForTesting
    static int lessThanBranchFree(final long n, final long n2) {
        return (int)(~(~(n - n2)) >>> 63);
    }
    
    @GwtIncompatible("TODO")
    public static int log10(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        final int log10Floor = log10Floor(n);
        final long n2 = LongMath.powersOf10[log10Floor];
        switch (roundingMode) {
            default: {
                throw new AssertionError();
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(n == n2);
            }
            case DOWN:
            case FLOOR: {
                return log10Floor;
            }
            case UP:
            case CEILING: {
                return log10Floor + lessThanBranchFree(n2, n);
            }
            case HALF_DOWN:
            case HALF_UP:
            case HALF_EVEN: {
                return log10Floor + lessThanBranchFree(LongMath.halfPowersOf10[log10Floor], n);
            }
        }
    }
    
    @GwtIncompatible("TODO")
    static int log10Floor(final long i) {
        final byte b = LongMath.maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(i)];
        return b - lessThanBranchFree(i, LongMath.powersOf10[b]);
    }
    
    public static int log2(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        switch (roundingMode) {
            default: {
                throw new AssertionError((Object)"impossible");
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(n));
            }
            case DOWN:
            case FLOOR: {
                return 63 - Long.numberOfLeadingZeros(n);
            }
            case UP:
            case CEILING: {
                return 64 - Long.numberOfLeadingZeros(n - 1L);
            }
            case HALF_DOWN:
            case HALF_UP:
            case HALF_EVEN: {
                final int numberOfLeadingZeros = Long.numberOfLeadingZeros(n);
                return lessThanBranchFree(-5402926248376769404L >>> numberOfLeadingZeros, n) + (63 - numberOfLeadingZeros);
            }
        }
    }
    
    public static long mean(final long n, final long n2) {
        return (n & n2) + ((n ^ n2) >> 1);
    }
    
    @GwtIncompatible("TODO")
    public static int mod(final long n, final int n2) {
        return (int)mod(n, (long)n2);
    }
    
    @GwtIncompatible("TODO")
    public static long mod(long n, final long n2) {
        if (n2 <= 0L) {
            throw new ArithmeticException("Modulus must be positive");
        }
        n %= n2;
        if (n >= 0L) {
            return n;
        }
        return n + n2;
    }
    
    static long multiplyFraction(long n, final long n2, final long n3) {
        if (n == 1L) {
            return n2 / n3;
        }
        final long gcd = gcd(n, n3);
        n /= gcd;
        return n2 / (n3 / gcd) * n;
    }
    
    @GwtIncompatible("TODO")
    public static long pow(long n, int n2) {
        final long n3 = 0L;
        MathPreconditions.checkNonNegative("exponent", n2);
        if (-2L <= n && n <= 2L) {
            switch ((int)n) {
                default: {
                    throw new AssertionError();
                }
                case 0: {
                    if (n2 == 0) {
                        return 1L;
                    }
                    return 0L;
                }
                case 1: {
                    return 1L;
                }
                case -1: {
                    if ((n2 & 0x1) != 0x0) {
                        return -1L;
                    }
                    return 1L;
                }
                case 2: {
                    n = n3;
                    if (n2 < 64) {
                        n = 1L << n2;
                    }
                    return n;
                }
                case -2: {
                    if (n2 >= 64) {
                        return 0L;
                    }
                    if ((n2 & 0x1) == 0x0) {
                        return 1L << n2;
                    }
                    return -(1L << n2);
                }
            }
        }
        else {
            long n4 = 1L;
            while (true) {
                switch (n2) {
                    default: {
                        long n5;
                        if ((n2 & 0x1) == 0x0) {
                            n5 = 1L;
                        }
                        else {
                            n5 = n;
                        }
                        n4 *= n5;
                        n *= n;
                        n2 >>= 1;
                        continue;
                    }
                    case 0: {
                        return n4;
                    }
                    case 1: {
                        return n4 * n;
                    }
                }
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long sqrt(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", n);
        long n2 = 0L;
        if (fitsInInt(n)) {
            n2 = IntMath.sqrt((int)n, roundingMode);
        }
        else {
            final long n3 = (long)Math.sqrt((double)n);
            final long n4 = n3 * n3;
            switch (roundingMode) {
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    MathPreconditions.checkRoundingUnnecessary(n4 == n);
                    return n3;
                }
                case DOWN:
                case FLOOR: {
                    n2 = n3;
                    if (n < n4) {
                        return n3 - 1L;
                    }
                    break;
                }
                case UP:
                case CEILING: {
                    n2 = n3;
                    if (n > n4) {
                        return n3 + 1L;
                    }
                    break;
                }
                case HALF_DOWN:
                case HALF_UP:
                case HALF_EVEN: {
                    int n5;
                    if (n < n4) {
                        n5 = 1;
                    }
                    else {
                        n5 = 0;
                    }
                    final long n6 = n3 - n5;
                    return n6 + lessThanBranchFree(n6 * n6 + n6, n);
                }
            }
        }
        return n2;
    }
}
