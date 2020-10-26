// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.math;

import java.math.BigInteger;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.math.RoundingMode;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Booleans;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class DoubleMath
{
    private static final double LN_2;
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18;
    @VisibleForTesting
    static final double[] everySixteenthFactorial;
    
    static {
        LN_2 = Math.log(2.0);
        everySixteenthFactorial = new double[] { 1.0, 2.0922789888E13, 2.631308369336935E35, 1.2413915592536073E61, 1.2688693218588417E89, 7.156945704626381E118, 9.916779348709496E149, 1.974506857221074E182, 3.856204823625804E215, 5.5502938327393044E249, 4.7147236359920616E284 };
    }
    
    private DoubleMath() {
    }
    
    public static double factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double n2 = 1.0;
        for (int i = (n & 0xFFFFFFF0) + 1; i <= n; ++i) {
            n2 *= i;
        }
        return DoubleMath.everySixteenthFactorial[n >> 4] * n2;
    }
    
    public static int fuzzyCompare(final double v, final double v2, final double n) {
        if (fuzzyEquals(v, v2, n)) {
            return 0;
        }
        if (v < v2) {
            return -1;
        }
        if (v > v2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(v), Double.isNaN(v2));
    }
    
    public static boolean fuzzyEquals(final double v, final double v2, final double n) {
        MathPreconditions.checkNonNegative("tolerance", n);
        return Math.copySign(v - v2, 1.0) <= n || v == v2 || (Double.isNaN(v) && Double.isNaN(v2));
    }
    
    @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static boolean isMathematicalInteger(final double d) {
        return DoubleUtils.isFinite(d) && (d == 0.0 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d)) <= Math.getExponent(d));
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    public static boolean isPowerOfTwo(final double n) {
        return n > 0.0 && DoubleUtils.isFinite(n) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(n));
    }
    
    public static double log2(final double a) {
        return Math.log(a) / DoubleMath.LN_2;
    }
    
    @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static int log2(double scaleNormalize, final RoundingMode roundingMode) {
        final boolean b = true;
        boolean b2 = true;
        Preconditions.checkArgument(scaleNormalize > 0.0 && DoubleUtils.isFinite(scaleNormalize), (Object)"x must be positive and finite");
        final int exponent = Math.getExponent(scaleNormalize);
        int n;
        if (!DoubleUtils.isNormal(scaleNormalize)) {
            n = log2(4.503599627370496E15 * scaleNormalize, roundingMode) - 52;
        }
        else {
            int n2 = 0;
            switch (roundingMode) {
                default: {
                    throw new AssertionError();
                }
                case UNNECESSARY: {
                    MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(scaleNormalize));
                }
                case FLOOR: {
                    n2 = 0;
                    break;
                }
                case CEILING: {
                    if (!isPowerOfTwo(scaleNormalize)) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    break;
                }
                case DOWN: {
                    boolean b3;
                    if (exponent < 0) {
                        b3 = true;
                    }
                    else {
                        b3 = false;
                    }
                    if (isPowerOfTwo(scaleNormalize)) {
                        b2 = false;
                    }
                    n2 = ((b3 & b2) ? 1 : 0);
                    break;
                }
                case UP: {
                    boolean b4;
                    if (exponent >= 0) {
                        b4 = true;
                    }
                    else {
                        b4 = false;
                    }
                    boolean b5;
                    if (!isPowerOfTwo(scaleNormalize)) {
                        b5 = b;
                    }
                    else {
                        b5 = false;
                    }
                    n2 = ((b4 & b5) ? 1 : 0);
                    break;
                }
                case HALF_EVEN:
                case HALF_UP:
                case HALF_DOWN: {
                    scaleNormalize = DoubleUtils.scaleNormalize(scaleNormalize);
                    if (scaleNormalize * scaleNormalize > 2.0) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    break;
                }
            }
            n = exponent;
            if (n2 != 0) {
                return exponent + 1;
            }
        }
        return n;
    }
    
    @GwtIncompatible("MeanAccumulator")
    public static double mean(final Iterable<? extends Number> iterable) {
        final MeanAccumulator meanAccumulator = new MeanAccumulator();
        final Iterator<? extends Number> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            meanAccumulator.add(((Number)iterator.next()).doubleValue());
        }
        return meanAccumulator.mean();
    }
    
    @GwtIncompatible("MeanAccumulator")
    public static double mean(final Iterator<? extends Number> iterator) {
        final MeanAccumulator meanAccumulator = new MeanAccumulator();
        while (iterator.hasNext()) {
            meanAccumulator.add(((Number)iterator.next()).doubleValue());
        }
        return meanAccumulator.mean();
    }
    
    @GwtIncompatible("MeanAccumulator")
    public static double mean(final double... array) {
        final MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (int length = array.length, i = 0; i < length; ++i) {
            meanAccumulator.add(array[i]);
        }
        return meanAccumulator.mean();
    }
    
    @GwtIncompatible("MeanAccumulator")
    public static double mean(final int... array) {
        final MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (int length = array.length, i = 0; i < length; ++i) {
            meanAccumulator.add(array[i]);
        }
        return meanAccumulator.mean();
    }
    
    @GwtIncompatible("MeanAccumulator")
    public static double mean(final long... array) {
        final MeanAccumulator meanAccumulator = new MeanAccumulator();
        for (int length = array.length, i = 0; i < length; ++i) {
            meanAccumulator.add((double)array[i]);
        }
        return meanAccumulator.mean();
    }
    
    @GwtIncompatible("#isMathematicalInteger, com.google.common.math.DoubleUtils")
    static double roundIntermediate(final double a, final RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(a)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (roundingMode) {
            default: {
                throw new AssertionError();
            }
            case UNNECESSARY: {
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(a));
            }
            case DOWN: {
                return a;
            }
            case FLOOR: {
                if (a < 0.0 && !isMathematicalInteger(a)) {
                    return a - 1.0;
                }
                return a;
            }
            case CEILING: {
                if (a > 0.0 && !isMathematicalInteger(a)) {
                    return a + 1.0;
                }
                return a;
            }
            case UP: {
                if (!isMathematicalInteger(a)) {
                    return a + Math.copySign(1.0, a);
                }
                return a;
            }
            case HALF_EVEN: {
                return Math.rint(a);
            }
            case HALF_UP: {
                final double rint = Math.rint(a);
                if (Math.abs(a - rint) == 0.5) {
                    return a + Math.copySign(0.5, a);
                }
                return rint;
            }
            case HALF_DOWN: {
                final double rint2 = Math.rint(a);
                if (Math.abs(a - rint2) != 0.5) {
                    return rint2;
                }
                return a;
            }
        }
    }
    
    @GwtIncompatible("#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static BigInteger roundToBigInteger(double roundIntermediate, final RoundingMode roundingMode) {
        boolean b = true;
        roundIntermediate = roundIntermediate(roundIntermediate, roundingMode);
        boolean b2;
        if (-9.223372036854776E18 - roundIntermediate < 1.0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (roundIntermediate >= 9.223372036854776E18) {
            b = false;
        }
        BigInteger bigInteger;
        if (b & b2) {
            bigInteger = BigInteger.valueOf((long)roundIntermediate);
        }
        else {
            bigInteger = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
            if (roundIntermediate < 0.0) {
                return bigInteger.negate();
            }
        }
        return bigInteger;
    }
    
    @GwtIncompatible("#roundIntermediate")
    public static int roundToInt(double roundIntermediate, final RoundingMode roundingMode) {
        boolean b = true;
        roundIntermediate = roundIntermediate(roundIntermediate, roundingMode);
        boolean b2;
        if (roundIntermediate > -2.147483649E9) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (roundIntermediate >= 2.147483648E9) {
            b = false;
        }
        MathPreconditions.checkInRange(b & b2);
        return (int)roundIntermediate;
    }
    
    @GwtIncompatible("#roundIntermediate")
    public static long roundToLong(double roundIntermediate, final RoundingMode roundingMode) {
        boolean b = true;
        roundIntermediate = roundIntermediate(roundIntermediate, roundingMode);
        boolean b2;
        if (-9.223372036854776E18 - roundIntermediate < 1.0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (roundIntermediate >= 9.223372036854776E18) {
            b = false;
        }
        MathPreconditions.checkInRange(b & b2);
        return (long)roundIntermediate;
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    private static final class MeanAccumulator
    {
        private long count;
        private double mean;
        
        private MeanAccumulator() {
            this.count = 0L;
            this.mean = 0.0;
        }
        
        void add(final double n) {
            Preconditions.checkArgument(DoubleUtils.isFinite(n));
            ++this.count;
            this.mean += (n - this.mean) / this.count;
        }
        
        double mean() {
            Preconditions.checkArgument(this.count > 0L, (Object)"Cannot take mean of 0 values");
            return this.mean;
        }
    }
}
