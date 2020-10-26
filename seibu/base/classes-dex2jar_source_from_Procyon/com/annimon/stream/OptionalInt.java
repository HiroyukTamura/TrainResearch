// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.IntFunction;
import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.function.IntUnaryOperator;
import java.util.NoSuchElementException;
import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.function.IntConsumer;
import com.annimon.stream.function.Function;

public final class OptionalInt
{
    private static final OptionalInt EMPTY;
    private final boolean isPresent;
    private final int value;
    
    static {
        EMPTY = new OptionalInt();
    }
    
    private OptionalInt() {
        this.isPresent = false;
        this.value = 0;
    }
    
    private OptionalInt(final int value) {
        this.isPresent = true;
        this.value = value;
    }
    
    public static OptionalInt empty() {
        return OptionalInt.EMPTY;
    }
    
    public static OptionalInt of(final int n) {
        return new OptionalInt(n);
    }
    
    public <R> R custom(final Function<OptionalInt, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof OptionalInt)) {
                return false;
            }
            final OptionalInt optionalInt = (OptionalInt)o;
            if (this.isPresent && optionalInt.isPresent) {
                if (this.value != optionalInt.value) {
                    return false;
                }
            }
            else if (this.isPresent != optionalInt.isPresent) {
                return false;
            }
        }
        return true;
    }
    
    public OptionalInt executeIfAbsent(final Runnable runnable) {
        if (!this.isPresent()) {
            runnable.run();
        }
        return this;
    }
    
    public OptionalInt executeIfPresent(final IntConsumer intConsumer) {
        this.ifPresent(intConsumer);
        return this;
    }
    
    public OptionalInt filter(final IntPredicate intPredicate) {
        if (this.isPresent() && !intPredicate.test(this.value)) {
            return empty();
        }
        return this;
    }
    
    public OptionalInt filterNot(final IntPredicate intPredicate) {
        return this.filter(IntPredicate.Util.negate(intPredicate));
    }
    
    public int getAsInt() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }
    
    @Override
    public int hashCode() {
        if (this.isPresent) {
            return this.value;
        }
        return 0;
    }
    
    public void ifPresent(final IntConsumer intConsumer) {
        if (this.isPresent) {
            intConsumer.accept(this.value);
        }
    }
    
    public void ifPresentOrElse(final IntConsumer intConsumer, final Runnable runnable) {
        if (this.isPresent) {
            intConsumer.accept(this.value);
            return;
        }
        runnable.run();
    }
    
    public boolean isPresent() {
        return this.isPresent;
    }
    
    public OptionalInt map(final IntUnaryOperator intUnaryOperator) {
        if (!this.isPresent()) {
            return empty();
        }
        return of(intUnaryOperator.applyAsInt(this.value));
    }
    
    public OptionalDouble mapToDouble(final IntToDoubleFunction intToDoubleFunction) {
        if (!this.isPresent()) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(intToDoubleFunction.applyAsDouble(this.value));
    }
    
    public OptionalLong mapToLong(final IntToLongFunction intToLongFunction) {
        if (!this.isPresent()) {
            return OptionalLong.empty();
        }
        return OptionalLong.of(intToLongFunction.applyAsLong(this.value));
    }
    
    public <U> Optional<U> mapToObj(final IntFunction<U> intFunction) {
        if (!this.isPresent()) {
            return Optional.empty();
        }
        return Optional.ofNullable(intFunction.apply(this.value));
    }
    
    public OptionalInt or(final Supplier<OptionalInt> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public int orElse(int value) {
        if (this.isPresent) {
            value = this.value;
        }
        return value;
    }
    
    public int orElseGet(final IntSupplier intSupplier) {
        if (this.isPresent) {
            return this.value;
        }
        return intSupplier.getAsInt();
    }
    
    public <X extends Throwable> int orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }
    
    public IntStream stream() {
        if (!this.isPresent()) {
            return IntStream.empty();
        }
        return IntStream.of(this.value);
    }
    
    @Override
    public String toString() {
        if (this.isPresent) {
            return String.format("OptionalInt[%s]", this.value);
        }
        return "OptionalInt.empty";
    }
}
