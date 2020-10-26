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
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.n.k;

public abstract class da
extends ViewDataBinding {
    public final TextView c;
    public final AppCompatImageView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final LinearLayout g;
    protected k h;
    protected RailwayLine i;

    protected da(e e2, View view, int n2, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        super(e2, view, n2);
        this.c = textView;
        this.d = appCompatImageView;
        this.e = textView2;
        this.f = constraintLayout;
        this.g = linearLayout;
    }

    public static da a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return da.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static da a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (da)f.a(layoutInflater, 2131427447, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLine var1);

    public abstract void a(k var1);

    public k j() {
        return this.h;
    }

    public RailwayLine k() {
        return this.i;
    }
}

