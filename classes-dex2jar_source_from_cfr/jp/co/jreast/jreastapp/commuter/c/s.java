/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;

public abstract class s
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final RecyclerView d;
    public final AppCompatTextView e;
    protected d f;

    protected s(e e2, View view, int n2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = recyclerView;
        this.e = appCompatTextView;
    }

    public abstract void a(d var1);
}

