package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@VisibleForTesting
final class zzbp extends zzbq {

    /* renamed from: ID */
    private static final String f966ID = zza.EVENT.toString();
    private final zzfb zzaee;

    public zzbp(zzfb zzfb) {
        super(f966ID, new String[0]);
        this.zzaee = zzfb;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String zzjf = this.zzaee.zzjf();
        return zzjf == null ? zzgj.zzkc() : zzgj.zzi(zzjf);
    }

    public final boolean zzgw() {
        return false;
    }
}
