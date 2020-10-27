package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzjp<T> implements zzkc<T> {
    private final zzjj zza;
    private final zzku<?, ?> zzb;
    private final boolean zzc;
    private final zzhq<?> zzd;

    private zzjp(zzku<?, ?> zzku, zzhq<?> zzhq, zzjj zzjj) {
        this.zzb = zzku;
        this.zzc = zzhq.zza(zzjj);
        this.zzd = zzhq;
        this.zza = zzjj;
    }

    static <T> zzjp<T> zza(zzku<?, ?> zzku, zzhq<?> zzhq, zzjj zzjj) {
        return new zzjp<>(zzku, zzhq, zzjj);
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final T zza() {
        return this.zza.zzbr().zzu();
    }

    public final void zza(T t, zzjz zzjz, zzho zzho) throws IOException {
        boolean z;
        zzku<?, ?> zzku = this.zzb;
        zzhq<?> zzhq = this.zzd;
        Object zzc2 = zzku.zzc(t);
        zzhr<?> zzb2 = zzhq.zzb(t);
        do {
            try {
                if (zzjz.zza() == Integer.MAX_VALUE) {
                    zzku.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzjz.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgt zzgt = null;
                    while (zzjz.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjz.zzb();
                        if (zzb4 == 16) {
                            i = zzjz.zzo();
                            obj = zzhq.zza(zzho, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhq.zza(zzjz, obj, zzho, zzb2);
                            } else {
                                zzgt = zzjz.zzn();
                            }
                        } else if (!zzjz.zzc()) {
                            break;
                        }
                    }
                    if (zzjz.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgt != null) {
                        if (obj != null) {
                            zzhq.zza(zzgt, obj, zzho, zzb2);
                        } else {
                            zzku.zza(zzc2, i, zzgt);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhq.zza(zzho, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhq.zza(zzjz, zza2, zzho, zzb2);
                    } else {
                        z = zzku.zza(zzc2, zzjz);
                        continue;
                    }
                } else {
                    z = zzjz.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzku.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zza(T t, zzln zzln) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzht zzht = (zzht) next.getKey();
            if (zzht.zzc() != zzlo.MESSAGE || zzht.zzd() || zzht.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzln.zza(zzht.zza(), next instanceof zziq ? ((zziq) next).zza().zzc() : next.getValue());
        }
        zzku<?, ?> zzku = this.zzb;
        zzku.zzb(zzku.zzb(t), zzln);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzib$zzd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzgo r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0
            com.google.android.gms.internal.measurement.zzkt r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzkt r2 = com.google.android.gms.internal.measurement.zzkt.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzkt r1 = com.google.android.gms.internal.measurement.zzkt.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzib$zzb r10 = (com.google.android.gms.internal.measurement.zzib.zzb) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzhq<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzho r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzib$zzd r0 = (com.google.android.gms.internal.measurement.zzib.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzgp.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzkt) r6, (com.google.android.gms.internal.measurement.zzgo) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzjy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzgp.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgp.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzgt r2 = (com.google.android.gms.internal.measurement.zzgt) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzjy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzhq<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzho r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzib$zzd r0 = (com.google.android.gms.internal.measurement.zzib.zzd) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgp.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgo) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzij r10 = com.google.android.gms.internal.measurement.zzij.zzg()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zzb(T t) {
        zzku<?, ?> zzku = this.zzb;
        int zze = zzku.zze(zzku.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }

    public final void zzb(T t, T t2) {
        zzke.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzke.zza(this.zzd, t, t2);
        }
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }
}
