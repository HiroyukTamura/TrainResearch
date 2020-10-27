package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@VisibleForTesting
final class zzaj extends zzbq {

    /* renamed from: ID */
    private static final String f956ID = zza.CONTAINER_VERSION.toString();
    private final String version;

    public zzaj(String str) {
        super(f956ID, new String[0]);
        this.version = str;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str = this.version;
        return str == null ? zzgj.zzkc() : zzgj.zzi(str);
    }

    public final boolean zzgw() {
        return true;
    }
}
