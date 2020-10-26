// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.DoubleStream;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleFlatMap extends OfDouble
{
    private OfDouble inner;
    private DoubleStream innerStream;
    private final OfDouble iterator;
    private final DoubleFunction<? extends DoubleStream> mapper;
    
    public DoubleFlatMap(final OfDouble iterator, final DoubleFunction<? extends DoubleStream> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        if (this.inner != null && this.inner.hasNext()) {
            return true;
        }
        while (this.iterator.hasNext()) {
            if (this.innerStream != null) {
                this.innerStream.close();
                this.innerStream = null;
            }
            final DoubleStream innerStream = (DoubleStream)this.mapper.apply(this.iterator.nextDouble());
            if (innerStream != null) {
                this.innerStream = innerStream;
                if (innerStream.iterator().hasNext()) {
                    this.inner = innerStream.iterator();
                    return true;
                }
                continue;
            }
        }
        if (this.innerStream != null) {
            this.innerStream.close();
            this.innerStream = null;
        }
        return false;
    }
    
    @Override
    public double nextDouble() {
        if (this.inner == null) {
            throw new NoSuchElementException();
        }
        return this.inner.nextDouble();
    }
}
