package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbjy implements zzbjx {
    private zzawt zzduw;

    public zzbjy(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        this.zzduw.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
