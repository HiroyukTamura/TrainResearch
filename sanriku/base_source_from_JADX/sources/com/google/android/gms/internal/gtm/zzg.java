package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzg {

    public static final class zza extends zzuq<zza> {
        public static final zzur<zzl, zza> zzpx = zzur.zza(11, zza.class, 810);
        private static final zza[] zzpy = new zza[0];
        public int[] zzpz;
        public int[] zzqa;
        public int[] zzqb;
        private int zzqc = 0;
        public int[] zzqd;
        public int zzqe;
        private int zzqf;

        public zza() {
            int[] iArr = zzuz.zzbcw;
            this.zzpz = iArr;
            this.zzqa = iArr;
            this.zzqb = iArr;
            this.zzqd = iArr;
            this.zzqe = 0;
            this.zzqf = 0;
            this.zzbhb = null;
            this.zzbhl = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!zzuu.equals(this.zzpz, zza.zzpz) || !zzuu.equals(this.zzqa, zza.zzqa) || !zzuu.equals(this.zzqb, zza.zzqb) || this.zzqc != zza.zzqc || !zzuu.equals(this.zzqd, zza.zzqd) || this.zzqe != zza.zzqe || this.zzqf != zza.zzqf) {
                return false;
            }
            zzus zzus = this.zzbhb;
            if (zzus != null && !zzus.isEmpty()) {
                return this.zzbhb.equals(zza.zzbhb);
            }
            zzus zzus2 = zza.zzbhb;
            return zzus2 == null || zzus2.isEmpty();
        }

        public final int hashCode() {
            int hashCode = zzuu.hashCode(this.zzqa);
            int hashCode2 = (((((zzuu.hashCode(this.zzqd) + ((((zzuu.hashCode(this.zzqb) + ((hashCode + ((zzuu.hashCode(this.zzpz) + 1215384196) * 31)) * 31)) * 31) + this.zzqc) * 31)) * 31) + this.zzqe) * 31) + this.zzqf) * 31;
            zzus zzus = this.zzbhb;
            return hashCode2 + ((zzus == null || zzus.isEmpty()) ? 0 : this.zzbhb.hashCode());
        }

        public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
            int i;
            while (true) {
                int zzni = zzun.zzni();
                switch (zzni) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzuz.zzb(zzun, 8);
                        int[] iArr = this.zzpz;
                        int length = iArr == null ? 0 : iArr.length;
                        int i2 = zzb + length;
                        int[] iArr2 = new int[i2];
                        if (length != 0) {
                            System.arraycopy(this.zzpz, 0, iArr2, 0, length);
                        }
                        while (length < i2 - 1) {
                            iArr2[length] = zzun.zzoa();
                            zzun.zzni();
                            length++;
                        }
                        iArr2[length] = zzun.zzoa();
                        this.zzpz = iArr2;
                        continue;
                    case 10:
                        i = zzun.zzaq(zzun.zzoa());
                        int position = zzun.getPosition();
                        int i3 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i3++;
                        }
                        zzun.zzbz(position);
                        int[] iArr3 = this.zzpz;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int i4 = i3 + length2;
                        int[] iArr4 = new int[i4];
                        if (length2 != 0) {
                            System.arraycopy(this.zzpz, 0, iArr4, 0, length2);
                        }
                        while (length2 < i4) {
                            iArr4[length2] = zzun.zzoa();
                            length2++;
                        }
                        this.zzpz = iArr4;
                        break;
                    case 16:
                        int zzb2 = zzuz.zzb(zzun, 16);
                        int[] iArr5 = this.zzqa;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int i5 = zzb2 + length3;
                        int[] iArr6 = new int[i5];
                        if (length3 != 0) {
                            System.arraycopy(this.zzqa, 0, iArr6, 0, length3);
                        }
                        while (length3 < i5 - 1) {
                            iArr6[length3] = zzun.zzoa();
                            zzun.zzni();
                            length3++;
                        }
                        iArr6[length3] = zzun.zzoa();
                        this.zzqa = iArr6;
                        continue;
                    case 18:
                        i = zzun.zzaq(zzun.zzoa());
                        int position2 = zzun.getPosition();
                        int i6 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i6++;
                        }
                        zzun.zzbz(position2);
                        int[] iArr7 = this.zzqa;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int i7 = i6 + length4;
                        int[] iArr8 = new int[i7];
                        if (length4 != 0) {
                            System.arraycopy(this.zzqa, 0, iArr8, 0, length4);
                        }
                        while (length4 < i7) {
                            iArr8[length4] = zzun.zzoa();
                            length4++;
                        }
                        this.zzqa = iArr8;
                        break;
                    case 24:
                        int zzb3 = zzuz.zzb(zzun, 24);
                        int[] iArr9 = this.zzqb;
                        int length5 = iArr9 == null ? 0 : iArr9.length;
                        int i8 = zzb3 + length5;
                        int[] iArr10 = new int[i8];
                        if (length5 != 0) {
                            System.arraycopy(this.zzqb, 0, iArr10, 0, length5);
                        }
                        while (length5 < i8 - 1) {
                            iArr10[length5] = zzun.zzoa();
                            zzun.zzni();
                            length5++;
                        }
                        iArr10[length5] = zzun.zzoa();
                        this.zzqb = iArr10;
                        continue;
                    case 26:
                        i = zzun.zzaq(zzun.zzoa());
                        int position3 = zzun.getPosition();
                        int i9 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i9++;
                        }
                        zzun.zzbz(position3);
                        int[] iArr11 = this.zzqb;
                        int length6 = iArr11 == null ? 0 : iArr11.length;
                        int i10 = i9 + length6;
                        int[] iArr12 = new int[i10];
                        if (length6 != 0) {
                            System.arraycopy(this.zzqb, 0, iArr12, 0, length6);
                        }
                        while (length6 < i10) {
                            iArr12[length6] = zzun.zzoa();
                            length6++;
                        }
                        this.zzqb = iArr12;
                        break;
                    case 32:
                        this.zzqc = zzun.zzoa();
                        continue;
                    case 40:
                        int zzb4 = zzuz.zzb(zzun, 40);
                        int[] iArr13 = this.zzqd;
                        int length7 = iArr13 == null ? 0 : iArr13.length;
                        int i11 = zzb4 + length7;
                        int[] iArr14 = new int[i11];
                        if (length7 != 0) {
                            System.arraycopy(this.zzqd, 0, iArr14, 0, length7);
                        }
                        while (length7 < i11 - 1) {
                            iArr14[length7] = zzun.zzoa();
                            zzun.zzni();
                            length7++;
                        }
                        iArr14[length7] = zzun.zzoa();
                        this.zzqd = iArr14;
                        continue;
                    case 42:
                        i = zzun.zzaq(zzun.zzoa());
                        int position4 = zzun.getPosition();
                        int i12 = 0;
                        while (zzun.zzrv() > 0) {
                            zzun.zzoa();
                            i12++;
                        }
                        zzun.zzbz(position4);
                        int[] iArr15 = this.zzqd;
                        int length8 = iArr15 == null ? 0 : iArr15.length;
                        int i13 = i12 + length8;
                        int[] iArr16 = new int[i13];
                        if (length8 != 0) {
                            System.arraycopy(this.zzqd, 0, iArr16, 0, length8);
                        }
                        while (length8 < i13) {
                            iArr16[length8] = zzun.zzoa();
                            length8++;
                        }
                        this.zzqd = iArr16;
                        break;
                    case 48:
                        this.zzqe = zzun.zzoa();
                        continue;
                    case 56:
                        this.zzqf = zzun.zzoa();
                        continue;
                    default:
                        if (!super.zza(zzun, zzni)) {
                            return this;
                        }
                        continue;
                }
                zzun.zzar(i);
            }
        }

        public final void zza(zzuo zzuo) throws IOException {
            int[] iArr = this.zzpz;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.zzpz;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    zzuo.zze(1, iArr2[i2]);
                    i2++;
                }
            }
            int[] iArr3 = this.zzqa;
            if (iArr3 != null && iArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr4 = this.zzqa;
                    if (i3 >= iArr4.length) {
                        break;
                    }
                    zzuo.zze(2, iArr4[i3]);
                    i3++;
                }
            }
            int[] iArr5 = this.zzqb;
            if (iArr5 != null && iArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr6 = this.zzqb;
                    if (i4 >= iArr6.length) {
                        break;
                    }
                    zzuo.zze(3, iArr6[i4]);
                    i4++;
                }
            }
            int i5 = this.zzqc;
            if (i5 != 0) {
                zzuo.zze(4, i5);
            }
            int[] iArr7 = this.zzqd;
            if (iArr7 != null && iArr7.length > 0) {
                while (true) {
                    int[] iArr8 = this.zzqd;
                    if (i >= iArr8.length) {
                        break;
                    }
                    zzuo.zze(5, iArr8[i]);
                    i++;
                }
            }
            int i6 = this.zzqe;
            if (i6 != 0) {
                zzuo.zze(6, i6);
            }
            int i7 = this.zzqf;
            if (i7 != 0) {
                zzuo.zze(7, i7);
            }
            super.zza(zzuo);
        }

        /* access modifiers changed from: protected */
        public final int zzy() {
            int[] iArr;
            int[] iArr2;
            int[] iArr3;
            int[] iArr4;
            int zzy = super.zzy();
            int[] iArr5 = this.zzpz;
            int i = 0;
            if (iArr5 != null && iArr5.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    iArr4 = this.zzpz;
                    if (i2 >= iArr4.length) {
                        break;
                    }
                    i3 += zzuo.zzbc(iArr4[i2]);
                    i2++;
                }
                zzy = zzy + i3 + (iArr4.length * 1);
            }
            int[] iArr6 = this.zzqa;
            if (iArr6 != null && iArr6.length > 0) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    iArr3 = this.zzqa;
                    if (i4 >= iArr3.length) {
                        break;
                    }
                    i5 += zzuo.zzbc(iArr3[i4]);
                    i4++;
                }
                zzy = zzy + i5 + (iArr3.length * 1);
            }
            int[] iArr7 = this.zzqb;
            if (iArr7 != null && iArr7.length > 0) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    iArr2 = this.zzqb;
                    if (i6 >= iArr2.length) {
                        break;
                    }
                    i7 += zzuo.zzbc(iArr2[i6]);
                    i6++;
                }
                zzy = zzy + i7 + (iArr2.length * 1);
            }
            int i8 = this.zzqc;
            if (i8 != 0) {
                zzy += zzuo.zzi(4, i8);
            }
            int[] iArr8 = this.zzqd;
            if (iArr8 != null && iArr8.length > 0) {
                int i9 = 0;
                while (true) {
                    iArr = this.zzqd;
                    if (i >= iArr.length) {
                        break;
                    }
                    i9 += zzuo.zzbc(iArr[i]);
                    i++;
                }
                zzy = zzy + i9 + (iArr.length * 1);
            }
            int i10 = this.zzqe;
            if (i10 != 0) {
                zzy += zzuo.zzi(6, i10);
            }
            int i11 = this.zzqf;
            return i11 != 0 ? zzy + zzuo.zzi(7, i11) : zzy;
        }
    }
}
