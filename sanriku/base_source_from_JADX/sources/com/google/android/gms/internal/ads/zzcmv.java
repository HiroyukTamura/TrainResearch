package com.google.android.gms.internal.ads;

public final class zzcmv {
    private int responseCode = 0;
    private long zzgdk = 0;
    private long zzgdl = 0;
    private long zzgdm = 0;
    private final Object zzgdn = new Object();
    private final Object zzgdo = new Object();
    private final Object zzgdp = new Object();
    private final Object zzgdq = new Object();

    public final int getResponseCode() {
        int i;
        synchronized (this.zzgdn) {
            i = this.responseCode;
        }
        return i;
    }

    public final long zzaoy() {
        long j;
        synchronized (this.zzgdo) {
            j = this.zzgdk;
        }
        return j;
    }

    public final synchronized long zzaoz() {
        long j;
        synchronized (this.zzgdp) {
            j = this.zzgdl;
        }
        return j;
    }

    public final synchronized long zzapa() {
        long j;
        synchronized (this.zzgdq) {
            j = this.zzgdm;
        }
        return j;
    }

    public final void zzds(int i) {
        synchronized (this.zzgdn) {
            this.responseCode = i;
        }
    }

    public final void zzeq(long j) {
        synchronized (this.zzgdo) {
            this.zzgdk = j;
        }
    }

    public final synchronized void zzer(long j) {
        synchronized (this.zzgdq) {
            this.zzgdm = j;
        }
    }

    public final synchronized void zzff(long j) {
        synchronized (this.zzgdp) {
            this.zzgdl = j;
        }
    }
}
