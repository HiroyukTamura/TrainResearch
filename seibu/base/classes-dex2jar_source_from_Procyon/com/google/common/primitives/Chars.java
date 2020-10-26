// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Chars
{
    public static final int BYTES = 2;
    
    private Chars() {
    }
    
    public static List<Character> asList(final char... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new CharArrayAsList(array);
    }
    
    public static char checkedCast(final long lng) {
        final char c = (char)lng;
        if (c != lng) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(lng).toString());
        }
        return c;
    }
    
    public static int compare(final char c, final char c2) {
        return c - c2;
    }
    
    public static char[] concat(final char[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final char[] array2 = new char[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final char[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final char[] array, final char c) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == c) {
                return true;
            }
        }
        return false;
    }
    
    private static char[] copyOf(final char[] array, final int b) {
        final char[] array2 = new char[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    public static char[] ensureCapacity(final char[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        char[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    @GwtIncompatible("doesn't work")
    public static char fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 2, "array too small: %s < %s", array.length, 2);
        return fromBytes(array[0], array[1]);
    }
    
    @GwtIncompatible("doesn't work")
    public static char fromBytes(final byte b, final byte b2) {
        return (char)(b << 8 | (b2 & 0xFF));
    }
    
    public static int hashCode(final char c) {
        return c;
    }
    
    public static int indexOf(final char[] array, final char c) {
        return indexOf(array, c, 0, array.length);
    }
    
    private static int indexOf(final char[] array, final char c, int i, final int n) {
        while (i < n) {
            if (array[i] == c) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final char[] array, final char[] array2) {
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
    
    public static String join(final String str, final char... array) {
        Preconditions.checkNotNull(str);
        final int length = array.length;
        if (length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(str.length() * (length - 1) + length);
        sb.append(array[0]);
        for (int i = 1; i < length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static int lastIndexOf(final char[] array, final char c) {
        return lastIndexOf(array, c, 0, array.length);
    }
    
    private static int lastIndexOf(final char[] array, final char c, final int n, int i) {
        for (--i; i >= n; --i) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static char max(final char... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        char c2;
        for (int i = 1; i < array.length; ++i, c = c2) {
            if (array[i] > (c2 = c)) {
                c2 = array[i];
            }
        }
        return c;
    }
    
    public static char min(final char... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        char c2;
        for (int i = 1; i < array.length; ++i, c = c2) {
            if (array[i] < (c2 = c)) {
                c2 = array[i];
            }
        }
        return c;
    }
    
    public static char saturatedCast(final long n) {
        if (n > 65535L) {
            return '\uffff';
        }
        if (n < 0L) {
            return '\0';
        }
        return (char)n;
    }
    
    public static char[] toArray(final Collection<Character> collection) {
        char[] charArray;
        if (collection instanceof CharArrayAsList) {
            charArray = ((CharArrayAsList)collection).toCharArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final char[] array2 = new char[length];
            int n = 0;
            while (true) {
                charArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]);
                ++n;
            }
        }
        return charArray;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final char c) {
        return new byte[] { (byte)(c >> 8), (byte)c };
    }
    
    @GwtCompatible
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final char[] array;
        final int end;
        final int start;
        
        CharArrayAsList(final char[] array) {
            this(array, 0, array.length);
        }
        
        CharArrayAsList(final char[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Character && indexOf(this.array, (char)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof CharArrayAsList)) {
                    return super.equals(o);
                }
                final CharArrayAsList list = (CharArrayAsList)o;
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
        public Character get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Chars.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Character) {
                final int access$000 = indexOf(this.array, (char)o, this.start, this.end);
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
            if (o instanceof Character) {
                final int access$100 = lastIndexOf(this.array, (char)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Character set(final int n, final Character c) {
            Preconditions.checkElementIndex(n, this.size());
            final char c2 = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(c);
            return c2;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Character> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new CharArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        char[] toCharArray() {
            final int size = this.size();
            final char[] array = new char[size];
            System.arraycopy(this.array, this.start, array, 0, size);
            return array;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.size() * 3);
            sb.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; ++i) {
                sb.append(", ").append(this.array[i]);
            }
            return sb.append(']').toString();
        }
    }
    
    private enum LexicographicalComparator implements Comparator<char[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final char[] array, final char[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = Chars.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
}
