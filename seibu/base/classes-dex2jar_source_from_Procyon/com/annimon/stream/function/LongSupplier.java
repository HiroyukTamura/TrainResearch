// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface LongSupplier
{
    long getAsLong();
    
    public static class Util
    {
        private Util() {
        }
        
        public static LongSupplier safe(final ThrowableLongSupplier<Throwable> throwableLongSupplier) {
            return safe(throwableLongSupplier, 0L);
        }
        
        public static LongSupplier safe(final ThrowableLongSupplier<Throwable> throwableLongSupplier, final long n) {
            return new LongSupplier() {
                @Override
                public long getAsLong() {
                    try {
                        return throwableLongSupplier.getAsLong();
                    }
                    catch (Throwable t) {
                        return n;
                    }
                }
            };
        }
    }
}
