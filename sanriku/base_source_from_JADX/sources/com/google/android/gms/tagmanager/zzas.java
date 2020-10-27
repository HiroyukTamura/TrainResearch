package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@VisibleForTesting
final class zzas extends zzbq {

    /* renamed from: ID */
    private static final String f959ID = zza.CUSTOM_VAR.toString();
    private static final String NAME = zzb.NAME.toString();
    private static final String zzafw = zzb.DEFAULT_VALUE.toString();
    private final DataLayer zzaed;

    public zzas(DataLayer dataLayer) {
        super(f959ID, NAME);
        this.zzaed = dataLayer;
    }

    public final zzl zzb(Map<String, zzl> map) {
        Object obj = this.zzaed.get(zzgj.zzc(map.get(NAME)));
        if (obj != null) {
            return zzgj.zzi(obj);
        }
        zzl zzl = map.get(zzafw);
        return zzl != null ? zzl : zzgj.zzkc();
    }

    public final boolean zzgw() {
        return false;
    }
}
