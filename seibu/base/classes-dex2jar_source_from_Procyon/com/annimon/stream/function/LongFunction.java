// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface LongFunction<R>
{
    R apply(final long p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <R> LongFunction<R> safe(final ThrowableLongFunction<? extends R, Throwable> throwableLongFunction) {
            return safe(throwableLongFunction, (R)null);
        }
        
        public static <R> LongFunction<R> safe(final ThrowableLongFunction<? extends R, Throwable> throwableLongFunction, final R r) {
            return new LongFunction<R>() {
                @Override
                public R apply(final long n) {
                    try {
                        return throwableLongFunction.apply(n);
                    }
                    catch (Throwable t) {
                        return r;
                    }
                }
            };
        }
    }
}
