// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import java.math.RoundingMode;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class IntMath
{
    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;
    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    @VisibleForTesting
    static int[] biggestBinomials;
    private static final int[] factorials;
    @VisibleForTesting
    static final int[] halfPowersOf10;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros;
    @VisibleForTesting
    static final int[] powersOf10;
    
    static {
        maxLog10ForLeadingZeros = new byte[] { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
        powersOf10 = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
        halfPowersOf10 = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
        factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
        IntMath.biggestBinomials = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
    }
    
    private IntMath() {
    }
    
    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int binomial(final int i, int j) {
        final int n = 1;
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", j);
        Preconditions.checkArgument(j <= i, "k (%s) > n (%s)", j, i);
        int n2 = j;
        if (j > i >> 1) {
            n2 = i - j;
        }
        if (n2 >= IntMath.biggestBinomials.length || i > IntMath.biggestBinomials[n2]) {
            j = Integer.MAX_VALUE;
        }
        else {
            j = n;
            switch (n2) {
                case 0: {
                    break;
                }
                default: {
                    long n3 = 1L;
                    for (j = 0; j < n2; ++j) {
                        n3 = n3 * (i - j) / (j + 1);
                    }
                    return (int)n3;
                }
                case 1: {
                    return i;
                }
            }
        }
        return j;
    }
    
    public static int checkedAdd(final int n, final int n2) {
        final long n3 = n + (long)n2;
        MathPreconditions.checkNoOverflow(n3 == (int)n3);
        return (int)n3;
    }
    
    public static int checkedMultiply(final int n, final int n2) {
        final long n3 = n * (long)n2;
        MathPreconditions.checkNoOverflow(n3 == (int)n3);
        return (int)n3;
    }
    
    public static int checkedPow(int n, int checkedMultiply) {
        final boolean b = false;
        boolean b2 = false;
        MathPreconditions.checkNonNegative("exponent", checkedMultiply);
        switch (n) {
            default: {
                int n2 = 1;
                int n3 = checkedMultiply;
                while (true) {
                    switch (n3) {
                        default: {
                            checkedMultiply = n2;
                            if ((n3 & 0x1) != 0x0) {
                                checkedMultiply = checkedMultiply(n2, n);
                            }
                            final int n4 = n3 >> 1;
                            n2 = checkedMultiply;
                            if ((n3 = n4) > 0) {
                                boolean b3;
                                if (-46340 <= n) {
                                    b3 = true;
                                }
                                else {
                                    b3 = false;
                                }
                                boolean b4;
                                if (n <= 46340) {
                                    b4 = true;
                                }
                                else {
                                    b4 = false;
                                }
                                MathPreconditions.checkNoOverflow(b4 & b3);
                                n *= n;
                                n2 = checkedMultiply;
                                n3 = n4;
                                continue;
                            }
                            continue;
                        }
                        case 0: {
                            return n2;
                        }
                        case 1: {
                            return checkedMultiply(n2, n);
                        }
                    }
                }
                break;
            }
            case 0: {
                if (checkedMultiply == 0) {
                    return 1;
                }
                return 0;
            }
            case 1: {
                return 1;
            }
            case -1: {
                if ((checkedMultiply & 0x1) != 0x0) {
                    return -1;
                }
                return 1;
            }
            case 2: {
                if (checkedMultiply < 31) {
                    b2 = true;
                }
                MathPreconditions.checkNoOverflow(b2);
                return 1 << checkedMultiply;
            }
            case -2: {
                boolean b5 = b;
                if (checkedMultiply < 32) {
                    b5 = true;
                }
                MathPreconditions.checkNoOverflow(b5);
                if ((checkedMultiply & 0x1) == 0x0) {
                    return 1 << checkedMultiply;
                }
                return -1 << checkedMultiply;
            }
        }
    }
    
    public static int checkedSubtract(final int n, final int n2) {
        final long n3 = n - (long)n2;
        MathPreconditions.checkNoOverflow(n3 == (int)n3);
        return (int)n3;
    }
    
    public static int divide(int abs, int a, final RoundingMode roundingMode) {
        boolean b = true;
        Preconditions.checkNotNull(roundingMode);
        if (a == 0) {
            throw new ArithmeticException("/ by zero");
        }
        final int n = abs / a;
        final int a2 = abs - a * n;
        if (a2 != 0) {
            final int n2 = (abs ^ a) >> 31 | 0x1;
            switch (roundingMode) {
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    if (a2 != 0) {
                        b = false;
                    }
                    MathPreconditions.checkRoundingUnnecessary(b);
                }
                case DOWN: {
                    abs = 0;
                    break;
                }
                case UP: {
                    abs = 1;
                    break;
                }
                case CEILING: {
                    if (n2 > 0) {
                        abs = 1;
                    }
                    else {
                        abs = 0;
                    }
                    break;
                }
                case FLOOR: {
                    if (n2 < 0) {
                        abs = 1;
                    }
                    else {
                        abs = 0;
                    }
                    break;
                }
                case HALF_DOWN:
                case HALF_UP:
                case HALF_EVEN: {
                    abs = Math.abs(a2);
                    abs -= Math.abs(a) - abs;
                    if (abs == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                abs = 1;
                            }
                            else {
                                abs = 0;
                            }
                            if ((n & 0x1) != 0x0) {
                                a = 1;
                            }
                            else {
                                a = 0;
                            }
                            if ((a & abs) == 0x0) {
                                abs = 0;
                                break;
                            }
                        }
                        abs = 1;
                        break;
                    }
                    if (abs > 0) {
                        abs = 1;
                    }
                    else {
                        abs = 0;
                    }
                    break;
                }
            }
            if (abs != 0) {
                return n + n2;
            }
        }
        return n;
    }
    
    public static int factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n < IntMath.factorials.length) {
            return IntMath.factorials[n];
        }
        return Integer.MAX_VALUE;
    }
    
    public static int gcd(int i, int j) {
        MathPreconditions.checkNonNegative("a", i);
        MathPreconditions.checkNonNegative("b", j);
        int n;
        if (i == 0) {
            n = j;
        }
        else {
            n = i;
            if (j != 0) {
                final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
                final int n2 = i >> numberOfTrailingZeros;
                final int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(j);
                int n3;
                int k;
                for (i = j >> numberOfTrailingZeros2, j = n2; j != i; j = (n3 & n3 >> 31), k = n3 - j - j, i += j, j = k >> Integer.numberOfTrailingZeros(k)) {
                    n3 = j - i;
                }
                return j << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
            }
        }
        return n;
    }
    
    public static boolean isPowerOfTwo(int n) {
        final int n2 = 1;
        boolean b;
        if (n > 0) {
            b = true;
        }
        else {
            b = false;
        }
        if ((n - 1 & n) == 0x0) {
            n = n2;
        }
        else {
            n = 0;
        }
        return (n & (b ? 1 : 0)) != 0x0;
    }
    
    @VisibleForTesting
    static int lessThanBranchFree(final int n, final int n2) {
        return ~(~(n - n2)) >>> 31;
    }
    
    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int log10(final int n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        final int log10Floor = log10Floor(n);
        final int n2 = IntMath.powersOf10[log10Floor];
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
                return log10Floor + lessThanBranchFree(IntMath.halfPowersOf10[log10Floor], n);
            }
        }
    }
    
    private static int log10Floor(final int i) {
        final byte b = IntMath.maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i)];
        return b - lessThanBranchFree(i, IntMath.powersOf10[b]);
    }
    
    public static int log2(final int n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        switch (roundingMode) {
            default: {
                throw new AssertionError();
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(n));
            }
            case DOWN:
            case FLOOR: {
                return 31 - Integer.numberOfLeadingZeros(n);
            }
            case UP:
            case CEILING: {
                return 32 - Integer.numberOfLeadingZeros(n - 1);
            }
            case HALF_DOWN:
            case HALF_UP:
            case HALF_EVEN: {
                final int numberOfLeadingZeros = Integer.numberOfLeadingZeros(n);
                return lessThanBranchFree(-1257966797 >>> numberOfLeadingZeros, n) + (31 - numberOfLeadingZeros);
            }
        }
    }
    
    public static int mean(final int n, final int n2) {
        return (n & n2) + ((n ^ n2) >> 1);
    }
    
    public static int mod(int n, final int i) {
        if (i <= 0) {
            throw new ArithmeticException(new StringBuilder(31).append("Modulus ").append(i).append(" must be > 0").toString());
        }
        n %= i;
        if (n >= 0) {
            return n;
        }
        return n + i;
    }
    
    @GwtIncompatible("failing tests")
    public static int pow(int n, int n2) {
        final int n3 = 0;
        MathPreconditions.checkNonNegative("exponent", n2);
        switch (n) {
            default: {
                int n4 = 1;
                while (true) {
                    switch (n2) {
                        default: {
                            int n5;
                            if ((n2 & 0x1) == 0x0) {
                                n5 = 1;
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
                            return n * n4;
                        }
                    }
                }
                break;
            }
            case 0: {
                if (n2 == 0) {
                    return 1;
                }
                return 0;
            }
            case 1: {
                return 1;
            }
            case -1: {
                if ((n2 & 0x1) != 0x0) {
                    return -1;
                }
                return 1;
            }
            case 2: {
                n = n3;
                if (n2 < 32) {
                    n = 1 << n2;
                }
                return n;
            }
            case -2: {
                if (n2 >= 32) {
                    return 0;
                }
                if ((n2 & 0x1) == 0x0) {
                    return 1 << n2;
                }
                return -(1 << n2);
            }
        }
    }
    
    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int sqrt(final int n, final RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", n);
        final int sqrtFloor = sqrtFloor(n);
        switch (roundingMode) {
            default: {
                throw new AssertionError();
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor * sqrtFloor == n);
            }
            case DOWN:
            case FLOOR: {
                return sqrtFloor;
            }
            case UP:
            case CEILING: {
                return sqrtFloor + lessThanBranchFree(sqrtFloor * sqrtFloor, n);
            }
            case HALF_DOWN:
            case HALF_UP:
            case HALF_EVEN: {
                return sqrtFloor + lessThanBranchFree(sqrtFloor * sqrtFloor + sqrtFloor, n);
            }
        }
    }
    
    private static int sqrtFloor(final int n) {
        return (int)Math.sqrt(n);
    }
}
