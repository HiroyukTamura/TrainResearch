// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleArray extends OfDouble
{
    private int index;
    private final double[] values;
    
    public DoubleArray(final double[] values) {
        this.values = values;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }
    
    @Override
    public double nextDouble() {
        return this.values[this.index++];
    }
}
