/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.webview.r;

public abstract class aa
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatImageButton d;
    public final AppCompatImageView e;
    public final LinearLayout f;
    public final AppCompatTextView g;
    public final WebView h;
    protected r i;

    protected aa(e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView, WebView webView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatImageButton;
        this.e = appCompatImageView2;
        this.f = linearLayout;
        this.g = appCompatTextView;
        this.h = webView;
    }

    public abstract void a(r var1);
}

