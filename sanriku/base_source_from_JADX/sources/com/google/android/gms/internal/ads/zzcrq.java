package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzcrq implements zzcnk<zzanv, zzcot> {
    private final zzcsx zzghn;

    public zzcrq(zzcsx zzcsx) {
        this.zzghn = zzcsx;
    }

    public final zzcnl<zzanv, zzcot> zzf(String str, JSONObject jSONObject) throws zzdhk {
        zzanv zzgn = this.zzghn.zzgn(str);
        if (zzgn == null) {
            return null;
        }
        return new zzcnl<>(zzgn, new zzcot(), str);
    }
}
