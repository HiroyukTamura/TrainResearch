/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;

public abstract class ba
extends ViewDataBinding {
    public final Button c;
    public final Button d;
    public final TextView e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final LinearLayout i;
    public final TextView j;
    public final Button k;
    public final Button l;
    public final TextView m;
    public final LinearLayout n;
    public final Button o;
    public final Button p;
    public final TextView q;
    public final Button r;
    public final TextView s;
    public final LinearLayout t;
    public final TextView u;
    public final TextView v;
    protected j w;
    protected d x;

    protected ba(e e2, View view, int n2, Button button, Button button2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, LinearLayout linearLayout2, TextView textView4, Button button3, Button button4, TextView textView5, LinearLayout linearLayout3, Button button5, Button button6, TextView textView6, Button button7, TextView textView7, LinearLayout linearLayout4, TextView textView8, TextView textView9) {
        super(e2, view, n2);
        this.c = button;
        this.d = button2;
        this.e = textView;
        this.f = linearLayout;
        this.g = textView2;
        this.h = textView3;
        this.i = linearLayout2;
        this.j = textView4;
        this.k = button3;
        this.l = button4;
        this.m = textView5;
        this.n = linearLayout3;
        this.o = button5;
        this.p = button6;
        this.q = textView6;
        this.r = button7;
        this.s = textView7;
        this.t = linearLayout4;
        this.u = textView8;
        this.v = textView9;
    }

    public static ba a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ba.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ba a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ba)f.a(layoutInflater, 2131427400, viewGroup, bl2, e2);
    }

    public abstract void a(d var1);

    public abstract void a(j var1);
}

