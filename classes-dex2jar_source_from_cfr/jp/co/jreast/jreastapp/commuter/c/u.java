/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.servicestatus.b;

public abstract class u
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final AppCompatImageView j;
    public final ConstraintLayout k;
    public final TextView l;
    public final View m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final AppCompatImageView q;
    public final View r;
    protected b s;

    protected u(e e2, View view, int n2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout, TextView textView7, View view2, TextView textView8, TextView textView9, TextView textView10, AppCompatImageView appCompatImageView3, View view3) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
        this.i = textView6;
        this.j = appCompatImageView2;
        this.k = constraintLayout;
        this.l = textView7;
        this.m = view2;
        this.n = textView8;
        this.o = textView9;
        this.p = textView10;
        this.q = appCompatImageView3;
        this.r = view3;
    }

    public abstract void a(b var1);
}

