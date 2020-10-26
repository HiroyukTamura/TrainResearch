// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface LongPredicate
{
    boolean test(final long p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static LongPredicate and(final LongPredicate longPredicate, final LongPredicate longPredicate2) {
            return new LongPredicate() {
                @Override
                public boolean test(final long n) {
                    return longPredicate.test(n) && longPredicate2.test(n);
                }
            };
        }
        
        public static LongPredicate negate(final LongPredicate longPredicate) {
            return new LongPredicate() {
                @Override
                public boolean test(final long n) {
                    return !longPredicate.test(n);
                }
            };
        }
        
        public static LongPredicate or(final LongPredicate longPredicate, final LongPredicate longPredicate2) {
            return new LongPredicate() {
                @Override
                public boolean test(final long n) {
                    return longPredicate.test(n) || longPredicate2.test(n);
                }
            };
        }
        
        public static LongPredicate safe(final ThrowableLongPredicate<Throwable> throwableLongPredicate) {
            return safe(throwableLongPredicate, false);
        }
        
        public static LongPredicate safe(final ThrowableLongPredicate<Throwable> throwableLongPredicate, final boolean b) {
            return new LongPredicate() {
                @Override
                public boolean test(final long n) {
                    try {
                        return throwableLongPredicate.test(n);
                    }
                    catch (Throwable t) {
                        return b;
                    }
                }
            };
        }
        
        public static LongPredicate xor(final LongPredicate longPredicate, final LongPredicate longPredicate2) {
            return new LongPredicate() {
                @Override
                public boolean test(final long n) {
                    return longPredicate.test(n) ^ longPredicate2.test(n);
                }
            };
        }
    }
}
