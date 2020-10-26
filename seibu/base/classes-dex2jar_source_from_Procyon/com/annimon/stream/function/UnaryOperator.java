// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T>
{
    public static class Util
    {
        private Util() {
        }
        
        public static <T> UnaryOperator<T> identity() {
            return new UnaryOperator<T>() {
                @Override
                public T apply(final T t) {
                    return t;
                }
            };
        }
    }
}
