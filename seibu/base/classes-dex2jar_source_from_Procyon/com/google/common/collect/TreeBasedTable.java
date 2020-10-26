// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Collection;
import java.util.SortedSet;
import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V>
{
    private static final long serialVersionUID = 0L;
    private final Comparator<? super C> columnComparator;
    
    TreeBasedTable(final Comparator<? super R> comparator, final Comparator<? super C> columnComparator) {
        super(new TreeMap(comparator), new Factory(columnComparator));
        this.columnComparator = columnComparator;
    }
    
    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<R, C, V>(Ordering.natural(), Ordering.natural());
    }
    
    public static <R, C, V> TreeBasedTable<R, C, V> create(final TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        final TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<R, C, V>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll((Table)treeBasedTable);
        return treeBasedTable2;
    }
    
    public static <R, C, V> TreeBasedTable<R, C, V> create(final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<R, C, V>(comparator, comparator2);
    }
    
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }
    
    @Override
    Iterator<C> createColumnKeyIterator() {
        final Comparator<? super C> columnComparator = this.columnComparator();
        return new AbstractIterator<C>() {
            C lastValue;
            final /* synthetic */ Iterator val$merged = Iterators.mergeSorted(Iterables.transform((Iterable<Map<C, V>>)TreeBasedTable.this.backingMap.values(), (Function<? super Map<C, V>, ? extends Iterator<?>>)new Function<Map<C, V>, Iterator<C>>(this) {
                @Override
                public Iterator<C> apply(final Map<C, V> map) {
                    return map.keySet().iterator();
                }
            }), (Comparator<? super Object>)columnComparator);
            
            @Override
            protected C computeNext() {
                while (this.val$merged.hasNext()) {
                    final C next = this.val$merged.next();
                    int n;
                    if (this.lastValue != null && columnComparator.compare(next, this.lastValue) == 0) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (n == 0) {
                        return this.lastValue = next;
                    }
                }
                this.lastValue = null;
                return this.endOfData();
            }
        };
    }
    
    @Override
    public SortedMap<C, V> row(final R r) {
        return new TreeRow(r);
    }
    
    public Comparator<? super R> rowComparator() {
        return this.rowKeySet().comparator();
    }
    
    @Override
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }
    
    @Override
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }
    
    private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Comparator<? super C> comparator;
        
        Factory(final Comparator<? super C> comparator) {
            this.comparator = comparator;
        }
        
        @Override
        public TreeMap<C, V> get() {
            return new TreeMap<C, V>(this.comparator);
        }
    }
    
    private class TreeRow extends Row implements SortedMap<C, V>
    {
        @Nullable
        final C lowerBound;
        @Nullable
        final C upperBound;
        transient SortedMap<C, V> wholeRow;
        
        TreeRow(final TreeBasedTable treeBasedTable, final R r) {
            this(r, null, null);
        }
        
        TreeRow(@Nullable final R r, @Nullable final C lowerBound, final C upperBound) {
            (StandardTable<R, C, V>)TreeBasedTable.this.super(r);
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            Preconditions.checkArgument(lowerBound == null || upperBound == null || this.compare(lowerBound, upperBound) <= 0);
        }
        
        SortedMap<C, V> backingRowMap() {
            return (SortedMap<C, V>)(SortedMap)super.backingRowMap();
        }
        
        @Override
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }
        
        int compare(final Object o, final Object o2) {
            return this.comparator().compare((Object)o, (Object)o2);
        }
        
        SortedMap<C, V> computeBackingRowMap() {
            final SortedMap<C, V> wholeRow = this.wholeRow();
            if (wholeRow != null) {
                SortedMap<C, V> tailMap = wholeRow;
                if (this.lowerBound != null) {
                    tailMap = wholeRow.tailMap(this.lowerBound);
                }
                SortedMap<C, V> headMap = tailMap;
                if (this.upperBound != null) {
                    headMap = tailMap.headMap(this.upperBound);
                }
                return headMap;
            }
            return null;
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return this.rangeContains(o) && super.containsKey(o);
        }
        
        @Override
        public C firstKey() {
            if (this.backingRowMap() == null) {
                throw new NoSuchElementException();
            }
            return this.backingRowMap().firstKey();
        }
        
        @Override
        public SortedMap<C, V> headMap(final C c) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return new TreeRow((R)this.rowKey, this.lowerBound, c);
        }
        
        @Override
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet<C, Object>(this);
        }
        
        @Override
        public C lastKey() {
            if (this.backingRowMap() == null) {
                throw new NoSuchElementException();
            }
            return this.backingRowMap().lastKey();
        }
        
        @Override
        void maintainEmptyInvariant() {
            if (this.wholeRow() != null && this.wholeRow.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.rowKey);
                this.wholeRow = null;
                this.backingRowMap = null;
            }
        }
        
        @Override
        public V put(final C c, final V v) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return super.put(c, v);
        }
        
        boolean rangeContains(@Nullable final Object o) {
            return o != null && (this.lowerBound == null || this.compare(this.lowerBound, o) <= 0) && (this.upperBound == null || this.compare(this.upperBound, o) > 0);
        }
        
        @Override
        public SortedMap<C, V> subMap(final C c, final C c2) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)) && this.rangeContains(Preconditions.checkNotNull(c2)));
            return new TreeRow((R)this.rowKey, c, c2);
        }
        
        @Override
        public SortedMap<C, V> tailMap(final C c) {
            Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(c)));
            return new TreeRow((R)this.rowKey, c, this.upperBound);
        }
        
        SortedMap<C, V> wholeRow() {
            if (this.wholeRow == null || (this.wholeRow.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey))) {
                this.wholeRow = (SortedMap<C, V>)(SortedMap)TreeBasedTable.this.backingMap.get(this.rowKey);
            }
            return this.wholeRow;
        }
    }
}
