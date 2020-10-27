package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class zzic implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzid zze;

    zzic(zzid zzid, boolean z, Uri uri, String str, String str2) {
        this.zze = zzid;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
