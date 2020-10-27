package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdao<T> implements zzegz<zzdaj<T>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Set<zzdak<? extends zzdah<T>>>> zzgov;

    private zzdao(zzehm<Executor> zzehm, zzehm<Set<zzdak<? extends zzdah<T>>>> zzehm2) {
        this.zzenm = zzehm;
        this.zzgov = zzehm2;
    }

    public static <T> zzdaj<T> zza(Executor executor, Set<zzdak<? extends zzdah<T>>> set) {
        return new zzdaj<>(executor, set);
    }

    public static <T> zzdao<T> zzbb(zzehm<Executor> zzehm, zzehm<Set<zzdak<? extends zzdah<T>>>> zzehm2) {
        return new zzdao<>(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzenm.get(), this.zzgov.get());
    }
}
