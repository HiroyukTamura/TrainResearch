// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface IntSupplier
{
    int getAsInt();
    
    public static class Util
    {
        private Util() {
        }
        
        public static IntSupplier safe(final ThrowableIntSupplier<Throwable> throwableIntSupplier) {
            return safe(throwableIntSupplier, 0);
        }
        
        public static IntSupplier safe(final ThrowableIntSupplier<Throwable> throwableIntSupplier, final int n) {
            return new IntSupplier() {
                @Override
                public int getAsInt() {
                    try {
                        return throwableIntSupplier.getAsInt();
                    }
                    catch (Throwable t) {
                        return n;
                    }
                }
            };
        }
    }
}
