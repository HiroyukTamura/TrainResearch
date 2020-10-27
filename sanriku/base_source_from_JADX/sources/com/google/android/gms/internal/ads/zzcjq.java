package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcjq implements Callable {
    private final Context zzcit;

    zzcjq(Context context) {
        this.zzcit = context;
    }

    public final Object call() {
        CookieManager zzbf = zzq.zzky().zzbf(this.zzcit);
        return zzbf != null ? zzbf.getCookie("googleads.g.doubleclick.net") : "";
    }
}
