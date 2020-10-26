// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.hash;

import com.google.common.primitives.SignedBytes;
import java.io.DataOutputStream;
import java.io.OutputStream;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import java.io.IOException;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.InputStream;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.annotations.Beta;
import java.io.Serializable;
import com.google.common.base.Predicate;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable
{
    private static final Strategy DEFAULT_STRATEGY;
    private final BloomFilterStrategies.BitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;
    
    static {
        DEFAULT_STRATEGY = (Strategy)BloomFilterStrategies.MURMUR128_MITZ_64;
    }
    
    private BloomFilter(final BloomFilterStrategies.BitArray bitArray, final int numHashFunctions, final Funnel<? super T> funnel, final Strategy strategy) {
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", numHashFunctions);
        Preconditions.checkArgument(numHashFunctions <= 255, "numHashFunctions (%s) must be <= 255", numHashFunctions);
        this.bits = Preconditions.checkNotNull(bitArray);
        this.numHashFunctions = numHashFunctions;
        this.funnel = Preconditions.checkNotNull(funnel);
        this.strategy = Preconditions.checkNotNull(strategy);
    }
    
    public static <T> BloomFilter<T> create(final Funnel<? super T> funnel, final int n) {
        return create(funnel, n, 0.03);
    }
    
    public static <T> BloomFilter<T> create(final Funnel<? super T> funnel, final int n, final double n2) {
        return create(funnel, n, n2, BloomFilter.DEFAULT_STRATEGY);
    }
    
    @VisibleForTesting
    static <T> BloomFilter<T> create(final Funnel<? super T> funnel, int optimalNumOfHashFunctions, final double n, final Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Label_0141: {
            if (optimalNumOfHashFunctions < 0) {
                break Label_0141;
            }
            boolean b = true;
        Label_0039_Outer:
            while (true) {
                Preconditions.checkArgument(b, "Expected insertions (%s) must be >= 0", optimalNumOfHashFunctions);
                Label_0147: {
                    if (n <= 0.0) {
                        break Label_0147;
                    }
                    boolean b2 = true;
                Label_0066_Outer:
                    while (true) {
                        Preconditions.checkArgument(b2, "False positive probability (%s) must be > 0.0", n);
                        Label_0153: {
                            if (n >= 1.0) {
                                break Label_0153;
                            }
                            boolean b3 = true;
                            while (true) {
                                Preconditions.checkArgument(b3, "False positive probability (%s) must be < 1.0", n);
                                Preconditions.checkNotNull(strategy);
                                int n2 = optimalNumOfHashFunctions;
                                if (optimalNumOfHashFunctions == 0) {
                                    n2 = 1;
                                }
                                final long optimalNumOfBits = optimalNumOfBits(n2, n);
                                optimalNumOfHashFunctions = optimalNumOfHashFunctions(n2, optimalNumOfBits);
                                try {
                                    return new BloomFilter<T>(new BloomFilterStrategies.BitArray(optimalNumOfBits), optimalNumOfHashFunctions, (Funnel<? super Object>)funnel, strategy);
                                    b3 = false;
                                    continue;
                                    b = false;
                                    continue Label_0039_Outer;
                                    b2 = false;
                                    continue Label_0066_Outer;
                                }
                                catch (IllegalArgumentException cause) {
                                    throw new IllegalArgumentException(new StringBuilder(57).append("Could not create BloomFilter of ").append(optimalNumOfBits).append(" bits").toString(), cause);
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @VisibleForTesting
    static long optimalNumOfBits(final long n, final double n2) {
        double a = n2;
        if (n2 == 0.0) {
            a = Double.MIN_VALUE;
        }
        return (long)(-n * Math.log(a) / (Math.log(2.0) * Math.log(2.0)));
    }
    
    @VisibleForTesting
    static int optimalNumOfHashFunctions(final long n, final long n2) {
        return Math.max(1, (int)Math.round(n2 / (double)n * Math.log(2.0)));
    }
    
    public static <T> BloomFilter<T> readFrom(final InputStream in, final Funnel<T> funnel) throws IOException {
        Preconditions.checkNotNull(in, (Object)"InputStream");
        Preconditions.checkNotNull(funnel, (Object)"Funnel");
        final int n = -1;
        final int n2 = -1;
        int int1;
        final int n3 = int1 = -1;
        int i = n2;
        int j = n;
        try {
            final DataInputStream dataInputStream = new DataInputStream(in);
            int1 = n3;
            i = n2;
            j = n;
            final byte byte1 = dataInputStream.readByte();
            int1 = n3;
            i = n2;
            j = byte1;
            final int int2 = UnsignedBytes.toInt(dataInputStream.readByte());
            int1 = n3;
            i = int2;
            j = byte1;
            final int n4 = int1 = dataInputStream.readInt();
            i = int2;
            j = byte1;
            final BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[byte1];
            int1 = n4;
            i = int2;
            j = byte1;
            final long[] array = new long[n4];
            int n5 = 0;
            while (true) {
                int1 = n4;
                i = int2;
                j = byte1;
                if (n5 >= array.length) {
                    break;
                }
                int1 = n4;
                i = int2;
                j = byte1;
                array[n5] = dataInputStream.readLong();
                ++n5;
            }
            int1 = n4;
            i = int2;
            j = byte1;
            return new BloomFilter<T>(new BloomFilterStrategies.BitArray(array), int2, (Funnel<? super Object>)funnel, (Strategy)bloomFilterStrategies);
        }
        catch (RuntimeException cause) {
            final String value = String.valueOf(String.valueOf("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: "));
            final IOException ex = new IOException(new StringBuilder(value.length() + 65).append(value).append(j).append(" numHashFunctions: ").append(i).append(" dataLength: ").append(int1).toString());
            ex.initCause(cause);
            throw ex;
        }
    }
    
    private Object writeReplace() {
        return new SerialForm((BloomFilter<Object>)this);
    }
    
    @Deprecated
    @Override
    public boolean apply(final T t) {
        return this.mightContain(t);
    }
    
    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }
    
    public BloomFilter<T> copy() {
        return new BloomFilter<T>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (!(o instanceof BloomFilter)) {
                return false;
            }
            final BloomFilter bloomFilter = (BloomFilter)o;
            if (this.numHashFunctions != bloomFilter.numHashFunctions || !this.funnel.equals(bloomFilter.funnel) || !this.bits.equals(bloomFilter.bits) || !this.strategy.equals(bloomFilter.strategy)) {
                return false;
            }
        }
        return true;
    }
    
    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / (double)this.bitSize(), this.numHashFunctions);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.numHashFunctions, this.funnel, this.strategy, this.bits);
    }
    
    public boolean isCompatible(final BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && this.bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }
    
    public boolean mightContain(final T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }
    
    public boolean put(final T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }
    
    public void putAll(final BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, (Object)"Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.checkArgument(this.bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", this.bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }
    
    public void writeTo(final OutputStream out) throws IOException {
        final DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length);
        final long[] data = this.bits.data;
        for (int length = data.length, i = 0; i < length; ++i) {
            dataOutputStream.writeLong(data[i]);
        }
    }
    
    private static class SerialForm<T> implements Serializable
    {
        private static final long serialVersionUID = 1L;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;
        
        SerialForm(final BloomFilter<T> bloomFilter) {
            this.data = ((BloomFilter<Object>)bloomFilter).bits.data;
            this.numHashFunctions = ((BloomFilter<Object>)bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter<Object>)bloomFilter).funnel;
            this.strategy = ((BloomFilter<Object>)bloomFilter).strategy;
        }
        
        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }
    
    interface Strategy extends Serializable
    {
         <T> boolean mightContain(final T p0, final Funnel<? super T> p1, final int p2, final BloomFilterStrategies.BitArray p3);
        
        int ordinal();
        
         <T> boolean put(final T p0, final Funnel<? super T> p1, final int p2, final BloomFilterStrategies.BitArray p3);
    }
}
