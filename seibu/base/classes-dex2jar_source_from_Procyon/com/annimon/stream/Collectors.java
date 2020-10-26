// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import java.util.HashSet;
import java.util.Set;
import com.annimon.stream.function.UnaryOperator;
import java.util.ArrayList;
import java.util.Collection;
import com.annimon.stream.function.BinaryOperator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.BiConsumer;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Supplier;

public final class Collectors
{
    private static final Supplier<double[]> DOUBLE_2ELEMENTS_ARRAY_SUPPLIER;
    private static final Supplier<long[]> LONG_2ELEMENTS_ARRAY_SUPPLIER;
    
    static {
        LONG_2ELEMENTS_ARRAY_SUPPLIER = new Supplier<long[]>() {
            @Override
            public long[] get() {
                return new long[] { 0L, 0L };
            }
        };
        DOUBLE_2ELEMENTS_ARRAY_SUPPLIER = new Supplier<double[]>() {
            @Override
            public double[] get() {
                return new double[] { 0.0, 0.0 };
            }
        };
    }
    
    private Collectors() {
    }
    
    @Deprecated
    public static <T> Collector<T, ?, Double> averaging(final Function<? super T, Double> function) {
        return averagingDouble((ToDoubleFunction<? super T>)new ToDoubleFunction<T>() {
            @Override
            public double applyAsDouble(final T t) {
                return function.apply(t);
            }
        });
    }
    
