package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzdu;
import java.util.concurrent.Callable;

final class zzm implements Callable<zzdt> {
    private final /* synthetic */ zzl zzbmn;

    zzm(zzl zzl) {
        this.zzbmn = zzl;
    }

    public final /* synthetic */ Object call() throws Exception {
        return new zzdt(zzdu.zzb(this.zzbmn.zzbmo.zzbnd, this.zzbmn.zzvf, false));
    }
}
