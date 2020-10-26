/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.c.a;
import androidx.core.h.ab;
import androidx.core.h.d;
import androidx.core.h.t;
import com.google.android.material.appbar.c;
import java.util.List;

abstract class b
extends c<View> {
    final Rect a = new Rect();
    final Rect b = new Rect();
    private int c = 0;
    private int d;

    public b() {
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int n2) {
        int n3 = n2;
        if (n2 == 0) {
            n3 = 8388659;
        }
        return n3;
    }

    float a(View view) {
        return 1.0f;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2, int n3, int n4, int n5) {
        View view2;
        int n6 = view.getLayoutParams().height;
        if ((n6 == -1 || n6 == -2) && (view2 = this.b(coordinatorLayout.c(view))) != null) {
            int n7;
            if (t.r(view2) && !t.r(view)) {
                t.b(view, true);
                if (t.r(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            n4 = n7 = View.MeasureSpec.getSize((int)n4);
            if (n7 == 0) {
                n4 = coordinatorLayout.getHeight();
            }
            n4 += this.b(view2);
            n7 = view2.getMeasuredHeight();
            if (this.b()) {
                view.setTranslationY((float)(-n7));
            } else {
                n4 -= n7;
            }
            n7 = n6 == -1 ? 1073741824 : Integer.MIN_VALUE;
            coordinatorLayout.a(view, n2, n3, View.MeasureSpec.makeMeasureSpec((int)n4, (int)n7), n5);
            return true;
        }
        return false;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View b(List<View> var1);

    public final void b(int n2) {
        this.d = n2;
    }

    @Override
    protected void b(CoordinatorLayout coordinatorLayout, View view, int n2) {
        View view2 = this.b(coordinatorLayout.c(view));
        if (view2 != null) {
            CoordinatorLayout.e e2 = (CoordinatorLayout.e)view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + e2.leftMargin, view2.getBottom() + e2.topMargin, coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight() - e2.rightMargin, coordinatorLayout.getHeight() + view2.getBottom() - coordinatorLayout.getPaddingBottom() - e2.bottomMargin);
            ab ab2 = coordinatorLayout.getLastWindowInsets();
            if (ab2 != null && t.r((View)coordinatorLayout) && !t.r(view)) {
                rect.left += ab2.a();
                rect.right -= ab2.c();
            }
            coordinatorLayout = this.b;
            d.a(b.c(e2.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, (Rect)coordinatorLayout, n2);
            n2 = this.c(view2);
            view.layout(((Rect)coordinatorLayout).left, ((Rect)coordinatorLayout).top - n2, ((Rect)coordinatorLayout).right, ((Rect)coordinatorLayout).bottom - n2);
            n2 = ((Rect)coordinatorLayout).top - view2.getBottom();
        } else {
            super.b(coordinatorLayout, view, n2);
            n2 = 0;
        }
        this.c = n2;
    }

    protected boolean b() {
        return false;
    }

    final int c(View view) {
        if (this.d == 0) {
            return 0;
        }
        return a.a((int)(this.a(view) * (float)this.d), 0, this.d);
    }

    final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }
}

