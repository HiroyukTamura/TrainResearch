// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.LongStream;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongFlatMap extends OfLong
{
    private OfLong inner;
    private LongStream innerStream;
    private final OfLong iterator;
    private final LongFunction<? extends LongStream> mapper;
    
    public LongFlatMap(final OfLong iterator, final LongFunction<? extends LongStream> mapper) {
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
            final LongStream innerStream = (LongStream)this.mapper.apply(this.iterator.nextLong());
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
    public long nextLong() {
        if (this.inner == null) {
            throw new NoSuchElementException();
        }
        return this.inner.nextLong();
    }
}
