package com.google.android.gms.internal.ads;

public final class zzhw {
    private final zzdns zzaes;
    /* access modifiers changed from: private */
    public final zzhx zzaih;

    public zzhw(zzdns zzdns, zzhx zzhx) {
        this.zzaes = zzhx != null ? (zzdns) zzoh.checkNotNull(zzdns) : null;
        this.zzaih = zzhx;
    }

    public final void zza(int i, long j, long j2) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzia(this, i, j, j2));
        }
    }

    public final void zza(zziy zziy) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzhz(this, zziy));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzhy(this, str, j, j2));
        }
    }

    public final void zzb(zzhf zzhf) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzib(this, zzhf));
        }
    }

    public final void zzb(zziy zziy) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzid(this, zziy));
        }
    }

    public final void zzt(int i) {
        if (this.zzaih != null) {
            this.zzaes.post(new zzic(this, i));
        }
    }
}
