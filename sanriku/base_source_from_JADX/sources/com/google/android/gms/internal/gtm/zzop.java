package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzop extends zzuq<zzop> {
    public long zzaux = 0;
    public zzk zzauy = null;
    public zzi zzqk = null;

    public zzop() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzop)) {
            return false;
        }
        zzop zzop = (zzop) obj;
        if (this.zzaux != zzop.zzaux) {
            return false;
        }
        zzi zzi = this.zzqk;
        if (zzi == null) {
            if (zzop.zzqk != null) {
                return false;
            }
        } else if (!zzi.equals(zzop.zzqk)) {
            return false;
        }
        zzk zzk = this.zzauy;
        if (zzk == null) {
            if (zzop.zzauy != null) {
                return false;
            }
        } else if (!zzk.equals(zzop.zzauy)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzop.zzbhb);
        }
        zzus zzus2 = zzop.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        long j = this.zzaux;
        zzi zzi = this.zzqk;
        int i = 0;
        int hashCode = ((1772348377 + ((int) (j ^ (j >>> 32)))) * 31) + (zzi == null ? 0 : zzi.hashCode());
        zzk zzk = this.zzauy;
        int hashCode2 = ((hashCode * 31) + (zzk == null ? 0 : zzk.hashCode())) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return hashCode2 + i;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        zzuw zzuw;
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni != 8) {
                if (zzni == 18) {
                    if (this.zzqk == null) {
                        this.zzqk = new zzi();
                    }
                    zzuw = this.zzqk;
                } else if (zzni == 26) {
                    if (this.zzauy == null) {
                        this.zzauy = new zzk();
                    }
                    zzuw = this.zzauy;
                } else if (!super.zza(zzun, zzni)) {
                    return this;
                }
                zzun.zza(zzuw);
            } else {
                this.zzaux = zzun.zzob();
            }
        }
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzuo.zzi(1, this.zzaux);
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzuo.zza(2, (zzuw) zzi);
        }
        zzk zzk = this.zzauy;
        if (zzk != null) {
            zzuo.zza(3, (zzuw) zzk);
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int zzd = zzuo.zzd(1, this.zzaux) + super.zzy();
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzd += zzuo.zzb(2, (zzuw) zzi);
        }
        zzk zzk = this.zzauy;
        return zzk != null ? zzd + zzuo.zzb(3, (zzuw) zzk) : zzd;
    }
}
