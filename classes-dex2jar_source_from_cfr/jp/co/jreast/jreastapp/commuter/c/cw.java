/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.n.k;

public abstract class cw
extends ViewDataBinding {
    public final TextView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final ConstraintLayout i;
    public final View j;
    public final View k;
    public final AppCompatImageView l;
    public final AppCompatImageView m;
    public final AppCompatImageView n;
    public final LinearLayout o;
    public final TextView p;
    public final TextView q;
    public final View r;
    public final AppCompatTextView s;
    protected k t;
    protected RailwayLine u;

    protected cw(e e2, View view, int n2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, View view2, View view3, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, TextView textView4, TextView textView5, View view4, AppCompatTextView appCompatTextView2) {
        super(e2, view, n2);
        this.c = textView;
        this.d = constraintLayout;
        this.e = textView2;
        this.f = textView3;
        this.g = appCompatImageView;
        this.h = appCompatTextView;
        this.i = constraintLayout2;
        this.j = view2;
        this.k = view3;
        this.l = appCompatImageView2;
        this.m = appCompatImageView3;
        this.n = appCompatImageView4;
        this.o = linearLayout;
        this.p = textView4;
        this.q = textView5;
        this.r = view4;
        this.s = appCompatTextView2;
    }

    public static cw a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cw.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cw a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cw)f.a(layoutInflater, 2131427445, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLine var1);

    public abstract void a(k var1);

    public k j() {
        return this.t;
    }

    public RailwayLine k() {
        return this.u;
    }
}

