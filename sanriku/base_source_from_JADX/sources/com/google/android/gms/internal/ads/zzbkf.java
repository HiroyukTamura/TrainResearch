package com.google.android.gms.internal.ads;

public final class zzbkf implements zzbrc {
    private final zzdha zzfgj;
    private final zzdld zzfgl;
    private final zzdgq zzfgp;

    public zzbkf(zzdha zzdha, zzdld zzdld) {
        this.zzfgj = zzdha;
        this.zzfgl = zzdld;
        this.zzfgp = zzdha.zzgus.zzgup;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzfgl.zza(this.zzfgj, (zzdgo) null, this.zzfgp.zzdex);
    }
}
