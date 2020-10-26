// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.ToLongFunction;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class ObjMapToLong<T> extends OfLong
{
    private final Iterator<? extends T> iterator;
    private final ToLongFunction<? super T> mapper;
    
    public ObjMapToLong(final Iterator<? extends T> iterator, final ToLongFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        return this.mapper.applyAsLong((Object)this.iterator.next());
    }
}
