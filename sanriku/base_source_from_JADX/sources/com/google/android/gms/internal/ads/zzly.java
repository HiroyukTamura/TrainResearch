package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;
import kotlin.jvm.internal.LongCompanionObject;

final class zzly implements zzjo, zzmi, zzmu, zzoe<zzmb> {
    private final Uri uri;
    private final zzdns zzadv;
    /* access modifiers changed from: private */
    public final zzdns zzaes;
    /* access modifiers changed from: private */
    public boolean zzaez;
    private boolean zzafv;
    private long zzaht;
    private final zznu zzans;
    private final int zzbav;
    /* access modifiers changed from: private */
    public final zzmf zzbaw;
    private final zzmj zzbax;
    private final zzns zzbay;
    /* access modifiers changed from: private */
    public final String zzbaz;
    /* access modifiers changed from: private */
    public final long zzbba;
    private final zzob zzbbb = new zzob("Loader:ExtractorMediaPeriod");
    private final zzme zzbbc;
    private final zzoj zzbbd;
    private final Runnable zzbbe;
    /* access modifiers changed from: private */
    public final Runnable zzbbf;
    /* access modifiers changed from: private */
    public final SparseArray<zzms> zzbbg;
    /* access modifiers changed from: private */
    public zzmh zzbbh;
    private zzjr zzbbi;
    private boolean zzbbj;
    private boolean zzbbk;
    private boolean zzbbl;
    private int zzbbm;
    private zzna zzbbn;
    private boolean[] zzbbo;
    private boolean[] zzbbp;
    private boolean zzbbq;
    private long zzbbr;
    private long zzbbs;
    private int zzbbt;
    private boolean zzbbu;
    private long zzce;

