// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface IndexedFunction<T, R>
{
    R apply(final int p0, final T p1);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T, R> IndexedFunction<T, R> wrap(final Function<? super T, ? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedFunction<T, R>() {
                @Override
                public R apply(final int n, final T t) {
                    return function.apply(t);
                }
            };
        }
    }
}
