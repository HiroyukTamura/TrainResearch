package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdsu<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzhix;
    private ConcurrentMap<String, List<zzdst<P>>> zzhji = new ConcurrentHashMap();
    private zzdst<P> zzhjj;

    private zzdsu(Class<P> cls) {
        this.zzhix = cls;
    }

    public static <P> zzdsu<P> zza(Class<P> cls) {
        return new zzdsu<>(cls);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdst<P> zza(P r9, com.google.android.gms.internal.ads.zzdxp.zza r10) throws java.security.GeneralSecurityException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdxj r0 = r10.zzaxe()
            com.google.android.gms.internal.ads.zzdxj r1 = com.google.android.gms.internal.ads.zzdxj.ENABLED
            if (r0 != r1) goto L_0x0094
            com.google.android.gms.internal.ads.zzdst r0 = new com.google.android.gms.internal.ads.zzdst
            int[] r1 = com.google.android.gms.internal.ads.zzdsg.zzhiu
            com.google.android.gms.internal.ads.zzdyb r2 = r10.zzaxf()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 5
            r3 = 1
            if (r1 == r3) goto L_0x0037
            r4 = 2
            if (r1 == r4) goto L_0x0037
            r4 = 3
            if (r1 == r4) goto L_0x002e
            r2 = 4
            if (r1 != r2) goto L_0x0026
            byte[] r1 = com.google.android.gms.internal.ads.zzdsd.zzhit
            goto L_0x004c
        L_0x0026:
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException
            java.lang.String r10 = "unknown output prefix type"
            r9.<init>(r10)
            throw r9
        L_0x002e:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteBuffer r1 = r1.put(r3)
            goto L_0x0040
        L_0x0037:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            r2 = 0
            java.nio.ByteBuffer r1 = r1.put(r2)
        L_0x0040:
            int r2 = r10.zzbaw()
            java.nio.ByteBuffer r1 = r1.putInt(r2)
            byte[] r1 = r1.array()
        L_0x004c:
            r4 = r1
            com.google.android.gms.internal.ads.zzdxj r5 = r10.zzaxe()
            com.google.android.gms.internal.ads.zzdyb r6 = r10.zzaxf()
            int r7 = r10.zzbaw()
            r2 = r0
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r9.add(r0)
            java.lang.String r10 = new java.lang.String
            byte[] r1 = r0.zzaxg()
            java.nio.charset.Charset r2 = UTF_8
            r10.<init>(r1, r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdst<P>>> r1 = r8.zzhji
            java.util.List r9 = java.util.Collections.unmodifiableList(r9)
            java.lang.Object r9 = r1.put(r10, r9)
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x0093
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.addAll(r9)
            r1.add(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzdst<P>>> r9 = r8.zzhji
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r9.put(r10, r1)
        L_0x0093:
            return r0
        L_0x0094:
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException
            java.lang.String r10 = "only ENABLED key is allowed"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsu.zza(java.lang.Object, com.google.android.gms.internal.ads.zzdxp$zza):com.google.android.gms.internal.ads.zzdst");
    }

    public final void zza(zzdst<P> zzdst) {
        if (zzdst == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzdst.zzaxe() == zzdxj.ENABLED) {
            List list = (List) this.zzhji.get(new String(zzdst.zzaxg(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzhjj = zzdst;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final Class<P> zzawu() {
        return this.zzhix;
    }

    public final zzdst<P> zzaxh() {
        return this.zzhjj;
    }
}
