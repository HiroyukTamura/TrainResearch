// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable>
{
    protected DiscreteDomain() {
    }
    
    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.INSTANCE;
    }
    
    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.INSTANCE;
    }
    
    public static DiscreteDomain<Long> longs() {
        return LongDomain.INSTANCE;
    }
    
    public abstract long distance(final C p0, final C p1);
    
    public C maxValue() {
        throw new NoSuchElementException();
    }
    
    public C minValue() {
        throw new NoSuchElementException();
    }
    
    public abstract C next(final C p0);
    
    public abstract C previous(final C p0);
    
    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable
    {
        private static final BigIntegerDomain INSTANCE;
        private static final BigInteger MAX_LONG;
        private static final BigInteger MIN_LONG;
        private static final long serialVersionUID = 0L;
        
        static {
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }
        
        private Object readResolve() {
            return BigIntegerDomain.INSTANCE;
        }
        
        @Override
        public long distance(final BigInteger val, final BigInteger bigInteger) {
            return bigInteger.subtract(val).max(BigIntegerDomain.MIN_LONG).min(BigIntegerDomain.MAX_LONG).longValue();
        }
        
        @Override
        public BigInteger next(final BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }
        
        @Override
        public BigInteger previous(final BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }
        
        @Override
        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }
    
    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable
    {
        private static final IntegerDomain INSTANCE;
        private static final long serialVersionUID = 0L;
        
        static {
            INSTANCE = new IntegerDomain();
        }
        
        private Object readResolve() {
            return IntegerDomain.INSTANCE;
        }
        
        @Override
        public long distance(final Integer n, final Integer n2) {
            return n2 - (long)n;
        }
        
        @Override
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }
        
        @Override
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }
        
        @Override
        public Integer next(final Integer n) {
            final int intValue = n;
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return intValue + 1;
        }
        
        @Override
        public Integer previous(final Integer n) {
            final int intValue = n;
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return intValue - 1;
        }
        
        @Override
        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }
    
    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable
    {
        private static final LongDomain INSTANCE;
        private static final long serialVersionUID = 0L;
        
        static {
            INSTANCE = new LongDomain();
        }
        
        private Object readResolve() {
            return LongDomain.INSTANCE;
        }
        
        @Override
        public long distance(final Long n, final Long n2) {
            final long n3 = n2 - n;
            long n4;
            if (n2 > n && n3 < 0L) {
                n4 = Long.MAX_VALUE;
            }
            else {
                n4 = n3;
                if (n2 < n) {
                    n4 = n3;
                    if (n3 > 0L) {
                        return Long.MIN_VALUE;
                    }
                }
            }
            return n4;
        }
        
        @Override
        public Long maxValue() {
            return Long.MAX_VALUE;
        }
        
        @Override
        public Long minValue() {
            return Long.MIN_VALUE;
        }
        
        @Override
        public Long next(final Long n) {
            final long longValue = n;
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return 1L + longValue;
        }
        
        @Override
        public Long previous(final Long n) {
            final long longValue = n;
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return longValue - 1L;
        }
        
        @Override
        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }
}
