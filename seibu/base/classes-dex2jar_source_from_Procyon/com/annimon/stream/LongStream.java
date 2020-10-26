// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.operator.LongTakeWhile;
import com.annimon.stream.operator.LongTakeUntil;
import java.util.Comparator;
import com.annimon.stream.operator.LongSorted;
import com.annimon.stream.operator.LongSkip;
import java.util.NoSuchElementException;
import com.annimon.stream.operator.LongScan;
import com.annimon.stream.operator.LongScanIdentity;
import com.annimon.stream.operator.LongSample;
import com.annimon.stream.operator.LongPeek;
import com.annimon.stream.operator.LongMapToObj;
import com.annimon.stream.operator.LongMapToInt;
import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.operator.LongMapToDouble;
import com.annimon.stream.function.LongToDoubleFunction;
import com.annimon.stream.operator.LongMap;
import com.annimon.stream.operator.LongLimit;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.operator.LongFlatMap;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.operator.LongFilter;
import com.annimon.stream.operator.LongDropWhile;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.ObjLongConsumer;
import com.annimon.stream.function.Supplier;
import java.util.Iterator;
import com.annimon.stream.operator.LongRangeClosed;
import com.annimon.stream.operator.LongArray;
import com.annimon.stream.operator.LongIterate;
import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.operator.LongGenerate;
import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.operator.LongConcat;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.ToLongFunction;
import java.io.Closeable;

public final class LongStream implements Closeable
{
    private static final LongStream EMPTY;
    private static final ToLongFunction<Long> UNBOX_FUNCTION;
    private final PrimitiveIterator.OfLong iterator;
    private final Params params;
    
    static {
        EMPTY = new LongStream(new PrimitiveIterator.OfLong() {
            @Override
            public boolean hasNext() {
                return false;
            }
            
            @Override
            public long nextLong() {
                return 0L;
            }
        });
        UNBOX_FUNCTION = new ToLongFunction<Long>() {
            @Override
            public long applyAsLong(final Long n) {
                return n;
            }
        };
    }
    
    LongStream(final Params params, final PrimitiveIterator.OfLong iterator) {
        this.params = params;
        this.iterator = iterator;
    }
    
    private LongStream(final PrimitiveIterator.OfLong ofLong) {
        this(null, ofLong);
    }
    
    public static LongStream concat(final LongStream longStream, final LongStream longStream2) {
        Objects.requireNonNull(longStream);
        Objects.requireNonNull(longStream2);
        return new LongStream(new LongConcat(longStream.iterator, longStream2.iterator)).onClose(Compose.closeables(longStream, longStream2));
    }
    
    public static LongStream empty() {
        return LongStream.EMPTY;
    }
    
    public static LongStream generate(final LongSupplier longSupplier) {
        Objects.requireNonNull(longSupplier);
        return new LongStream(new LongGenerate(longSupplier));
    }
    
    public static LongStream iterate(final long n, final LongPredicate longPredicate, final LongUnaryOperator longUnaryOperator) {
        Objects.requireNonNull(longPredicate);
        return iterate(n, longUnaryOperator).takeWhile(longPredicate);
    }
    
    public static LongStream iterate(final long n, final LongUnaryOperator longUnaryOperator) {
        Objects.requireNonNull(longUnaryOperator);
        return new LongStream(new LongIterate(n, longUnaryOperator));
    }
    
    public static LongStream of(final long n) {
        return new LongStream(new LongArray(new long[] { n }));
    }
    
    public static LongStream of(final PrimitiveIterator.OfLong ofLong) {
        Objects.requireNonNull(ofLong);
        return new LongStream(ofLong);
    }
    
    public static LongStream of(final long... array) {
        Objects.requireNonNull(array);
        if (array.length == 0) {
            return empty();
        }
        return new LongStream(new LongArray(array));
    }
    
    public static LongStream range(final long n, final long n2) {
        if (n >= n2) {
            return empty();
        }
        return rangeClosed(n, n2 - 1L);
    }
    
    public static LongStream rangeClosed(final long n, final long n2) {
        if (n > n2) {
            return empty();
        }
        if (n == n2) {
            return of(n);
        }
        return new LongStream(new LongRangeClosed(n, n2));
    }
    
