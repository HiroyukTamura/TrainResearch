package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzcpl implements zzcnk<zzdhq, zzcot> {
    private final zzcfz zzgac;

    public zzcpl(zzcfz zzcfz) {
        this.zzgac = zzcfz;
    }

    public final zzcnl<zzdhq, zzcot> zzf(String str, JSONObject jSONObject) throws zzdhk {
        zzdhq zzd = this.zzgac.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcnl<>(zzd, new zzcot(), str);
    }
}
