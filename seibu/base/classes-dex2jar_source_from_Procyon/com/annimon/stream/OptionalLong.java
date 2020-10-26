// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.LongFunction;
import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.function.LongUnaryOperator;
import java.util.NoSuchElementException;
import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.function.Function;

public final class OptionalLong
{
    private static final OptionalLong EMPTY;
    private final boolean isPresent;
    private final long value;
    
    static {
        EMPTY = new OptionalLong();
    }
    
    private OptionalLong() {
        this.isPresent = false;
        this.value = 0L;
    }
    
    private OptionalLong(final long value) {
        this.isPresent = true;
        this.value = value;
    }
    
    public static OptionalLong empty() {
        return OptionalLong.EMPTY;
    }
    
    public static OptionalLong of(final long n) {
        return new OptionalLong(n);
    }
    
    public <R> R custom(final Function<OptionalLong, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof OptionalLong)) {
                return false;
            }
            final OptionalLong optionalLong = (OptionalLong)o;
            if (this.isPresent && optionalLong.isPresent) {
                if (this.value != optionalLong.value) {
                    return false;
                }
            }
            else if (this.isPresent != optionalLong.isPresent) {
                return false;
            }
        }
        return true;
    }
    
    public OptionalLong executeIfAbsent(final Runnable runnable) {
        if (!this.isPresent()) {
            runnable.run();
        }
        return this;
    }
    
    public OptionalLong executeIfPresent(final LongConsumer longConsumer) {
        this.ifPresent(longConsumer);
        return this;
    }
    
    public OptionalLong filter(final LongPredicate longPredicate) {
        if (this.isPresent() && !longPredicate.test(this.value)) {
            return empty();
        }
        return this;
    }
    
    public OptionalLong filterNot(final LongPredicate longPredicate) {
        return this.filter(LongPredicate.Util.negate(longPredicate));
    }
    
    public long getAsLong() {
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
    
    public void ifPresent(final LongConsumer longConsumer) {
        if (this.isPresent) {
            longConsumer.accept(this.value);
        }
    }
    
    public void ifPresentOrElse(final LongConsumer longConsumer, final Runnable runnable) {
        if (this.isPresent) {
            longConsumer.accept(this.value);
            return;
        }
        runnable.run();
    }
    
    public boolean isPresent() {
        return this.isPresent;
    }
    
    public OptionalLong map(final LongUnaryOperator longUnaryOperator) {
        if (!this.isPresent()) {
            return empty();
        }
        Objects.requireNonNull(longUnaryOperator);
        return of(longUnaryOperator.applyAsLong(this.value));
    }
    
    public OptionalInt mapToInt(final LongToIntFunction longToIntFunction) {
        if (!this.isPresent()) {
            return OptionalInt.empty();
        }
        Objects.requireNonNull(longToIntFunction);
        return OptionalInt.of(longToIntFunction.applyAsInt(this.value));
    }
    
    public <U> Optional<U> mapToObj(final LongFunction<U> longFunction) {
        if (!this.isPresent()) {
            return Optional.empty();
        }
        Objects.requireNonNull(longFunction);
        return Optional.ofNullable(longFunction.apply(this.value));
    }
    
    public OptionalLong or(final Supplier<OptionalLong> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public long orElse(long value) {
        if (this.isPresent) {
            value = this.value;
        }
        return value;
    }
    
    public long orElseGet(final LongSupplier longSupplier) {
        if (this.isPresent) {
            return this.value;
        }
        return longSupplier.getAsLong();
    }
    
    public <X extends Throwable> long orElseThrow(final Supplier<X> supplier) throws X, Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }
    
    public LongStream stream() {
        if (!this.isPresent()) {
            return LongStream.empty();
        }
        return LongStream.of(this.value);
    }
    
    @Override
    public String toString() {
        if (this.isPresent) {
            return String.format("OptionalLong[%s]", this.value);
        }
        return "OptionalLong.empty";
    }
}
