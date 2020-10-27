package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.List;

final class zzie {
    private static final Class<?> zzyq = zzcy();
    private static final zziu<?, ?> zzyr = zzd(false);
    private static final zziu<?, ?> zzys = zzd(true);
    private static final zziu<?, ?> zzyt = new zziw();

    public static void zza(int i, List<String> list, zzjo zzjo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzjo zzjo, zzic zzic) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list, zzic);
        }
    }

    public static void zza(int i, List<Double> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzg(i, list, z);
        }
    }

    static <T, FT extends zzgd<FT>> void zza(zzfw<FT> zzfw, T t, T t2) {
        zzgb<FT> zza = zzfw.zza((Object) t2);
        if (!zza.zzsj.isEmpty()) {
            zzfw.zzb(t).zza(zza);
        }
    }

    static <T> void zza(zzhh zzhh, T t, T t2, long j) {
        zzja.zza((Object) t, j, zzhh.zzc(zzja.zzo(t, j), zzja.zzo(t2, j)));
    }

    static <T, UT, UB> void zza(zziu<UT, UB> zziu, T t, T t2) {
        zziu.zzf(t, zziu.zzg(zziu.zzm(t), zziu.zzm(t2)));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzd(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzb(int i, List<zzff> list, zzjo zzjo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list);
        }
    }

    public static void zzb(int i, List<?> list, zzjo zzjo, zzic zzic) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list, zzic);
        }
    }

    public static void zzb(int i, List<Float> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzf(i, list, z);
        }
    }

    static int zzc(int i, Object obj, zzic zzic) {
        return obj instanceof zzgt ? zzfs.zza(i, (zzgt) obj) : zzfs.zzb(i, (zzho) obj, zzic);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzp = zzfs.zzp(i) * size;
        if (list instanceof zzgv) {
            zzgv zzgv = (zzgv) list;
            while (i2 < size) {
                Object zzad = zzgv.zzad(i2);
                zzp = (zzad instanceof zzff ? zzfs.zzb((zzff) zzad) : zzfs.zzn((String) zzad)) + zzp;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzp = (obj instanceof zzff ? zzfs.zzb((zzff) obj) : zzfs.zzn((String) obj)) + zzp;
                i2++;
            }
        }
        return zzp;
    }

    static int zzc(int i, List<?> list, zzic zzic) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzp = zzfs.zzp(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzp = obj instanceof zzgt ? zzfs.zza((zzgt) obj) + zzp : zzp + zzfs.zza((zzho) obj, zzic);
        }
        return zzp;
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zze(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzc(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzc(i, list, z);
        }
    }

    public static zziu<?, ?> zzcv() {
        return zzyr;
    }

    public static zziu<?, ?> zzcw() {
        return zzys;
    }

    public static zziu<?, ?> zzcx() {
        return zzyt;
    }

    private static Class<?> zzcy() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzcz() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static int zzd(int i, List<zzff> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzp = zzfs.zzp(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzp += zzfs.zzb(list.get(i2));
        }
        return zzp;
    }

    static int zzd(int i, List<zzho> list, zzic zzic) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfs.zzc(i, list.get(i3), zzic);
        }
        return i2;
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhc) {
            zzhc zzhc = (zzhc) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzf(zzhc.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    private static zziu<?, ?> zzd(boolean z) {
        try {
            Class<?> zzcz = zzcz();
            if (zzcz == null) {
                return null;
            }
            return (zziu) zzcz.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzd(i, list, z);
        }
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzv(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zze(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzn(i, list, z);
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzq(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzq(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzf(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zze(i, list, z);
        }
    }

    public static void zzf(Class<?> cls) {
        Class<?> cls2;
        if (!zzgg.class.isAssignableFrom(cls) && (cls2 = zzyq) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzr(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzr(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzg(int i, List<Long> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzl(i, list, z);
        }
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            i = 0;
            while (i2 < size) {
                i += zzfs.zzs(zzgi.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfs.zzs(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzh(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zza(i, list, z);
        }
    }

    static int zzi(List<?> list) {
        return list.size() << 2;
    }

    public static void zzi(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzj(i, list, z);
        }
    }

    static int zzj(List<?> list) {
        return list.size() << 3;
    }

    public static void zzj(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzm(i, list, z);
        }
    }

    static int zzk(List<?> list) {
        return list.size();
    }

    public static void zzk(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjo zzjo, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjo.zzi(i, list, z);
        }
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * list.size()) + zzb(list);
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zzc(list);
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zzd(list);
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zze(list);
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zzf(list);
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zzg(list);
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfs.zzp(i) * size) + zzh(list);
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfs.zzj(i, 0) * size;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfs.zzg(i, 0) * size;
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfs.zzb(i, true) * size;
    }
}
