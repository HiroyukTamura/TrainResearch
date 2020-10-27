package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.jvm.internal.LongCompanionObject;

public abstract class zzgp implements zzhk, zzhn {
    private int index;
    private int state;
    private final int zzade;
    private zzhm zzadf;
    private zzmt zzadg;
    private long zzadh;
    private boolean zzadi = true;
    private boolean zzadj;

    public zzgp(int i) {
        this.zzade = i;
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzoh.checkState(z);
        this.state = 0;
        this.zzadg = null;
        this.zzadj = false;
        zzeg();
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTrackType() {
        return this.zzade;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzgq {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzgq {
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void start() throws zzgq {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzoh.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void stop() throws zzgq {
        zzoh.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzhh zzhh, zzjb zzjb, boolean z) {
        int zzb = this.zzadg.zzb(zzhh, zzjb, z);
        if (zzb == -4) {
            if (zzjb.zzgh()) {
                this.zzadi = true;
                return this.zzadj ? -4 : -3;
            }
            zzjb.timeUs += this.zzadh;
        } else if (zzb == -5) {
            zzhf zzhf = zzhh.zzahd;
            long j = zzhf.zzagx;
            if (j != LongCompanionObject.MAX_VALUE) {
                zzhh.zzahd = zzhf.zzds(j + this.zzadh);
            }
        }
        return zzb;
    }

    public void zza(int i, Object obj) throws zzgq {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzgq {
    }

    public final void zza(zzhm zzhm, zzhf[] zzhfArr, zzmt zzmt, long j, boolean z, long j2) throws zzgq {
        zzoh.checkState(this.state == 0);
        this.zzadf = zzhm;
        this.state = 1;
        zze(z);
        zza(zzhfArr, zzmt, j2);
        zza(j, z);
    }

    /* access modifiers changed from: protected */
    public void zza(zzhf[] zzhfArr, long j) throws zzgq {
    }

    public final void zza(zzhf[] zzhfArr, zzmt zzmt, long j) throws zzgq {
        zzoh.checkState(!this.zzadj);
        this.zzadg = zzmt;
        this.zzadi = false;
        this.zzadh = j;
        zza(zzhfArr, j);
    }

    public final void zzdm(long j) throws zzgq {
        this.zzadj = false;
        this.zzadi = false;
        zza(j, false);
    }

    /* access modifiers changed from: protected */
    public final void zzdn(long j) {
        this.zzadg.zzeh(j - this.zzadh);
    }

    public final zzhn zzdy() {
        return this;
    }

    public zzol zzdz() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) throws zzgq {
    }

    public final zzmt zzea() {
        return this.zzadg;
    }

    public final boolean zzeb() {
        return this.zzadi;
    }

    public final void zzec() {
        this.zzadj = true;
    }

    public final boolean zzed() {
        return this.zzadj;
    }

    public final void zzee() throws IOException {
        this.zzadg.zzhr();
    }

    public int zzef() throws zzgq {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzeg() {
    }

    /* access modifiers changed from: protected */
    public final zzhm zzeh() {
        return this.zzadf;
    }

    /* access modifiers changed from: protected */
    public final boolean zzei() {
        return this.zzadi ? this.zzadj : this.zzadg.isReady();
    }
}
