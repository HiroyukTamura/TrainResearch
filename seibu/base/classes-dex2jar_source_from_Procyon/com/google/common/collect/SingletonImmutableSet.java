// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableSet<E> extends ImmutableSet<E>
{
    private transient int cachedHashCode;
    final transient E element;
    
    SingletonImmutableSet(final E e) {
        this.element = Preconditions.checkNotNull(e);
    }
    
    SingletonImmutableSet(final E element, final int cachedHashCode) {
        this.element = element;
        this.cachedHashCode = cachedHashCode;
    }
    
    @Override
    public boolean contains(final Object obj) {
        return this.element.equals(obj);
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        array[n] = this.element;
        return n + 1;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (!(o instanceof Set)) {
                return false;
            }
            final Set set = (Set)o;
            if (set.size() != 1 || !this.element.equals(set.iterator().next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int cachedHashCode;
        if ((cachedHashCode = this.cachedHashCode) == 0) {
            cachedHashCode = this.element.hashCode();
            this.cachedHashCode = cachedHashCode;
        }
        return cachedHashCode;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    public String toString() {
        final String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
}
