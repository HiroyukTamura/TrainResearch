package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbjw implements zzbjx {
    private zzawt zzduw;

    public zzbjw(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        this.zzduw.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
