// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.ThrowableFunction;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Supplier;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.ThrowableSupplier;

public class Exceptional<T>
{
    private final Throwable throwable;
    private final T value;
    
    private Exceptional(final T value, final Throwable throwable) {
        this.value = value;
        this.throwable = throwable;
    }
    
    public static <T> Exceptional<T> of(final ThrowableSupplier<T, Throwable> throwableSupplier) {
        try {
            return new Exceptional<T>(throwableSupplier.get(), null);
        }
        catch (Throwable t) {
            return of(t);
        }
    }
    
    public static <T> Exceptional<T> of(final Throwable t) {
        return new Exceptional<T>(null, t);
    }
    
    public <R> R custom(final Function<Exceptional<T>, R> function) {
        Objects.requireNonNull(function);
        return function.apply(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof Exceptional)) {
                return false;
            }
            final Exceptional exceptional = (Exceptional)o;
            if (!Objects.equals(this.value, exceptional.value) || !Objects.equals(this.throwable, exceptional.throwable)) {
                return false;
            }
        }
        return true;
    }
    
    public T get() {
        return this.value;
    }
    
    public Throwable getException() {
        return this.throwable;
    }
    
    public Optional<T> getOptional() {
        return Optional.ofNullable(this.value);
    }
    
    public T getOrElse(final Supplier<? extends T> supplier) {
        if (this.throwable == null) {
            return this.value;
        }
        return (T)supplier.get();
    }
    
    public T getOrElse(T value) {
        if (this.throwable == null) {
            value = this.value;
        }
        return value;
    }
    
    public T getOrThrow() throws Throwable {
        if (this.throwable != null) {
            throw this.throwable;
        }
        return this.value;
    }
    
    public <E extends Throwable> T getOrThrow(final E e) throws E, Throwable {
        if (this.throwable != null) {
            e.initCause(this.throwable);
            throw e;
        }
        return this.value;
    }
    
    public T getOrThrowRuntimeException() throws RuntimeException {
        if (this.throwable != null) {
            throw new RuntimeException(this.throwable);
        }
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.throwable);
    }
    
    public Exceptional<T> ifException(final Consumer<Throwable> consumer) {
        if (this.throwable != null) {
            consumer.accept(this.throwable);
        }
        return this;
    }
    
    public <E extends Throwable> Exceptional<T> ifExceptionIs(final Class<E> clazz, final Consumer<? super E> consumer) {
        if (this.throwable != null && clazz.isAssignableFrom(this.throwable.getClass())) {
            consumer.accept((Object)this.throwable);
        }
        return this;
    }
    
    public Exceptional<T> ifPresent(final Consumer<? super T> consumer) {
        if (this.throwable == null) {
            consumer.accept(this.value);
        }
        return this;
    }
    
    public boolean isPresent() {
        return this.throwable == null;
    }
    
    public <U> Exceptional<U> map(final ThrowableFunction<? super T, ? extends U, Throwable> throwableFunction) {
        if (this.throwable != null) {
            return of(this.throwable);
        }
        Objects.requireNonNull(throwableFunction);
        try {
            return new Exceptional<U>((U)throwableFunction.apply(this.value), null);
        }
        catch (Throwable t) {
            return of(t);
        }
    }
    
    public Exceptional<T> or(final Supplier<Exceptional<T>> supplier) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(supplier);
        return Objects.requireNonNull(supplier.get());
    }
    
    public Exceptional<T> recover(final ThrowableFunction<Throwable, ? extends T, Throwable> throwableFunction) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(throwableFunction);
        try {
            return new Exceptional<T>((T)throwableFunction.apply(this.throwable), null);
        }
        catch (Throwable t) {
            return of(t);
        }
    }
    
    public Exceptional<T> recoverWith(final Function<Throwable, ? extends Exceptional<T>> function) {
        if (this.throwable == null) {
            return this;
        }
        Objects.requireNonNull(function);
        return Objects.requireNonNull((Exceptional<T>)function.apply(this.throwable));
    }
    
    @Override
    public String toString() {
        if (this.throwable == null) {
            return String.format("Exceptional value %s", this.value);
        }
        return String.format("Exceptional throwable %s", this.throwable);
    }
}
