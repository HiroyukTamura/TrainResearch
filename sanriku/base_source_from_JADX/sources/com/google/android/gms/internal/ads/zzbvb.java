package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbvb implements zzegz<Set<zzbvt<AppEventListener>>> {
    private final zzbuj zzfoh;

    private zzbvb(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbvb zzw(zzbuj zzbuj) {
        return new zzbvb(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
