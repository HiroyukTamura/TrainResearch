package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdpa<E> extends zzdos<E> {
    private int zzahb;
    @NullableDecl
    private Object[] zzhfm;

    public zzdpa() {
        super(4);
    }

    zzdpa(int i) {
        super(i);
        this.zzhfm = new Object[zzdpb.zzeh(i)];
    }

    public final /* synthetic */ zzdov zza(Iterator it) {
        zzdoj.checkNotNull(it);
        while (it.hasNext()) {
            zzac(it.next());
        }
        return this;
    }

    public final /* synthetic */ zzdos zzab(Object obj) {
        return (zzdpa) zzac(obj);
    }

    public final /* synthetic */ zzdov zzac(Object obj) {
        zzdoj.checkNotNull(obj);
        if (this.zzhfm != null) {
            int zzeh = zzdpb.zzeh(this.size);
            Object[] objArr = this.zzhfm;
            if (zzeh <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzef = zzdoq.zzef(hashCode);
                while (true) {
                    int i = zzef & length;
                    Object[] objArr2 = this.zzhfm;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzef = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzahb += hashCode;
                        super.zzac(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzhfm = null;
        super.zzac(obj);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.zzdpk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.internal.ads.zzdpb} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.internal.ads.zzdpk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.ads.zzdpk} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdpb<E> zzawc() {
        /*
            r8 = this;
            int r0 = r8.size
            if (r0 == 0) goto L_0x0059
            r1 = 1
            if (r0 == r1) goto L_0x004f
            java.lang.Object[] r2 = r8.zzhfm
            if (r2 == 0) goto L_0x003b
            int r0 = com.google.android.gms.internal.ads.zzdpb.zzeh(r0)
            java.lang.Object[] r2 = r8.zzhfm
            int r2 = r2.length
            if (r0 != r2) goto L_0x003b
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zzhfc
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzdpb.zzv(r0, r2)
            if (r0 == 0) goto L_0x0028
            java.lang.Object[] r0 = r8.zzhfc
            int r2 = r8.size
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x002a
        L_0x0028:
            java.lang.Object[] r0 = r8.zzhfc
        L_0x002a:
            r3 = r0
            com.google.android.gms.internal.ads.zzdpk r0 = new com.google.android.gms.internal.ads.zzdpk
            int r4 = r8.zzahb
            java.lang.Object[] r5 = r8.zzhfm
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.size
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0049
        L_0x003b:
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zzhfc
            com.google.android.gms.internal.ads.zzdpb r0 = com.google.android.gms.internal.ads.zzdpb.zza(r0, r2)
            int r2 = r0.size()
            r8.size = r2
        L_0x0049:
            r8.zzhfd = r1
            r1 = 0
            r8.zzhfm = r1
            return r0
        L_0x004f:
            java.lang.Object[] r0 = r8.zzhfc
            r1 = 0
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzdpb r0 = com.google.android.gms.internal.ads.zzdpb.zzae(r0)
            return r0
        L_0x0059:
            com.google.android.gms.internal.ads.zzdpk<java.lang.Object> r0 = com.google.android.gms.internal.ads.zzdpk.zzhfy
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpa.zzawc():com.google.android.gms.internal.ads.zzdpb");
    }

    public final /* synthetic */ zzdov zzg(Iterable iterable) {
        zzdoj.checkNotNull(iterable);
        if (this.zzhfm != null) {
            for (Object zzac : iterable) {
                zzac(zzac);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }
}
