package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzbkb implements zzbjx {
    private final zzdgm zzfgh;

    public zzbkb(zzdgm zzdgm) {
        this.zzfgh = zzdgm;
    }

    public final void zzl(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfgh.zzbn(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
