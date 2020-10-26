// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import com.google.common.annotations.Beta;
import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Suppliers
{
    private Suppliers() {
    }
    
    public static <F, T> Supplier<T> compose(final Function<? super F, T> function, final Supplier<F> supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(supplier);
        return new SupplierComposition<Object, T>(function, supplier);
    }
    
    public static <T> Supplier<T> memoize(final Supplier<T> supplier) {
        if (supplier instanceof MemoizingSupplier) {
            return supplier;
        }
        return new MemoizingSupplier<T>(Preconditions.checkNotNull(supplier));
    }
    
    public static <T> Supplier<T> memoizeWithExpiration(final Supplier<T> supplier, final long n, final TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier<T>(supplier, n, timeUnit);
    }
    
    public static <T> Supplier<T> ofInstance(@Nullable final T t) {
        return new SupplierOfInstance<T>(t);
    }
    
    @Beta
    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return (Function<Supplier<T>, T>)SupplierFunctionImpl.INSTANCE;
    }
    
    public static <T> Supplier<T> synchronizedSupplier(final Supplier<T> supplier) {
        return new ThreadSafeSupplier<T>(Preconditions.checkNotNull(supplier));
    }
    
    @VisibleForTesting
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Supplier<T> delegate;
        final long durationNanos;
        transient volatile long expirationNanos;
        transient volatile T value;
        
        ExpiringMemoizingSupplier(final Supplier<T> supplier, final long duration, final TimeUnit timeUnit) {
            this.delegate = Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(duration);
            Preconditions.checkArgument(duration > 0L);
        }
        
        @Override
        public T get() {
            long expirationNanos = this.expirationNanos;
            final long systemNanoTime = Platform.systemNanoTime();
            Label_0078: {
                if (expirationNanos != 0L && systemNanoTime - expirationNanos < 0L) {
                    break Label_0078;
                }
                while (true) {
                    while (true) {
                        Label_0090: {
                            synchronized (this) {
                                if (expirationNanos != this.expirationNanos) {
                                    // monitorexit(this)
                                    return this.value;
                                }
                                final T value = this.delegate.get();
                                this.value = value;
                                expirationNanos = systemNanoTime + this.durationNanos;
                                if (expirationNanos == 0L) {
                                    expirationNanos = 1L;
                                    this.expirationNanos = expirationNanos;
                                    return value;
                                }
                                break Label_0090;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.delegate));
            return new StringBuilder(value.length() + 62).append("Suppliers.memoizeWithExpiration(").append(value).append(", ").append(this.durationNanos).append(", NANOS)").toString();
        }
    }
    
    @VisibleForTesting
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Supplier<T> delegate;
        transient volatile boolean initialized;
        transient T value;
        
        MemoizingSupplier(final Supplier<T> delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public T get() {
            Label_0042: {
                if (this.initialized) {
                    break Label_0042;
                }
                synchronized (this) {
                    if (!this.initialized) {
                        final T value = this.delegate.get();
                        this.value = value;
                        this.initialized = true;
                        return value;
                    }
                    // monitorexit(this)
                    return this.value;
                }
            }
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.delegate));
            return new StringBuilder(value.length() + 19).append("Suppliers.memoize(").append(value).append(")").toString();
        }
    }
    
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Function<? super F, T> function;
        final Supplier<F> supplier;
        
        SupplierComposition(final Function<? super F, T> function, final Supplier<F> supplier) {
            this.function = function;
            this.supplier = supplier;
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof SupplierComposition) {
                final SupplierComposition supplierComposition = (SupplierComposition)o;
                b2 = b;
                if (this.function.equals(supplierComposition.function)) {
                    b2 = b;
                    if (this.supplier.equals(supplierComposition.supplier)) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public T get() {
            return this.function.apply((Object)this.supplier.get());
        }
        
        @Override
        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.function));
            final String value2 = String.valueOf(String.valueOf(this.supplier));
            return new StringBuilder(value.length() + 21 + value2.length()).append("Suppliers.compose(").append(value).append(", ").append(value2).append(")").toString();
        }
    }
    
    private interface SupplierFunction<T> extends Function<Supplier<T>, T>
    {
    }
    
    private enum SupplierFunctionImpl implements SupplierFunction<Object>
    {
        INSTANCE;
        
        @Override
        public Object apply(final Supplier<Object> supplier) {
            return supplier.get();
        }
        
        @Override
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }
    
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final T instance;
        
        SupplierOfInstance(@Nullable final T instance) {
            this.instance = instance;
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof SupplierOfInstance && Objects.equal(this.instance, ((SupplierOfInstance)o).instance);
        }
        
        @Override
        public T get() {
            return this.instance;
        }
        
        @Override
        public int hashCode() {
            return Objects.hashCode(this.instance);
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.instance));
            return new StringBuilder(value.length() + 22).append("Suppliers.ofInstance(").append(value).append(")").toString();
        }
    }
    
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable
    {
        private static final long serialVersionUID = 0L;
        final Supplier<T> delegate;
        
        ThreadSafeSupplier(final Supplier<T> delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public T get() {
            synchronized (this.delegate) {
                return this.delegate.get();
            }
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.delegate));
            return new StringBuilder(value.length() + 32).append("Suppliers.synchronizedSupplier(").append(value).append(")").toString();
        }
    }
}
