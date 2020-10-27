package com.google.android.gms.internal.ads;

import java.util.Set;

final class zzbij implements zzbne {
    private zzehm<zzdgo> zzewe;
    private zzehm<Set<zzbvt<zzbrs>>> zzewh;
    private zzehm<zzbrr> zzewi;
    private zzehm<zzdha> zzewj;
    private zzehm<Set<zzbvt<zzbsm>>> zzexh;
    private zzehm<zzbsh> zzexi;
    private zzehm<String> zzeya;
    private zzehm<zzbqs> zzeyb;
    private zzehm<zzbnv> zzeyc;
    private final zzbnh zzfch;
    private zzehm<zzaem> zzfci;
    private zzehm<Runnable> zzfcj;
    private zzehm<zzbnd> zzfck;
    private final /* synthetic */ zzbih zzfcl;

    private zzbij(zzbih zzbih, zzboi zzboi, zzbnh zzbnh) {
        this.zzfcl = zzbih;
        this.zzfch = zzbnh;
        this.zzewj = zzbon.zze(zzboi);
        this.zzewe = zzbol.zzc(zzboi);
        zzehi zzbit = zzehi.zzar(0, 2).zzau(this.zzfcl.zzeut).zzau(this.zzfcl.zzeuu).zzbit();
        this.zzewh = zzbit;
        this.zzewi = zzeha.zzar(zzbry.zzj(zzbit));
        zzehi zzbit2 = zzehi.zzar(4, 3).zzat(this.zzfcl.zzevi).zzat(this.zzfcl.zzevj).zzat(this.zzfcl.zzevk).zzau(this.zzfcl.zzevl).zzau(this.zzfcl.zzevm).zzau(this.zzfcl.zzevn).zzat(this.zzfcl.zzevo).zzbit();
        this.zzexh = zzbit2;
        this.zzexi = zzeha.zzar(zzbsj.zzl(zzbit2));
        zzbok zza = zzbok.zza(zzboi);
        this.zzeya = zza;
        this.zzeyb = zzbqr.zzm(this.zzewe, zza);
        this.zzeyc = zzbpl.zzb(this.zzewj, this.zzewe, this.zzewi, this.zzexi, this.zzfcl.zzevw, this.zzeyb);
        this.zzfci = new zzbnj(zzbnh);
        zzbng zzbng = new zzbng(zzbnh);
        this.zzfcj = zzbng;
        this.zzfck = zzeha.zzar(new zzbni(this.zzeyc, this.zzfci, zzbng, this.zzfcl.zzewb.zzent));
    }

    public final zzblx zzafh() {
        return (zzblx) zzehf.zza(this.zzfck.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
