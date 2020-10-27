package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzfk extends zzbq {

    /* renamed from: ID */
    private static final String f987ID = zza.SDK_VERSION.toString();

    public zzfk() {
        super(f987ID, new String[0]);
    }

    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    public final boolean zzgw() {
        return true;
    }
}
