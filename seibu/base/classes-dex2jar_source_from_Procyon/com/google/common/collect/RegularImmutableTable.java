// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V>
{
    static <R, C, V> RegularImmutableTable<R, C, V> forCells(final Iterable<Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }
    
    static <R, C, V> RegularImmutableTable<R, C, V> forCells(final List<Cell<R, C, V>> list, @Nullable final Comparator<? super R> comparator, @Nullable final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort((List<Object>)list, (Comparator<? super Object>)new Comparator<Cell<R, C, V>>() {
                @Override
                public int compare(final Cell<R, C, V> cell, final Cell<R, C, V> cell2) {
                    final int n = 0;
                    int compare;
                    if (comparator == null) {
                        compare = 0;
                    }
                    else {
                        compare = comparator.compare(cell.getRowKey(), cell2.getRowKey());
                    }
                    if (compare != 0) {
                        return compare;
                    }
                    int compare2;
                    if (comparator2 == null) {
                        compare2 = n;
                    }
                    else {
                        compare2 = comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
                    }
                    return compare2;
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }
    
    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(final Iterable<Cell<R, C, V>> iterable, @Nullable final Comparator<? super R> c, @Nullable final Comparator<? super C> c2) {
        final ImmutableSet.Builder<R> builder = ImmutableSet.builder();
        final ImmutableSet.Builder<C> builder2 = ImmutableSet.builder();
        final ImmutableList<Cell<Object, Object, Object>> copy = (ImmutableList<Cell<Object, Object, Object>>)ImmutableList.copyOf((Iterable<?>)iterable);
        for (final Table.Cell<Object, C, V> cell : copy) {
            builder.add((R)cell.getRowKey());
            builder2.add(cell.getColumnKey());
        }
        Set<E> set2;
        final ImmutableSet<R> set = (ImmutableSet<R>)(set2 = (Set<E>)builder.build());
        if (c != null) {
            final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)set);
            Collections.sort(arrayList, (Comparator<? super Object>)c);
            set2 = (Set<E>)ImmutableSet.copyOf((Collection<?>)arrayList);
        }
        Object o;
        final ImmutableSet<C> set3 = (ImmutableSet<C>)(o = builder2.build());
        if (c2 != null) {
            final ArrayList<Object> arrayList2 = Lists.newArrayList((Iterable<?>)set3);
            Collections.sort(arrayList2, (Comparator<? super Object>)c2);
            o = ImmutableSet.copyOf((Collection<?>)arrayList2);
        }
        if (copy.size() > ((AbstractCollection)set2).size() * (long)((AbstractCollection)o).size() / 2L) {
            return new DenseImmutableTable<R, C, V>(copy, (ImmutableSet<Object>)set2, (ImmutableSet<Object>)o);
        }
        return new SparseImmutableTable<R, C, V>(copy, (ImmutableSet<Object>)set2, (ImmutableSet<Object>)o);
    }
    
    @Override
    final ImmutableSet<Cell<R, C, V>> createCellSet() {
        if (this.isEmpty()) {
            return ImmutableSet.of();
        }
        return new CellSet();
    }
    
    @Override
    final ImmutableCollection<V> createValues() {
        if (this.isEmpty()) {
            return (ImmutableCollection<V>)ImmutableList.of();
        }
        return new Values();
    }
    
    abstract Cell<R, C, V> getCell(final int p0);
    
    abstract V getValue(final int p0);
    
    private final class CellSet extends ImmutableSet<Cell<R, C, V>>
    {
        @Override
        public boolean contains(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof Cell) {
                final Cell cell = (Cell)o;
                final Object value = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
                b2 = b;
                if (value != null) {
                    b2 = b;
                    if (value.equals(cell.getValue())) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        ImmutableList<Cell<R, C, V>> createAsList() {
            return new ImmutableAsList<Cell<R, C, V>>() {
                @Override
                ImmutableCollection<Cell<R, C, V>> delegateCollection() {
                    return CellSet.this;
                }
                
                @Override
                public Cell<R, C, V> get(final int n) {
                    return RegularImmutableTable.this.getCell(n);
                }
            };
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        public UnmodifiableIterator<Cell<R, C, V>> iterator() {
            return this.asList().iterator();
        }
        
        @Override
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }
    
    private final class Values extends ImmutableList<V>
    {
        @Override
        public V get(final int n) {
            return RegularImmutableTable.this.getValue(n);
        }
        
        @Override
        boolean isPartialView() {
            return true;
        }
        
        @Override
        public int size() {
            return RegularImmutableTable.this.size();
        }
    }
}
