package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzj extends zzuq<zzj> {
    private static volatile zzj[] zzqg;
    public String name = "";
    private zzl zzqh = null;
    public zzh zzqi = null;

    public zzj() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public static zzj[] zzz() {
        if (zzqg == null) {
            synchronized (zzuu.zzbhk) {
                if (zzqg == null) {
                    zzqg = new zzj[0];
                }
            }
        }
        return zzqg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        String str = this.name;
        if (str == null) {
            if (zzj.name != null) {
                return false;
            }
        } else if (!str.equals(zzj.name)) {
            return false;
        }
        zzl zzl = this.zzqh;
        if (zzl == null) {
            if (zzj.zzqh != null) {
                return false;
            }
        } else if (!zzl.equals(zzj.zzqh)) {
            return false;
        }
        zzh zzh = this.zzqi;
        if (zzh == null) {
            if (zzj.zzqi != null) {
                return false;
            }
        } else if (!zzh.equals(zzj.zzqi)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzj.zzbhb);
        }
        zzus zzus2 = zzj.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = -1328285250 + (str == null ? 0 : str.hashCode());
        zzl zzl = this.zzqh;
        int hashCode2 = (hashCode * 31) + (zzl == null ? 0 : zzl.hashCode());
        zzh zzh = this.zzqi;
        int hashCode3 = ((hashCode2 * 31) + (zzh == null ? 0 : zzh.hashCode())) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return hashCode3 + i;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        zzuw zzuw;
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni != 10) {
                if (zzni == 18) {
                    if (this.zzqh == null) {
                        this.zzqh = new zzl();
                    }
                    zzuw = this.zzqh;
                } else if (zzni == 26) {
                    if (this.zzqi == null) {
                        this.zzqi = new zzh();
                    }
                    zzuw = this.zzqi;
                } else if (!super.zza(zzun, zzni)) {
                    return this;
                }
                zzun.zza(zzuw);
            } else {
                this.name = zzun.readString();
            }
        }
    }

    public final void zza(zzuo zzuo) throws IOException {
        String str = this.name;
        if (str != null && !str.equals("")) {
            zzuo.zza(1, this.name);
        }
        zzl zzl = this.zzqh;
        if (zzl != null) {
            zzuo.zza(2, (zzuw) zzl);
        }
        zzh zzh = this.zzqi;
        if (zzh != null) {
            zzuo.zza(3, (zzuw) zzh);
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int zzy = super.zzy();
        String str = this.name;
        if (str != null && !str.equals("")) {
            zzy += zzuo.zzb(1, this.name);
        }
        zzl zzl = this.zzqh;
        if (zzl != null) {
            zzy += zzuo.zzb(2, (zzuw) zzl);
        }
        zzh zzh = this.zzqi;
        return zzh != null ? zzy + zzuo.zzb(3, (zzuw) zzh) : zzy;
    }
}
