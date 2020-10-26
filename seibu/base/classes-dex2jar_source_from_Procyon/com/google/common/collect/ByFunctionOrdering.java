// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Objects;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.common.base.Function;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable
{
    private static final long serialVersionUID = 0L;
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;
    
    ByFunctionOrdering(final Function<F, ? extends T> function, final Ordering<T> ordering) {
        this.function = Preconditions.checkNotNull(function);
        this.ordering = Preconditions.checkNotNull(ordering);
    }
    
    @Override
    public int compare(final F n, final F n2) {
        return this.ordering.compare((T)this.function.apply(n), (T)this.function.apply(n2));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (!(o instanceof ByFunctionOrdering)) {
                return false;
            }
            final ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering)o;
            if (!this.function.equals(byFunctionOrdering.function) || !this.ordering.equals(byFunctionOrdering.ordering)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.ordering));
        final String value2 = String.valueOf(String.valueOf(this.function));
        return new StringBuilder(value.length() + 13 + value2.length()).append(value).append(".onResultOf(").append(value2).append(")").toString();
    }
}
