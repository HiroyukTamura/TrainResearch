package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

final class zzagj implements zzagi {
    private final /* synthetic */ zzbaj zzdax;

    zzagj(zzagg zzagg, zzbaj zzbaj) {
        this.zzdax = zzbaj;
    }

    public final void onFailure(@Nullable String str) {
        this.zzdax.setException(new zzake(str));
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzdax.set(jSONObject);
    }
}
