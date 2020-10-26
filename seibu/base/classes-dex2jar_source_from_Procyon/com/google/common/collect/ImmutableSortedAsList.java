// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E>
{
    ImmutableSortedAsList(final ImmutableSortedSet<E> set, final ImmutableList<E> list) {
        super(set, (ImmutableList<? extends E>)list);
    }
    
    @Override
    public Comparator<? super E> comparator() {
        return this.delegateCollection().comparator();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    @Override
    ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet<E>)(ImmutableSortedSet)super.delegateCollection();
    }
    
    @GwtIncompatible("ImmutableSortedSet.indexOf")
    @Override
    public int indexOf(@Nullable final Object obj) {
        final int index = this.delegateCollection().indexOf(obj);
        if (index >= 0 && this.get(index).equals(obj)) {
            return index;
        }
        return -1;
    }
    
    @GwtIncompatible("ImmutableSortedSet.indexOf")
    @Override
    public int lastIndexOf(@Nullable final Object o) {
        return this.indexOf(o);
    }
    
    @GwtIncompatible("super.subListUnchecked does not exist; inherited subList is valid if slow")
    @Override
    ImmutableList<E> subListUnchecked(final int n, final int n2) {
        return new RegularImmutableSortedSet<E>(super.subListUnchecked(n, n2), this.comparator()).asList();
    }
}
