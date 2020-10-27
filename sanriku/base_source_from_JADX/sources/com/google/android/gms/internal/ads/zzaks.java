package com.google.android.gms.internal.ads;

final class zzaks implements zzbal {
    private final /* synthetic */ zzbaj zzdax;
    private final /* synthetic */ zzajs zzded;

    zzaks(zzakq zzakq, zzbaj zzbaj, zzajs zzajs) {
        this.zzdax = zzbaj;
        this.zzded = zzajs;
    }

    public final void run() {
        this.zzdax.setException(new zzake("Unable to obtain a JavascriptEngine."));
        this.zzded.release();
    }
}
