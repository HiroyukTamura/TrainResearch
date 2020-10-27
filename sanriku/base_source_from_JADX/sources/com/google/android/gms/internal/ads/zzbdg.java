package com.google.android.gms.internal.ads;

public final class zzbdg implements zzbdt {
    public final zzbdl zza(zzbbx zzbbx, int i, String str, zzbby zzbby) {
        if (i <= 0) {
            return new zzbdw(zzbbx);
        }
        int zzaaj = zzbcu.zzaaj();
        return zzaaj < zzbby.zzedy ? new zzbea(zzbbx, zzbby) : zzaaj < zzbby.zzeds ? new zzbdx(zzbbx, zzbby) : new zzbdv(zzbbx);
    }
}
