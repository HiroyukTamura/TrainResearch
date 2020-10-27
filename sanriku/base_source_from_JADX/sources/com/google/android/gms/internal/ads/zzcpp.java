package com.google.android.gms.internal.ads;

import org.json.JSONArray;

final /* synthetic */ class zzcpp implements zzdqj {
    private final zzdgo zzfjm;
    private final zzdha zzfvc;
    private final zzcpn zzgfx;

    zzcpp(zzcpn zzcpn, zzdha zzdha, zzdgo zzdgo) {
        this.zzgfx = zzcpn;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
    }

    public final zzdri zzf(Object obj) {
        return this.zzgfx.zza(this.zzfvc, this.zzfjm, (JSONArray) obj);
    }
}
