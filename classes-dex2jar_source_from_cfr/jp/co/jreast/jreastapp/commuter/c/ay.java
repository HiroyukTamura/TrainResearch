/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.o.h;

public abstract class ay
extends ViewDataBinding {
    public final AppCompatImageButton c;
    public final FrameLayout d;
    public final AppCompatImageView e;
    public final FrameLayout f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final Toolbar m;
    protected h n;

    protected ay(e e2, View view, int n2, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, Toolbar toolbar) {
        super(e2, view, n2);
        this.c = appCompatImageButton;
        this.d = frameLayout;
        this.e = appCompatImageView;
        this.f = frameLayout2;
        this.g = constraintLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = constraintLayout2;
        this.m = toolbar;
    }

    public static ay a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ay.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ay a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ay)f.a(layoutInflater, 2131427399, viewGroup, bl2, e2);
    }

    public abstract void a(h var1);
}

