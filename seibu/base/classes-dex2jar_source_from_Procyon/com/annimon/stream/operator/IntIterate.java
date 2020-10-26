// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntIterate extends OfInt
{
    private int current;
    private final IntUnaryOperator op;
    
    public IntIterate(final int current, final IntUnaryOperator op) {
        this.op = op;
        this.current = current;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public int nextInt() {
        final int current = this.current;
        this.current = this.op.applyAsInt(this.current);
        return current;
    }
}
