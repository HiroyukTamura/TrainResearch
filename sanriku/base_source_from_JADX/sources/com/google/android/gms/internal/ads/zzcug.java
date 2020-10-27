package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcug implements Callable {
    private final zzcuh zzgkn;
    private final List zzgko;
    private final IObjectWrapper zzgkp;

    zzcug(zzcuh zzcuh, List list, IObjectWrapper iObjectWrapper) {
        this.zzgkn = zzcuh;
        this.zzgko = list;
        this.zzgkp = iObjectWrapper;
    }

    public final Object call() {
        return this.zzgkn.zza(this.zzgko, this.zzgkp);
    }
}
