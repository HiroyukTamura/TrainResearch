package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;

public final class zzbsx implements zzegz<zzbsu> {
    private final zzehm<Set<zzbvt<zzo>>> zzfjp;

    private zzbsx(zzehm<Set<zzbvt<zzo>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbsx zzo(zzehm<Set<zzbvt<zzo>>> zzehm) {
        return new zzbsx(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbsu(this.zzfjp.get());
    }
}
