// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.LongStream;
import com.annimon.stream.function.Function;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class ObjFlatMapToLong<T> extends OfLong
{
    private PrimitiveIterator.OfLong inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends LongStream> mapper;
    
    public ObjFlatMapToLong(final Iterator<? extends T> iterator, final Function<? super T, ? extends LongStream> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    protected void nextIteration() {
        if (this.inner != null && this.inner.hasNext()) {
            this.next = this.inner.next();
            this.hasNext = true;
            return;
        }
        while (this.iterator.hasNext()) {
            if (this.inner == null || !this.inner.hasNext()) {
                final LongStream longStream = (LongStream)this.mapper.apply((Object)this.iterator.next());
                if (longStream != null) {
                    this.inner = longStream.iterator();
                }
            }
            if (this.inner != null && this.inner.hasNext()) {
                this.next = this.inner.next();
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
}
