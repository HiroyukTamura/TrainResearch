// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import javax.annotation.Nullable;
import javax.annotation.CheckReturnValue;
import java.math.BigInteger;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable
{
    public static final UnsignedLong MAX_VALUE;
    public static final UnsignedLong ONE;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO;
    private final long value;
    
    static {
        ZERO = new UnsignedLong(0L);
        ONE = new UnsignedLong(1L);
        MAX_VALUE = new UnsignedLong(-1L);
    }
    
    private UnsignedLong(final long value) {
        this.value = value;
    }
    
    public static UnsignedLong fromLongBits(final long n) {
        return new UnsignedLong(n);
    }
    
    public static UnsignedLong valueOf(final long l) {
        Preconditions.checkArgument(l >= 0L, "value (%s) is outside the range for an unsigned long value", l);
        return fromLongBits(l);
    }
    
    public static UnsignedLong valueOf(final String s) {
        return valueOf(s, 10);
    }
    
    public static UnsignedLong valueOf(final String s, final int n) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(s, n));
    }
    
    public static UnsignedLong valueOf(final BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }
    
    public BigInteger bigIntegerValue() {
        BigInteger bigInteger = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0L) {
            bigInteger = bigInteger.setBit(63);
        }
        return bigInteger;
    }
    
    @Override
    public int compareTo(final UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }
    
    @CheckReturnValue
    public UnsignedLong dividedBy(final UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, Preconditions.checkNotNull(unsignedLong).value));
    }
    
    @Override
    public double doubleValue() {
        double n = (double)(this.value & Long.MAX_VALUE);
        if (this.value < 0L) {
            n += 9.223372036854776E18;
        }
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b = false;
        if (o instanceof UnsignedLong) {
            final UnsignedLong unsignedLong = (UnsignedLong)o;
            b = b;
            if (this.value == unsignedLong.value) {
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public float floatValue() {
        float n = (float)(this.value & Long.MAX_VALUE);
        if (this.value < 0L) {
            n += 9.223372E18f;
        }
        return n;
    }
    
    @Override
    public int hashCode() {
        return Longs.hashCode(this.value);
    }
    
    @Override
    public int intValue() {
        return (int)this.value;
    }
    
    @Override
    public long longValue() {
        return this.value;
    }
    
    public UnsignedLong minus(final UnsignedLong unsignedLong) {
        return fromLongBits(this.value - Preconditions.checkNotNull(unsignedLong).value);
    }
    
    @CheckReturnValue
    public UnsignedLong mod(final UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, Preconditions.checkNotNull(unsignedLong).value));
    }
    
    public UnsignedLong plus(final UnsignedLong unsignedLong) {
        return fromLongBits(Preconditions.checkNotNull(unsignedLong).value + this.value);
    }
    
    @CheckReturnValue
    public UnsignedLong times(final UnsignedLong unsignedLong) {
        return fromLongBits(Preconditions.checkNotNull(unsignedLong).value * this.value);
    }
    
    @Override
    public String toString() {
        return UnsignedLongs.toString(this.value);
    }
    
    public String toString(final int n) {
        return UnsignedLongs.toString(this.value, n);
    }
}
