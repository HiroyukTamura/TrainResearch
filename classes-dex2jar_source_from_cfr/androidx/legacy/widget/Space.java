/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public class Space
extends View {
    @Deprecated
    public Space(Context context) {
        this(context, null);
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        if (this.getVisibility() == 0) {
            this.setVisibility(4);
        }
    }

    private static int a(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n3);
        int n5 = View.MeasureSpec.getSize((int)n3);
        if (n4 != Integer.MIN_VALUE) {
            n3 = n2;
            if (n4 != 0) {
                if (n4 != 1073741824) {
                    return n2;
                }
                return n5;
            }
        } else {
            n3 = Math.min(n2, n5);
        }
        return n3;
    }

    @Deprecated
    @SuppressLint(value={"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Deprecated
    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(Space.a(this.getSuggestedMinimumWidth(), n2), Space.a(this.getSuggestedMinimumHeight(), n3));
    }
}

