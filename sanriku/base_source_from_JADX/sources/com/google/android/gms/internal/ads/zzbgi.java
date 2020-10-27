package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;

final /* synthetic */ class zzbgi implements zzdon {
    private final Context zzcit;
    private final String zzdep;
    private final zzbfz zzeit;
    private final boolean zzeiu;
    private final boolean zzeiv;
    private final zzdt zzeiw;
    private final zzazz zzeix;
    private final zzaam zzeiy;
    private final zzi zzeiz;
    private final zza zzeja;
    private final zzst zzejb;
    private final zzrv zzejc;
    private final boolean zzejd;

    zzbgi(Context context, zzbfz zzbfz, String str, boolean z, boolean z2, zzdt zzdt, zzazz zzazz, zzaam zzaam, zzi zzi, zza zza, zzst zzst, zzrv zzrv, boolean z3) {
        this.zzcit = context;
        this.zzeit = zzbfz;
        this.zzdep = str;
        this.zzeiu = z;
        this.zzeiv = z2;
        this.zzeiw = zzdt;
        this.zzeix = zzazz;
        this.zzeiy = zzaam;
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
        zzrv zzrv = this.zzejc;
        boolean z3 = this.zzejd;
        zzbgc zzbgc = new zzbgc();
        zzrv zzrv2 = zzrv;
        zzbgh zzbgh = new zzbgh(new zzbga(context), zzbgc, zzbfz, str, z, z2, zzdt, zzazz, zzaam, zzi, zza, zzst, zzrv2, z3);
        zzbev zzbev = new zzbev(zzbgh);
        zzbgh.setWebChromeClient(new zzbec(zzbev));
        zzbgc.zza((zzbek) zzbev, z2);
        return zzbev;
    }
}
