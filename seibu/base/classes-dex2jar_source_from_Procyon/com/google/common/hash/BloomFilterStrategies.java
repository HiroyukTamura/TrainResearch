// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.hash;

import java.util.Arrays;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.math.LongMath;
import java.math.RoundingMode;
import com.google.common.primitives.Longs;

enum BloomFilterStrategies implements Strategy
{
    MURMUR128_MITZ_32 {
        @Override
        public <T> boolean mightContain(final T t, final Funnel<? super T> funnel, final int n, final BitArray bitArray) {
            final long bitSize = bitArray.bitSize();
            final long long1 = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            final int n2 = (int)long1;
            final int n3 = (int)(long1 >>> 32);
            for (int i = 1; i <= n; ++i) {
                final int n4 = n2 + i * n3;
                int n5;
                if ((n5 = n4) < 0) {
                    n5 = ~n4;
                }
                if (!bitArray.get(n5 % bitSize)) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public <T> boolean put(final T t, final Funnel<? super T> funnel, final int n, final BitArray bitArray) {
            final long bitSize = bitArray.bitSize();
            final long long1 = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            final int n2 = (int)long1;
            final int n3 = (int)(long1 >>> 32);
            boolean b = false;
            for (int i = 1; i <= n; ++i) {
                final int n4 = n2 + i * n3;
                int n5;
                if ((n5 = n4) < 0) {
                    n5 = ~n4;
                }
                b |= bitArray.set(n5 % bitSize);
            }
            return b;
        }
    }, 
    MURMUR128_MITZ_64 {
        private long lowerEight(final byte[] array) {
            return Longs.fromBytes(array[7], array[6], array[5], array[4], array[3], array[2], array[1], array[0]);
        }
        
        private long upperEight(final byte[] array) {
            return Longs.fromBytes(array[15], array[14], array[13], array[12], array[11], array[10], array[9], array[8]);
        }
        
        @Override
        public <T> boolean mightContain(final T t, final Funnel<? super T> funnel, final int n, final BitArray bitArray) {
            final long bitSize = bitArray.bitSize();
            final byte[] bytesInternal = Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = this.lowerEight(bytesInternal);
            final long upperEight = this.upperEight(bytesInternal);
            for (int i = 0; i < n; ++i) {
                if (!bitArray.get((Long.MAX_VALUE & lowerEight) % bitSize)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }
        
        @Override
        public <T> boolean put(final T t, final Funnel<? super T> funnel, final int n, final BitArray bitArray) {
            final long bitSize = bitArray.bitSize();
            final byte[] bytesInternal = Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = this.lowerEight(bytesInternal);
            final long upperEight = this.upperEight(bytesInternal);
            boolean b = false;
            for (int i = 0; i < n; ++i) {
                b |= bitArray.set((Long.MAX_VALUE & lowerEight) % bitSize);
                lowerEight += upperEight;
            }
            return b;
        }
    };
    
    static final class BitArray
    {
        long bitCount;
        final long[] data;
        
        BitArray(final long n) {
            this(new long[Ints.checkedCast(LongMath.divide(n, 64L, RoundingMode.CEILING))]);
        }
        
        BitArray(final long[] data) {
            Preconditions.checkArgument(data.length > 0, (Object)"data length is zero!");
            this.data = data;
            long bitCount = 0L;
            for (int length = data.length, i = 0; i < length; ++i) {
                bitCount += Long.bitCount(data[i]);
            }
            this.bitCount = bitCount;
        }
        
        long bitCount() {
            return this.bitCount;
        }
        
        long bitSize() {
            return this.data.length * 64L;
        }
        
        BitArray copy() {
            return new BitArray(this.data.clone());
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof BitArray && Arrays.equals(this.data, ((BitArray)o).data);
        }
        
        boolean get(final long n) {
            return (this.data[(int)(n >>> 6)] & 1L << (int)n) != 0x0L;
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(this.data);
        }
        
        void putAll(final BitArray bitArray) {
            Preconditions.checkArgument(this.data.length == bitArray.data.length, "BitArrays must be of equal length (%s != %s)", this.data.length, bitArray.data.length);
            this.bitCount = 0L;
            for (int i = 0; i < this.data.length; ++i) {
                final long[] data = this.data;
                data[i] |= bitArray.data[i];
                this.bitCount += Long.bitCount(this.data[i]);
            }
        }
        
        boolean set(final long n) {
            if (!this.get(n)) {
                final long[] data = this.data;
                final int n2 = (int)(n >>> 6);
                data[n2] |= 1L << (int)n;
                ++this.bitCount;
                return true;
            }
            return false;
        }
    }
}
