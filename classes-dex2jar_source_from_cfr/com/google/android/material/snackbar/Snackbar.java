/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.material.snackbar.a;

public final class Snackbar
extends BaseTransientBottomBar<Snackbar> {
    private static final int[] f = new int[]{a.b.snackbarButtonStyle};
    private final AccessibilityManager d;
    private boolean e;

    private Snackbar(ViewGroup viewGroup, View view, a a2) {
        super(viewGroup, view, a2);
        this.d = (AccessibilityManager)viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        View view2 = view;
        do {
            if (view2 instanceof CoordinatorLayout) {
                return (ViewGroup)view2;
            }
            viewGroup = viewGroup2;
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup)view2;
                }
                viewGroup = (ViewGroup)view2;
            }
            view = view2;
            if (view2 != null && !((view = view2.getParent()) instanceof View)) {
                view = null;
            }
            viewGroup2 = viewGroup;
            view2 = view;
        } while (view != null);
        return viewGroup;
    }

    public static Snackbar a(View object, CharSequence charSequence, int n2) {
        if ((object = Snackbar.a((View)object)) != null) {
            Object object2 = LayoutInflater.from((Context)object.getContext());
            int n3 = Snackbar.a(object.getContext()) ? a.g.mtrl_layout_snackbar_include : a.g.design_layout_snackbar_include;
            object2 = (SnackbarContentLayout)object2.inflate(n3, (ViewGroup)object, false);
            object = new Snackbar((ViewGroup)object, (View)object2, (a)object2);
            ((Snackbar)object).a(charSequence);
            ((BaseTransientBottomBar)object).a(n2);
            return object;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    protected static boolean a(Context context) {
        context = context.obtainStyledAttributes(f);
        boolean bl2 = false;
        int n2 = context.getResourceId(0, -1);
        context.recycle();
        if (n2 != -1) {
            bl2 = true;
        }
        return bl2;
    }

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout)this.b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @Override
    public int c() {
        if (this.e && this.d.isTouchExplorationEnabled()) {
            return -2;
        }
        return super.c();
    }

    @Override
    public void e() {
        super.e();
    }

    @Override
    public void f() {
        super.f();
    }

    public static final class SnackbarLayout
    extends BaseTransientBottomBar.e {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected void onMeasure(int n2, int n3) {
            super.onMeasure(n2, n3);
            n3 = this.getChildCount();
            int n4 = this.getMeasuredWidth();
            int n5 = this.getPaddingLeft();
            int n6 = this.getPaddingRight();
            for (n2 = 0; n2 < n3; ++n2) {
                View view = this.getChildAt(n2);
                if (view.getLayoutParams().width != -1) continue;
                view.measure(View.MeasureSpec.makeMeasureSpec((int)(n4 - n5 - n6), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)view.getMeasuredHeight(), (int)1073741824));
            }
        }
    }

}

