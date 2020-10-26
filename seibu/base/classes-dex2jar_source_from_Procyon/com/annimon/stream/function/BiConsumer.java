// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface BiConsumer<T, U>
{
    void accept(final T p0, final U p1);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T, U> BiConsumer<T, U> andThen(final BiConsumer<? super T, ? super U> biConsumer, final BiConsumer<? super T, ? super U> biConsumer2) {
            return new BiConsumer<T, U>() {
                @Override
                public void accept(final T t, final U u) {
                    biConsumer.accept(t, u);
                    biConsumer2.accept(t, u);
                }
            };
        }
    }
}
