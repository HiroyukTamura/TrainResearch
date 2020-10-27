package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbkd implements zzbjx {
    private final zzawt zzduw;

    public zzbkd(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        String str = map.get("value");
        if ("auto_collect_location".equals(map.get("key"))) {
            this.zzduw.zzaq(Boolean.parseBoolean(str));
        }
    }
}
