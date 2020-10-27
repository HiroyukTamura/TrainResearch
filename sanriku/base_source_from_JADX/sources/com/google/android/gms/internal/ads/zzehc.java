package com.google.android.gms.internal.ads;

public final class zzehc<T> implements zzegt<T>, zzegz<T> {
    private static final zzehc<Object> zzijh = new zzehc<>((Object) null);
    private final T zzdyi;

    private zzehc(T t) {
        this.zzdyi = t;
    }

    public static <T> zzegz<T> zzbb(T t) {
        return new zzehc(zzehf.zza(t, "instance cannot be null"));
    }

    public static <T> zzegz<T> zzbc(T t) {
        return t == null ? zzijh : new zzehc(t);
    }

    public final T get() {
        return this.zzdyi;
    }
}
