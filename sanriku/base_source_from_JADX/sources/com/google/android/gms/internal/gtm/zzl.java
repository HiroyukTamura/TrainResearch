package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzl extends zzuq<zzl> {
    private static volatile zzl[] zzqm;
    public String string = "";
    public int type = 1;
    public zzl[] zzqn = zzaa();
    public zzl[] zzqo = zzaa();
    public zzl[] zzqp = zzaa();
    public String zzqq = "";
    public String zzqr = "";
    public long zzqs = 0;
    public boolean zzqt = false;
    public zzl[] zzqu = zzaa();
    public int[] zzqv = zzuz.zzbcw;
    public boolean zzqw = false;

    public zzl() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public static zzl[] zzaa() {
        if (zzqm == null) {
            synchronized (zzuu.zzbhk) {
                if (zzqm == null) {
                    zzqm = new zzl[0];
                }
            }
        }
        return zzqm;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzl zza(zzun zzun) throws IOException {
        int zzoa;
        while (true) {
            int zzni = zzun.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 8:
                    try {
                        zzoa = zzun.zzoa();
                        if (zzoa > 0 && zzoa <= 8) {
                            this.type = zzoa;
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(36);
                            sb.append(zzoa);
                            sb.append(" is not a valid enum Type");
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzun.zzbz(zzun.getPosition());
                        zza(zzun, zzni);
                        break;
                    }
                    break;
                case 18:
                    this.string = zzun.readString();
                    break;
                case 26:
                    int zzb = zzuz.zzb(zzun, 26);
                    zzl[] zzlArr = this.zzqn;
                    int length = zzlArr == null ? 0 : zzlArr.length;
                    int i = zzb + length;
                    zzl[] zzlArr2 = new zzl[i];
                    if (length != 0) {
                        System.arraycopy(this.zzqn, 0, zzlArr2, 0, length);
                    }
                    while (length < i - 1) {
                        zzlArr2[length] = new zzl();
                        zzun.zza((zzuw) zzlArr2[length]);
                        zzun.zzni();
                        length++;
                    }
                    zzlArr2[length] = new zzl();
                    zzun.zza((zzuw) zzlArr2[length]);
                    this.zzqn = zzlArr2;
                    break;
                case 34:
                    int zzb2 = zzuz.zzb(zzun, 34);
                    zzl[] zzlArr3 = this.zzqo;
                    int length2 = zzlArr3 == null ? 0 : zzlArr3.length;
                    int i2 = zzb2 + length2;
                    zzl[] zzlArr4 = new zzl[i2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzqo, 0, zzlArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        zzlArr4[length2] = new zzl();
                        zzun.zza((zzuw) zzlArr4[length2]);
                        zzun.zzni();
                        length2++;
                    }
                    zzlArr4[length2] = new zzl();
                    zzun.zza((zzuw) zzlArr4[length2]);
                    this.zzqo = zzlArr4;
                    break;
                case 42:
                    int zzb3 = zzuz.zzb(zzun, 42);
                    zzl[] zzlArr5 = this.zzqp;
                    int length3 = zzlArr5 == null ? 0 : zzlArr5.length;
                    int i3 = zzb3 + length3;
                    zzl[] zzlArr6 = new zzl[i3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzqp, 0, zzlArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        zzlArr6[length3] = new zzl();
                        zzun.zza((zzuw) zzlArr6[length3]);
                        zzun.zzni();
                        length3++;
                    }
                    zzlArr6[length3] = new zzl();
                    zzun.zza((zzuw) zzlArr6[length3]);
                    this.zzqp = zzlArr6;
                    break;
                case 50:
                    this.zzqq = zzun.readString();
                    break;
                case 58:
                    this.zzqr = zzun.readString();
                    break;
                case 64:
                    this.zzqs = zzun.zzob();
                    break;
                case 72:
                    this.zzqw = zzun.zzno();
                    break;
                case 80:
                    int zzb4 = zzuz.zzb(zzun, 80);
                    int[] iArr = new int[zzb4];
                    int i4 = 0;
                    for (int i5 = 0; i5 < zzb4; i5++) {
                        if (i5 != 0) {
                            zzun.zzni();
                        }
                        int position = zzun.getPosition();
                        try {
                            iArr[i4] = zzc(zzun.zzoa());
                            i4++;
                        } catch (IllegalArgumentException unused2) {
                            zzun.zzbz(position);
                            zza(zzun, zzni);
                        }
                    }
                    if (i4 != 0) {
                        int[] iArr2 = this.zzqv;
                        int length4 = iArr2 == null ? 0 : iArr2.length;
                        if (length4 != 0 || i4 != zzb4) {
                            int[] iArr3 = new int[(length4 + i4)];
                            if (length4 != 0) {
                                System.arraycopy(this.zzqv, 0, iArr3, 0, length4);
                            }
                            System.arraycopy(iArr, 0, iArr3, length4, i4);
                            this.zzqv = iArr3;
                            break;
                        } else {
                            this.zzqv = iArr;
                            break;
                        }
                    } else {
                        break;
                    }
                case 82:
                    int zzaq = zzun.zzaq(zzun.zzoa());
                    int position2 = zzun.getPosition();
                    int i6 = 0;
                    while (zzun.zzrv() > 0) {
                        try {
                            zzc(zzun.zzoa());
                            i6++;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    if (i6 != 0) {
                        zzun.zzbz(position2);
                        int[] iArr4 = this.zzqv;
                        int length5 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[(i6 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzqv, 0, iArr5, 0, length5);
                        }
                        while (zzun.zzrv() > 0) {
                            int position3 = zzun.getPosition();
                            try {
                                iArr5[length5] = zzc(zzun.zzoa());
                                length5++;
                            } catch (IllegalArgumentException unused4) {
                                zzun.zzbz(position3);
                                zza(zzun, 80);
                            }
                        }
                        this.zzqv = iArr5;
                    }
                    zzun.zzar(zzaq);
                    break;
                case 90:
                    int zzb5 = zzuz.zzb(zzun, 90);
                    zzl[] zzlArr7 = this.zzqu;
                    int length6 = zzlArr7 == null ? 0 : zzlArr7.length;
                    int i7 = zzb5 + length6;
                    zzl[] zzlArr8 = new zzl[i7];
                    if (length6 != 0) {
                        System.arraycopy(this.zzqu, 0, zzlArr8, 0, length6);
                    }
                    while (length6 < i7 - 1) {
                        zzlArr8[length6] = new zzl();
                        zzun.zza((zzuw) zzlArr8[length6]);
                        zzun.zzni();
                        length6++;
                    }
                    zzlArr8[length6] = new zzl();
                    zzun.zza((zzuw) zzlArr8[length6]);
                    this.zzqu = zzlArr8;
                    break;
                case 96:
                    this.zzqt = zzun.zzno();
                    break;
                default:
                    if (super.zza(zzun, zzni)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
        StringBuilder sb2 = new StringBuilder(36);
        sb2.append(zzoa);
        sb2.append(" is not a valid enum Type");
        throw new IllegalArgumentException(sb2.toString());
    }

    private static int zzc(int i) {
        if (i > 0 && i <= 17) {
            return i;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append(i);
        sb.append(" is not a valid enum Escaping");
        throw new IllegalArgumentException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl = (zzl) obj;
        if (this.type != zzl.type) {
            return false;
        }
        String str = this.string;
        if (str == null) {
            if (zzl.string != null) {
                return false;
            }
        } else if (!str.equals(zzl.string)) {
            return false;
        }
        if (!zzuu.equals((Object[]) this.zzqn, (Object[]) zzl.zzqn) || !zzuu.equals((Object[]) this.zzqo, (Object[]) zzl.zzqo) || !zzuu.equals((Object[]) this.zzqp, (Object[]) zzl.zzqp)) {
            return false;
        }
        String str2 = this.zzqq;
        if (str2 == null) {
            if (zzl.zzqq != null) {
                return false;
            }
        } else if (!str2.equals(zzl.zzqq)) {
            return false;
        }
        String str3 = this.zzqr;
        if (str3 == null) {
            if (zzl.zzqr != null) {
                return false;
            }
        } else if (!str3.equals(zzl.zzqr)) {
            return false;
        }
        if (this.zzqs != zzl.zzqs || this.zzqt != zzl.zzqt || !zzuu.equals((Object[]) this.zzqu, (Object[]) zzl.zzqu) || !zzuu.equals(this.zzqv, zzl.zzqv) || this.zzqw != zzl.zzqw) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzl.zzbhb);
        }
        zzus zzus2 = zzl.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        int i = (-1328285188 + this.type) * 31;
        String str = this.string;
        int i2 = 0;
        int hashCode = (zzuu.hashCode((Object[]) this.zzqp) + ((zzuu.hashCode((Object[]) this.zzqo) + ((zzuu.hashCode((Object[]) this.zzqn) + ((i + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31;
        String str2 = this.zzqq;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzqr;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.zzqs;
        int i3 = (((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        int i4 = 1231;
        int hashCode4 = (zzuu.hashCode(this.zzqv) + ((zzuu.hashCode((Object[]) this.zzqu) + ((i3 + (this.zzqt ? 1231 : 1237)) * 31)) * 31)) * 31;
        if (!this.zzqw) {
            i4 = 1237;
        }
        int i5 = (hashCode4 + i4) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i2 = this.zzbhb.hashCode();
        }
        return i5 + i2;
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzuo.zze(1, this.type);
        String str = this.string;
        if (str != null && !str.equals("")) {
            zzuo.zza(2, this.string);
        }
        zzl[] zzlArr = this.zzqn;
        int i = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzqn;
                if (i2 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i2];
                if (zzl != null) {
                    zzuo.zza(3, (zzuw) zzl);
                }
                i2++;
            }
        }
        zzl[] zzlArr3 = this.zzqo;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzqo;
                if (i3 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i3];
                if (zzl2 != null) {
                    zzuo.zza(4, (zzuw) zzl2);
                }
                i3++;
            }
        }
        zzl[] zzlArr5 = this.zzqp;
        if (zzlArr5 != null && zzlArr5.length > 0) {
            int i4 = 0;
            while (true) {
                zzl[] zzlArr6 = this.zzqp;
                if (i4 >= zzlArr6.length) {
                    break;
                }
                zzl zzl3 = zzlArr6[i4];
                if (zzl3 != null) {
                    zzuo.zza(5, (zzuw) zzl3);
                }
                i4++;
            }
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            zzuo.zza(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            zzuo.zza(7, this.zzqr);
        }
        long j = this.zzqs;
        if (j != 0) {
            zzuo.zzi(8, j);
        }
        boolean z = this.zzqw;
        if (z) {
            zzuo.zzb(9, z);
        }
        int[] iArr = this.zzqv;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.zzqv;
                if (i5 >= iArr2.length) {
                    break;
                }
                zzuo.zze(10, iArr2[i5]);
                i5++;
            }
        }
        zzl[] zzlArr7 = this.zzqu;
        if (zzlArr7 != null && zzlArr7.length > 0) {
            while (true) {
                zzl[] zzlArr8 = this.zzqu;
                if (i >= zzlArr8.length) {
                    break;
                }
                zzl zzl4 = zzlArr8[i];
                if (zzl4 != null) {
                    zzuo.zza(11, (zzuw) zzl4);
                }
                i++;
            }
        }
        boolean z2 = this.zzqt;
        if (z2) {
            zzuo.zzb(12, z2);
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int[] iArr;
        int zzi = zzuo.zzi(1, this.type) + super.zzy();
        String str = this.string;
        if (str != null && !str.equals("")) {
            zzi += zzuo.zzb(2, this.string);
        }
        zzl[] zzlArr = this.zzqn;
        int i = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzqn;
                if (i2 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i2];
                if (zzl != null) {
                    zzi = zzuo.zzb(3, (zzuw) zzl) + zzi;
                }
                i2++;
            }
        }
        zzl[] zzlArr3 = this.zzqo;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzqo;
                if (i3 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i3];
                if (zzl2 != null) {
                    zzi += zzuo.zzb(4, (zzuw) zzl2);
                }
                i3++;
            }
        }
        zzl[] zzlArr5 = this.zzqp;
        if (zzlArr5 != null && zzlArr5.length > 0) {
            int i4 = 0;
            while (true) {
                zzl[] zzlArr6 = this.zzqp;
                if (i4 >= zzlArr6.length) {
                    break;
                }
                zzl zzl3 = zzlArr6[i4];
                if (zzl3 != null) {
                    zzi += zzuo.zzb(5, (zzuw) zzl3);
                }
                i4++;
            }
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            zzi += zzuo.zzb(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            zzi += zzuo.zzb(7, this.zzqr);
        }
        long j = this.zzqs;
        if (j != 0) {
            zzi += zzuo.zzd(8, j);
        }
        if (this.zzqw) {
            zzi += zzuo.zzbb(9) + 1;
        }
        int[] iArr2 = this.zzqv;
        if (iArr2 != null && iArr2.length > 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                iArr = this.zzqv;
                if (i5 >= iArr.length) {
                    break;
                }
                i6 += zzuo.zzbc(iArr[i5]);
                i5++;
            }
            zzi = zzi + i6 + (iArr.length * 1);
        }
        zzl[] zzlArr7 = this.zzqu;
        if (zzlArr7 != null && zzlArr7.length > 0) {
            while (true) {
                zzl[] zzlArr8 = this.zzqu;
                if (i >= zzlArr8.length) {
                    break;
                }
                zzl zzl4 = zzlArr8[i];
                if (zzl4 != null) {
                    zzi += zzuo.zzb(11, (zzuw) zzl4);
                }
                i++;
            }
        }
        return this.zzqt ? zzi + zzuo.zzbb(12) + 1 : zzi;
    }
}
