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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;

public abstract class ao
extends ViewDataBinding {
    public final TextView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final TextView f;
    public final RecyclerView g;
    public final TextView h;
    protected j i;

    protected ao(e e2, View view, int n2, TextView textView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView2, RecyclerView recyclerView, TextView textView3) {
        super(e2, view, n2);
        this.c = textView;
        this.d = appCompatImageView;
        this.e = linearLayout;
        this.f = textView2;
        this.g = recyclerView;
        this.h = textView3;
    }

    public static ao a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ao.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ao a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ao)f.a(layoutInflater, 2131427394, viewGroup, bl2, e2);
    }

    public abstract void a(j var1);
}

