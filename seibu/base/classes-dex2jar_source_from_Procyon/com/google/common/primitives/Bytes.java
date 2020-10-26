// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.Collection;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Bytes
{
    private Bytes() {
    }
    
    public static List<Byte> asList(final byte... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new ByteArrayAsList(array);
    }
    
    public static byte[] concat(final byte[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final byte[] array2 = new byte[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final byte[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final byte[] array, final byte b) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == b) {
                return true;
            }
        }
        return false;
    }
    
    private static byte[] copyOf(final byte[] array, final int b) {
        final byte[] array2 = new byte[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    public static byte[] ensureCapacity(final byte[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        byte[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    public static int hashCode(final byte b) {
        return b;
    }
    
    public static int indexOf(final byte[] array, final byte b) {
        return indexOf(array, b, 0, array.length);
    }
    
    private static int indexOf(final byte[] array, final byte b, int i, final int n) {
        while (i < n) {
            if (array[i] == b) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final byte[] array, final byte[] array2) {
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
    
    public static int lastIndexOf(final byte[] array, final byte b) {
        return lastIndexOf(array, b, 0, array.length);
    }
    
    private static int lastIndexOf(final byte[] array, final byte b, final int n, int i) {
        for (--i; i >= n; --i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static byte[] toArray(final Collection<? extends Number> collection) {
        byte[] byteArray;
        if (collection instanceof ByteArrayAsList) {
            byteArray = ((ByteArrayAsList)collection).toByteArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final byte[] array2 = new byte[length];
            int n = 0;
            while (true) {
                byteArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]).byteValue();
                ++n;
            }
        }
        return byteArray;
    }
    
    @GwtCompatible
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final byte[] array;
        final int end;
        final int start;
        
        ByteArrayAsList(final byte[] array) {
            this(array, 0, array.length);
        }
        
        ByteArrayAsList(final byte[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Byte && indexOf(this.array, (byte)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof ByteArrayAsList)) {
                    return super.equals(o);
                }
                final ByteArrayAsList list = (ByteArrayAsList)o;
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
        public Byte get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Bytes.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Byte) {
                final int access$000 = indexOf(this.array, (byte)o, this.start, this.end);
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
            if (o instanceof Byte) {
                final int access$100 = lastIndexOf(this.array, (byte)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Byte set(final int n, final Byte b) {
            Preconditions.checkElementIndex(n, this.size());
            final byte b2 = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(b);
            return b2;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Byte> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new ByteArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        byte[] toByteArray() {
            final int size = this.size();
            final byte[] array = new byte[size];
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
}
