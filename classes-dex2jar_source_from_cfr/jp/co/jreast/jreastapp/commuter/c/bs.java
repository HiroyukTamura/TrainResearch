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

public abstract class bs
extends ViewDataBinding {
    public final TextView c;
    public final AppCompatImageView d;
    public final TextView e;
    protected y f;
    protected RailwayLineInformation g;

    protected bs(e e2, View view, int n2, TextView textView, AppCompatImageView appCompatImageView, TextView textView2) {
        super(e2, view, n2);
        this.c = textView;
        this.d = appCompatImageView;
        this.e = textView2;
    }

    public static bs a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bs.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bs a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bs)f.a(layoutInflater, 2131427411, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLineInformation var1);

    public abstract void a(y var1);
}

