package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbft;

@TargetApi(17)
public final class zzbff<WebViewT extends zzbfj & zzbfr & zzbft> {
    private final zzbfk zzeld;
    private final WebViewT zzele;

    private zzbff(WebViewT webviewt, zzbfk zzbfk) {
        this.zzeld = zzbfk;
        this.zzele = webviewt;
    }

    public static zzbff<zzbek> zzc(zzbek zzbek) {
        return new zzbff<>(zzbek, new zzbfi(zzbek));
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "Click string is empty, not proceeding.";
        } else {
            zzdt zzabm = ((zzbfr) this.zzele).zzabm();
            if (zzabm == null) {
                str2 = "Signal utils is empty, ignoring.";
            } else {
                zzdj zzcb = zzabm.zzcb();
                if (zzcb == null) {
                    str2 = "Signals object is empty, ignoring.";
                } else if (this.zzele.getContext() != null) {
                    return zzcb.zza(this.zzele.getContext(), str, ((zzbft) this.zzele).getView(), this.zzele.zzzh());
                } else {
                    str2 = "Context is null, ignoring.";
                }
            }
        }
        zzawr.zzeg(str2);
        return "";
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzazw.zzfc("URL is empty, ignoring message");
        } else {
            zzaxa.zzdwf.post(new zzbfh(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfs(String str) {
        this.zzeld.zzh(Uri.parse(str));
    }
}
