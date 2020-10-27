package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcjs implements Callable {
    private final Context zzchn;
    private final zzdt zzgay;

    zzcjs(zzdt zzdt, Context context) {
        this.zzgay = zzdt;
        this.zzchn = context;
    }

    public final Object call() {
        zzdt zzdt = this.zzgay;
        return zzdt.zzcb().zzb(this.zzchn);
    }
}
