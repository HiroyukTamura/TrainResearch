package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

final class zzbyj implements zzbnx<zzbny> {
    private final zzcae zzfjb;
    private final Map<String, zzcnj<zzbny>> zzfku;
    private final zzehm<zzbnx<zzblx>> zzfpo;
    private final Map<String, zzcnj<zzbzm>> zzfpp;
    private final Map<String, zzcpk<zzbzm>> zzfpq;

    zzbyj(Map<String, zzcnj<zzbny>> map, Map<String, zzcnj<zzbzm>> map2, Map<String, zzcpk<zzbzm>> map3, zzehm<zzbnx<zzblx>> zzehm, zzcae zzcae) {
        this.zzfku = map;
        this.zzfpp = map2;
        this.zzfpq = map3;
        this.zzfpo = zzehm;
        this.zzfjb = zzcae;
    }

    @Nullable
    public final zzcnj<zzbny> zze(int i, String str) {
        zzcnj zze;
        zzcnj<zzbny> zzcnj = this.zzfku.get(str);
        if (zzcnj != null) {
            return zzcnj;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcpk zzcpk = this.zzfpq.get(str);
            if (zzcpk != null) {
                return zzbny.zza((zzcpk<? extends zzbns>) zzcpk);
            }
            zzcnj zzcnj2 = this.zzfpp.get(str);
            if (zzcnj2 != null) {
                return zzbny.zza((zzcnj<? extends zzbns>) zzcnj2);
            }
            return null;
        } else if (this.zzfjb.zzalo() == null || (zze = this.zzfpo.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzbny.zza((zzcnj<? extends zzbns>) zze);
        }
    }
}
