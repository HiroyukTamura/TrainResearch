// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongIterate extends OfLong
{
    private long current;
    private final LongUnaryOperator op;
    
    public LongIterate(final long current, final LongUnaryOperator op) {
        this.op = op;
        this.current = current;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public long nextLong() {
        final long current = this.current;
        this.current = this.op.applyAsLong(this.current);
        return current;
    }
}
