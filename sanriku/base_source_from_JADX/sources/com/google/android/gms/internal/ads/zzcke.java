package com.google.android.gms.internal.ads;

public abstract class zzcke implements zzdqj<zzarj, zzdha> {
    /* access modifiers changed from: private */
    public final zzbth zzgbd;

    public zzcke(zzbth zzbth) {
        this.zzgbd = zzbth;
    }

    /* access modifiers changed from: protected */
    public abstract zzdri<zzdha> zzb(zzarj zzarj) throws zzcjk;

    public final /* synthetic */ zzdri zzf(Object obj) throws Exception {
        zzarj zzarj = (zzarj) obj;
        this.zzgbd.zzd(zzarj);
        zzdri<zzdha> zzb = zzb(zzarj);
        zzdqw.zza(zzb, new zzckh(this), zzbab.zzdzw);
        return zzb;
    }
}
