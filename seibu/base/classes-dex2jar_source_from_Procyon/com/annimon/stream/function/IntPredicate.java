// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface IntPredicate
{
    boolean test(final int p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static IntPredicate and(final IntPredicate intPredicate, final IntPredicate intPredicate2) {
            return new IntPredicate() {
                @Override
                public boolean test(final int n) {
                    return intPredicate.test(n) && intPredicate2.test(n);
                }
            };
        }
        
        public static IntPredicate negate(final IntPredicate intPredicate) {
            return new IntPredicate() {
                @Override
                public boolean test(final int n) {
                    return !intPredicate.test(n);
                }
            };
        }
        
        public static IntPredicate or(final IntPredicate intPredicate, final IntPredicate intPredicate2) {
            return new IntPredicate() {
                @Override
                public boolean test(final int n) {
                    return intPredicate.test(n) || intPredicate2.test(n);
                }
            };
        }
        
        public static IntPredicate safe(final ThrowableIntPredicate<Throwable> throwableIntPredicate) {
            return safe(throwableIntPredicate, false);
        }
        
        public static IntPredicate safe(final ThrowableIntPredicate<Throwable> throwableIntPredicate, final boolean b) {
            return new IntPredicate() {
                @Override
                public boolean test(final int n) {
                    try {
                        return throwableIntPredicate.test(n);
                    }
                    catch (Throwable t) {
                        return b;
                    }
                }
            };
        }
        
        public static IntPredicate xor(final IntPredicate intPredicate, final IntPredicate intPredicate2) {
            return new IntPredicate() {
                @Override
                public boolean test(final int n) {
                    return intPredicate.test(n) ^ intPredicate2.test(n);
                }
            };
        }
    }
}
