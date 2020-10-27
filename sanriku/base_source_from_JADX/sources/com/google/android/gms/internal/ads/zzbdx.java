package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzbdx extends zzbdl implements zzoi<zznu> {
    private String url;
    private ByteBuffer zzalo;
    private final zzbby zzeet;
    private boolean zzehc;
    private final zzbdy zzehd = new zzbdy();
    private final zzbdd zzehe = new zzbdd();
    private boolean zzehf;
    private final Object zzehg = new Object();
    private boolean zzehh;

    public zzbdx(zzbbx zzbbx, zzbby zzbby) {
        super(zzbbx);
        this.zzeet = zzbby;
    }

    private final void zzyx() {
        int zzaam = (int) this.zzehd.zzaam();
        int zzl = (int) this.zzehe.zzl(this.zzalo);
        int position = this.zzalo.position();
        int round = Math.round((((float) position) / ((float) zzaam)) * ((float) zzl));
        boolean z = round > 0;
        int zzaai = zzbcu.zzaai();
        int zzaaj = zzbcu.zzaaj();
        String str = this.url;
        zza(str, zzfm(str), position, zzaam, (long) round, (long) zzl, z, zzaai, zzaaj);
    }

    public final void abort() {
        this.zzehc = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzehg) {
            if (this.zzalo != null && !this.zzehf) {
                this.zzalo.flip();
                this.zzehf = true;
            }
            this.zzehc = true;
        }
        return this.zzalo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final /* synthetic */ void zza(Object obj, zznv zznv) {
        zznu zznu = (zznu) obj;
        if (zznu instanceof zznx) {
            this.zzehd.zza((zznx) zznu);
        }
    }

    public final boolean zzaal() {
        return this.zzehh;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    /* JADX WARNING: type inference failed for: r1v24, types: [com.google.android.gms.internal.ads.zzbcp] */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0146, code lost:
        r0 = th;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfl(java.lang.String r23) {
        /*
            r22 = this;
            r9 = r22
            r10 = r23
            r9.url = r10
            java.lang.String r11 = r22.zzfm(r23)
            java.lang.String r12 = "error"
            r0 = 0
            com.google.android.gms.internal.ads.zznx r13 = new com.google.android.gms.internal.ads.zznx     // Catch:{ Exception -> 0x0148 }
            java.lang.String r2 = r9.zzdym     // Catch:{ Exception -> 0x0148 }
            r3 = 0
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x0148 }
            int r5 = r1.zzedu     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x0148 }
            int r6 = r1.zzedw     // Catch:{ Exception -> 0x0148 }
            r7 = 1
            r8 = 0
            r1 = r13
            r4 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x0148 }
            boolean r1 = r1.zzeea     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzbcp r1 = new com.google.android.gms.internal.ads.zzbcp     // Catch:{ Exception -> 0x0032 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r1.<init>(r2, r13, r3, r3)     // Catch:{ Exception -> 0x0032 }
            r13 = r1
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x0134
        L_0x0035:
            android.net.Uri r1 = android.net.Uri.parse(r23)     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zznv r2 = new com.google.android.gms.internal.ads.zznv     // Catch:{ Exception -> 0x0148 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0148 }
            r13.zza(r2)     // Catch:{ Exception -> 0x0148 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbbx> r1 = r9.zzego     // Catch:{ Exception -> 0x0148 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzbbx r1 = (com.google.android.gms.internal.ads.zzbbx) r1     // Catch:{ Exception -> 0x0148 }
            if (r1 == 0) goto L_0x004e
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbdl) r9)     // Catch:{ Exception -> 0x0032 }
        L_0x004e:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ Exception -> 0x0148 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzzz.zzcjl     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzzv r5 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x0148 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x0148 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0148 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzzz.zzcjk     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzzv r7 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x0148 }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x0148 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0148 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0148 }
            com.google.android.gms.internal.ads.zzbby r8 = r9.zzeet     // Catch:{ Exception -> 0x0148 }
            int r8 = r8.zzedt     // Catch:{ Exception -> 0x0148 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0148 }
            r9.zzalo = r8     // Catch:{ Exception -> 0x0148 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r8]     // Catch:{ Exception -> 0x0148 }
            r15 = r2
            r17 = r12
        L_0x0087:
            java.nio.ByteBuffer r12 = r9.zzalo     // Catch:{ Exception -> 0x0139 }
            int r12 = r12.remaining()     // Catch:{ Exception -> 0x0139 }
            int r8 = java.lang.Math.min(r12, r8)     // Catch:{ Exception -> 0x0139 }
            int r0 = r13.read(r14, r0, r8)     // Catch:{ Exception -> 0x0139 }
            r8 = -1
            if (r0 != r8) goto L_0x00ae
            r0 = 1
            r9.zzehh = r0     // Catch:{ Exception -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbdd r0 = r9.zzehe     // Catch:{ Exception -> 0x00a9 }
            java.nio.ByteBuffer r1 = r9.zzalo     // Catch:{ Exception -> 0x00a9 }
            long r0 = r0.zzl(r1)     // Catch:{ Exception -> 0x00a9 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x00a9 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x00a9 }
            r9.zzb(r10, r11, r0)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c7
        L_0x00a9:
            r0 = move-exception
            r12 = r17
            goto L_0x0134
        L_0x00ae:
            java.lang.Object r8 = r9.zzehg     // Catch:{ Exception -> 0x0139 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0139 }
            boolean r12 = r9.zzehc     // Catch:{ all -> 0x013b }
            if (r12 != 0) goto L_0x00bb
            java.nio.ByteBuffer r12 = r9.zzalo     // Catch:{ all -> 0x013b }
            r10 = 0
            r12.put(r14, r10, r0)     // Catch:{ all -> 0x013b }
        L_0x00bb:
            monitor-exit(r8)     // Catch:{ all -> 0x013b }
            java.nio.ByteBuffer r0 = r9.zzalo     // Catch:{ Exception -> 0x0139 }
            int r0 = r0.remaining()     // Catch:{ Exception -> 0x0139 }
            if (r0 > 0) goto L_0x00c9
            r22.zzyx()     // Catch:{ Exception -> 0x0139 }
        L_0x00c7:
            r0 = 1
            return r0
        L_0x00c9:
            boolean r0 = r9.zzehc     // Catch:{ Exception -> 0x0139 }
            if (r0 != 0) goto L_0x010c
            long r18 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0139 }
            long r20 = r18 - r15
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00dc
            r22.zzyx()     // Catch:{ Exception -> 0x0139 }
            r15 = r18
        L_0x00dc:
            long r18 = r18 - r2
            r20 = 1000(0x3e8, double:4.94E-321)
            long r20 = r20 * r6
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 > 0) goto L_0x00ec
            r8 = 8192(0x2000, float:1.14794E-41)
            r0 = 0
            r10 = r23
            goto L_0x0087
        L_0x00ec:
            java.lang.String r1 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0132 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r2.append(r0)     // Catch:{ Exception -> 0x0132 }
            r2.append(r6)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0132 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x0132 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0132 }
            throw r2     // Catch:{ Exception -> 0x0132 }
        L_0x010c:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0132 }
            java.nio.ByteBuffer r2 = r9.zzalo     // Catch:{ Exception -> 0x0132 }
            int r2 = r2.limit()     // Catch:{ Exception -> 0x0132 }
            r3 = 35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0132 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r3 = "Precache abort at "
            r4.append(r3)     // Catch:{ Exception -> 0x0132 }
            r4.append(r2)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r2 = " bytes"
            r4.append(r2)     // Catch:{ Exception -> 0x0132 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0132 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0132 }
            throw r0     // Catch:{ Exception -> 0x0132 }
        L_0x0132:
            r0 = move-exception
            r12 = r1
        L_0x0134:
            r1 = r23
            r2 = r1
            r3 = r9
            goto L_0x0151
        L_0x0139:
            r0 = move-exception
            goto L_0x014b
        L_0x013b:
            r0 = move-exception
            r1 = r23
            r2 = r1
            r3 = r9
            r12 = r17
        L_0x0142:
            monitor-exit(r8)     // Catch:{ all -> 0x0146 }
            throw r0     // Catch:{ Exception -> 0x0144 }
        L_0x0144:
            r0 = move-exception
            goto L_0x0151
        L_0x0146:
            r0 = move-exception
            goto L_0x0142
        L_0x0148:
            r0 = move-exception
            r17 = r12
        L_0x014b:
            r1 = r23
            r2 = r1
            r3 = r9
            r12 = r17
        L_0x0151:
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            r5 = 1
            int r5 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r4, (int) r5)
            int r5 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r0, (int) r5)
            java.lang.String r6 = ":"
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m313a((int) r5, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            r4 = 34
            int r1 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r1, (int) r4)
            int r1 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r0, (int) r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = " Exception: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r1 = r4.toString()
            com.google.android.gms.internal.ads.zzazw.zzfc(r1)
            r3.zza(r2, r11, r12, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.zzfl(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final String zzfm(String str) {
        String valueOf = String.valueOf(super.zzfm(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
