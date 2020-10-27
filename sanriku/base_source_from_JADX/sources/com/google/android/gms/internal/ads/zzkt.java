package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.jvm.internal.LongCompanionObject;

public final class zzkt implements zzjm, zzjr {
    private static final zzjn zzaon = new zzkw();
    private static final int zzawo = zzov.zzbj("qt  ");
    private long zzaht;
    private final zzos zzaou = new zzos(zzon.zzbhb);
    private final zzos zzaov = new zzos(4);
    private int zzaqj;
    private int zzaqk;
    private zzjo zzaqn;
    private final zzos zzawp = new zzos(16);
    private final Stack<zzkh> zzawq = new Stack<>();
    private int zzawr;
    private int zzaws;
    private long zzawt;
    private int zzawu;
    private zzos zzawv;
    private zzkv[] zzaww;
    private boolean zzawx;

    private final void zzeb(long j) throws zzhi {
        zzln zzln;
        zzjq zzjq;
        zzkx zza;
        while (!this.zzawq.isEmpty() && this.zzawq.peek().zzarx == j) {
            zzkh pop = this.zzawq.pop();
            if (pop.type == zzki.zzatb) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j3 = LongCompanionObject.MAX_VALUE;
                zzln zzln2 = null;
                zzjq zzjq2 = new zzjq();
                zzkk zzan = pop.zzan(zzki.zzava);
                if (!(zzan == null || (zzln2 = zzkj.zza(zzan, this.zzawx)) == null)) {
                    zzjq2.zzb(zzln2);
                }
                int i = 0;
                while (i < pop.zzarz.size()) {
                    zzkh zzkh = pop.zzarz.get(i);
                    if (zzkh.type == zzki.zzatd && (zza = zzkj.zza(zzkh, pop.zzan(zzki.zzatc), -9223372036854775807L, (zzja) null, this.zzawx)) != null) {
                        zzkz zza2 = zzkj.zza(zza, zzkh.zzao(zzki.zzate).zzao(zzki.zzatf).zzao(zzki.zzatg), zzjq2);
                        if (zza2.zzawf != 0) {
                            zzkv zzkv = new zzkv(zza, zza2, this.zzaqn.zzc(i, zza.type));
                            zzhf zzr = zza.zzahd.zzr(zza2.zzawl + 30);
                            if (zza.type == 1) {
                                if (zzjq2.zzgs()) {
                                    zzr = zzr.zzb(zzjq2.zzagv, zzjq2.zzagw);
                                }
                                if (zzln2 != null) {
                                    zzr = zzr.zza(zzln2);
                                }
                            }
                            zzkv.zzaye.zze(zzr);
                            zzln = zzln2;
                            zzjq = zzjq2;
                            j2 = Math.max(j2, zza.zzaht);
                            arrayList.add(zzkv);
                            long j4 = zza2.zzany[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzjq2 = zzjq;
                            zzln2 = zzln;
                        }
                    }
                    zzln = zzln2;
                    zzjq = zzjq2;
                    i++;
                    zzjq2 = zzjq;
                    zzln2 = zzln;
                }
                this.zzaht = j2;
                this.zzaww = (zzkv[]) arrayList.toArray(new zzkv[arrayList.size()]);
                this.zzaqn.zzgr();
                this.zzaqn.zza(this);
                this.zzawq.clear();
                this.zzawr = 2;
            } else if (!this.zzawq.isEmpty()) {
                this.zzawq.peek().zzarz.add(pop);
            }
        }
        if (this.zzawr != 2) {
            zzha();
        }
    }

    private final void zzha() {
        this.zzawr = 0;
        this.zzawu = 0;
    }

