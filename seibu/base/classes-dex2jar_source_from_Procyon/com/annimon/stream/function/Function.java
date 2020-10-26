// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface Function<T, R>
{
    R apply(final T p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T, R, V> Function<T, V> andThen(final Function<? super T, ? extends R> function, final Function<? super R, ? extends V> function2) {
            return new Function<T, V>() {
                @Override
                public V apply(final T t) {
                    return function2.apply(function.apply(t));
                }
            };
        }
        
        public static <V, T, R> Function<V, R> compose(final Function<? super T, ? extends R> function, final Function<? super V, ? extends T> function2) {
            return andThen((Function<? super V, ?>)function2, (Function<? super Object, ? extends R>)function);
        }
        
        public static <T, R> Function<T, R> safe(final ThrowableFunction<? super T, ? extends R, Throwable> throwableFunction) {
            return safe(throwableFunction, (R)null);
        }
        
        public static <T, R> Function<T, R> safe(final ThrowableFunction<? super T, ? extends R, Throwable> throwableFunction, final R r) {
            return new Function<T, R>() {
                @Override
                public R apply(final T t) {
                    try {
                        return throwableFunction.apply(t);
                    }
                    catch (Throwable t2) {
                        return r;
                    }
                }
            };
        }
    }
}
