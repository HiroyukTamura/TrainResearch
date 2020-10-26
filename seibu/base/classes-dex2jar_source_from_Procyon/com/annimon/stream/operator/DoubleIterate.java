// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleIterate extends OfDouble
{
    private double current;
    private final DoubleUnaryOperator op;
    
    public DoubleIterate(final double current, final DoubleUnaryOperator op) {
        this.op = op;
        this.current = current;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public double nextDouble() {
        final double current = this.current;
        this.current = this.op.applyAsDouble(this.current);
        return current;
    }
}
