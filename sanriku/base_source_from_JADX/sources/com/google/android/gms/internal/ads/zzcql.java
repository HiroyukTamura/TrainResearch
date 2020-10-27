package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzcql implements zzdqx<T> {
    private final /* synthetic */ String zzggo;
    private final /* synthetic */ long zzggp;
    private final /* synthetic */ zzdgo zzggq;
    private final /* synthetic */ zzdgq zzggr;
    private final /* synthetic */ zzcqi zzggs;

    zzcql(zzcqi zzcqi, String str, long j, zzdgo zzdgo, zzdgq zzdgq) {
        this.zzggs = zzcqi;
        this.zzggo = str;
        this.zzggp = j;
        this.zzggq = zzdgo;
        this.zzggr = zzdgq;
    }

    public final void onSuccess(T t) {
        long elapsedRealtime = this.zzggs.zzbnt.elapsedRealtime();
        this.zzggs.zza(this.zzggo, 0, elapsedRealtime - this.zzggp, this.zzggq.zzguf);
        if (this.zzggs.zzggn) {
            this.zzggs.zzggl.zza(this.zzggr, this.zzggq, 0, (zzcnn) null, elapsedRealtime - this.zzggp);
        }
    }

    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzggs.zzbnt.elapsedRealtime();
        int i = 6;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcpy) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdhk) {
            i = 5;
        } else if ((th instanceof zzcjk) && ((zzcjk) th).getErrorCode() == 3) {
            i = 1;
        }
        this.zzggs.zza(this.zzggo, i, elapsedRealtime - this.zzggp, this.zzggq.zzguf);
        if (this.zzggs.zzggn) {
            this.zzggs.zzggl.zza(this.zzggr, this.zzggq, i, th instanceof zzcnn ? (zzcnn) th : null, elapsedRealtime - this.zzggp);
        }
    }
}
