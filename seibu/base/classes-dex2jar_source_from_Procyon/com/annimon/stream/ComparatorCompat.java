// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.Function;
import java.util.Collections;
import java.util.Comparator;

public final class ComparatorCompat<T> implements Comparator<T>
{
    private static final ComparatorCompat<Comparable<Object>> NATURAL_ORDER;
    private static final ComparatorCompat<Comparable<Object>> REVERSE_ORDER;
    private final Comparator<? super T> comparator;
    
    static {
        NATURAL_ORDER = new ComparatorCompat<Comparable<Object>>(new Comparator<Comparable<Object>>() {
            @Override
            public int compare(final Comparable<Object> comparable, final Comparable<Object> comparable2) {
                return comparable.compareTo(comparable2);
            }
        });
        REVERSE_ORDER = new ComparatorCompat<Comparable<Object>>(Collections.reverseOrder());
    }
    
    public ComparatorCompat(final Comparator<? super T> comparator) {
        this.comparator = comparator;
    }
    
    public static <T> ComparatorCompat<T> chain(final Comparator<T> comparator) {
        return new ComparatorCompat<T>(comparator);
    }
    
    public static <T, U extends Comparable<? super U>> ComparatorCompat<T> comparing(final Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return function.apply(t).compareTo(function.apply(t2));
            }
        });
    }
    
    public static <T, U> ComparatorCompat<T> comparing(final Function<? super T, ? extends U> function, final Comparator<? super U> comparator) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(comparator);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return comparator.compare(function.apply(t), function.apply(t2));
            }
        });
    }
    
    public static <T> ComparatorCompat<T> comparingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return Double.compare(toDoubleFunction.applyAsDouble(t), toDoubleFunction.applyAsDouble(t2));
            }
        });
    }
    
    public static <T> ComparatorCompat<T> comparingInt(final ToIntFunction<? super T> toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return Objects.compareInt(toIntFunction.applyAsInt(t), toIntFunction.applyAsInt(t2));
            }
        });
    }
    
    public static <T> ComparatorCompat<T> comparingLong(final ToLongFunction<? super T> toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return Objects.compareLong(toLongFunction.applyAsLong(t), toLongFunction.applyAsLong(t2));
            }
        });
    }
    
    public static <T extends Comparable<? super T>> ComparatorCompat<T> naturalOrder() {
        return (ComparatorCompat<T>)ComparatorCompat.NATURAL_ORDER;
    }
    
    private static <T> ComparatorCompat<T> nullsComparator(final boolean b, final Comparator<? super T> comparator) {
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                int n = 1;
                if (t == null) {
                    if (t2 != null) {
                        if (b) {
                            return -1;
                        }
                        return 1;
                    }
                }
                else {
                    if (t2 == null) {
                        if (!b) {
                            n = -1;
                        }
                        return n;
                    }
                    if (comparator != null) {
                        return comparator.compare(t, t2);
                    }
                }
                return 0;
            }
        });
    }
    
    public static <T> ComparatorCompat<T> nullsFirst() {
        return nullsComparator(true, (Comparator<? super T>)null);
    }
    
    public static <T> ComparatorCompat<T> nullsFirst(final Comparator<? super T> comparator) {
        return nullsComparator(true, comparator);
    }
    
    public static <T> ComparatorCompat<T> nullsLast() {
        return nullsComparator(false, (Comparator<? super T>)null);
    }
    
    public static <T> ComparatorCompat<T> nullsLast(final Comparator<? super T> comparator) {
        return nullsComparator(false, comparator);
    }
    
    public static <T extends Comparable<? super T>> ComparatorCompat<T> reverseOrder() {
        return (ComparatorCompat<T>)ComparatorCompat.REVERSE_ORDER;
    }
    
    public static <T> Comparator<T> reversed(final Comparator<T> cmp) {
        return Collections.reverseOrder(cmp);
    }
    
    public static <T> Comparator<T> thenComparing(final Comparator<? super T> comparator, final Comparator<? super T> comparator2) {
        Objects.requireNonNull(comparator);
        Objects.requireNonNull(comparator2);
        return new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                final int compare = comparator.compare(t, t2);
                if (compare != 0) {
                    return compare;
                }
                return comparator2.compare(t, t2);
            }
        };
    }
    
    public Comparator<T> comparator() {
        return (Comparator<T>)this.comparator;
    }
    
    @Override
    public int compare(final T t, final T t2) {
        return this.comparator.compare((Object)t, (Object)t2);
    }
    
    @Override
    public ComparatorCompat<T> reversed() {
        return new ComparatorCompat<T>(Collections.reverseOrder(this.comparator));
    }
    
    public <U extends Comparable<? super U>> ComparatorCompat<T> thenComparing(final Function<? super T, ? extends U> function) {
        return this.thenComparing((Comparator<? super T>)comparing((Function<? super Object, ? extends Comparable>)function));
    }
    
    public <U> ComparatorCompat<T> thenComparing(final Function<? super T, ? extends U> function, final Comparator<? super U> comparator) {
        return this.thenComparing((Comparator<? super T>)comparing((Function<? super Object, ?>)function, (Comparator<? super Object>)comparator));
    }
    
    @Override
    public ComparatorCompat<T> thenComparing(final Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new ComparatorCompat<T>(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                final int compare = ComparatorCompat.this.comparator.compare(t, t2);
                if (compare != 0) {
                    return compare;
                }
                return comparator.compare(t, t2);
            }
        });
    }
    
    public ComparatorCompat<T> thenComparingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        return this.thenComparing((Comparator<? super T>)comparingDouble((ToDoubleFunction<? super Object>)toDoubleFunction));
    }
    
    public ComparatorCompat<T> thenComparingInt(final ToIntFunction<? super T> toIntFunction) {
        return this.thenComparing((Comparator<? super T>)comparingInt((ToIntFunction<? super Object>)toIntFunction));
    }
    
    public ComparatorCompat<T> thenComparingLong(final ToLongFunction<? super T> toLongFunction) {
        return this.thenComparing((Comparator<? super T>)comparingLong((ToLongFunction<? super Object>)toLongFunction));
    }
}
