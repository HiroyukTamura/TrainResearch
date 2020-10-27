package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzop;
import com.google.android.gms.internal.gtm.zzoq;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.tagmanager.zzeh;

@ShowFirstParty
public final class zzy extends BasePendingResult<ContainerHolder> {
    private final String zzaec;
    /* access modifiers changed from: private */
    public long zzaeh;
    private final Looper zzaek;
    private final TagManager zzaer;
    private final zzaf zzaeu;
    /* access modifiers changed from: private */
    public final zzej zzaev;
    private final int zzaew;
    /* access modifiers changed from: private */
    public final zzai zzaex;
    private zzah zzaey;
    private zzoq zzaez;
    /* access modifiers changed from: private */
    public volatile zzv zzafa;
    /* access modifiers changed from: private */
    public volatile boolean zzafb;
    /* access modifiers changed from: private */
    public zzk zzafc;
    private String zzafd;
    private zzag zzafe;
    private zzac zzaff;
    private final Context zzrm;
    /* access modifiers changed from: private */
    public final Clock zzsd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    private zzy(Context context, TagManager tagManager, Looper looper, String str, int i, zzah zzah, zzag zzag, zzoq zzoq, Clock clock, zzej zzej, zzai zzai) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.zzrm = context;
        this.zzaer = tagManager;
        this.zzaek = looper == null ? Looper.getMainLooper() : looper;
        this.zzaec = str;
        this.zzaew = i;
        this.zzaey = zzah;
        this.zzafe = zzag;
        this.zzaez = zzoq;
        this.zzaeu = new zzaf(this, (zzz) null);
        this.zzafc = new zzk();
        this.zzsd = clock;
        this.zzaev = zzej;
        this.zzaex = zzai;
        if (zzhi()) {
            zzao(zzeh.zziy().zzja());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzy(android.content.Context r23, com.google.android.gms.tagmanager.TagManager r24, android.os.Looper r25, java.lang.String r26, int r27, com.google.android.gms.tagmanager.zzal r28) {
        /*
            r22 = this;
            r1 = r23
            r4 = r26
            com.google.android.gms.tagmanager.zzex r6 = new com.google.android.gms.tagmanager.zzex
            r6.<init>(r1, r4)
            com.google.android.gms.tagmanager.zzes r7 = new com.google.android.gms.tagmanager.zzes
            r12 = r28
            r7.<init>(r1, r4, r12)
            com.google.android.gms.internal.gtm.zzoq r8 = new com.google.android.gms.internal.gtm.zzoq
            r8.<init>(r1)
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.common.util.DefaultClock.getInstance()
            com.google.android.gms.tagmanager.zzdg r10 = new com.google.android.gms.tagmanager.zzdg
            com.google.android.gms.common.util.Clock r21 = com.google.android.gms.common.util.DefaultClock.getInstance()
            r14 = 1
            r15 = 5
            r16 = 900000(0xdbba0, double:4.44659E-318)
            r18 = 5000(0x1388, double:2.4703E-320)
            java.lang.String r20 = "refreshing"
            r13 = r10
            r13.<init>(r14, r15, r16, r18, r20, r21)
            com.google.android.gms.tagmanager.zzai r11 = new com.google.android.gms.tagmanager.zzai
            r11.<init>(r1, r4)
            r0 = r22
            r2 = r24
            r3 = r25
            r5 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.google.android.gms.internal.gtm.zzoq r1 = r0.zzaez
            java.lang.String r2 = r28.zzhq()
            r1.zzcr(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzy.<init>(android.content.Context, com.google.android.gms.tagmanager.TagManager, android.os.Looper, java.lang.String, int, com.google.android.gms.tagmanager.zzal):void");
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzk zzk) {
        if (this.zzaey != null) {
            zzop zzop = new zzop();
            zzop.zzaux = this.zzaeh;
            zzop.zzqk = new zzi();
            zzop.zzauy = zzk;
            this.zzaey.zza(zzop);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.gtm.zzk r10, long r11, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r13 = r9.isReady()     // Catch:{ all -> 0x006c }
            if (r13 == 0) goto L_0x000d
            com.google.android.gms.tagmanager.zzv r13 = r9.zzafa     // Catch:{ all -> 0x006c }
            if (r13 != 0) goto L_0x000d
            monitor-exit(r9)
            return
        L_0x000d:
            r9.zzafc = r10     // Catch:{ all -> 0x006c }
            r9.zzaeh = r11     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.zzai r13 = r9.zzaex     // Catch:{ all -> 0x006c }
            long r0 = r13.zzhl()     // Catch:{ all -> 0x006c }
            r2 = 0
            long r4 = r9.zzaeh     // Catch:{ all -> 0x006c }
            long r4 = r4 + r0
            com.google.android.gms.common.util.Clock r13 = r9.zzsd     // Catch:{ all -> 0x006c }
            long r6 = r13.currentTimeMillis()     // Catch:{ all -> 0x006c }
            long r4 = r4 - r6
            long r0 = java.lang.Math.min(r0, r4)     // Catch:{ all -> 0x006c }
            long r0 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x006c }
            r9.zzk(r0)     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.Container r13 = new com.google.android.gms.tagmanager.Container     // Catch:{ all -> 0x006c }
            android.content.Context r3 = r9.zzrm     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.TagManager r0 = r9.zzaer     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.DataLayer r4 = r0.getDataLayer()     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r9.zzaec     // Catch:{ all -> 0x006c }
            r2 = r13
            r6 = r11
            r8 = r10
            r2.<init>((android.content.Context) r3, (com.google.android.gms.tagmanager.DataLayer) r4, (java.lang.String) r5, (long) r6, (com.google.android.gms.internal.gtm.zzk) r8)     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.zzv r10 = r9.zzafa     // Catch:{ all -> 0x006c }
            if (r10 != 0) goto L_0x0052
            com.google.android.gms.tagmanager.zzv r10 = new com.google.android.gms.tagmanager.zzv     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.TagManager r11 = r9.zzaer     // Catch:{ all -> 0x006c }
            android.os.Looper r12 = r9.zzaek     // Catch:{ all -> 0x006c }
            com.google.android.gms.tagmanager.zzaf r0 = r9.zzaeu     // Catch:{ all -> 0x006c }
            r10.<init>(r11, r12, r13, r0)     // Catch:{ all -> 0x006c }
            r9.zzafa = r10     // Catch:{ all -> 0x006c }
            goto L_0x0057
        L_0x0052:
            com.google.android.gms.tagmanager.zzv r10 = r9.zzafa     // Catch:{ all -> 0x006c }
            r10.zza(r13)     // Catch:{ all -> 0x006c }
        L_0x0057:
            boolean r10 = r9.isReady()     // Catch:{ all -> 0x006c }
            if (r10 != 0) goto L_0x006a
            com.google.android.gms.tagmanager.zzac r10 = r9.zzaff     // Catch:{ all -> 0x006c }
            boolean r10 = r10.zzb(r13)     // Catch:{ all -> 0x006c }
            if (r10 == 0) goto L_0x006a
            com.google.android.gms.tagmanager.zzv r10 = r9.zzafa     // Catch:{ all -> 0x006c }
            r9.setResult(r10)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r9)
            return
        L_0x006c:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzy.zza(com.google.android.gms.internal.gtm.zzk, long, boolean):void");
    }

    private final void zzd(boolean z) {
        this.zzaey.zza((zzdh<zzop>) new zzad(this, (zzz) null));
        this.zzafe.zza(new zzae(this, (zzz) null));
        zzov zzt = this.zzaey.zzt(this.zzaew);
        if (zzt != null) {
            TagManager tagManager = this.zzaer;
            this.zzafa = new zzv(tagManager, this.zzaek, new Container(this.zzrm, tagManager.getDataLayer(), this.zzaec, 0, zzt), this.zzaeu);
        }
        this.zzaff = new zzab(this, z);
        if (zzhi()) {
            this.zzafe.zza(0, "");
        } else {
            this.zzaey.zzhk();
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzhi() {
        zzeh zziy = zzeh.zziy();
        return (zziy.zziz() == zzeh.zza.CONTAINER || zziy.zziz() == zzeh.zza.CONTAINER_DEBUG) && this.zzaec.equals(zziy.getContainerId());
    }

    /* access modifiers changed from: private */
    public final synchronized void zzk(long j) {
        if (this.zzafe == null) {
            zzdi.zzac("Refresh requested, but no network load scheduler.");
        } else {
            this.zzafe.zza(j, this.zzafc.zzql);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final ContainerHolder createFailedResult(Status status) {
        if (this.zzafa != null) {
            return this.zzafa;
        }
        if (status == Status.RESULT_TIMEOUT) {
            zzdi.zzav("timer expired: setting result to failure");
        }
        return new zzv(status);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final synchronized void zzao(String str) {
        this.zzafd = str;
        if (this.zzafe != null) {
            this.zzafe.zzap(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized String zzhc() {
        return this.zzafd;
    }

    public final void zzhf() {
        zzov zzt = this.zzaey.zzt(this.zzaew);
        if (zzt != null) {
            setResult(new zzv(this.zzaer, this.zzaek, new Container(this.zzrm, this.zzaer.getDataLayer(), this.zzaec, 0, zzt), new zzaa(this)));
        } else {
            zzdi.zzav("Default was requested, but no default container was found");
            setResult(createFailedResult(new Status(10, "Default was requested, but no default container was found", (PendingIntent) null)));
        }
        this.zzafe = null;
        this.zzaey = null;
    }

    public final void zzhg() {
        zzd(false);
    }

    public final void zzhh() {
        zzd(true);
    }
}
