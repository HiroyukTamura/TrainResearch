package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

final /* synthetic */ class zzczo implements zzdqh {
    private final String zzdbv;
    private final zzczm zzgnr;
    private final List zzgnt;
    private final Bundle zzgnu;

    zzczo(zzczm zzczm, String str, List list, Bundle bundle) {
        this.zzgnr = zzczm;
        this.zzdbv = str;
        this.zzgnt = list;
        this.zzgnu = bundle;
    }

    public final zzdri zzaql() {
        return this.zzgnr.zza(this.zzdbv, this.zzgnt, this.zzgnu);
    }
}
