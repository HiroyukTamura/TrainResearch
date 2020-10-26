// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class SortedIterables
{
    private SortedIterables() {
    }
    
    public static <E> Comparator<? super E> comparator(final SortedSet<E> set) {
        Object o;
        if ((o = set.comparator()) == null) {
            o = Ordering.natural();
        }
        return (Comparator<? super E>)o;
    }
    
    public static boolean hasSameComparator(final Comparator<?> comparator, final Iterable<?> iterable) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        Comparator<? super Object> comparator2;
        if (iterable instanceof SortedSet) {
            comparator2 = comparator((SortedSet<Object>)iterable);
        }
        else {
            if (!(iterable instanceof SortedIterable)) {
                return false;
            }
            comparator2 = (Comparator<? super Object>)((SortedIterable)iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
