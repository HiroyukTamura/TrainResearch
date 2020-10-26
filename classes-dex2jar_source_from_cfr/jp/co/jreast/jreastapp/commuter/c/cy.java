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

public abstract class cy
extends ViewDataBinding {
    protected Boolean A;
    public final TextView c;
    public final TextView d;
    public final AppCompatImageView e;
    public final LinearLayout f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;
    public final AppCompatImageView j;
    public final TextView k;
    public final TextView l;
    public final AppCompatTextView m;
    public final ConstraintLayout n;
    public final View o;
    public final AppCompatImageView p;
    public final LinearLayout q;
    public final TextView r;
    public final TextView s;
    public final LinearLayout t;
    public final View u;
    public final View v;
    public final AppCompatTextView w;
    public final TextView x;
    protected k y;
    protected RailwayLine z;

    protected cy(e e2, View view, int n2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, AppCompatImageView appCompatImageView2, TextView textView5, TextView textView6, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, View view2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout2, TextView textView7, TextView textView8, LinearLayout linearLayout3, View view3, View view4, AppCompatTextView appCompatTextView2, TextView textView9) {
        super(e2, view, n2);
        this.c = textView;
        this.d = textView2;
        this.e = appCompatImageView;
        this.f = linearLayout;
        this.g = constraintLayout;
        this.h = textView3;
        this.i = textView4;
        this.j = appCompatImageView2;
        this.k = textView5;
        this.l = textView6;
        this.m = appCompatTextView;
        this.n = constraintLayout2;
        this.o = view2;
        this.p = appCompatImageView3;
        this.q = linearLayout2;
        this.r = textView7;
        this.s = textView8;
        this.t = linearLayout3;
        this.u = view3;
        this.v = view4;
        this.w = appCompatTextView2;
        this.x = textView9;
    }

    public static cy a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cy.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cy a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cy)f.a(layoutInflater, 2131427446, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLine var1);

    public abstract void a(k var1);

    public abstract void b(Boolean var1);

    public k j() {
        return this.y;
    }

    public RailwayLine k() {
        return this.z;
    }

    public Boolean l() {
        return this.A;
    }
}

