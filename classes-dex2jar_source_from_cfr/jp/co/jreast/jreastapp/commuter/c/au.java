/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.n.k;

public abstract class au
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatImageButton d;
    public final AppCompatImageButton e;
    public final CoordinatorLayout f;
    public final FrameLayout g;
    public final AppCompatImageView h;
    public final ImageView i;
    public final AppCompatImageButton j;
    public final CheckBox k;
    public final Button l;
    public final Button m;
    public final ConstraintLayout n;
    public final RecyclerView o;
    public final ConstraintLayout p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final ConstraintLayout t;
    public final Toolbar u;
    protected k v;

    protected au(e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, ImageView imageView, AppCompatImageButton appCompatImageButton3, CheckBox checkBox, Button button, Button button2, ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, Toolbar toolbar) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatImageButton;
        this.e = appCompatImageButton2;
        this.f = coordinatorLayout;
        this.g = frameLayout;
        this.h = appCompatImageView2;
        this.i = imageView;
        this.j = appCompatImageButton3;
        this.k = checkBox;
        this.l = button;
        this.m = button2;
        this.n = constraintLayout;
        this.o = recyclerView;
        this.p = constraintLayout2;
        this.q = textView;
        this.r = textView2;
        this.s = textView3;
        this.t = constraintLayout3;
        this.u = toolbar;
    }

    public static au a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return au.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static au a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (au)f.a(layoutInflater, 2131427397, viewGroup, bl2, e2);
    }

    public abstract void a(k var1);
}

