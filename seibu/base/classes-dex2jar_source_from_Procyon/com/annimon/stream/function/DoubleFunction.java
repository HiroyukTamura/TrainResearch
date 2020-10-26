// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface DoubleFunction<R>
{
    R apply(final double p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <R> DoubleFunction<R> safe(final ThrowableDoubleFunction<? extends R, Throwable> throwableDoubleFunction) {
            return safe(throwableDoubleFunction, (R)null);
        }
        
        public static <R> DoubleFunction<R> safe(final ThrowableDoubleFunction<? extends R, Throwable> throwableDoubleFunction, final R r) {
            return new DoubleFunction<R>() {
                @Override
                public R apply(final double n) {
                    try {
                        return throwableDoubleFunction.apply(n);
                    }
                    catch (Throwable t) {
                        return r;
                    }
                }
            };
        }
    }
}
