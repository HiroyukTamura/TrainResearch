// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongPeek extends OfLong
{
    private final LongConsumer action;
    private final OfLong iterator;
    
    public LongPeek(final OfLong iterator, final LongConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        final long nextLong = this.iterator.nextLong();
        this.action.accept(nextLong);
        return nextLong;
    }
}
