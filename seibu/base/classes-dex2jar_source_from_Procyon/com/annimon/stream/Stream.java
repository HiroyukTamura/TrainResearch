// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import java.util.ArrayList;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.operator.ObjTakeWhileIndexed;
import com.annimon.stream.operator.ObjTakeWhile;
import com.annimon.stream.operator.ObjTakeUntilIndexed;
import com.annimon.stream.operator.ObjTakeUntil;
import com.annimon.stream.operator.ObjSorted;
import com.annimon.stream.operator.ObjSkip;
import java.util.NoSuchElementException;
import com.annimon.stream.operator.ObjScanIdentity;
import com.annimon.stream.operator.ObjScan;
import com.annimon.stream.function.IndexedBiFunction;
import com.annimon.stream.operator.ObjPeek;
import java.util.Comparator;
import com.annimon.stream.operator.ObjMapToLong;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.operator.ObjMapToInt;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.operator.ObjMapToDouble;
import com.annimon.stream.function.ToDoubleFunction;
import com.annimon.stream.operator.ObjMapIndexed;
import com.annimon.stream.operator.ObjMap;
import com.annimon.stream.operator.ObjLimit;
import com.annimon.stream.function.IndexedFunction;
import com.annimon.stream.function.IndexedConsumer;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.operator.ObjFlatMapToLong;
import com.annimon.stream.operator.ObjFlatMapToInt;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.operator.ObjFlatMapToDouble;
import com.annimon.stream.operator.ObjFlatMap;
import com.annimon.stream.function.BinaryOperator;
import com.annimon.stream.operator.ObjFilterIndexed;
import com.annimon.stream.operator.ObjFilter;
import com.annimon.stream.operator.ObjDropWhileIndexed;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.operator.ObjDropWhile;
import com.annimon.stream.operator.ObjDistinctBy;
import com.annimon.stream.operator.ObjDistinct;
import com.annimon.stream.function.BiConsumer;
import java.util.List;
import com.annimon.stream.function.Function;
import com.annimon.stream.operator.ObjZip;
import com.annimon.stream.operator.ObjArray;
import java.util.Map;
import com.annimon.stream.operator.ObjMerge;
import com.annimon.stream.function.BiFunction;
import com.annimon.stream.operator.ObjIterate;
import com.annimon.stream.function.UnaryOperator;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.operator.ObjGenerate;
import com.annimon.stream.function.Supplier;
import java.util.Collections;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.operator.ObjConcat;
import com.annimon.stream.iterator.LazyIterator;
import com.annimon.stream.internal.Params;
import java.util.Iterator;
import java.io.Closeable;

public class Stream<T> implements Closeable
{
    private static final int MATCH_ALL = 1;
    private static final int MATCH_ANY = 0;
    private static final int MATCH_NONE = 2;
    private final Iterator<? extends T> iterator;
    private final Params params;
    
    private Stream(final Params params, final Iterable<? extends T> iterable) {
        this(params, (Iterator)new LazyIterator(iterable));
    }
    
    Stream(final Params params, final Iterator<? extends T> iterator) {
        this.params = params;
        this.iterator = iterator;
    }
    
    private Stream(final Iterable<? extends T> iterable) {
        this(null, (Iterator)new LazyIterator(iterable));
    }
    
    private Stream(final Iterator<? extends T> iterator) {
        this(null, iterator);
    }
    
    public static <T> Stream<T> concat(final Stream<? extends T> stream, final Stream<? extends T> stream2) {
        Objects.requireNonNull(stream);
        Objects.requireNonNull(stream2);
        return new Stream<T>((Iterator<? extends T>)new ObjConcat<T>(stream.iterator, stream2.iterator)).onClose(Compose.closeables(stream, stream2));
    }
    
