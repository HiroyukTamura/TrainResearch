// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.internal;

import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class Compat
{
    private static final String BAD_SIZE = "Stream size exceeds max array size";
    static final long MAX_ARRAY_SIZE = 2147483639L;
    
    static void checkMaxArraySize(final long n) {
        if (n >= 2147483639L) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }
    
    @SafeVarargs
    public static <E> E[] newArray(final int newLength, final E... original) {
        try {
            return Arrays.copyOf(original, newLength);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            return newArrayCompat(original, newLength);
        }
    }
    
    public static <E> E[] newArrayCompat(final E[] array, final int n) {
        final Object[] array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), n);
        System.arraycopy(array, 0, array2, 0, Math.min(n, array.length));
        return (E[])array2;
    }
    
    public static <T> Queue<T> queue() {
        try {
            return new ArrayDeque<T>();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return new LinkedList<T>();
        }
    }
}
