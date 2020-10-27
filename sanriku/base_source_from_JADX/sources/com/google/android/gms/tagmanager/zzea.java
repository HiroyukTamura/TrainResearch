package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzea extends zzbq {

    /* renamed from: ID */
    private static final String f979ID = zza.OS_VERSION.toString();

    public zzea() {
        super(f979ID, new String[0]);
    }

    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Build.VERSION.RELEASE);
    }

    public final boolean zzgw() {
        return true;
    }
}
