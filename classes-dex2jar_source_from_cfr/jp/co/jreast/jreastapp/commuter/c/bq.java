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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.d;

public abstract class bq
extends ViewDataBinding {
    public final View c;
    public final TextView d;
    protected d e;
    protected RailwayLineInformation f;

    protected bq(e e2, View view, int n2, View view2, TextView textView) {
        super(e2, view, n2);
        this.c = view2;
        this.d = textView;
    }

    public static bq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bq.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bq a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bq)f.a(layoutInflater, 2131427408, viewGroup, bl2, e2);
    }

    public abstract void a(RailwayLineInformation var1);

    public abstract void a(d var1);
}

