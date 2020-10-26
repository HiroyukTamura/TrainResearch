/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import jp.co.jreast.jreastapp.commuter.webview.j;

public abstract class ci
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final AppCompatImageButton g;
    protected j h;

    protected ci(e e2, View view, int n2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = textView;
        this.e = textView2;
        this.f = constraintLayout;
        this.g = appCompatImageButton;
    }

    public abstract void a(j var1);
}

