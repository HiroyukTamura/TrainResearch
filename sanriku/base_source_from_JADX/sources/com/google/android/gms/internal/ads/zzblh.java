package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzblh implements zzegz<View> {
    private final zzble zzfio;

    public zzblh(zzble zzble) {
        this.zzfio = zzble;
    }

    public static View zza(zzble zzble) {
        return (View) zzehf.zza(zzble.zzagt(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfio);
    }
}
