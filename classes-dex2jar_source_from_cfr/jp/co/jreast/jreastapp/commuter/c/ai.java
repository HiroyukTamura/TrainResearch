/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.c.ci;
import jp.co.jreast.jreastapp.commuter.c.ck;
import jp.co.jreast.jreastapp.commuter.webview.j;

public abstract class ai
extends ViewDataBinding {
    public final AppCompatImageButton c;
    public final ci d;
    public final ck e;
    public final AppCompatImageView f;
    public final ProgressBar g;
    public final AppCompatImageButton h;
    public final TextView i;
    public final AppCompatImageButton j;
    public final TextView k;
    public final ConstraintLayout l;
    public final Toolbar m;
    public final ConstraintLayout n;
    public final WebView o;
    protected j p;

    protected ai(e e2, View view, int n2, AppCompatImageButton appCompatImageButton, ci ci2, ck ck2, AppCompatImageView appCompatImageView, ProgressBar progressBar, AppCompatImageButton appCompatImageButton2, TextView textView, AppCompatImageButton appCompatImageButton3, TextView textView2, ConstraintLayout constraintLayout, Toolbar toolbar, ConstraintLayout constraintLayout2, WebView webView) {
        super(e2, view, n2);
        this.c = appCompatImageButton;
        this.d = ci2;
        this.b(this.d);
        this.e = ck2;
        this.b(this.e);
        this.f = appCompatImageView;
        this.g = progressBar;
        this.h = appCompatImageButton2;
        this.i = textView;
        this.j = appCompatImageButton3;
        this.k = textView2;
        this.l = constraintLayout;
        this.m = toolbar;
        this.n = constraintLayout2;
        this.o = webView;
    }

    public static ai a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ai.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ai a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ai)f.a(layoutInflater, 2131427390, viewGroup, bl2, e2);
    }

    public abstract void a(j var1);
}

