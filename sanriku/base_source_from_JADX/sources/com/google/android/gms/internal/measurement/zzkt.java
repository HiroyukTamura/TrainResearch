package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import java.io.IOException;
import java.util.Arrays;

public final class zzkt {
    private static final zzkt zza = new zzkt(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzkt() {
        this(0, new int[8], new Object[8], true);
    }

    private zzkt(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzkt zza() {
        return zza;
    }

    static zzkt zza(zzkt zzkt, zzkt zzkt2) {
        int i = zzkt.zzb + zzkt2.zzb;
        int[] copyOf = Arrays.copyOf(zzkt.zzc, i);
        System.arraycopy(zzkt2.zzc, 0, copyOf, zzkt.zzb, zzkt2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzkt.zzd, i);
        System.arraycopy(zzkt2.zzd, 0, copyOf2, zzkt.zzb, zzkt2.zzb);
        return new zzkt(i, copyOf, copyOf2, true);
    }

    private static void zza(int i, Object obj, zzln zzln) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzln.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzln.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzln.zza(i2, (zzgt) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzln.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzij.zzf());
        } else if (zzln.zza() == zzib.zzf.zzj) {
            zzln.zza(i2);
            ((zzkt) obj).zzb(zzln);
            zzln.zzb(i2);
        } else {
            zzln.zzb(i2);
            ((zzkt) obj).zzb(zzln);
            zzln.zza(i2);
        }
    }

    static zzkt zzb() {
        return new zzkt();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzkt)) {
            return false;
        }
        zzkt zzkt = (zzkt) obj;
        int i = this.zzb;
        if (i == zzkt.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzkt.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzkt.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            if (i2 == this.zzc.length) {
                int i3 = this.zzb + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(this.zzc, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr = this.zzc;
            int i4 = this.zzb;
            iArr[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzln zzln) throws IOException {
        if (zzln.zza() == zzib.zzf.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzln.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzln.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjo.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzb(zzln zzln) throws IOException {
        if (this.zzb != 0) {
            if (zzln.zza() == zzib.zzf.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzln);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzln);
            }
        }
    }

    public final void zzc() {
        this.zzf = false;
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzhi.zzd(this.zzc[i3] >>> 3, (zzgt) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zze() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzhi.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzhi.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzhi.zzc(i6, (zzgt) this.zzd[i4]);
            } else if (i7 == 3) {
                i3 = ((zzkt) this.zzd[i4]).zze() + (zzhi.zze(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzhi.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzij.zzf());
            }
            i3 = i + i3;
        }
        this.zze = i3;
        return i3;
    }
}
