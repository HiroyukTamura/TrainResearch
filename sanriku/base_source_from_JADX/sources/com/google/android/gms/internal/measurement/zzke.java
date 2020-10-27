package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzke {
    private static final Class<?> zza = zzd();
    private static final zzku<?, ?> zzb = zza(false);
    private static final zzku<?, ?> zzc = zza(true);
    private static final zzku<?, ?> zzd = new zzkw();

    static int zza(int i, Object obj, zzkc zzkc) {
        return obj instanceof zzis ? zzhi.zza(i, (zzis) obj) : zzhi.zzb(i, (zzjj) obj, zzkc);
    }

    static int zza(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            while (i2 < size) {
                Object zzb2 = zziu.zzb(i2);
                zze = (zzb2 instanceof zzgt ? zzhi.zzb((zzgt) zzb2) : zzhi.zzb((String) zzb2)) + zze;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zze = (obj instanceof zzgt ? zzhi.zzb((zzgt) obj) : zzhi.zzb((String) obj)) + zze;
                i2++;
            }
        }
        return zze;
    }

    static int zza(int i, List<?> list, zzkc zzkc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zze = obj instanceof zzis ? zzhi.zza((zzis) obj) + zze : zze + zzhi.zza((zzjj) obj, zzkc);
        }
        return zze;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzhi.zze(i) * list.size()) + zza(list);
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzd(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzku<?, ?> zza() {
        return zzb;
    }

    private static zzku<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzku) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzku<UT, UB> zzku) {
        if (ub == null) {
            ub = zzku.zza();
        }
        zzku.zza(ub, i, (long) i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzif zzif, UB ub, zzku<UT, UB> zzku) {
        if (zzif == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzif.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzku);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzif.zza(intValue2)) {
                    ub = zza(i, intValue2, ub, zzku);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void zza(int i, List<String> list, zzln zzln) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzln zzln, zzkc zzkc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zza(i, list, zzkc);
        }
    }

    public static void zza(int i, List<Double> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzg(i, list, z);
        }
    }

    static <T, FT extends zzht<FT>> void zza(zzhq<FT> zzhq, T t, T t2) {
        zzhr<FT> zza2 = zzhq.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzhq.zzb(t).zza(zza2);
        }
    }

    static <T> void zza(zzjg zzjg, T t, T t2, long j) {
        zzla.zza((Object) t, j, zzjg.zza(zzla.zzf(t, j), zzla.zzf(t2, j)));
    }

    static <T, UT, UB> void zza(zzku<UT, UB> zzku, T t, T t2) {
        zzku.zza((Object) t, zzku.zzc(zzku.zzb(t), zzku.zzb(t2)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzib.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zzb(int i, List<zzgt> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhi.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzjj> list, zzkc zzkc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhi.zzc(i, list.get(i3), zzkc);
        }
        return i2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzb(list);
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zze(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzku<?, ?> zzb() {
        return zzc;
    }

    public static void zzb(int i, List<zzgt> list, zzln zzln) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzb(i, list);
        }
    }

    public static void zzb(int i, List<?> list, zzln zzln, zzkc zzkc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzb(i, list, zzkc);
        }
    }

    public static void zzb(int i, List<Float> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzf(i, list, z);
        }
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzc(list);
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzix = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzix.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzku<?, ?> zzc() {
        return zzd;
    }

    public static void zzc(int i, List<Long> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzc(i, list, z);
        }
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzd(list);
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzic) {
            zzic zzic = (zzic) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzk(zzic.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i, List<Long> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzd(i, list, z);
        }
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zze(list);
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzic) {
            zzic zzic = (zzic) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzic.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i, List<Long> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzn(i, list, z);
        }
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzf(list);
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzic) {
            zzic zzic = (zzic) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzg(zzic.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzf(int i, List<Long> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zze(i, list, z);
        }
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzhi.zze(i) * size) + zzg(list);
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzic) {
            zzic zzic = (zzic) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzh(zzic.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhi.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzg(int i, List<Long> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzl(i, list, z);
        }
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzi(i, 0) * size;
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static void zzh(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zza(i, list, z);
        }
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzg(i, 0) * size;
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static void zzi(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzj(i, list, z);
        }
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzhi.zzb(i, true) * size;
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzj(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzln zzln, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzln.zzi(i, list, z);
        }
    }
}
