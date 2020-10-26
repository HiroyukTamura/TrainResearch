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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;

public abstract class be
extends ViewDataBinding {
    public final AppCompatImageButton c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final TextView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final ConstraintLayout i;
    public final Toolbar j;
    protected jp.co.jreast.jreastapp.commuter.p.f k;

    protected be(e e2, View view, int n2, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ConstraintLayout constraintLayout2, Toolbar toolbar) {
        super(e2, view, n2);
        this.c = appCompatImageButton;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = textView;
        this.g = constraintLayout;
        this.h = textView2;
        this.i = constraintLayout2;
        this.j = toolbar;
    }

    public static be a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return be.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static be a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (be)f.a(layoutInflater, 2131427402, viewGroup, bl2, e2);
    }

    public abstract void a(jp.co.jreast.jreastapp.commuter.p.f var1);
}

