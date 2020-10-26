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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;
import jp.co.jreast.jreastapp.commuter.model.Station;

public abstract class di
extends ViewDataBinding {
    public final AppCompatImageButton c;
    public final View d;
    public final ConstraintLayout e;
    public final TextView f;
    protected c g;
    protected Station h;

    protected di(e e2, View view, int n2, AppCompatImageButton appCompatImageButton, View view2, ConstraintLayout constraintLayout, TextView textView) {
        super(e2, view, n2);
        this.c = appCompatImageButton;
        this.d = view2;
        this.e = constraintLayout;
        this.f = textView;
    }

    public static di a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        return di.a(layoutInflater, viewGroup, bl2, f.a());
    }

    public static di a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, e e2) {
        return (di)f.a(layoutInflater, 2131427455, viewGroup, bl2, e2);
    }

    public abstract void a(c var1);

    public abstract void a(Station var1);
}

