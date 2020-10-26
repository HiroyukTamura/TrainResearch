// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.ToDoubleFunction;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class ObjMapToDouble<T> extends OfDouble
{
    private final Iterator<? extends T> iterator;
    private final ToDoubleFunction<? super T> mapper;
    
    public ObjMapToDouble(final Iterator<? extends T> iterator, final ToDoubleFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        return this.mapper.applyAsDouble((Object)this.iterator.next());
    }
}
