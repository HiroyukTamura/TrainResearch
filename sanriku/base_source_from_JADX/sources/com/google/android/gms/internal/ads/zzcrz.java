package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzcrz implements zzbsi {
    private boolean zzghu = false;
    private final /* synthetic */ zzbaj zzghv;

    zzcrz(zzcru zzcru, zzbaj zzbaj) {
        this.zzghv = zzbaj;
    }

    private final void zzh(int i, @Nullable String str) {
        this.zzghv.setException(new zzcnn(((Boolean) zzvj.zzpv().zzd(zzzz.zzcrn)).booleanValue() ? 3 : i, i, str));
    }

    public final void onAdFailedToLoad(int i) {
        if (!this.zzghu) {
            zzh(i, (String) null);
        }
    }

    public final synchronized void onAdLoaded() {
        this.zzghv.set(null);
    }

    public final synchronized void zzg(int i, @Nullable String str) {
        this.zzghu = true;
        zzh(i, str);
    }
}
