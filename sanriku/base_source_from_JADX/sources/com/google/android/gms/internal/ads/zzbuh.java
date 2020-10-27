package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzbuh implements Runnable {
    private final Object zzdel;
    private final zzbuk zzfns;

    zzbuh(zzbuk zzbuk, Object obj) {
        this.zzfns = zzbuk;
        this.zzdel = obj;
    }

    public final void run() {
        try {
            this.zzfns.zzp(this.zzdel);
        } catch (Throwable th) {
            zzq.zzla().zzb(th, "EventEmitter.notify");
            zzawr.zza("Event emitter exception.", th);
        }
    }
}
