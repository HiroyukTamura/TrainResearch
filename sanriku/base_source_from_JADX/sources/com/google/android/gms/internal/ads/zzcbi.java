package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

public final class zzcbi implements zzbrp {
    private final zzbzx zzfqb;
    private final zzcab zzfrc;

    public zzcbi(zzbzx zzbzx, zzcab zzcab) {
        this.zzfqb = zzbzx;
        this.zzfrc = zzcab;
    }

    public final void onAdImpression() {
        if (this.zzfqb.zzald() != null) {
            zzbek zzalc = this.zzfqb.zzalc();
            zzbek zzalb = this.zzfqb.zzalb();
            if (zzalc == null) {
                zzalc = zzalb != null ? zzalb : null;
            }
            if (this.zzfrc.zzaks() && zzalc != null) {
                zzalc.zza("onSdkImpression", new ArrayMap());
            }
        }
    }
}
