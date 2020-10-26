/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public abstract class bm
extends ViewDataBinding {
    public final AppCompatImageView c;
    public final ConstraintLayout d;
    public final AppCompatTextView e;

    protected bm(e e2, View view, int n2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        super(e2, view, n2);
        this.c = appCompatImageView;
        this.d = constraintLayout;
        this.e = appCompatTextView;
    }
}

