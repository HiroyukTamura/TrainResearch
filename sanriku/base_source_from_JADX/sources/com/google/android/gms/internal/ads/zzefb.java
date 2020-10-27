package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import java.io.IOException;
import java.util.Arrays;

public final class zzefb {
    private static final zzefb zzicj = new zzefb(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzhsu;
    private int zzhxw;
    private Object[] zziae;
    private int[] zzick;

    private zzefb() {
        this(0, new int[8], new Object[8], true);
    }

    private zzefb(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzhxw = -1;
        this.count = i;
        this.zzick = iArr;
        this.zziae = objArr;
        this.zzhsu = z;
    }

    static zzefb zza(zzefb zzefb, zzefb zzefb2) {
        int i = zzefb.count + zzefb2.count;
        int[] copyOf = Arrays.copyOf(zzefb.zzick, i);
        System.arraycopy(zzefb2.zzick, 0, copyOf, zzefb.count, zzefb2.count);
        Object[] copyOf2 = Arrays.copyOf(zzefb.zziae, i);
        System.arraycopy(zzefb2.zziae, 0, copyOf2, zzefb.count, zzefb2.count);
        return new zzefb(i, copyOf, copyOf2, true);
    }

    private static void zzb(int i, Object obj, zzefv zzefv) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzefv.zzp(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzefv.zzj(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzefv.zza(i2, (zzeaq) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzefv.zzae(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzeco.zzbfl());
        } else if (zzefv.zzbeb() == zzecd.zzf.zzhym) {
            zzefv.zzgt(i2);
            ((zzefb) obj).zzb(zzefv);
            zzefv.zzgu(i2);
        } else {
            zzefv.zzgu(i2);
            ((zzefb) obj).zzb(zzefv);
            zzefv.zzgt(i2);
        }
    }

    public static zzefb zzbhd() {
        return zzicj;
    }

    static zzefb zzbhe() {
        return new zzefb();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzefb)) {
            return false;
        }
        zzefb zzefb = (zzefb) obj;
        int i = this.count;
        if (i == zzefb.count) {
            int[] iArr = this.zzick;
            int[] iArr2 = zzefb.zzick;
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
                Object[] objArr = this.zziae;
                Object[] objArr2 = zzefb.zziae;
                int i3 = this.count;
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
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzick;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zziae;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzefv zzefv) throws IOException {
        if (zzefv.zzbeb() == zzecd.zzf.zzhyn) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzefv.zzc(this.zzick[i] >>> 3, this.zziae[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzefv.zzc(this.zzick[i2] >>> 3, this.zziae[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzedp.zza(sb, i, String.valueOf(this.zzick[i2] >>> 3), this.zziae[i2]);
        }
    }

    public final void zzb(zzefv zzefv) throws IOException {
        if (this.count != 0) {
            if (zzefv.zzbeb() == zzecd.zzf.zzhym) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzick[i], this.zziae[i], zzefv);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzick[i2], this.zziae[i2], zzefv);
            }
        }
    }

    public final void zzbcj() {
        this.zzhsu = false;
    }

    public final int zzbex() {
        int i;
        int i2 = this.zzhxw;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzick[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzebk.zzl(i6, ((Long) this.zziae[i4]).longValue());
            } else if (i7 == 1) {
                i = zzebk.zzn(i6, ((Long) this.zziae[i4]).longValue());
            } else if (i7 == 2) {
                i = zzebk.zzc(i6, (zzeaq) this.zziae[i4]);
            } else if (i7 == 3) {
                i3 = ((zzefb) this.zziae[i4]).zzbex() + (zzebk.zzgk(i6) << 1) + i3;
            } else if (i7 == 5) {
                i = zzebk.zzai(i6, ((Integer) this.zziae[i4]).intValue());
            } else {
                throw new IllegalStateException(zzeco.zzbfl());
            }
            i3 = i + i3;
        }
        this.zzhxw = i3;
        return i3;
    }

    public final int zzbhf() {
        int i = this.zzhxw;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzebk.zzd(this.zzick[i3] >>> 3, (zzeaq) this.zziae[i3]);
        }
        this.zzhxw = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, Object obj) {
        if (this.zzhsu) {
            int i2 = this.count;
            if (i2 == this.zzick.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzick = Arrays.copyOf(this.zzick, i3);
                this.zziae = Arrays.copyOf(this.zziae, i3);
            }
            int[] iArr = this.zzick;
            int i4 = this.count;
            iArr[i4] = i;
            this.zziae[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
