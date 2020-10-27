package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
public class zzbfo extends zzbej {
    public zzbfo(zzbek zzbek, zzst zzst, boolean z) {
        super(zzbek, zzst, z);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        if (!(webView instanceof zzbek)) {
            zzazw.zzfc("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbek zzbek = (zzbek) webView;
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            zzaun.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbek.zzabj() != null) {
            zzbek.zzabj().zzui();
        }
        String str2 = (String) zzvj.zzpv().zzd(zzbek.zzabh().zzaco() ? zzzz.zzcka : zzbek.zzabo() ? zzzz.zzcjz : zzzz.zzcjy);
        zzq.zzkw();
        return zzaxa.zzd(zzbek.getContext(), zzbek.zzzk().zzbnd, str2);
    }
}
