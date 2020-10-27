package com.google.android.gms.measurement.internal;

import java.util.Map;

final /* synthetic */ class zzij implements Runnable {
    private final zzig zza;
    private final int zzb;
    private final Exception zzc;
    private final byte[] zzd;
    private final Map zze;

    zzij(zzig zzig, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzig;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
