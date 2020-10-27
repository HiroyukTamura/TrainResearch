package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

final class zzeda extends zzecy {
    private static final Class<?> zzhzq = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzeda() {
        super();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzecw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.ads.zzecw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.ads.zzecw} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzd(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzecv
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzecw r0 = new com.google.android.gms.internal.ads.zzecw
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzeea
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzecl
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzecl r0 = (com.google.android.gms.internal.ads.zzecl) r0
            com.google.android.gms.internal.ads.zzecl r6 = r0.zzfn(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007a
        L_0x002d:
            java.lang.Class<?> r1 = zzhzq
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
        L_0x0046:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            r0 = r1
            goto L_0x007a
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzefd
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.ads.zzecw r1 = new com.google.android.gms.internal.ads.zzecw
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.ads.zzefd r0 = (com.google.android.gms.internal.ads.zzefd) r0
            r1.addAll(r0)
            goto L_0x0046
        L_0x005f:
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzeea
            if (r1 == 0) goto L_0x007a
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzecl
            if (r1 == 0) goto L_0x007a
            r1 = r0
            com.google.android.gms.internal.ads.zzecl r1 = (com.google.android.gms.internal.ads.zzecl) r1
            boolean r2 = r1.zzbci()
            if (r2 != 0) goto L_0x007a
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.ads.zzecl r0 = r1.zzfn(r0)
            goto L_0x0029
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeda.zza(java.lang.Object, long, int):java.util.List");
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzefi.zzp(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzefi.zza(obj, j, (Object) zzd);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzefi.zzp(obj, j);
        if (list instanceof zzecv) {
            obj2 = ((zzecv) list).zzbft();
        } else if (!zzhzq.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzeea) || !(list instanceof zzecl)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzecl zzecl = (zzecl) list;
                if (zzecl.zzbci()) {
                    zzecl.zzbcj();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzefi.zza(obj, j, obj2);
    }
}
