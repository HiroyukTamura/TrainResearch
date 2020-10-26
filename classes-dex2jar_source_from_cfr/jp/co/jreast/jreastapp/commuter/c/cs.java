/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;

public abstract class cs
extends ViewDataBinding {
    public final Button c;
    public final LinearLayout d;
    public final ConstraintLayout e;

    protected cs(e e2, View view, int n2, Button button, LinearLayout linearLayout, ConstraintLayout constraintLayout) {
        super(e2, view, n2);
        this.c = button;
        this.d = linearLayout;
        this.e = constraintLayout;
    }

    public static cs a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return cs.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static cs a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (cs)f.a(layoutInflater, 2131427443, viewGroup, bl2, e2);
    }
}

