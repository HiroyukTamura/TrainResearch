package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzqr implements Runnable {
    private ValueCallback<String> zzbqy = new zzqu(this);
    final /* synthetic */ zzqj zzbqz;
    final /* synthetic */ WebView zzbra;
    final /* synthetic */ boolean zzbrb;
    final /* synthetic */ zzqp zzbrc;

    zzqr(zzqp zzqp, zzqj zzqj, WebView webView, boolean z) {
        this.zzbrc = zzqp;
        this.zzbqz = zzqj;
        this.zzbra = webView;
        this.zzbrb = z;
    }

    public final void run() {
        if (this.zzbra.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbra.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbqy);
            } catch (Throwable unused) {
                this.zzbqy.onReceiveValue("");
            }
        }
    }
}
