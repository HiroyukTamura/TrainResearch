// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.internal.Operators;
import com.annimon.stream.operator.DoubleTakeWhile;
import com.annimon.stream.operator.DoubleTakeUntil;
import java.util.Comparator;
import com.annimon.stream.operator.DoubleSorted;
import com.annimon.stream.operator.DoubleSkip;
import java.util.NoSuchElementException;
import com.annimon.stream.operator.DoubleScan;
import com.annimon.stream.operator.DoubleScanIdentity;
import com.annimon.stream.operator.DoubleSample;
import com.annimon.stream.operator.DoublePeek;
import com.annimon.stream.operator.DoubleMapToObj;
import com.annimon.stream.operator.DoubleMapToLong;
import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.operator.DoubleMapToInt;
import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.operator.DoubleMap;
import com.annimon.stream.operator.DoubleLimit;
import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.operator.DoubleFlatMap;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.operator.DoubleFilter;
import com.annimon.stream.operator.DoubleDropWhile;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.ObjDoubleConsumer;
import com.annimon.stream.function.Supplier;
import java.util.Iterator;
import com.annimon.stream.operator.DoubleArray;
import com.annimon.stream.operator.DoubleIterate;
import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.operator.DoubleGenerate;
import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.internal.Compose;
import com.annimon.stream.operator.DoubleConcat;
import com.annimon.stream.internal.Params;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.ToDoubleFunction;
import java.io.Closeable;

public final class DoubleStream implements Closeable
{
    private static final DoubleStream EMPTY;
    private static final ToDoubleFunction<Double> UNBOX_FUNCTION;
    private final PrimitiveIterator.OfDouble iterator;
    private final Params params;
    
    static {
        EMPTY = new DoubleStream(new PrimitiveIterator.OfDouble() {
            @Override
            public boolean hasNext() {
                return false;
            }
            
            @Override
            public double nextDouble() {
                return 0.0;
            }
        });
        UNBOX_FUNCTION = new ToDoubleFunction<Double>() {
            @Override
            public double applyAsDouble(final Double n) {
                return n;
            }
        };
    }
    
    DoubleStream(final Params params, final PrimitiveIterator.OfDouble iterator) {
        this.params = params;
        this.iterator = iterator;
    }
    
    private DoubleStream(final PrimitiveIterator.OfDouble ofDouble) {
        this(null, ofDouble);
    }
    
    public static DoubleStream concat(final DoubleStream doubleStream, final DoubleStream doubleStream2) {
        Objects.requireNonNull(doubleStream);
        Objects.requireNonNull(doubleStream2);
        return new DoubleStream(new DoubleConcat(doubleStream.iterator, doubleStream2.iterator)).onClose(Compose.closeables(doubleStream, doubleStream2));
    }
    
    public static DoubleStream empty() {
        return DoubleStream.EMPTY;
    }
    
    public static DoubleStream generate(final DoubleSupplier doubleSupplier) {
        Objects.requireNonNull(doubleSupplier);
        return new DoubleStream(new DoubleGenerate(doubleSupplier));
    }
    
    public static DoubleStream iterate(final double n, final DoublePredicate doublePredicate, final DoubleUnaryOperator doubleUnaryOperator) {
        Objects.requireNonNull(doublePredicate);
        return iterate(n, doubleUnaryOperator).takeWhile(doublePredicate);
    }
    
    public static DoubleStream iterate(final double n, final DoubleUnaryOperator doubleUnaryOperator) {
        Objects.requireNonNull(doubleUnaryOperator);
        return new DoubleStream(new DoubleIterate(n, doubleUnaryOperator));
    }
    
    public static DoubleStream of(final double n) {
        return new DoubleStream(new DoubleArray(new double[] { n }));
    }
    
    public static DoubleStream of(final PrimitiveIterator.OfDouble ofDouble) {
        Objects.requireNonNull(ofDouble);
        return new DoubleStream(ofDouble);
    }
    
    public static DoubleStream of(final double... array) {
        Objects.requireNonNull(array);
        if (array.length == 0) {
            return empty();
        }
        return new DoubleStream(new DoubleArray(array));
    }
    
