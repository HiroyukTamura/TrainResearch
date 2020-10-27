package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p064d.p065a.p066a.C1567a;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        SafeFuture<T> future;
        Object tag;

        Completer() {
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture != null && !safeFuture.isDone()) {
                StringBuilder a = C0681a.m330a("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
                a.append(this.tag);
                safeFuture.setException(new FutureGarbageCollectedException(a.toString()));
            }
            if (!this.attemptedSetting && (resolvableFuture = this.cancellationFuture) != null) {
                resolvableFuture.set(null);
            }
        }

        /* access modifiers changed from: package-private */
        public void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T t) {
            boolean z = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.set(t)) {
                z = false;
            }
            if (z) {
                setCompletedNormally();
            }
            return z;
        }

        public boolean setCancelled() {
            boolean z = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.cancelWithoutNotifyingCompleter(true)) {
                z = false;
            }
            if (z) {
                setCompletedNormally();
            }
            return z;
        }

        public boolean setException(@NonNull Throwable th) {
            boolean z = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture == null || !safeFuture.setException(th)) {
                z = false;
            }
            if (z) {
                setCompletedNormally();
            }
            return z;
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    private static final class SafeFuture<T> implements C1567a<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() {
            /* access modifiers changed from: protected */
            public String pendingToString() {
                Completer completer = (Completer) SafeFuture.this.completerWeakReference.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                StringBuilder a = C0681a.m330a("tag=[");
                a.append(completer.tag);
                a.append("]");
                return a.toString();
            }
        };

        SafeFuture(Completer<T> completer) {
            this.completerWeakReference = new WeakReference<>(completer);
        }

        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        public boolean cancel(boolean z) {
            Completer completer = (Completer) this.completerWeakReference.get();
            boolean cancel = this.delegate.cancel(z);
            if (cancel && completer != null) {
                completer.fireCancellationListeners();
            }
            return cancel;
        }

        /* access modifiers changed from: package-private */
        public boolean cancelWithoutNotifyingCompleter(boolean z) {
            return this.delegate.cancel(z);
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public T get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(j, timeUnit);
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public boolean isDone() {
            return this.delegate.isDone();
        }

        /* access modifiers changed from: package-private */
        public boolean set(T t) {
            return this.delegate.set(t);
        }

        /* access modifiers changed from: package-private */
        public boolean setException(Throwable th) {
            return this.delegate.setException(th);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> C1567a<T> getFuture(@NonNull Resolver<T> resolver) {
        Completer completer = new Completer();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.tag = attachCompleter;
            }
        } catch (Exception e) {
            safeFuture.setException(e);
        }
        return safeFuture;
    }
}
