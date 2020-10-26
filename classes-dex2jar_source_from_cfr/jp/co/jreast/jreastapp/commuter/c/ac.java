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
import jp.co.jreast.jreastapp.commuter.common.o;
import jp.co.jreast.jreastapp.commuter.common.view.ScalableImageView;

public abstract class ac
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final ScalableImageView d;
    protected o e;

    protected ac(e e2, View view, int n2, AppCompatImageView appCompatImageView, ScalableImageView scalableImageView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = scalableImageView;
    }

    public static ac a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return ac.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static ac a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (ac)f.a(layoutInflater, 2131427387, viewGroup, bl2, e2);
    }

    public abstract void a(o var1);
}

