package com.google.android.gms.internal.ads;

public final class zzbli {
    private final zzdha zzepv;
    private final zzchz zzfiq;

    public zzbli(zzchz zzchz, zzdha zzdha) {
        this.zzfiq = zzchz;
        this.zzepv = zzdha;
    }

    public final void zzfd(long j) {
        this.zzfiq.zzaoa().zza(this.zzepv.zzgus.zzgup).zzq("action", "ad_closed").zzq("show_time", String.valueOf(j)).zzq("ad_format", "appopen").zzany();
    }
}