    public zzly(Uri uri2, zznu zznu, zzjm[] zzjmArr, int i, zzdns zzdns, zzmf zzmf, zzmj zzmj, zzns zzns, String str, int i2) {
        this.uri = uri2;
        this.zzans = zznu;
        this.zzbav = i;
        this.zzadv = zzdns;
        this.zzbaw = zzmf;
        this.zzbax = zzmj;
        this.zzbay = zzns;
        this.zzbaz = str;
        this.zzbba = (long) i2;
        this.zzbbc = new zzme(zzjmArr, this);
        this.zzbbd = new zzoj();
        this.zzbbe = new zzlx(this);
        this.zzbbf = new zzma(this);
        this.zzaes = new zzdns();
        this.zzbbs = -9223372036854775807L;
        this.zzbbg = new SparseArray<>();
        this.zzce = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        r0 = r9.zzbbi;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void startLoading() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzmb r6 = new com.google.android.gms.internal.ads.zzmb
            android.net.Uri r2 = r9.uri
            com.google.android.gms.internal.ads.zznu r3 = r9.zzans
            com.google.android.gms.internal.ads.zzme r4 = r9.zzbbc
            com.google.android.gms.internal.ads.zzoj r5 = r9.zzbbd
            r0 = r6
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r0 = r9.zzafv
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0040
            boolean r0 = r9.zzhv()
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            long r3 = r9.zzaht
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            long r7 = r9.zzbbs
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0031
            r0 = 1
            r9.zzbbu = r0
            r9.zzbbs = r1
            return
        L_0x0031:
            com.google.android.gms.internal.ads.zzjr r0 = r9.zzbbi
            long r3 = r9.zzbbs
            long r3 = r0.zzdz(r3)
            long r7 = r9.zzbbs
            r6.zze(r3, r7)
            r9.zzbbs = r1
        L_0x0040:
            int r0 = r9.zzht()
            r9.zzbbt = r0
            int r0 = r9.zzbav
            r3 = -1
            if (r0 != r3) goto L_0x0067
            boolean r0 = r9.zzafv
            if (r0 == 0) goto L_0x0066
            long r3 = r9.zzce
            r7 = -1
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzjr r0 = r9.zzbbi
            if (r0 == 0) goto L_0x0064
            long r3 = r0.getDurationUs()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = 6
            goto L_0x0067
        L_0x0066:
            r0 = 3
        L_0x0067:
            com.google.android.gms.internal.ads.zzob r1 = r9.zzbbb
            r1.zza(r6, r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.startLoading():void");
    }

    private final void zza(zzmb zzmb) {
        if (this.zzce == -1) {
            this.zzce = zzmb.zzce;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public final void zzhs() {
        /*
            r8 = this;
            boolean r0 = r8.zzaez
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.zzafv
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzjr r0 = r8.zzbbi
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.zzbbj
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzms> r0 = r8.zzbbg
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzms> r3 = r8.zzbbg
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzms r3 = (com.google.android.gms.internal.ads.zzms) r3
            com.google.android.gms.internal.ads.zzhf r3 = r3.zzie()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzoj r2 = r8.zzbbd
            r2.zzit()
            com.google.android.gms.internal.ads.zzmx[] r2 = new com.google.android.gms.internal.ads.zzmx[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzbbp = r3
            boolean[] r3 = new boolean[r0]
            r8.zzbbo = r3
            com.google.android.gms.internal.ads.zzjr r3 = r8.zzbbi
            long r3 = r3.getDurationUs()
            r8.zzaht = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzms> r5 = r8.zzbbg
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzms r5 = (com.google.android.gms.internal.ads.zzms) r5
            com.google.android.gms.internal.ads.zzhf r5 = r5.zzie()
            com.google.android.gms.internal.ads.zzmx r6 = new com.google.android.gms.internal.ads.zzmx
            com.google.android.gms.internal.ads.zzhf[] r7 = new com.google.android.gms.internal.ads.zzhf[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzagi
            boolean r6 = com.google.android.gms.internal.ads.zzoo.zzbe(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzoo.zzbd(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.zzbbp
            r5[r3] = r4
            boolean r5 = r8.zzbbq
            r4 = r4 | r5
            r8.zzbbq = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zzna r0 = new com.google.android.gms.internal.ads.zzna
            r0.<init>(r2)
            r8.zzbbn = r0
            r8.zzafv = r4
            com.google.android.gms.internal.ads.zzmj r0 = r8.zzbax
            com.google.android.gms.internal.ads.zzmy r1 = new com.google.android.gms.internal.ads.zzmy
            long r2 = r8.zzaht
            com.google.android.gms.internal.ads.zzjr r4 = r8.zzbbi
            boolean r4 = r4.isSeekable()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzmh r0 = r8.zzbbh
            r0.zza(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.zzhs():void");
    }

    private final int zzht() {
        int size = this.zzbbg.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbbg.valueAt(i2).zzic();
        }
        return i;
    }

    private final long zzhu() {
        int size = this.zzbbg.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbbg.valueAt(i).zzhu());
        }
        return j;
    }

    private final boolean zzhv() {
        return this.zzbbs != -9223372036854775807L;
    }

    public final void release() {
        this.zzbbb.zza((Runnable) new zzlz(this, this.zzbbc));
        this.zzaes.removeCallbacksAndMessages((Object) null);
        this.zzaez = true;
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzhh zzhh, zzjb zzjb, boolean z) {
        if (this.zzbbl || zzhv()) {
            return -3;
        }
        return this.zzbbg.valueAt(i).zza(zzhh, zzjb, z, this.zzbbu, this.zzbbr);
    }

    public final /* synthetic */ int zza(zzog zzog, long j, long j2, IOException iOException) {
        zzjr zzjr;
        zzmb zzmb = (zzmb) zzog;
        zza(zzmb);
        zzdns zzdns = this.zzadv;
        if (!(zzdns == null || this.zzbaw == null)) {
            zzdns.post(new zzmc(this, iOException));
        }
        if (iOException instanceof zzmz) {
            return 3;
        }
        boolean z = zzht() > this.zzbbt;
        if (this.zzce == -1 && ((zzjr = this.zzbbi) == null || zzjr.getDurationUs() == -9223372036854775807L)) {
            this.zzbbr = 0;
            this.zzbbl = this.zzafv;
            int size = this.zzbbg.size();
            for (int i = 0; i < size; i++) {
                this.zzbbg.valueAt(i).zzk(!this.zzafv || this.zzbbo[i]);
            }
            zzmb.zze(0, 0);
        }
        this.zzbbt = zzht();
        return z ? 1 : 0;
    }

    public final long zza(zznj[] zznjArr, boolean[] zArr, zzmt[] zzmtArr, boolean[] zArr2, long j) {
        zzoh.checkState(this.zzafv);
        for (int i = 0; i < zznjArr.length; i++) {
            if (zzmtArr[i] != null && (zznjArr[i] == null || !zArr[i])) {
                int zza = zzmtArr[i].track;
                zzoh.checkState(this.zzbbo[zza]);
                this.zzbbm--;
                this.zzbbo[zza] = false;
                this.zzbbg.valueAt(zza).disable();
                zzmtArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zznjArr.length; i2++) {
            if (zzmtArr[i2] == null && zznjArr[i2] != null) {
                zznj zznj = zznjArr[i2];
                zzoh.checkState(zznj.length() == 1);
                zzoh.checkState(zznj.zzaz(0) == 0);
                int zza2 = this.zzbbn.zza(zznj.zzik());
                zzoh.checkState(!this.zzbbo[zza2]);
                this.zzbbm++;
                this.zzbbo[zza2] = true;
                zzmtArr[i2] = new zzmd(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbbk) {
            int size = this.zzbbg.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzbbo[i3]) {
                    this.zzbbg.valueAt(i3).disable();
                }
            }
        }
        if (this.zzbbm == 0) {
            this.zzbbl = false;
            if (this.zzbbb.isLoading()) {
                this.zzbbb.zzir();
            }
        } else if (!this.zzbbk ? j != 0 : z) {
            j = zzeg(j);
            for (int i4 = 0; i4 < zzmtArr.length; i4++) {
                if (zzmtArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbbk = true;
        return j;
    }

    public final void zza(zzjr zzjr) {
        this.zzbbi = zzjr;
        this.zzaes.post(this.zzbbe);
    }

    public final void zza(zzmh zzmh, long j) {
        this.zzbbh = zzmh;
        this.zzbbd.open();
        startLoading();
    }

    public final /* synthetic */ void zza(zzog zzog, long j, long j2) {
        zza((zzmb) zzog);
        this.zzbbu = true;
        if (this.zzaht == -9223372036854775807L) {
            long zzhu = zzhu();
            this.zzaht = zzhu == Long.MIN_VALUE ? 0 : zzhu + 10000;
            this.zzbax.zzb(new zzmy(this.zzaht, this.zzbbi.isSeekable()), (Object) null);
        }
        this.zzbbh.zza(this);
    }

    public final /* synthetic */ void zza(zzog zzog, long j, long j2, boolean z) {
        zza((zzmb) zzog);
        if (!z && this.zzbbm > 0) {
            int size = this.zzbbg.size();
            for (int i = 0; i < size; i++) {
                this.zzbbg.valueAt(i).zzk(this.zzbbo[i]);
            }
            this.zzbbh.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzav(int i) {
        if (!this.zzbbu) {
            return !zzhv() && this.zzbbg.valueAt(i).zzid();
        }
        return true;
    }

    public final zzjt zzc(int i, int i2) {
        zzms zzms = this.zzbbg.get(i);
        if (zzms != null) {
            return zzms;
        }
        zzms zzms2 = new zzms(this.zzbay);
        zzms2.zza(this);
        this.zzbbg.put(i, zzms2);
        return zzms2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j) {
        zzms valueAt = this.zzbbg.valueAt(i);
        if (!this.zzbbu || j <= valueAt.zzhu()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzih();
        }
    }

    public final boolean zzee(long j) {
        if (this.zzbbu) {
            return false;
        }
        if (this.zzafv && this.zzbbm == 0) {
            return false;
        }
        boolean open = this.zzbbd.open();
        if (this.zzbbb.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final void zzef(long j) {
    }

    public final long zzeg(long j) {
        if (!this.zzbbi.isSeekable()) {
            j = 0;
        }
        this.zzbbr = j;
        int size = this.zzbbg.size();
        boolean z = !zzhv();
        int i = 0;
        while (z && i < size) {
            if (this.zzbbo[i]) {
                z = this.zzbbg.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbbs = j;
            this.zzbbu = false;
            if (this.zzbbb.isLoading()) {
                this.zzbbb.zzir();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbbg.valueAt(i2).zzk(this.zzbbo[i2]);
                }
            }
        }
        this.zzbbl = false;
        return j;
    }

    public final void zzf(zzhf zzhf) {
        this.zzaes.post(this.zzbbe);
    }

    public final void zzgr() {
        this.zzbbj = true;
        this.zzaes.post(this.zzbbe);
    }

    public final long zzhm() {
        if (this.zzbbm == 0) {
            return Long.MIN_VALUE;
        }
        return zzhq();
    }

    public final void zzhn() throws IOException {
        this.zzbbb.zzbd(Integer.MIN_VALUE);
    }

    public final zzna zzho() {
        return this.zzbbn;
    }

    public final long zzhp() {
        if (!this.zzbbl) {
            return -9223372036854775807L;
        }
        this.zzbbl = false;
        return this.zzbbr;
    }

    public final long zzhq() {
        long j;
        if (this.zzbbu) {
            return Long.MIN_VALUE;
        }
        if (zzhv()) {
            return this.zzbbs;
        }
        if (this.zzbbq) {
            j = LongCompanionObject.MAX_VALUE;
            int size = this.zzbbg.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbbp[i]) {
                    j = Math.min(j, this.zzbbg.valueAt(i).zzhu());
                }
            }
        } else {
            j = zzhu();
        }
        return j == Long.MIN_VALUE ? this.zzbbr : j;
    }

    /* access modifiers changed from: package-private */
    public final void zzhr() throws IOException {
        this.zzbbb.zzbd(Integer.MIN_VALUE);
    }
}
