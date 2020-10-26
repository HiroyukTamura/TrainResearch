/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.text.Layout
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewPropertyAnimator
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.snackbar.a;

public class SnackbarContentLayout
extends LinearLayout
implements a {
    private TextView a;
    private Button b;
    private int c;
    private int d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, a.i.SnackbarLayout);
        this.c = context.getDimensionPixelSize(a.i.SnackbarLayout_android_maxWidth, -1);
        this.d = context.getDimensionPixelSize(a.i.SnackbarLayout_maxActionInlineWidth, -1);
        context.recycle();
    }

    private static void a(View view, int n2, int n3) {
        if (t.t(view)) {
            t.a(view, t.g(view), n2, t.h(view), n3);
            return;
        }
        view.setPadding(view.getPaddingLeft(), n2, view.getPaddingRight(), n3);
    }

    private boolean a(int n2, int n3, int n4) {
        boolean bl2;
        if (n2 != this.getOrientation()) {
            this.setOrientation(n2);
            bl2 = true;
        } else {
            bl2 = false;
        }
        if (this.a.getPaddingTop() != n3 || this.a.getPaddingBottom() != n4) {
            SnackbarContentLayout.a((View)this.a, n3, n4);
            bl2 = true;
        }
        return bl2;
    }

    void a(float f2) {
        if (f2 != 1.0f) {
            int n2 = this.b.getCurrentTextColor();
            n2 = com.google.android.material.e.a.a(com.google.android.material.e.a.a((View)this, a.b.colorSurface), n2, f2);
            this.b.setTextColor(n2);
        }
    }

    @Override
    public void a(int n2, int n3) {
        this.a.setAlpha(0.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.a.animate().alpha(1.0f);
        long l2 = n3;
        viewPropertyAnimator = viewPropertyAnimator.setDuration(l2);
        long l3 = n2;
        viewPropertyAnimator.setStartDelay(l3).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration(l2).setStartDelay(l3).start();
        }
    }

    @Override
    public void b(int n2, int n3) {
        this.a.setAlpha(1.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.a.animate().alpha(0.0f);
        long l2 = n3;
        viewPropertyAnimator = viewPropertyAnimator.setDuration(l2);
        long l3 = n2;
        viewPropertyAnimator.setStartDelay(l3).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration(l2).setStartDelay(l3).start();
        }
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView)this.findViewById(a.e.snackbar_text);
        this.b = (Button)this.findViewById(a.e.snackbar_action);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        int n4 = n2;
        if (this.c > 0) {
            n4 = n2;
            if (this.getMeasuredWidth() > this.c) {
                n4 = View.MeasureSpec.makeMeasureSpec((int)this.c, (int)1073741824);
                super.onMeasure(n4, n3);
            }
        }
        int n5 = this.getResources().getDimensionPixelSize(a.c.design_snackbar_padding_vertical_2lines);
        int n6 = this.getResources().getDimensionPixelSize(a.c.design_snackbar_padding_vertical);
        n2 = this.a.getLayout().getLineCount();
        int n7 = 1;
        if ((n2 = n2 > 1 ? 1 : 0) != 0 && this.d > 0 && this.b.getMeasuredWidth() > this.d) {
            if (!this.a(1, n5, n5 - n6)) return;
            n2 = n7;
        } else {
            n2 = n2 != 0 ? n5 : n6;
            if (!this.a(0, n2, n2)) return;
            n2 = n7;
        }
        if (n2 == 0) return;
        super.onMeasure(n4, n3);
    }
}

