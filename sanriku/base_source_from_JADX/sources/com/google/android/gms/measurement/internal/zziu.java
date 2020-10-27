package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zziu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkr zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzis zzd;

    zziu(zzis zzis, boolean z, zzkr zzkr, zzn zzn) {
        this.zzd = zzis;
        this.zza = z;
        this.zzb = zzkr;
        this.zzc = zzn;
    }

    public final void run() {
        zzer zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzd2, (AbstractSafeParcelable) this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzak();
    }
}
