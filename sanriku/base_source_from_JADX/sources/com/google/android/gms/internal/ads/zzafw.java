package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzafw implements zzaga<zzbek> {
    zzafw() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbek.zzkc();
        } else if ("resume".equals(str)) {
            zzbek.zzkd();
        }
    }
}