    public static <T> Stream<T> concat(final Iterator<? extends T> iterator, final Iterator<? extends T> iterator2) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(iterator2);
        return new Stream<T>((Iterator<? extends T>)new ObjConcat<T>(iterator, iterator2));
    }
    
    public static <T> Stream<T> empty() {
        return of((Iterable<? extends T>)Collections.emptyList());
    }
    
    public static <T> Stream<T> generate(final Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return new Stream<T>((Iterator<? extends T>)new ObjGenerate<T>((Supplier<? extends T>)supplier));
    }
    
    public static <T> Stream<T> iterate(final T t, final Predicate<? super T> predicate, final UnaryOperator<T> unaryOperator) {
        Objects.requireNonNull(predicate);
        return iterate(t, unaryOperator).takeWhile(predicate);
    }
    
    public static <T> Stream<T> iterate(final T t, final UnaryOperator<T> unaryOperator) {
        Objects.requireNonNull(unaryOperator);
        return new Stream<T>((Iterator<? extends T>)new ObjIterate<T>((T)t, (UnaryOperator<? extends T>)unaryOperator));
    }
    
    private boolean match(final Predicate<? super T> predicate, int n) {
        boolean b;
        if (n == 0) {
            b = true;
        }
        else {
            b = false;
        }
        if (n == 1) {
            n = 1;
        }
        else {
            n = 0;
        }
        while (this.iterator.hasNext()) {
            final boolean test = predicate.test((Object)this.iterator.next());
            if (((test ? 1 : 0) ^ n) != 0x0) {
                if (b && test) {
                    return true;
                }
                return false;
            }
        }
        if (b) {
            return false;
        }
        return true;
    }
    
    public static <T> Stream<T> merge(final Stream<? extends T> stream, final Stream<? extends T> stream2, final BiFunction<? super T, ? super T, ObjMerge.MergeResult> biFunction) {
        Objects.requireNonNull(stream);
        Objects.requireNonNull(stream2);
        return merge(stream.iterator, stream2.iterator, biFunction);
    }
    
    public static <T> Stream<T> merge(final Iterator<? extends T> iterator, final Iterator<? extends T> iterator2, final BiFunction<? super T, ? super T, ObjMerge.MergeResult> biFunction) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(iterator2);
        return new Stream<T>((Iterator<? extends T>)new ObjMerge<T>(iterator, iterator2, biFunction));
    }
    
    public static <T> Stream<T> of(final Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable);
        return new Stream<T>(iterable);
    }
    
    public static <T> Stream<T> of(final Iterator<? extends T> iterator) {
        Objects.requireNonNull(iterator);
        return new Stream<T>(iterator);
    }
    
    public static <K, V> Stream<Map.Entry<K, V>> of(final Map<K, V> map) {
        Objects.requireNonNull(map);
        return new Stream<Map.Entry<K, V>>((Iterable<? extends Map.Entry<K, V>>)map.entrySet());
    }
    
    public static <T> Stream<T> of(final T... array) {
        Objects.requireNonNull(array);
        if (array.length == 0) {
            return empty();
        }
        return new Stream<T>((Iterator<? extends T>)new ObjArray<T>((T[])array));
    }
    
    public static <T> Stream<T> ofNullable(final Iterable<? extends T> iterable) {
        if (iterable == null) {
            return empty();
        }
        return (Stream<T>)of((Iterable<?>)iterable);
    }
    
    public static <T> Stream<T> ofNullable(final T t) {
        if (t == null) {
            return empty();
        }
        return of(t);
    }
    
    public static <T> Stream<T> ofNullable(final Iterator<? extends T> iterator) {
        if (iterator == null) {
            return empty();
        }
        return (Stream<T>)of((Iterator<?>)iterator);
    }
    
    public static <K, V> Stream<Map.Entry<K, V>> ofNullable(final Map<K, V> map) {
        if (map == null) {
            return empty();
        }
        return (Stream<Map.Entry<K, V>>)of((Map<Object, Object>)map);
    }
    
    public static <T> Stream<T> ofNullable(final T[] array) {
        if (array == null) {
            return empty();
        }
        return (Stream<T>)of((Object[])array);
    }
    
    public static Stream<Integer> range(final int n, final int n2) {
        return IntStream.range(n, n2).boxed();
    }
    
    public static Stream<Long> range(final long n, final long n2) {
        return LongStream.range(n, n2).boxed();
    }
    
    public static Stream<Integer> rangeClosed(final int n, final int n2) {
        return IntStream.rangeClosed(n, n2).boxed();
    }
    
    public static Stream<Long> rangeClosed(final long n, final long n2) {
        return LongStream.rangeClosed(n, n2).boxed();
    }
    
    public static <F, S, R> Stream<R> zip(final Stream<? extends F> stream, final Stream<? extends S> stream2, final BiFunction<? super F, ? super S, ? extends R> biFunction) {
        Objects.requireNonNull(stream);
        Objects.requireNonNull(stream2);
        return zip((Iterator<?>)stream.iterator, (Iterator<?>)stream2.iterator, (BiFunction<? super Object, ? super Object, ? extends R>)biFunction);
    }
    
    public static <F, S, R> Stream<R> zip(final Iterator<? extends F> iterator, final Iterator<? extends S> iterator2, final BiFunction<? super F, ? super S, ? extends R> biFunction) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(iterator2);
        return new Stream<R>((Iterator<? extends R>)new ObjZip(iterator, iterator2, (BiFunction<? super Object, ? super Object, ?>)biFunction));
    }
    
    public boolean allMatch(final Predicate<? super T> predicate) {
        return this.match(predicate, 1);
    }
    
    public boolean anyMatch(final Predicate<? super T> predicate) {
        return this.match(predicate, 0);
    }
    
    public <K> Stream<List<T>> chunkBy(final Function<? super T, ? extends K> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0        
        //     5: getfield        com/annimon/stream/Stream.params:Lcom/annimon/stream/internal/Params;
        //     8: new             Lcom/annimon/stream/operator/ObjChunkBy;
        //    11: dup            
        //    12: aload_0        
        //    13: getfield        com/annimon/stream/Stream.iterator:Ljava/util/Iterator;
        //    16: aload_1        
        //    17: invokespecial   com/annimon/stream/operator/ObjChunkBy.<init>:(Ljava/util/Iterator;Lcom/annimon/stream/function/Function;)V
        //    20: invokespecial   com/annimon/stream/Stream.<init>:(Lcom/annimon/stream/internal/Params;Ljava/util/Iterator;)V
        //    23: areturn        
        //    Signature:
        //  <K:Ljava/lang/Object;>(Lcom/annimon/stream/function/Function<-TT;+TK;>;)Lcom/annimon/stream/Stream<Ljava/util/List<TT;>;>;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitWildcard(TypeSubstitutionVisitor.java:108)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitWildcard(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.WildcardType.accept(WildcardType.java:83)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameters(TypeSubstitutionVisitor.java:364)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:279)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypesForVariables(TypeAnalysis.java:586)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:397)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void close() {
        if (this.params != null && this.params.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
    
    public <R, A> R collect(final Collector<? super T, A, R> collector) {
        final A value = collector.supplier().get();
        while (this.iterator.hasNext()) {
            collector.accumulator().accept(value, (T)this.iterator.next());
        }
        if (collector.finisher() != null) {
            return collector.finisher().apply(value);
        }
        return Collectors.castIdentity().apply(value);
    }
    
    public <R> R collect(final Supplier<R> supplier, final BiConsumer<R, ? super T> biConsumer) {
        final R value = supplier.get();
        while (this.iterator.hasNext()) {
            biConsumer.accept(value, (Object)this.iterator.next());
        }
        return value;
    }
    
    public long count() {
        long n = 0L;
        while (this.iterator.hasNext()) {
            this.iterator.next();
            ++n;
        }
        return n;
    }
    
    public <R> R custom(final Function<Stream<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    public Stream<T> distinct() {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjDistinct<T>(this.iterator));
    }
    
    public <K> Stream<T> distinctBy(final Function<? super T, ? extends K> function) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjDistinctBy(this.iterator, (Function<? super Object, ?>)function));
    }
    
    public Stream<T> dropWhile(final Predicate<? super T> predicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjDropWhile<T>(this.iterator, predicate));
    }
    
    public Stream<T> dropWhileIndexed(final int n, final int n2, final IndexedPredicate<? super T> indexedPredicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjDropWhileIndexed<T>((IndexedIterator<? extends T>)new IndexedIterator<T>(n, n2, this.iterator), indexedPredicate));
    }
    
    public Stream<T> dropWhileIndexed(final IndexedPredicate<? super T> indexedPredicate) {
        return this.dropWhileIndexed(0, 1, indexedPredicate);
    }
    
    public Stream<T> filter(final Predicate<? super T> predicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjFilter<T>(this.iterator, predicate));
    }
    
    public Stream<T> filterIndexed(final int n, final int n2, final IndexedPredicate<? super T> indexedPredicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjFilterIndexed<T>((IndexedIterator<? extends T>)new IndexedIterator<T>(n, n2, this.iterator), indexedPredicate));
    }
    
    public Stream<T> filterIndexed(final IndexedPredicate<? super T> indexedPredicate) {
        return this.filterIndexed(0, 1, indexedPredicate);
    }
    
    public Stream<T> filterNot(final Predicate<? super T> predicate) {
        return this.filter(Predicate.Util.negate(predicate));
    }
    
    public Optional<T> findFirst() {
        if (this.iterator.hasNext()) {
            return Optional.of((T)this.iterator.next());
        }
        return Optional.empty();
    }
    
    public Optional<IntPair<T>> findIndexed(int n, final int n2, final IndexedPredicate<? super T> indexedPredicate) {
        while (this.iterator.hasNext()) {
            final T next = (T)this.iterator.next();
            if (indexedPredicate.test(n, next)) {
                return Optional.of(new IntPair<T>(n, next));
            }
            n += n2;
        }
        return Optional.empty();
    }
    
    public Optional<IntPair<T>> findIndexed(final IndexedPredicate<? super T> indexedPredicate) {
        return this.findIndexed(0, 1, indexedPredicate);
    }
    
    public Optional<T> findLast() {
        return this.reduce(new BinaryOperator<T>() {
            @Override
            public T apply(final T t, final T t2) {
                return t2;
            }
        });
    }
    
    public Optional<T> findSingle() {
        if (!this.iterator.hasNext()) {
            return Optional.empty();
        }
        final T next = (T)this.iterator.next();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("Stream contains more than one element");
        }
        return Optional.of(next);
    }
    
    public <R> Stream<R> flatMap(final Function<? super T, ? extends Stream<? extends R>> function) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new ObjFlatMap(this.iterator, (Function<? super Object, ? extends Stream<?>>)function));
    }
    
    public DoubleStream flatMapToDouble(final Function<? super T, ? extends DoubleStream> function) {
        return new DoubleStream(this.params, new ObjFlatMapToDouble<Object>(this.iterator, function));
    }
    
    public IntStream flatMapToInt(final Function<? super T, ? extends IntStream> function) {
        return new IntStream(this.params, new ObjFlatMapToInt<Object>(this.iterator, function));
    }
    
    public LongStream flatMapToLong(final Function<? super T, ? extends LongStream> function) {
        return new LongStream(this.params, new ObjFlatMapToLong<Object>(this.iterator, function));
    }
    
    public void forEach(final Consumer<? super T> consumer) {
        while (this.iterator.hasNext()) {
            consumer.accept((Object)this.iterator.next());
        }
    }
    
    public void forEachIndexed(int n, final int n2, final IndexedConsumer<? super T> indexedConsumer) {
        while (this.iterator.hasNext()) {
            indexedConsumer.accept(n, (Object)this.iterator.next());
            n += n2;
        }
    }
    
    public void forEachIndexed(final IndexedConsumer<? super T> indexedConsumer) {
        this.forEachIndexed(0, 1, indexedConsumer);
    }
    
    @Deprecated
    public Iterator<? extends T> getIterator() {
        return this.iterator;
    }
    
    public <K> Stream<Map.Entry<K, List<T>>> groupBy(final Function<? super T, ? extends K> function) {
        return new Stream<Map.Entry<K, List<T>>>(this.params, (Iterable<? extends Map.Entry<K, List<T>>>)this.collect(Collectors.groupingBy((Function<? super T, ?>)function)).entrySet());
    }
    
    public Stream<IntPair<T>> indexed() {
        return this.indexed(0, 1);
    }
    
    public Stream<IntPair<T>> indexed(final int n, final int n2) {
        return this.mapIndexed(n, n2, (IndexedFunction<? super T, ? extends IntPair<T>>)new IndexedFunction<T, IntPair<T>>() {
            @Override
            public IntPair<T> apply(final int n, final T t) {
                return new IntPair<T>(n, t);
            }
        });
    }
    
    public Iterator<? extends T> iterator() {
        return this.iterator;
    }
    
    public Stream<T> limit(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        }
        if (n == 0L) {
            return empty();
        }
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjLimit<T>(this.iterator, n));
    }
    
    public <R> Stream<R> map(final Function<? super T, ? extends R> function) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new ObjMap(this.iterator, (Function<? super Object, ?>)function));
    }
    
    public <R> Stream<R> mapIndexed(final int n, final int n2, final IndexedFunction<? super T, ? extends R> indexedFunction) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new ObjMapIndexed(new IndexedIterator<Object>(n, n2, this.iterator), (IndexedFunction<? super Object, ?>)indexedFunction));
    }
    
    public <R> Stream<R> mapIndexed(final IndexedFunction<? super T, ? extends R> indexedFunction) {
        return this.mapIndexed(0, 1, indexedFunction);
    }
    
    public DoubleStream mapToDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        return new DoubleStream(this.params, new ObjMapToDouble<Object>(this.iterator, toDoubleFunction));
    }
    
    public IntStream mapToInt(final ToIntFunction<? super T> toIntFunction) {
        return new IntStream(this.params, new ObjMapToInt<Object>(this.iterator, toIntFunction));
    }
    
    public LongStream mapToLong(final ToLongFunction<? super T> toLongFunction) {
        return new LongStream(this.params, new ObjMapToLong<Object>(this.iterator, toLongFunction));
    }
    
    public Optional<T> max(final Comparator<? super T> comparator) {
        return this.reduce((BiFunction<T, T, T>)BinaryOperator.Util.maxBy((Comparator<? super Object>)comparator));
    }
    
    public Optional<T> min(final Comparator<? super T> comparator) {
        return this.reduce((BiFunction<T, T, T>)BinaryOperator.Util.minBy((Comparator<? super Object>)comparator));
    }
    
    public boolean noneMatch(final Predicate<? super T> predicate) {
        return this.match(predicate, 2);
    }
    
    public Stream<T> nullsOnly() {
        return this.filterNot(Predicate.Util.notNull());
    }
    
    public Stream<T> onClose(final Runnable closeHandler) {
        Objects.requireNonNull(closeHandler);
        Params params2;
        if (this.params == null) {
            final Params params = new Params();
            params.closeHandler = closeHandler;
            params2 = params;
        }
        else {
            final Params params3 = this.params;
            params3.closeHandler = Compose.runnables(params3.closeHandler, closeHandler);
            params2 = params3;
        }
        return new Stream<T>(params2, this.iterator);
    }
    
    public Stream<T> peek(final Consumer<? super T> consumer) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjPeek<T>(this.iterator, consumer));
    }
    
    public Optional<T> reduce(final BiFunction<T, T, T> biFunction) {
        int n = 0;
        T apply = null;
        while (this.iterator.hasNext()) {
            final T next = (T)this.iterator.next();
            if (n == 0) {
                n = 1;
                apply = next;
            }
            else {
                apply = biFunction.apply(apply, next);
            }
        }
        if (n != 0) {
            return Optional.of(apply);
        }
        return Optional.empty();
    }
    
    public <R> R reduce(R apply, final BiFunction<? super R, ? super T, ? extends R> biFunction) {
        while (this.iterator.hasNext()) {
            apply = (R)biFunction.apply(apply, (Object)this.iterator.next());
        }
        return apply;
    }
    
    public <R> R reduceIndexed(int n, final int n2, R apply, final IndexedBiFunction<? super R, ? super T, ? extends R> indexedBiFunction) {
        while (this.iterator.hasNext()) {
            apply = (R)indexedBiFunction.apply(n, apply, (Object)this.iterator.next());
            n += n2;
        }
        return apply;
    }
    
    public <R> R reduceIndexed(final R r, final IndexedBiFunction<? super R, ? super T, ? extends R> indexedBiFunction) {
        return this.reduceIndexed(0, 1, r, indexedBiFunction);
    }
    
    public Stream<T> sample(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifgt            15
        //     4: new             Ljava/lang/IllegalArgumentException;
        //     7: dup            
        //     8: ldc_w           "stepWidth cannot be zero or negative"
        //    11: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    14: athrow         
        //    15: iload_1        
        //    16: iconst_1       
        //    17: if_icmpne       22
        //    20: aload_0        
        //    21: areturn        
        //    22: aload_0        
        //    23: iconst_1       
        //    24: iload_1        
        //    25: invokevirtual   com/annimon/stream/Stream.slidingWindow:(II)Lcom/annimon/stream/Stream;
        //    28: new             Lcom/annimon/stream/Stream$4;
        //    31: dup            
        //    32: aload_0        
        //    33: invokespecial   com/annimon/stream/Stream$4.<init>:(Lcom/annimon/stream/Stream;)V
        //    36: invokevirtual   com/annimon/stream/Stream.map:(Lcom/annimon/stream/function/Function;)Lcom/annimon/stream/Stream;
        //    39: areturn        
        //    Signature:
        //  (I)Lcom/annimon/stream/Stream<TT;>;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitTypes(TypeSubstitutionVisitor.java:331)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:273)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1656)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypesForVariables(TypeAnalysis.java:586)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:397)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Stream<T> scan(final BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction);
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjScan<T>(this.iterator, (BiFunction<? extends T, ? extends T, ? extends T>)biFunction));
    }
    
    public <R> Stream<R> scan(final R r, final BiFunction<? super R, ? super T, ? extends R> biFunction) {
        Objects.requireNonNull(biFunction);
        return new Stream<R>(this.params, (Iterator<? extends R>)new ObjScanIdentity(this.iterator, r, (BiFunction<? super Object, ? super Object, ?>)biFunction));
    }
    
    public <TT> Stream<TT> select(final Class<TT> clazz) {
        return this.filter((Predicate<? super TT>)new Predicate<T>() {
            @Override
            public boolean test(final T t) {
                return clazz.isInstance(t);
            }
        });
    }
    
    public T single() {
        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException("Stream contains no element");
        }
        final T next = (T)this.iterator.next();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("Stream contains more than one element");
        }
        return next;
    }
    
    public Stream<T> skip(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n == 0L) {
            return this;
        }
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjSkip<T>(this.iterator, n));
    }
    
    public Stream<List<T>> slidingWindow(final int n) {
        return this.slidingWindow(n, 1);
    }
    
    public Stream<List<T>> slidingWindow(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifgt            15
        //     4: new             Ljava/lang/IllegalArgumentException;
        //     7: dup            
        //     8: ldc_w           "windowSize cannot be zero or negative"
        //    11: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    14: athrow         
        //    15: iload_2        
        //    16: ifgt            30
        //    19: new             Ljava/lang/IllegalArgumentException;
        //    22: dup            
        //    23: ldc_w           "stepWidth cannot be zero or negative"
        //    26: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    29: athrow         
        //    30: new             Lcom/annimon/stream/Stream;
        //    33: dup            
        //    34: aload_0        
        //    35: getfield        com/annimon/stream/Stream.params:Lcom/annimon/stream/internal/Params;
        //    38: new             Lcom/annimon/stream/operator/ObjSlidingWindow;
        //    41: dup            
        //    42: aload_0        
        //    43: getfield        com/annimon/stream/Stream.iterator:Ljava/util/Iterator;
        //    46: iload_1        
        //    47: iload_2        
        //    48: invokespecial   com/annimon/stream/operator/ObjSlidingWindow.<init>:(Ljava/util/Iterator;II)V
        //    51: invokespecial   com/annimon/stream/Stream.<init>:(Lcom/annimon/stream/internal/Params;Ljava/util/Iterator;)V
        //    54: areturn        
        //    Signature:
        //  (II)Lcom/annimon/stream/Stream<Ljava/util/List<TT;>;>;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException: The requested operation is not supported.
        //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:276)
        //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:271)
        //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:150)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:187)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitWildcard(TypeSubstitutionVisitor.java:108)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitWildcard(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.WildcardType.accept(WildcardType.java:83)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:173)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
        //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:39)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameters(TypeSubstitutionVisitor.java:364)
        //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:279)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2591)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypesForVariables(TypeAnalysis.java:586)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:397)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public <R extends Comparable<? super R>> Stream<T> sortBy(final Function<? super T, ? extends R> function) {
        return this.sorted(ComparatorCompat.comparing((Function<? super Object, ? extends Comparable>)function));
    }
    
    public Stream<T> sorted() {
        return this.sorted(new Comparator<T>() {
            @Override
            public int compare(final T t, final T t2) {
                return ((Comparable)t).compareTo(t2);
            }
        });
    }
    
    public Stream<T> sorted(final Comparator<? super T> comparator) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjSorted<T>(this.iterator, comparator));
    }
    
    public Stream<T> takeUntil(final Predicate<? super T> predicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjTakeUntil<T>(this.iterator, predicate));
    }
    
    public Stream<T> takeUntilIndexed(final int n, final int n2, final IndexedPredicate<? super T> indexedPredicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjTakeUntilIndexed<T>((IndexedIterator<? extends T>)new IndexedIterator<T>(n, n2, this.iterator), indexedPredicate));
    }
    
    public Stream<T> takeUntilIndexed(final IndexedPredicate<? super T> indexedPredicate) {
        return this.takeUntilIndexed(0, 1, indexedPredicate);
    }
    
    public Stream<T> takeWhile(final Predicate<? super T> predicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjTakeWhile<T>(this.iterator, predicate));
    }
    
    public Stream<T> takeWhileIndexed(final int n, final int n2, final IndexedPredicate<? super T> indexedPredicate) {
        return new Stream<T>(this.params, (Iterator<? extends T>)new ObjTakeWhileIndexed<T>((IndexedIterator<? extends T>)new IndexedIterator<T>(n, n2, this.iterator), indexedPredicate));
    }
    
    public Stream<T> takeWhileIndexed(final IndexedPredicate<? super T> indexedPredicate) {
        return this.takeWhileIndexed(0, 1, indexedPredicate);
    }
    
    public Object[] toArray() {
        return this.toArray((IntFunction<Object[]>)new IntFunction<Object[]>() {
            @Override
            public Object[] apply(final int n) {
                return new Object[n];
            }
        });
    }
    
    public <R> R[] toArray(final IntFunction<R[]> intFunction) {
        return Operators.toArray((Iterator<?>)this.iterator, intFunction);
    }
    
    public List<T> toList() {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<T>();
        while (this.iterator.hasNext()) {
            list.add(this.iterator.next());
        }
        return (List<T>)list;
    }
    
    public Stream<T> withoutNulls() {
        return this.filter(Predicate.Util.notNull());
    }
}
