package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zze extends zzbq {

    /* renamed from: ID */
    private static final String f978ID = zza.ADVERTISER_ID.toString();
    private final zza zzadt;

    public zze(Context context) {
        this(zza.zzf(context));
    }

    @VisibleForTesting
    private zze(zza zza) {
        super(f978ID, new String[0]);
        this.zzadt = zza;
        zza.zzgq();
    }

    public final zzl zzb(Map<String, zzl> map) {
        String zzgq = this.zzadt.zzgq();
        return zzgq == null ? zzgj.zzkc() : zzgj.zzi(zzgq);
    }

    public final boolean zzgw() {
        return false;
    }
}
