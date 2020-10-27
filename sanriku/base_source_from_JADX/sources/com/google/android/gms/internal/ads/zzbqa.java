package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;

final class zzbqa implements zzbrs, zzbsm {
    private final zzapn zzblt;
    private final zzdgo zzfkd;
    private final Context zzvf;

    public zzbqa(Context context, zzdgo zzdgo, zzapn zzapn) {
        this.zzvf = context;
        this.zzfkd = zzdgo;
        this.zzblt = zzapn;
    }

    public final void onAdLoaded() {
        zzapl zzapl = this.zzfkd.zzgud;
        if (zzapl != null && zzapl.zzdlf) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzfkd.zzgud.zzdlg.isEmpty()) {
                arrayList.add(this.zzfkd.zzgud.zzdlg);
            }
            this.zzblt.zza(this.zzvf, arrayList);
        }
    }

    public final void zzbx(@Nullable Context context) {
    }

    public final void zzby(@Nullable Context context) {
    }

    public final void zzbz(@Nullable Context context) {
        this.zzblt.detach();
    }
}
