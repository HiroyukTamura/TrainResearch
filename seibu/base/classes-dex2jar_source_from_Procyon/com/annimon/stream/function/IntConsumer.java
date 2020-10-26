// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface IntConsumer
{
    void accept(final int p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static IntConsumer andThen(final IntConsumer intConsumer, final IntConsumer intConsumer2) {
            return new IntConsumer() {
                @Override
                public void accept(final int n) {
                    intConsumer.accept(n);
                    intConsumer2.accept(n);
                }
            };
        }
        
        public static IntConsumer safe(final ThrowableIntConsumer<Throwable> throwableIntConsumer) {
            return safe(throwableIntConsumer, null);
        }
        
        public static IntConsumer safe(final ThrowableIntConsumer<Throwable> throwableIntConsumer, final IntConsumer intConsumer) {
            return new IntConsumer() {
                @Override
                public void accept(final int n) {
                    try {
                        throwableIntConsumer.accept(n);
                    }
                    catch (Throwable t) {
                        if (intConsumer != null) {
                            intConsumer.accept(n);
                        }
                    }
                }
            };
        }
    }
}
