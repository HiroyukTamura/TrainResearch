package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzot implements zzol {
    private boolean started;
    private zzhl zzaek = zzhl.zzahe;
    private long zzbht;
    private long zzbhu;

    public final void start() {
        if (!this.started) {
            this.zzbhu = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgb());
            this.started = false;
        }
    }

    public final void zza(zzol zzol) {
        zzel(zzol.zzgb());
        this.zzaek = zzol.zzfr();
    }

    public final zzhl zzb(zzhl zzhl) {
        if (this.started) {
            zzel(zzgb());
        }
        this.zzaek = zzhl;
        return zzhl;
    }

    public final void zzel(long j) {
        this.zzbht = j;
        if (this.started) {
            this.zzbhu = SystemClock.elapsedRealtime();
        }
    }

    public final zzhl zzfr() {
        return this.zzaek;
    }

    public final long zzgb() {
        long j = this.zzbht;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbhu;
        zzhl zzhl = this.zzaek;
        return j + (zzhl.zzahf == 1.0f ? zzgr.zzdp(elapsedRealtime) : zzhl.zzdu(elapsedRealtime));
    }
}
