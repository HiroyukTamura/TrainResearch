package com.google.android.gms.measurement.internal;

final class zzgo implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzge zzc;

    zzgo(zzge zzge, zzao zzao, String str) {
        this.zzc = zzge;
        this.zza = zzao;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
