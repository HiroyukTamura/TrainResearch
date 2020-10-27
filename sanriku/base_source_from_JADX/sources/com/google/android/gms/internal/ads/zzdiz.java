package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

public final class zzdiz {
    private HashMap<zzdiu, zzdjc<? extends zzbns>> zzgxx = new HashMap<>();

    public final <AdT extends zzbns> zzdjc<AdT> zza(zzdiu zzdiu, Context context, zzdih zzdih, zzdjk<AdT> zzdjk) {
        zzdjc<AdT> zzdjc = this.zzgxx.get(zzdiu);
        if (zzdjc != null) {
            return zzdjc;
        }
        zzdin zzdin = new zzdin(zzdir.zza(zzdiu, context));
        zzdjc<AdT> zzdjc2 = new zzdjc<>(zzdin, new zzdjd(zzdin, zzdih, zzdjk));
        this.zzgxx.put(zzdiu, zzdjc2);
        return zzdjc2;
    }
}
