package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.List;

final class zzha extends zzgy {
    private static final Class<?> zzxb = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzha() {
        super();
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzja.zzo(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzja.zzo(obj, j);
        if (list instanceof zzgv) {
            obj2 = ((zzgv) list).zzby();
        } else if (!zzxb.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhx) || !(list instanceof zzgl)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzgl zzgl = (zzgl) list;
                if (zzgl.zzak()) {
                    zzgl.zzal();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzja.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.fitness.zzgw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.fitness.zzgw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.fitness.zzgw} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void zza(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.util.List r6 = zzc(r6, r7)
            int r0 = r6.size()
            java.util.List r1 = zzc(r5, r7)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zzgv
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.fitness.zzgw r1 = new com.google.android.gms.internal.fitness.zzgw
            r1.<init>((int) r0)
            goto L_0x0031
        L_0x001c:
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zzhx
            if (r2 == 0) goto L_0x002c
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zzgl
            if (r2 == 0) goto L_0x002c
            com.google.android.gms.internal.fitness.zzgl r1 = (com.google.android.gms.internal.fitness.zzgl) r1
            com.google.android.gms.internal.fitness.zzgl r0 = r1.zzac(r0)
            r1 = r0
            goto L_0x0031
        L_0x002c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0031:
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r1)
            goto L_0x0082
        L_0x0035:
            java.lang.Class<?> r2 = zzxb
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0053
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
        L_0x004e:
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
            r1 = r2
            goto L_0x0082
        L_0x0053:
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zziv
            if (r2 == 0) goto L_0x0067
            com.google.android.gms.internal.fitness.zzgw r2 = new com.google.android.gms.internal.fitness.zzgw
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.fitness.zziv r1 = (com.google.android.gms.internal.fitness.zziv) r1
            r2.addAll(r1)
            goto L_0x004e
        L_0x0067:
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zzhx
            if (r2 == 0) goto L_0x0082
            boolean r2 = r1 instanceof com.google.android.gms.internal.fitness.zzgl
            if (r2 == 0) goto L_0x0082
            r2 = r1
            com.google.android.gms.internal.fitness.zzgl r2 = (com.google.android.gms.internal.fitness.zzgl) r2
            boolean r3 = r2.zzak()
            if (r3 != 0) goto L_0x0082
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.fitness.zzgl r1 = r2.zzac(r1)
            goto L_0x0031
        L_0x0082:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0091
            if (r2 <= 0) goto L_0x0091
            r1.addAll(r6)
        L_0x0091:
            if (r0 <= 0) goto L_0x0094
            r6 = r1
        L_0x0094:
            com.google.android.gms.internal.fitness.zzja.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzha.zza(java.lang.Object, java.lang.Object, long):void");
    }
}
