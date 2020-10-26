// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface Consumer<T>
{
    void accept(final T p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T> Consumer<T> andThen(final Consumer<? super T> consumer, final Consumer<? super T> consumer2) {
            return new Consumer<T>() {
                @Override
                public void accept(final T t) {
                    consumer.accept(t);
                    consumer2.accept(t);
                }
            };
        }
        
        public static <T> Consumer<T> safe(final ThrowableConsumer<? super T, Throwable> throwableConsumer) {
            return safe(throwableConsumer, (Consumer<? super T>)null);
        }
        
        public static <T> Consumer<T> safe(final ThrowableConsumer<? super T, Throwable> throwableConsumer, final Consumer<? super T> consumer) {
            return new Consumer<T>() {
                @Override
                public void accept(final T t) {
                    Objects.requireNonNull(throwableConsumer);
                    try {
                        throwableConsumer.accept(t);
                    }
                    catch (Throwable t2) {
                        if (consumer != null) {
                            consumer.accept(t);
                        }
                    }
                }
            };
        }
    }
}
