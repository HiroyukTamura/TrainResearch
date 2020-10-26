// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongArray extends OfLong
{
    private int index;
    private final long[] values;
    
    public LongArray(final long[] values) {
        this.values = values;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }
    
    @Override
    public long nextLong() {
        return this.values[this.index++];
    }
}
