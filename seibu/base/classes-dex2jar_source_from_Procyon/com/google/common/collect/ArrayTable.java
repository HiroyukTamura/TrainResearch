// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Collection;
import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;
import java.io.Serializable;

@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable
{
    private static final long serialVersionUID = 0L;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ColumnMap columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient RowMap rowMap;
    
    private ArrayTable(final ArrayTable<R, C, V> arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        final Object[][] array = (Object[][])Array.newInstance(Object.class, this.rowList.size(), this.columnList.size());
        this.array = (V[][])array;
        this.eraseAll();
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(arrayTable.array[i], 0, array[i], 0, arrayTable.array[i].length);
        }
    }
    
    private ArrayTable(final Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        this.putAll((Table<? extends R, ? extends C, ? extends V>)table);
    }
    
    private ArrayTable(final Iterable<? extends R> iterable, final Iterable<? extends C> iterable2) {
        final boolean b = true;
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(!this.rowList.isEmpty());
        Preconditions.checkArgument(!this.columnList.isEmpty() && b);
        this.rowKeyToIndex = index(this.rowList);
        this.columnKeyToIndex = index(this.columnList);
        this.array = (V[][])Array.newInstance(Object.class, this.rowList.size(), this.columnList.size());
        this.eraseAll();
    }
    
    public static <R, C, V> ArrayTable<R, C, V> create(final Table<R, C, V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<R, C, V>((ArrayTable<R, C, V>)table);
        }
        return new ArrayTable<R, C, V>((Table<Object, Object, Object>)table);
    }
    
    public static <R, C, V> ArrayTable<R, C, V> create(final Iterable<? extends R> iterable, final Iterable<? extends C> iterable2) {
        return new ArrayTable<R, C, V>(iterable, iterable2);
    }
    
    private static <E> ImmutableMap<E, Integer> index(final List<E> list) {
        final ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        for (int i = 0; i < list.size(); ++i) {
            builder.put(list.get(i), i);
        }
        return builder.build();
    }
    
    public V at(final int n, final int n2) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        return this.array[n][n2];
    }
    
    @Override
    Iterator<Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Cell<R, C, V>>(this.size()) {
            @Override
            protected Cell<R, C, V> get(final int n) {
                return new Tables.AbstractCell<R, C, V>() {
                    final int columnIndex = n % ArrayTable.this.columnList.size();
                    final int rowIndex = n / ArrayTable.this.columnList.size();
                    
                    @Override
                    public C getColumnKey() {
                        return (C)ArrayTable.this.columnList.get(this.columnIndex);
                    }
                    
                    @Override
                    public R getRowKey() {
                        return (R)ArrayTable.this.rowList.get(this.rowIndex);
                    }
                    
                    @Override
                    public V getValue() {
                        return ArrayTable.this.at(this.rowIndex, this.columnIndex);
                    }
                };
            }
        };
    }
    
    @Override
    public Set<Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }
    
    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Map<R, V> column(final C c) {
        Preconditions.checkNotNull(c);
        final Integer n = this.columnKeyToIndex.get(c);
        if (n == null) {
            return (Map<R, V>)ImmutableMap.of();
        }
        return new Column(n);
    }
    
    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }
    
    @Override
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }
    
    @Override
    public Map<C, Map<R, V>> columnMap() {
        ColumnMap columnMap;
        if ((columnMap = this.columnMap) == null) {
            columnMap = new ColumnMap();
            this.columnMap = columnMap;
        }
        return columnMap;
    }
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return this.containsRow(o) && this.containsColumn(o2);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        return this.columnKeyToIndex.containsKey(o);
    }
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return this.rowKeyToIndex.containsKey(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        final V[][] array = this.array;
        for (int length = array.length, i = 0; i < length; ++i) {
            final V[] array2 = array[i];
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                if (Objects.equal(o, array2[j])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public V erase(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = this.rowKeyToIndex.get(o);
        final Integer n2 = this.columnKeyToIndex.get(o2);
        if (n == null || n2 == null) {
            return null;
        }
        return this.set(n, n2, null);
    }
    
    public void eraseAll() {
        final V[][] array = this.array;
        for (int length = array.length, i = 0; i < length; ++i) {
            Arrays.fill(array[i], null);
        }
    }
    
    @Override
    public V get(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = this.rowKeyToIndex.get(o);
        final Integer n2 = this.columnKeyToIndex.get(o2);
        if (n == null || n2 == null) {
            return null;
        }
        return this.at(n, n2);
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public V put(final R r, final C c, @Nullable final V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        final Integer n = this.rowKeyToIndex.get(r);
        Preconditions.checkArgument(n != null, "Row %s not in %s", r, this.rowList);
        final Integer n2 = this.columnKeyToIndex.get(c);
        Preconditions.checkArgument(n2 != null, "Column %s not in %s", c, this.columnList);
        return this.set(n, n2, v);
    }
    
    @Override
    public void putAll(final Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }
    
    @Deprecated
    @Override
    public V remove(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Map<C, V> row(final R r) {
        Preconditions.checkNotNull(r);
        final Integer n = this.rowKeyToIndex.get(r);
        if (n == null) {
            return (Map<C, V>)ImmutableMap.of();
        }
        return new Row(n);
    }
    
    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }
    
    @Override
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }
    
    @Override
    public Map<R, Map<C, V>> rowMap() {
        RowMap rowMap;
        if ((rowMap = this.rowMap) == null) {
            rowMap = new RowMap();
            this.rowMap = rowMap;
        }
        return rowMap;
    }
    
    public V set(final int n, final int n2, @Nullable final V v) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        final V v2 = this.array[n][n2];
        this.array[n][n2] = v;
        return v2;
    }
    
    @Override
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }
    
    @GwtIncompatible("reflection")
    public V[][] toArray(final Class<V> componentType) {
        final Object[][] array = (Object[][])Array.newInstance(componentType, this.rowList.size(), this.columnList.size());
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(this.array[i], 0, array[i], 0, this.array[i].length);
        }
        return (V[][])array;
    }
    
    @Override
    public Collection<V> values() {
        return super.values();
    }
    
    private abstract static class ArrayMap<K, V> extends ImprovedAbstractMap<K, V>
    {
        private final ImmutableMap<K, Integer> keyIndex;
        
        private ArrayMap(final ImmutableMap<K, Integer> keyIndex) {
            this.keyIndex = keyIndex;
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.keyIndex.containsKey(o);
        }
        
        protected Set<Entry<K, V>> createEntrySet() {
            return (Set<Entry<K, V>>)new Maps.EntrySet<K, V>() {
                @Override
                public Iterator<Entry<K, V>> iterator() {
                    return new AbstractIndexedListIterator<Entry<K, V>>(((Maps.EntrySet)this).size()) {
                        @Override
                        protected Entry<K, V> get(final int n) {
                            return new AbstractMapEntry<K, V>() {
                                @Override
                                public K getKey() {
                                    return ArrayMap.this.getKey(n);
                                }
                                
                                @Override
                                public V getValue() {
                                    return ArrayMap.this.getValue(n);
                                }
                                
                                @Override
                                public V setValue(final V v) {
                                    return ArrayMap.this.setValue(n, v);
                                }
                            };
                        }
                    };
                }
                
                @Override
                Map<K, V> map() {
                    return (Map<K, V>)ArrayMap.this;
                }
            };
        }
        
        @Override
        public V get(@Nullable final Object o) {
            final Integer n = this.keyIndex.get(o);
            if (n == null) {
                return null;
            }
            return this.getValue(n);
        }
        
        K getKey(final int n) {
            return (K)this.keyIndex.keySet().asList().get(n);
        }
        
        abstract String getKeyRole();
        
        @Nullable
        abstract V getValue(final int p0);
        
        @Override
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }
        
        @Override
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }
        
        @Override
        public V put(final K obj, final V v) {
            final Integer n = this.keyIndex.get(obj);
            if (n == null) {
                final String value = String.valueOf(String.valueOf(this.getKeyRole()));
                final String value2 = String.valueOf(String.valueOf(obj));
                final String value3 = String.valueOf(String.valueOf(this.keyIndex.keySet()));
                throw new IllegalArgumentException(new StringBuilder(value.length() + 9 + value2.length() + value3.length()).append(value).append(" ").append(value2).append(" not in ").append(value3).toString());
            }
            return this.setValue(n, v);
        }
        
        @Override
        public V remove(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Nullable
        abstract V setValue(final int p0, final V p1);
        
        @Override
        public int size() {
            return this.keyIndex.size();
        }
    }
    
    private class Column extends ArrayMap<R, V>
    {
        final int columnIndex;
        
        Column(final int columnIndex) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = columnIndex;
        }
        
        @Override
        String getKeyRole() {
            return "Row";
        }
        
        @Override
        V getValue(final int n) {
            return ArrayTable.this.at(n, this.columnIndex);
        }
        
        @Override
        V setValue(final int n, final V v) {
            return ArrayTable.this.set(n, this.columnIndex, v);
        }
    }
    
    private class ColumnMap extends ArrayMap<C, Map<R, V>>
    {
        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }
        
        @Override
        String getKeyRole() {
            return "Column";
        }
        
        Map<R, V> getValue(final int n) {
            return new Column(n);
        }
        
        @Override
        public Map<R, V> put(final C c, final Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
        
        Map<R, V> setValue(final int n, final Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }
    
    private class Row extends ArrayMap<C, V>
    {
        final int rowIndex;
        
        Row(final int rowIndex) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = rowIndex;
        }
        
        @Override
        String getKeyRole() {
            return "Column";
        }
        
        @Override
        V getValue(final int n) {
            return ArrayTable.this.at(this.rowIndex, n);
        }
        
        @Override
        V setValue(final int n, final V v) {
            return ArrayTable.this.set(this.rowIndex, n, v);
        }
    }
    
    private class RowMap extends ArrayMap<R, Map<C, V>>
    {
        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }
        
        @Override
        String getKeyRole() {
            return "Row";
        }
        
        Map<C, V> getValue(final int n) {
            return new Row(n);
        }
        
        @Override
        public Map<C, V> put(final R r, final Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
        
        Map<C, V> setValue(final int n, final Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }
}
