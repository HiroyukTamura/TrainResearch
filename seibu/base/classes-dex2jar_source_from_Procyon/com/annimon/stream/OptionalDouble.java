// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.function.DoubleUnaryOperator;
import java.util.NoSuchElementException;
import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.function.DoubleConsumer;
import com.annimon.stream.function.Function;

public final class OptionalDouble
{
    private static final OptionalDouble EMPTY;
    private final boolean isPresent;
    private final double value;
    
    static {
        EMPTY = new OptionalDouble();
    }
    
    private OptionalDouble() {
        this.isPresent = false;
        this.value = 0.0;
    }
    
    private OptionalDouble(final double value) {
        this.isPresent = true;
        this.value = value;
    }
    
    public static OptionalDouble empty() {
        return OptionalDouble.EMPTY;
    }
    
    public static OptionalDouble of(final double n) {
        return new OptionalDouble(n);
    }
    
    public <R> R custom(final Function<OptionalDouble, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof OptionalDouble)) {
                return false;
            }
            final OptionalDouble optionalDouble = (OptionalDouble)o;
            if (this.isPresent && optionalDouble.isPresent) {
                if (Double.compare(this.value, optionalDouble.value) != 0) {
                    return false;
                }
            }
            else if (this.isPresent != optionalDouble.isPresent) {
                return false;
            }
        }
        return true;
    }
    
    public OptionalDouble executeIfAbsent(final Runnable runnable) {
        if (!this.isPresent()) {
            runnable.run();
        }
        return this;
    }
    
    public OptionalDouble executeIfPresent(final DoubleConsumer doubleConsumer) {
        this.ifPresent(doubleConsumer);
        return this;
    }
    
    public OptionalDouble filter(final DoublePredicate doublePredicate) {
        if (this.isPresent() && !doublePredicate.test(this.value)) {
            return empty();
        }
        return this;
    }
    
    public OptionalDouble filterNot(final DoublePredicate doublePredicate) {
        return this.filter(DoublePredicate.Util.negate(doublePredicate));
    }
    
    public double getAsDouble() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }
    
    @Override
    public int hashCode() {
        if (this.isPresent) {
            return Objects.hashCode(this.value);
        }
        return 0;
    }
    
    public void ifPresent(final DoubleConsumer doubleConsumer) {
        if (this.isPresent) {
            doubleConsumer.accept(this.value);
        }
    }
    
    public void ifPresentOrElse(final DoubleConsumer doubleConsumer, final Runnable runnable) {
        if (this.isPresent) {
            doubleConsumer.accept(this.value);
            return;
        }
        runnable.run();
    }
    
    public boolean isPresent() {
        return this.isPresent;
    }
    
    public OptionalDouble map(final DoubleUnaryOperator doubleUnaryOperator) {
        if (!this.isPresent()) {
            return empty();
        }
        Objects.requireNonNull(doubleUnaryOperator);
        return of(doubleUnaryOperator.applyAsDouble(this.value));
    }
    
    public OptionalInt mapToInt(final DoubleToIntFunction doubleToIntFunction) {
        if (!this.isPresent()) {
            return OptionalInt.empty();
        }
        Objects.requireNonNull(doubleToIntFunction);
        return OptionalInt.of(doubleToIntFunction.applyAsInt(this.value));
    }
    
    public OptionalLong mapToLong(final DoubleToLongFunction doubleToLongFunction) {
        if (!this.isPresent()) {
            return OptionalLong.empty();
        }
        Objects.requireNonNull(doubleToLongFunction);
        return OptionalLong.of(doubleToLongFunction.applyAsLong(this.value));
    }
    
    public <U> Optional<U> mapToObj(final DoubleFunction<U> doubleFunction) {
        if (!this.isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(doubleFunction);
        return Optional.ofNullable(doubleFunction.apply(this.value));
    }
    
    public OptionalDouble or(final Supplier<OptionalDouble> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public double orElse(double value) {
        if (this.isPresent) {
            value = this.value;
        }
        return value;
    }
    
    public double orElseGet(final DoubleSupplier doubleSupplier) {
        if (this.isPresent) {
            return this.value;
        }
        return doubleSupplier.getAsDouble();
    }
    
    public <X extends Throwable> double orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }
    
    public DoubleStream stream() {
        if (!this.isPresent()) {
            return DoubleStream.empty();
        }
        return DoubleStream.of(this.value);
    }
    
    @Override
    public String toString() {
        if (this.isPresent) {
            return String.format("OptionalDouble[%s]", this.value);
        }
        return "OptionalDouble.empty";
    }
}
