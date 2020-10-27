package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzmb implements zzog {
    private final Uri uri;
    private final zznu zzans;
    private final /* synthetic */ zzly zzbau;
    private final zzme zzbbc;
    private final zzoj zzbbd;
    private final zzjs zzbbw = new zzjs();
    private volatile boolean zzbbx;
    private boolean zzbby = true;
    private long zzbbz;
    /* access modifiers changed from: private */
    public long zzce = -1;

    public zzmb(zzly zzly, Uri uri2, zznu zznu, zzme zzme, zzoj zzoj) {
        this.zzbau = zzly;
        this.uri = (Uri) zzoh.checkNotNull(uri2);
        this.zzans = (zznu) zzoh.checkNotNull(zznu);
        this.zzbbc = (zzme) zzoh.checkNotNull(zzme);
        this.zzbbd = zzoj;
    }

    public final void cancelLoad() {
        this.zzbbx = true;
    }

    public final void zze(long j, long j2) {
        this.zzbbw.position = j;
        this.zzbbz = j2;
        this.zzbby = true;
    }

    public final boolean zzhw() {
        return this.zzbbx;
    }

    public final void zzhx() throws IOException, InterruptedException {
        int i = 0;
        while (i == 0 && !this.zzbbx) {
            zzjj zzjj = null;
            try {
                long j = this.zzbbw.position;
                long zza = this.zzans.zza(new zznv(this.uri, j, -1, this.zzbau.zzbaz));
                this.zzce = zza;
                if (zza != -1) {
                    this.zzce = zza + j;
                }
                zzjj zzjj2 = new zzjj(this.zzans, j, this.zzce);
                try {
                    zzjm zza2 = this.zzbbc.zza(zzjj2, this.zzans.getUri());
                    if (this.zzbby) {
                        zza2.zzc(j, this.zzbbz);
                        this.zzbby = false;
                    }
                    while (i == 0 && !this.zzbbx) {
                        this.zzbbd.block();
                        i = zza2.zza(zzjj2, this.zzbbw);
                        if (zzjj2.getPosition() > this.zzbau.zzbba + j) {
                            j = zzjj2.getPosition();
                            this.zzbbd.zzit();
                            this.zzbau.zzaes.post(this.zzbau.zzbbf);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbbw.position = zzjj2.getPosition();
                    }
                    zzov.zza(this.zzans);
                } catch (Throwable th) {
                    th = th;
                    zzjj = zzjj2;
                    this.zzbbw.position = zzjj.getPosition();
                    zzov.zza(this.zzans);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!(i == 1 || zzjj == null)) {
                    this.zzbbw.position = zzjj.getPosition();
                }
                zzov.zza(this.zzans);
                throw th;
            }
        }
    }
}
