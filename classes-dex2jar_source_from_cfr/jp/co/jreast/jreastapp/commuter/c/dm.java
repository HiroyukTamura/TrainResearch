/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.c;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.legacy.widget.Space;

public abstract class dm
extends ViewDataBinding {
    public final LinearLayout c;
    public final LinearLayout d;
    public final Space e;
    public final AppCompatImageView f;
    public final TextView g;
    public final ConstraintLayout h;

    protected dm(e e2, View view, int n2, LinearLayout linearLayout, LinearLayout linearLayout2, Space space, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout) {
        super(e2, view, n2);
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = space;
        this.f = appCompatImageView;
        this.g = textView;
        this.h = constraintLayout;
    }
}