    public boolean allMatch(final DoublePredicate doublePredicate) {
        while (this.iterator.hasNext()) {
            if (!doublePredicate.test(this.iterator.nextDouble())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean anyMatch(final DoublePredicate doublePredicate) {
        while (this.iterator.hasNext()) {
            if (doublePredicate.test(this.iterator.nextDouble())) {
                return true;
            }
        }
        return false;
    }
    
    public OptionalDouble average() {
        long n = 0L;
        double n2 = 0.0;
        while (this.iterator.hasNext()) {
            n2 += this.iterator.nextDouble();
            ++n;
        }
        if (n == 0L) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(n2 / n);
    }
    
    public Stream<Double> boxed() {
        return new Stream<Double>(this.params, this.iterator);
    }
    
    @Override
    public void close() {
        if (this.params != null && this.params.closeHandler != null) {
            this.params.closeHandler.run();
            this.params.closeHandler = null;
        }
    }
    
    public <R> R collect(final Supplier<R> supplier, final ObjDoubleConsumer<R> objDoubleConsumer) {
        final R value = supplier.get();
        while (this.iterator.hasNext()) {
            objDoubleConsumer.accept(value, this.iterator.nextDouble());
        }
        return value;
    }
    
    public long count() {
        long n = 0L;
        while (this.iterator.hasNext()) {
            this.iterator.nextDouble();
            ++n;
        }
        return n;
    }
    
    public <R> R custom(final Function<DoubleStream, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    public DoubleStream distinct() {
        return this.boxed().distinct().mapToDouble(DoubleStream.UNBOX_FUNCTION);
    }
    
    public DoubleStream dropWhile(final DoublePredicate doublePredicate) {
        return new DoubleStream(this.params, new DoubleDropWhile(this.iterator, doublePredicate));
    }
    
    public DoubleStream filter(final DoublePredicate doublePredicate) {
        return new DoubleStream(this.params, new DoubleFilter(this.iterator, doublePredicate));
    }
    
    public DoubleStream filterNot(final DoublePredicate doublePredicate) {
        return this.filter(DoublePredicate.Util.negate(doublePredicate));
    }
    
    public OptionalDouble findFirst() {
        if (this.iterator.hasNext()) {
            return OptionalDouble.of(this.iterator.nextDouble());
        }
        return OptionalDouble.empty();
    }
    
    public OptionalDouble findLast() {
        return this.reduce(new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(final double n, final double n2) {
                return n2;
            }
        });
    }
    
    public OptionalDouble findSingle() {
        if (!this.iterator.hasNext()) {
            return OptionalDouble.empty();
        }
        final double nextDouble = this.iterator.nextDouble();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("DoubleStream contains more than one element");
        }
        return OptionalDouble.of(nextDouble);
    }
    
    public DoubleStream flatMap(final DoubleFunction<? extends DoubleStream> doubleFunction) {
        return new DoubleStream(this.params, new DoubleFlatMap(this.iterator, doubleFunction));
    }
    
    public void forEach(final DoubleConsumer doubleConsumer) {
        while (this.iterator.hasNext()) {
            doubleConsumer.accept(this.iterator.nextDouble());
        }
    }
    
    public PrimitiveIterator.OfDouble iterator() {
        return this.iterator;
    }
    
    public DoubleStream limit(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("maxSize cannot be negative");
        }
        if (n == 0L) {
            return empty();
        }
        return new DoubleStream(this.params, new DoubleLimit(this.iterator, n));
    }
    
    public DoubleStream map(final DoubleUnaryOperator doubleUnaryOperator) {
        return new DoubleStream(this.params, new DoubleMap(this.iterator, doubleUnaryOperator));
    }
    
    public IntStream mapToInt(final DoubleToIntFunction doubleToIntFunction) {
        return new IntStream(this.params, new DoubleMapToInt(this.iterator, doubleToIntFunction));
    }
    
    public LongStream mapToLong(final DoubleToLongFunction doubleToLongFunction) {
        return new LongStream(this.params, new DoubleMapToLong(this.iterator, doubleToLongFunction));
    }
    
    public <R> Stream<R> mapToObj(final DoubleFunction<? extends R> doubleFunction) {
        return new Stream<R>(this.params, (Iterator<? extends R>)new DoubleMapToObj<R>(this.iterator, doubleFunction));
    }
    
    public OptionalDouble max() {
        return this.reduce(new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(final double a, final double b) {
                return Math.max(a, b);
            }
        });
    }
    
