// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface LongConsumer
{
    void accept(final long p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static LongConsumer andThen(final LongConsumer longConsumer, final LongConsumer longConsumer2) {
            return new LongConsumer() {
                @Override
                public void accept(final long n) {
                    longConsumer.accept(n);
                    longConsumer2.accept(n);
                }
            };
        }
        
        public static LongConsumer safe(final ThrowableLongConsumer<Throwable> throwableLongConsumer) {
            return safe(throwableLongConsumer, null);
        }
        
        public static LongConsumer safe(final ThrowableLongConsumer<Throwable> throwableLongConsumer, final LongConsumer longConsumer) {
            return new LongConsumer() {
                @Override
                public void accept(final long n) {
                    try {
                        throwableLongConsumer.accept(n);
                    }
                    catch (Throwable t) {
                        if (longConsumer != null) {
                            longConsumer.accept(n);
                        }
                    }
                }
            };
        }
    }
}
