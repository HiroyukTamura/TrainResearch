// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjScanIdentity<T, R> extends LsaExtIterator<R>
{
    private final BiFunction<? super R, ? super T, ? extends R> accumulator;
    private final R identity;
    private final Iterator<? extends T> iterator;
    
    public ObjScanIdentity(final Iterator<? extends T> iterator, final R identity, final BiFunction<? super R, ? super T, ? extends R> accumulator) {
        this.iterator = iterator;
        this.identity = identity;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        if (!this.isInit) {
            this.hasNext = true;
            this.next = (T)this.identity;
        }
        else {
            this.hasNext = this.iterator.hasNext();
            if (this.hasNext) {
                this.next = (T)this.accumulator.apply((Object)this.next, (Object)this.iterator.next());
            }
        }
    }
}
