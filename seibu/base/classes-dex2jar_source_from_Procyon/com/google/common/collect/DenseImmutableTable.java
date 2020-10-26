// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Immutable
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V>
{
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, Map<C, V>> rowMap;
    private final V[][] values;
    
    DenseImmutableTable(final ImmutableList<Cell<R, C, V>> list, final ImmutableSet<R> set, final ImmutableSet<C> set2) {
        this.values = (V[][])Array.newInstance(Object.class, set.size(), set2.size());
        this.rowKeyToIndex = makeIndex(set);
        this.columnKeyToIndex = makeIndex(set2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        final int[] iterationOrderRow = new int[list.size()];
        final int[] iterationOrderColumn = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            final Table.Cell<Object, C, V> cell = list.get(i);
            final Object rowKey = cell.getRowKey();
            final C columnKey = cell.getColumnKey();
            final int intValue = this.rowKeyToIndex.get(rowKey);
            final int intValue2 = this.columnKeyToIndex.get(columnKey);
            Preconditions.checkArgument(this.values[intValue][intValue2] == null, "duplicate key: (%s, %s)", rowKey, columnKey);
            this.values[intValue][intValue2] = (V)cell.getValue();
            final int[] rowCounts = this.rowCounts;
            ++rowCounts[intValue];
            final int[] columnCounts = this.columnCounts;
            ++columnCounts[intValue2];
            iterationOrderRow[i] = intValue;
            iterationOrderColumn[i] = intValue2;
        }
        this.iterationOrderRow = iterationOrderRow;
        this.iterationOrderColumn = iterationOrderColumn;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }
    
    private static <E> ImmutableMap<E, Integer> makeIndex(final ImmutableSet<E> set) {
        final ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        int i = 0;
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            builder.put(iterator.next(), i);
            ++i;
        }
        return builder.build();
    }
    
    @Override
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }
    
    @Override
    public V get(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = this.rowKeyToIndex.get(o);
        final Integer n2 = this.columnKeyToIndex.get(o2);
        if (n == null || n2 == null) {
            return null;
        }
        return this.values[n][n2];
    }
    
    @Override
    Cell<R, C, V> getCell(int n) {
        final int n2 = this.iterationOrderRow[n];
        n = this.iterationOrderColumn[n];
        return ImmutableTable.cellOf(this.rowKeySet().asList().get(n2), this.columnKeySet().asList().get(n), this.values[n2][n]);
    }
    
    @Override
    V getValue(final int n) {
        return this.values[this.iterationOrderRow[n]][this.iterationOrderColumn[n]];
    }
    
    @Override
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }
    
    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }
    
    private final class Column extends ImmutableArrayMap<R, V>
    {
        private final int columnIndex;
        
        Column(final int columnIndex) {
            super(DenseImmutableTable.this.columnCounts[columnIndex]);
            this.columnIndex = columnIndex;
        }
        
        @Override
        V getValue(final int n) {
            return DenseImmutableTable.this.values[n][this.columnIndex];
        }
        
        @Override
        boolean isPartialView() {
            return true;
        }
        
        @Override
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }
    
    private final class ColumnMap extends ImmutableArrayMap<C, Map<R, V>>
    {
        private ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }
        
        Map<R, V> getValue(final int n) {
            return new Column(n);
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }
    
    private abstract static class ImmutableArrayMap<K, V> extends ImmutableMap<K, V>
    {
        private final int size;
        
        ImmutableArrayMap(final int size) {
            this.size = size;
        }
        
        private boolean isFull() {
            return this.size == this.keyToIndex().size();
        }
        
        @Override
        ImmutableSet<Entry<K, V>> createEntrySet() {
            return (ImmutableSet<Entry<K, V>>)new ImmutableMapEntrySet<K, V>() {
                @Override
                public UnmodifiableIterator<Entry<K, V>> iterator() {
                    return new AbstractIterator<Entry<K, V>>() {
                        private int index = -1;
                        private final int maxIndex = ImmutableArrayMap.this.keyToIndex().size();
                        
                        @Override
                        protected Entry<K, V> computeNext() {
                            ++this.index;
                            while (this.index < this.maxIndex) {
                                final V value = ImmutableArrayMap.this.getValue(this.index);
                                if (value != null) {
                                    return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), value);
                                }
                                ++this.index;
                            }
                            return (Entry<K, V>)((AbstractIterator<Map.Entry>)this).endOfData();
                        }
                    };
                }
                
                @Override
                ImmutableMap<K, V> map() {
                    return (ImmutableMap<K, V>)ImmutableArrayMap.this;
                }
            };
        }
        
        @Override
        ImmutableSet<K> createKeySet() {
            if (this.isFull()) {
                return this.keyToIndex().keySet();
            }
            return super.createKeySet();
        }
        
        @Override
        public V get(@Nullable final Object o) {
            final Integer n = this.keyToIndex().get(o);
            if (n == null) {
                return null;
            }
            return this.getValue(n);
        }
        
        K getKey(final int n) {
            return (K)this.keyToIndex().keySet().asList().get(n);
        }
        
        @Nullable
        abstract V getValue(final int p0);
        
        abstract ImmutableMap<K, Integer> keyToIndex();
        
        @Override
        public int size() {
            return this.size;
        }
    }
    
    private final class Row extends ImmutableArrayMap<C, V>
    {
        private final int rowIndex;
        
        Row(final int rowIndex) {
            super(DenseImmutableTable.this.rowCounts[rowIndex]);
            this.rowIndex = rowIndex;
        }
        
        @Override
        V getValue(final int n) {
            return DenseImmutableTable.this.values[this.rowIndex][n];
        }
        
        @Override
        boolean isPartialView() {
            return true;
        }
        
        @Override
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }
    
    private final class RowMap extends ImmutableArrayMap<R, Map<C, V>>
    {
        private RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }
        
        Map<C, V> getValue(final int n) {
            return new Row(n);
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }
}
