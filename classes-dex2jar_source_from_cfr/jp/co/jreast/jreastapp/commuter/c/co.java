/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.legacy.widget.Space;

public abstract class co
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final View d;
    public final View e;
    public final FrameLayout f;
    public final View g;
    public final View h;
    public final LinearLayout i;
    public final Space j;
    public final AppCompatImageView k;
    public final ConstraintLayout l;
    public final TextView m;

    protected co(e e2, View view, int n2, AppCompatImageView appCompatImageView, View view2, View view3, FrameLayout frameLayout, View view4, View view5, LinearLayout linearLayout, Space space, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = view2;
        this.e = view3;
        this.f = frameLayout;
        this.g = view4;
        this.h = view5;
        this.i = linearLayout;
        this.j = space;
        this.k = appCompatImageView2;
        this.l = constraintLayout;
        this.m = textView;
    }
}

