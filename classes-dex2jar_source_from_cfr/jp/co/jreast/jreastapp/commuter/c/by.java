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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public abstract class by
extends ViewDataBinding {
    public final TextView c;
    public final TextView d;
    public final AppCompatImageView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    protected y i;
    protected RailwayLineInformation j;

    protected by(e e2, View view, int n2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, TextView textView3, TextView textView4, TextView textView5) {
        super(e2, view, n2);
        this.c = textView;
        this.d = textView2;
        this.e = appCompatImageView;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
    }

    public static by a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return by.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static by a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (by)f.a(layoutInflater, 2131427414, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLineInformation var1);

    public abstract void a(y var1);
}

