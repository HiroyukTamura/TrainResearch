// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;

@FunctionalInterface
public interface IndexedPredicate<T>
{
    boolean test(final int p0, final T p1);
    
    public static class Util
    {
        private Util() {
        }
        
        public static <T> IndexedPredicate<T> wrap(final Predicate<? super T> predicate) {
            Objects.requireNonNull(predicate);
            return new IndexedPredicate<T>() {
                @Override
                public boolean test(final int n, final T t) {
                    return predicate.test(t);
                }
            };
        }
    }
}
