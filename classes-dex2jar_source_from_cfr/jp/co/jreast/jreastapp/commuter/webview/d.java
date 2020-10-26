/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Message
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebView$HitTestResult
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebChromeClient;", "Landroid/webkit/WebChromeClient;", "()V", "onCreateWindow", "", "view", "Landroid/webkit/WebView;", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends WebChromeClient {
    public boolean onCreateWindow(WebView webView, boolean bl2, boolean bl3, Message message) {
        if (webView != null) {
            message = webView.getHitTestResult();
            j.a((Object)message, "view.hitTestResult");
            message = new Intent("android.intent.action.VIEW", Uri.parse((String)message.getExtra()));
            webView.getContext().startActivity((Intent)message);
            return true;
        }
        return false;
    }
}

