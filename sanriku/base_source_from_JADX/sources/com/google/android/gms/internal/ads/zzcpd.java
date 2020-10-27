package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzcpd implements zzbxz {
    @Nullable
    private zzbro zzfpi = null;
    private final zzdgo zzfpj;
    private final zzanv zzgfv;
    private final boolean zzgfw;

    zzcpd(zzdgo zzdgo, zzanv zzanv, boolean z) {
        this.zzfpj = zzdgo;
        this.zzgfv = zzanv;
        this.zzgfw = z;
    }

    public final void zza(zzbro zzbro) {
        this.zzfpi = zzbro;
    }

    public final void zza(boolean z, Context context) throws zzbxy {
        try {
            if (this.zzgfw ? this.zzgfv.zzaa(ObjectWrapper.wrap(context)) : this.zzgfv.zzz(ObjectWrapper.wrap(context))) {
                zzbro zzbro = this.zzfpi;
                if (zzbro != null && this.zzfpj.zzgub == 2) {
                    zzbro.onAdImpression();
                    return;
                }
                return;
            }
            throw new zzbxy("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzbxy(th);
        }
    }
}
