/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import jp.co.jreast.jreastapp.commuter.webview.r;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/WebViewClientCustom;", "Landroid/webkit/WebViewClient;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "(Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;)V", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "url", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class q
extends WebViewClient {
    private final r a;

    public q(r r2) {
        j.b(r2, "viewModel");
        this.a = r2;
    }

    public boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest object2) {
        if (object != null) {
            r r2 = this.a;
            Object var3_4 = null;
            object = object2 != null ? object2.getUrl() : null;
            if (r2.b(String.valueOf(object))) {
                object = this.a;
                if (object2 == null) {
                    j.a();
                }
                object2 = object2.getUrl().toString();
                j.a(object2, "request!!.url.toString()");
                ((r)object).a((String)object2);
                return true;
            }
            r2 = this.a;
            object = var3_4;
            if (object2 != null) {
                object = object2.getUrl();
            }
            if (r2.c(String.valueOf(object))) {
                this.a.n();
                return true;
            }
        }
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView object, String string2) {
        if (object != null) {
            if (this.a.b(string2)) {
                object = this.a;
                if (string2 == null) {
                    j.a();
                }
                ((r)object).a(string2);
                return true;
            }
            if (this.a.c(string2)) {
                this.a.n();
                return true;
            }
        }
        return false;
    }
}

