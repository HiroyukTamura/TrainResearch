// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable
{
    private static final long serialVersionUID = 0L;
    final ImmutableMap<T, Integer> rankMap;
    
    ExplicitOrdering(final ImmutableMap<T, Integer> rankMap) {
        this.rankMap = rankMap;
    }
    
    ExplicitOrdering(final List<T> list) {
        this(buildRankMap(list));
    }
    
    private static <T> ImmutableMap<T, Integer> buildRankMap(final List<T> list) {
        final ImmutableMap.Builder<T, Integer> builder = ImmutableMap.builder();
        int i = 0;
        final Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            builder.put(iterator.next(), i);
            ++i;
        }
        return builder.build();
    }
    
    private int rank(final T t) {
        final Integer n = this.rankMap.get(t);
        if (n == null) {
            throw new IncomparableValueException(t);
        }
        return n;
    }
    
    @Override
    public int compare(final T t, final T t2) {
        return this.rank(t) - this.rank(t2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof ExplicitOrdering && this.rankMap.equals(((ExplicitOrdering)o).rankMap);
    }
    
    @Override
    public int hashCode() {
        return this.rankMap.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.rankMap.keySet()));
        return new StringBuilder(value.length() + 19).append("Ordering.explicit(").append(value).append(")").toString();
    }
}
