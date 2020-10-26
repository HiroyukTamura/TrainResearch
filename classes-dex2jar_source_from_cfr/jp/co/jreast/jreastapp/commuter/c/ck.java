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

public abstract class ck
extends ViewDataBinding {
    public final AppCompatImageButton c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final ConstraintLayout g;
    public final AppCompatImageView h;
    public final TextView i;
    protected j j;

    protected ck(e e2, View view, int n2, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView3) {
        super(e2, view, n2);
        this.c = appCompatImageButton;
        this.d = constraintLayout;
        this.e = textView;
        this.f = textView2;
        this.g = constraintLayout2;
        this.h = appCompatImageView;
        this.i = textView3;
    }

    public abstract void a(j var1);
}

