/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.q.a.c;

public abstract class y
extends ViewDataBinding {
    public final View c;
    public final AppCompatImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final AppCompatTextView t;
    public final ConstraintLayout u;
    public final AppCompatImageView v;
    protected c w;

    protected y(e e2, View view, int n2, View view2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView2) {
        super(e2, view, n2);
        this.c = view2;
        this.d = appCompatImageView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
        this.k = textView7;
        this.l = textView8;
        this.m = textView9;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
        this.q = textView13;
        this.r = textView14;
        this.s = textView15;
        this.t = appCompatTextView;
        this.u = constraintLayout;
        this.v = appCompatImageView2;
    }

    public static y a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return y.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static y a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (y)f.a(layoutInflater, 2131427368, viewGroup, bl2, e2);
    }

    public abstract void a(c var1);
}

