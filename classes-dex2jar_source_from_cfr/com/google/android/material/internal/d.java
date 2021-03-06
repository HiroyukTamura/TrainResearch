/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.Gravity
 */
package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.ab;
import com.google.android.material.a;
import com.google.android.material.internal.f;

public class d
extends ab {
    protected boolean a = true;
    boolean b = false;
    private Drawable c;
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private int f = 119;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        context = f.a(context, attributeSet, a.i.ForegroundLinearLayout, n2, 0, new int[0]);
        this.f = context.getInt(a.i.ForegroundLinearLayout_android_foregroundGravity, this.f);
        attributeSet = context.getDrawable(a.i.ForegroundLinearLayout_android_foreground);
        if (attributeSet != null) {
            this.setForeground((Drawable)attributeSet);
        }
        this.a = context.getBoolean(a.i.ForegroundLinearLayout_foregroundInsidePadding, true);
        context.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.c != null) {
            Drawable drawable2 = this.c;
            if (this.b) {
                this.b = false;
                Rect rect = this.d;
                Rect rect2 = this.e;
                int n2 = this.getRight() - this.getLeft();
                int n3 = this.getBottom() - this.getTop();
                if (this.a) {
                    rect.set(0, 0, n2, n3);
                } else {
                    rect.set(this.getPaddingLeft(), this.getPaddingTop(), n2 - this.getPaddingRight(), n3 - this.getPaddingBottom());
                }
                Gravity.apply((int)this.f, (int)drawable2.getIntrinsicWidth(), (int)drawable2.getIntrinsicHeight(), (Rect)rect, (Rect)rect2);
                drawable2.setBounds(rect2);
            }
            drawable2.draw(canvas);
        }
    }

    @TargetApi(value=21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        if (this.c != null) {
            this.c.setHotspot(f2, f3);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(this.getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.c;
    }

    public int getForegroundGravity() {
        return this.f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.b = bl2 | this.b;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.b = true;
    }

    public void setForeground(Drawable drawable2) {
        if (this.c != drawable2) {
            if (this.c != null) {
                this.c.setCallback(null);
                this.unscheduleDrawable(this.c);
            }
            this.c = drawable2;
            if (drawable2 != null) {
                this.setWillNotDraw(false);
                drawable2.setCallback((Drawable.Callback)this);
                if (drawable2.isStateful()) {
                    drawable2.setState(this.getDrawableState());
                }
                if (this.f == 119) {
                    drawable2.getPadding(new Rect());
                }
            } else {
                this.setWillNotDraw(true);
            }
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setForegroundGravity(int n2) {
        if (this.f != n2) {
            int n3 = n2;
            if ((8388615 & n2) == 0) {
                n3 = n2 | 8388611;
            }
            n2 = n3;
            if ((n3 & 112) == 0) {
                n2 = n3 | 48;
            }
            this.f = n2;
            if (this.f == 119 && this.c != null) {
                Rect rect = new Rect();
                this.c.getPadding(rect);
            }
            this.requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return super.verifyDrawable(drawable2) || drawable2 == this.c;
        {
        }
    }
}

