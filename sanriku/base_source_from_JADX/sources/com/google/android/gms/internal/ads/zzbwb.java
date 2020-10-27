package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzbwb implements zzbvy {
    private final List<String> zzdnv;
    private final zzdld zzfgl;
    private boolean zzfoo;

    public zzbwb(zzdgo zzdgo, zzdld zzdld) {
        this.zzdnv = zzdgo.zzdnv;
        this.zzfgl = zzdld;
    }

    public final void zzajr() {
        if (!this.zzfoo) {
            this.zzfgl.zzh(this.zzdnv);
            this.zzfoo = true;
        }
    }
}
