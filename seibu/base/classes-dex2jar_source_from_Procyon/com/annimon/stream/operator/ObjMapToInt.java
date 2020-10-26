// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.ToIntFunction;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class ObjMapToInt<T> extends OfInt
{
    private final Iterator<? extends T> iterator;
    private final ToIntFunction<? super T> mapper;
    
    public ObjMapToInt(final Iterator<? extends T> iterator, final ToIntFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        return this.mapper.applyAsInt((Object)this.iterator.next());
    }
}
