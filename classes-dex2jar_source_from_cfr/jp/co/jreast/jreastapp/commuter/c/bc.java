/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.common.view.LockableScrollView;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;

public abstract class bc
extends ViewDataBinding {
    public final LinearLayout c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final ProgressBar f;
    public final LinearLayout g;
    public final Button h;
    public final AppCompatImageView i;
    public final Button j;
    public final RecyclerView k;
    public final LinearLayout l;
    public final LockableScrollView m;
    public final TextView n;
    public final TextView o;
    public final ConstraintLayout p;
    protected h q;

    protected bc(e e2, View view, int n2, LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, ProgressBar progressBar, LinearLayout linearLayout3, Button button, AppCompatImageView appCompatImageView2, Button button2, RecyclerView recyclerView, LinearLayout linearLayout4, LockableScrollView lockableScrollView, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        super(e2, view, n2);
        this.c = linearLayout;
        this.d = appCompatImageView;
        this.e = linearLayout2;
        this.f = progressBar;
        this.g = linearLayout3;
        this.h = button;
        this.i = appCompatImageView2;
        this.j = button2;
        this.k = recyclerView;
        this.l = linearLayout4;
        this.m = lockableScrollView;
        this.n = textView;
        this.o = textView2;
        this.p = constraintLayout;
    }

    public static bc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bc.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bc)f.a(layoutInflater, 2131427401, viewGroup, bl2, e2);
    }

    public abstract void a(h var1);

    public h j() {
        return this.q;
    }
}

