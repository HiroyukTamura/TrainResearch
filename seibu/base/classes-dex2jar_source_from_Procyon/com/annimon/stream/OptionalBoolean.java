// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.BooleanSupplier;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.BooleanFunction;
import java.util.NoSuchElementException;
import com.annimon.stream.function.BooleanPredicate;
import com.annimon.stream.function.BooleanConsumer;
import com.annimon.stream.function.Function;

public final class OptionalBoolean
{
    private static final OptionalBoolean EMPTY;
    private static final OptionalBoolean FALSE;
    private static final OptionalBoolean TRUE;
    private final boolean isPresent;
    private final boolean value;
    
    static {
        EMPTY = new OptionalBoolean();
        TRUE = new OptionalBoolean(true);
        FALSE = new OptionalBoolean(false);
    }
    
    private OptionalBoolean() {
        this.isPresent = false;
        this.value = false;
    }
    
    private OptionalBoolean(final boolean value) {
        this.isPresent = true;
        this.value = value;
    }
    
    public static OptionalBoolean empty() {
        return OptionalBoolean.EMPTY;
    }
    
    public static OptionalBoolean of(final boolean b) {
        if (b) {
            return OptionalBoolean.TRUE;
        }
        return OptionalBoolean.FALSE;
    }
    
    public <R> R custom(final Function<OptionalBoolean, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof OptionalBoolean)) {
                return false;
            }
            final OptionalBoolean optionalBoolean = (OptionalBoolean)o;
            if (this.isPresent && optionalBoolean.isPresent) {
                if (this.value != optionalBoolean.value) {
                    return false;
                }
            }
            else if (this.isPresent != optionalBoolean.isPresent) {
                return false;
            }
        }
        return true;
    }
    
    public OptionalBoolean executeIfAbsent(final Runnable runnable) {
        if (!this.isPresent()) {
            runnable.run();
        }
        return this;
    }
    
    public OptionalBoolean executeIfPresent(final BooleanConsumer booleanConsumer) {
        this.ifPresent(booleanConsumer);
        return this;
    }
    
    public OptionalBoolean filter(final BooleanPredicate booleanPredicate) {
        if (this.isPresent() && !booleanPredicate.test(this.value)) {
            return empty();
        }
        return this;
    }
    
    public OptionalBoolean filterNot(final BooleanPredicate booleanPredicate) {
        return this.filter(BooleanPredicate.Util.negate(booleanPredicate));
    }
    
    public boolean getAsBoolean() {
        if (!this.isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }
    
    @Override
    public int hashCode() {
        if (!this.isPresent) {
            return 0;
        }
        if (this.value) {
            return 1231;
        }
        return 1237;
    }
    
    public void ifPresent(final BooleanConsumer booleanConsumer) {
        if (this.isPresent) {
            booleanConsumer.accept(this.value);
        }
    }
    
    public void ifPresentOrElse(final BooleanConsumer booleanConsumer, final Runnable runnable) {
        if (this.isPresent) {
            booleanConsumer.accept(this.value);
            return;
        }
        runnable.run();
    }
    
    public boolean isPresent() {
        return this.isPresent;
    }
    
    public OptionalBoolean map(final BooleanPredicate booleanPredicate) {
        if (!this.isPresent()) {
            return empty();
        }
        Objects.requireNonNull(booleanPredicate);
        return of(booleanPredicate.test(this.value));
    }
    
    public <U> Optional<U> mapToObj(final BooleanFunction<U> booleanFunction) {
        if (!this.isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(booleanFunction);
        return Optional.ofNullable(booleanFunction.apply(this.value));
    }
    
    public OptionalBoolean or(final Supplier<OptionalBoolean> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public boolean orElse(boolean value) {
        if (this.isPresent) {
            value = this.value;
        }
        return value;
    }
    
    public boolean orElseGet(final BooleanSupplier booleanSupplier) {
        if (this.isPresent) {
            return this.value;
        }
        return booleanSupplier.getAsBoolean();
    }
    
    public <X extends Throwable> boolean orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }
    
    @Override
    public String toString() {
        if (!this.isPresent) {
            return "OptionalBoolean.empty";
        }
        if (this.value) {
            return "OptionalBoolean[true]";
        }
        return "OptionalBoolean[false]";
    }
}
