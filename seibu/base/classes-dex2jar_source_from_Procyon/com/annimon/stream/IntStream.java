// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.operator.IntTakeWhile;
import com.annimon.stream.operator.IntTakeUntil;
import java.util.Comparator;
import com.annimon.stream.operator.IntSorted;
import com.annimon.stream.operator.IntSkip;
import java.util.NoSuchElementException;
import com.annimon.stream.operator.IntScan;
import com.annimon.stream.operator.IntScanIdentity;
import com.annimon.stream.operator.IntSample;
import com.annimon.stream.operator.IntPeek;
import com.annimon.stream.operator.IntMapToObj;
import com.annimon.stream.operator.IntMapToLong;
import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.operator.IntMapToDouble;
import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.operator.IntMap;
import com.annimon.stream.operator.IntLimit;
import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.operator.IntFlatMap;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.operator.IntFilter;
import com.annimon.stream.operator.IntDropWhile;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.ObjIntConsumer;
import com.annimon.stream.function.Supplier;
import java.util.Iterator;
import com.annimon.stream.operator.IntRangeClosed;
import com.annimon.stream.operator.IntCodePoints;
import com.annimon.stream.operator.IntArray;
import com.annimon.stream.operator.IntIterate;
import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.operator.IntGenerate;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.operator.IntConcat;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.ToIntFunction;
import java.io.Closeable;

public final class IntStream implements Closeable
{
    private static final IntStream EMPTY;
    private static final ToIntFunction<Integer> UNBOX_FUNCTION;
    private final PrimitiveIterator.OfInt iterator;
    private final Params params;
    
