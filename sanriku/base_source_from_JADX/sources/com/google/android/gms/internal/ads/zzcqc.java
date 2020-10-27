package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqj;

public final class zzcqc extends zzcqd<zzblx> {
    private final zzbyl zzepw;
    private final zzbuj zzewc;
    private final zzcsm zzfcf;
    private final ViewGroup zzfiv;
    private final zzbte zzfkn;
    private final zzbgy zzggh;
    private final zzbqj.zza zzggi;

    public zzcqc(zzbgy zzbgy, zzbqj.zza zza, zzcsm zzcsm, zzbuj zzbuj, zzbyl zzbyl, zzbte zzbte, @Nullable ViewGroup viewGroup) {
        this.zzggh = zzbgy;
        this.zzggi = zza;
        this.zzfcf = zzcsm;
        this.zzewc = zzbuj;
        this.zzepw = zzbyl;
        this.zzfkn = zzbte;
        this.zzfiv = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzdri<zzblx> zza(zzdhe zzdhe, Bundle bundle) {
        return this.zzggh.zzadc().zzc(this.zzggi.zza(zzdhe).zzf(bundle).zzair()).zzc(this.zzewc).zza(this.zzfcf).zzb(this.zzepw).zza(new zzbnp(this.zzfkn)).zzb(new zzbls(this.zzfiv)).zzafg().zzaed().zzaii();
    }
}
