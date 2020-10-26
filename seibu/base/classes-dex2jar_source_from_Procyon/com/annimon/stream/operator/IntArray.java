// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntArray extends OfInt
{
    private int index;
    private final int[] values;
    
    public IntArray(final int[] values) {
        this.values = values;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }
    
    @Override
    public int nextInt() {
        return this.values[this.index++];
    }
}
