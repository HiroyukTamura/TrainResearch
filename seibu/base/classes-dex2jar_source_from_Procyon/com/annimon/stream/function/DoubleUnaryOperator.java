// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface DoubleUnaryOperator
{
    double applyAsDouble(final double p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static DoubleUnaryOperator identity() {
            return new DoubleUnaryOperator() {
                @Override
                public double applyAsDouble(final double n) {
                    return n;
                }
            };
        }
    }
}
