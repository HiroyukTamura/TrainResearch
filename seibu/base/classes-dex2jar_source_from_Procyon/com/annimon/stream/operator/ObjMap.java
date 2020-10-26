// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Function;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaIterator;

public class ObjMap<T, R> extends LsaIterator<R>
{
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends R> mapper;
    
    public ObjMap(final Iterator<? extends T> iterator, final Function<? super T, ? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public R nextIteration() {
        return (R)this.mapper.apply((Object)this.iterator.next());
    }
}
