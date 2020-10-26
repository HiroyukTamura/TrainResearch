// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.DoubleStream;
import com.annimon.stream.function.Function;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class ObjFlatMapToDouble<T> extends OfDouble
{
    private PrimitiveIterator.OfDouble inner;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends DoubleStream> mapper;
    
    public ObjFlatMapToDouble(final Iterator<? extends T> iterator, final Function<? super T, ? extends DoubleStream> mapper) {
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
                final DoubleStream doubleStream = (DoubleStream)this.mapper.apply((Object)this.iterator.next());
                if (doubleStream != null) {
                    this.inner = doubleStream.iterator();
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
