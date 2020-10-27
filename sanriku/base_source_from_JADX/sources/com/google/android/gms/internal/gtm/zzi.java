package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.silentlogsdkandroid.BuildConfig;

public final class zzi extends zzuq<zzi> {
    public String version = "";
    private String[] zzph;
    public String[] zzpi;
    public zzl[] zzpj = zzl.zzaa();
    public zzc.zzd[] zzpk = new zzc.zzd[0];
    public zzc.zzb[] zzpl = new zzc.zzb[0];
    public zzc.zzb[] zzpm = new zzc.zzb[0];
    public zzc.zzb[] zzpn = new zzc.zzb[0];
    public zzc.zze[] zzpo = new zzc.zze[0];
    private String zzpp = "";
    private String zzpq = "";
    private String zzpr = RFGDef.DEFAULT_GYM_ID;
    private zzc.zza zzps = null;
    private float zzpt = 0.0f;
    private boolean zzpu = false;
    private String[] zzpv = zzuz.zzbhu;
    public int zzpw = 0;

    public zzi() {
        String[] strArr = zzuz.zzbhu;
        this.zzph = strArr;
        this.zzpi = strArr;
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        if (!zzuu.equals((Object[]) this.zzph, (Object[]) zzi.zzph) || !zzuu.equals((Object[]) this.zzpi, (Object[]) zzi.zzpi) || !zzuu.equals((Object[]) this.zzpj, (Object[]) zzi.zzpj) || !zzuu.equals((Object[]) this.zzpk, (Object[]) zzi.zzpk) || !zzuu.equals((Object[]) this.zzpl, (Object[]) zzi.zzpl) || !zzuu.equals((Object[]) this.zzpm, (Object[]) zzi.zzpm) || !zzuu.equals((Object[]) this.zzpn, (Object[]) zzi.zzpn) || !zzuu.equals((Object[]) this.zzpo, (Object[]) zzi.zzpo)) {
            return false;
        }
        String str = this.zzpp;
        if (str == null) {
            if (zzi.zzpp != null) {
                return false;
            }
        } else if (!str.equals(zzi.zzpp)) {
            return false;
        }
        String str2 = this.zzpq;
        if (str2 == null) {
            if (zzi.zzpq != null) {
                return false;
            }
        } else if (!str2.equals(zzi.zzpq)) {
            return false;
        }
        String str3 = this.zzpr;
        if (str3 == null) {
            if (zzi.zzpr != null) {
                return false;
            }
        } else if (!str3.equals(zzi.zzpr)) {
            return false;
        }
        String str4 = this.version;
        if (str4 == null) {
            if (zzi.version != null) {
                return false;
            }
        } else if (!str4.equals(zzi.version)) {
            return false;
        }
        zzc.zza zza = this.zzps;
        if (zza == null) {
            if (zzi.zzps != null) {
                return false;
            }
        } else if (!zza.equals(zzi.zzps)) {
            return false;
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(zzi.zzpt) || this.zzpu != zzi.zzpu || !zzuu.equals((Object[]) this.zzpv, (Object[]) zzi.zzpv) || this.zzpw != zzi.zzpw) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzi.zzbhb);
        }
        zzus zzus2 = zzi.zzbhb;
        return zzus2 == null || zzus2.isEmpty();
    }

    public final int hashCode() {
        int hashCode = (((((((((((zzuu.hashCode((Object[]) this.zzpj) + ((((-1328285281 + zzuu.hashCode((Object[]) this.zzph)) * 31) + zzuu.hashCode((Object[]) this.zzpi)) * 31)) * 31) + zzuu.hashCode((Object[]) this.zzpk)) * 31) + zzuu.hashCode((Object[]) this.zzpl)) * 31) + zzuu.hashCode((Object[]) this.zzpm)) * 31) + zzuu.hashCode((Object[]) this.zzpn)) * 31) + zzuu.hashCode((Object[]) this.zzpo)) * 31;
        String str = this.zzpp;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzpq;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzpr;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        int hashCode5 = hashCode4 + (str4 == null ? 0 : str4.hashCode());
        zzc.zza zza = this.zzps;
        int floatToIntBits = (((((((Float.floatToIntBits(this.zzpt) + (((hashCode5 * 31) + (zza == null ? 0 : zza.hashCode())) * 31)) * 31) + (this.zzpu ? 1231 : 1237)) * 31) + zzuu.hashCode((Object[]) this.zzpv)) * 31) + this.zzpw) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i = this.zzbhb.hashCode();
        }
        return floatToIntBits + i;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzuz.zzb(zzun, 10);
                    String[] strArr = this.zzpi;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = zzb + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(this.zzpi, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = zzun.readString();
                        zzun.zzni();
                        length++;
                    }
                    strArr2[length] = zzun.readString();
                    this.zzpi = strArr2;
                    break;
                case 18:
                    int zzb2 = zzuz.zzb(zzun, 18);
                    zzl[] zzlArr = this.zzpj;
                    int length2 = zzlArr == null ? 0 : zzlArr.length;
                    int i2 = zzb2 + length2;
                    zzl[] zzlArr2 = new zzl[i2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzpj, 0, zzlArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        zzlArr2[length2] = new zzl();
                        zzun.zza((zzuw) zzlArr2[length2]);
                        zzun.zzni();
                        length2++;
                    }
                    zzlArr2[length2] = new zzl();
                    zzun.zza((zzuw) zzlArr2[length2]);
                    this.zzpj = zzlArr2;
                    break;
                case 26:
                    int zzb3 = zzuz.zzb(zzun, 26);
                    zzc.zzd[] zzdArr = this.zzpk;
                    int length3 = zzdArr == null ? 0 : zzdArr.length;
                    int i3 = zzb3 + length3;
                    zzc.zzd[] zzdArr2 = new zzc.zzd[i3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzpk, 0, zzdArr2, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        zzdArr2[length3] = (zzc.zzd) zzun.zza(zzc.zzd.zza());
                        zzun.zzni();
                        length3++;
                    }
                    zzdArr2[length3] = (zzc.zzd) zzun.zza(zzc.zzd.zza());
                    this.zzpk = zzdArr2;
                    break;
                case 34:
                    int zzb4 = zzuz.zzb(zzun, 34);
                    zzc.zzb[] zzbArr = this.zzpl;
                    int length4 = zzbArr == null ? 0 : zzbArr.length;
                    int i4 = zzb4 + length4;
                    zzc.zzb[] zzbArr2 = new zzc.zzb[i4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzpl, 0, zzbArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        zzbArr2[length4] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length4++;
                    }
                    zzbArr2[length4] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpl = zzbArr2;
                    break;
                case 42:
                    int zzb5 = zzuz.zzb(zzun, 42);
                    zzc.zzb[] zzbArr3 = this.zzpm;
                    int length5 = zzbArr3 == null ? 0 : zzbArr3.length;
                    int i5 = zzb5 + length5;
                    zzc.zzb[] zzbArr4 = new zzc.zzb[i5];
                    if (length5 != 0) {
                        System.arraycopy(this.zzpm, 0, zzbArr4, 0, length5);
                    }
                    while (length5 < i5 - 1) {
                        zzbArr4[length5] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length5++;
                    }
                    zzbArr4[length5] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpm = zzbArr4;
                    break;
                case 50:
                    int zzb6 = zzuz.zzb(zzun, 50);
                    zzc.zzb[] zzbArr5 = this.zzpn;
                    int length6 = zzbArr5 == null ? 0 : zzbArr5.length;
                    int i6 = zzb6 + length6;
                    zzc.zzb[] zzbArr6 = new zzc.zzb[i6];
                    if (length6 != 0) {
                        System.arraycopy(this.zzpn, 0, zzbArr6, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        zzbArr6[length6] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length6++;
                    }
                    zzbArr6[length6] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpn = zzbArr6;
                    break;
                case 58:
                    int zzb7 = zzuz.zzb(zzun, 58);
                    zzc.zze[] zzeArr = this.zzpo;
                    int length7 = zzeArr == null ? 0 : zzeArr.length;
                    int i7 = zzb7 + length7;
                    zzc.zze[] zzeArr2 = new zzc.zze[i7];
                    if (length7 != 0) {
                        System.arraycopy(this.zzpo, 0, zzeArr2, 0, length7);
                    }
                    while (length7 < i7 - 1) {
                        zzeArr2[length7] = (zzc.zze) zzun.zza(zzc.zze.zza());
                        zzun.zzni();
                        length7++;
                    }
                    zzeArr2[length7] = (zzc.zze) zzun.zza(zzc.zze.zza());
                    this.zzpo = zzeArr2;
                    break;
                case 74:
                    this.zzpp = zzun.readString();
                    break;
                case 82:
                    this.zzpq = zzun.readString();
                    break;
                case 98:
                    this.zzpr = zzun.readString();
                    break;
                case 106:
                    this.version = zzun.readString();
                    break;
                case 114:
                    zzc.zza zza = (zzc.zza) zzun.zza(zzc.zza.zza());
                    zzc.zza zza2 = this.zzps;
                    if (zza2 != null) {
                        zza = (zzc.zza) ((zzrc) ((zzc.zza.C2673zza) ((zzc.zza.C2673zza) zza2.zzpd()).zza(zza)).zzpm());
                    }
                    this.zzps = zza;
                    break;
                case 125:
                    this.zzpt = Float.intBitsToFloat(zzun.zzoc());
                    break;
                case 130:
                    int zzb8 = zzuz.zzb(zzun, 130);
                    String[] strArr3 = this.zzpv;
                    int length8 = strArr3 == null ? 0 : strArr3.length;
                    int i8 = zzb8 + length8;
                    String[] strArr4 = new String[i8];
                    if (length8 != 0) {
                        System.arraycopy(this.zzpv, 0, strArr4, 0, length8);
                    }
                    while (length8 < i8 - 1) {
                        strArr4[length8] = zzun.readString();
                        zzun.zzni();
                        length8++;
                    }
                    strArr4[length8] = zzun.readString();
                    this.zzpv = strArr4;
                    break;
                case BuildConfig.VERSION_CODE /*136*/:
                    this.zzpw = zzun.zzoa();
                    break;
                case 144:
                    this.zzpu = zzun.zzno();
                    break;
                case 154:
                    int zzb9 = zzuz.zzb(zzun, 154);
                    String[] strArr5 = this.zzph;
                    int length9 = strArr5 == null ? 0 : strArr5.length;
                    int i9 = zzb9 + length9;
                    String[] strArr6 = new String[i9];
                    if (length9 != 0) {
                        System.arraycopy(this.zzph, 0, strArr6, 0, length9);
                    }
                    while (length9 < i9 - 1) {
                        strArr6[length9] = zzun.readString();
                        zzun.zzni();
                        length9++;
                    }
                    strArr6[length9] = zzun.readString();
                    this.zzph = strArr6;
                    break;
                default:
                    if (super.zza(zzun, zzni)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final void zza(zzuo zzuo) throws IOException {
        String[] strArr = this.zzpi;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    zzuo.zza(1, str);
                }
                i2++;
            }
        }
        zzl[] zzlArr = this.zzpj;
        if (zzlArr != null && zzlArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpj;
                if (i3 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i3];
                if (zzl != null) {
                    zzuo.zza(2, (zzuw) zzl);
                }
                i3++;
            }
        }
        zzc.zzd[] zzdArr = this.zzpk;
        if (zzdArr != null && zzdArr.length > 0) {
            int i4 = 0;
            while (true) {
                zzc.zzd[] zzdArr2 = this.zzpk;
                if (i4 >= zzdArr2.length) {
                    break;
                }
                zzc.zzd zzd = zzdArr2[i4];
                if (zzd != null) {
                    zzuo.zze(3, (zzsk) zzd);
                }
                i4++;
            }
        }
        zzc.zzb[] zzbArr = this.zzpl;
        if (zzbArr != null && zzbArr.length > 0) {
            int i5 = 0;
            while (true) {
                zzc.zzb[] zzbArr2 = this.zzpl;
                if (i5 >= zzbArr2.length) {
                    break;
                }
                zzc.zzb zzb = zzbArr2[i5];
                if (zzb != null) {
                    zzuo.zze(4, (zzsk) zzb);
                }
                i5++;
            }
        }
        zzc.zzb[] zzbArr3 = this.zzpm;
        if (zzbArr3 != null && zzbArr3.length > 0) {
            int i6 = 0;
            while (true) {
                zzc.zzb[] zzbArr4 = this.zzpm;
                if (i6 >= zzbArr4.length) {
                    break;
                }
                zzc.zzb zzb2 = zzbArr4[i6];
                if (zzb2 != null) {
                    zzuo.zze(5, (zzsk) zzb2);
                }
                i6++;
            }
        }
        zzc.zzb[] zzbArr5 = this.zzpn;
        if (zzbArr5 != null && zzbArr5.length > 0) {
            int i7 = 0;
            while (true) {
                zzc.zzb[] zzbArr6 = this.zzpn;
                if (i7 >= zzbArr6.length) {
                    break;
                }
                zzc.zzb zzb3 = zzbArr6[i7];
                if (zzb3 != null) {
                    zzuo.zze(6, (zzsk) zzb3);
                }
                i7++;
            }
        }
        zzc.zze[] zzeArr = this.zzpo;
        if (zzeArr != null && zzeArr.length > 0) {
            int i8 = 0;
            while (true) {
                zzc.zze[] zzeArr2 = this.zzpo;
                if (i8 >= zzeArr2.length) {
                    break;
                }
                zzc.zze zze = zzeArr2[i8];
                if (zze != null) {
                    zzuo.zze(7, (zzsk) zze);
                }
                i8++;
            }
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzuo.zza(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzuo.zza(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals(RFGDef.DEFAULT_GYM_ID)) {
            zzuo.zza(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzuo.zza(13, this.version);
        }
        zzc.zza zza = this.zzps;
        if (zza != null) {
            zzuo.zze(14, (zzsk) zza);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            float f = this.zzpt;
            zzuo.zzd(15, 5);
            zzuo.zzcc(Float.floatToIntBits(f));
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i9 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i9];
                if (str6 != null) {
                    zzuo.zza(16, str6);
                }
                i9++;
            }
        }
        int i10 = this.zzpw;
        if (i10 != 0) {
            zzuo.zze(17, i10);
        }
        boolean z = this.zzpu;
        if (z) {
            zzuo.zzb(18, z);
        }
        String[] strArr5 = this.zzph;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzph;
                if (i >= strArr6.length) {
                    break;
                }
                String str7 = strArr6[i];
                if (str7 != null) {
                    zzuo.zza(19, str7);
                }
                i++;
            }
        }
        super.zza(zzuo);
    }

    /* access modifiers changed from: protected */
    public final int zzy() {
        int zzy = super.zzy();
        String[] strArr = this.zzpi;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i4++;
                    i3 += zzuo.zzda(str);
                }
                i2++;
            }
            zzy = zzy + i3 + (i4 * 1);
        }
        zzl[] zzlArr = this.zzpj;
        if (zzlArr != null && zzlArr.length > 0) {
            int i5 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpj;
                if (i5 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i5];
                if (zzl != null) {
                    zzy = zzuo.zzb(2, (zzuw) zzl) + zzy;
                }
                i5++;
            }
        }
        zzc.zzd[] zzdArr = this.zzpk;
        if (zzdArr != null && zzdArr.length > 0) {
            int i6 = 0;
            while (true) {
                zzc.zzd[] zzdArr2 = this.zzpk;
                if (i6 >= zzdArr2.length) {
                    break;
                }
                zzc.zzd zzd = zzdArr2[i6];
                if (zzd != null) {
                    zzy = zzqj.zzc(3, (zzsk) zzd) + zzy;
                }
                i6++;
            }
        }
        zzc.zzb[] zzbArr = this.zzpl;
        if (zzbArr != null && zzbArr.length > 0) {
            int i7 = 0;
            while (true) {
                zzc.zzb[] zzbArr2 = this.zzpl;
                if (i7 >= zzbArr2.length) {
                    break;
                }
                zzc.zzb zzb = zzbArr2[i7];
                if (zzb != null) {
                    zzy = zzqj.zzc(4, (zzsk) zzb) + zzy;
                }
                i7++;
            }
        }
        zzc.zzb[] zzbArr3 = this.zzpm;
        if (zzbArr3 != null && zzbArr3.length > 0) {
            int i8 = 0;
            while (true) {
                zzc.zzb[] zzbArr4 = this.zzpm;
                if (i8 >= zzbArr4.length) {
                    break;
                }
                zzc.zzb zzb2 = zzbArr4[i8];
                if (zzb2 != null) {
                    zzy = zzqj.zzc(5, (zzsk) zzb2) + zzy;
                }
                i8++;
            }
        }
        zzc.zzb[] zzbArr5 = this.zzpn;
        if (zzbArr5 != null && zzbArr5.length > 0) {
            int i9 = 0;
            while (true) {
                zzc.zzb[] zzbArr6 = this.zzpn;
                if (i9 >= zzbArr6.length) {
                    break;
                }
                zzc.zzb zzb3 = zzbArr6[i9];
                if (zzb3 != null) {
                    zzy += zzqj.zzc(6, (zzsk) zzb3);
                }
                i9++;
            }
        }
        zzc.zze[] zzeArr = this.zzpo;
        if (zzeArr != null && zzeArr.length > 0) {
            int i10 = 0;
            while (true) {
                zzc.zze[] zzeArr2 = this.zzpo;
                if (i10 >= zzeArr2.length) {
                    break;
                }
                zzc.zze zze = zzeArr2[i10];
                if (zze != null) {
                    zzy += zzqj.zzc(7, (zzsk) zze);
                }
                i10++;
            }
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzy += zzuo.zzb(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzy += zzuo.zzb(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals(RFGDef.DEFAULT_GYM_ID)) {
            zzy += zzuo.zzb(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzy += zzuo.zzb(13, this.version);
        }
        zzc.zza zza = this.zzps;
        if (zza != null) {
            zzy += zzqj.zzc(14, (zzsk) zza);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            zzy += zzuo.zzbb(15) + 4;
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i11 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i11];
                if (str6 != null) {
                    i13++;
                    i12 += zzuo.zzda(str6);
                }
                i11++;
            }
            zzy = zzy + i12 + (i13 * 2);
        }
        int i14 = this.zzpw;
        if (i14 != 0) {
            zzy += zzuo.zzi(17, i14);
        }
        if (this.zzpu) {
            zzy += zzuo.zzbb(18) + 1;
        }
        String[] strArr5 = this.zzph;
        if (strArr5 == null || strArr5.length <= 0) {
            return zzy;
        }
        int i15 = 0;
        int i16 = 0;
        while (true) {
            String[] strArr6 = this.zzph;
            if (i >= strArr6.length) {
                return zzy + i15 + (i16 * 2);
            }
            String str7 = strArr6[i];
            if (str7 != null) {
                i16++;
                i15 = zzuo.zzda(str7) + i15;
            }
            i++;
        }
    }
}
