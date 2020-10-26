// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaIterator;

public class ObjZip<F, S, R> extends LsaIterator<R>
{
    private final BiFunction<? super F, ? super S, ? extends R> combiner;
    private final Iterator<? extends F> iterator1;
    private final Iterator<? extends S> iterator2;
    
    public ObjZip(final Iterator<? extends F> iterator1, final Iterator<? extends S> iterator2, final BiFunction<? super F, ? super S, ? extends R> combiner) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.combiner = combiner;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator1.hasNext() && this.iterator2.hasNext();
    }
    
    @Override
    public R nextIteration() {
        return (R)this.combiner.apply((Object)this.iterator1.next(), (Object)this.iterator2.next());
    }
}
