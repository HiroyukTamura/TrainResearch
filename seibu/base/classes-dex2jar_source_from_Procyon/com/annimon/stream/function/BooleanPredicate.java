// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface BooleanPredicate
{
    boolean test(final boolean p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static BooleanPredicate and(final BooleanPredicate booleanPredicate, final BooleanPredicate booleanPredicate2) {
            return new BooleanPredicate() {
                @Override
                public boolean test(final boolean b) {
                    return booleanPredicate.test(b) && booleanPredicate2.test(b);
                }
            };
        }
        
        public static BooleanPredicate identity() {
            return new BooleanPredicate() {
                @Override
                public boolean test(final boolean b) {
                    return b;
                }
            };
        }
        
        public static BooleanPredicate negate(final BooleanPredicate booleanPredicate) {
            return new BooleanPredicate() {
                @Override
                public boolean test(final boolean b) {
                    return !booleanPredicate.test(b);
                }
            };
        }
        
        public static BooleanPredicate or(final BooleanPredicate booleanPredicate, final BooleanPredicate booleanPredicate2) {
            return new BooleanPredicate() {
                @Override
                public boolean test(final boolean b) {
                    return booleanPredicate.test(b) || booleanPredicate2.test(b);
                }
            };
        }
        
        public static BooleanPredicate xor(final BooleanPredicate booleanPredicate, final BooleanPredicate booleanPredicate2) {
            return new BooleanPredicate() {
                @Override
                public boolean test(final boolean b) {
                    return booleanPredicate.test(b) ^ booleanPredicate2.test(b);
                }
            };
        }
    }
}
