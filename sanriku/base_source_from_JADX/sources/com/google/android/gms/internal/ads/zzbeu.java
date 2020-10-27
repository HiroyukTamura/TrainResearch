package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzbeu implements zzdon {
    private final Context zzcit;
    private final String zzdep;
    private final zzbfz zzeit;
    private final boolean zzeiu;
    private final boolean zzeiv;
    private final zzdt zzeiw;
    private final zzazz zzeix;
    private final zzaam zzeiy = null;
    private final zzi zzeiz;
    private final zza zzeja;
    private final zzst zzejb;
    private final zzrv zzejc;
    private final boolean zzejd;

    zzbeu(Context context, zzbfz zzbfz, String str, boolean z, boolean z2, zzdt zzdt, zzazz zzazz, zzaam zzaam, zzi zzi, zza zza, zzst zzst, zzrv zzrv, boolean z3) {
        this.zzcit = context;
        this.zzeit = zzbfz;
        this.zzdep = str;
        this.zzeiu = z;
        this.zzeiv = z2;
        this.zzeiw = zzdt;
        this.zzeix = zzazz;
        this.zzeiz = zzi;
        this.zzeja = zza;
        this.zzejb = zzst;
        this.zzejc = zzrv;
        this.zzejd = z3;
    }

    public final Object get() {
        Context context = this.zzcit;
        zzbfz zzbfz = this.zzeit;
        String str = this.zzdep;
        boolean z = this.zzeiu;
        boolean z2 = this.zzeiv;
        zzdt zzdt = this.zzeiw;
        zzazz zzazz = this.zzeix;
        zzaam zzaam = this.zzeiy;
        zzi zzi = this.zzeiz;
        zza zza = this.zzeja;
        zzst zzst = this.zzejb;
        zzbev zzbev = new zzbev(zzbfa.zzb(context, zzbfz, str, z, z2, zzdt, zzazz, zzaam, zzi, zza, zzst, this.zzejc, this.zzejd));
        zzbev.setWebViewClient(zzq.zzky().zza(zzbev, zzst, z2));
        zzbev.setWebChromeClient(new zzbec(zzbev));
        return zzbev;
    }
}
