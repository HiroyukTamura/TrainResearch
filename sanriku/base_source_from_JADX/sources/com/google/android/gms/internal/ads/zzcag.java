package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

public final class zzcag {
    zzadx zzfsp;
    zzads zzfsq;
    zzael zzfsr;
    zzaeg zzfss;
    zzahu zzfst;
    final SimpleArrayMap<String, zzaed> zzfsu = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzady> zzfsv = new SimpleArrayMap<>();

    public final zzcag zza(zzaeg zzaeg) {
        this.zzfss = zzaeg;
        return this;
    }

    public final zzcae zzals() {
        return new zzcae(this);
    }

    public final zzcag zzb(zzads zzads) {
        this.zzfsq = zzads;
        return this;
    }

    public final zzcag zzb(zzadx zzadx) {
        this.zzfsp = zzadx;
        return this;
    }

    public final zzcag zzb(zzael zzael) {
        this.zzfsr = zzael;
        return this;
    }

    public final zzcag zzb(zzahu zzahu) {
        this.zzfst = zzahu;
        return this;
    }

    public final zzcag zzb(String str, zzaed zzaed, zzady zzady) {
        this.zzfsu.put(str, zzaed);
        this.zzfsv.put(str, zzady);
        return this;
    }
}
