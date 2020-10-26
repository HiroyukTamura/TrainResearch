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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.n.k;

public abstract class cq
extends ViewDataBinding {
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final TextView o;
    protected k p;
    protected Route q;

    protected cq(e e2, View view, int n2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, TextView textView10) {
        super(e2, view, n2);
        this.c = textView;
        this.d = linearLayout;
        this.e = textView2;
        this.f = textView3;
        this.g = constraintLayout;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
        this.k = textView7;
        this.l = textView8;
        this.m = textView9;
        this.n = view2;
        this.o = textView10;
    }

    public static cq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cq.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cq)f.a(layoutInflater, 2131427442, viewGroup, bl2, e2);
    }

    public abstract void a(Route var1);

    public abstract void a(k var1);

    public Route j() {
        return this.q;
    }
}

