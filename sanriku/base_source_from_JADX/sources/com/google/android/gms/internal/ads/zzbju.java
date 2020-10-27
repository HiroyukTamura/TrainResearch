package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbju implements zzdqj<zzdha, zzdha> {
    private Map<String, zzbjx> zzfgg;

    public zzbju(Map<String, zzbjx> map) {
        this.zzfgg = map;
    }

    public final /* synthetic */ zzdri zzf(Object obj) throws Exception {
        zzdha zzdha = (zzdha) obj;
        for (zzdgx next : zzdha.zzgus.zzguq) {
            if (this.zzfgg.containsKey(next.name)) {
                this.zzfgg.get(next.name).zzl(next.zzgun);
            }
        }
        return zzdqw.zzag(zzdha);
    }
}