    public boolean allMatch(final LongPredicate longPredicate) {
        while (this.iterator.hasNext()) {
            if (!longPredicate.test(this.iterator.nextLong())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean anyMatch(final LongPredicate longPredicate) {
        while (this.iterator.hasNext()) {
            if (longPredicate.test(this.iterator.nextLong())) {
                return true;
            }
        }
        return false;
    }
    
    public Stream<Long> boxed() {
        return new Stream<Long>(this.params, this.iterator);
    }
    
    @Override
    public void close() {
        if (this.params != null && this.params.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
    
    public <R> R collect(final Supplier<R> supplier, final ObjLongConsumer<R> objLongConsumer) {
        final R value = supplier.get();
        while (this.iterator.hasNext()) {
            objLongConsumer.accept(value, this.iterator.nextLong());
        }
        return value;
    }
    
    public long count() {
        long n = 0L;
        while (this.iterator.hasNext()) {
            this.iterator.nextLong();
            ++n;
        }
        return n;
    }
    
    public <R> R custom(final Function<LongStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    public LongStream distinct() {
        return this.boxed().distinct().mapToLong(LongStream.UNBOX_FUNCTION);
    }
    
    public LongStream dropWhile(final LongPredicate longPredicate) {
        return new LongStream(this.params, new LongDropWhile(this.iterator, longPredicate));
    }
    
    public LongStream filter(final LongPredicate longPredicate) {
        return new LongStream(this.params, new LongFilter(this.iterator, longPredicate));
    }
    
    public LongStream filterNot(final LongPredicate longPredicate) {
        return this.filter(LongPredicate.Util.negate(longPredicate));
    }
    
    public OptionalLong findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalLong.of(this.iterator.nextLong());
        }
        return OptionalLong.empty();
    }
    
    public OptionalLong findLast() {
        return this.reduce(new LongBinaryOperator() {
            @Override
            public long applyAsLong(final long n, final long n2) {
                return n2;
            }
        });
    }
    
    public OptionalLong findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalLong.empty();
        }
        final long nextLong = this.iterator.nextLong();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("LongStream contains more than one element");
        }
        return OptionalLong.of(nextLong);
    }
    
    public LongStream flatMap(final LongFunction<? extends LongStream> longFunction) {
        return new LongStream(this.params, new LongFlatMap(this.iterator, longFunction));
    }
    
    public void forEach(final LongConsumer longConsumer) {
        while (this.iterator.hasNext()) {
            longConsumer.accept(this.iterator.nextLong());
        }
    }
    
    public PrimitiveIterator.OfLong iterator() {
        return this.iterator;
    }
    
    public LongStream limit(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        }
        if (n == 0L) {
            return empty();
        }
        return new LongStream(this.params, new LongLimit(this.iterator, n));
    }
    
    public LongStream map(final LongUnaryOperator longUnaryOperator) {
        return new LongStream(this.params, new LongMap(this.iterator, longUnaryOperator));
    }
    
    public DoubleStream mapToDouble(final LongToDoubleFunction longToDoubleFunction) {
        return new DoubleStream(this.params, new LongMapToDouble(this.iterator, longToDoubleFunction));
    }
    
    public IntStream mapToInt(final LongToIntFunction longToIntFunction) {
        return new IntStream(this.params, new LongMapToInt(this.iterator, longToIntFunction));
    }
    
    public <R> Stream<R> mapToObj(final LongFunction<? extends R> longFunction) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new LongMapToObj<R>(this.iterator, longFunction));
    }
    
    public OptionalLong max() {
        return this.reduce(new LongBinaryOperator() {
            @Override
            public long applyAsLong(final long a, final long b) {
                return Math.max(a, b);
            }
        });
    }
    
    public OptionalLong min() {
        return this.reduce(new LongBinaryOperator() {
            @Override
            public long applyAsLong(final long a, final long b) {
                return Math.min(a, b);
            }
        });
    }
    
    public boolean noneMatch(final LongPredicate longPredicate) {
        while (this.iterator.hasNext()) {
            if (longPredicate.test(this.iterator.nextLong())) {
                return false;
            }
        }
        return true;
    }
    
    public LongStream onClose(final Runnable closeHandler) {
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
        return new LongStream(params2, this.iterator);
    }
    
    public LongStream peek(final LongConsumer longConsumer) {
        return new LongStream(this.params, new LongPeek(this.iterator, longConsumer));
    }
    
    public long reduce(long applyAsLong, final LongBinaryOperator longBinaryOperator) {
        while (this.iterator.hasNext()) {
            applyAsLong = longBinaryOperator.applyAsLong(applyAsLong, this.iterator.nextLong());
        }
        return applyAsLong;
    }
    
    public OptionalLong reduce(final LongBinaryOperator longBinaryOperator) {
        int n = 0;
        long applyAsLong = 0L;
        while (this.iterator.hasNext()) {
            final long nextLong = this.iterator.nextLong();
            if (n == 0) {
                n = 1;
                applyAsLong = nextLong;
            }
            else {
                applyAsLong = longBinaryOperator.applyAsLong(applyAsLong, nextLong);
            }
        }
        if (n != 0) {
            return OptionalLong.of(applyAsLong);
        }
        return OptionalLong.empty();
    }
    
    public LongStream sample(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        }
        if (n == 1) {
            return this;
        }
        return new LongStream(this.params, new LongSample(this.iterator, n));
    }
    
    public LongStream scan(final long n, final LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return new LongStream(this.params, new LongScanIdentity(this.iterator, n, longBinaryOperator));
    }
    
    public LongStream scan(final LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return new LongStream(this.params, new LongScan(this.iterator, longBinaryOperator));
    }
    
    public long single() {
        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException("LongStream contains no element");
        }
        final long nextLong = this.iterator.nextLong();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("LongStream contains more than one element");
        }
        return nextLong;
    }
    
    public LongStream skip(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n == 0L) {
            return this;
        }
        return new LongStream(this.params, new LongSkip(this.iterator, n));
    }
    
    public LongStream sorted() {
        return new LongStream(this.params, new LongSorted(this.iterator));
    }
    
    public LongStream sorted(final Comparator<Long> comparator) {
        return this.boxed().sorted(comparator).mapToLong(LongStream.UNBOX_FUNCTION);
    }
    
    public long sum() {
        long n = 0L;
        while (this.iterator.hasNext()) {
            n += this.iterator.nextLong();
        }
        return n;
    }
    
    public LongStream takeUntil(final LongPredicate longPredicate) {
        return new LongStream(this.params, new LongTakeUntil(this.iterator, longPredicate));
    }
    
    public LongStream takeWhile(final LongPredicate longPredicate) {
        return new LongStream(this.params, new LongTakeWhile(this.iterator, longPredicate));
    }
    
    public long[] toArray() {
        return Operators.toLongArray(this.iterator);
    }
}
