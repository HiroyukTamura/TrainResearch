/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;

public abstract class am
extends ViewDataBinding {
    public final RecyclerView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final ProgressBar f;
    public final ConstraintLayout g;
    public final AppCompatImageView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final Button k;
    protected g l;

    protected am(e e2, View view, int n2, RecyclerView recyclerView, TextView textView, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView2, ConstraintLayout constraintLayout3, Button button) {
        super(e2, view, n2);
        this.c = recyclerView;
        this.d = textView;
        this.e = constraintLayout;
        this.f = progressBar;
        this.g = constraintLayout2;
        this.h = appCompatImageView;
        this.i = textView2;
        this.j = constraintLayout3;
        this.k = button;
    }

    public abstract void a(g var1);
}

