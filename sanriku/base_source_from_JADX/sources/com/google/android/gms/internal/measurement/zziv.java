package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

final class zziv extends zzit {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziv() {
        super();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzc(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zziu
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.measurement.zzir r0 = new com.google.android.gms.internal.measurement.zzir
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjv
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzik
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.measurement.zzik r0 = (com.google.android.gms.internal.measurement.zzik) r0
            com.google.android.gms.internal.measurement.zzik r6 = r0.zza(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007a
        L_0x002d:
            java.lang.Class<?> r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
        L_0x0046:
            com.google.android.gms.internal.measurement.zzla.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            r0 = r1
            goto L_0x007a
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzkv
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.measurement.zzir r1 = new com.google.android.gms.internal.measurement.zzir
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.measurement.zzkv r0 = (com.google.android.gms.internal.measurement.zzkv) r0
            r1.addAll(r0)
            goto L_0x0046
        L_0x005f:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjv
            if (r1 == 0) goto L_0x007a
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzik
            if (r1 == 0) goto L_0x007a
            r1 = r0
            com.google.android.gms.internal.measurement.zzik r1 = (com.google.android.gms.internal.measurement.zzik) r1
            boolean r2 = r1.zza()
            if (r2 != 0) goto L_0x007a
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.measurement.zzik r0 = r1.zza(r0)
            goto L_0x0029
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziv.zza(java.lang.Object, long, int):java.util.List");
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzla.zzf(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzla.zza(obj, j, (Object) zzc);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzla.zzf(obj, j);
        if (list instanceof zziu) {
            obj2 = ((zziu) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzjv) || !(list instanceof zzik)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzik zzik = (zzik) list;
                if (zzik.zza()) {
                    zzik.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzla.zza(obj, j, obj2);
    }
}
