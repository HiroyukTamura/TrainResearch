package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

@TargetApi(16)
public final class zzbea extends zzbdl implements zzbdc {
    private String zzebv;
    private boolean zzehc;
    private zzbcu zzehl;
    private Exception zzehm;
    private boolean zzehn;

    public zzbea(zzbbx zzbbx, zzbby zzbby) {
        super(zzbbx);
        zzbcu zzbcu = new zzbcu(zzbbx.getContext(), zzbby);
        this.zzehl = zzbcu;
        zzbcu.zza((zzbdc) this);
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder b = C0681a.m337b(C0681a.m336b(message, C0681a.m336b(canonicalName, C0681a.m336b(str, 2))), str, "/", canonicalName, ":");
        b.append(message);
        return b.toString();
    }

    private final void zzfo(String str) {
        synchronized (this) {
            this.zzehc = true;
            notify();
            release();
        }
        String str2 = this.zzebv;
        if (str2 != null) {
            String zzfm = zzfm(str2);
            Exception exc = this.zzehm;
            if (exc != null) {
                zza(this.zzebv, zzfm, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzebv, zzfm, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final void abort() {
        zzfo((String) null);
    }

    public final void release() {
        zzbcu zzbcu = this.zzehl;
        if (zzbcu != null) {
            zzbcu.zza((zzbdc) null);
            this.zzehl.release();
        }
        super.release();
    }

    public final void zza(String str, Exception exc) {
        String str2 = (String) zzvj.zzpv().zzd(zzzz.zzcjf);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzehm = exc;
        zzazw.zzd("Precache error", exc);
        zzfo(str);
    }

    public final zzbcu zzaan() {
        synchronized (this) {
            this.zzehn = true;
            notify();
        }
        this.zzehl.zza((zzbdc) null);
        zzbcu zzbcu = this.zzehl;
        this.zzehl = null;
        return zzbcu;
    }

    public final void zzb(boolean z, long j) {
        zzbbx zzbbx = (zzbbx) this.zzego.get();
        if (zzbbx != null) {
            zzbab.zzdzv.execute(new zzbdz(zzbbx, z, j));
        }
    }

    public final void zzde(int i) {
        this.zzehl.zzaak().zzdl(i);
    }

    public final void zzdf(int i) {
        this.zzehl.zzaak().zzdm(i);
    }

    public final void zzdg(int i) {
        this.zzehl.zzaak().zzdg(i);
    }

    public final void zzdh(int i) {
        this.zzehl.zzaak().zzdh(i);
    }

    public final void zzdj(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r11.zzehm == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        throw r11.zzehm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0171, code lost:
        r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r33, java.lang.String[] r34) {
        /*
            r32 = this;
            r11 = r32
            r12 = r33
            r0 = r34
            r11.zzebv = r12
            java.lang.String r13 = r32.zzfm(r33)
            java.lang.String r14 = "error"
            int r1 = r0.length     // Catch:{ Exception -> 0x0175 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x0175 }
            r2 = 0
        L_0x0012:
            int r3 = r0.length     // Catch:{ Exception -> 0x0175 }
            if (r2 >= r3) goto L_0x0026
            r3 = r0[r2]     // Catch:{ Exception -> 0x0020 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0020 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0020 }
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0020:
            r0 = move-exception
            r2 = r11
            r3 = r2
            r1 = r12
            goto L_0x017d
        L_0x0026:
            com.google.android.gms.internal.ads.zzbcu r0 = r11.zzehl     // Catch:{ Exception -> 0x0175 }
            java.lang.String r2 = r11.zzdym     // Catch:{ Exception -> 0x0175 }
            r0.zza((android.net.Uri[]) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0175 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbbx> r0 = r11.zzego     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzbbx r0 = (com.google.android.gms.internal.ads.zzbbx) r0     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x003a
            r0.zza((java.lang.String) r13, (com.google.android.gms.internal.ads.zzbdl) r11)     // Catch:{ Exception -> 0x0020 }
        L_0x003a:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ Exception -> 0x0175 }
            long r15 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzzz.zzcjl     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0175 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0175 }
            long r9 = r1.longValue()     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzzz.zzcjk     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0175 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0175 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0175 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r1 * r3
            com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzzz.zzcjj     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x0175 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0175 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0175 }
            long r4 = (long) r1     // Catch:{ Exception -> 0x0175 }
            r1 = -1
        L_0x0079:
            monitor-enter(r32)     // Catch:{ Exception -> 0x0175 }
            long r17 = r0.currentTimeMillis()     // Catch:{ all -> 0x0167 }
            long r17 = r17 - r15
            int r3 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0139
            boolean r3 = r11.zzehc     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x009e
            java.lang.Exception r0 = r11.zzehm     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0091
            java.lang.String r1 = "badUrl"
            java.lang.Exception r0 = r11.zzehm     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x0091:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x015f }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x009b:
            r0 = move-exception
            goto L_0x0161
        L_0x009e:
            boolean r3 = r11.zzehn     // Catch:{ all -> 0x0167 }
            r17 = 1
            if (r3 == 0) goto L_0x00a7
            monitor-exit(r32)     // Catch:{ all -> 0x009b }
            goto L_0x010b
        L_0x00a7:
            com.google.android.gms.internal.ads.zzbcu r3 = r11.zzehl     // Catch:{ all -> 0x0167 }
            com.google.android.gms.internal.ads.zzgt r3 = r3.zzaah()     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x012d
            r18 = r15
            r16 = r14
            long r14 = r3.getDuration()     // Catch:{ all -> 0x0165 }
            r20 = 0
            int r8 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r8 <= 0) goto L_0x010f
            long r22 = r3.getBufferedPosition()     // Catch:{ all -> 0x0165 }
            int r3 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00ee
            int r1 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cc
            r1 = 1
            r8 = 1
            goto L_0x00ce
        L_0x00cc:
            r1 = 0
            r8 = 0
        L_0x00ce:
            int r24 = com.google.android.gms.internal.ads.zzbcu.zzaai()     // Catch:{ all -> 0x0165 }
            int r25 = com.google.android.gms.internal.ads.zzbcu.zzaaj()     // Catch:{ all -> 0x0165 }
            r1 = r32
            r2 = r33
            r3 = r13
            r26 = r4
            r4 = r22
            r28 = r6
            r6 = r14
            r30 = r9
            r9 = r24
            r10 = r25
            r1.zza(r2, r3, r4, r6, r8, r9, r10)     // Catch:{ all -> 0x0165 }
            r1 = r22
            goto L_0x00f4
        L_0x00ee:
            r26 = r4
            r28 = r6
            r30 = r9
        L_0x00f4:
            int r3 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x00fc
            r11.zzb(r12, r13, r14)     // Catch:{ all -> 0x0165 }
            goto L_0x010a
        L_0x00fc:
            com.google.android.gms.internal.ads.zzbcu r3 = r11.zzehl     // Catch:{ all -> 0x0165 }
            long r3 = r3.getBytesTransferred()     // Catch:{ all -> 0x0165 }
            int r5 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r5 < 0) goto L_0x010c
            int r3 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r3 <= 0) goto L_0x010c
        L_0x010a:
            monitor-exit(r32)     // Catch:{ all -> 0x0165 }
        L_0x010b:
            return r17
        L_0x010c:
            r3 = r30
            goto L_0x0114
        L_0x010f:
            r26 = r4
            r28 = r6
            r3 = r9
        L_0x0114:
            r11.wait(r3)     // Catch:{ InterruptedException -> 0x0123 }
            monitor-exit(r32)     // Catch:{ all -> 0x0165 }
            r9 = r3
            r14 = r16
            r15 = r18
            r4 = r26
            r6 = r28
            goto L_0x0079
        L_0x0123:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x015f }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x012d:
            r16 = r14
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x015f }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x0139:
            r28 = r6
            r16 = r14
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x015f }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r3.<init>(r2)     // Catch:{ all -> 0x015f }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x015f }
            r4 = r28
            r3.append(r4)     // Catch:{ all -> 0x015f }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x015f }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x015f }
            r0.<init>(r2)     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x015f:
            r0 = move-exception
            r14 = r1
        L_0x0161:
            r2 = r11
            r3 = r2
            r1 = r12
            goto L_0x016f
        L_0x0165:
            r0 = move-exception
            goto L_0x016a
        L_0x0167:
            r0 = move-exception
            r16 = r14
        L_0x016a:
            r2 = r11
            r3 = r2
            r1 = r12
            r14 = r16
        L_0x016f:
            monitor-exit(r2)     // Catch:{ all -> 0x0173 }
            throw r0     // Catch:{ Exception -> 0x0171 }
        L_0x0171:
            r0 = move-exception
            goto L_0x017d
        L_0x0173:
            r0 = move-exception
            goto L_0x016f
        L_0x0175:
            r0 = move-exception
            r16 = r14
            r2 = r11
            r3 = r2
            r1 = r12
            r14 = r16
        L_0x017d:
            java.lang.String r4 = r0.getMessage()
            r5 = 34
            int r5 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r12, (int) r5)
            int r5 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r4, (int) r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Failed to preload url "
            r6.append(r5)
            r6.append(r1)
            java.lang.String r5 = " Exception: "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzazw.zzfc(r4)
            r2.release()
            java.lang.String r0 = zzb((java.lang.String) r14, (java.lang.Exception) r0)
            r3.zza(r1, r13, r14, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbea.zze(java.lang.String, java.lang.String[]):boolean");
    }

    public final boolean zzfl(String str) {
        return zze(str, new String[]{str});
    }

    /* access modifiers changed from: protected */
    public final String zzfm(String str) {
        String valueOf = String.valueOf(super.zzfm(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    public final void zzn(int i, int i2) {
    }
}
