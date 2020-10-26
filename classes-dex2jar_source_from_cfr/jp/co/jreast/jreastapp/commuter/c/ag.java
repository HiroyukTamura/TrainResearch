/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;

public abstract class ag
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final TextView d;
    public final FrameLayout e;
    public final LinearLayout f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    protected jp.co.jreast.jreastapp.commuter.favoriterouteedit.f i;
    protected Integer j;

    protected ag(e e2, View view, int n2, AppCompatImageView appCompatImageView, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = textView;
        this.e = frameLayout;
        this.f = linearLayout;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
    }

    public static ag a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ag.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ag a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ag)f.a(layoutInflater, 2131427389, viewGroup, bl2, e2);
    }

    public abstract void a(jp.co.jreast.jreastapp.commuter.favoriterouteedit.f var1);

    public abstract void b(Integer var1);
}

