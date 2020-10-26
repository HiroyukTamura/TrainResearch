// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import com.google.common.annotations.Beta;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import java.util.SortedSet;

@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E>
{
    protected ForwardingSortedSet() {
    }
    
    private int unsafeCompare(final Object o, final Object o2) {
        final Comparator<? super E> comparator = this.comparator();
        if (comparator == null) {
            return ((Comparable)o).compareTo(o2);
        }
        return comparator.compare(o, o2);
    }
    
    @Override
    public Comparator<? super E> comparator() {
        return this.delegate().comparator();
    }
    
    @Override
    protected abstract SortedSet<E> delegate();
    
    @Override
    public E first() {
        return this.delegate().first();
    }
    
    @Override
    public SortedSet<E> headSet(final E e) {
        return this.delegate().headSet(e);
    }
    
    @Override
    public E last() {
        return this.delegate().last();
    }
    
    @Beta
    @Override
    protected boolean standardContains(@Nullable final Object o) {
        boolean b = false;
        try {
            if (this.unsafeCompare(this.tailSet((E)o).first(), o) == 0) {
                b = true;
            }
            return b;
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NoSuchElementException ex2) {
            return false;
        }
        catch (NullPointerException ex3) {
            return false;
        }
    }
    
    @Beta
    @Override
    protected boolean standardRemove(@Nullable final Object o) {
        final boolean b = false;
        try {
            final Iterator<Object> iterator = this.tailSet((E)o).iterator();
            boolean b2 = b;
            if (iterator.hasNext()) {
                b2 = b;
                if (this.unsafeCompare(iterator.next(), o) == 0) {
                    iterator.remove();
                    b2 = true;
                }
            }
            return b2;
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    @Beta
    protected SortedSet<E> standardSubSet(final E e, final E e2) {
        return this.tailSet(e).headSet(e2);
    }
    
    @Override
    public SortedSet<E> subSet(final E e, final E e2) {
        return this.delegate().subSet(e, e2);
    }
    
    @Override
    public SortedSet<E> tailSet(final E e) {
        return this.delegate().tailSet(e);
    }
}
