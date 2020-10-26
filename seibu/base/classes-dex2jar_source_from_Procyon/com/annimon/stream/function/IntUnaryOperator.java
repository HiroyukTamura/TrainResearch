// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface IntUnaryOperator
{
    int applyAsInt(final int p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static IntUnaryOperator identity() {
            return new IntUnaryOperator() {
                @Override
                public int applyAsInt(final int n) {
                    return n;
                }
            };
        }
    }
}
