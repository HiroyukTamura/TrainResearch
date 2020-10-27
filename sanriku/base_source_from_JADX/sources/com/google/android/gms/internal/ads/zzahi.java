package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

public final class zzahi implements AdapterStatus {
    private final String description;
    private final int zzdbi;
    private final AdapterStatus.State zzdbj;

    public zzahi(AdapterStatus.State state, String str, int i) {
        this.zzdbj = state;
        this.description = str;
        this.zzdbi = i;
    }

    public final String getDescription() {
        return this.description;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zzdbj;
    }

    public final int getLatency() {
        return this.zzdbi;
    }
}
