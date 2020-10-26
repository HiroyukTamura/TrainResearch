// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.reflect.InvocationTargetException;
import com.google.common.collect.ImmutableCollection;
import java.util.ArrayList;
import java.util.Collections;
import com.google.common.collect.Lists;
import com.google.common.base.Optional;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import com.google.common.collect.Queues;
import javax.annotation.Nullable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.Arrays;
import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import com.google.common.collect.Ordering;
import com.google.common.annotations.Beta;

@Beta
public final class Futures
{
    private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER;
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST;
    
    static {
        DEREFERENCER = new AsyncFunction<ListenableFuture<Object>, Object>() {
            @Override
            public ListenableFuture<Object> apply(final ListenableFuture<Object> listenableFuture) {
                return listenableFuture;
            }
        };
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf((Function<Object, ? extends Comparable>)new Function<Constructor<?>, Boolean>() {
            @Override
            public Boolean apply(final Constructor<?> constructor) {
                return Arrays.asList((Class<?>[])constructor.getParameterTypes()).contains(String.class);
            }
        }).reverse();
    }
    
    private Futures() {
    }
    
    public static <V> void addCallback(final ListenableFuture<V> listenableFuture, final FutureCallback<? super V> futureCallback) {
        addCallback(listenableFuture, futureCallback, MoreExecutors.directExecutor());
    }
    
