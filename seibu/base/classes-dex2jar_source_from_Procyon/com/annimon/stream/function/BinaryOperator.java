// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

import com.annimon.stream.Objects;
import java.util.Comparator;

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T>
{
    public static class Util
    {
        private Util() {
        }
        
        public static <T> BinaryOperator<T> maxBy(final Comparator<? super T> comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator<T>() {
                @Override
                public T apply(final T t, final T t2) {
                    if (comparator.compare(t, t2) >= 0) {
                        return t;
                    }
                    return t2;
                }
            };
        }
        
        public static <T> BinaryOperator<T> minBy(final Comparator<? super T> comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator<T>() {
                @Override
                public T apply(final T t, final T t2) {
                    if (comparator.compare(t, t2) <= 0) {
                        return t;
                    }
                    return t2;
                }
            };
        }
    }
}
