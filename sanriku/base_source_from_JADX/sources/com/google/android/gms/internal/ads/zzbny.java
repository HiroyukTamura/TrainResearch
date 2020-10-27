package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

public final class zzbny {
    public final List<? extends zzdri<? extends zzbns>> zzfkv;

    public zzbny(zzbns zzbns) {
        this.zzfkv = Collections.singletonList(zzdqw.zzag(zzbns));
    }

    public zzbny(List<? extends zzdri<? extends zzbns>> list) {
        this.zzfkv = list;
    }

    public static zzcnj<zzbny> zza(@NonNull zzcnj<? extends zzbns> zzcnj) {
        return new zzcni(zzcnj, zzboa.zzdsc);
    }

    public static zzcnj<zzbny> zza(@NonNull zzcpk<? extends zzbns> zzcpk) {
        return new zzcni(zzcpk, zzbob.zzdsc);
    }
}
