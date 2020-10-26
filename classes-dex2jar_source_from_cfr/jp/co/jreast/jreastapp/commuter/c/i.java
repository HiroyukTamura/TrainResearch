/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.favoriteroute.b;

public abstract class i
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatEditText e;
    public final Button f;
    protected b g;

    protected i(e e2, View view, int n2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatEditText appCompatEditText, Button button) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatEditText;
        this.f = button;
    }

    public abstract void a(b var1);
}

