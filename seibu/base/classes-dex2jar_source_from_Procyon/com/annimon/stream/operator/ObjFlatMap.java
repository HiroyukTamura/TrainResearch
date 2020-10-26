// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Function;
import com.annimon.stream.Stream;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjFlatMap<T, R> extends LsaExtIterator<R>
{
    private Iterator<? extends R> inner;
    private Stream<? extends R> innerStream;
    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends Stream<? extends R>> mapper;
    
    public ObjFlatMap(final Iterator<? extends T> iterator, final Function<? super T, ? extends Stream<? extends R>> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    protected void nextIteration() {
        if (this.inner != null && this.inner.hasNext()) {
            this.next = (T)this.inner.next();
            this.hasNext = true;
        }
        else {
            while (this.iterator.hasNext()) {
                if (this.inner == null || !this.inner.hasNext()) {
                    if (this.innerStream != null) {
                        this.innerStream.close();
                        this.innerStream = null;
                    }
                    final Stream innerStream = (Stream)this.mapper.apply((Object)this.iterator.next());
                    if (innerStream != null) {
                        this.inner = innerStream.iterator();
                        this.innerStream = (Stream<? extends R>)innerStream;
                    }
                }
                if (this.inner != null && this.inner.hasNext()) {
                    this.next = (T)this.inner.next();
                    this.hasNext = true;
                    return;
                }
            }
            this.hasNext = false;
            if (this.innerStream != null) {
                this.innerStream.close();
                this.innerStream = null;
            }
        }
    }
}
