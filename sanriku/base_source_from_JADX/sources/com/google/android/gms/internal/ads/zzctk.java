package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

public final class zzctk implements zzbtb {
    private final AtomicReference<zzxf> zzgjn = new AtomicReference<>();

    public final void zzb(zzuo zzuo) {
        zzdek.zza(this.zzgjn, new zzctn(zzuo));
    }

    public final void zzb(zzxf zzxf) {
        this.zzgjn.set(zzxf);
    }
}
