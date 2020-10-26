// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.ToLongFunction;
import com.annimon.stream.function.ToIntFunction;
import com.annimon.stream.function.ToDoubleFunction;
import java.util.NoSuchElementException;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;

public class Optional<T>
{
    private static final Optional<?> EMPTY;
    private final T value;
    
    static {
        EMPTY = new Optional<Object>();
    }
    
    private Optional() {
        this.value = null;
    }
    
    private Optional(final T t) {
        this.value = Objects.requireNonNull(t);
    }
    
    public static <T> Optional<T> empty() {
        return (Optional<T>)Optional.EMPTY;
    }
    
    public static <T> Optional<T> of(final T t) {
        return new Optional<T>(t);
    }
    
    public static <T> Optional<T> ofNullable(final T t) {
        if (t == null) {
            return empty();
        }
        return (Optional<T>)of((Object)t);
    }
    
    public <R> R custom(final Function<Optional<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof Optional && Objects.equals(this.value, ((Optional)o).value));
    }
    
    public Optional<T> executeIfAbsent(final Runnable runnable) {
        if (this.value == null) {
            runnable.run();
        }
        return this;
    }
    
    public Optional<T> executeIfPresent(final Consumer<? super T> consumer) {
        this.ifPresent(consumer);
        return this;
    }
    
    public Optional<T> filter(final Predicate<? super T> predicate) {
        if (this.isPresent() && !predicate.test(this.value)) {
            return empty();
        }
        return this;
    }
    
    public Optional<T> filterNot(final Predicate<? super T> predicate) {
        return this.filter(Predicate.Util.negate(predicate));
    }
    
    public <U> Optional<U> flatMap(final Function<? super T, Optional<U>> function) {
        if (!this.isPresent()) {
            return empty();
        }
        return Objects.requireNonNull(function.apply(this.value));
    }
    
    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }
    
    public void ifPresent(final Consumer<? super T> consumer) {
        if (this.value != null) {
            consumer.accept(this.value);
        }
    }
    
    public void ifPresentOrElse(final Consumer<? super T> consumer, final Runnable runnable) {
        if (this.value != null) {
            consumer.accept(this.value);
            return;
        }
        runnable.run();
    }
    
    public boolean isPresent() {
        return this.value != null;
    }
    
    public <U> Optional<U> map(final Function<? super T, ? extends U> function) {
        if (!this.isPresent()) {
            return empty();
        }
        return ofNullable((U)function.apply(this.value));
    }
    
    public OptionalDouble mapToDouble(final ToDoubleFunction<? super T> toDoubleFunction) {
        if (!this.isPresent()) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(toDoubleFunction.applyAsDouble(this.value));
    }
    
    public OptionalInt mapToInt(final ToIntFunction<? super T> toIntFunction) {
        if (!this.isPresent()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(toIntFunction.applyAsInt(this.value));
    }
    
    public OptionalLong mapToLong(final ToLongFunction<? super T> toLongFunction) {
        if (!this.isPresent()) {
            return OptionalLong.empty();
        }
        return OptionalLong.of(toLongFunction.applyAsLong(this.value));
    }
    
    public Optional<T> or(final Supplier<Optional<T>> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public T orElse(T value) {
        if (this.value != null) {
            value = this.value;
        }
        return value;
    }
    
    public T orElseGet(final Supplier<? extends T> supplier) {
        if (this.value != null) {
            return this.value;
        }
        return (T)supplier.get();
    }
    
    public <X extends Throwable> T orElseThrow(final Supplier<? extends X> supplier) throws X, Throwable {
        if (this.value != null) {
            return this.value;
        }
        throw (Throwable)supplier.get();
    }
    
    public <R> Optional<R> select(final Class<R> clazz) {
        Objects.requireNonNull(clazz);
        if (!this.isPresent()) {
            return empty();
        }
        Object value;
        if (clazz.isInstance(this.value)) {
            value = this.value;
        }
        else {
            value = null;
        }
        return ofNullable(value);
    }
    
    public Stream<T> stream() {
        if (!this.isPresent()) {
            return Stream.empty();
        }
        return Stream.of(this.value);
    }
    
    @Override
    public String toString() {
        if (this.value != null) {
            return String.format("Optional[%s]", this.value);
        }
        return "Optional.empty";
    }
}
