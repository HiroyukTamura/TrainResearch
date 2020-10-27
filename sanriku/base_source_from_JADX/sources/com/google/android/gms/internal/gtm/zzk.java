package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzk extends zzuq<zzk> {
    public zzj[] zzqj = zzj.zzz();
    public zzi zzqk = null;
    public String zzql = "";

    public zzk() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzk)) {
            return false;
        }
        zzk zzk = (zzk) obj;
        if (!zzuu.equals((Object[]) this.zzqj, (Object[]) zzk.zzqj)) {
            return false;
        }
        zzi zzi = this.zzqk;
        if (zzi == null) {
            if (zzk.zzqk != null) {
                return false;
            }
        } else if (!zzi.equals(zzk.zzqk)) {
            return false;
        }
        String str = this.zzql;
        if (str == null) {
            if (zzk.zzql != null) {
                return false;
            }
        } else if (!str.equals(zzk.zzql)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzk.zzbhb);
        }
        zzus zzus2 = zzk.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        zzi zzi = this.zzqk;
        int i = 0;
        int hashCode = (((zzuu.hashCode((Object[]) this.zzqj) - 1328285219) * 31) + (zzi == null ? 0 : zzi.hashCode())) * 31;
        String str = this.zzql;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return hashCode2 + i;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzun, 10);
                zzj[] zzjArr = this.zzqj;
                int length = zzjArr == null ? 0 : zzjArr.length;
                int i = zzb + length;
                zzj[] zzjArr2 = new zzj[i];
                if (length != 0) {
                    System.arraycopy(this.zzqj, 0, zzjArr2, 0, length);
                }
                while (length < i - 1) {
                    zzjArr2[length] = new zzj();
                    zzun.zza((zzuw) zzjArr2[length]);
                    zzun.zzni();
                    length++;
                }
                zzjArr2[length] = new zzj();
                zzun.zza((zzuw) zzjArr2[length]);
                this.zzqj = zzjArr2;
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzun.zza((zzuw) this.zzqk);
            } else if (zzni == 26) {
                this.zzql = zzun.readString();
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzj[] zzjArr = this.zzqj;
        if (zzjArr != null && zzjArr.length > 0) {
            int i = 0;
            while (true) {
                zzj[] zzjArr2 = this.zzqj;
                if (i >= zzjArr2.length) {
                    break;
                }
                zzj zzj = zzjArr2[i];
                if (zzj != null) {
                    zzuo.zza(1, (zzuw) zzj);
                }
                i++;
            }
        }
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzuo.zza(2, (zzuw) zzi);
        }
        String str = this.zzql;
        if (str != null && !str.equals("")) {
            zzuo.zza(3, this.zzql);
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int zzy = super.zzy();
        zzj[] zzjArr = this.zzqj;
        if (zzjArr != null && zzjArr.length > 0) {
            int i = 0;
            while (true) {
                zzj[] zzjArr2 = this.zzqj;
                if (i >= zzjArr2.length) {
                    break;
                }
                zzj zzj = zzjArr2[i];
                if (zzj != null) {
                    zzy += zzuo.zzb(1, (zzuw) zzj);
                }
                i++;
            }
        }
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzy += zzuo.zzb(2, (zzuw) zzi);
        }
        String str = this.zzql;
        return (str == null || str.equals("")) ? zzy : zzy + zzuo.zzb(3, this.zzql);
    }
}
