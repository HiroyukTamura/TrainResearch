// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoublePeek extends OfDouble
{
    private final DoubleConsumer action;
    private final OfDouble iterator;
    
    public DoublePeek(final OfDouble iterator, final DoubleConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        final double nextDouble = this.iterator.nextDouble();
        this.action.accept(nextDouble);
        return nextDouble;
    }
}
