/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.q.h;

public abstract class cc
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final View d;
    protected h e;

    protected cc(e e2, View view, int n2, AppCompatImageView appCompatImageView, View view2) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = view2;
    }

    public static cc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cc.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cc a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cc)f.a(layoutInflater, 2131427416, viewGroup, bl2, e2);
    }

    public abstract void a(h var1);
}

