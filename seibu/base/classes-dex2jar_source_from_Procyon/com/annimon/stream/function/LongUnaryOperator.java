// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface LongUnaryOperator
{
    long applyAsLong(final long p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static LongUnaryOperator identity() {
            return new LongUnaryOperator() {
                @Override
                public long applyAsLong(final long n) {
                    return n;
                }
            };
        }
    }
}
