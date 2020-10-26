/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.acknowledgement.b;

public abstract class a
extends ViewDataBinding {
    public final TextView c;
    public final View d;
    public final View e;
    public final View f;
    public final AppCompatImageView g;
    public final TextView h;
    public final ProgressBar i;
    public final TextView j;
    public final AppCompatTextView k;
    protected b l;

    protected a(e e2, View view, int n2, TextView textView, View view2, View view3, View view4, AppCompatImageView appCompatImageView, TextView textView2, ProgressBar progressBar, TextView textView3, AppCompatTextView appCompatTextView) {
        super(e2, view, n2);
        this.c = textView;
        this.d = view2;
        this.e = view3;
        this.f = view4;
        this.g = appCompatImageView;
        this.h = textView2;
        this.i = progressBar;
        this.j = textView3;
        this.k = appCompatTextView;
    }

    public abstract void a(b var1);
}

