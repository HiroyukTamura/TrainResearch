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
import jp.co.jreast.jreastapp.commuter.model.LineServiceStatusItem;
import jp.co.jreast.jreastapp.commuter.q.h;

public abstract class ce
extends ViewDataBinding {
    protected LineServiceStatusItem A;
    public final AppCompatImageView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final TextView l;
    public final AppCompatImageView m;
    public final AppCompatTextView n;
    public final ConstraintLayout o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final View t;
    public final View u;
    public final ConstraintLayout v;
    public final ConstraintLayout w;
    public final ConstraintLayout x;
    protected int y;
    protected h z;

    protected ce(e e2, View view, int n2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, TextView textView5, AppCompatImageView appCompatImageView5, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, View view3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = constraintLayout;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = appCompatImageView2;
        this.j = appCompatImageView3;
        this.k = appCompatImageView4;
        this.l = textView5;
        this.m = appCompatImageView5;
        this.n = appCompatTextView;
        this.o = constraintLayout2;
        this.p = textView6;
        this.q = textView7;
        this.r = textView8;
        this.s = textView9;
        this.t = view2;
        this.u = view3;
        this.v = constraintLayout3;
        this.w = constraintLayout4;
        this.x = constraintLayout5;
    }

    public static ce a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ce.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ce a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ce)f.a(layoutInflater, 2131427417, viewGroup, bl2, e2);
    }

    public abstract void a(LineServiceStatusItem var1);

    public abstract void a(h var1);

    public abstract void c(int var1);
}

