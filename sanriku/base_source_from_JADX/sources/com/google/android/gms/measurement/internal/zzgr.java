package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzgr implements Callable<byte[]> {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzge zzc;

    zzgr(zzge zzge, zzao zzao, String str) {
        this.zzc = zzge;
        this.zza = zzao;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzo();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
