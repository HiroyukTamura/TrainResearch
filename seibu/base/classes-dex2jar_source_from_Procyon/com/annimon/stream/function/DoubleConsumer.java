// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface DoubleConsumer
{
    void accept(final double p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static DoubleConsumer andThen(final DoubleConsumer doubleConsumer, final DoubleConsumer doubleConsumer2) {
            return new DoubleConsumer() {
                @Override
                public void accept(final double n) {
                    doubleConsumer.accept(n);
                    doubleConsumer2.accept(n);
                }
            };
        }
        
        public static DoubleConsumer safe(final ThrowableDoubleConsumer<Throwable> throwableDoubleConsumer) {
            return safe(throwableDoubleConsumer, null);
        }
        
        public static DoubleConsumer safe(final ThrowableDoubleConsumer<Throwable> throwableDoubleConsumer, final DoubleConsumer doubleConsumer) {
            return new DoubleConsumer() {
                @Override
                public void accept(final double n) {
                    try {
                        throwableDoubleConsumer.accept(n);
                    }
                    catch (Throwable t) {
                        if (doubleConsumer != null) {
                            doubleConsumer.accept(n);
                        }
                    }
                }
            };
        }
    }
}