    static {
        EMPTY = new IntStream(new PrimitiveIterator.OfInt() {
            @Override
            public boolean hasNext() {
                return false;
            }
            
            @Override
            public int nextInt() {
                return 0;
            }
        });
        UNBOX_FUNCTION = new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(final Integer n) {
                return n;
            }
        };
    }
    
    IntStream(final Params params, final PrimitiveIterator.OfInt iterator) {
        this.params = params;
        this.iterator = iterator;
    }
    
    private IntStream(final PrimitiveIterator.OfInt ofInt) {
        this(null, ofInt);
    }
    
    public static IntStream concat(final IntStream intStream, final IntStream intStream2) {
        Objects.requireNonNull(intStream);
        Objects.requireNonNull(intStream2);
        return new IntStream(new IntConcat(intStream.iterator, intStream2.iterator)).onClose(Compose.closeables(intStream, intStream2));
    }
    
    public static IntStream empty() {
        return IntStream.EMPTY;
    }
    
    public static IntStream generate(final IntSupplier intSupplier) {
        Objects.requireNonNull(intSupplier);
        return new IntStream(new IntGenerate(intSupplier));
    }
    
    public static IntStream iterate(final int n, final IntPredicate intPredicate, final IntUnaryOperator intUnaryOperator) {
        Objects.requireNonNull(intPredicate);
        return iterate(n, intUnaryOperator).takeWhile(intPredicate);
    }
    
    public static IntStream iterate(final int n, final IntUnaryOperator intUnaryOperator) {
        Objects.requireNonNull(intUnaryOperator);
        return new IntStream(new IntIterate(n, intUnaryOperator));
    }
    
    public static IntStream of(final int n) {
        return new IntStream(new IntArray(new int[] { n }));
    }
    
    public static IntStream of(final PrimitiveIterator.OfInt ofInt) {
        Objects.requireNonNull(ofInt);
        return new IntStream(ofInt);
    }
    
    public static IntStream of(final int... array) {
        Objects.requireNonNull(array);
        if (array.length == 0) {
            return empty();
        }
        return new IntStream(new IntArray(array));
    }
    
    public static IntStream ofCodePoints(final CharSequence charSequence) {
        return new IntStream(new IntCodePoints(charSequence));
    }
    
    public static IntStream range(final int n, final int n2) {
        if (n >= n2) {
            return empty();
        }
        return rangeClosed(n, n2 - 1);
    }
    
    public static IntStream rangeClosed(final int n, final int n2) {
        if (n > n2) {
            return empty();
        }
        if (n == n2) {
            return of(n);
        }
        return new IntStream(new IntRangeClosed(n, n2));
    }
    
    public boolean allMatch(final IntPredicate intPredicate) {
        while (this.iterator.hasNext()) {
            if (!intPredicate.test(this.iterator.nextInt())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean anyMatch(final IntPredicate intPredicate) {
        while (this.iterator.hasNext()) {
            if (intPredicate.test(this.iterator.nextInt())) {
                return true;
            }
        }
        return false;
    }
    
    public Stream<Integer> boxed() {
        return new Stream<Integer>(this.params, this.iterator);
    }
    
    @Override
    public void close() {
        if (this.params != null && this.params.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
    
    public <R> R collect(final Supplier<R> supplier, final ObjIntConsumer<R> objIntConsumer) {
        final R value = supplier.get();
        while (this.iterator.hasNext()) {
            objIntConsumer.accept(value, this.iterator.nextInt());
        }
        return value;
    }
    
    public long count() {
        long n = 0L;
        while (this.iterator.hasNext()) {
            this.iterator.nextInt();
            ++n;
        }
        return n;
    }
    
    public <R> R custom(final Function<IntStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    public IntStream distinct() {
        return this.boxed().distinct().mapToInt(IntStream.UNBOX_FUNCTION);
    }
    
    public IntStream dropWhile(final IntPredicate intPredicate) {
        return new IntStream(this.params, new IntDropWhile(this.iterator, intPredicate));
    }
    
    public IntStream filter(final IntPredicate intPredicate) {
        return new IntStream(this.params, new IntFilter(this.iterator, intPredicate));
    }
    
    public IntStream filterNot(final IntPredicate intPredicate) {
        return this.filter(IntPredicate.Util.negate(intPredicate));
    }
    
    public OptionalInt findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalInt.of(this.iterator.nextInt());
        }
        return OptionalInt.empty();
    }
    
    public OptionalInt findLast() {
        return this.reduce(new IntBinaryOperator() {
            @Override
            public int applyAsInt(final int n, final int n2) {
                return n2;
            }
        });
    }
    
    public OptionalInt findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalInt.empty();
        }
        final int nextInt = this.iterator.nextInt();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("IntStream contains more than one element");
        }
        return OptionalInt.of(nextInt);
    }
    
    public IntStream flatMap(final IntFunction<? extends IntStream> intFunction) {
        return new IntStream(this.params, new IntFlatMap(this.iterator, intFunction));
    }
    
    public void forEach(final IntConsumer intConsumer) {
        while (this.iterator.hasNext()) {
            intConsumer.accept(this.iterator.nextInt());
        }
    }
    
    public PrimitiveIterator.OfInt iterator() {
        return this.iterator;
    }
    
    public IntStream limit(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        }
        if (n == 0L) {
            return empty();
        }
        return new IntStream(this.params, new IntLimit(this.iterator, n));
    }
    
    public IntStream map(final IntUnaryOperator intUnaryOperator) {
        return new IntStream(this.params, new IntMap(this.iterator, intUnaryOperator));
    }
    
    public DoubleStream mapToDouble(final IntToDoubleFunction intToDoubleFunction) {
        return new DoubleStream(this.params, new IntMapToDouble(this.iterator, intToDoubleFunction));
    }
    
    public LongStream mapToLong(final IntToLongFunction intToLongFunction) {
        return new LongStream(this.params, new IntMapToLong(this.iterator, intToLongFunction));
    }
    
    public <R> Stream<R> mapToObj(final IntFunction<? extends R> intFunction) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new IntMapToObj<R>(this.iterator, intFunction));
    }
    
    public OptionalInt max() {
        return this.reduce(new IntBinaryOperator() {
            @Override
            public int applyAsInt(final int n, final int n2) {
                if (n > n2) {
                    return n;
                }
                return n2;
            }
        });
    }
    
    public OptionalInt min() {
        return this.reduce(new IntBinaryOperator() {
            @Override
            public int applyAsInt(final int n, final int n2) {
                if (n < n2) {
                    return n;
                }
                return n2;
            }
        });
    }
    
    public boolean noneMatch(final IntPredicate intPredicate) {
        while (this.iterator.hasNext()) {
            if (intPredicate.test(this.iterator.nextInt())) {
                return false;
            }
        }
        return true;
    }
    
    public IntStream onClose(final Runnable closeHandler) {
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
        return new IntStream(params2, this.iterator);
    }
    
    public IntStream peek(final IntConsumer intConsumer) {
        return new IntStream(this.params, new IntPeek(this.iterator, intConsumer));
    }
    
    public int reduce(int applyAsInt, final IntBinaryOperator intBinaryOperator) {
        while (this.iterator.hasNext()) {
            applyAsInt = intBinaryOperator.applyAsInt(applyAsInt, this.iterator.nextInt());
        }
        return applyAsInt;
    }
    
    public OptionalInt reduce(final IntBinaryOperator intBinaryOperator) {
        int n = 0;
        int applyAsInt = 0;
        while (this.iterator.hasNext()) {
            final int nextInt = this.iterator.nextInt();
            if (n == 0) {
                n = 1;
                applyAsInt = nextInt;
            }
            else {
                applyAsInt = intBinaryOperator.applyAsInt(applyAsInt, nextInt);
            }
        }
        if (n != 0) {
            return OptionalInt.of(applyAsInt);
        }
        return OptionalInt.empty();
    }
    
    public IntStream sample(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        }
        if (n == 1) {
            return this;
        }
        return new IntStream(this.params, new IntSample(this.iterator, n));
    }
    
    public IntStream scan(final int n, final IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return new IntStream(this.params, new IntScanIdentity(this.iterator, n, intBinaryOperator));
    }
    
    public IntStream scan(final IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return new IntStream(this.params, new IntScan(this.iterator, intBinaryOperator));
    }
    
    public int single() {
        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException("IntStream contains no element");
        }
        final int nextInt = this.iterator.nextInt();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("IntStream contains more than one element");
        }
        return nextInt;
    }
    
    public IntStream skip(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n == 0L) {
            return this;
        }
        return new IntStream(this.params, new IntSkip(this.iterator, n));
    }
    
    public IntStream sorted() {
        return new IntStream(this.params, new IntSorted(this.iterator));
    }
    
    public IntStream sorted(final Comparator<Integer> comparator) {
        return this.boxed().sorted(comparator).mapToInt(IntStream.UNBOX_FUNCTION);
    }
    
    public int sum() {
        int n = 0;
        while (this.iterator.hasNext()) {
            n += this.iterator.nextInt();
        }
        return n;
    }
    
    public IntStream takeUntil(final IntPredicate intPredicate) {
        return new IntStream(this.params, new IntTakeUntil(this.iterator, intPredicate));
    }
    
    public IntStream takeWhile(final IntPredicate intPredicate) {
        return new IntStream(this.params, new IntTakeWhile(this.iterator, intPredicate));
    }
    
    public int[] toArray() {
        return Operators.toIntArray(this.iterator);
    }
}
