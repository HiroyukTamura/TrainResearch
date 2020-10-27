package com.google.android.gms.internal.ads;

public class zzbiv {
    private zza zzfff;

    public static abstract class zza {
        public abstract zzbdt zzads();

        public abstract zzbbh zzadt();

        public abstract zzsy zzadu();

        public abstract zzaup zzadv();

        public abstract zzapn zzadw();

        public abstract zzalc zzadx();
    }

    public zzbiv(zza zza2) {
        this.zzfff = zza2;
    }

    public final zzaup zzadv() {
        return this.zzfff.zzadv();
    }

    public final zzapn zzadw() {
        return this.zzfff.zzadw();
    }

    public final zzalc zzadx() {
        return this.zzfff.zzadx();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzauk, com.google.android.gms.internal.ads.zzauq] */
    public final com.google.android.gms.ads.internal.zza zzaga() {
        zza zza2 = this.zzfff;
        return new com.google.android.gms.ads.internal.zza(zza2.zzads(), zza2.zzadt(), new zzauk(zza2.zzadv()), zza2.zzadu(), zza2.zzadw());
    }
}
