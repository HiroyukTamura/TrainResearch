/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
extends ViewGroup {
    private int a = -1;

    public BaselineLayout(Context context) {
        super(context, null, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public int getBaseline() {
        return this.a;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        int n7 = this.getPaddingLeft();
        int n8 = this.getPaddingRight();
        int n9 = this.getPaddingTop();
        for (n3 = 0; n3 < n6; ++n3) {
            View view = this.getChildAt(n3);
            if (view.getVisibility() == 8) continue;
            int n10 = view.getMeasuredWidth();
            int n11 = view.getMeasuredHeight();
            int n12 = (n4 - n2 - n8 - n7 - n10) / 2 + n7;
            n5 = this.a != -1 && view.getBaseline() != -1 ? this.a + n9 - view.getBaseline() : n9;
            view.layout(n12, n5, n10 + n12, n11 + n5);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5 = this.getChildCount();
        int n6 = -1;
        int n7 = -1;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            this.measureChild(view, n2, n3);
            int n11 = view.getBaseline();
            n4 = n6;
            int n12 = n7;
            if (n11 != -1) {
                n4 = Math.max(n6, n11);
                n12 = Math.max(n7, view.getMeasuredHeight() - n11);
            }
            n9 = Math.max(n9, view.getMeasuredWidth());
            n8 = Math.max(n8, view.getMeasuredHeight());
            n10 = View.combineMeasuredStates((int)n10, (int)view.getMeasuredState());
            n7 = n12;
            n6 = n4;
        }
        n4 = n8;
        if (n6 != -1) {
            n4 = Math.max(n8, Math.max(n7, this.getPaddingBottom()) + n6);
            this.a = n6;
        }
        n8 = Math.max(n4, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n9, this.getSuggestedMinimumWidth()), (int)n2, (int)n10), View.resolveSizeAndState((int)n8, (int)n3, (int)(n10 << 16)));
    }
}

