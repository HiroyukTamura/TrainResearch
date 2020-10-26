// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.IntStream;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntFlatMap extends OfInt
{
    private OfInt inner;
    private IntStream innerStream;
    private final OfInt iterator;
    private final IntFunction<? extends IntStream> mapper;
    
    public IntFlatMap(final OfInt iterator, final IntFunction<? extends IntStream> mapper) {
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
            final IntStream innerStream = (IntStream)this.mapper.apply(this.iterator.nextInt());
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
    public int nextInt() {
        if (this.inner == null) {
            throw new NoSuchElementException();
        }
        return this.inner.nextInt();
    }
}
