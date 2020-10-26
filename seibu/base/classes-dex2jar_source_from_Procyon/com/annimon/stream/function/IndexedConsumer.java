// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface IndexedConsumer<T>
{
    void accept(final int p0, final T p1);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T> IndexedConsumer<T> accept(final IntConsumer intConsumer, final Consumer<? super T> consumer) {
            return new IndexedConsumer<T>() {
                @Override
                public void accept(final int n, final T t) {
                    if (intConsumer != null) {
                        intConsumer.accept(n);
                    }
                    if (consumer != null) {
                        consumer.accept(t);
                    }
                }
            };
        }
        
        public static <T> IndexedConsumer<T> wrap(final Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            return new IndexedConsumer<T>() {
                @Override
                public void accept(final int n, final T t) {
                    consumer.accept(t);
                }
            };
        }
    }
}
