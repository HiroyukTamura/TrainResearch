// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.Set;
import java.util.NavigableSet;
import java.util.Collection;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(emulated = true)
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E>
{
    protected ForwardingSortedMultiset() {
    }
    
    @Override
    public Comparator<? super E> comparator() {
        return this.delegate().comparator();
    }
    
    @Override
    protected abstract SortedMultiset<E> delegate();
    
    @Override
    public SortedMultiset<E> descendingMultiset() {
        return this.delegate().descendingMultiset();
    }
    
    @Override
    public NavigableSet<E> elementSet() {
        return (NavigableSet<E>)(NavigableSet)super.elementSet();
    }
    
    @Override
    public Entry<E> firstEntry() {
        return this.delegate().firstEntry();
    }
    
    @Override
    public SortedMultiset<E> headMultiset(final E e, final BoundType boundType) {
        return this.delegate().headMultiset(e, boundType);
    }
    
    @Override
    public Entry<E> lastEntry() {
        return this.delegate().lastEntry();
    }
    
    @Override
    public Entry<E> pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }
    
    @Override
    public Entry<E> pollLastEntry() {
        return this.delegate().pollLastEntry();
    }
    
    protected Entry<E> standardFirstEntry() {
        final Iterator<Entry<E>> iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset.Entry<E> entry = iterator.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }
    
    protected Entry<E> standardLastEntry() {
        final Iterator<Entry<E>> iterator = this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset.Entry<E> entry = iterator.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }
    
    protected Entry<E> standardPollFirstEntry() {
        final Iterator<Entry<E>> iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset.Entry<E> entry = iterator.next();
        final Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        iterator.remove();
        return immutableEntry;
    }
    
    protected Entry<E> standardPollLastEntry() {
        final Iterator<Entry<E>> iterator = this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset.Entry<E> entry = iterator.next();
        final Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        iterator.remove();
        return immutableEntry;
    }
    
    protected SortedMultiset<E> standardSubMultiset(final E e, final BoundType boundType, final E e2, final BoundType boundType2) {
        return this.tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }
    
    @Override
    public SortedMultiset<E> subMultiset(final E e, final BoundType boundType, final E e2, final BoundType boundType2) {
        return this.delegate().subMultiset(e, boundType, e2, boundType2);
    }
    
    @Override
    public SortedMultiset<E> tailMultiset(final E e, final BoundType boundType) {
        return this.delegate().tailMultiset(e, boundType);
    }
    
    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E>
    {
        public StandardDescendingMultiset() {
        }
        
        @Override
        SortedMultiset<E> forwardMultiset() {
            return (SortedMultiset<E>)ForwardingSortedMultiset.this;
        }
    }
    
    protected class StandardElementSet extends NavigableElementSet<E>
    {
        public StandardElementSet() {
            super(ForwardingSortedMultiset.this);
        }
    }
}