    public OptionalDouble min() {
        return this.reduce(new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(final double a, final double b) {
                return Math.min(a, b);
            }
        });
    }
    
    public boolean noneMatch(final DoublePredicate doublePredicate) {
        while (this.iterator.hasNext()) {
            if (doublePredicate.test(this.iterator.nextDouble())) {
                return false;
            }
        }
        return true;
    }
    
    public DoubleStream onClose(final Runnable closeHandler) {
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
        return new DoubleStream(params2, this.iterator);
    }
    
    public DoubleStream peek(final DoubleConsumer doubleConsumer) {
        return new DoubleStream(this.params, new DoublePeek(this.iterator, doubleConsumer));
    }
    
    public double reduce(double applyAsDouble, final DoubleBinaryOperator doubleBinaryOperator) {
        while (this.iterator.hasNext()) {
            applyAsDouble = doubleBinaryOperator.applyAsDouble(applyAsDouble, this.iterator.nextDouble());
        }
        return applyAsDouble;
    }
    
    public OptionalDouble reduce(final DoubleBinaryOperator doubleBinaryOperator) {
        int n = 0;
        double applyAsDouble = 0.0;
        while (this.iterator.hasNext()) {
            final double nextDouble = this.iterator.nextDouble();
            if (n == 0) {
                n = 1;
                applyAsDouble = nextDouble;
            }
            else {
                applyAsDouble = doubleBinaryOperator.applyAsDouble(applyAsDouble, nextDouble);
            }
        }
        if (n != 0) {
            return OptionalDouble.of(applyAsDouble);
        }
        return OptionalDouble.empty();
    }
    
    public DoubleStream sample(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("stepWidth cannot be zero or negative");
        }
        if (n == 1) {
            return this;
        }
        return new DoubleStream(this.params, new DoubleSample(this.iterator, n));
    }
    
    public DoubleStream scan(final double n, final DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return new DoubleStream(this.params, new DoubleScanIdentity(this.iterator, n, doubleBinaryOperator));
    }
    
    public DoubleStream scan(final DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return new DoubleStream(this.params, new DoubleScan(this.iterator, doubleBinaryOperator));
    }
    
    public double single() {
        if (!this.iterator.hasNext()) {
            throw new NoSuchElementException("DoubleStream contains no element");
        }
        final double nextDouble = this.iterator.nextDouble();
        if (this.iterator.hasNext()) {
            throw new IllegalStateException("DoubleStream contains more than one element");
        }
        return nextDouble;
    }
    
    public DoubleStream skip(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n == 0L) {
            return this;
        }
        return new DoubleStream(this.params, new DoubleSkip(this.iterator, n));
    }
    
    public DoubleStream sorted() {
        return new DoubleStream(this.params, new DoubleSorted(this.iterator));
    }
    
    public DoubleStream sorted(final Comparator<Double> comparator) {
        return this.boxed().sorted(comparator).mapToDouble(DoubleStream.UNBOX_FUNCTION);
    }
    
    public double sum() {
        double n = 0.0;
        while (this.iterator.hasNext()) {
            n += this.iterator.nextDouble();
        }
        return n;
    }
    
    public DoubleStream takeUntil(final DoublePredicate doublePredicate) {
        return new DoubleStream(this.params, new DoubleTakeUntil(this.iterator, doublePredicate));
    }
    
    public DoubleStream takeWhile(final DoublePredicate doublePredicate) {
        return new DoubleStream(this.params, new DoubleTakeWhile(this.iterator, doublePredicate));
    }
    
    public double[] toArray() {
        return Operators.toDoubleArray(this.iterator);
    }
}
