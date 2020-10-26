// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Supplier;
import com.annimon.stream.iterator.LsaIterator;

public class ObjGenerate<T> extends LsaIterator<T>
{
    private final Supplier<T> supplier;
    
    public ObjGenerate(final Supplier<T> supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public T nextIteration() {
        return this.supplier.get();
    }
}
