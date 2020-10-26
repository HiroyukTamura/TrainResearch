// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.UnaryOperator;
import com.annimon.stream.iterator.LsaIterator;

public class ObjIterate<T> extends LsaIterator<T>
{
    private T current;
    private final UnaryOperator<T> op;
    
    public ObjIterate(final T current, final UnaryOperator<T> op) {
        this.op = op;
        this.current = current;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public T nextIteration() {
        final T current = this.current;
        this.current = this.op.apply(this.current);
        return current;
    }
}