    public final long getDurationUs() {
        return this.zzaht;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void release() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x018e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0299 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjl r24, com.google.android.gms.internal.ads.zzjs r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
        L_0x0006:
            int r3 = r0.zzawr
            r4 = -1
            r5 = 8
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x018f
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x010d
            if (r3 != r10) goto L_0x0107
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x001e:
            com.google.android.gms.internal.ads.zzkv[] r14 = r0.zzaww
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003a
            r14 = r14[r3]
            int r15 = r14.zzawj
            com.google.android.gms.internal.ads.zzkz r14 = r14.zzayd
            int r11 = r14.zzawf
            if (r15 == r11) goto L_0x0037
            long[] r11 = r14.zzany
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0037
            r5 = r3
            r12 = r14
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x003a:
            if (r5 != r4) goto L_0x003d
            return r4
        L_0x003d:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zzjt r4 = r3.zzaye
            int r5 = r3.zzawj
            com.google.android.gms.internal.ads.zzkz r11 = r3.zzayd
            long[] r12 = r11.zzany
            r13 = r12[r5]
            int[] r11 = r11.zzanx
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzkx r12 = r3.zzayc
            int r12 = r12.zzayg
            if (r12 != r6) goto L_0x0059
            r16 = 8
            long r13 = r13 + r16
            int r11 = r11 + -8
        L_0x0059:
            long r16 = r24.getPosition()
            long r16 = r13 - r16
            int r12 = r0.zzaqk
            r18 = r11
            long r10 = (long) r12
            long r10 = r16 + r10
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 < 0) goto L_0x0104
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 < 0) goto L_0x0072
            goto L_0x0104
        L_0x0072:
            int r2 = (int) r10
            r1.zzae(r2)
            com.google.android.gms.internal.ads.zzkx r2 = r3.zzayc
            int r2 = r2.zzart
            if (r2 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzos r8 = r0.zzaov
            byte[] r8 = r8.data
            r8[r7] = r7
            r8[r6] = r7
            r9 = 2
            r8[r9] = r7
            r8 = 4
            int r11 = 4 - r2
            r8 = r18
        L_0x008c:
            int r9 = r0.zzaqk
            if (r9 >= r8) goto L_0x00c9
            int r9 = r0.zzaqj
            if (r9 != 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzos r9 = r0.zzaov
            byte[] r9 = r9.data
            r1.readFully(r9, r11, r2)
            com.google.android.gms.internal.ads.zzos r9 = r0.zzaov
            r9.zzbi(r7)
            com.google.android.gms.internal.ads.zzos r9 = r0.zzaov
            int r9 = r9.zzje()
            r0.zzaqj = r9
            com.google.android.gms.internal.ads.zzos r9 = r0.zzaou
            r9.zzbi(r7)
            com.google.android.gms.internal.ads.zzos r9 = r0.zzaou
            r10 = 4
            r4.zza(r9, r10)
            int r9 = r0.zzaqk
            int r9 = r9 + r10
            r0.zzaqk = r9
            int r8 = r8 + r11
            goto L_0x008c
        L_0x00ba:
            int r9 = r4.zza(r1, r9, r7)
            int r10 = r0.zzaqk
            int r10 = r10 + r9
            r0.zzaqk = r10
            int r10 = r0.zzaqj
            int r10 = r10 - r9
            r0.zzaqj = r10
            goto L_0x008c
        L_0x00c9:
            r20 = r8
            goto L_0x00e7
        L_0x00cc:
            int r2 = r0.zzaqk
            r11 = r18
            if (r2 >= r11) goto L_0x00e5
            int r2 = r11 - r2
            int r2 = r4.zza(r1, r2, r7)
            int r8 = r0.zzaqk
            int r8 = r8 + r2
            r0.zzaqk = r8
            int r8 = r0.zzaqj
            int r8 = r8 - r2
            r0.zzaqj = r8
            r18 = r11
            goto L_0x00cc
        L_0x00e5:
            r20 = r11
        L_0x00e7:
            com.google.android.gms.internal.ads.zzkz r1 = r3.zzayd
            long[] r2 = r1.zzayl
            r17 = r2[r5]
            int[] r1 = r1.zzawn
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzawj
            int r1 = r1 + r6
            r3.zzawj = r1
            r0.zzaqk = r7
            r0.zzaqj = r7
            return r7
        L_0x0104:
            r2.position = r13
            return r6
        L_0x0107:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x010d:
            long r3 = r0.zzawt
            int r10 = r0.zzawu
            long r10 = (long) r10
            long r3 = r3 - r10
            long r10 = r24.getPosition()
            long r10 = r10 + r3
            com.google.android.gms.internal.ads.zzos r12 = r0.zzawv
            if (r12 == 0) goto L_0x016f
            byte[] r8 = r12.data
            int r9 = r0.zzawu
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.zzaws
            int r4 = com.google.android.gms.internal.ads.zzki.zzasa
            if (r3 != r4) goto L_0x0150
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawv
            r3.zzbi(r5)
            int r4 = r3.readInt()
            int r5 = zzawo
            if (r4 != r5) goto L_0x0139
        L_0x0137:
            r3 = 1
            goto L_0x014d
        L_0x0139:
            r4 = 4
            r3.zzbj(r4)
        L_0x013d:
            int r4 = r3.zziz()
            if (r4 <= 0) goto L_0x014c
            int r4 = r3.readInt()
            int r5 = zzawo
            if (r4 != r5) goto L_0x013d
            goto L_0x0137
        L_0x014c:
            r3 = 0
        L_0x014d:
            r0.zzawx = r3
            goto L_0x0177
        L_0x0150:
            java.util.Stack<com.google.android.gms.internal.ads.zzkh> r3 = r0.zzawq
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0177
            java.util.Stack<com.google.android.gms.internal.ads.zzkh> r3 = r0.zzawq
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzkh r3 = (com.google.android.gms.internal.ads.zzkh) r3
            com.google.android.gms.internal.ads.zzkk r4 = new com.google.android.gms.internal.ads.zzkk
            int r5 = r0.zzaws
            com.google.android.gms.internal.ads.zzos r8 = r0.zzawv
            r4.<init>(r5, r8)
            java.util.List<com.google.android.gms.internal.ads.zzkk> r3 = r3.zzary
            r3.add(r4)
            goto L_0x0177
        L_0x016f:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0179
            int r4 = (int) r3
            r1.zzae(r4)
        L_0x0177:
            r3 = 0
            goto L_0x0181
        L_0x0179:
            long r8 = r24.getPosition()
            long r8 = r8 + r3
            r2.position = r8
            r3 = 1
        L_0x0181:
            r0.zzeb(r10)
            if (r3 == 0) goto L_0x018c
            int r3 = r0.zzawr
            r4 = 2
            if (r3 == r4) goto L_0x018c
            r7 = 1
        L_0x018c:
            if (r7 == 0) goto L_0x0006
            return r6
        L_0x018f:
            int r3 = r0.zzawu
            if (r3 != 0) goto L_0x01b7
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            byte[] r3 = r3.data
            boolean r3 = r1.zza(r3, r7, r5, r6)
            if (r3 != 0) goto L_0x01a0
            r6 = 0
            goto L_0x0297
        L_0x01a0:
            r0.zzawu = r5
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            r3.zzbi(r7)
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            long r8 = r3.zzjb()
            r0.zzawt = r8
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            int r3 = r3.readInt()
            r0.zzaws = r3
        L_0x01b7:
            long r8 = r0.zzawt
            r10 = 1
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x01d3
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            byte[] r3 = r3.data
            r1.readFully(r3, r5, r5)
            int r3 = r0.zzawu
            int r3 = r3 + r5
            r0.zzawu = r3
            com.google.android.gms.internal.ads.zzos r3 = r0.zzawp
            long r8 = r3.zzjf()
            r0.zzawt = r8
        L_0x01d3:
            int r3 = r0.zzaws
            int r8 = com.google.android.gms.internal.ads.zzki.zzatb
            if (r3 == r8) goto L_0x01f0
            int r8 = com.google.android.gms.internal.ads.zzki.zzatd
            if (r3 == r8) goto L_0x01f0
            int r8 = com.google.android.gms.internal.ads.zzki.zzate
            if (r3 == r8) goto L_0x01f0
            int r8 = com.google.android.gms.internal.ads.zzki.zzatf
            if (r3 == r8) goto L_0x01f0
            int r8 = com.google.android.gms.internal.ads.zzki.zzatg
            if (r3 == r8) goto L_0x01f0
            int r8 = com.google.android.gms.internal.ads.zzki.zzatp
            if (r3 != r8) goto L_0x01ee
            goto L_0x01f0
        L_0x01ee:
            r3 = 0
            goto L_0x01f1
        L_0x01f0:
            r3 = 1
        L_0x01f1:
            if (r3 == 0) goto L_0x021d
            long r7 = r24.getPosition()
            long r9 = r0.zzawt
            long r7 = r7 + r9
            int r3 = r0.zzawu
            long r9 = (long) r3
            long r7 = r7 - r9
            java.util.Stack<com.google.android.gms.internal.ads.zzkh> r3 = r0.zzawq
            com.google.android.gms.internal.ads.zzkh r5 = new com.google.android.gms.internal.ads.zzkh
            int r9 = r0.zzaws
            r5.<init>(r9, r7)
            r3.add(r5)
            long r9 = r0.zzawt
            int r3 = r0.zzawu
            long r11 = (long) r3
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0218
            r0.zzeb(r7)
            goto L_0x0297
        L_0x0218:
            r23.zzha()
            goto L_0x0297
        L_0x021d:
            int r3 = r0.zzaws
            int r8 = com.google.android.gms.internal.ads.zzki.zzatr
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzatc
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzats
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzatt
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaum
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaun
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzauo
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzatq
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaup
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzauq
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaur
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaus
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzaut
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzato
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzasa
            if (r3 == r8) goto L_0x0262
            int r8 = com.google.android.gms.internal.ads.zzki.zzava
            if (r3 != r8) goto L_0x0260
            goto L_0x0262
        L_0x0260:
            r3 = 0
            goto L_0x0263
        L_0x0262:
            r3 = 1
        L_0x0263:
            if (r3 == 0) goto L_0x0292
            int r3 = r0.zzawu
            if (r3 != r5) goto L_0x026b
            r3 = 1
            goto L_0x026c
        L_0x026b:
            r3 = 0
        L_0x026c:
            com.google.android.gms.internal.ads.zzoh.checkState(r3)
            long r8 = r0.zzawt
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x027a
            r3 = 1
            goto L_0x027b
        L_0x027a:
            r3 = 0
        L_0x027b:
            com.google.android.gms.internal.ads.zzoh.checkState(r3)
            com.google.android.gms.internal.ads.zzos r3 = new com.google.android.gms.internal.ads.zzos
            long r8 = r0.zzawt
            int r9 = (int) r8
            r3.<init>((int) r9)
            r0.zzawv = r3
            com.google.android.gms.internal.ads.zzos r8 = r0.zzawp
            byte[] r8 = r8.data
            byte[] r3 = r3.data
            java.lang.System.arraycopy(r8, r7, r3, r7, r5)
            goto L_0x0295
        L_0x0292:
            r3 = 0
            r0.zzawv = r3
        L_0x0295:
            r0.zzawr = r6
        L_0x0297:
            if (r6 != 0) goto L_0x0006
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkt.zza(com.google.android.gms.internal.ads.zzjl, com.google.android.gms.internal.ads.zzjs):int");
    }

    public final void zza(zzjo zzjo) {
        this.zzaqn = zzjo;
    }

    public final boolean zza(zzjl zzjl) throws IOException, InterruptedException {
        return zzky.zzd(zzjl);
    }

    public final void zzc(long j, long j2) {
        this.zzawq.clear();
        this.zzawu = 0;
        this.zzaqk = 0;
        this.zzaqj = 0;
        if (j == 0) {
            zzha();
            return;
        }
        zzkv[] zzkvArr = this.zzaww;
        if (zzkvArr != null) {
            for (zzkv zzkv : zzkvArr) {
                zzkz zzkz = zzkv.zzayd;
                int zzec = zzkz.zzec(j2);
                if (zzec == -1) {
                    zzec = zzkz.zzed(j2);
                }
                zzkv.zzawj = zzec;
            }
        }
    }

    public final long zzdz(long j) {
        long j2 = LongCompanionObject.MAX_VALUE;
        for (zzkv zzkv : this.zzaww) {
            zzkz zzkz = zzkv.zzayd;
            int zzec = zzkz.zzec(j);
            if (zzec == -1) {
                zzec = zzkz.zzed(j);
            }
            long j3 = zzkz.zzany[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
