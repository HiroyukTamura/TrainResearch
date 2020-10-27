package com.google.android.gms.internal.fitness;

final class zzgz extends zzgy {
    private zzgz() {
        super();
    }

    private static <E> zzgl<E> zzb(Object obj, long j) {
        return (zzgl) zzja.zzo(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        zzb(obj, j).zzal();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzgl zzb = zzb(obj, j);
        zzgl zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzb.zzak()) {
                zzb = zzb.zzac(size2 + size);
            }
            zzb.addAll(zzb2);
        }
        if (size > 0) {
            zzb2 = zzb;
        }
        zzja.zza(obj, j, (Object) zzb2);
    }
}
