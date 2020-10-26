/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.a;
import androidx.core.h.t;

public class ButtonBarLayout
extends LinearLayout {
    private boolean a;
    private int b = -1;
    private int c = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, a.j.ButtonBarLayout);
        this.a = context.getBoolean(a.j.ButtonBarLayout_allowStacking, true);
        context.recycle();
    }

    private int a(int n2) {
        int n3 = this.getChildCount();
        while (n2 < n3) {
            if (this.getChildAt(n2).getVisibility() == 0) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private boolean a() {
        return this.getOrientation() == 1;
    }

    private void setStacked(boolean bl2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public int getMinimumHeight() {
        return Math.max(this.c, super.getMinimumHeight());
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5 = View.MeasureSpec.getSize((int)n2);
        boolean bl2 = this.a;
        int n6 = 0;
        if (bl2) {
            if (n5 > this.b && this.a()) {
                this.setStacked(false);
            }
            this.b = n5;
        }
        if (!this.a() && View.MeasureSpec.getMode((int)n2) == 1073741824) {
            n4 = View.MeasureSpec.makeMeasureSpec((int)n5, (int)Integer.MIN_VALUE);
            n5 = 1;
        } else {
            n4 = n2;
            n5 = 0;
        }
        super.onMeasure(n4, n3);
        int n7 = n5;
        if (this.a) {
            n7 = n5;
            if (!this.a()) {
                n4 = (this.getMeasuredWidthAndState() & -16777216) == 16777216 ? 1 : 0;
                n7 = n5;
                if (n4 != 0) {
                    this.setStacked(true);
                    n7 = 1;
                }
            }
        }
        if (n7 != 0) {
            super.onMeasure(n2, n3);
        }
        n5 = this.a(0);
        n2 = n6;
        if (n5 >= 0) {
            View view = this.getChildAt(n5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            n3 = this.getPaddingTop() + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (this.a()) {
                n5 = this.a(n5 + 1);
                n2 = n3;
                if (n5 >= 0) {
                    n2 = n3 + (this.getChildAt(n5).getPaddingTop() + (int)(this.getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                n2 = n3 + this.getPaddingBottom();
            }
        }
        if (t.l((View)this) != n2) {
            this.setMinimumHeight(n2);
        }
    }

    public void setAllowStacking(boolean bl2) {
        if (this.a != bl2) {
            this.a = bl2;
            if (!this.a && this.getOrientation() == 1) {
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }
}

