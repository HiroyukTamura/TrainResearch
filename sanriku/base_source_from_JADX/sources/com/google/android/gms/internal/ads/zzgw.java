package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import p009e.p010a.p011a.p012a.C0681a;

final class zzgw implements zzgt {
    private int repeatMode;
    private final zzhk[] zzads;
    private final zzno zzadt;
    private final zznl zzadu;
    private final zzdns zzadv;
    private final zzgy zzadw;
    private final CopyOnWriteArraySet<zzgs> zzadx;
    private final zzhq zzady;
    private final zzhr zzadz;
    private boolean zzaea;
    private boolean zzaeb;
    private int zzaec;
    private int zzaed;
    private int zzaee;
    private boolean zzaef;
    private zzhp zzaeg;
    private Object zzaeh;
    private zzna zzaei;
    private zznl zzaej;
    private zzhl zzaek;
    private zzha zzael;
    private int zzaem;
    private int zzaen;
    private long zzaeo;

    @SuppressLint({"HandlerLeak"})
    public zzgw(zzhk[] zzhkArr, zzno zzno, zzhj zzhj) {
        String str = zzov.zzbhv;
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 26));
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzoh.checkState(zzhkArr.length > 0);
        this.zzads = (zzhk[]) zzoh.checkNotNull(zzhkArr);
        this.zzadt = (zzno) zzoh.checkNotNull(zzno);
        this.zzaeb = false;
        this.repeatMode = 0;
        this.zzaec = 1;
        this.zzadx = new CopyOnWriteArraySet<>();
        this.zzadu = new zznl(new zznj[zzhkArr.length]);
        this.zzaeg = zzhp.zzahk;
        this.zzady = new zzhq();
        this.zzadz = new zzhr();
        this.zzaei = zzna.zzbee;
        this.zzaej = this.zzadu;
        this.zzaek = zzhl.zzahe;
        this.zzadv = new zzgz(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        zzha zzha = new zzha(0, 0);
        this.zzael = zzha;
        this.zzadw = new zzgy(zzhkArr, zzno, zzhj, this.zzaeb, 0, this.zzadv, zzha, this);
    }

    private final int zzen() {
        if (this.zzaeg.isEmpty() || this.zzaed > 0) {
            return this.zzaem;
        }
        this.zzaeg.zza(this.zzael.zzafl, this.zzadz, false);
        return 0;
    }

    public final long getBufferedPosition() {
        if (this.zzaeg.isEmpty() || this.zzaed > 0) {
            return this.zzaeo;
        }
        this.zzaeg.zza(this.zzael.zzafl, this.zzadz, false);
        return zzgr.zzdo(this.zzael.zzafo) + this.zzadz.zzfg();
    }

    public final long getDuration() {
        if (this.zzaeg.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzgr.zzdo(this.zzaeg.zza(zzen(), this.zzady, false).zzaht);
    }

    public final int getPlaybackState() {
        return this.zzaec;
    }

    public final void release() {
        this.zzadw.release();
        this.zzadv.removeCallbacksAndMessages((Object) null);
    }

    public final void seekTo(long j) {
        int zzen = zzen();
        if (zzen < 0 || (!this.zzaeg.isEmpty() && zzen >= this.zzaeg.zzfe())) {
            throw new zzhg(this.zzaeg, zzen, j);
        }
        this.zzaed++;
        this.zzaem = zzen;
        if (!this.zzaeg.isEmpty()) {
            this.zzaeg.zza(zzen, this.zzady, false);
            long zzdp = this.zzady.zzahu + (j == -9223372036854775807L ? this.zzady.zzahs : zzgr.zzdp(j));
            long j2 = this.zzaeg.zza(0, this.zzadz, false).zzaht;
            if (j2 != -9223372036854775807L) {
                int i = (zzdp > j2 ? 1 : (zzdp == j2 ? 0 : -1));
            }
        }
        this.zzaen = 0;
        if (j == -9223372036854775807L) {
            this.zzaeo = 0;
            this.zzadw.zza(this.zzaeg, zzen, -9223372036854775807L);
            return;
        }
        this.zzaeo = j;
        this.zzadw.zza(this.zzaeg, zzen, zzgr.zzdp(j));
        Iterator<zzgs> it = this.zzadx.iterator();
        while (it.hasNext()) {
            it.next().zzej();
        }
    }

    public final void stop() {
        this.zzadw.stop();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzaee--;
                return;
            case 1:
                this.zzaec = message.arg1;
                Iterator<zzgs> it = this.zzadx.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzaeb, this.zzaec);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzaef = z;
                Iterator<zzgs> it2 = this.zzadx.iterator();
                while (it2.hasNext()) {
                    it2.next().zzf(this.zzaef);
                }
                return;
            case 3:
                if (this.zzaee == 0) {
                    zznq zznq = (zznq) message.obj;
                    this.zzaea = true;
                    this.zzaei = zznq.zzbfg;
                    this.zzaej = zznq.zzbfh;
                    this.zzadt.zzd(zznq.zzbfi);
                    Iterator<zzgs> it3 = this.zzadx.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzaei, this.zzaej);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzaed - 1;
                this.zzaed = i;
                if (i == 0) {
                    this.zzael = (zzha) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzgs> it4 = this.zzadx.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzej();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzaed == 0) {
                    this.zzael = (zzha) message.obj;
                    Iterator<zzgs> it5 = this.zzadx.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzej();
                    }
                    return;
                }
                return;
            case 6:
                zzhc zzhc = (zzhc) message.obj;
                this.zzaed -= zzhc.zzaga;
                if (this.zzaee == 0) {
                    this.zzaeg = zzhc.zzaeg;
                    this.zzaeh = zzhc.zzaeh;
                    this.zzael = zzhc.zzael;
                    Iterator<zzgs> it6 = this.zzadx.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzaeg, this.zzaeh);
                    }
                    return;
                }
                return;
            case 7:
                zzhl zzhl = (zzhl) message.obj;
                if (!this.zzaek.equals(zzhl)) {
                    this.zzaek = zzhl;
                    Iterator<zzgs> it7 = this.zzadx.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzhl);
                    }
                    return;
                }
                return;
            case 8:
                zzgq zzgq = (zzgq) message.obj;
                Iterator<zzgs> it8 = this.zzadx.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzgq);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final void zza(zzgs zzgs) {
        this.zzadx.add(zzgs);
    }

    public final void zza(zzmk zzmk) {
        if (!this.zzaeg.isEmpty() || this.zzaeh != null) {
            this.zzaeg = zzhp.zzahk;
            this.zzaeh = null;
            Iterator<zzgs> it = this.zzadx.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzaeg, this.zzaeh);
            }
        }
        if (this.zzaea) {
            this.zzaea = false;
            this.zzaei = zzna.zzbee;
            this.zzaej = this.zzadu;
            this.zzadt.zzd((Object) null);
            Iterator<zzgs> it2 = this.zzadx.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzaei, this.zzaej);
            }
        }
        this.zzaee++;
        this.zzadw.zza(zzmk, true);
    }

    public final void zza(zzgu... zzguArr) {
        this.zzadw.zza(zzguArr);
    }

    public final void zzb(zzgs zzgs) {
        this.zzadx.remove(zzgs);
    }

    public final void zzb(zzgu... zzguArr) {
        this.zzadw.zzb(zzguArr);
    }

    public final boolean zzek() {
        return this.zzaeb;
    }

    public final int zzel() {
        return this.zzads.length;
    }

    public final long zzem() {
        if (this.zzaeg.isEmpty() || this.zzaed > 0) {
            return this.zzaeo;
        }
        this.zzaeg.zza(this.zzael.zzafl, this.zzadz, false);
        return zzgr.zzdo(this.zzael.zzafn) + this.zzadz.zzfg();
    }

    public final void zzg(boolean z) {
        if (this.zzaeb != z) {
            this.zzaeb = z;
            this.zzadw.zzg(z);
            Iterator<zzgs> it = this.zzadx.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzaec);
            }
        }
    }
}
