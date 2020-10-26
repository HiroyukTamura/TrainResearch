/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.ValueCallback
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.p;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import jp.co.jreast.jreastapp.commuter.i.b;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.webview.c;
import jp.co.jreast.jreastapp.commuter.webview.f;
import jp.co.jreast.jreastapp.commuter.webview.j;
import jp.co.jreast.jreastapp.commuter.webview.l;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J.\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010#\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010#\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006%"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewClient;", "Landroid/webkit/WebViewClient;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "timerTaskGenerator", "Ljp/co/jreast/jreastapp/commuter/generator/TimerTaskGenerator;", "timeout", "", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;Ljp/co/jreast/jreastapp/commuter/generator/TimerTaskGenerator;J)V", "timer", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "setTimer", "(Ljava/util/Timer;)V", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends WebViewClient {
    private Timer a;
    private final j b;
    private final b c;
    private final long d;

    public e(j j2, b b2, long l2) {
        kotlin.e.b.j.b(j2, "viewModel");
        kotlin.e.b.j.b(b2, "timerTaskGenerator");
        this.b = j2;
        this.c = b2;
        this.d = l2;
        this.a = new Timer();
    }

    public /* synthetic */ e(j j2, b b2, long l2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            b2 = new b();
        }
        if ((n2 & 4) != 0) {
            l2 = 10000L;
        }
        this(j2, b2, l2);
    }

    public void onPageFinished(WebView webView, String string2) {
        super.onPageFinished(webView, string2);
        this.b.k().b(false);
        if (string2 != null) {
            CharSequence charSequence;
            if (n.a(string2, "http", false, 2, null)) {
                this.a.cancel();
                this.a.purge();
            }
            if (n.b(charSequence = (CharSequence)string2, (CharSequence)"trainnetTop.html", false, 2, null)) {
                if (webView == null) {
                    kotlin.e.b.j.a();
                }
                webView.loadUrl(this.b.E());
            }
            if (!n.b(charSequence, (CharSequence)"zw01", false, 2, null) && !n.b(charSequence, (CharSequence)"trainnet", false, 2, null)) {
                if (n.a(string2, "http", false, 2, null)) {
                    String string3;
                    j j2 = this.b;
                    if (webView == null || (string3 = webView.getTitle()) == null) {
                        string3 = "";
                    }
                    j2.a(new o(string3, string2, 0, null, 0, null, 0, null, 0, null, 1020, null));
                }
            } else if (n.b(charSequence, (CharSequence)"reload=1", false, 2, null)) {
                this.b.N();
            }
            if (webView != null && webView.canGoBack() && n.b(charSequence, (CharSequence)"zw01", false, 2, null)) {
                this.b.d(string2);
            }
        }
        if (webView != null) {
            webView.evaluateJavascript(this.b.a("fonts/TT-UDShinGoPro-Bold.ttf", "bold"), null);
            webView.evaluateJavascript(this.b.a("fonts/TT-UDShinGoPro-Medium.ttf", "normal"), null);
            int n2 = this.b.y() != f.a ? 8 : 0;
            webView.setVisibility(n2);
        }
    }

    public void onPageStarted(WebView object, String string2, Bitmap bitmap) {
        super.onPageStarted(object, string2, bitmap);
        if (object != null && string2 != null && (n.b((CharSequence)(object = (CharSequence)string2), (CharSequence)"zw01", false, 2, null) || n.b((CharSequence)object, (CharSequence)"com-static/ew01/static/trainnet/trainnetTop.html", false, 2, null))) {
            this.b.c(string2);
        }
        this.b.k().b(true);
        this.b.a(f.a);
        if (string2 != null && n.a(string2, "http", false, 2, null)) {
            this.a = this.c.a();
            object = this.c.a(this.b, this.a);
            this.a.schedule((TimerTask)object, this.d);
        }
    }

    public void onReceivedError(WebView webView, int n2, String string2, String string3) {
        super.onReceivedError(webView, n2, string2, string3);
        if (Build.VERSION.SDK_INT < 23) {
            this.b.b(f.b);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            this.b.b(f.b);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest object2) {
        block5 : {
            block6 : {
                String string2;
                if (object != null && object2 != null) {
                    string2 = object2.getUrl().toString();
                    kotlin.e.b.j.a((Object)string2, "request.url.toString()");
                    if (n.b((CharSequence)string2, (CharSequence)"zw01", false, 2, null)) {
                        object.loadUrl(object2.getUrl().toString(), new c(null, 1, null).a());
                        return true;
                    }
                }
                if (object == null || object2 == null) break block5;
                string2 = object2.getUrl().toString();
                kotlin.e.b.j.a((Object)string2, "request.url.toString()");
                if (n.b((CharSequence)string2, (CharSequence)"trainnet/homeExit", false, 2, null)) break block6;
                string2 = object2.getUrl().toString();
                kotlin.e.b.j.a((Object)string2, "request.url.toString()");
                if (!n.b((CharSequence)string2, (CharSequence)"trainnet/cars", false, 2, null)) break block5;
            }
            object.stopLoading();
            object = this.b;
            object2 = object2.getUrl().toString();
            kotlin.e.b.j.a(object2, "request.url.toString()");
            ((j)object).e((String)object2);
            return true;
        }
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        CharSequence charSequence;
        if (webView != null && string2 != null && n.b((CharSequence)string2, (CharSequence)"zw01", false, 2, null)) {
            webView.loadUrl(string2, new c(null, 1, null).a());
            return true;
        }
        if (webView != null && string2 != null && (n.b(charSequence = (CharSequence)string2, (CharSequence)"trainnet/homeExit", false, 2, null) || n.b(charSequence, (CharSequence)"trainnet/cars", false, 2, null))) {
            webView.stopLoading();
            this.b.e(string2);
            return true;
        }
        return false;
    }
}

