// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableList<E> extends ImmutableList<E>
{
    final transient E element;
    
    SingletonImmutableList(final E e) {
        this.element = Preconditions.checkNotNull(e);
    }
    
    @Override
    public boolean contains(@Nullable final Object obj) {
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
            if (!(o instanceof List)) {
                return false;
            }
            final List list = (List)o;
            if (list.size() != 1 || !this.element.equals(list.get(0))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public E get(final int n) {
        Preconditions.checkElementIndex(n, 1);
        return this.element;
    }
    
    @Override
    public int hashCode() {
        return this.element.hashCode() + 31;
    }
    
    @Override
    public int indexOf(@Nullable final Object obj) {
        if (this.element.equals(obj)) {
            return 0;
        }
        return -1;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
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
    public int lastIndexOf(@Nullable final Object o) {
        return this.indexOf(o);
    }
    
    @Override
    public ImmutableList<E> reverse() {
        return this;
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    public ImmutableList<E> subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, 1);
        ImmutableList<Object> of = (ImmutableList<Object>)this;
        if (n == n2) {
            of = ImmutableList.of();
        }
        return (ImmutableList<E>)of;
    }
    
    @Override
    public String toString() {
        final String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
}
