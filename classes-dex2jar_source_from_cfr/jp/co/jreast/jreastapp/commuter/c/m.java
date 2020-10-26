/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.jreast.jreastapp.commuter.others.d;

public abstract class m
extends ViewDataBinding {
    public final RecyclerView c;
    public final Toolbar d;
    protected d e;

    protected m(e e2, View view, int n2, RecyclerView recyclerView, Toolbar toolbar) {
        super(e2, view, n2);
        this.c = recyclerView;
        this.d = toolbar;
    }

    public abstract void a(d var1);
}

