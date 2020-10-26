// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.IntStream;
import com.annimon.stream.function.Function;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class ObjFlatMapToInt<T> extends OfInt
{
    private PrimitiveIterator.OfInt inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends IntStream> mapper;
    
    public ObjFlatMapToInt(final Iterator<? extends T> iterator, final Function<? super T, ? extends IntStream> mapper) {
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
                final IntStream intStream = (IntStream)this.mapper.apply((Object)this.iterator.next());
                if (intStream != null) {
                    this.inner = intStream.iterator();
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
