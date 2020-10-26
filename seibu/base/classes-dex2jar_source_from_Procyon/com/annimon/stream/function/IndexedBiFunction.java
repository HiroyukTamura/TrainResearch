// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface IndexedBiFunction<T, U, R>
{
    R apply(final int p0, final T p1, final U p2);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T, U, R> IndexedBiFunction<T, U, R> wrap(final BiFunction<? super T, ? super U, ? extends R> biFunction) {
            Objects.requireNonNull(biFunction);
            return new IndexedBiFunction<T, U, R>() {
                @Override
                public R apply(final int n, final T t, final U u) {
                    return biFunction.apply(t, u);
                }
            };
        }
    }
}
