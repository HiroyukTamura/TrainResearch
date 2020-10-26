// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Immutable
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V>
{
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    private final ImmutableMap<R, Map<C, V>> rowMap;
    
    SparseImmutableTable(final ImmutableList<Cell<R, C, V>> list, final ImmutableSet<R> set, final ImmutableSet<C> set2) {
        final HashMap<Object, Object> hashMap = Maps.newHashMap();
        final LinkedHashMap<Object, Object> linkedHashMap = Maps.newLinkedHashMap();
        for (final Object next : set) {
            hashMap.put(next, linkedHashMap.size());
            linkedHashMap.put(next, new LinkedHashMap<Object, Object>());
        }
        final LinkedHashMap<Object, Object> linkedHashMap2 = Maps.newLinkedHashMap();
        final Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            linkedHashMap2.put(iterator2.next(), new LinkedHashMap<Object, Object>());
        }
        final int[] iterationOrderRow = new int[list.size()];
        final int[] iterationOrderColumn = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            final Table.Cell<Object, C, V> cell = list.get(i);
            final Object rowKey = cell.getRowKey();
            final C columnKey = cell.getColumnKey();
            final V value = cell.getValue();
            iterationOrderRow[i] = hashMap.get(rowKey);
            final LinkedHashMap<Object, Object> linkedHashMap3 = linkedHashMap.get(rowKey);
            iterationOrderColumn[i] = linkedHashMap3.size();
            final V put = linkedHashMap3.put(columnKey, value);
            if (put != null) {
                final String value2 = String.valueOf(String.valueOf(rowKey));
                final String value3 = String.valueOf(String.valueOf(columnKey));
                final String value4 = String.valueOf(String.valueOf(value));
                final String value5 = String.valueOf(String.valueOf(put));
                throw new IllegalArgumentException(new StringBuilder(value2.length() + 37 + value3.length() + value4.length() + value5.length()).append("Duplicate value for row=").append(value2).append(", column=").append(value3).append(": ").append(value4).append(", ").append(value5).toString());
            }
            linkedHashMap2.get(columnKey).put(rowKey, value);
        }
        this.iterationOrderRow = iterationOrderRow;
        this.iterationOrderColumn = iterationOrderColumn;
        final ImmutableMap.Builder<R, ImmutableMap<Object, Object>> builder = ImmutableMap.builder();
        for (final Map.Entry<Object, Object> entry : linkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map<?, ?>)entry.getValue()));
        }
        this.rowMap = (ImmutableMap<R, Map<C, V>>)builder.build();
        final ImmutableMap.Builder<C, ImmutableMap<Object, Object>> builder2 = ImmutableMap.builder();
        for (final Map.Entry<Object, LinkedHashMap<Object, Object>> entry2 : linkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map<?, ?>)entry2.getValue()));
        }
        this.columnMap = (ImmutableMap<C, Map<R, V>>)builder2.build();
    }
    
    @Override
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }
    
    @Override
    Cell<R, C, V> getCell(int n) {
        final Map.Entry<K, ImmutableMap> entry = this.rowMap.entrySet().asList().get(this.iterationOrderRow[n]);
        final ImmutableMap immutableMap = entry.getValue();
        n = this.iterationOrderColumn[n];
        final Map.Entry entry2 = (Map.Entry)immutableMap.entrySet().asList().get(n);
        return ImmutableTable.cellOf((R)entry.getKey(), (C)entry2.getKey(), (V)entry2.getValue());
    }
    
    @Override
    V getValue(int n) {
        final ImmutableMap immutableMap = this.rowMap.values().asList().get(this.iterationOrderRow[n]);
        n = this.iterationOrderColumn[n];
        return (V)immutableMap.values().asList().get(n);
    }
    
    @Override
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }
    
    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }
}
