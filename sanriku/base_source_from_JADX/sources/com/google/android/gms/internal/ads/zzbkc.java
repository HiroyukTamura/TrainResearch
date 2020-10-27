package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzbkc implements zzbrs {
    private final zzdhq zzfgi;

    public zzbkc(zzdhq zzdhq) {
        this.zzfgi = zzdhq;
    }

    public final void zzbx(@Nullable Context context) {
        try {
            this.zzfgi.pause();
        } catch (zzdhk e) {
            zzazw.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzby(@Nullable Context context) {
        try {
            this.zzfgi.resume();
            if (context != null) {
                this.zzfgi.onContextChanged(context);
            }
        } catch (zzdhk e) {
            zzazw.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzbz(@Nullable Context context) {
        try {
            this.zzfgi.destroy();
        } catch (zzdhk e) {
            zzazw.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
