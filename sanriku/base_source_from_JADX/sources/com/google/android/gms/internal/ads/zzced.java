package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzced implements Callable<zzcdt> {
    /* access modifiers changed from: private */
    public final zzbes zzbnm;
    /* access modifiers changed from: private */
    public final zzazz zzdls;
    /* access modifiers changed from: private */
    public final zzdt zzejl;
    /* access modifiers changed from: private */
    public final Executor zzfhi;
    /* access modifiers changed from: private */
    public final zza zzfvf;
    /* access modifiers changed from: private */
    public final Context zzvf;

    public zzced(Context context, Executor executor, zzdt zzdt, zzazz zzazz, zza zza, zzbes zzbes) {
        this.zzvf = context;
        this.zzfhi = executor;
        this.zzejl = zzdt;
        this.zzdls = zzazz;
        this.zzfvf = zza;
        this.zzbnm = zzbes;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzcdt zzcdt = new zzcdt(this);
        zzcdt.zzamp();
        return zzcdt;
    }
}
