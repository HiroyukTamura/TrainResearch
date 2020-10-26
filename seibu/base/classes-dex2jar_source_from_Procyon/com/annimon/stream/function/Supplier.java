// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface Supplier<T>
{
    T get();
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T> Supplier<T> safe(final ThrowableSupplier<? extends T, Throwable> throwableSupplier) {
            return safe(throwableSupplier, (T)null);
        }
        
        public static <T> Supplier<T> safe(final ThrowableSupplier<? extends T, Throwable> throwableSupplier, final T t) {
            return new Supplier<T>() {
                @Override
                public T get() {
                    try {
                        return throwableSupplier.get();
                    }
                    catch (Throwable t) {
                        return t;
                    }
                }
            };
        }
    }
}
