// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntPeek extends OfInt
{
    private final IntConsumer action;
    private final OfInt iterator;
    
    public IntPeek(final OfInt iterator, final IntConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        final int nextInt = this.iterator.nextInt();
        this.action.accept(nextInt);
        return nextInt;
    }
}
