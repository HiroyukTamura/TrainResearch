package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;

public final class zzh extends zzuq<zzh> {
    public zzl[] zzpe = zzl.zzaa();
    public zzl[] zzpf = zzl.zzaa();
    public zzc.C2674zzc[] zzpg = new zzc.C2674zzc[0];

    public zzh() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzh = (zzh) obj;
        if (!zzuu.equals((Object[]) this.zzpe, (Object[]) zzh.zzpe) || !zzuu.equals((Object[]) this.zzpf, (Object[]) zzh.zzpf) || !zzuu.equals((Object[]) this.zzpg, (Object[]) zzh.zzpg)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzh.zzbhb);
        }
        zzus zzus2 = zzh.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((zzuu.hashCode((Object[]) this.zzpf) + ((zzuu.hashCode((Object[]) this.zzpe) - 1328285312) * 31)) * 31) + zzuu.hashCode((Object[]) this.zzpg)) * 31;
        zzus zzus = this.zzbhb;
        return hashCode + ((zzus == null || zzus.isEmpty()) ? 0 : this.zzbhb.hashCode());
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzun, 10);
                zzl[] zzlArr = this.zzpe;
                int length = zzlArr == null ? 0 : zzlArr.length;
                int i = zzb + length;
                zzl[] zzlArr2 = new zzl[i];
                if (length != 0) {
                    System.arraycopy(this.zzpe, 0, zzlArr2, 0, length);
                }
                while (length < i - 1) {
                    zzlArr2[length] = new zzl();
                    zzun.zza((zzuw) zzlArr2[length]);
                    zzun.zzni();
                    length++;
                }
                zzlArr2[length] = new zzl();
                zzun.zza((zzuw) zzlArr2[length]);
                this.zzpe = zzlArr2;
            } else if (zzni == 18) {
                int zzb2 = zzuz.zzb(zzun, 18);
                zzl[] zzlArr3 = this.zzpf;
                int length2 = zzlArr3 == null ? 0 : zzlArr3.length;
                int i2 = zzb2 + length2;
                zzl[] zzlArr4 = new zzl[i2];
                if (length2 != 0) {
                    System.arraycopy(this.zzpf, 0, zzlArr4, 0, length2);
                }
                while (length2 < i2 - 1) {
                    zzlArr4[length2] = new zzl();
                    zzun.zza((zzuw) zzlArr4[length2]);
                    zzun.zzni();
                    length2++;
                }
                zzlArr4[length2] = new zzl();
                zzun.zza((zzuw) zzlArr4[length2]);
                this.zzpf = zzlArr4;
            } else if (zzni == 26) {
                int zzb3 = zzuz.zzb(zzun, 26);
                zzc.C2674zzc[] zzcArr = this.zzpg;
                int length3 = zzcArr == null ? 0 : zzcArr.length;
                int i3 = zzb3 + length3;
                zzc.C2674zzc[] zzcArr2 = new zzc.C2674zzc[i3];
                if (length3 != 0) {
                    System.arraycopy(this.zzpg, 0, zzcArr2, 0, length3);
                }
                while (length3 < i3 - 1) {
                    zzcArr2[length3] = (zzc.C2674zzc) zzun.zza(zzc.C2674zzc.zza());
                    zzun.zzni();
                    length3++;
                }
                zzcArr2[length3] = (zzc.C2674zzc) zzun.zza(zzc.C2674zzc.zza());
                this.zzpg = zzcArr2;
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzl[] zzlArr = this.zzpe;
        int i = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpe;
                if (i2 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i2];
                if (zzl != null) {
                    zzuo.zza(1, (zzuw) zzl);
                }
                i2++;
            }
        }
        zzl[] zzlArr3 = this.zzpf;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzpf;
                if (i3 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i3];
                if (zzl2 != null) {
                    zzuo.zza(2, (zzuw) zzl2);
                }
                i3++;
            }
        }
        zzc.C2674zzc[] zzcArr = this.zzpg;
        if (zzcArr != null && zzcArr.length > 0) {
            while (true) {
                zzc.C2674zzc[] zzcArr2 = this.zzpg;
                if (i >= zzcArr2.length) {
                    break;
                }
                zzc.C2674zzc zzc = zzcArr2[i];
                if (zzc != null) {
                    zzuo.zze(3, (zzsk) zzc);
                }
                i++;
            }
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int zzy = super.zzy();
        zzl[] zzlArr = this.zzpe;
        int i = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpe;
                if (i2 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i2];
                if (zzl != null) {
                    zzy = zzuo.zzb(1, (zzuw) zzl) + zzy;
                }
                i2++;
            }
        }
        zzl[] zzlArr3 = this.zzpf;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzpf;
                if (i3 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i3];
                if (zzl2 != null) {
                    zzy += zzuo.zzb(2, (zzuw) zzl2);
                }
                i3++;
            }
        }
        zzc.C2674zzc[] zzcArr = this.zzpg;
        if (zzcArr != null && zzcArr.length > 0) {
            while (true) {
                zzc.C2674zzc[] zzcArr2 = this.zzpg;
                if (i >= zzcArr2.length) {
                    break;
                }
                zzc.C2674zzc zzc = zzcArr2[i];
                if (zzc != null) {
                    zzy += zzqj.zzc(3, (zzsk) zzc);
                }
                i++;
            }
        }
        return zzy;
    }
}
