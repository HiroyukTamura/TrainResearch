package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

final class zzgy implements Handler.Callback, zzmh, zzmj, zznn {
    private int repeatMode = 0;
    private int state;
    private final zzhk[] zzads;
    private final zzno zzadt;
    private final zzdns zzadv;
    private final zzhq zzady;
    private final zzhr zzadz;
    private boolean zzaeb;
    private boolean zzaef;
    private zzhp zzaeg;
    private zzhl zzaek;
    private zzha zzael;
    private final zzhn[] zzaep;
    private final zzhj zzaeq;
    private final zzot zzaer;
    private final zzdns zzaes;
    private final HandlerThread zzaet;
    private final zzgt zzaeu;
    private zzhk zzaev;
    private zzol zzaew;
    private zzmk zzaex;
    private zzhk[] zzaey;
    private boolean zzaez;
    private boolean zzafa;
    private int zzafb;
    private int zzafc;
    private long zzafd;
    private int zzafe;
    private zzhd zzaff;
    private long zzafg;
    private zzhb zzafh;
    private zzhb zzafi;
    private zzhb zzafj;

    public zzgy(zzhk[] zzhkArr, zzno zzno, zzhj zzhj, boolean z, int i, zzdns zzdns, zzha zzha, zzgt zzgt) {
        this.zzads = zzhkArr;
        this.zzadt = zzno;
        this.zzaeq = zzhj;
        this.zzaeb = z;
        this.zzadv = zzdns;
        this.state = 1;
        this.zzael = zzha;
        this.zzaeu = zzgt;
        this.zzaep = new zzhn[zzhkArr.length];
        for (int i2 = 0; i2 < zzhkArr.length; i2++) {
            zzhkArr[i2].setIndex(i2);
            this.zzaep[i2] = zzhkArr[i2].zzdy();
        }
        this.zzaer = new zzot();
        this.zzaey = new zzhk[0];
        this.zzady = new zzhq();
        this.zzadz = new zzhr();
        zzno.zza(this);
        this.zzaek = zzhl.zzahe;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzaet = handlerThread;
        handlerThread.start();
        this.zzaes = new zzdns(this.zzaet.getLooper(), this);
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzadv.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final int zza(int i, zzhp zzhp, zzhp zzhp2) {
        int zzff = zzhp.zzff();
        int i2 = -1;
        for (int i3 = 0; i3 < zzff && i2 == -1; i3++) {
            i = zzhp.zza(i, this.zzadz, this.zzady, this.repeatMode);
            i2 = zzhp2.zzc(zzhp.zza(i, this.zzadz, true).zzafq);
        }
        return i2;
    }

    private final long zza(int i, long j) throws zzgq {
        zzhb zzhb;
        zzeq();
        this.zzafa = false;
        setState(2);
        zzhb zzhb2 = this.zzafj;
        if (zzhb2 == null) {
            zzhb zzhb3 = this.zzafh;
            if (zzhb3 != null) {
                zzhb3.release();
            }
            zzhb = null;
        } else {
            zzhb = null;
            while (zzhb2 != null) {
                if (zzhb2.zzafl != i || !zzhb2.zzafv) {
                    zzhb2.release();
                } else {
                    zzhb = zzhb2;
                }
                zzhb2 = zzhb2.zzafx;
            }
        }
        zzhb zzhb4 = this.zzafj;
        if (!(zzhb4 == zzhb && zzhb4 == this.zzafi)) {
            for (zzhk disable : this.zzaey) {
                disable.disable();
            }
            this.zzaey = new zzhk[0];
            this.zzaew = null;
            this.zzaev = null;
            this.zzafj = null;
        }
        if (zzhb != null) {
            zzhb.zzafx = null;
            this.zzafh = zzhb;
            this.zzafi = zzhb;
            zzb(zzhb);
            zzhb zzhb5 = this.zzafj;
            if (zzhb5.zzafw) {
                j = zzhb5.zzafp.zzeg(j);
            }
            zzdq(j);
            zzeu();
        } else {
            this.zzafh = null;
            this.zzafi = null;
            this.zzafj = null;
            zzdq(j);
        }
        this.zzaes.sendEmptyMessage(2);
        return j;
    }

    private final Pair<Integer, Long> zza(zzhd zzhd) {
        zzhp zzhp = zzhd.zzaeg;
        if (zzhp.isEmpty()) {
            zzhp = this.zzaeg;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzhp, zzhd.zzagb, zzhd.zzagc);
            zzhp zzhp2 = this.zzaeg;
            if (zzhp2 == zzhp) {
                return zzb;
            }
            int zzc = zzhp2.zzc(zzhp.zza(((Integer) zzb.first).intValue(), this.zzadz, true).zzafq);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzhp, this.zzaeg);
            if (zza == -1) {
                return null;
            }
            this.zzaeg.zza(zza, this.zzadz, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhg(this.zzaeg, zzhd.zzagb, zzhd.zzagc);
        }
    }

