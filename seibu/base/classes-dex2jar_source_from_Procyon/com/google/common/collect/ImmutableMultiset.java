// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import com.google.common.base.Preconditions;
import java.util.Set;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import com.google.common.primitives.Ints;
import java.util.Collection;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E>
{
    private static final ImmutableMultiset<Object> EMPTY;
    private transient ImmutableSet<Entry<E>> entrySet;
    
    static {
        EMPTY = new RegularImmutableMultiset<Object>(ImmutableMap.of(), 0);
    }
    
    ImmutableMultiset() {
    }
    
    public static <E> Builder<E> builder() {
        return new Builder<E>();
    }
    
    static <E> ImmutableMultiset<E> copyFromEntries(final Collection<? extends Entry<? extends E>> collection) {
        long n = 0L;
        final ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        for (final Entry<Object> entry : collection) {
            final int count = entry.getCount();
            if (count > 0) {
                builder.put(entry.getElement(), count);
                n += count;
            }
        }
        if (n == 0L) {
            return of();
        }
        return new RegularImmutableMultiset<E>((ImmutableMap<Object, Integer>)builder.build(), Ints.saturatedCast(n));
    }
    
    public static <E> ImmutableMultiset<E> copyOf(final Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            final ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset<E>)iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        Object o;
        if (iterable instanceof Multiset) {
            o = Multisets.cast((Iterable<E>)iterable);
        }
        else {
            o = LinkedHashMultiset.create((Iterable<?>)iterable);
        }
        return copyOfInternal((Multiset<? extends E>)o);
    }
    
    public static <E> ImmutableMultiset<E> copyOf(final Iterator<? extends E> iterator) {
        final LinkedHashMultiset<Object> create = LinkedHashMultiset.create();
        Iterators.addAll(create, iterator);
        return copyOfInternal((Multiset<? extends E>)create);
    }
    
    public static <E> ImmutableMultiset<E> copyOf(final E[] a) {
        return copyOf((Iterable<? extends E>)Arrays.asList(a));
    }
    
    private static <E> ImmutableMultiset<E> copyOfInternal(final Multiset<? extends E> multiset) {
        return copyFromEntries((Collection<? extends Entry<? extends E>>)multiset.entrySet());
    }
    
    private static <E> ImmutableMultiset<E> copyOfInternal(final E... a) {
        return copyOf((Iterable<? extends E>)Arrays.asList(a));
    }
    
    private final ImmutableSet<Entry<E>> createEntrySet() {
        if (this.isEmpty()) {
            return ImmutableSet.of();
        }
        return new EntrySet();
    }
    
    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>)ImmutableMultiset.EMPTY;
    }
    
    public static <E> ImmutableMultiset<E> of(final E e) {
        return copyOfInternal(e);
    }
    
    public static <E> ImmutableMultiset<E> of(final E e, final E e2) {
        return copyOfInternal(e, e2);
    }
    
    public static <E> ImmutableMultiset<E> of(final E e, final E e2, final E e3) {
        return copyOfInternal(e, e2, e3);
    }
    
    public static <E> ImmutableMultiset<E> of(final E e, final E e2, final E e3, final E e4) {
        return copyOfInternal(e, e2, e3, e4);
    }
    
    public static <E> ImmutableMultiset<E> of(final E e, final E e2, final E e3, final E e4, final E e5) {
        return copyOfInternal(e, e2, e3, e4, e5);
    }
    
    public static <E> ImmutableMultiset<E> of(final E e, final E e2, final E e3, final E e4, final E e5, final E e6, final E... array) {
        return new Builder<E>().add(e).add(e2).add(e3).add(e4).add(e5).add(e6).add(array).build();
    }
    
    @Deprecated
    @Override
    public final int add(final E e, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.count(o) > 0;
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return this.elementSet().containsAll(collection);
    }
    
    @GwtIncompatible("not present in emulated superclass")
    @Override
    int copyIntoArray(final Object[] a, int fromIndex) {
        for (final Entry<Object> entry : this.entrySet()) {
            Arrays.fill(a, fromIndex, entry.getCount() + fromIndex, entry.getElement());
            fromIndex += entry.getCount();
        }
        return fromIndex;
    }
    
    @Override
    public ImmutableSet<Entry<E>> entrySet() {
        ImmutableSet<Entry<E>> entrySet;
        if ((entrySet = this.entrySet) == null) {
            entrySet = this.createEntrySet();
            this.entrySet = entrySet;
        }
        return entrySet;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Multisets.equalsImpl(this, o);
    }
    
    abstract Entry<E> getEntry(final int p0);
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return new UnmodifiableIterator<E>() {
            E element;
            int remaining;
            final /* synthetic */ Iterator val$entryIterator = ImmutableMultiset.this.entrySet().iterator();
            
            @Override
            public boolean hasNext() {
                return this.remaining > 0 || this.val$entryIterator.hasNext();
            }
            
            @Override
            public E next() {
                if (this.remaining <= 0) {
                    final Entry<E> entry = this.val$entryIterator.next();
                    this.element = entry.getElement();
                    this.remaining = entry.getCount();
                }
                --this.remaining;
                return this.element;
            }
        };
    }
    
    @Deprecated
    @Override
    public final int remove(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final int setCount(final E e, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean setCount(final E e, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        return this.entrySet().toString();
    }
    
    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }
    
    public static class Builder<E> extends ImmutableCollection.Builder<E>
    {
        final Multiset<E> contents;
        
        public Builder() {
            this(LinkedHashMultiset.create());
        }
        
        Builder(final Multiset<E> contents) {
            this.contents = contents;
        }
        
        public Builder<E> add(final E e) {
            this.contents.add(Preconditions.checkNotNull(e));
            return this;
        }
        
        public Builder<E> add(final E... array) {
            super.add(array);
            return this;
        }
        
        public Builder<E> addAll(final Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (final Entry<Object> entry : Multisets.cast((Iterable<Object>)iterable).entrySet()) {
                    this.addCopies(entry.getElement(), entry.getCount());
                }
            }
            else {
                super.addAll(iterable);
            }
            return this;
        }
        
        public Builder<E> addAll(final Iterator<? extends E> iterator) {
            super.addAll(iterator);
            return this;
        }
        
        public Builder<E> addCopies(final E e, final int n) {
            this.contents.add(Preconditions.checkNotNull(e), n);
            return this;
        }
        
        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf((Iterable<? extends E>)this.contents);
        }
        
        public Builder<E> setCount(final E e, final int n) {
            this.contents.setCount(Preconditions.checkNotNull(e), n);
            return this;
        }
    }
    
    private final class EntrySet extends ImmutableSet<Entry<E>>
    {
        private static final long serialVersionUID = 0L;
        
        @Override
        public boolean contains(final Object o) {
            if (o instanceof Entry) {
                final Entry entry = (Entry)o;
                if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        ImmutableList<Entry<E>> createAsList() {
            return new ImmutableAsList<Entry<E>>() {
                @Override
                ImmutableCollection<Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
                
                @Override
                public Entry<E> get(final int n) {
                    return ImmutableMultiset.this.getEntry(n);
                }
            };
        }
        
        @Override
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }
        
        @Override
        boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }
        
        @Override
        public UnmodifiableIterator<Entry<E>> iterator() {
            return this.asList().iterator();
        }
        
        @Override
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }
        
        @Override
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }
    
    static class EntrySetSerializedForm<E> implements Serializable
    {
        final ImmutableMultiset<E> multiset;
        
        EntrySetSerializedForm(final ImmutableMultiset<E> multiset) {
            this.multiset = multiset;
        }
        
        Object readResolve() {
            return this.multiset.entrySet();
        }
    }
    
    private static class SerializedForm implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final int[] counts;
        final Object[] elements;
        
        SerializedForm(final Multiset<?> multiset) {
            final int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int n = 0;
            for (final Entry<Object> entry : multiset.entrySet()) {
                this.elements[n] = entry.getElement();
                this.counts[n] = entry.getCount();
                ++n;
            }
        }
        
        Object readResolve() {
            final LinkedHashMultiset<? extends E> create = (LinkedHashMultiset<? extends E>)LinkedHashMultiset.create(this.elements.length);
            for (int i = 0; i < this.elements.length; ++i) {
                create.add(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.copyOf((Iterable<?>)create);
        }
    }
}
