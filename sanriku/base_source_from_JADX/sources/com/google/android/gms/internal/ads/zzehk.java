package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzehk<T> {
    private final List<zzehm<T>> zzijj;
    private final List<zzehm<Collection<T>>> zzijk;

    private zzehk(int i, int i2) {
        this.zzijj = zzegy.zzhs(i);
        this.zzijk = zzegy.zzhs(i2);
    }

    public final zzehk<T> zzat(zzehm<? extends T> zzehm) {
        this.zzijj.add(zzehm);
        return this;
    }

    public final zzehk<T> zzau(zzehm<? extends Collection<? extends T>> zzehm) {
        this.zzijk.add(zzehm);
        return this;
    }

    public final zzehi<T> zzbit() {
        return new zzehi<>(this.zzijj, this.zzijk);
    }
}