    private final Pair<Integer, Long> zza(zzhp zzhp, int i, long j, long j2) {
        zzoh.zzc(i, 0, zzhp.zzfe());
        zzhp.zza(i, this.zzady, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzady.zzahs;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzady.zzahu + j;
        long j4 = zzhp.zza(0, this.zzadz, false).zzaht;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zza(long j, long j2) {
        this.zzaes.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zzaes.sendEmptyMessage(2);
        } else {
            this.zzaes.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private static void zza(zzhb zzhb) {
        while (zzhb != null) {
            zzhb.release();
            zzhb = zzhb.zzafx;
        }
    }

    private static void zza(zzhk zzhk) throws zzgq {
        if (zzhk.getState() == 2) {
            zzhk.stop();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzael = new zzha(0, 0);
        zzb(obj, i);
        this.zzael = new zzha(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final void zza(boolean[] zArr, int i) throws zzgq {
        this.zzaey = new zzhk[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhk[] zzhkArr = this.zzads;
            if (i2 < zzhkArr.length) {
                zzhk zzhk = zzhkArr[i2];
                zznj zzba = this.zzafj.zzafy.zzbfh.zzba(i2);
                if (zzba != null) {
                    int i4 = i3 + 1;
                    this.zzaey[i3] = zzhk;
                    if (zzhk.getState() == 0) {
                        zzhm zzhm = this.zzafj.zzafy.zzbfj[i2];
                        boolean z = this.zzaeb && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        int length = zzba.length();
                        zzhf[] zzhfArr = new zzhf[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            zzhfArr[i5] = zzba.zzax(i5);
                        }
                        zzhb zzhb = this.zzafj;
                        zzhk.zza(zzhm, zzhfArr, zzhb.zzafr[i2], this.zzafg, z2, zzhb.zzev());
                        zzol zzdz = zzhk.zzdz();
                        if (zzdz != null) {
                            if (this.zzaew == null) {
                                this.zzaew = zzdz;
                                this.zzaev = zzhk;
                                zzdz.zzb(this.zzaek);
                            } else {
                                throw zzgq.zza((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhk.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzaeg, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzhp zzhp, int i, long j) {
        return zza(zzhp, i, j, 0);
    }

    private final void zzb(zzhb zzhb) throws zzgq {
        if (this.zzafj != zzhb) {
            boolean[] zArr = new boolean[this.zzads.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhk[] zzhkArr = this.zzads;
                if (i < zzhkArr.length) {
                    zzhk zzhk = zzhkArr[i];
                    zArr[i] = zzhk.getState() != 0;
                    zznj zzba = zzhb.zzafy.zzbfh.zzba(i);
                    if (zzba != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzba == null || (zzhk.zzed() && zzhk.zzea() == this.zzafj.zzafr[i]))) {
                        if (zzhk == this.zzaev) {
                            this.zzaer.zza(this.zzaew);
                            this.zzaew = null;
                            this.zzaev = null;
                        }
                        zza(zzhk);
                        zzhk.disable();
                    }
                    i++;
                } else {
                    this.zzafj = zzhb;
                    this.zzadv.obtainMessage(3, zzhb.zzafy).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zzb(Object obj, int i) {
        this.zzadv.obtainMessage(6, new zzhc(this.zzaeg, obj, this.zzael, i)).sendToTarget();
    }

    private final void zzdq(long j) throws zzgq {
        zzhb zzhb = this.zzafj;
        long zzev = j + (zzhb == null ? 60000000 : zzhb.zzev());
        this.zzafg = zzev;
        this.zzaer.zzel(zzev);
        for (zzhk zzdm : this.zzaey) {
            zzdm.zzdm(this.zzafg);
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzael.zzafn < j) {
            return true;
        }
        zzhb zzhb = this.zzafj.zzafx;
        return zzhb != null && zzhb.zzafv;
    }

    private final void zzep() throws zzgq {
        this.zzafa = false;
        this.zzaer.start();
        for (zzhk start : this.zzaey) {
            start.start();
        }
    }

    private final void zzeq() throws zzgq {
        this.zzaer.stop();
        for (zzhk zza : this.zzaey) {
            zza(zza);
        }
    }

    private final void zzer() throws zzgq {
        zzhb zzhb = this.zzafj;
        if (zzhb != null) {
            long zzhp = zzhb.zzafp.zzhp();
            if (zzhp != -9223372036854775807L) {
                zzdq(zzhp);
            } else {
                zzhk zzhk = this.zzaev;
                if (zzhk == null || zzhk.zzfd()) {
                    this.zzafg = this.zzaer.zzgb();
                } else {
                    long zzgb = this.zzaew.zzgb();
                    this.zzafg = zzgb;
                    this.zzaer.zzel(zzgb);
                }
                zzhp = this.zzafg - this.zzafj.zzev();
            }
            this.zzael.zzafn = zzhp;
            this.zzafd = SystemClock.elapsedRealtime() * 1000;
            long zzhq = this.zzaey.length == 0 ? Long.MIN_VALUE : this.zzafj.zzafp.zzhq();
            zzha zzha = this.zzael;
            if (zzhq == Long.MIN_VALUE) {
                zzhq = this.zzaeg.zza(this.zzafj.zzafl, this.zzadz, false).zzaht;
            }
            zzha.zzafo = zzhq;
        }
    }

    private final void zzes() {
        zzi(true);
        this.zzaeq.onStopped();
        setState(1);
    }

    private final void zzet() throws IOException {
        zzhb zzhb = this.zzafh;
        if (zzhb != null && !zzhb.zzafv) {
            zzhb zzhb2 = this.zzafi;
            if (zzhb2 == null || zzhb2.zzafx == zzhb) {
                zzhk[] zzhkArr = this.zzaey;
                int length = zzhkArr.length;
                int i = 0;
                while (i < length) {
                    if (zzhkArr[i].zzeb()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzafh.zzafp.zzhn();
            }
        }
    }

    private final void zzeu() {
        zzhb zzhb = this.zzafh;
        long zzhm = !zzhb.zzafv ? 0 : zzhb.zzafp.zzhm();
        if (zzhm == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzev = this.zzafg - this.zzafh.zzev();
        boolean zzdt = this.zzaeq.zzdt(zzhm - zzev);
        zzh(zzdt);
        if (zzdt) {
            this.zzafh.zzafp.zzee(zzev);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzaef != z) {
            this.zzaef = z;
            this.zzadv.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        this.zzaes.removeMessages(2);
        this.zzafa = false;
        this.zzaer.stop();
        this.zzaew = null;
        this.zzaev = null;
        this.zzafg = 60000000;
        for (zzhk zzhk : this.zzaey) {
            try {
                zza(zzhk);
                zzhk.disable();
            } catch (zzgq | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzaey = new zzhk[0];
        zzhb zzhb = this.zzafj;
        if (zzhb == null) {
            zzhb = this.zzafh;
        }
        zza(zzhb);
        this.zzafh = null;
        this.zzafi = null;
        this.zzafj = null;
        zzh(false);
        if (z) {
            zzmk zzmk = this.zzaex;
            if (zzmk != null) {
                zzmk.zzhz();
                this.zzaex = null;
            }
            this.zzaeg = null;
        }
    }

    private final boolean zzq(int i) {
        this.zzaeg.zza(i, this.zzadz, false);
        return !this.zzaeg.zza(0, this.zzady, false).zzahp && this.zzaeg.zza(i, this.zzadz, this.zzady, this.repeatMode) == -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:217:0x037a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x043e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x043f, code lost:
        r2 = r0;
        r8.zzael = new com.google.android.gms.internal.ads.zzha(r3, r4);
        r3 = r8.zzadv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0449, code lost:
        if (r1 != false) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x044b, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x044d, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x044e, code lost:
        r3.obtainMessage(4, r1, 0, r8.zzael).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0457, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x0890, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x0891, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x0895, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0896, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x089a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x089b, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r2 = r8.zzadv;
        r1 = com.google.android.gms.internal.ads.zzgq.zza(r1);
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ca, code lost:
        monitor-enter(r34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r8.zzafc++;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0283 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0286 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x028a A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0348 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x035c A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0522 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0529 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0543 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0546 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0581 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0593 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x05af A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }, LOOP:8: B:333:0x05af->B:337:0x05c1, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x070c A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x07c5 A[Catch:{ all -> 0x043e, all -> 0x037a, all -> 0x00c8, all -> 0x00d5, all -> 0x00c4, zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }] */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x089a A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzgq -> 0x08c8, IOException -> 0x08b6, RuntimeException -> 0x089a }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0859;
                case 1: goto L_0x082e;
                case 2: goto L_0x0458;
                case 3: goto L_0x03a3;
                case 4: goto L_0x0382;
                case 5: goto L_0x037e;
                case 6: goto L_0x0367;
                case 7: goto L_0x0211;
                case 8: goto L_0x01dd;
                case 9: goto L_0x01ca;
                case 10: goto L_0x00d9;
                case 11: goto L_0x009b;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.repeatMode = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0026:
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzhb r4 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r4) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            com.google.android.gms.internal.ads.zzhp r11 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r12 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r13 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhq r14 = r8.zzady     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r11 = r11.zza((int) r12, (com.google.android.gms.internal.ads.zzhr) r13, (com.google.android.gms.internal.ads.zzhq) r14, (int) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r12 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == 0) goto L_0x0061
            if (r11 == r5) goto L_0x0061
            com.google.android.gms.internal.ads.zzhb r12 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r12 = r12.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 != r11) goto L_0x0061
            com.google.android.gms.internal.ads.zzhb r2 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r11 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r11) goto L_0x0056
            r11 = 1
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            r3 = r3 | r11
            com.google.android.gms.internal.ads.zzhb r11 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r11) goto L_0x005e
            r11 = 1
            goto L_0x005f
        L_0x005e:
            r11 = 0
        L_0x005f:
            r4 = r4 | r11
            goto L_0x0036
        L_0x0061:
            com.google.android.gms.internal.ads.zzhb r5 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r5 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzhb r5 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            zza((com.google.android.gms.internal.ads.zzhb) r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zzafx = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x006c:
            int r5 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r5 = r8.zzq(r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zzafu = r5     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 != 0) goto L_0x0078
            r8.zzafh = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0078:
            if (r3 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r3.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r8.zza((int) r2, (long) r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r5 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5.<init>(r2, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r5     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0091:
            int r2 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r15) goto L_0x009a
            if (r1 == 0) goto L_0x009a
            r8.setState(r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x009a:
            return r10
        L_0x009b:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzgu[] r1 = (com.google.android.gms.internal.ads.zzgu[]) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r1.length     // Catch:{ all -> 0x00c8 }
        L_0x00a0:
            if (r9 >= r2) goto L_0x00b0
            r3 = r1[r9]     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.internal.ads.zzgv r4 = r3.zzadp     // Catch:{ all -> 0x00c8 }
            int r5 = r3.zzadq     // Catch:{ all -> 0x00c8 }
            java.lang.Object r3 = r3.zzadr     // Catch:{ all -> 0x00c8 }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00c8 }
            int r9 = r9 + 1
            goto L_0x00a0
        L_0x00b0:
            com.google.android.gms.internal.ads.zzmk r1 = r8.zzaex     // Catch:{ all -> 0x00c8 }
            if (r1 == 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ all -> 0x00c8 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c8 }
        L_0x00b9:
            monitor-enter(r34)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r8.zzafc     // Catch:{ all -> 0x00c4 }
            int r1 = r1 + r10
            r8.zzafc = r1     // Catch:{ all -> 0x00c4 }
            r34.notifyAll()     // Catch:{ all -> 0x00c4 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c4 }
            return r10
        L_0x00c4:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c4 }
            throw r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r8.zzafc     // Catch:{ all -> 0x00d5 }
            int r2 = r2 + r10
            r8.zzafc = r2     // Catch:{ all -> 0x00d5 }
            r34.notifyAll()     // Catch:{ all -> 0x00d5 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d5 }
            throw r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x00d5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00d5 }
            throw r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x00d9:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x01c9
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = 1
        L_0x00e0:
            if (r1 == 0) goto L_0x01c9
            boolean r3 = r1.zzafv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 != 0) goto L_0x00e8
            goto L_0x01c9
        L_0x00e8:
            boolean r3 = r1.zzex()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != r3) goto L_0x00f3
            r2 = 0
        L_0x00f3:
            com.google.android.gms.internal.ads.zzhb r1 = r1.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x00e0
        L_0x00f6:
            if (r2 == 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == r3) goto L_0x0100
            r2 = 1
            goto L_0x0101
        L_0x0100:
            r2 = 0
        L_0x0101:
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            zza((com.google.android.gms.internal.ads.zzhb) r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzafx = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafh = r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafi = r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhk[] r3 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r3 = r3.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r4 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r5 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r5.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r4.zza(r11, r2, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r2 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r2.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzha r2 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zzafn = r4     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzdq(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0132:
            com.google.android.gms.internal.ads.zzhk[] r2 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r4 = 0
            r5 = 0
        L_0x0139:
            com.google.android.gms.internal.ads.zzhk[] r11 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r11 = r11.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 >= r11) goto L_0x0185
            com.google.android.gms.internal.ads.zzhk[] r11 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11 = r11[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r12 = r11.getState()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == 0) goto L_0x014a
            r12 = 1
            goto L_0x014b
        L_0x014a:
            r12 = 0
        L_0x014b:
            r2[r4] = r12     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r12 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmt[] r12 = r12.zzafr     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12 = r12[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == 0) goto L_0x0157
            int r5 = r5 + 1
        L_0x0157:
            boolean r13 = r2[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r13 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zzmt r13 = r11.zzea()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == r13) goto L_0x0179
            com.google.android.gms.internal.ads.zzhk r13 = r8.zzaev     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r11 != r13) goto L_0x0172
            if (r12 != 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzot r12 = r8.zzaer     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzol r13 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12.zza(r13)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x016e:
            r8.zzaew = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaev = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0172:
            zza((com.google.android.gms.internal.ads.zzhk) r11)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11.disable()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0182
        L_0x0179:
            boolean r12 = r3[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == 0) goto L_0x0182
            long r12 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11.zzdm(r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0182:
            int r4 = r4 + 1
            goto L_0x0139
        L_0x0185:
            com.google.android.gms.internal.ads.zzdns r3 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznq r1 = r1.zzafy     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zza((boolean[]) r2, (int) r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x01be
        L_0x0194:
            r8.zzafh = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0196:
            com.google.android.gms.internal.ads.zzhb r1 = r1.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x019e
            r1.release()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0196
        L_0x019e:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzafx = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r1 = r1.zzafv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x01be
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r3.zzev()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzb(r1, r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x01be:
            r34.zzeu()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzer()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendEmptyMessage(r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x01c9:
            return r10
        L_0x01ca:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r1 = (com.google.android.gms.internal.ads.zzmi) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r2 = r2.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == r1) goto L_0x01d9
            goto L_0x01dc
        L_0x01d9:
            r34.zzeu()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x01dc:
            return r10
        L_0x01dd:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r1 = (com.google.android.gms.internal.ads.zzmi) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x0210
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r2 = r2.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == r1) goto L_0x01ec
            goto L_0x0210
        L_0x01ec:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzafv = r10     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzex()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r1.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r1.zzb(r2, r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzafm = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != 0) goto L_0x020d
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafi = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzdq(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzb((com.google.android.gms.internal.ads.zzhb) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x020d:
            r34.zzeu()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0210:
            return r10
        L_0x0211:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r3 = r1.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r3 = (com.google.android.gms.internal.ads.zzhp) r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaeg = r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r1 = r1.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x027e
            int r4 = r8.zzafe     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 <= 0) goto L_0x0250
            com.google.android.gms.internal.ads.zzhd r3 = r8.zzaff     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.util.Pair r3 = r8.zza((com.google.android.gms.internal.ads.zzhd) r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r4 = r8.zzafe     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafe = r9     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaff = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 != 0) goto L_0x0238
        L_0x0233:
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0366
        L_0x0238:
            com.google.android.gms.internal.ads.zzha r7 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r11 = r3.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r11 = r11.intValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r3 = r3.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r14 = r3.longValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r7.<init>(r11, r14)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r7     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x027f
        L_0x0250:
            com.google.android.gms.internal.ads.zzha r4 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r14 = r4.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x027e
            boolean r3 = r3.isEmpty()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 == 0) goto L_0x0263
            r8.zza((java.lang.Object) r1, (int) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0366
        L_0x0263:
            android.util.Pair r3 = r8.zzb((int) r9, (long) r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r4 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r7 = r3.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r7 = r7.intValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r3 = r3.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r14 = r3.longValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r4.<init>(r7, r14)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r4     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x027e:
            r4 = 0
        L_0x027f:
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 == 0) goto L_0x0286
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0288
        L_0x0286:
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0288:
            if (r3 == 0) goto L_0x0363
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r11 = r3.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r7 = r7.zzc(r11)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 != r5) goto L_0x02e8
            int r6 = r3.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r8.zza((int) r6, (com.google.android.gms.internal.ads.zzhp) r2, (com.google.android.gms.internal.ads.zzhp) r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != r5) goto L_0x029f
            goto L_0x0233
        L_0x029f:
            com.google.android.gms.internal.ads.zzhp r6 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r6.zza((int) r2, (com.google.android.gms.internal.ads.zzhr) r7, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.util.Pair r2 = r8.zzb((int) r9, (long) r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r6 = r2.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r6 = r6.intValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r2 = r2.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r2.longValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza((int) r6, (com.google.android.gms.internal.ads.zzhr) r7, (boolean) r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r2 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r2 = r2.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzafl = r5     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x02c7:
            com.google.android.gms.internal.ads.zzhb r7 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == 0) goto L_0x02db
            com.google.android.gms.internal.ads.zzhb r3 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r7 = r3.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r7 = r7.equals(r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == 0) goto L_0x02d7
            r7 = r6
            goto L_0x02d8
        L_0x02d7:
            r7 = -1
        L_0x02d8:
            r3.zzafl = r7     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x02c7
        L_0x02db:
            long r2 = r8.zza((int) r6, (long) r11)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r5 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5.<init>(r6, r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r5     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0363
        L_0x02e8:
            boolean r2 = r8.zzq(r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzc(r7, r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 != r2) goto L_0x02f5
            r2 = 1
            goto L_0x02f6
        L_0x02f5:
            r2 = 0
        L_0x02f6:
            com.google.android.gms.internal.ads.zzha r11 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r11 = r11.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == r11) goto L_0x030f
            com.google.android.gms.internal.ads.zzha r11 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r12 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r13 = r11.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12.<init>(r7, r13)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r13 = r11.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12.zzafn = r13     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r13 = r11.zzafo     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12.zzafo = r13     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r12     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x030f:
            com.google.android.gms.internal.ads.zzhb r11 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r11 == 0) goto L_0x0363
            com.google.android.gms.internal.ads.zzhb r11 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r12 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r13 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhq r14 = r8.zzady     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r15 = r8.repeatMode     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r7 = r12.zza((int) r7, (com.google.android.gms.internal.ads.zzhr) r13, (com.google.android.gms.internal.ads.zzhq) r14, (int) r15)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == r5) goto L_0x0346
            java.lang.Object r12 = r11.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r13 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r14 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r13 = r13.zza((int) r7, (com.google.android.gms.internal.ads.zzhr) r14, (boolean) r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r13 = r13.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r12 = r12.equals(r13)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r12 == 0) goto L_0x0346
            boolean r3 = r8.zzq(r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11.zzc(r7, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r11 != r3) goto L_0x0342
            r3 = 1
            goto L_0x0343
        L_0x0342:
            r3 = 0
        L_0x0343:
            r2 = r2 | r3
            r3 = r11
            goto L_0x030f
        L_0x0346:
            if (r2 != 0) goto L_0x035c
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r5 = r3.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r5 = r8.zza((int) r2, (long) r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r3 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.<init>(r2, r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0363
        L_0x035c:
            r8.zzafh = r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzafx = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            zza((com.google.android.gms.internal.ads.zzhb) r11)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0363:
            r8.zzb((java.lang.Object) r1, (int) r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0366:
            return r10
        L_0x0367:
            r8.zzi(r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhj r1 = r8.zzaeq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzfb()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.setState(r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            monitor-enter(r34)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaez = r10     // Catch:{ all -> 0x037a }
            r34.notifyAll()     // Catch:{ all -> 0x037a }
            monitor-exit(r34)     // Catch:{ all -> 0x037a }
            return r10
        L_0x037a:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x037a }
            throw r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x037e:
            r34.zzes()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            return r10
        L_0x0382:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhl r1 = (com.google.android.gms.internal.ads.zzhl) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzol r2 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x0391
            com.google.android.gms.internal.ads.zzol r2 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhl r1 = r2.zzb(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0397
        L_0x0391:
            com.google.android.gms.internal.ads.zzot r2 = r8.zzaer     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhl r1 = r2.zzb(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0397:
            r8.zzaek = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            return r10
        L_0x03a3:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhd r1 = (com.google.android.gms.internal.ads.zzhd) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x03b4
            int r2 = r8.zzafe     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2 + r10
            r8.zzafe = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaff = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x043d
        L_0x03b4:
            android.util.Pair r2 = r8.zza((com.google.android.gms.internal.ads.zzhd) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x03d8
            com.google.android.gms.internal.ads.zzha r1 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.<init>(r9, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r1 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.<init>(r9, r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.setState(r15)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzi(r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x043d
        L_0x03d8:
            long r3 = r1.zzagc     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03e0
            r1 = 1
            goto L_0x03e1
        L_0x03e0:
            r1 = 0
        L_0x03e1:
            java.lang.Object r3 = r2.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r3 = r3.intValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r2 = r2.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r2.longValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r2 = r8.zzael     // Catch:{ all -> 0x043e }
            int r2 = r2.zzafl     // Catch:{ all -> 0x043e }
            if (r3 != r2) goto L_0x041c
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzha r2 = r8.zzael     // Catch:{ all -> 0x043e }
            long r13 = r2.zzafn     // Catch:{ all -> 0x043e }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x041c
            com.google.android.gms.internal.ads.zzha r2 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.<init>(r3, r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0411
            r1 = 1
            goto L_0x0412
        L_0x0411:
            r1 = 0
        L_0x0412:
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0418:
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x043d
        L_0x041c:
            long r6 = r8.zza((int) r3, (long) r4)     // Catch:{ all -> 0x043e }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0426
            r2 = 1
            goto L_0x0427
        L_0x0426:
            r2 = 0
        L_0x0427:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzha r2 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.<init>(r3, r6)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0435
            r1 = 1
            goto L_0x0436
        L_0x0435:
            r1 = 0
        L_0x0436:
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0418
        L_0x043d:
            return r10
        L_0x043e:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzha r6 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r6.<init>(r3, r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r6     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r3 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x044d
            r1 = 1
            goto L_0x044e
        L_0x044d:
            r1 = 0
        L_0x044e:
            com.google.android.gms.internal.ads.zzha r4 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            throw r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0458:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != 0) goto L_0x0468
            com.google.android.gms.internal.ads.zzmk r1 = r8.zzaex     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzhy()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r14 = r5
            goto L_0x06bd
        L_0x0468:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != 0) goto L_0x0471
            com.google.android.gms.internal.ads.zzha r1 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r1.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x04af
        L_0x0471:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r1.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r2 = r2.zzafu     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x04bc
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r2 = r2.zzew()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x04bc
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r2 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzhr) r7, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r14 = r2.zzaht     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0492
            goto L_0x04bc
        L_0x0492:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x04a3
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.index     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r7 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r7 = r7.index     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04bc
        L_0x04a3:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhq r14 = r8.zzady     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r15 = r8.repeatMode     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzhr) r7, (com.google.android.gms.internal.ads.zzhq) r14, (int) r15)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x04af:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.zzff()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 < r2) goto L_0x04bf
            com.google.android.gms.internal.ads.zzmk r1 = r8.zzaex     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzhy()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x04bc:
            r14 = r5
            goto L_0x058f
        L_0x04bf:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x04c9
            com.google.android.gms.internal.ads.zzha r2 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r2.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x04c7:
            r14 = r5
            goto L_0x051e
        L_0x04c9:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzhr) r7, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhq r7 = r8.zzady     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza((int) r9, (com.google.android.gms.internal.ads.zzhq) r7, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x04da
            goto L_0x04c7
        L_0x04da:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1.zzev()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r14 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r14 = r14.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r15 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r7 = r7.zza((int) r14, (com.google.android.gms.internal.ads.zzhr) r15, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r14 = r7.zzaht     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1 + r14
            long r14 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzhp r7 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x058f
            java.lang.Object r2 = r1.first     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.intValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r1 = r1.second     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r1.longValue()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1 = r2
        L_0x051e:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x0529
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x0526:
            r23 = r5
            goto L_0x053f
        L_0x0529:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r5 = r2.zzev()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r7 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r7 = r7.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r11 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r2 = r2.zza((int) r7, (com.google.android.gms.internal.ads.zzhr) r11, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r12 = r2.zzaht     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r5 = r5 + r12
            goto L_0x0526
        L_0x053f:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x0546
            r29 = 0
            goto L_0x054d
        L_0x0546:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.index     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2 + r10
            r29 = r2
        L_0x054d:
            boolean r31 = r8.zzq(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r5 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzhr) r5, (boolean) r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = new com.google.android.gms.internal.ads.zzhb     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhk[] r5 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhn[] r6 = r8.zzaep     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzno r7 = r8.zzadt     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhj r11 = r8.zzaeq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmk r12 = r8.zzaex     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r13 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            java.lang.Object r13 = r13.zzafq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0585
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzafx = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0585:
            r8.zzafh = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r1 = r2.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zza(r8, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzh(r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x058f:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x05a8
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r1 = r1.zzew()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x059c
            goto L_0x05a8
        L_0x059c:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x05ab
            boolean r1 = r8.zzaef     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != 0) goto L_0x05ab
            r34.zzeu()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x05ab
        L_0x05a8:
            r8.zzh(r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x05ab:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x06bd
        L_0x05af:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == r2) goto L_0x05ec
            long r1 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r3.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r3.zzaft     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x05ec
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.release()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r1.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzb((com.google.android.gms.internal.ads.zzhb) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r1 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r3.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.<init>(r2, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzer()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = 5
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x05af
        L_0x05ec:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r1 = r1.zzafu     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0616
            r1 = 0
        L_0x05f3:
            com.google.android.gms.internal.ads.zzhk[] r2 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 >= r2) goto L_0x06bd
            com.google.android.gms.internal.ads.zzhk[] r2 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = r2[r1]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmt[] r3 = r3.zzafr     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3 = r3[r1]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 == 0) goto L_0x0613
            com.google.android.gms.internal.ads.zzmt r4 = r2.zzea()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 != r3) goto L_0x0613
            boolean r3 = r2.zzeb()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 == 0) goto L_0x0613
            r2.zzec()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0613:
            int r1 = r1 + 1
            goto L_0x05f3
        L_0x0616:
            r1 = 0
        L_0x0617:
            com.google.android.gms.internal.ads.zzhk[] r2 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 >= r2) goto L_0x0639
            com.google.android.gms.internal.ads.zzhk[] r2 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = r2[r1]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmt[] r3 = r3.zzafr     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3 = r3[r1]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmt r4 = r2.zzea()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 != r3) goto L_0x06bd
            if (r3 == 0) goto L_0x0636
            boolean r2 = r2.zzeb()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x0636
            goto L_0x06bd
        L_0x0636:
            int r1 = r1 + 1
            goto L_0x0617
        L_0x0639:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r1.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x06bd
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r1.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r1 = r1.zzafv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x06bd
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznq r1 = r1.zzafy     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r2.zzafx     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafi = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznq r3 = r2.zzafy     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r2 = r2.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r2.zzhp()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0664
            r2 = 1
            goto L_0x0665
        L_0x0664:
            r2 = 0
        L_0x0665:
            r4 = 0
        L_0x0666:
            com.google.android.gms.internal.ads.zzhk[] r5 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r5 = r5.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r4 >= r5) goto L_0x06bd
            com.google.android.gms.internal.ads.zzhk[] r5 = r8.zzads     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5 = r5[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznl r6 = r1.zzbfh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznj r6 = r6.zzba(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r6 == 0) goto L_0x06ba
            if (r2 != 0) goto L_0x06b7
            boolean r6 = r5.zzed()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r6 != 0) goto L_0x06ba
            com.google.android.gms.internal.ads.zznl r6 = r3.zzbfh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zznj r6 = r6.zzba(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhm[] r7 = r1.zzbfj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r7 = r7[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhm[] r11 = r3.zzbfj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11 = r11[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r6 == 0) goto L_0x06b7
            boolean r7 = r11.equals(r7)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == 0) goto L_0x06b7
            int r7 = r6.length()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhf[] r11 = new com.google.android.gms.internal.ads.zzhf[r7]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r12 = 0
        L_0x069c:
            if (r12 >= r7) goto L_0x06a7
            com.google.android.gms.internal.ads.zzhf r13 = r6.zzax(r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11[r12] = r13     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r12 = r12 + 1
            goto L_0x069c
        L_0x06a7:
            com.google.android.gms.internal.ads.zzhb r6 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmt[] r6 = r6.zzafr     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r6 = r6[r4]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r7 = r8.zzafi     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r12 = r7.zzev()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5.zza(r11, r6, r12)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x06ba
        L_0x06b7:
            r5.zzec()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x06ba:
            int r4 = r4 + 1
            goto L_0x0666
        L_0x06bd:
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = 10
            if (r1 != 0) goto L_0x06cb
            r34.zzet()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zza((long) r14, (long) r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x082d
        L_0x06cb:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzow.beginSection(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzer()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r1 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r1 = r1.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzha r4 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r4 = r4.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.zzef(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhk[] r1 = r8.zzaey     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r4 = r1.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06e4:
            if (r5 >= r4) goto L_0x071b
            r11 = r1[r5]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r12 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r8.zzafd     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r11.zzb(r12, r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == 0) goto L_0x06f9
            boolean r2 = r11.zzfd()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x06f9
            r7 = 1
            goto L_0x06fa
        L_0x06f9:
            r7 = 0
        L_0x06fa:
            boolean r2 = r11.isReady()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x0709
            boolean r2 = r11.zzfd()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x0707
            goto L_0x0709
        L_0x0707:
            r2 = 0
            goto L_0x070a
        L_0x0709:
            r2 = 1
        L_0x070a:
            if (r2 != 0) goto L_0x070f
            r11.zzee()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x070f:
            if (r6 == 0) goto L_0x0715
            if (r2 == 0) goto L_0x0715
            r6 = 1
            goto L_0x0716
        L_0x0715:
            r6 = 0
        L_0x0716:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06e4
        L_0x071b:
            if (r6 != 0) goto L_0x0720
            r34.zzet()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0720:
            com.google.android.gms.internal.ads.zzol r1 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0745
            com.google.android.gms.internal.ads.zzol r1 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzfr()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzaek     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r2 = r1.equals(r2)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x0745
            r8.zzaek = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzot r2 = r8.zzaer     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzol r3 = r8.zzaew     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza(r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendToTarget()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0745:
            com.google.android.gms.internal.ads.zzhp r1 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r2.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r3 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzhr) r3, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r1 = r1.zzaht     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r7 == 0) goto L_0x0776
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0766
            com.google.android.gms.internal.ads.zzha r3 = r8.zzael     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r3 = r3.zzafn     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0776
        L_0x0766:
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r3 = r3.zzafu     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 == 0) goto L_0x0776
            r3 = 4
            r8.setState(r3)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzeq()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r4 = 2
            goto L_0x07f6
        L_0x0776:
            int r3 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r4 = 2
            if (r3 != r4) goto L_0x07db
            com.google.android.gms.internal.ads.zzhk[] r3 = r8.zzaey     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r3 = r3.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 <= 0) goto L_0x07c9
            if (r6 == 0) goto L_0x07c7
            boolean r1 = r8.zzafa     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r2 = r2.zzafv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 != 0) goto L_0x078f
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r2.zzafm     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0797
        L_0x078f:
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmi r2 = r2.zzafp     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r2.zzhq()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0797:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07b3
            com.google.android.gms.internal.ads.zzhb r2 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r2 = r2.zzafu     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r2 == 0) goto L_0x07a5
            r1 = 1
            goto L_0x07c3
        L_0x07a5:
            com.google.android.gms.internal.ads.zzhp r2 = r8.zzaeg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r3 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r3 = r3.zzafl     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r5 = r8.zzadz     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhr r2 = r2.zza((int) r3, (com.google.android.gms.internal.ads.zzhr) r5, (boolean) r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r2 = r2.zzaht     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07b3:
            com.google.android.gms.internal.ads.zzhj r5 = r8.zzaeq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhb r6 = r8.zzafh     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r8.zzafg     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r6 = r6.zzev()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07c3:
            if (r1 == 0) goto L_0x07c7
            r1 = 1
            goto L_0x07cd
        L_0x07c7:
            r1 = 0
            goto L_0x07cd
        L_0x07c9:
            boolean r1 = r8.zzdr(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07cd:
            if (r1 == 0) goto L_0x07f6
            r1 = 3
            r8.setState(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            boolean r1 = r8.zzaeb     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x07f6
            r34.zzep()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x07f6
        L_0x07db:
            int r3 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5 = 3
            if (r3 != r5) goto L_0x07f6
            com.google.android.gms.internal.ads.zzhk[] r3 = r8.zzaey     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r3 = r3.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r3 <= 0) goto L_0x07e6
            goto L_0x07ea
        L_0x07e6:
            boolean r6 = r8.zzdr(r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07ea:
            if (r6 != 0) goto L_0x07f6
            boolean r1 = r8.zzaeb     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzafa = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.setState(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzeq()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07f6:
            int r1 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != r4) goto L_0x0807
            com.google.android.gms.internal.ads.zzhk[] r1 = r8.zzaey     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r2 = r1.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x07fd:
            if (r9 >= r2) goto L_0x0807
            r3 = r1[r9]     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzee()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r9 = r9 + 1
            goto L_0x07fd
        L_0x0807:
            boolean r1 = r8.zzaeb     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0810
            int r1 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = 3
            if (r1 == r2) goto L_0x0814
        L_0x0810:
            int r1 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != r4) goto L_0x081a
        L_0x0814:
            r1 = 10
            r8.zza((long) r14, (long) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x082a
        L_0x081a:
            com.google.android.gms.internal.ads.zzhk[] r1 = r8.zzaey     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r1.length     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0825
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.zza((long) r14, (long) r1)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x082a
        L_0x0825:
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.removeMessages(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x082a:
            com.google.android.gms.internal.ads.zzow.endSection()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x082d:
            return r10
        L_0x082e:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0835
            r1 = 1
            goto L_0x0836
        L_0x0835:
            r1 = 0
        L_0x0836:
            r8.zzafa = r9     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzaeb = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != 0) goto L_0x0843
            r34.zzeq()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r34.zzer()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0858
        L_0x0843:
            int r1 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2 = 3
            if (r1 != r2) goto L_0x0851
            r34.zzep()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x084d:
            r1.sendEmptyMessage(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x0858
        L_0x0851:
            int r1 = r8.state     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 != r4) goto L_0x0858
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            goto L_0x084d
        L_0x0858:
            return r10
        L_0x0859:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzmk r2 = (com.google.android.gms.internal.ads.zzmk) r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            int r1 = r1.arg1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0864
            r1 = 1
            goto L_0x0865
        L_0x0864:
            r1 = 0
        L_0x0865:
            com.google.android.gms.internal.ads.zzdns r3 = r8.zzadv     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.sendEmptyMessage(r9)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzi(r10)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzhj r3 = r8.zzaeq     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r3.zzfa()     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            if (r1 == 0) goto L_0x0880
            com.google.android.gms.internal.ads.zzha r1 = new com.google.android.gms.internal.ads.zzha     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.zzael = r1     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
        L_0x0880:
            r8.zzaex = r2     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzgt r1 = r8.zzaeu     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r2.zza(r1, r10, r8)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r8.setState(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            com.google.android.gms.internal.ads.zzdns r1 = r8.zzaes     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            r1.sendEmptyMessage(r4)     // Catch:{ zzgq -> 0x0895, IOException -> 0x0890, RuntimeException -> 0x089a }
            return r10
        L_0x0890:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08ba
        L_0x0895:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08cc
        L_0x089a:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv
            com.google.android.gms.internal.ads.zzgq r1 = com.google.android.gms.internal.ads.zzgq.zza((java.lang.RuntimeException) r1)
            r3 = 8
        L_0x08ab:
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzes()
            return r10
        L_0x08b6:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08ba:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv
            com.google.android.gms.internal.ads.zzgq r1 = com.google.android.gms.internal.ads.zzgq.zza((java.io.IOException) r1)
            goto L_0x08ab
        L_0x08c8:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08cc:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            com.google.android.gms.internal.ads.zzdns r2 = r8.zzadv
            goto L_0x08ab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzaez     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzdns r0 = r2.zzaes     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzaez     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzaet     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0028
        L_0x0027:
            throw r0
        L_0x0028:
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.release():void");
    }

    public final void stop() {
        this.zzaes.sendEmptyMessage(5);
    }

    public final void zza(zzhp zzhp, int i, long j) {
        this.zzaes.obtainMessage(3, new zzhd(zzhp, i, j)).sendToTarget();
    }

    public final void zza(zzmi zzmi) {
        this.zzaes.obtainMessage(8, zzmi).sendToTarget();
    }

    public final void zza(zzmk zzmk, boolean z) {
        this.zzaes.obtainMessage(0, 1, 0, zzmk).sendToTarget();
    }

    public final /* synthetic */ void zza(zzmw zzmw) {
        this.zzaes.obtainMessage(9, (zzmi) zzmw).sendToTarget();
    }

    public final void zza(zzgu... zzguArr) {
        if (this.zzaez) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzafb++;
        this.zzaes.obtainMessage(11, zzguArr).sendToTarget();
    }

    public final void zzb(zzhp zzhp, Object obj) {
        this.zzaes.obtainMessage(7, Pair.create(zzhp, obj)).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzgu... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzaez     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzafb     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzafb = r1     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzdns r1 = r3.zzaes     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzafc     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0035
        L_0x0034:
            throw r4
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.zzb(com.google.android.gms.internal.ads.zzgu[]):void");
    }

    public final void zzeo() {
        this.zzaes.sendEmptyMessage(10);
    }

    public final void zzg(boolean z) {
        this.zzaes.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }
}
