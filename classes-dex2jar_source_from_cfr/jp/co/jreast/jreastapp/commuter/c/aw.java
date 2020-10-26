/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.commuterpager.b.c;

public abstract class aw
extends ViewDataBinding {
    public final TextView c;
    public final Button d;
    public final TextView e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final FrameLayout i;
    public final TextView j;
    public final ConstraintLayout k;
    public final Button l;
    public final TextView m;
    public final AppCompatImageView n;
    public final AppCompatImageView o;
    public final Button p;
    public final ConstraintLayout q;
    public final Button r;
    public final Button s;
    protected c t;

    protected aw(e e2, View view, int n2, TextView textView, Button button, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4, FrameLayout frameLayout, TextView textView5, ConstraintLayout constraintLayout, Button button2, TextView textView6, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, Button button3, ConstraintLayout constraintLayout2, Button button4, Button button5) {
        super(e2, view, n2);
        this.c = textView;
        this.d = button;
        this.e = textView2;
        this.f = linearLayout;
        this.g = textView3;
        this.h = textView4;
        this.i = frameLayout;
        this.j = textView5;
        this.k = constraintLayout;
        this.l = button2;
        this.m = textView6;
        this.n = appCompatImageView;
        this.o = appCompatImageView2;
        this.p = button3;
        this.q = constraintLayout2;
        this.r = button4;
        this.s = button5;
    }

    public static aw a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return aw.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static aw a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (aw)f.a(layoutInflater, 2131427398, viewGroup, bl2, e2);
    }

    public abstract void a(c var1);
}

