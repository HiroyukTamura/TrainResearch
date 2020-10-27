package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbip implements zzdgg {
    private final /* synthetic */ zzbhw zzewb;
    private zzehm<Context> zzfbf;
    private zzehm<String> zzfbg;
    private zzehm<zzdeu<zzceo, zzcel>> zzfei;
    private zzehm<zzdez> zzfej;
    private zzehm<zzdgz> zzfek;
    private zzehm<zzdfw> zzfel;
    private zzehm<zzdgi> zzfem;
    private zzehm<zzdgc> zzfen;

    private zzbip(zzbhw zzbhw, Context context, String str) {
        this.zzewb = zzbhw;
        zzegz zzbb = zzehc.zzbb(context);
        this.zzfbf = zzbb;
        this.zzfei = new zzdex(zzbb, this.zzewb.zzepo, this.zzewb.zzepp);
        this.zzfej = zzeha.zzar(new zzdfu(this.zzewb.zzepo));
        this.zzfek = zzeha.zzar(zzdhc.zzarw());
        zzehm<zzdfw> zzar = zzeha.zzar(new zzdfz(this.zzfbf, this.zzewb.zzent, this.zzewb.zzenk, this.zzfei, this.zzfej, zzdhf.zzary(), this.zzfek));
        this.zzfel = zzar;
        this.zzfem = zzeha.zzar(new zzdgj(zzar, this.zzfej, this.zzfek));
        zzegz zzbc = zzehc.zzbc(str);
        this.zzfbg = zzbc;
        this.zzfen = zzeha.zzar(new zzdgd(zzbc, this.zzfel, this.zzfbf, this.zzfej, this.zzfek));
    }

    public final zzdgi zzafr() {
        return this.zzfem.get();
    }

    public final zzdgc zzafs() {
        return this.zzfen.get();
    }
}
