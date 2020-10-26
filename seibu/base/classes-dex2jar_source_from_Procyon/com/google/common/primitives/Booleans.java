// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import com.google.common.base.Preconditions;
import com.google.common.annotations.Beta;
import java.util.Collections;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Booleans
{
    private Booleans() {
    }
    
    public static List<Boolean> asList(final boolean... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(array);
    }
    
    public static int compare(final boolean b, final boolean b2) {
        if (b == b2) {
            return 0;
        }
        if (b) {
            return 1;
        }
        return -1;
    }
    
    public static boolean[] concat(final boolean[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final boolean[] array2 = new boolean[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final boolean[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final boolean[] array, final boolean b) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == b) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean[] copyOf(final boolean[] array, final int b) {
        final boolean[] array2 = new boolean[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    @Beta
    public static int countTrue(final boolean... array) {
        int n = 0;
        int n2;
        for (int length = array.length, i = 0; i < length; ++i, n = n2) {
            n2 = n;
            if (array[i]) {
                n2 = n + 1;
            }
        }
        return n;
    }
    
    public static boolean[] ensureCapacity(final boolean[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        boolean[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    public static int hashCode(final boolean b) {
        if (b) {
            return 1231;
        }
        return 1237;
    }
    
    public static int indexOf(final boolean[] array, final boolean b) {
        return indexOf(array, b, 0, array.length);
    }
    
    private static int indexOf(final boolean[] array, final boolean b, int i, final int n) {
        while (i < n) {
            if (array[i] == b) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final boolean[] array, final boolean[] array2) {
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
    
    public static String join(final String str, final boolean... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static int lastIndexOf(final boolean[] array, final boolean b) {
        return lastIndexOf(array, b, 0, array.length);
    }
    
    private static int lastIndexOf(final boolean[] array, final boolean b, final int n, int i) {
        for (--i; i >= n; --i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static boolean[] toArray(final Collection<Boolean> collection) {
        boolean[] booleanArray;
        if (collection instanceof BooleanArrayAsList) {
            booleanArray = ((BooleanArrayAsList)collection).toBooleanArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final boolean[] array2 = new boolean[length];
            int n = 0;
            while (true) {
                booleanArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]);
                ++n;
            }
        }
        return booleanArray;
    }
    
    @GwtCompatible
    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final boolean[] array;
        final int end;
        final int start;
        
        BooleanArrayAsList(final boolean[] array) {
            this(array, 0, array.length);
        }
        
        BooleanArrayAsList(final boolean[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Boolean && indexOf(this.array, (boolean)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof BooleanArrayAsList)) {
                    return super.equals(o);
                }
                final BooleanArrayAsList list = (BooleanArrayAsList)o;
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
        public Boolean get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Booleans.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Boolean) {
                final int access$000 = indexOf(this.array, (boolean)o, this.start, this.end);
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
            if (o instanceof Boolean) {
                final int access$100 = lastIndexOf(this.array, (boolean)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Boolean set(final int n, final Boolean b) {
            Preconditions.checkElementIndex(n, this.size());
            final boolean b2 = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(b);
            return b2;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Boolean> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new BooleanArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        boolean[] toBooleanArray() {
            final int size = this.size();
            final boolean[] array = new boolean[size];
            System.arraycopy(this.array, this.start, array, 0, size);
            return array;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.size() * 7);
            String str;
            if (this.array[this.start]) {
                str = "[true";
            }
            else {
                str = "[false";
            }
            sb.append(str);
            for (int i = this.start + 1; i < this.end; ++i) {
                String str2;
                if (this.array[i]) {
                    str2 = ", true";
                }
                else {
                    str2 = ", false";
                }
                sb.append(str2);
            }
            return sb.append(']').toString();
        }
    }
    
    private enum LexicographicalComparator implements Comparator<boolean[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final boolean[] array, final boolean[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = Booleans.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
}
