package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpw;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

class zzdrc<V> implements zzdri<V> {
    private static final Logger zzhgm = Logger.getLogger(zzdrc.class.getName());
    static final zzdri<?> zzhia = new zzdrc((Object) null);
    @NullableDecl
    private final V value;

    static final class zza<V> extends zzdpw.zzj<V> {
        zza(Throwable th) {
            setException(th);
        }
    }

    zzdrc(@NullableDecl V v) {
        this.value = v;
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzdoj.checkNotNull(runnable, "Runnable was null.");
        zzdoj.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhgm;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", C0681a.m314a(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), e);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public V get() {
        return this.value;
    }

    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdoj.checkNotNull(timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.value);
        return C0681a.m314a(valueOf.length() + C0681a.m336b(obj, 27), obj, "[status=SUCCESS, result=[", valueOf, "]]");
    }
}
