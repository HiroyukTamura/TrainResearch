package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzhs implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzhh zze;

    zzhs(zzhh zzhh, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zzhh;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final void run() {
        this.zze.zzy.zzw().zza((AtomicReference<List<zzw>>) this.zza, this.zzb, this.zzc, this.zzd);
    }
}
