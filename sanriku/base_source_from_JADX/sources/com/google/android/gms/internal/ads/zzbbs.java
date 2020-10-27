package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public final class zzbbs {
    private final long zzech = TimeUnit.MILLISECONDS.toNanos(((Long) zzvj.zzpv().zzd(zzzz.zzcjq)).longValue());
    private long zzeci;
    private boolean zzecj = true;

    zzbbs() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbbf zzbbf) {
        if (zzbbf != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzecj || Math.abs(timestamp - this.zzeci) >= this.zzech) {
                this.zzecj = false;
                this.zzeci = timestamp;
                zzaxa.zzdwf.post(new zzbbr(this, zzbbf));
            }
        }
    }

    public final void zzyq() {
        this.zzecj = true;
    }
}
