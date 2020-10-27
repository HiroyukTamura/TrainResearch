package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzbd extends zzbq {

    /* renamed from: ID */
    private static final String f962ID = zza.DEVICE_NAME.toString();

    public zzbd() {
        super(f962ID, new String[0]);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = C0681a.m313a(str2.length() + str.length() + 1, str, " ", str2);
        }
        return zzgj.zzi(str2);
    }

    public final boolean zzgw() {
        return true;
    }
}
