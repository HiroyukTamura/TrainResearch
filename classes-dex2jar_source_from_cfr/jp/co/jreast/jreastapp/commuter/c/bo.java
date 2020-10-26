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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.common.h;
import jp.co.jreast.jreastapp.commuter.others.d;

public abstract class bo
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final TextView d;
    protected d e;
    protected h f;

    protected bo(e e2, View view, int n2, AppCompatImageView appCompatImageView, TextView textView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = textView;
    }

    public static bo a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return bo.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static bo a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (bo)f.a(layoutInflater, 2131427407, viewGroup, bl2, e2);
    }

    public abstract void a(h var1);

    public abstract void a(d var1);
}

