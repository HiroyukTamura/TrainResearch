package com.google.android.gms.internal.ads;

public final class zzmy extends zzhp {
    private static final Object zzbdz = new Object();
    private final boolean zzaho;
    private final boolean zzahp;
    private final long zzbea;
    private final long zzbeb;
    private final long zzbec;
    private final long zzbed;

    private zzmy(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbea = j;
        this.zzbeb = j2;
        this.zzbec = 0;
        this.zzbed = 0;
        this.zzaho = z;
        this.zzahp = false;
    }

    public zzmy(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final zzhq zza(int i, zzhq zzhq, boolean z, long j) {
        zzoh.zzc(i, 0, 1);
        boolean z2 = this.zzaho;
        long j2 = this.zzbeb;
        zzhq.zzahl = null;
        zzhq.zzahm = -9223372036854775807L;
        zzhq.zzahn = -9223372036854775807L;
        zzhq.zzaho = z2;
        zzhq.zzahp = false;
        zzhq.zzahs = 0;
        zzhq.zzaht = j2;
        zzhq.zzahq = 0;
        zzhq.zzahr = 0;
        zzhq.zzahu = 0;
        return zzhq;
    }

    public final zzhr zza(int i, zzhr zzhr, boolean z) {
        zzoh.zzc(i, 0, 1);
        Object obj = z ? zzbdz : null;
        return zzhr.zza(obj, obj, 0, this.zzbea, 0, false);
    }

    public final int zzc(Object obj) {
        return zzbdz.equals(obj) ? 0 : -1;
    }

    public final int zzfe() {
        return 1;
    }

    public final int zzff() {
        return 1;
    }
}
