package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbm;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzdll implements Continuation {
    private final int zzdwt;
    private final zzbm.zza.C2651zza zzhbd;

    zzdll(zzbm.zza.C2651zza zza, int i) {
        this.zzhbd = zza;
        this.zzdwt = i;
    }

    public final Object then(Task task) {
        return zzdlk.zza(this.zzhbd, this.zzdwt, task);
    }
}
