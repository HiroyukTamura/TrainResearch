/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.trainlocation.d;

public abstract class c
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final AppCompatImageView f;
    public final AppCompatEditText g;
    protected d h;

    protected c(e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, AppCompatImageView appCompatImageView3, AppCompatEditText appCompatEditText) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = recyclerView;
        this.f = appCompatImageView3;
        this.g = appCompatEditText;
    }

    public abstract void a(d var1);
}

