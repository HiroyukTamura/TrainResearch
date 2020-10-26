// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.BiConsumer;

public interface Collector<T, A, R>
{
    BiConsumer<A, T> accumulator();
    
    Function<A, R> finisher();
    
    Supplier<A> supplier();
}
