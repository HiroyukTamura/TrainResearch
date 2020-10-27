package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrc;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdqw extends zzdrd {
    public static <V> zzdri<V> immediateFailedFuture(Throwable th) {
        zzdoj.checkNotNull(th);
        return new zzdrc.zza(th);
    }

    @SafeVarargs
    public static <V> zzdrb<V> zza(zzdri<? extends V>... zzdriArr) {
        return new zzdrb<>(false, zzdou.zzb(zzdriArr), (zzdqz) null);
    }

    public static <O> zzdri<O> zza(zzdqh<O> zzdqh, Executor executor) {
        zzdrw zzdrw = new zzdrw(zzdqh);
        executor.execute(zzdrw);
        return zzdrw;
    }

    public static <V> zzdri<V> zza(zzdri<V> zzdri, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdri.isDone() ? zzdri : zzdrs.zzb(zzdri, j, timeUnit, scheduledExecutorService);
    }

    public static <V> V zza(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzdsa.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdok.zzb("Future was expected to be done: %s", future));
    }

    public static <V> void zza(zzdri<V> zzdri, zzdqx<? super V> zzdqx, Executor executor) {
        zzdoj.checkNotNull(zzdqx);
        zzdri.addListener(new zzdqy(zzdri, zzdqx), executor);
    }

    public static <V> zzdri<V> zzag(@NullableDecl V v) {
        return v == null ? zzdrc.zzhia : new zzdrc(v);
    }

    @SafeVarargs
    public static <V> zzdrb<V> zzb(zzdri<? extends V>... zzdriArr) {
        return new zzdrb<>(true, zzdou.zzb(zzdriArr), (zzdqz) null);
    }

    public static <I, O> zzdri<O> zzb(zzdri<I> zzdri, zzdnx<? super I, ? extends O> zzdnx, Executor executor) {
        return zzdpy.zza(zzdri, zzdnx, executor);
    }

    public static <I, O> zzdri<O> zzb(zzdri<I> zzdri, zzdqj<? super I, ? extends O> zzdqj, Executor executor) {
        return zzdpy.zza(zzdri, zzdqj, executor);
    }

    public static <V, X extends Throwable> zzdri<V> zzb(zzdri<? extends V> zzdri, Class<X> cls, zzdqj<? super X, ? extends V> zzdqj, Executor executor) {
        return zzdpv.zza(zzdri, cls, zzdqj, executor);
    }

    public static <V> V zzb(Future<V> future) {
        zzdoj.checkNotNull(future);
        try {
            return zzdsa.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdqo((Error) cause);
            }
            throw new zzdrx(cause);
        }
    }

    public static <V> zzdri<List<V>> zzi(Iterable<? extends zzdri<? extends V>> iterable) {
        return new zzdql(zzdou.zzh(iterable), true);
    }

    public static <V> zzdrb<V> zzj(Iterable<? extends zzdri<? extends V>> iterable) {
        return new zzdrb<>(false, zzdou.zzh(iterable), (zzdqz) null);
    }

    public static <V> zzdrb<V> zzk(Iterable<? extends zzdri<? extends V>> iterable) {
        return new zzdrb<>(true, zzdou.zzh(iterable), (zzdqz) null);
    }
}
