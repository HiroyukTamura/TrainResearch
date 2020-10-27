package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbuw implements zzegz<Set<zzbvt<AdMetadataListener>>> {
    private final zzbuj zzfoh;

    private zzbuw(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuw zzq(zzbuj zzbuj) {
        return new zzbuw(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajf(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
