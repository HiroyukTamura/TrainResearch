// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class EmptyImmutableSet extends ImmutableSet<Object>
{
    static final EmptyImmutableSet INSTANCE;
    private static final long serialVersionUID = 0L;
    
    static {
        INSTANCE = new EmptyImmutableSet();
    }
    
    private EmptyImmutableSet() {
    }
    
    @Override
    public ImmutableList<Object> asList() {
        return ImmutableList.of();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return collection.isEmpty();
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Set && ((Set)o).isEmpty();
    }
    
    @Override
    public final int hashCode() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<Object> iterator() {
        return Iterators.emptyIterator();
    }
    
    Object readResolve() {
        return EmptyImmutableSet.INSTANCE;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "[]";
    }
}
