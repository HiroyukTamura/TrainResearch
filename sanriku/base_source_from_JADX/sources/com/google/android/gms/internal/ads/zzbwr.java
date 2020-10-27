package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;

public final class zzbwr implements zzrv {
    private zzdnt zzfoq;

    public final View getView() {
        return this.zzfoq;
    }

    public final WebView getWebView() {
        if (this.zzfoq == null) {
            return null;
        }
        return zzdnt.getWebView();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzfoq != null) {
            zzdnt.onPageStarted(webView, str, bitmap);
        }
    }

    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzfoq = new zzdnt(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzazw.zzfa(sb.toString());
        }
    }

    public final void zzc(String str, String str2) {
        if (this.zzfoq == null) {
            zzazw.zzfa("ArWebView is not initialized.");
        } else {
            zzdnt.getWebView().loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
        }
    }
}
