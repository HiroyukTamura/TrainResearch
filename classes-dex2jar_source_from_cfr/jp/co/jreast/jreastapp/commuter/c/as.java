/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;

public abstract class as
extends ViewDataBinding {
    public final FrameLayout c;

    protected as(e e2, View view, int n2, FrameLayout frameLayout) {
        super(e2, view, n2);
        this.c = frameLayout;
    }

    public static as a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return as.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static as a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (as)f.a(layoutInflater, 2131427396, viewGroup, bl2, e2);
    }
}

