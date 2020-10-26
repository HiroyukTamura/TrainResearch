/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.e;

public abstract class q
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatButton d;
    public final AppCompatTextView e;
    public final AppCompatImageView f;
    public final AppCompatTextView g;
    protected e h;

    protected q(androidx.databinding.e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView2) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatButton;
        this.e = appCompatTextView;
        this.f = appCompatImageView2;
        this.g = appCompatTextView2;
    }

    public abstract void a(e var1);
}

