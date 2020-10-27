package com.google.android.gms.internal.ads;

import android.view.Surface;

public final class zzpl {
    private final zzdns zzaes;
    /* access modifiers changed from: private */
    public final zzpm zzbkh;

    public zzpl(zzdns zzdns, zzpm zzpm) {
        this.zzaes = zzpm != null ? (zzdns) zzoh.checkNotNull(zzdns) : null;
        this.zzbkh = zzpm;
    }

    public final void zza(int i, int i2, int i3, float f) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzps(this, i, i2, i3, f));
        }
    }

    public final void zza(Surface surface) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpr(this, surface));
        }
    }

    public final void zza(zziy zziy) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpo(this, zziy));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpn(this, str, j, j2));
        }
    }

    public final void zzb(zzhf zzhf) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpq(this, zzhf));
        }
    }

    public final void zzb(zziy zziy) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpt(this, zziy));
        }
    }

    public final void zze(int i, long j) {
        if (this.zzbkh != null) {
            this.zzaes.post(new zzpp(this, i, j));
        }
    }
}
