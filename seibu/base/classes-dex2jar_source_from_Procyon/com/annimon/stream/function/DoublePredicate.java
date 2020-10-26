// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface DoublePredicate
{
    boolean test(final double p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static DoublePredicate and(final DoublePredicate doublePredicate, final DoublePredicate doublePredicate2) {
            return new DoublePredicate() {
                @Override
                public boolean test(final double n) {
                    return doublePredicate.test(n) && doublePredicate2.test(n);
                }
            };
        }
        
        public static DoublePredicate negate(final DoublePredicate doublePredicate) {
            return new DoublePredicate() {
                @Override
                public boolean test(final double n) {
                    return !doublePredicate.test(n);
                }
            };
        }
        
        public static DoublePredicate or(final DoublePredicate doublePredicate, final DoublePredicate doublePredicate2) {
            return new DoublePredicate() {
                @Override
                public boolean test(final double n) {
                    return doublePredicate.test(n) || doublePredicate2.test(n);
                }
            };
        }
        
        public static DoublePredicate safe(final ThrowableDoublePredicate<Throwable> throwableDoublePredicate) {
            return safe(throwableDoublePredicate, false);
        }
        
        public static DoublePredicate safe(final ThrowableDoublePredicate<Throwable> throwableDoublePredicate, final boolean b) {
            return new DoublePredicate() {
                @Override
                public boolean test(final double n) {
                    try {
                        return throwableDoublePredicate.test(n);
                    }
                    catch (Throwable t) {
                        return b;
                    }
                }
            };
        }
        
        public static DoublePredicate xor(final DoublePredicate doublePredicate, final DoublePredicate doublePredicate2) {
            return new DoublePredicate() {
                @Override
                public boolean test(final double n) {
                    return doublePredicate.test(n) ^ doublePredicate2.test(n);
                }
            };
        }
    }
}
