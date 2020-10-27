package com.google.android.gms.internal.ads;

import android.location.Location;

final /* synthetic */ class zzcxo implements zzdnx {
    private final zzcxm zzgmz;

    zzcxo(zzcxm zzcxm) {
        this.zzgmz = zzcxm;
    }

    public final Object apply(Object obj) {
        Location location = (Location) obj;
        return location != null ? location : this.zzgmz.zzfll.zzguw.zzmp;
    }
}
