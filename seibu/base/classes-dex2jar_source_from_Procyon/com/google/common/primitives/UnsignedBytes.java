// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.security.PrivilegedActionException;
import java.security.AccessController;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.nio.ByteOrder;
import sun.misc.Unsafe;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.util.Comparator;
import com.google.common.base.Preconditions;

public final class UnsignedBytes
{
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;
    
    private UnsignedBytes() {
    }
    
    public static byte checkedCast(final long lng) {
        if (lng >> 8 != 0L) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(lng).toString());
        }
        return (byte)lng;
    }
    
    public static int compare(final byte b, final byte b2) {
        return toInt(b) - toInt(b2);
    }
    
    public static String join(final String str, final byte... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * (str.length() + 3));
        sb.append(toInt(array[0]));
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(toString(array[i]));
        }
        return sb.toString();
    }
    
    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }
    
    @VisibleForTesting
    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return PureJavaComparator.INSTANCE;
    }
    
    public static byte max(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        int int1 = toInt(array[0]);
        int n;
        for (int i = 1; i < array.length; ++i, int1 = n) {
            final int int2 = toInt(array[i]);
            if (int2 > (n = int1)) {
                n = int2;
            }
        }
        return (byte)int1;
    }
    
    public static byte min(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        int int1 = toInt(array[0]);
        int n;
        for (int i = 1; i < array.length; ++i, int1 = n) {
            final int int2 = toInt(array[i]);
            if (int2 < (n = int1)) {
                n = int2;
            }
        }
        return (byte)int1;
    }
    
    @Beta
    public static byte parseUnsignedByte(final String s) {
        return parseUnsignedByte(s, 10);
    }
    
    @Beta
    public static byte parseUnsignedByte(final String s, int int1) {
        int1 = Integer.parseInt(Preconditions.checkNotNull(s), int1);
        if (int1 >> 8 == 0) {
            return (byte)int1;
        }
        throw new NumberFormatException(new StringBuilder(25).append("out of range: ").append(int1).toString());
    }
    
    public static byte saturatedCast(final long n) {
        if (n > toInt((byte)(-1))) {
            return -1;
        }
        if (n < 0L) {
            return 0;
        }
        return (byte)n;
    }
    
    public static int toInt(final byte b) {
        return b & 0xFF;
    }
    
    @Beta
    public static String toString(final byte b) {
        return toString(b, 10);
    }
    
    @Beta
    public static String toString(final byte b, final int n) {
        Preconditions.checkArgument(n >= 2 && n <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n);
        return Integer.toString(toInt(b), n);
    }
    
    @VisibleForTesting
    static class LexicographicalComparatorHolder
    {
        static final Comparator<byte[]> BEST_COMPARATOR;
        static final String UNSAFE_COMPARATOR_NAME;
        
        static {
            UNSAFE_COMPARATOR_NAME = String.valueOf(LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
            BEST_COMPARATOR = getBestComparator();
        }
        
        static Comparator<byte[]> getBestComparator() {
            try {
                return (Comparator<byte[]>)Class.forName(LexicographicalComparatorHolder.UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
            }
            catch (Throwable t) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
        
        enum PureJavaComparator implements Comparator<byte[]>
        {
            INSTANCE;
            
            @Override
            public int compare(final byte[] array, final byte[] array2) {
                for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                    final int compare = UnsignedBytes.compare(array[i], array2[i]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return array.length - array2.length;
            }
        }
        
        @VisibleForTesting
        enum UnsafeComparator implements Comparator<byte[]>
        {
            static final boolean BIG_ENDIAN;
            static final int BYTE_ARRAY_BASE_OFFSET;
            
            INSTANCE;
            
            static final Unsafe theUnsafe;
            
            static {
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                theUnsafe = getUnsafe();
                BYTE_ARRAY_BASE_OFFSET = UnsafeComparator.theUnsafe.arrayBaseOffset(byte[].class);
                if (UnsafeComparator.theUnsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new AssertionError();
                }
            }
            
            private static Unsafe getUnsafe() {
                try {
                    return Unsafe.getUnsafe();
                }
                catch (SecurityException ex2) {
                    try {
                        return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new PrivilegedExceptionAction<Unsafe>() {
                            @Override
                            public Unsafe run() throws Exception {
                                final Field[] declaredFields = Unsafe.class.getDeclaredFields();
                                for (int length = declaredFields.length, i = 0; i < length; ++i) {
                                    final Field field = declaredFields[i];
                                    field.setAccessible(true);
                                    final Object value = field.get(null);
                                    if (Unsafe.class.isInstance(value)) {
                                        return Unsafe.class.cast(value);
                                    }
                                }
                                throw new NoSuchFieldError("the Unsafe");
                            }
                        });
                    }
                    catch (PrivilegedActionException ex) {
                        throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
                    }
                }
            }
            
            @Override
            public int compare(final byte[] o, final byte[] o2) {
                final int min = Math.min(o.length, o2.length);
                final int n = min / 8;
                int i = 0;
                while (i < n * 8) {
                    final long long1 = UnsafeComparator.theUnsafe.getLong(o, UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + (long)i);
                    final long long2 = UnsafeComparator.theUnsafe.getLong(o2, UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + (long)i);
                    if (long1 != long2) {
                        if (UnsafeComparator.BIG_ENDIAN) {
                            return UnsignedLongs.compare(long1, long2);
                        }
                        final int n3 = Long.numberOfTrailingZeros(long1 ^ long2) & 0xFFFFFFF8;
                        return (int)((long1 >>> n3 & 0xFFL) - (long2 >>> n3 & 0xFFL));
                    }
                    else {
                        i += 8;
                    }
                }
                for (int j = n * 8; j < min; ++j) {
                    final int n2;
                    if ((n2 = UnsignedBytes.compare(o[j], o2[j])) != 0) {
                        return n2;
                    }
                }
                return o.length - o2.length;
            }
        }
    }
}
