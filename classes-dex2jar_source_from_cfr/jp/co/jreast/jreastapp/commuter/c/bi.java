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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import jp.co.jreast.jreastapp.commuter.c.cm;
import jp.co.jreast.jreastapp.commuter.q.h;

public abstract class bi
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final AppCompatImageButton g;
    public final ConstraintLayout h;
    public final AppCompatImageView i;
    public final cm j;
    public final SwipeRefreshLayout k;
    public final TextView l;
    public final TextView m;
    public final Toolbar n;
    public final RecyclerView o;
    protected h p;

    protected bi(e e2, View view, int n2, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView2, cm cm2, SwipeRefreshLayout swipeRefreshLayout, TextView textView3, TextView textView4, Toolbar toolbar, RecyclerView recyclerView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = textView;
        this.e = constraintLayout;
        this.f = textView2;
        this.g = appCompatImageButton;
        this.h = constraintLayout2;
        this.i = appCompatImageView2;
        this.j = cm2;
        this.b(this.j);
        this.k = swipeRefreshLayout;
        this.l = textView3;
        this.m = textView4;
        this.n = toolbar;
        this.o = recyclerView;
    }

    public static bi a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bi.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bi a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bi)f.a(layoutInflater, 2131427404, viewGroup, bl2, e2);
    }

    public abstract void a(h var1);
}

