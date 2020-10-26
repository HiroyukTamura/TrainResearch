// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.primitives;

import java.io.Serializable;
import java.util.RandomAccess;
import java.util.AbstractList;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;
import java.util.Collection;
import com.google.common.annotations.Beta;
import com.google.common.base.Converter;
import java.util.Comparator;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Floats
{
    public static final int BYTES = 4;
    
    private Floats() {
    }
    
    public static List<Float> asList(final float... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new FloatArrayAsList(array);
    }
    
    public static int compare(final float f1, final float f2) {
        return Float.compare(f1, f2);
    }
    
    public static float[] concat(final float[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final float[] array2 = new float[n];
        int n2 = 0;
        for (int length2 = array.length, j = 0; j < length2; ++j) {
            final float[] array3 = array[j];
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean contains(final float[] array, final float n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    private static float[] copyOf(final float[] array, final int b) {
        final float[] array2 = new float[b];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, b));
        return array2;
    }
    
    public static float[] ensureCapacity(final float[] array, final int i, final int j) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(j >= 0, "Invalid padding: %s", j);
        float[] copy = array;
        if (array.length < i) {
            copy = copyOf(array, i + j);
        }
        return copy;
    }
    
    public static int hashCode(final float f) {
        return Float.valueOf(f).hashCode();
    }
    
    public static int indexOf(final float[] array, final float n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final float[] array, final float n, int i, final int n2) {
        while (i < n2) {
            if (array[i] == n) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static int indexOf(final float[] array, final float[] array2) {
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
    
    public static boolean isFinite(final float n) {
        boolean b = true;
        boolean b2;
        if (Float.NEGATIVE_INFINITY < n) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (n >= Float.POSITIVE_INFINITY) {
            b = false;
        }
        return b & b2;
    }
    
    public static String join(final String str, final float... array) {
        Preconditions.checkNotNull(str);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 12);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(str).append(array[i]);
        }
        return sb.toString();
    }
    
    public static int lastIndexOf(final float[] array, final float n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final float[] array, final float n, final int n2, int i) {
        for (--i; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
    
    public static float max(final float... array) {
        Preconditions.checkArgument(array.length > 0);
        float max = array[0];
        for (int i = 1; i < array.length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    public static float min(final float... array) {
        Preconditions.checkArgument(array.length > 0);
        float min = array[0];
        for (int i = 1; i < array.length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }
    
    public static float[] toArray(final Collection<? extends Number> collection) {
        float[] floatArray;
        if (collection instanceof FloatArrayAsList) {
            floatArray = ((FloatArrayAsList)collection).toFloatArray();
        }
        else {
            final Object[] array = collection.toArray();
            final int length = array.length;
            final float[] array2 = new float[length];
            int n = 0;
            while (true) {
                floatArray = array2;
                if (n >= length) {
                    break;
                }
                array2[n] = Preconditions.checkNotNull(array[n]).floatValue();
                ++n;
            }
        }
        return floatArray;
    }
    
    @Nullable
    @Beta
    @GwtIncompatible("regular expressions")
    public static Float tryParse(final String s) {
        if (Doubles.FLOATING_POINT_PATTERN.matcher(s).matches()) {
            try {
                return Float.parseFloat(s);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
    
    @GwtCompatible
    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable
    {
        private static final long serialVersionUID = 0L;
        final float[] array;
        final int end;
        final int start;
        
        FloatArrayAsList(final float[] array) {
            this(array, 0, array.length);
        }
        
        FloatArrayAsList(final float[] array, final int start, final int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean contains(final Object o) {
            return o instanceof Float && indexOf(this.array, (float)o, this.start, this.end) != -1;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof FloatArrayAsList)) {
                    return super.equals(o);
                }
                final FloatArrayAsList list = (FloatArrayAsList)o;
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
        public Float get(final int n) {
            Preconditions.checkElementIndex(n, this.size());
            return this.array[this.start + n];
        }
        
        @Override
        public int hashCode() {
            int n = 1;
            for (int i = this.start; i < this.end; ++i) {
                n = n * 31 + Floats.hashCode(this.array[i]);
            }
            return n;
        }
        
        @Override
        public int indexOf(final Object o) {
            if (o instanceof Float) {
                final int access$000 = indexOf(this.array, (float)o, this.start, this.end);
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
            if (o instanceof Float) {
                final int access$100 = lastIndexOf(this.array, (float)o, this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }
        
        @Override
        public Float set(final int n, final Float n2) {
            Preconditions.checkElementIndex(n, this.size());
            final float f = this.array[this.start + n];
            this.array[this.start + n] = Preconditions.checkNotNull(n2);
            return f;
        }
        
        @Override
        public int size() {
            return this.end - this.start;
        }
        
        @Override
        public List<Float> subList(final int n, final int n2) {
            Preconditions.checkPositionIndexes(n, n2, this.size());
            if (n == n2) {
                return Collections.emptyList();
            }
            return new FloatArrayAsList(this.array, this.start + n, this.start + n2);
        }
        
        float[] toFloatArray() {
            final int size = this.size();
            final float[] array = new float[size];
            System.arraycopy(this.array, this.start, array, 0, size);
            return array;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(this.size() * 12);
            sb.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; ++i) {
                sb.append(", ").append(this.array[i]);
            }
            return sb.append(']').toString();
        }
    }
    
    private static final class FloatConverter extends Converter<String, Float> implements Serializable
    {
        static final FloatConverter INSTANCE;
        private static final long serialVersionUID = 1L;
        
        static {
            INSTANCE = new FloatConverter();
        }
        
        private Object readResolve() {
            return FloatConverter.INSTANCE;
        }
        
        @Override
        protected String doBackward(final Float n) {
            return n.toString();
        }
        
        @Override
        protected Float doForward(final String s) {
            return Float.valueOf(s);
        }
        
        @Override
        public String toString() {
            return "Floats.stringConverter()";
        }
    }
    
    private enum LexicographicalComparator implements Comparator<float[]>
    {
        INSTANCE;
        
        @Override
        public int compare(final float[] array, final float[] array2) {
            for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
                final int compare = Float.compare(array[i], array2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return array.length - array2.length;
        }
    }
}
