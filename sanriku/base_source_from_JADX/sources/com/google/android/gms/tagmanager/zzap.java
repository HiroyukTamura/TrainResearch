package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;

final class zzap implements zzaq {
    private final /* synthetic */ DataLayer zzafv;

    zzap(DataLayer dataLayer) {
        this.zzafv = dataLayer;
    }

    public final void zzc(List<DataLayer.zza> list) {
        for (DataLayer.zza next : list) {
            this.zzafv.zze(DataLayer.zzg(next.mKey, next.mValue));
        }
        this.zzafv.zzafu.countDown();
    }
}
