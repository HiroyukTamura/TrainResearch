/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;

public abstract class e
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final AppCompatImageView h;
    public final AppCompatEditText i;
    public final TextView j;
    public final RecyclerView k;
    protected c l;

    protected e(androidx.databinding.e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView3, AppCompatEditText appCompatEditText, TextView textView4, RecyclerView recyclerView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = appCompatImageView3;
        this.i = appCompatEditText;
        this.j = textView4;
        this.k = recyclerView;
    }

    public abstract void a(c var1);
}

