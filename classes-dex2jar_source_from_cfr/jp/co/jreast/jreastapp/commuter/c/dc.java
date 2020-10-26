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
import jp.co.jreast.jreastapp.commuter.common.view.OutlineTextView;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;

public abstract class dc
extends ViewDataBinding {
    public final OutlineTextView c;
    public final OutlineTextView d;
    public final TextView e;
    public final OutlineTextView f;
    public final OutlineTextView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final ConstraintLayout k;
    public final TextView l;
    public final LinearLayout m;
    public final ConstraintLayout n;
    protected h o;
    protected Route p;

    protected dc(e e2, View view, int n2, OutlineTextView outlineTextView, OutlineTextView outlineTextView2, TextView textView, OutlineTextView outlineTextView3, OutlineTextView outlineTextView4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, TextView textView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        super(e2, view, n2);
        this.c = outlineTextView;
        this.d = outlineTextView2;
        this.e = textView;
        this.f = outlineTextView3;
        this.g = outlineTextView4;
        this.h = appCompatImageView;
        this.i = appCompatImageView2;
        this.j = appCompatImageView3;
        this.k = constraintLayout;
        this.l = textView2;
        this.m = linearLayout;
        this.n = constraintLayout2;
    }

    public static dc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return dc.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static dc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (dc)f.a(layoutInflater, 2131427448, viewGroup, bl2, e2);
    }

    public abstract void a(Route var1);

    public abstract void a(h var1);

    public h j() {
        return this.o;
    }

    public Route k() {
        return this.p;
    }
}

