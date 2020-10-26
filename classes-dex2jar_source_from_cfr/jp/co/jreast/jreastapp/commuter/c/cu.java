/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.k;

public abstract class cu
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final Button d;
    public final AppCompatTextView e;
    public final AppCompatImageView f;
    public final AppCompatTextView g;
    public final ConstraintLayout h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final TextView n;
    public final AppCompatTextView o;
    public final ConstraintLayout p;
    public final TextView q;
    public final TextView r;
    public final ConstraintLayout s;
    public final AppCompatTextView t;
    protected k u;
    protected Route v;

    protected cu(e e2, View view, int n2, AppCompatImageView appCompatImageView, Button button, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, TextView textView, AppCompatTextView appCompatTextView8, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView9) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = button;
        this.e = appCompatTextView;
        this.f = appCompatImageView2;
        this.g = appCompatTextView2;
        this.h = constraintLayout;
        this.i = appCompatTextView3;
        this.j = appCompatTextView4;
        this.k = appCompatTextView5;
        this.l = appCompatTextView6;
        this.m = appCompatTextView7;
        this.n = textView;
        this.o = appCompatTextView8;
        this.p = constraintLayout2;
        this.q = textView2;
        this.r = textView3;
        this.s = constraintLayout3;
        this.t = appCompatTextView9;
    }

    public static cu a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cu.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cu a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cu)f.a(layoutInflater, 2131427444, viewGroup, bl2, e2);
    }

    public abstract void a(Route var1);

    public abstract void a(k var1);

    public k j() {
        return this.u;
    }

    public Route k() {
        return this.v;
    }
}

