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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;

public abstract class ae
extends ViewDataBinding {
    public final ConstraintLayout c;
    public final LinearLayout d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final AppCompatImageView i;
    public final ConstraintLayout j;
    public final View k;
    public final View l;
    public final View m;
    public final View n;
    public final View o;
    public final AppCompatImageView p;
    public final ConstraintLayout q;
    public final TextView r;
    public final LinearLayout s;
    public final LinearLayout t;
    protected g u;
    protected RailwayLine v;

    protected ae(e e2, View view, int n2, ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout3, View view2, View view3, View view4, View view5, View view6, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout4, TextView textView4, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(e2, view, n2);
        this.c = constraintLayout;
        this.d = linearLayout;
        this.e = constraintLayout2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = appCompatImageView;
        this.j = constraintLayout3;
        this.k = view2;
        this.l = view3;
        this.m = view4;
        this.n = view5;
        this.o = view6;
        this.p = appCompatImageView2;
        this.q = constraintLayout4;
        this.r = textView4;
        this.s = linearLayout2;
        this.t = linearLayout3;
    }

    public static ae a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ae.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ae a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ae)f.a(layoutInflater, 2131427388, viewGroup, bl2, e2);
    }

    public abstract void a(g var1);

    public abstract void a(RailwayLine var1);

    public g j() {
        return this.u;
    }

    public RailwayLine k() {
        return this.v;
    }
}

