package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzgt implements Callable<List<zzkt>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    zzgt(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
