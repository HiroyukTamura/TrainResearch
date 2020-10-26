// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface DoubleSupplier
{
    double getAsDouble();
    
    public static class Util
    {
        private Util() {
        }
        
        public static DoubleSupplier safe(final ThrowableDoubleSupplier<Throwable> throwableDoubleSupplier) {
            return safe(throwableDoubleSupplier, 0.0);
        }
        
        public static DoubleSupplier safe(final ThrowableDoubleSupplier<Throwable> throwableDoubleSupplier, final double n) {
            return new DoubleSupplier() {
                @Override
                public double getAsDouble() {
                    try {
                        return throwableDoubleSupplier.getAsDouble();
                    }
                    catch (Throwable t) {
                        return n;
                    }
                }
            };
        }
    }
}
