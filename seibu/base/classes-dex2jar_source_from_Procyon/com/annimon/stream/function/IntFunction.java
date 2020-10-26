// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface IntFunction<R>
{
    R apply(final int p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <R> IntFunction<R> safe(final ThrowableIntFunction<? extends R, Throwable> throwableIntFunction) {
            return safe(throwableIntFunction, (R)null);
        }
        
        public static <R> IntFunction<R> safe(final ThrowableIntFunction<? extends R, Throwable> throwableIntFunction, final R r) {
            return new IntFunction<R>() {
                @Override
                public R apply(final int n) {
                    try {
                        return throwableIntFunction.apply(n);
                    }
                    catch (Throwable t) {
                        return r;
                    }
                }
            };
        }
    }
}
