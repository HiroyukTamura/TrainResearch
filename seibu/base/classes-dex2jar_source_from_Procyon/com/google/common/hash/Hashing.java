// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.hash;

import javax.annotation.Nullable;
import com.google.common.annotations.VisibleForTesting;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.Iterator;
import java.util.zip.Checksum;
import com.google.common.base.Supplier;
import com.google.common.base.Preconditions;
import com.google.common.annotations.Beta;

@Beta
public final class Hashing
{
    private static final int GOOD_FAST_HASH_SEED;
    
    static {
        GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
    }
    
    private Hashing() {
    }
    
    public static HashFunction adler32() {
        return Adler32Holder.ADLER_32;
    }
    
    static int checkPositiveAndMakeMultipleOf32(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"Number of bits must be positive");
        return n + 31 & 0xFFFFFFE0;
    }
    
    private static HashFunction checksumHashFunction(final ChecksumType checksumType, final String s) {
        return new ChecksumHashFunction(checksumType, checksumType.bits, s);
    }
    
    public static HashCode combineOrdered(final Iterable<HashCode> iterable) {
        final Iterator<HashCode> iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), (Object)"Must be at least 1 hash code to combine.");
        final byte[] array = new byte[iterator.next().bits() / 8];
        final Iterator<HashCode> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            final byte[] bytes = iterator2.next().asBytes();
            Preconditions.checkArgument(bytes.length == array.length, (Object)"All hashcodes must have the same bit length.");
            for (int i = 0; i < bytes.length; ++i) {
                array[i] = (byte)(array[i] * 37 ^ bytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(array);
    }
    
    public static HashCode combineUnordered(final Iterable<HashCode> iterable) {
        final Iterator<HashCode> iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), (Object)"Must be at least 1 hash code to combine.");
        final byte[] array = new byte[iterator.next().bits() / 8];
        final Iterator<HashCode> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            final byte[] bytes = iterator2.next().asBytes();
            Preconditions.checkArgument(bytes.length == array.length, (Object)"All hashcodes must have the same bit length.");
            for (int i = 0; i < bytes.length; ++i) {
                array[i] += bytes[i];
            }
        }
        return HashCode.fromBytesNoCopy(array);
    }
    
    public static int consistentHash(final long n, final int i) {
        Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        final LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(n);
        int n2 = 0;
        while (true) {
            final int n3 = (int)((n2 + 1) / linearCongruentialGenerator.nextDouble());
            if (n3 < 0 || n3 >= i) {
                break;
            }
            n2 = n3;
        }
        return n2;
    }
    
    public static int consistentHash(final HashCode hashCode, final int n) {
        return consistentHash(hashCode.padToLong(), n);
    }
    
    public static HashFunction crc32() {
        return Crc32Holder.CRC_32;
    }
    
    public static HashFunction crc32c() {
        return Crc32cHolder.CRC_32_C;
    }
    
    public static HashFunction goodFastHash(int i) {
        i = checkPositiveAndMakeMultipleOf32(i);
        if (i == 32) {
            return Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
        }
        if (i <= 128) {
            return Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        }
        final int n = (i + 127) / 128;
        final HashFunction[] array = new HashFunction[n];
        array[0] = Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        int good_FAST_HASH_SEED = Hashing.GOOD_FAST_HASH_SEED;
        for (i = 1; i < n; ++i) {
            good_FAST_HASH_SEED += 1500450271;
            array[i] = murmur3_128(good_FAST_HASH_SEED);
        }
        return new ConcatenatedHashFunction(array);
    }
    
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }
    
    public static HashFunction murmur3_128() {
        return Murmur3_128Holder.MURMUR3_128;
    }
    
    public static HashFunction murmur3_128(final int n) {
        return new Murmur3_128HashFunction(n);
    }
    
    public static HashFunction murmur3_32() {
        return Murmur3_32Holder.MURMUR3_32;
    }
    
    public static HashFunction murmur3_32(final int n) {
        return new Murmur3_32HashFunction(n);
    }
    
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }
    
    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }
    
    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }
    
    public static HashFunction sipHash24() {
        return SipHash24Holder.SIP_HASH_24;
    }
    
    public static HashFunction sipHash24(final long n, final long n2) {
        return new SipHashFunction(2, 4, n, n2);
    }
    
    private static class Adler32Holder
    {
        static final HashFunction ADLER_32;
        
        static {
            ADLER_32 = checksumHashFunction(ChecksumType.ADLER_32, "Hashing.adler32()");
        }
    }
    
    enum ChecksumType implements Supplier<Checksum>
    {
        ADLER_32(32) {
            @Override
            public Checksum get() {
                return new Adler32();
            }
        }, 
        CRC_32(32) {
            @Override
            public Checksum get() {
                return new CRC32();
            }
        };
        
        private final int bits;
        
        private ChecksumType(final int bits) {
            this.bits = bits;
        }
        
        @Override
        public abstract Checksum get();
    }
    
    @VisibleForTesting
    static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction
    {
        private final int bits;
        
        ConcatenatedHashFunction(final HashFunction... array) {
            super(array);
            int bits = 0;
            for (int length = array.length, i = 0; i < length; ++i) {
                bits += array[i].bits();
            }
            this.bits = bits;
        }
        
        @Override
        public int bits() {
            return this.bits;
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            if (o instanceof ConcatenatedHashFunction) {
                final ConcatenatedHashFunction concatenatedHashFunction = (ConcatenatedHashFunction)o;
                if (this.bits == concatenatedHashFunction.bits && this.functions.length == concatenatedHashFunction.functions.length) {
                    for (int i = 0; i < this.functions.length; ++i) {
                        if (!this.functions[i].equals(concatenatedHashFunction.functions[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            int bits = this.bits;
            final HashFunction[] functions = this.functions;
            for (int length = functions.length, i = 0; i < length; ++i) {
                bits ^= functions[i].hashCode();
            }
            return bits;
        }
        
        @Override
        HashCode makeHash(final Hasher[] array) {
            final byte[] array2 = new byte[this.bits / 8];
            int n = 0;
            for (int length = array.length, i = 0; i < length; ++i) {
                final HashCode hash = array[i].hash();
                n += hash.writeBytesTo(array2, n, hash.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(array2);
        }
    }
    
    private static class Crc32Holder
    {
        static final HashFunction CRC_32;
        
        static {
            CRC_32 = checksumHashFunction(ChecksumType.CRC_32, "Hashing.crc32()");
        }
    }
    
    private static final class Crc32cHolder
    {
        static final HashFunction CRC_32_C;
        
        static {
            CRC_32_C = new Crc32cHashFunction();
        }
    }
    
    private static final class LinearCongruentialGenerator
    {
        private long state;
        
        public LinearCongruentialGenerator(final long state) {
            this.state = state;
        }
        
        public double nextDouble() {
            this.state = 2862933555777941757L * this.state + 1L;
            return ((int)(this.state >>> 33) + 1) / 2.147483648E9;
        }
    }
    
    private static class Md5Holder
    {
        static final HashFunction MD5;
        
        static {
            MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
        }
    }
    
    private static class Murmur3_128Holder
    {
        static final HashFunction GOOD_FAST_HASH_FUNCTION_128;
        static final HashFunction MURMUR3_128;
        
        static {
            MURMUR3_128 = new Murmur3_128HashFunction(0);
            GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.GOOD_FAST_HASH_SEED);
        }
    }
    
    private static class Murmur3_32Holder
    {
        static final HashFunction GOOD_FAST_HASH_FUNCTION_32;
        static final HashFunction MURMUR3_32;
        
        static {
            MURMUR3_32 = new Murmur3_32HashFunction(0);
            GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.GOOD_FAST_HASH_SEED);
        }
    }
    
    private static class Sha1Holder
    {
        static final HashFunction SHA_1;
        
        static {
            SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
        }
    }
    
    private static class Sha256Holder
    {
        static final HashFunction SHA_256;
        
        static {
            SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
        }
    }
    
    private static class Sha512Holder
    {
        static final HashFunction SHA_512;
        
        static {
            SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
        }
    }
    
    private static class SipHash24Holder
    {
        static final HashFunction SIP_HASH_24;
        
        static {
            SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
        }
    }
}
