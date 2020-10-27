package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzber implements zzdqj {
    private final Context zzcit;
    private final zzdt zzdcn;
    private final zzazz zzeip;
    private final zza zzeiq;
    private final String zzeir;

    zzber(Context context, zzdt zzdt, zzazz zzazz, zza zza, String str) {
        this.zzcit = context;
        this.zzdcn = zzdt;
        this.zzeip = zzazz;
        this.zzeiq = zza;
        this.zzeir = str;
    }

    public final zzdri zzf(Object obj) {
        Context context = this.zzcit;
        zzdt zzdt = this.zzdcn;
        zzazz zzazz = this.zzeip;
        zza zza = this.zzeiq;
        String str = this.zzeir;
        zzq.zzkx();
        zzbek zza2 = zzbes.zza(context, zzbfz.zzacl(), "", false, false, zzdt, zzazz, (zzaam) null, (zzi) null, zza, zzst.zzmz(), (zzrv) null, false);
        zzbak zzl = zzbak.zzl(zza2);
        zza2.zzabj().zza((zzbfv) new zzbet(zzl));
        zza2.loadUrl(str);
        return zzl;
    }
}
