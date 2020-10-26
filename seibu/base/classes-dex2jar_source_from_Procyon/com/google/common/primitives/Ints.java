// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import javax.annotation.CheckForNull;
import java.util.Collection;
import com.google.common.annotations.Beta;
import com.google.common.base.Converter;
import java.util.Comparator;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Ints
{
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;
    private static final byte[] asciiDigits;
    
    static {
        Arrays.fill(asciiDigits = new byte[128], (byte)(-1));
        for (int i = 0; i <= 9; ++i) {
            Ints.asciiDigits[i + 48] = (byte)i;
        }
        for (int j = 0; j <= 26; ++j) {
            Ints.asciiDigits[j + 65] = (byte)(j + 10);
            Ints.asciiDigits[j + 97] = (byte)(j + 10);
        }
    }
    
    private Ints() {
    }
    
    public static List<Integer> asList(final int... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(array);
    }
    
    public static int checkedCast(final long lng) {
        final int n = (int)lng;
        if (n != lng) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(lng).toString());
        }
        return n;
    }
    
    public static int compare(final int n, final int n2) {
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
    
    public static int[] concat(final int[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final int[] array2 = new int[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final int[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    private static int[] copyOf(final int[] array, final int b) {
        final int[] array2 = new int[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    private static int digit(final char c) {
        if (c < '\u0080') {
            return Ints.asciiDigits[c];
        }
        return -1;
    }
    
    public static int[] ensureCapacity(final int[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        int[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    @GwtIncompatible("doesn't work")
    public static int fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 4, "array too small: %s < %s", array.length, 4);
        return fromBytes(array[0], array[1], array[2], array[3]);
    }
    
    @GwtIncompatible("doesn't work")
    public static int fromBytes(final byte b, final byte b2, final byte b3, final byte b4) {
        return b << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8 | (b4 & 0xFF);
    }
    
    public static int hashCode(final int n) {
        return n;
    }
    
    public static int indexOf(final int[] array, final int n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final int[] array, final int n, int i, final int n2) {
        while (i < n2) {
            if (array[i] == n) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final int[] array, final int[] array2) {
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
    
    public static String join(final String str, final int... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static int lastIndexOf(final int[] array, final int n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final int[] array, final int n, final int n2, int i) {
        for (--i; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static int max(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int n = array[0];
        int n2;
        for (int i = 1; i < array.length; ++i, n = n2) {
            if (array[i] > (n2 = n)) {
                n2 = array[i];
            }
        }
        return n;
    }
    
    public static int min(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int n = array[0];
        int n2;
        for (int i = 1; i < array.length; ++i, n = n2) {
            if (array[i] < (n2 = n)) {
                n2 = array[i];
            }
        }
        return n;
    }
    
    public static int saturatedCast(final long n) {
        if (n > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (n < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int)n;
    }
    
    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }
    
    public static int[] toArray(final Collection<? extends Number> collection) {
        int[] intArray;
        if (collection instanceof IntArrayAsList) {
            intArray = ((IntArrayAsList)collection).toIntArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final int[] array2 = new int[length];
            int n = 0;
            while (true) {
                intArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]).intValue();
                ++n;
            }
        }
        return intArray;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final int n) {
        return new byte[] { (byte)(n >> 24), (byte)(n >> 16), (byte)(n >> 8), (byte)n };
    }
    
    @CheckForNull
    @Beta
    public static Integer tryParse(final String s) {
        return tryParse(s, 10);
    }
    
    @CheckForNull
    static Integer tryParse(final String s, final int i) {
        int index = 1;
        if (Preconditions.checkNotNull(s).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException(new StringBuilder(65).append("radix must be between MIN_RADIX and MAX_RADIX but was ").append(i).toString());
        }
        boolean b;
        if (s.charAt(0) == '-') {
            b = true;
        }
        else {
            b = false;
        }
        if (!b) {
            index = 0;
        }
        if (index == s.length()) {
            return null;
        }
        final int digit = digit(s.charAt(index));
        if (digit < 0 || digit >= i) {
            return null;
        }
        int j = -digit;
        final int n = Integer.MIN_VALUE / i;
        for (int k = index + 1; k < s.length(); ++k) {
            final int digit2 = digit(s.charAt(k));
            if (digit2 < 0 || digit2 >= i || j < n) {
                return null;
            }
            final int n2 = j * i;
            if (n2 < Integer.MIN_VALUE + digit2) {
                return null;
            }
            j = n2 - digit2;
        }
        if (b) {
            return j;
        }
        if (j == Integer.MIN_VALUE) {
            return null;
        }
        return -j;
    }
    
    @GwtCompatible
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final int[] array;
        final int end;
        final int start;
        
        IntArrayAsList(final int[] array) {
            this(array, 0, array.length);
        }
        
        IntArrayAsList(final int[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Integer && indexOf(this.array, (int)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof IntArrayAsList)) {
                    return super.equals(o);
                }
                final IntArrayAsList list = (IntArrayAsList)o;
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
        public Integer get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Ints.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Integer) {
                final int access$000 = indexOf(this.array, (int)o, this.start, this.end);
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
            if (o instanceof Integer) {
                final int access$100 = lastIndexOf(this.array, (int)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Integer set(final int n, final Integer n2) {
            Preconditions.checkElementIndex(n, this.size());
            final int i = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(n2);
            return i;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Integer> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new IntArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        int[] toIntArray() {
            final int size = this.size();
            final int[] array = new int[size];
            System.arraycopy(this.array, this.start, array, 0, size);
            return array;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.size() * 5);
            sb.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; ++i) {
                sb.append(", ").append(this.array[i]);
            }
            return sb.append(']').toString();
        }
    }
    
    private static final class IntConverter extends Converter<String, Integer> implements Serializable
    {
        static final IntConverter INSTANCE;
        private static final long serialVersionUID = 1L;
        
        static {
            INSTANCE = new IntConverter();
        }
        
        private Object readResolve() {
            return IntConverter.INSTANCE;
        }
        
        @Override
        protected String doBackward(final Integer n) {
            return n.toString();
        }
        
        @Override
        protected Integer doForward(final String nm) {
            return Integer.decode(nm);
        }
        
        @Override
        public String toString() {
            return "Ints.stringConverter()";
        }
    }
    
    private enum LexicographicalComparator implements Comparator<int[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final int[] array, final int[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = Ints.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
}
