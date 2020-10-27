package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

public final class zzbld implements zzegz<JSONObject> {
    private final zzehm<zzdgo> zzfia;

    private zzbld(zzehm<zzdgo> zzehm) {
        this.zzfia = zzehm;
    }

    public static zzbld zzc(zzehm<zzdgo> zzehm) {
        return new zzbld(zzehm);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzbla.zza(this.zzfia.get());
    }
}