    public static <V> void addCallback(final ListenableFuture<V> listenableFuture, final FutureCallback<? super V> futureCallback, final Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    futureCallback.onSuccess(Uninterruptibles.getUninterruptibly((Future<Object>)listenableFuture));
                }
                catch (ExecutionException ex) {
                    futureCallback.onFailure(ex.getCause());
                }
                catch (RuntimeException ex2) {
                    futureCallback.onFailure(ex2);
                }
                catch (Error error) {
                    futureCallback.onFailure(error);
                }
            }
        }, executor);
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(final Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return listFuture(ImmutableList.copyOf(iterable), true, MoreExecutors.directExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(final ListenableFuture<? extends V>... array) {
        return listFuture((ImmutableList<ListenableFuture<? extends V>>)ImmutableList.copyOf((ListenableFuture<? extends V>[])array), true, MoreExecutors.directExecutor());
    }
    
    private static <I, O> AsyncFunction<I, O> asAsyncFunction(final Function<? super I, ? extends O> function) {
        return new AsyncFunction<I, O>() {
            @Override
            public ListenableFuture<O> apply(final I n) {
                return Futures.immediateFuture(function.apply(n));
            }
        };
    }
    
    public static <V> ListenableFuture<V> dereference(final ListenableFuture<? extends ListenableFuture<? extends V>> listenableFuture) {
        return transform((ListenableFuture<Object>)listenableFuture, (AsyncFunction<? super Object, ? extends V>)Futures.DEREFERENCER);
    }
    
    public static <V, X extends Exception> V get(final Future<V> future, final long n, final TimeUnit timeUnit, final Class<X> clazz) throws X, Exception {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(timeUnit);
        Label_0050: {
            if (RuntimeException.class.isAssignableFrom(clazz)) {
                break Label_0050;
            }
            boolean b = true;
            while (true) {
                Preconditions.checkArgument(b, "Futures.get exception type (%s) must not be a RuntimeException", clazz);
                try {
                    return future.get(n, timeUnit);
                    b = false;
                }
                catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    throw newWithCause(clazz, ex);
                }
                catch (TimeoutException ex2) {
                    throw newWithCause(clazz, ex2);
                }
                catch (ExecutionException ex3) {
                    wrapAndThrowExceptionOrError(ex3.getCause(), clazz);
                    throw new AssertionError();
                }
            }
        }
    }
    
    public static <V, X extends Exception> V get(final Future<V> future, final Class<X> clazz) throws X, Exception {
        Preconditions.checkNotNull(future);
        Label_0039: {
            if (RuntimeException.class.isAssignableFrom(clazz)) {
                break Label_0039;
            }
            boolean b = true;
            while (true) {
                Preconditions.checkArgument(b, "Futures.get exception type (%s) must not be a RuntimeException", clazz);
                try {
                    return future.get();
                    b = false;
                }
                catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    throw newWithCause(clazz, ex);
                }
                catch (ExecutionException ex2) {
                    wrapAndThrowExceptionOrError(ex2.getCause(), clazz);
                    throw new AssertionError();
                }
            }
        }
    }
    
    public static <V> V getUnchecked(final Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        }
        catch (ExecutionException ex) {
            wrapAndThrowUnchecked(ex.getCause());
            throw new AssertionError();
        }
    }
    
    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateCancelledFuture<V>();
    }
    
    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable final V v) {
        return new ImmediateSuccessfulCheckedFuture<V, X>(v);
    }
    
    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(final X x) {
        Preconditions.checkNotNull(x);
        return new ImmediateFailedCheckedFuture<V, X>(x);
    }
    
    public static <V> ListenableFuture<V> immediateFailedFuture(final Throwable t) {
        Preconditions.checkNotNull(t);
        return new ImmediateFailedFuture<V>(t);
    }
    
    public static <V> ListenableFuture<V> immediateFuture(@Nullable final V v) {
        return new ImmediateSuccessfulFuture<V>(v);
    }
    
    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(final Iterable<? extends ListenableFuture<? extends T>> iterable) {
        final ConcurrentLinkedQueue<AsyncSettableFuture<Object>> concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        final ImmutableList.Builder<AsyncSettableFuture<Object>> builder = ImmutableList.builder();
        final SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
        for (final ListenableFuture listenableFuture : iterable) {
            final AsyncSettableFuture<Object> create = AsyncSettableFuture.create();
            concurrentLinkedQueue.add(create);
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    ((AsyncSettableFuture)concurrentLinkedQueue.remove()).setFuture(listenableFuture);
                }
            }, serializingExecutor);
            builder.add(create);
        }
        return (ImmutableList<ListenableFuture<T>>)builder.build();
    }
    
    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() {
            private O applyTransformation(final I n) throws ExecutionException {
                try {
                    return function.apply(n);
                }
                catch (Throwable cause) {
                    throw new ExecutionException(cause);
                }
            }
            
            @Override
            public boolean cancel(final boolean b) {
                return future.cancel(b);
            }
            
            @Override
            public O get() throws InterruptedException, ExecutionException {
                return this.applyTransformation(future.get());
            }
            
            @Override
            public O get(final long n, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return this.applyTransformation(future.get(n, timeUnit));
            }
            
            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }
            
            @Override
            public boolean isDone() {
                return future.isDone();
            }
        };
    }
    
    private static <V> ListenableFuture<List<V>> listFuture(final ImmutableList<ListenableFuture<? extends V>> list, final boolean b, final Executor executor) {
        return (ListenableFuture<List<V>>)new CombinedFuture(list, b, executor, (FutureCombiner<Object, Object>)new FutureCombiner<V, List<V>>() {
            public List<V> combine(final List<Optional<V>> list) {
                final ArrayList<Object> arrayList = Lists.newArrayList();
                for (final Optional<V> optional : list) {
                    Object orNull;
                    if (optional != null) {
                        orNull = optional.orNull();
                    }
                    else {
                        orNull = null;
                    }
                    arrayList.add(orNull);
                }
                return Collections.unmodifiableList((List<? extends V>)arrayList);
            }
        });
    }
    
    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(final ListenableFuture<V> listenableFuture, final Function<? super Exception, X> function) {
        return new MappingCheckedFuture<V, X>(Preconditions.checkNotNull(listenableFuture), function);
    }
    
    @Nullable
    private static <X> X newFromConstructor(final Constructor<X> constructor, final Throwable t) {
        final X x = null;
        final Class[] parameterTypes = constructor.getParameterTypes();
        final Object[] initargs = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; ++i) {
            final Class clazz = parameterTypes[i];
            if (clazz.equals(String.class)) {
                initargs[i] = t.toString();
            }
            else {
                final X instance = x;
                if (!clazz.equals(Throwable.class)) {
                    return instance;
                }
                initargs[i] = t;
            }
        }
        try {
            return constructor.newInstance(initargs);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
        catch (InstantiationException ex2) {
            return null;
        }
        catch (IllegalAccessException ex3) {
            return null;
        }
        catch (InvocationTargetException ex4) {
            return null;
        }
    }
    
    private static <X extends Exception> X newWithCause(final Class<X> obj, final Throwable t) {
        final Iterator<Constructor<Exception>> iterator = preferringStrings((List<Constructor<Exception>>)Arrays.asList((Constructor<X>[])obj.getConstructors())).iterator();
        while (iterator.hasNext()) {
            final Exception ex = newFromConstructor((Constructor<X>)iterator.next(), t);
            if (ex != null) {
                if (ex.getCause() == null) {
                    ex.initCause(t);
                }
                return (X)ex;
            }
        }
        final String value = String.valueOf(String.valueOf(obj));
        throw new IllegalArgumentException(new StringBuilder(value.length() + 82).append("No appropriate constructor for exception of type ").append(value).append(" in response to chained exception").toString(), t);
    }
    
    public static <V> ListenableFuture<V> nonCancellationPropagating(final ListenableFuture<V> listenableFuture) {
        return new NonCancellationPropagatingFuture<V>(listenableFuture);
    }
    
    private static <X extends Exception> List<Constructor<X>> preferringStrings(final List<Constructor<X>> list) {
        return Futures.WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }
    
    private static Runnable rejectionPropagatingRunnable(final AbstractFuture<?> abstractFuture, final Runnable runnable, final Executor executor) {
        return new Runnable() {
            @Override
            public void run() {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            atomicBoolean.set(false);
                            runnable.run();
                        }
                    });
                }
                catch (RejectedExecutionException exception) {
                    if (atomicBoolean.get()) {
                        abstractFuture.setException(exception);
                    }
                }
            }
        };
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(final Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return listFuture(ImmutableList.copyOf(iterable), false, MoreExecutors.directExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(final ListenableFuture<? extends V>... array) {
        return listFuture((ImmutableList<ListenableFuture<? extends V>>)ImmutableList.copyOf((ListenableFuture<? extends V>[])array), false, MoreExecutors.directExecutor());
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(function);
        final ChainingListenableFuture<Object, Object> chainingListenableFuture = new ChainingListenableFuture<Object, Object>((AsyncFunction)asAsyncFunction((Function<? super Object, ?>)function), (ListenableFuture)listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, MoreExecutors.directExecutor());
        return (ListenableFuture<O>)chainingListenableFuture;
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function, final Executor executor) {
        Preconditions.checkNotNull(function);
        return transform(listenableFuture, asAsyncFunction(function), executor);
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> listenableFuture, final AsyncFunction<? super I, ? extends O> asyncFunction) {
        final ChainingListenableFuture<Object, Object> chainingListenableFuture = new ChainingListenableFuture<Object, Object>((AsyncFunction)asyncFunction, (ListenableFuture)listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, MoreExecutors.directExecutor());
        return (ListenableFuture<O>)chainingListenableFuture;
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> listenableFuture, final AsyncFunction<? super I, ? extends O> asyncFunction, final Executor executor) {
        Preconditions.checkNotNull(executor);
        final ChainingListenableFuture<Object, Object> chainingListenableFuture = new ChainingListenableFuture<Object, Object>((AsyncFunction)asyncFunction, (ListenableFuture)listenableFuture);
        listenableFuture.addListener(rejectionPropagatingRunnable(chainingListenableFuture, chainingListenableFuture, executor), MoreExecutors.directExecutor());
        return (ListenableFuture<O>)chainingListenableFuture;
    }
    
    public static <V> ListenableFuture<V> withFallback(final ListenableFuture<? extends V> listenableFuture, final FutureFallback<? extends V> futureFallback) {
        return withFallback(listenableFuture, futureFallback, MoreExecutors.directExecutor());
    }
    
    public static <V> ListenableFuture<V> withFallback(final ListenableFuture<? extends V> listenableFuture, final FutureFallback<? extends V> futureFallback, final Executor executor) {
        Preconditions.checkNotNull(futureFallback);
        return new FallbackFuture<V>(listenableFuture, futureFallback, executor);
    }
    
    private static <X extends Exception> void wrapAndThrowExceptionOrError(final Throwable t, final Class<X> clazz) throws X, Exception {
        if (t instanceof Error) {
            throw new ExecutionError((Error)t);
        }
        if (t instanceof RuntimeException) {
            throw new UncheckedExecutionException(t);
        }
        throw newWithCause(clazz, t);
    }
    
    private static void wrapAndThrowUnchecked(final Throwable t) {
        if (t instanceof Error) {
            throw new ExecutionError((Error)t);
        }
        throw new UncheckedExecutionException(t);
    }
    
    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable
    {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private volatile ListenableFuture<? extends O> outputFuture;
        
        private ChainingListenableFuture(final AsyncFunction<? super I, ? extends O> asyncFunction, final ListenableFuture<? extends I> listenableFuture) {
            this.function = Preconditions.checkNotNull(asyncFunction);
            this.inputFuture = Preconditions.checkNotNull(listenableFuture);
        }
        
        private void cancel(@Nullable final Future<?> future, final boolean b) {
            if (future != null) {
                future.cancel(b);
            }
        }
        
        @Override
        public boolean cancel(final boolean b) {
            if (super.cancel(b)) {
                this.cancel(this.inputFuture, b);
                this.cancel(this.outputFuture, b);
                return true;
            }
            return false;
        }
        
        @Override
        public void run() {
            try {
                ListenableFuture<? extends O> outputFuture;
                try {
                    outputFuture = Preconditions.checkNotNull(this.function.apply((Object)Uninterruptibles.getUninterruptibly((Future<Object>)this.inputFuture)), (Object)"AsyncFunction may not return null.");
                    this.outputFuture = outputFuture;
                    if (this.isCancelled()) {
                        outputFuture.cancel(this.wasInterrupted());
                        this.outputFuture = null;
                        return;
                    }
                }
                catch (CancellationException ex3) {
                    this.cancel(false);
                    return;
                }
                catch (ExecutionException ex) {
                    this.setException(ex.getCause());
                    return;
                }
                outputFuture.addListener(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ChainingListenableFuture.this.set(Uninterruptibles.getUninterruptibly((Future<V>)outputFuture));
                        }
                        catch (CancellationException ex2) {
                            ChainingListenableFuture.this.cancel(false);
                        }
                        catch (ExecutionException ex) {
                            ChainingListenableFuture.this.setException(ex.getCause());
                        }
                        finally {
                            ChainingListenableFuture.this.outputFuture = null;
                        }
                    }
                }, MoreExecutors.directExecutor());
            }
            catch (UndeclaredThrowableException ex2) {
                this.setException(ex2.getCause());
            }
            catch (Throwable exception) {
                this.setException(exception);
            }
            finally {
                this.function = null;
                this.inputFuture = null;
            }
        }
    }
    
    private static class CombinedFuture<V, C> extends AbstractFuture<C>
    {
        private static final Logger logger;
        final boolean allMustSucceed;
        FutureCombiner<V, C> combiner;
        ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
        final AtomicInteger remaining;
        Set<Throwable> seenExceptions;
        final Object seenExceptionsLock;
        List<Optional<V>> values;
        
        static {
            logger = Logger.getLogger(CombinedFuture.class.getName());
        }
        
        CombinedFuture(final ImmutableCollection<? extends ListenableFuture<? extends V>> futures, final boolean allMustSucceed, final Executor executor, final FutureCombiner<V, C> combiner) {
            this.seenExceptionsLock = new Object();
            this.futures = futures;
            this.allMustSucceed = allMustSucceed;
            this.remaining = new AtomicInteger(futures.size());
            this.combiner = combiner;
            this.values = (List<Optional<V>>)Lists.newArrayListWithCapacity(futures.size());
            this.init(executor);
        }
        
        private void setExceptionAndMaybeLog(final Throwable t) {
            boolean setException = false;
            boolean add = true;
            Label_0054: {
                if (!this.allMustSucceed) {
                    break Label_0054;
                }
                setException = super.setException(t);
                synchronized (this.seenExceptionsLock) {
                    if (this.seenExceptions == null) {
                        this.seenExceptions = (Set<Throwable>)Sets.newHashSet();
                    }
                    add = this.seenExceptions.add(t);
                    // monitorexit(this.seenExceptionsLock)
                    if (t instanceof Error || (this.allMustSucceed && !setException && add)) {
                        CombinedFuture.logger.log(Level.SEVERE, "input future failed.", t);
                    }
                }
            }
        }
        
        private void setOneValue(int n, final Future<? extends V> future) {
            final boolean b = true;
            final boolean b2 = true;
            final boolean b3 = true;
            final boolean b4 = true;
            final boolean b5 = true;
            final List<Optional<V>> values = this.values;
            Label_0055: {
                if (!this.isDone() && values != null) {
                    break Label_0055;
                }
                Label_0142: {
                    if (!this.allMustSucceed && !this.isCancelled()) {
                        break Label_0142;
                    }
                    boolean b6 = true;
                    while (true) {
                        Preconditions.checkState(b6, (Object)"Future was done before all dependencies completed");
                        try {
                            Preconditions.checkState(future.isDone(), (Object)"Tried to set value from future which is not done");
                            final V uninterruptibly = Uninterruptibles.getUninterruptibly(future);
                            if (values != null) {
                                values.set(n, Optional.fromNullable(uninterruptibly));
                            }
                            n = this.remaining.decrementAndGet();
                            Preconditions.checkState(n >= 0 && b5, (Object)"Less than 0 remaining futures");
                            if (n == 0) {
                                final FutureCombiner<V, C> combiner = this.combiner;
                                if (combiner == null || values == null) {
                                    Preconditions.checkState(this.isDone());
                                    return;
                                }
                                this.set(combiner.combine(values));
                            }
                            return;
                        }
                        catch (CancellationException ex2) {
                            if (this.allMustSucceed) {
                                this.cancel(false);
                            }
                            n = this.remaining.decrementAndGet();
                            Preconditions.checkState(n >= 0 && b, (Object)"Less than 0 remaining futures");
                            if (n != 0) {
                                return;
                            }
                            final FutureCombiner<V, C> combiner2 = this.combiner;
                            if (combiner2 != null && values != null) {
                                this.set(combiner2.combine(values));
                                return;
                            }
                            Preconditions.checkState(this.isDone());
                        }
                        catch (ExecutionException ex) {
                            this.setExceptionAndMaybeLog(ex.getCause());
                            n = this.remaining.decrementAndGet();
                            Preconditions.checkState(n >= 0 && b2, (Object)"Less than 0 remaining futures");
                            if (n != 0) {
                                return;
                            }
                            final FutureCombiner<V, C> combiner3 = this.combiner;
                            if (combiner3 != null && values != null) {
                                this.set(combiner3.combine(values));
                                return;
                            }
                            Preconditions.checkState(this.isDone());
                        }
                        catch (Throwable exceptionAndMaybeLog) {
                            this.setExceptionAndMaybeLog(exceptionAndMaybeLog);
                            n = this.remaining.decrementAndGet();
                            Preconditions.checkState(n >= 0 && b3, (Object)"Less than 0 remaining futures");
                            if (n != 0) {
                                return;
                            }
                            final FutureCombiner<V, C> combiner4 = this.combiner;
                            if (combiner4 != null && values != null) {
                                this.set(combiner4.combine(values));
                                return;
                            }
                            Preconditions.checkState(this.isDone());
                        }
                        finally {
                            n = this.remaining.decrementAndGet();
                            b6 = (n >= 0 && b4);
                            Preconditions.checkState(b6, (Object)"Less than 0 remaining futures");
                            while (true) {
                                if (n != 0) {
                                    break Label_0443;
                                }
                                final FutureCombiner<V, C> combiner5 = this.combiner;
                                if (combiner5 != null && values != null) {
                                    this.set(combiner5.combine(values));
                                    break Label_0443;
                                }
                                Preconditions.checkState(this.isDone());
                                break Label_0443;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        
        protected void init(final Executor executor) {
            this.addListener(new Runnable() {
                @Override
                public void run() {
                    if (CombinedFuture.this.isCancelled()) {
                        final Iterator iterator = CombinedFuture.this.futures.iterator();
                        while (iterator.hasNext()) {
                            iterator.next().cancel(CombinedFuture.this.wasInterrupted());
                        }
                    }
                    CombinedFuture.this.futures = null;
                    CombinedFuture.this.values = null;
                    CombinedFuture.this.combiner = null;
                }
            }, MoreExecutors.directExecutor());
            if (this.futures.isEmpty()) {
                this.set(this.combiner.combine((List<Optional<V>>)ImmutableList.of()));
            }
            else {
                for (int i = 0; i < this.futures.size(); ++i) {
                    this.values.add(null);
                }
                int n = 0;
                for (final ListenableFuture listenableFuture : this.futures) {
                    listenableFuture.addListener(new Runnable() {
                        @Override
                        public void run() {
                            CombinedFuture.this.setOneValue(n, listenableFuture);
                        }
                    }, executor);
                    ++n;
                }
            }
        }
    }
    
    private static final class CombinerFuture<V> extends ListenableFutureTask<V>
    {
        ImmutableList<ListenableFuture<?>> futures;
        
        CombinerFuture(final Callable<V> callable, final ImmutableList<ListenableFuture<?>> futures) {
            super(callable);
            this.futures = futures;
        }
        
        @Override
        public boolean cancel(final boolean mayInterruptIfRunning) {
            final ImmutableList<ListenableFuture<?>> futures = this.futures;
            if (super.cancel(mayInterruptIfRunning)) {
                final Iterator iterator = futures.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cancel(mayInterruptIfRunning);
                }
                return true;
            }
            return false;
        }
        
        @Override
        protected void done() {
            super.done();
            this.futures = null;
        }
        
        @Override
        protected void setException(final Throwable exception) {
            super.setException(exception);
        }
    }
    
    private static class FallbackFuture<V> extends AbstractFuture<V>
    {
        private volatile ListenableFuture<? extends V> running;
        
        FallbackFuture(final ListenableFuture<? extends V> running, final FutureFallback<? extends V> futureFallback, final Executor executor) {
            Futures.addCallback((ListenableFuture<Object>)(this.running = running), (FutureCallback<? super Object>)new FutureCallback<V>() {
                @Override
                public void onFailure(final Throwable exception) {
                    if (FallbackFuture.this.isCancelled()) {
                        return;
                    }
                    try {
                        FallbackFuture.this.running = (ListenableFuture<? extends V>)futureFallback.create(exception);
                        if (FallbackFuture.this.isCancelled()) {
                            FallbackFuture.this.running.cancel(FallbackFuture.this.wasInterrupted());
                            return;
                        }
                    }
                    catch (Throwable exception) {
                        FallbackFuture.this.setException(exception);
                        return;
                    }
                    Futures.addCallback((ListenableFuture<Object>)FallbackFuture.this.running, (FutureCallback<? super Object>)new FutureCallback<V>() {
                        @Override
                        public void onFailure(final Throwable exception) {
                            if (FallbackFuture.this.running.isCancelled()) {
                                FallbackFuture.this.cancel(false);
                                return;
                            }
                            FallbackFuture.this.setException(exception);
                        }
                        
                        @Override
                        public void onSuccess(final V v) {
                            FallbackFuture.this.set(v);
                        }
                    }, MoreExecutors.directExecutor());
                }
                
                @Override
                public void onSuccess(final V v) {
                    FallbackFuture.this.set(v);
                }
            }, executor);
        }
        
        @Override
        public boolean cancel(final boolean b) {
            if (super.cancel(b)) {
                this.running.cancel(b);
                return true;
            }
            return false;
        }
    }
    
    private interface FutureCombiner<V, C>
    {
        C combine(final List<Optional<V>> p0);
    }
    
    private static class ImmediateCancelledFuture<V> extends ImmediateFuture<V>
    {
        private final CancellationException thrown;
        
        ImmediateCancelledFuture() {
            this.thrown = new CancellationException("Immediate cancelled future.");
        }
        
        @Override
        public V get() {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
        }
        
        @Override
        public boolean isCancelled() {
            return true;
        }
    }
    
    private static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X>
    {
        private final X thrown;
        
        ImmediateFailedCheckedFuture(final X thrown) {
            this.thrown = thrown;
        }
        
        @Override
        public V checkedGet() throws X, Exception {
            throw this.thrown;
        }
        
        @Override
        public V checkedGet(final long n, final TimeUnit timeUnit) throws X, Exception {
            Preconditions.checkNotNull(timeUnit);
            throw this.thrown;
        }
        
        @Override
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }
    
    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V>
    {
        private final Throwable thrown;
        
        ImmediateFailedFuture(final Throwable thrown) {
            this.thrown = thrown;
        }
        
        @Override
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }
    
    private abstract static class ImmediateFuture<V> implements ListenableFuture<V>
    {
        private static final Logger log;
        
        static {
            log = Logger.getLogger(ImmediateFuture.class.getName());
        }
        
        @Override
        public void addListener(final Runnable obj, final Executor obj2) {
            Preconditions.checkNotNull(obj, (Object)"Runnable was null.");
            Preconditions.checkNotNull(obj2, (Object)"Executor was null.");
            try {
                obj2.execute(obj);
            }
            catch (RuntimeException thrown) {
                final Logger log = ImmediateFuture.log;
                final Level severe = Level.SEVERE;
                final String value = String.valueOf(String.valueOf(obj));
                final String value2 = String.valueOf(String.valueOf(obj2));
                log.log(severe, new StringBuilder(value.length() + 57 + value2.length()).append("RuntimeException while executing runnable ").append(value).append(" with executor ").append(value2).toString(), thrown);
            }
        }
        
        @Override
        public boolean cancel(final boolean b) {
            return false;
        }
        
        @Override
        public abstract V get() throws ExecutionException;
        
        @Override
        public V get(final long n, final TimeUnit timeUnit) throws ExecutionException {
            Preconditions.checkNotNull(timeUnit);
            return this.get();
        }
        
        @Override
        public boolean isCancelled() {
            return false;
        }
        
        @Override
        public boolean isDone() {
            return true;
        }
    }
    
    private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X>
    {
        @Nullable
        private final V value;
        
        ImmediateSuccessfulCheckedFuture(@Nullable final V value) {
            this.value = value;
        }
        
        @Override
        public V checkedGet() {
            return this.value;
        }
        
        @Override
        public V checkedGet(final long n, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            return this.value;
        }
        
        @Override
        public V get() {
            return this.value;
        }
    }
    
    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V>
    {
        @Nullable
        private final V value;
        
        ImmediateSuccessfulFuture(@Nullable final V value) {
            this.value = value;
        }
        
        @Override
        public V get() {
            return this.value;
        }
    }
    
    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X>
    {
        final Function<? super Exception, X> mapper;
        
        MappingCheckedFuture(final ListenableFuture<V> listenableFuture, final Function<? super Exception, X> function) {
            super(listenableFuture);
            this.mapper = Preconditions.checkNotNull(function);
        }
        
        @Override
        protected X mapException(final Exception ex) {
            return this.mapper.apply(ex);
        }
    }
    
    private static class NonCancellationPropagatingFuture<V> extends AbstractFuture<V>
    {
        NonCancellationPropagatingFuture(final ListenableFuture<V> listenableFuture) {
            Preconditions.checkNotNull(listenableFuture);
            Futures.addCallback(listenableFuture, new FutureCallback<V>() {
                @Override
                public void onFailure(final Throwable exception) {
                    if (listenableFuture.isCancelled()) {
                        NonCancellationPropagatingFuture.this.cancel(false);
                        return;
                    }
                    NonCancellationPropagatingFuture.this.setException(exception);
                }
                
                @Override
                public void onSuccess(final V v) {
                    NonCancellationPropagatingFuture.this.set(v);
                }
            }, MoreExecutors.directExecutor());
        }
    }
    
    private static final class WrappedCombiner<T> implements Callable<T>
    {
        final Callable<T> delegate;
        CombinerFuture<T> outputFuture;
        
        WrappedCombiner(final Callable<T> callable) {
            this.delegate = Preconditions.checkNotNull(callable);
        }
        
        @Override
        public T call() throws Exception {
            try {
                return this.delegate.call();
            }
            catch (ExecutionException ex) {
                this.outputFuture.setException(ex.getCause());
            }
            catch (CancellationException ex2) {
                this.outputFuture.cancel(false);
                goto Label_0024;
            }
        }
    }
}