    public static <T> Collector<T, ?, Double> averagingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        return new CollectorsImpl<T, Object, Double>(Collectors.DOUBLE_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<double[], T>() {
            @Override
            public void accept(final double[] array, final T t) {
                ++array[0];
                array[1] += toDoubleFunction.applyAsDouble(t);
            }
        }, new Function<double[], Double>() {
            @Override
            public Double apply(final double[] array) {
                if (array[0] == 0.0) {
                    return 0.0;
                }
                return array[1] / array[0];
            }
        });
    }
    
    private static <T> Collector<T, ?, Double> averagingHelper(final BiConsumer<long[], T> biConsumer) {
        return new CollectorsImpl<T, Object, Double>(Collectors.LONG_2ELEMENTS_ARRAY_SUPPLIER, biConsumer, new Function<long[], Double>() {
            @Override
            public Double apply(final long[] array) {
                if (array[0] == 0L) {
                    return 0.0;
                }
                return array[1] / (double)array[0];
            }
        });
    }
    
    public static <T> Collector<T, ?, Double> averagingInt(final ToIntFunction<? super T> toIntFunction) {
        return averagingHelper((BiConsumer<long[], T>)new BiConsumer<long[], T>() {
            @Override
            public void accept(final long[] array, final T t) {
                ++array[0];
                array[1] += toIntFunction.applyAsInt(t);
            }
        });
    }
    
    public static <T> Collector<T, ?, Double> averagingLong(final ToLongFunction<? super T> toLongFunction) {
        return averagingHelper((BiConsumer<long[], T>)new BiConsumer<long[], T>() {
            @Override
            public void accept(final long[] array, final T t) {
                ++array[0];
                array[1] += toLongFunction.applyAsLong(t);
            }
        });
    }
    
    static <A, R> Function<A, R> castIdentity() {
        return new Function<A, R>() {
            @Override
            public R apply(final A a) {
                return (R)a;
            }
        };
    }
    
    public static <T, A, IR, OR> Collector<T, A, OR> collectingAndThen(final Collector<T, A, IR> collector, final Function<IR, OR> function) {
        Object o;
        if ((o = collector.finisher()) == null) {
            o = castIdentity();
        }
        return new CollectorsImpl<T, A, OR>((Supplier<Object>)collector.supplier(), (BiConsumer<Object, Object>)collector.accumulator(), Function.Util.andThen((Function<? super Object, ?>)o, (Function<? super Object, ?>)function));
    }
    
    public static <T> Collector<T, ?, Long> counting() {
        return summingLong((ToLongFunction<? super T>)new ToLongFunction<T>() {
            @Override
            public long applyAsLong(final T t) {
                return 1L;
            }
        });
    }
    
    public static <T, A, R> Collector<T, ?, R> filtering(final Predicate<? super T> predicate, final Collector<? super T, A, R> collector) {
        return new CollectorsImpl<T, Object, R>(collector.supplier(), new BiConsumer<A, T>() {
            final /* synthetic */ BiConsumer val$accumulator = collector.accumulator();
            
            @Override
            public void accept(final A a, final T t) {
                if (predicate.test(t)) {
                    this.val$accumulator.accept(a, t);
                }
            }
        }, collector.finisher());
    }
    
    public static <T, U, A, R> Collector<T, ?, R> flatMapping(final Function<? super T, ? extends Stream<? extends U>> function, final Collector<? super U, A, R> collector) {
        return new CollectorsImpl<T, Object, R>(collector.supplier(), new BiConsumer<A, T>() {
            final /* synthetic */ BiConsumer val$accumulator = collector.accumulator();
            
            @Override
            public void accept(final A a, final T t) {
                final Stream stream = function.apply(t);
                if (stream == null) {
                    return;
                }
                stream.forEach(new Consumer<U>() {
                    @Override
                    public void accept(final U u) {
                        BiConsumer.this.val$accumulator.accept(a, u);
                    }
                });
            }
        }, collector.finisher());
    }
    
    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(final Function<? super T, ? extends K> function) {
        return groupingBy(function, (Collector<? super T, ?, List<T>>)toList());
    }
    
    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(final Function<? super T, ? extends K> function, final Collector<? super T, A, D> collector) {
        return groupingBy((Function<? super T, ?>)function, hashMapSupplier(), collector);
    }
    
    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(final Function<? super T, ? extends K> function, final Supplier<M> supplier, final Collector<? super T, A, D> collector) {
        final Function<A, D> finisher = collector.finisher();
        Function<?, M> function2 = null;
        if (finisher != null) {
            function2 = new Function<Map<K, A>, M>() {
                @Override
                public M apply(final Map<K, A> map) {
                    for (final Map.Entry<K, A> entry : map.entrySet()) {
                        entry.setValue((A)finisher.apply(entry.getValue()));
                    }
                    return (M)map;
                }
            };
        }
        return new CollectorsImpl<T, Object, M>((Supplier<Object>)supplier, (BiConsumer<Object, Object>)new BiConsumer<Map<K, A>, T>() {
            @Override
            public void accept(final Map<K, A> map, final T t) {
                final K requireNonNull = Objects.requireNonNull(function.apply(t), "element cannot be mapped to a null key");
                A a;
                if ((a = map.get(requireNonNull)) == null) {
                    a = collector.supplier().get();
                    map.put(requireNonNull, a);
                }
                collector.accumulator().accept(a, t);
            }
        }, (Function<Object, Object>)function2);
    }
    
    private static <K, V> Supplier<Map<K, V>> hashMapSupplier() {
        return new Supplier<Map<K, V>>() {
            @Override
            public Map<K, V> get() {
                return new HashMap<K, V>();
            }
        };
    }
    
    public static Collector<CharSequence, ?, String> joining() {
        return joining("");
    }
    
    public static Collector<CharSequence, ?, String> joining(final CharSequence charSequence) {
        return joining(charSequence, "", "");
    }
    
    public static Collector<CharSequence, ?, String> joining(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3) {
        return joining(charSequence, charSequence2, charSequence3, charSequence2.toString() + charSequence3.toString());
    }
    
    public static Collector<CharSequence, ?, String> joining(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final String s) {
        return new CollectorsImpl<CharSequence, Object, String>(new Supplier<StringBuilder>() {
            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        }, new BiConsumer<StringBuilder, CharSequence>() {
            @Override
            public void accept(final StringBuilder sb, final CharSequence s) {
                if (sb.length() > 0) {
                    sb.append(charSequence);
                }
                else {
                    sb.append(charSequence2);
                }
                sb.append(s);
            }
        }, new Function<StringBuilder, String>() {
            @Override
            public String apply(final StringBuilder sb) {
                if (sb.length() == 0) {
                    return s;
                }
                sb.append(charSequence3);
                return sb.toString();
            }
        });
    }
    
    public static <T, U, A, R> Collector<T, ?, R> mapping(final Function<? super T, ? extends U> function, final Collector<? super U, A, R> collector) {
        return new CollectorsImpl<T, Object, R>(collector.supplier(), new BiConsumer<A, T>() {
            final /* synthetic */ BiConsumer val$accumulator = collector.accumulator();
            
            @Override
            public void accept(final A a, final T t) {
                this.val$accumulator.accept(a, function.apply(t));
            }
        }, collector.finisher());
    }
    
    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(final Predicate<? super T> predicate) {
        return partitioningBy(predicate, (Collector<? super T, ?, List<T>>)toList());
    }
    
    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(final Predicate<? super T> predicate, final Collector<? super T, A, D> collector) {
        return new CollectorsImpl<T, Object, Map<Boolean, D>>(new Supplier<Tuple2<A>>() {
            @Override
            public Tuple2<A> get() {
                return (Tuple2<A>)new Tuple2(collector.supplier().get(), collector.supplier().get());
            }
        }, new BiConsumer<Tuple2<A>, T>() {
            final /* synthetic */ BiConsumer val$downstreamAccumulator = collector.accumulator();
            
            @Override
            public void accept(final Tuple2<A> tuple2, final T t) {
                final BiConsumer val$downstreamAccumulator = this.val$downstreamAccumulator;
                A a;
                if (predicate.test(t)) {
                    a = tuple2.a;
                }
                else {
                    a = tuple2.b;
                }
                val$downstreamAccumulator.accept(a, t);
            }
        }, new Function<Tuple2<A>, Map<Boolean, D>>() {
            @Override
            public Map<Boolean, D> apply(final Tuple2<A> tuple2) {
                Function<A, D> function = collector.finisher();
                if (function == null) {
                    function = Collectors.castIdentity();
                }
                final HashMap<Boolean, D> hashMap = new HashMap<Boolean, D>(2);
                hashMap.put(Boolean.TRUE, function.apply(tuple2.a));
                hashMap.put(Boolean.FALSE, function.apply(tuple2.b));
                return hashMap;
            }
        });
    }
    
    public static <T> Collector<T, ?, T> reducing(final T t, final BinaryOperator<T> binaryOperator) {
        return new CollectorsImpl<T, Object, T>(new Supplier<Tuple1<T>>() {
            @Override
            public Tuple1<T> get() {
                return (Tuple1<T>)new Tuple1(t);
            }
        }, new BiConsumer<Tuple1<T>, T>() {
            @Override
            public void accept(final Tuple1<T> tuple1, final T t) {
                tuple1.a = (T)binaryOperator.apply(tuple1.a, t);
            }
        }, new Function<Tuple1<T>, T>() {
            @Override
            public T apply(final Tuple1<T> tuple1) {
                return tuple1.a;
            }
        });
    }
    
    public static <T, R> Collector<T, ?, R> reducing(final R r, final Function<? super T, ? extends R> function, final BinaryOperator<R> binaryOperator) {
        return new CollectorsImpl<T, Object, R>(new Supplier<Tuple1<R>>() {
            @Override
            public Tuple1<R> get() {
                return (Tuple1<R>)new Tuple1(r);
            }
        }, new BiConsumer<Tuple1<R>, T>() {
            @Override
            public void accept(final Tuple1<R> tuple1, final T t) {
                tuple1.a = (R)binaryOperator.apply(tuple1.a, function.apply(t));
            }
        }, new Function<Tuple1<R>, R>() {
            @Override
            public R apply(final Tuple1<R> tuple1) {
                return tuple1.a;
            }
        });
    }
    
    public static <T> Collector<T, ?, Double> summingDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        return new CollectorsImpl<T, Object, Double>(Collectors.DOUBLE_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<double[], T>() {
            @Override
            public void accept(final double[] array, final T t) {
                array[0] += toDoubleFunction.applyAsDouble(t);
            }
        }, new Function<double[], Double>() {
            @Override
            public Double apply(final double[] array) {
                return array[0];
            }
        });
    }
    
    public static <T> Collector<T, ?, Integer> summingInt(final ToIntFunction<? super T> toIntFunction) {
        return new CollectorsImpl<T, Object, Integer>(new Supplier<int[]>() {
            @Override
            public int[] get() {
                return new int[] { 0 };
            }
        }, new BiConsumer<int[], T>() {
            @Override
            public void accept(final int[] array, final T t) {
                array[0] += toIntFunction.applyAsInt(t);
            }
        }, new Function<int[], Integer>() {
            @Override
            public Integer apply(final int[] array) {
                return array[0];
            }
        });
    }
    
    public static <T> Collector<T, ?, Long> summingLong(final ToLongFunction<? super T> toLongFunction) {
        return new CollectorsImpl<T, Object, Long>(Collectors.LONG_2ELEMENTS_ARRAY_SUPPLIER, new BiConsumer<long[], T>() {
            @Override
            public void accept(final long[] array, final T t) {
                array[0] += toLongFunction.applyAsLong(t);
            }
        }, new Function<long[], Long>() {
            @Override
            public Long apply(final long[] array) {
                return array[0];
            }
        });
    }
    
    public static <T, R extends Collection<T>> Collector<T, ?, R> toCollection(final Supplier<R> supplier) {
        return new CollectorsImpl<T, Object, R>(supplier, new BiConsumer<R, T>() {
            @Override
            public void accept(final R r, final T t) {
                r.add(t);
            }
        });
    }
    
    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorsImpl<T, Object, List<T>>(new Supplier<List<T>>() {
            @Override
            public List<T> get() {
                return new ArrayList<T>();
            }
        }, new BiConsumer<List<T>, T>() {
            @Override
            public void accept(final List<T> list, final T t) {
                list.add(t);
            }
        });
    }
    
    public static <T, K> Collector<T, ?, Map<K, T>> toMap(final Function<? super T, ? extends K> function) {
        return toMap(function, (Function<? super T, ? extends T>)UnaryOperator.Util.identity());
    }
    
    public static <T, K, V> Collector<T, ?, Map<K, V>> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        return toMap((Function<? super T, ?>)function, (Function<? super T, ?>)function2, hashMapSupplier());
    }
    
    public static <T, K, V, M extends Map<K, V>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2, final Supplier<M> supplier) {
        return new CollectorsImpl<T, Object, M>(supplier, new BiConsumer<M, T>() {
            @Override
            public void accept(final M m, final T t) {
                final K apply = function.apply(t);
                V apply2 = function2.apply(t);
                final V value = ((Map<K, V>)m).get(apply);
                if (value != null) {
                    apply2 = value;
                }
                if (apply2 == null) {
                    m.remove(apply);
                    return;
                }
                m.put(apply, apply2);
            }
        });
    }
    
    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new CollectorsImpl<T, Object, Set<T>>(new Supplier<Set<T>>() {
            @Override
            public Set<T> get() {
                return new HashSet<T>();
            }
        }, new BiConsumer<Set<T>, T>() {
            @Override
            public void accept(final Set<T> set, final T t) {
                set.add(t);
            }
        });
    }
    
    private static final class CollectorsImpl<T, A, R> implements Collector<T, A, R>
    {
        private final BiConsumer<A, T> accumulator;
        private final Function<A, R> finisher;
        private final Supplier<A> supplier;
        
        public CollectorsImpl(final Supplier<A> supplier, final BiConsumer<A, T> biConsumer) {
            this(supplier, biConsumer, null);
        }
        
        public CollectorsImpl(final Supplier<A> supplier, final BiConsumer<A, T> accumulator, final Function<A, R> finisher) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.finisher = finisher;
        }
        
        @Override
        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }
        
        @Override
        public Function<A, R> finisher() {
            return this.finisher;
        }
        
        @Override
        public Supplier<A> supplier() {
            return this.supplier;
        }
    }
    
    private static final class Tuple1<A>
    {
        A a;
        
        Tuple1(final A a) {
            this.a = a;
        }
    }
    
    private static final class Tuple2<A>
    {
        A a;
        A b;
        
        Tuple2(final A a, final A b) {
            this.a = a;
            this.b = b;
        }
    }
}
