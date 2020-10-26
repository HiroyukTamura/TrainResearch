// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import java.util.List;
import java.util.ArrayList;
import com.google.common.annotations.GwtIncompatible;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.google.common.base.Preconditions;
import com.google.common.annotations.VisibleForTesting;
import java.math.BigInteger;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class BigIntegerMath
{
    private static final double LN_10;
    private static final double LN_2;
    @VisibleForTesting
    static final BigInteger SQRT2_PRECOMPUTED_BITS;
    @VisibleForTesting
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
    
    static {
        SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
        LN_10 = Math.log(10.0);
        LN_2 = Math.log(2.0);
    }
    
    private BigIntegerMath() {
    }
    
    public static BigInteger binomial(final int i, int log2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", log2);
        Preconditions.checkArgument(log2 <= i, "k (%s) > n (%s)", log2, i);
        int n = log2;
        if (log2 > i >> 1) {
            n = i - log2;
        }
        if (n < LongMath.biggestBinomials.length && i <= LongMath.biggestBinomials[n]) {
            return BigInteger.valueOf(LongMath.binomial(i, n));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long n2 = i;
        long n3 = 1L;
        final int n4 = log2 = LongMath.log2(i, RoundingMode.CEILING);
        for (int j = 1; j < n; ++j) {
            final int n5 = i - j;
            final int n6 = j + 1;
            if (log2 + n4 >= 63) {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(n2)).divide(BigInteger.valueOf(n3));
                n2 = n5;
                n3 = n6;
                log2 = n4;
            }
            else {
                n2 *= n5;
                n3 *= n6;
                log2 += n4;
            }
        }
        return bigInteger.multiply(BigInteger.valueOf(n2)).divide(BigInteger.valueOf(n3));
    }
    
    @GwtIncompatible("TODO")
    public static BigInteger divide(final BigInteger val, final BigInteger val2, final RoundingMode roundingMode) {
        return new BigDecimal(val).divide(new BigDecimal(val2), 0, roundingMode).toBigIntegerExact();
    }
    
    public static BigInteger factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n < LongMath.factorials.length) {
            return BigInteger.valueOf(LongMath.factorials[n]);
        }
        final ArrayList<BigInteger> list = new ArrayList<BigInteger>(IntMath.divide(IntMath.log2(n, RoundingMode.CEILING) * n, 64, RoundingMode.CEILING));
        final int length = LongMath.factorials.length;
        final long i = LongMath.factorials[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(i);
        long n2 = i >> numberOfTrailingZeros;
        int n3 = LongMath.log2(n2, RoundingMode.FLOOR) + 1;
        int n4 = LongMath.log2(length, RoundingMode.FLOOR) + 1;
        int n5 = 1 << n4 - 1;
        int n6;
        int n7;
        for (long j = length; j <= n; ++j, n4 = n6, n5 = n7) {
            n6 = n4;
            n7 = n5;
            if (((long)n5 & j) != 0x0L) {
                n7 = n5 << 1;
                n6 = n4 + 1;
            }
            final int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j);
            numberOfTrailingZeros += numberOfTrailingZeros2;
            long n8 = n2;
            if (n6 - numberOfTrailingZeros2 + n3 >= 64) {
                list.add(BigInteger.valueOf(n2));
                n8 = 1L;
            }
            n2 = n8 * (j >> numberOfTrailingZeros2);
            n3 = LongMath.log2(n2, RoundingMode.FLOOR) + 1;
        }
        if (n2 > 1L) {
            list.add(BigInteger.valueOf(n2));
        }
        return listProduct(list).shiftLeft(numberOfTrailingZeros);
    }
    
    @GwtIncompatible("TODO")
    static boolean fitsInLong(final BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }
    
    public static boolean isPowerOfTwo(final BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }
    
    static BigInteger listProduct(final List<BigInteger> list) {
        return listProduct(list, 0, list.size());
    }
    
    static BigInteger listProduct(final List<BigInteger> list, final int n, final int n2) {
        switch (n2 - n) {
            default: {
                final int n3 = n2 + n >>> 1;
                return listProduct(list, n, n3).multiply(listProduct(list, n3, n2));
            }
            case 0: {
                return BigInteger.ONE;
            }
            case 1: {
                return list.get(n);
            }
            case 2: {
                return list.get(n).multiply(list.get(n + 1));
            }
            case 3: {
                return list.get(n).multiply(list.get(n + 1)).multiply(list.get(n + 2));
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static int log10(final BigInteger x, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", x);
        int log10;
        if (fitsInLong(x)) {
            log10 = LongMath.log10(x.longValue(), roundingMode);
        }
        else {
            int exponent = (int)(log2(x, RoundingMode.FLOOR) * BigIntegerMath.LN_2 / BigIntegerMath.LN_10);
            BigInteger pow = BigInteger.TEN.pow(exponent);
            int compareTo = pow.compareTo(x);
            int i;
            int n;
            if (compareTo > 0) {
                BigInteger divide;
                do {
                    n = exponent - 1;
                    divide = pow.divide(BigInteger.TEN);
                    i = divide.compareTo(x);
                    exponent = n;
                    pow = divide;
                } while (i > 0);
                pow = divide;
            }
            else {
                BigInteger multiply = BigInteger.TEN.multiply(pow);
                int compareTo2 = multiply.compareTo(x);
                while (true) {
                    i = compareTo;
                    n = exponent;
                    if (compareTo2 > 0) {
                        break;
                    }
                    ++exponent;
                    final BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                    final int compareTo3 = multiply2.compareTo(x);
                    compareTo = compareTo2;
                    pow = multiply;
                    compareTo2 = compareTo3;
                    multiply = multiply2;
                }
            }
            log10 = n;
            switch (roundingMode) {
                case DOWN:
                case FLOOR: {
                    break;
                }
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    MathPreconditions.checkRoundingUnnecessary(i == 0);
                    return n;
                }
                case UP:
                case CEILING: {
                    log10 = n;
                    if (!pow.equals(x)) {
                        return n + 1;
                    }
                    break;
                }
                case HALF_DOWN:
                case HALF_UP:
                case HALF_EVEN: {
                    log10 = n;
                    if (x.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) > 0) {
                        return n + 1;
                    }
                    break;
                }
            }
        }
        return log10;
    }
    
    public static int log2(final BigInteger bigInteger, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", Preconditions.checkNotNull(bigInteger));
        final int n = bigInteger.bitLength() - 1;
        switch (roundingMode) {
            default: {
                throw new AssertionError();
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(bigInteger));
            }
            case DOWN:
            case FLOOR: {
                return n;
            }
            case UP:
            case CEILING: {
                if (!isPowerOfTwo(bigInteger)) {
                    return n + 1;
                }
                return n;
            }
            case HALF_DOWN:
            case HALF_UP:
            case HALF_EVEN: {
                if (n < 256) {
                    if (bigInteger.compareTo(BigIntegerMath.SQRT2_PRECOMPUTED_BITS.shiftRight(256 - n)) > 0) {
                        return n + 1;
                    }
                    return n;
                }
                else {
                    if (bigInteger.pow(2).bitLength() - 1 >= n * 2 + 1) {
                        return n + 1;
                    }
                    return n;
                }
                break;
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static BigInteger sqrt(final BigInteger val, final RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", val);
        BigInteger bigInteger;
        if (fitsInLong(val)) {
            bigInteger = BigInteger.valueOf(LongMath.sqrt(val.longValue(), roundingMode));
        }
        else {
            final BigInteger val2 = bigInteger = sqrtFloor(val);
            switch (roundingMode) {
                case DOWN:
                case FLOOR: {
                    break;
                }
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    MathPreconditions.checkRoundingUnnecessary(val2.pow(2).equals(val));
                    return val2;
                }
                case UP:
                case CEILING: {
                    final int intValue = val2.intValue();
                    int n;
                    if (intValue * intValue == val.intValue() && val2.pow(2).equals(val)) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    bigInteger = val2;
                    if (n == 0) {
                        return val2.add(BigInteger.ONE);
                    }
                    break;
                }
                case HALF_DOWN:
                case HALF_UP:
                case HALF_EVEN: {
                    bigInteger = val2;
                    if (val2.pow(2).add(val2).compareTo(val) < 0) {
                        return val2.add(BigInteger.ONE);
                    }
                    break;
                }
            }
        }
        return bigInteger;
    }
    
    @GwtIncompatible("TODO")
    private static BigInteger sqrtApproxWithDoubles(final BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(bigInteger)), RoundingMode.HALF_EVEN);
    }
    
    @GwtIncompatible("TODO")
    private static BigInteger sqrtFloor(final BigInteger bigInteger) {
        final int log2 = log2(bigInteger, RoundingMode.FLOOR);
        BigInteger val;
        if (log2 < 1023) {
            val = sqrtApproxWithDoubles(bigInteger);
        }
        else {
            final int n = log2 - 52 & 0xFFFFFFFE;
            val = sqrtApproxWithDoubles(bigInteger.shiftRight(n)).shiftLeft(n >> 1);
        }
        BigInteger bigInteger2;
        if (val.equals(bigInteger2 = val.add(bigInteger.divide(val)).shiftRight(1))) {
            return val;
        }
        BigInteger bigInteger3;
        do {
            bigInteger3 = bigInteger2;
        } while ((bigInteger2 = bigInteger3.add(bigInteger.divide(bigInteger3)).shiftRight(1)).compareTo(bigInteger3) < 0);
        return bigInteger3;
    }
}
