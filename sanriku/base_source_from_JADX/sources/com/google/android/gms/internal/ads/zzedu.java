package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzedu<T> implements zzeek<T> {
    private final zzedo zziah;
    private final boolean zziai;
    private final zzefc<?, ?> zziar;
    private final zzebs<?> zzias;

    private zzedu(zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedo zzedo) {
        this.zziar = zzefc;
        this.zziai = zzebs.zzj(zzedo);
        this.zzias = zzebs;
        this.zziah = zzedo;
    }

    static <T> zzedu<T> zza(zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedo zzedo) {
        return new zzedu<>(zzefc, zzebs, zzedo);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zziar.zzay(t).equals(this.zziar.zzay(t2))) {
            return false;
        }
        if (this.zziai) {
            return this.zzias.zzai(t).equals(this.zzias.zzai(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zziar.zzay(t).hashCode();
        return this.zziai ? (hashCode * 53) + this.zzias.zzai(t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zziah.zzbfc().zzbes();
    }

    public final void zza(T t, zzeee zzeee, zzebq zzebq) throws IOException {
        boolean z;
        zzefc<?, ?> zzefc = this.zziar;
        zzebs<?> zzebs = this.zzias;
        Object zzaz = zzefc.zzaz(t);
        zzebt<?> zzaj = zzebs.zzaj(t);
        do {
            try {
                if (zzeee.zzbdw() == Integer.MAX_VALUE) {
                    zzefc.zzi(t, zzaz);
                    return;
                }
                int tag = zzeee.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeaq zzeaq = null;
                    while (zzeee.zzbdw() != Integer.MAX_VALUE) {
                        int tag2 = zzeee.getTag();
                        if (tag2 == 16) {
                            i = zzeee.zzbdh();
                            obj = zzebs.zza(zzebq, this.zziah, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzebs.zza(zzeee, obj, zzebq, zzaj);
                            } else {
                                zzeaq = zzeee.zzbdg();
                            }
                        } else if (!zzeee.zzbdx()) {
                            break;
                        }
                    }
                    if (zzeee.getTag() != 12) {
                        throw zzeco.zzbfk();
                    } else if (zzeaq != null) {
                        if (obj != null) {
                            zzebs.zza(zzeaq, obj, zzebq, zzaj);
                        } else {
                            zzefc.zza(zzaz, i, zzeaq);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzebs.zza(zzebq, this.zziah, tag >>> 3);
                    if (zza != null) {
                        zzebs.zza(zzeee, zza, zzebq, zzaj);
                    } else {
                        z = zzefc.zza(zzaz, zzeee);
                        continue;
                    }
                } else {
                    z = zzeee.zzbdx();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzefc.zzi(t, zzaz);
            }
        } while (z);
    }

    public final void zza(T t, zzefv zzefv) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzias.zzai(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzebv zzebv = (zzebv) next.getKey();
            if (zzebv.zzbek() != zzefw.MESSAGE || zzebv.zzbel() || zzebv.zzbem()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzefv.zzc(zzebv.zzw(), next instanceof zzecr ? ((zzecr) next).zzbfr().zzbce() : next.getValue());
        }
        zzefc<?, ?> zzefc = this.zziar;
        zzefc.zzc(zzefc.zzay(t), zzefv);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzecd$zzd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.zzeap r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzecd r0 = (com.google.android.gms.internal.ads.zzecd) r0
            com.google.android.gms.internal.ads.zzefb r1 = r0.zzhxv
            com.google.android.gms.internal.ads.zzefb r2 = com.google.android.gms.internal.ads.zzefb.zzbhd()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.ads.zzefb r1 = com.google.android.gms.internal.ads.zzefb.zzbhe()
            r0.zzhxv = r1
        L_0x0011:
            com.google.android.gms.internal.ads.zzecd$zzb r10 = (com.google.android.gms.internal.ads.zzecd.zzb) r10
            r10.zzbfd()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r11, r12, r14)
            int r2 = r14.zzhtb
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.ads.zzebs<?> r12 = r9.zzias
            com.google.android.gms.internal.ads.zzebq r0 = r14.zzhte
            com.google.android.gms.internal.ads.zzedo r3 = r9.zziah
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzecd$zzd r0 = (com.google.android.gms.internal.ads.zzecd.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.zzeam.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzefb) r6, (com.google.android.gms.internal.ads.zzeap) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.ads.zzedz.zzbgk()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.ads.zzeam.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.ads.zzeap) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r11, r4, r14)
            int r5 = r14.zzhtb
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.zzeam.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzhtd
            com.google.android.gms.internal.ads.zzeaq r2 = (com.google.android.gms.internal.ads.zzeaq) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.ads.zzedz.zzbgk()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r11, r4, r14)
            int r12 = r14.zzhtb
            com.google.android.gms.internal.ads.zzebs<?> r0 = r9.zzias
            com.google.android.gms.internal.ads.zzebq r5 = r14.zzhte
            com.google.android.gms.internal.ads.zzedo r6 = r9.zziah
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.ads.zzecd$zzd r0 = (com.google.android.gms.internal.ads.zzecd.zzd) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.zzeam.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.ads.zzeap) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzd(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzeco r10 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedu.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeap):void");
    }

    public final void zzak(T t) {
        this.zziar.zzak(t);
        this.zzias.zzak(t);
    }

    public final int zzau(T t) {
        zzefc<?, ?> zzefc = this.zziar;
        int zzba = zzefc.zzba(zzefc.zzay(t)) + 0;
        return this.zziai ? zzba + this.zzias.zzai(t).zzbef() : zzba;
    }

    public final boolean zzaw(T t) {
        return this.zzias.zzai(t).isInitialized();
    }

    public final void zzf(T t, T t2) {
        zzeem.zza(this.zziar, t, t2);
        if (this.zziai) {
            zzeem.zza(this.zzias, t, t2);
        }
    }
}
