// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface Predicate<T>
{
    boolean test(final T p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T> Predicate<T> and(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    return predicate.test(t) && predicate2.test(t);
                }
            };
        }
        
        public static <T> Predicate<T> negate(final Predicate<? super T> predicate) {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    return !predicate.test(t);
                }
            };
        }
        
        public static <T> Predicate<T> notNull() {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    return t != null;
                }
            };
        }
        
        public static <T> Predicate<T> or(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    return predicate.test(t) || predicate2.test(t);
                }
            };
        }
        
        public static <T> Predicate<T> safe(final ThrowablePredicate<? super T, Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }
        
        public static <T> Predicate<T> safe(final ThrowablePredicate<? super T, Throwable> throwablePredicate, final boolean b) {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    try {
                        return throwablePredicate.test(t);
                    }
                    catch (Throwable t2) {
                        return b;
                    }
                }
            };
        }
        
        public static <T> Predicate<T> xor(final Predicate<? super T> predicate, final Predicate<? super T> predicate2) {
            return new Predicate<T>() {
                @Override
                public boolean test(final T t) {
                    return predicate.test(t) ^ predicate2.test(t);
                }
            };
        }
    }
}
