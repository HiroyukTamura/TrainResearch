package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbxp implements zzo {
    private final zzbsu zzfpb;
    private final zzbvp zzfpc;

    public zzbxp(zzbsu zzbsu, zzbvp zzbvp) {
        this.zzfpb = zzbsu;
        this.zzfpc = zzbvp;
    }

    public final void onPause() {
        this.zzfpb.onPause();
    }

    public final void onResume() {
        this.zzfpb.onResume();
    }

    public final void zztz() {
        this.zzfpb.zztz();
        this.zzfpc.onHide();
    }

    public final void zzua() {
        this.zzfpb.zzua();
        this.zzfpc.zzajp();
    }
}
