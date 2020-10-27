package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

public final class zzbka implements zzbjx {
    private final Context zzvf;

    public zzbka(Context context) {
        this.zzvf = context;
    }

    public final void zzl(Map<String, String> map) {
        CookieManager zzbf;
        String str = map.get("cookie");
        if (!TextUtils.isEmpty(str) && (zzbf = zzq.zzky().zzbf(this.zzvf)) != null) {
            zzbf.setCookie("googleads.g.doubleclick.net", str);
        }
    }
}
