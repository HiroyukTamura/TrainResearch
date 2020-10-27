package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

public final class zzcni<DelegateT, AdapterT> implements zzcnj<AdapterT> {
    @VisibleForTesting
    private final zzcnj<DelegateT> zzgej;
    private final zzdnx<DelegateT, AdapterT> zzgek;

    public zzcni(zzcnj<DelegateT> zzcnj, zzdnx<DelegateT, AdapterT> zzdnx) {
        this.zzgej = zzcnj;
        this.zzgek = zzdnx;
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        return this.zzgej.zza(zzdha, zzdgo);
    }

    public final zzdri<AdapterT> zzb(zzdha zzdha, zzdgo zzdgo) {
        return zzdqw.zzb(this.zzgej.zzb(zzdha, zzdgo), this.zzgek, (Executor) zzbab.zzdzr);
    }
}
