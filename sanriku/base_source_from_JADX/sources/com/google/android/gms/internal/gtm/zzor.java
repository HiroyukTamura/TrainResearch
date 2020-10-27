package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzg;
import com.google.android.gms.tagmanager.zzdi;
import com.google.android.gms.tagmanager.zzgj;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzor {
    private static zzl zza(int i, zzi zzi, zzl[] zzlArr, Set<Integer> set) throws zzoz {
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            StringBuilder sb = new StringBuilder(valueOf.length() + 90);
            sb.append("Value cycle detected.  Current value reference: ");
            sb.append(i);
            sb.append(".  Previous value references: ");
            sb.append(valueOf);
            sb.append(".");
            zzcf(sb.toString());
        }
        zzl zzl = (zzl) zza(zzi.zzpj, i, "values");
        if (zzlArr[i] != null) {
            return zzlArr[i];
        }
        zzl zzl2 = null;
        set.add(Integer.valueOf(i));
        int i2 = 0;
        switch (zzl.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzl2 = zzl;
                break;
            case 2:
                zzg.zza zzl3 = zzl(zzl);
                zzl zzk = zzk(zzl);
                int[] iArr = zzl3.zzpz;
                zzk.zzqn = new zzl[iArr.length];
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    zzk.zzqn[i3] = zza(iArr[i2], zzi, zzlArr, set);
                    i2++;
                    i3 = i4;
                }
                zzl2 = zzk;
                break;
            case 3:
                zzl2 = zzk(zzl);
                zzg.zza zzl4 = zzl(zzl);
                int[] iArr2 = zzl4.zzqa;
                int length2 = iArr2.length;
                int[] iArr3 = zzl4.zzqb;
                if (length2 != iArr3.length) {
                    int length3 = iArr2.length;
                    int length4 = iArr3.length;
                    StringBuilder sb2 = new StringBuilder(58);
                    sb2.append("Uneven map keys (");
                    sb2.append(length3);
                    sb2.append(") and map values (");
                    sb2.append(length4);
                    sb2.append(")");
                    zzcf(sb2.toString());
                }
                int[] iArr4 = zzl4.zzqa;
                zzl2.zzqo = new zzl[iArr4.length];
                zzl2.zzqp = new zzl[iArr4.length];
                int length5 = iArr4.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length5) {
                    zzl2.zzqo[i6] = zza(iArr4[i5], zzi, zzlArr, set);
                    i5++;
                    i6++;
                }
                int[] iArr5 = zzl4.zzqb;
                int length6 = iArr5.length;
                int i7 = 0;
                while (i2 < length6) {
                    zzl2.zzqp[i7] = zza(iArr5[i2], zzi, zzlArr, set);
                    i2++;
                    i7++;
                }
                break;
            case 4:
                zzl2 = zzk(zzl);
                zzl2.zzqq = zzgj.zzc(zza(zzl(zzl).zzqe, zzi, zzlArr, set));
                break;
            case 7:
                zzl2 = zzk(zzl);
                int[] iArr6 = zzl(zzl).zzqd;
                zzl2.zzqu = new zzl[iArr6.length];
                int length7 = iArr6.length;
                int i8 = 0;
                while (i2 < length7) {
                    zzl2.zzqu[i8] = zza(iArr6[i2], zzi, zzlArr, set);
                    i2++;
                    i8++;
                }
                break;
        }
        if (zzl2 == null) {
            String valueOf2 = String.valueOf(zzl);
            zzcf(C0681a.m312a(valueOf2.length() + 15, "Invalid value: ", valueOf2));
        }
        zzlArr[i] = zzl2;
        set.remove(Integer.valueOf(i));
        return zzl2;
    }

    private static zzot zza(zzc.zzb zzb, zzi zzi, zzl[] zzlArr, int i) throws zzoz {
        zzou zzml = zzot.zzml();
        for (Integer intValue : zzb.zze()) {
            zzc.zzd zzd = (zzc.zzd) zza(zzi.zzpk, intValue.intValue(), "properties");
            String str = (String) zza(zzi.zzpi, zzd.zzl(), "keys");
            zzl zzl = (zzl) zza(zzlArr, zzd.getValue(), "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzml.zzm(zzl);
            } else {
                zzml.zzb(str, zzl);
            }
        }
        return zzml.zzmm();
    }

    public static zzov zza(zzi zzi) throws zzoz {
        zzl[] zzlArr = new zzl[zzi.zzpj.length];
        for (int i = 0; i < zzi.zzpj.length; i++) {
            zza(i, zzi, zzlArr, (Set<Integer>) new HashSet(0));
        }
        zzow zzmn = zzov.zzmn();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            zzc.zzb[] zzbArr = zzi.zzpm;
            if (i2 >= zzbArr.length) {
                break;
            }
            arrayList.add(zza(zzbArr[i2], zzi, zzlArr, i2));
            i2++;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (true) {
            zzc.zzb[] zzbArr2 = zzi.zzpn;
            if (i3 >= zzbArr2.length) {
                break;
            }
            arrayList2.add(zza(zzbArr2[i3], zzi, zzlArr, i3));
            i3++;
        }
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            zzc.zzb[] zzbArr3 = zzi.zzpl;
            if (i4 >= zzbArr3.length) {
                break;
            }
            zzot zza = zza(zzbArr3[i4], zzi, zzlArr, i4);
            zzmn.zzc(zza);
            arrayList3.add(zza);
            i4++;
        }
        for (zzc.zze zze : zzi.zzpo) {
            zzoy zzoy = new zzoy();
            for (Integer intValue : zze.zzn()) {
                zzoy.zzd((zzot) arrayList2.get(intValue.intValue()));
            }
            for (Integer intValue2 : zze.zzo()) {
                zzoy.zze((zzot) arrayList2.get(intValue2.intValue()));
            }
            for (Integer intValue3 : zze.zzp()) {
                zzoy.zzf((zzot) arrayList.get(intValue3.intValue()));
            }
            for (Integer intValue4 : zze.zzr()) {
                zzoy.zzct(zzi.zzpj[intValue4.intValue()].string);
            }
            for (Integer intValue5 : zze.zzq()) {
                zzoy.zzg((zzot) arrayList.get(intValue5.intValue()));
            }
            for (Integer intValue6 : zze.zzs()) {
                zzoy.zzcu(zzi.zzpj[intValue6.intValue()].string);
            }
            for (Integer intValue7 : zze.zzt()) {
                zzoy.zzh((zzot) arrayList3.get(intValue7.intValue()));
            }
            for (Integer intValue8 : zze.zzv()) {
                zzoy.zzcv(zzi.zzpj[intValue8.intValue()].string);
            }
            for (Integer intValue9 : zze.zzu()) {
                zzoy.zzi((zzot) arrayList3.get(intValue9.intValue()));
            }
            for (Integer intValue10 : zze.zzw()) {
                zzoy.zzcw(zzi.zzpj[intValue10.intValue()].string);
            }
            zzmn.zzb(zzoy.zzms());
        }
        zzmn.zzcs(zzi.version);
        zzmn.zzaf(zzi.zzpw);
        return zzmn.zzmp();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzoz {
        if (i < 0 || i >= tArr.length) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 45));
            sb.append("Index out of bounds detected: ");
            sb.append(i);
            sb.append(" in ");
            sb.append(str);
            zzcf(sb.toString());
        }
        return tArr[i];
    }

    public static void zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzcf(String str) throws zzoz {
        zzdi.zzav(str);
        throw new zzoz(str);
    }

    public static zzl zzk(zzl zzl) {
        zzl zzl2 = new zzl();
        zzl2.type = zzl.type;
        zzl2.zzqv = (int[]) zzl.zzqv.clone();
        boolean z = zzl.zzqw;
        if (z) {
            zzl2.zzqw = z;
        }
        return zzl2;
    }

    private static zzg.zza zzl(zzl zzl) throws zzoz {
        if (((zzg.zza) zzl.zza(zzg.zza.zzpx)) == null) {
            String valueOf = String.valueOf(zzl);
            zzcf(C0681a.m312a(valueOf.length() + 54, "Expected a ServingValue and didn't get one. Value is: ", valueOf));
        }
        return (zzg.zza) zzl.zza(zzg.zza.zzpx);
    }
}
