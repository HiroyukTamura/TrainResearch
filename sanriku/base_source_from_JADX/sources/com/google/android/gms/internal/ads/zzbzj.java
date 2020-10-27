package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

public final class zzbzj implements zzegz<zzpu> {
    private final zzehm<zzazz> zzfib;
    private final zzehm<String> zzfic;

    public zzbzj(zzehm<zzazz> zzehm, zzehm<String> zzehm2) {
        this.zzfib = zzehm;
        this.zzfic = zzehm2;
    }

    public final /* synthetic */ Object get() {
        zzq.zzkw();
        return (zzpu) zzehf.zza(new zzpu(zzaxa.zzxg(), this.zzfib.get(), this.zzfic.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
