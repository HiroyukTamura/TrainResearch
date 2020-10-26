// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Collection;
import java.util.EnumSet;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E>
{
    private final transient EnumSet<E> delegate;
    private transient int hashCode;
    
    private ImmutableEnumSet(final EnumSet<E> delegate) {
        this.delegate = delegate;
    }
    
    static <E extends Enum<E>> ImmutableSet<E> asImmutable(final EnumSet<E> set) {
        switch (set.size()) {
            default: {
                return new ImmutableEnumSet<E>(set);
            }
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                return ImmutableSet.of((E)Iterables.getOnlyElement((Iterable<E>)set));
            }
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.delegate.contains(o);
    }
    
    @Override
    public boolean containsAll(final Collection<?> c) {
        return this.delegate.containsAll(c);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || this.delegate.equals(o);
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if ((hashCode = this.hashCode) == 0) {
            hashCode = this.delegate.hashCode();
            this.hashCode = hashCode;
        }
        return hashCode;
    }
    
    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
    
    @Override
    public int size() {
        return this.delegate.size();
    }
    
    @Override
    public String toString() {
        return this.delegate.toString();
    }
    
    @Override
    Object writeReplace() {
        return new EnumSerializedForm((EnumSet<Enum>)this.delegate);
    }
    
    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final EnumSet<E> delegate;
        
        EnumSerializedForm(final EnumSet<E> delegate) {
            this.delegate = delegate;
        }
        
        Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }
    }
}
