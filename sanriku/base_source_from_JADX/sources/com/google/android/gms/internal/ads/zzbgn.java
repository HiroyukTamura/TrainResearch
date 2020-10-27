package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;

public class zzbgn extends zzbgm implements zzbgs {
    private boolean zzejx;
    private boolean zzekq;
    private final zzbgl zzelt;

    public zzbgn(Context context, zzbgl zzbgl) {
        super(context);
        zzq.zzla().zzvy();
        this.zzelt = zzbgl;
        super.setWebViewClient(zzbgl);
    }

    private final synchronized void zzvz() {
        if (!this.zzekq) {
            this.zzekq = true;
            zzq.zzla().zzvz();
        }
    }

    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    public synchronized void destroy() {
        if (!this.zzejx) {
            this.zzejx = true;
            this.zzelt.zza((zzbgs) this);
            zzbe(false);
            zzawr.zzeg("Initiating WebView self destruct sequence in 3...");
            zzawr.zzeg("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzq.zzla().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzazw.zzfc(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgn.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzbe(true);
                }
                zzvz();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzejx;
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzazw.zzfc("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzazw.zzfc("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzazw.zzfc("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    public final synchronized void zza(zzbgo zzbgo) {
        zzawr.zzeg("Blank page loaded, 1...");
        zzabp();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzabp() {
        zzawr.zzeg("Destroying WebView!");
        zzvz();
        zzbab.zzdzv.execute(new zzbgq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacs() {
        super.destroy();
    }

    /* access modifiers changed from: protected */
    public void zzbe(boolean z) {
    }

    public /* bridge */ /* synthetic */ void zzda(String str) {
        super.zzda(str);
    }
}
