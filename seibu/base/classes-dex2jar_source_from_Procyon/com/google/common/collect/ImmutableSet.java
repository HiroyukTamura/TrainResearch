// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E>
{
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7;
    static final int MAX_TABLE_SIZE = 1073741824;
    
    ImmutableSet() {
    }
    
    public static <E> Builder<E> builder() {
        return new Builder<E>();
    }
    
    @VisibleForTesting
    static int chooseTableSize(final int n) {
        int n2 = 1073741824;
        if (n < 751619276) {
            int n3 = Integer.highestOneBit(n - 1) << 1;
            while (true) {
                n2 = n3;
                if (n3 * 0.7 >= n) {
                    break;
                }
                n3 <<= 1;
            }
        }
        else {
            Preconditions.checkArgument(n < 1073741824, (Object)"collection too large");
        }
        return n2;
    }
    
    private static <E> ImmutableSet<E> construct(final int toIndex, Object... arraysCopy) {
        switch (toIndex) {
            default: {
                final int chooseTableSize = chooseTableSize(toIndex);
                final Object[] array = new Object[chooseTableSize];
                final int n = chooseTableSize - 1;
                int n2 = 0;
                int i = 0;
                int fromIndex = 0;
                while (i < toIndex) {
                    final Object checkElementNotNull = ObjectArrays.checkElementNotNull(arraysCopy[i], i);
                    final int hashCode = checkElementNotNull.hashCode();
                    int smear = Hashing.smear(hashCode);
                    while (true) {
                        final int n3 = smear & n;
                        final Object o = array[n3];
                        if (o == null) {
                            final int n4 = fromIndex + 1;
                            array[n3] = (arraysCopy[fromIndex] = checkElementNotNull);
                            n2 += hashCode;
                            fromIndex = n4;
                            break;
                        }
                        if (o.equals(checkElementNotNull)) {
                            break;
                        }
                        ++smear;
                    }
                    ++i;
                }
                Arrays.fill(arraysCopy, fromIndex, toIndex, null);
                if (fromIndex == 1) {
                    return new SingletonImmutableSet<E>(arraysCopy[0], n2);
                }
                if (chooseTableSize != chooseTableSize(fromIndex)) {
                    return (ImmutableSet<E>)construct(fromIndex, arraysCopy);
                }
                if (fromIndex < arraysCopy.length) {
                    arraysCopy = ObjectArrays.arraysCopyOf(arraysCopy, fromIndex);
                }
                return new RegularImmutableSet<E>(arraysCopy, n2, array, n);
            }
            case 0: {
                return of();
            }
            case 1: {
                return of(arraysCopy[0]);
            }
        }
    }
    
    public static <E> ImmutableSet<E> copyOf(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<? extends E>)iterable);
        }
        return copyOf((Iterator<? extends E>)iterable.iterator());
    }
    
    public static <E> ImmutableSet<E> copyOf(final Collection<? extends E> collection) {
        if (collection instanceof ImmutableSet && !(collection instanceof ImmutableSortedSet)) {
            final ImmutableSet<E> set = (ImmutableSet<E>)collection;
            if (!set.isPartialView()) {
                return set;
            }
        }
        else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet<E>)collection);
        }
        final Object[] array = collection.toArray();
        return (ImmutableSet<E>)construct(array.length, array);
    }
    
    public static <E> ImmutableSet<E> copyOf(final Iterator<? extends E> iterator) {
        if (!iterator.hasNext()) {
            return of();
        }
        final E next = (E)iterator.next();
        if (!iterator.hasNext()) {
            return of(next);
        }
        return new Builder<E>().add(next).addAll(iterator).build();
    }
    
    public static <E> ImmutableSet<E> copyOf(final E[] array) {
        switch (array.length) {
            default: {
                return construct(array.length, (Object[])array.clone());
            }
            case 0: {
                return of();
            }
            case 1: {
                return of(array[0]);
            }
        }
    }
    
    private static <E extends Enum<E>> ImmutableSet<E> copyOfEnumSet(final EnumSet<E> s) {
        return ImmutableEnumSet.asImmutable((EnumSet<E>)EnumSet.copyOf((EnumSet<E>)s));
    }
    
    public static <E> ImmutableSet<E> of() {
        return (ImmutableSet<E>)EmptyImmutableSet.INSTANCE;
    }
    
    public static <E> ImmutableSet<E> of(final E e) {
        return new SingletonImmutableSet<E>(e);
    }
    
    public static <E> ImmutableSet<E> of(final E e, final E e2) {
        return construct(2, e, e2);
    }
    
    public static <E> ImmutableSet<E> of(final E e, final E e2, final E e3) {
        return construct(3, e, e2, e3);
    }
    
    public static <E> ImmutableSet<E> of(final E e, final E e2, final E e3, final E e4) {
        return construct(4, e, e2, e3, e4);
    }
    
    public static <E> ImmutableSet<E> of(final E e, final E e2, final E e3, final E e4, final E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }
    
    public static <E> ImmutableSet<E> of(final E e, final E e2, final E e3, final E e4, final E e5, final E e6, final E... array) {
        final Object[] array2 = new Object[array.length + 6];
        array2[0] = e;
        array2[1] = e2;
        array2[2] = e3;
        array2[3] = e4;
        array2[4] = e5;
        array2[5] = e6;
        System.arraycopy(array, 0, array2, 6, array.length);
        return (ImmutableSet<E>)construct(array2.length, array2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || ((!(o instanceof ImmutableSet) || !this.isHashCodeFast() || !((ImmutableSet)o).isHashCodeFast() || this.hashCode() == o.hashCode()) && Sets.equalsImpl(this, o));
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
    
    boolean isHashCodeFast() {
        return false;
    }
    
    @Override
    public abstract UnmodifiableIterator<E> iterator();
    
    @Override
    Object writeReplace() {
        return new SerializedForm(this.toArray());
    }
    
    public static class Builder<E> extends ArrayBasedBuilder<E>
    {
        public Builder() {
            this(4);
        }
        
        Builder(final int n) {
            super(n);
        }
        
        public Builder<E> add(final E e) {
            super.add(e);
            return this;
        }
        
        public Builder<E> add(final E... array) {
            super.add(array);
            return this;
        }
        
        public Builder<E> addAll(final Iterable<? extends E> iterable) {
            super.addAll(iterable);
            return this;
        }
        
        public Builder<E> addAll(final Iterator<? extends E> iterator) {
            super.addAll(iterator);
            return this;
        }
        
        public ImmutableSet<E> build() {
            final ImmutableSet<Object> access$000 = construct(this.size, this.contents);
            this.size = access$000.size();
            return (ImmutableSet<E>)access$000;
        }
    }
    
    private static class SerializedForm implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final Object[] elements;
        
        SerializedForm(final Object[] elements) {
            this.elements = elements;
        }
        
        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }
}
