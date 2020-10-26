// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.Collection;
import com.google.common.annotations.Beta;
import com.google.common.base.Converter;
import java.util.Comparator;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Shorts
{
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;
    
    private Shorts() {
    }
    
    public static List<Short> asList(final short... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new ShortArrayAsList(array);
    }
    
    public static short checkedCast(final long lng) {
        final short n = (short)lng;
        if (n != lng) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(lng).toString());
        }
        return n;
    }
    
    public static int compare(final short n, final short n2) {
        return n - n2;
    }
    
    public static short[] concat(final short[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final short[] array2 = new short[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final short[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final short[] array, final short n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    private static short[] copyOf(final short[] array, final int b) {
        final short[] array2 = new short[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    public static short[] ensureCapacity(final short[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        short[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    @GwtIncompatible("doesn't work")
    public static short fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 2, "array too small: %s < %s", array.length, 2);
        return fromBytes(array[0], array[1]);
    }
    
    @GwtIncompatible("doesn't work")
    public static short fromBytes(final byte b, final byte b2) {
        return (short)(b << 8 | (b2 & 0xFF));
    }
    
    public static int hashCode(final short n) {
        return n;
    }
    
    public static int indexOf(final short[] array, final short n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final short[] array, final short n, int i, final int n2) {
        while (i < n2) {
            if (array[i] == n) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final short[] array, final short[] array2) {
        Preconditions.checkNotNull(array, (Object)"array");
        Preconditions.checkNotNull(array2, (Object)"target");
        if (array2.length != 0) {
            for (int i = 0; i < array.length - array2.length + 1; ++i) {
                int n = 0;
                while (true) {
                    final int n2 = i;
                    if (n >= array2.length) {
                        return n2;
                    }
                    if (array[i + n] != array2[n]) {
                        break;
                    }
                    ++n;
                }
            }
            return -1;
        }
        return 0;
    }
    
    public static String join(final String str, final short... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static int lastIndexOf(final short[] array, final short n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final short[] array, final short n, final int n2, int i) {
        for (--i; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static short max(final short... array) {
        Preconditions.checkArgument(array.length > 0);
        short n = array[0];
        short n2;
        for (int i = 1; i < array.length; ++i, n = n2) {
            if (array[i] > (n2 = n)) {
                n2 = array[i];
            }
        }
        return n;
    }
    
    public static short min(final short... array) {
        Preconditions.checkArgument(array.length > 0);
        short n = array[0];
        short n2;
        for (int i = 1; i < array.length; ++i, n = n2) {
            if (array[i] < (n2 = n)) {
                n2 = array[i];
            }
        }
        return n;
    }
    
    public static short saturatedCast(final long n) {
        if (n > 32767L) {
            return 32767;
        }
        if (n < -32768L) {
            return -32768;
        }
        return (short)n;
    }
    
    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }
    
    public static short[] toArray(final Collection<? extends Number> collection) {
        short[] shortArray;
        if (collection instanceof ShortArrayAsList) {
            shortArray = ((ShortArrayAsList)collection).toShortArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final short[] array2 = new short[length];
            int n = 0;
            while (true) {
                shortArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]).shortValue();
                ++n;
            }
        }
        return shortArray;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final short n) {
        return new byte[] { (byte)(n >> 8), (byte)n };
    }
    
    private enum LexicographicalComparator implements Comparator<short[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final short[] array, final short[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = Shorts.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
    
    @GwtCompatible
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final short[] array;
        final int end;
        final int start;
        
        ShortArrayAsList(final short[] array) {
            this(array, 0, array.length);
        }
        
        ShortArrayAsList(final short[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Short && indexOf(this.array, (short)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof ShortArrayAsList)) {
                    return super.equals(o);
                }
                final ShortArrayAsList list = (ShortArrayAsList)o;
                final int size = this.size();
                if (list.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; ++i) {
                    if (this.array[this.start + i] != list.array[list.start + i]) {
                        return false;
                    }
                }
            }
            return true;
        }
        
        @Override
        public Short get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Shorts.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Short) {
                final int access$000 = indexOf(this.array, (short)o, this.start, this.end);
                if (access$000 >= 0) {
                    return access$000 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            if (o instanceof Short) {
                final int access$100 = lastIndexOf(this.array, (short)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Short set(final int n, final Short n2) {
            Preconditions.checkElementIndex(n, this.size());
            final short s = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(n2);
            return s;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Short> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new ShortArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        short[] toShortArray() {
            final int size = this.size();
            final short[] array = new short[size];
            System.arraycopy(this.array, this.start, array, 0, size);
            return array;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.size() * 6);
            sb.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; ++i) {
                sb.append(", ").append(this.array[i]);
            }
            return sb.append(']').toString();
        }
    }
    
    private static final class ShortConverter extends Converter<String, Short> implements Serializable
    {
        static final ShortConverter INSTANCE;
        private static final long serialVersionUID = 1L;
        
        static {
            INSTANCE = new ShortConverter();
        }
        
        private Object readResolve() {
            return ShortConverter.INSTANCE;
        }
        
        @Override
        protected String doBackward(final Short n) {
            return n.toString();
        }
        
        @Override
        protected Short doForward(final String nm) {
            return Short.decode(nm);
        }
        
        @Override
        public String toString() {
            return "Shorts.stringConverter()";
        }
    }
}
