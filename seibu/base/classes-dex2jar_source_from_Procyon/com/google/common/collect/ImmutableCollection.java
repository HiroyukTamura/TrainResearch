// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import javax.annotation.Nullable;
import java.util.Collection;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractCollection;

@GwtCompatible(emulated = true)
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable
{
    private transient ImmutableList<E> asList;
    
    ImmutableCollection() {
    }
    
    @Deprecated
    @Override
    public final boolean add(final E e) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean addAll(final Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }
    
    public ImmutableList<E> asList() {
        ImmutableList<E> asList;
        if ((asList = this.asList) == null) {
            asList = this.createAsList();
            this.asList = asList;
        }
        return asList;
    }
    
    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o != null && super.contains(o);
    }
    
    int copyIntoArray(final Object[] array, int n) {
        final Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            array[n] = iterator.next();
            ++n;
        }
        return n;
    }
    
    ImmutableList<E> createAsList() {
        switch (this.size()) {
            default: {
                return new RegularImmutableAsList<E>(this, this.toArray());
            }
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return ImmutableList.of(this.iterator().next());
            }
        }
    }
    
    abstract boolean isPartialView();
    
    @Override
    public abstract UnmodifiableIterator<E> iterator();
    
    @Deprecated
    @Override
    public final boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean removeAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean retainAll(final Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final Object[] toArray() {
        final int size = this.size();
        if (size == 0) {
            return ObjectArrays.EMPTY_ARRAY;
        }
        final Object[] array = new Object[size];
        this.copyIntoArray(array, 0);
        return array;
    }
    
    @Override
    public final <T> T[] toArray(final T[] array) {
        Preconditions.checkNotNull(array);
        final int size = this.size();
        T[] array2;
        if (array.length < size) {
            array2 = ObjectArrays.newArray(array, size);
        }
        else {
            array2 = array;
            if (array.length > size) {
                array[size] = null;
                array2 = array;
            }
        }
        this.copyIntoArray(array2, 0);
        return array2;
    }
    
    Object writeReplace() {
        return new ImmutableList.SerializedForm(this.toArray());
    }
    
    abstract static class ArrayBasedBuilder<E> extends Builder<E>
    {
        Object[] contents;
        int size;
        
        ArrayBasedBuilder(final int n) {
            CollectPreconditions.checkNonnegative(n, "initialCapacity");
            this.contents = new Object[n];
            this.size = 0;
        }
        
        private void ensureCapacity(final int n) {
            if (this.contents.length < n) {
                this.contents = ObjectArrays.arraysCopyOf(this.contents, Builder.expandedCapacity(this.contents.length, n));
            }
        }
        
        public ArrayBasedBuilder<E> add(final E e) {
            Preconditions.checkNotNull(e);
            this.ensureCapacity(this.size + 1);
            this.contents[this.size++] = e;
            return this;
        }
        
        @Override
        public Builder<E> add(final E... array) {
            ObjectArrays.checkElementsNotNull((Object[])array);
            this.ensureCapacity(this.size + array.length);
            System.arraycopy(array, 0, this.contents, this.size, array.length);
            this.size += array.length;
            return this;
        }
        
        @Override
        public Builder<E> addAll(final Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                this.ensureCapacity(this.size + ((Collection<? extends E>)iterable).size());
            }
            super.addAll(iterable);
            return this;
        }
    }
    
    public abstract static class Builder<E>
    {
        static final int DEFAULT_INITIAL_CAPACITY = 4;
        
        Builder() {
        }
        
        static int expandedCapacity(int n, int n2) {
            if (n2 < 0) {
                throw new AssertionError((Object)"cannot store more than MAX_VALUE elements");
            }
            if ((n = (n >> 1) + n + 1) < n2) {
                n = Integer.highestOneBit(n2 - 1) << 1;
            }
            if ((n2 = n) < 0) {
                n2 = Integer.MAX_VALUE;
            }
            return n2;
        }
        
        public abstract Builder<E> add(final E p0);
        
        public Builder<E> add(final E... array) {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.add(array[i]);
            }
            return this;
        }
        
        public Builder<E> addAll(final Iterable<? extends E> iterable) {
            final Iterator<? extends E> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                this.add(iterator.next());
            }
            return this;
        }
        
        public Builder<E> addAll(final Iterator<? extends E> iterator) {
            while (iterator.hasNext()) {
                this.add(iterator.next());
            }
            return this;
        }
        
        public abstract ImmutableCollection<E> build();
    }
}
