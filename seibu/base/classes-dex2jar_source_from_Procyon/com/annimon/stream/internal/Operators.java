// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.internal;

import java.util.ArrayList;
import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.List;
import com.annimon.stream.function.IntFunction;
import java.util.Iterator;

public final class Operators
{
    private Operators() {
    }
    
    public static <T, R> R[] toArray(final Iterator<? extends T> iterator, final IntFunction<R[]> intFunction) {
        final List<Object> list = toList((Iterator<?>)iterator);
        final int size = list.size();
        Compat.checkMaxArraySize(size);
        final Object[] array = list.toArray((Object[])Compat.newArray(size, (T[])new Object[0]));
        final R[] array2 = intFunction.apply(size);
        System.arraycopy(array, 0, array2, 0, size);
        return array2;
    }
    
    public static double[] toDoubleArray(final PrimitiveIterator.OfDouble ofDouble) {
        final SpinedBuffer.OfDouble ofDouble2 = new SpinedBuffer.OfDouble();
        while (ofDouble.hasNext()) {
            ofDouble2.accept(ofDouble.nextDouble());
        }
        return ((SpinedBuffer.OfPrimitive<E, double[], T_CONS>)ofDouble2).asPrimitiveArray();
    }
    
    public static int[] toIntArray(final PrimitiveIterator.OfInt ofInt) {
        final SpinedBuffer.OfInt ofInt2 = new SpinedBuffer.OfInt();
        while (ofInt.hasNext()) {
            ofInt2.accept(ofInt.nextInt());
        }
        return ((SpinedBuffer.OfPrimitive<E, int[], T_CONS>)ofInt2).asPrimitiveArray();
    }
    
    public static <T> List<T> toList(final Iterator<? extends T> iterator) {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<T>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return (List<T>)list;
    }
    
    public static long[] toLongArray(final PrimitiveIterator.OfLong ofLong) {
        final SpinedBuffer.OfLong ofLong2 = new SpinedBuffer.OfLong();
        while (ofLong.hasNext()) {
            ofLong2.accept(ofLong.nextLong());
        }
        return ((SpinedBuffer.OfPrimitive<E, long[], T_CONS>)ofLong2).asPrimitiveArray();
    }
}
