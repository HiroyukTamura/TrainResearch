/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;

public abstract class g
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final View d;
    public final RecyclerView e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final AppCompatTextView j;
    protected f k;

    protected g(e e2, View view, int n2, AppCompatImageView appCompatImageView, View view2, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = view2;
        this.e = recyclerView;
        this.f = linearLayout;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = appCompatTextView;
    }

    public abstract void a(f var1);
}

