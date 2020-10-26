// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface BiFunction<T, U, R>
{
    R apply(final T p0, final U p1);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T, U, R, V> BiFunction<T, U, V> andThen(final BiFunction<? super T, ? super U, ? extends R> biFunction, final Function<? super R, ? extends V> function) {
            return new BiFunction<T, U, V>() {
                @Override
                public V apply(final T t, final U u) {
                    return function.apply(biFunction.apply(t, u));
                }
            };
        }
        
        public static <T, U, R> BiFunction<U, T, R> reverse(final BiFunction<? super T, ? super U, ? extends R> biFunction) {
            Objects.requireNonNull(biFunction);
            return new BiFunction<U, T, R>() {
                @Override
                public R apply(final U u, final T t) {
                    return biFunction.apply(t, u);
                }
            };
        }
    }
}
