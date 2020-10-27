package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzcfr implements zzbrs {
    @Nullable
    private final zzbek zzdce;

    zzcfr(@Nullable zzbek zzbek) {
        this.zzdce = !((Boolean) zzvj.zzpv().zzd(zzzz.zzcli)).booleanValue() ? null : zzbek;
    }

    public final void zzbx(@Nullable Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.onPause();
        }
    }

    public final void zzby(@Nullable Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.onResume();
        }
    }

    public final void zzbz(@Nullable Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.destroy();
        }
    }
}
