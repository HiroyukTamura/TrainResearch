/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.t;

public class ContentFrameLayout
extends FrameLayout {
    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g = new Rect();
    private a h;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.g.set(n2, n3, n4, n5);
        if (t.y((View)this)) {
            this.requestLayout();
        }
    }

    public void a(Rect rect) {
        this.fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != null) {
            this.h.a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.b();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onMeasure(int var1_1, int var2_2) {
        block15 : {
            block13 : {
                block14 : {
                    block12 : {
                        var11_3 = this.getContext().getResources().getDisplayMetrics();
                        var4_4 = var11_3.widthPixels;
                        var5_5 = var11_3.heightPixels;
                        var8_6 = 1;
                        var4_4 = var4_4 < var5_5 ? 1 : 0;
                        var9_7 = View.MeasureSpec.getMode((int)var1_1);
                        var7_8 = View.MeasureSpec.getMode((int)var2_2);
                        if (var9_7 != Integer.MIN_VALUE || (var10_9 = var4_4 != 0 ? this.d : this.c) == null || var10_9.type == 0) ** GOTO lbl-1000
                        if (var10_9.type != 5) break block12;
                        var3_10 = var10_9.getDimension(var11_3);
                        ** GOTO lbl15
                    }
                    if (var10_9.type == 6) {
                        var3_10 = var10_9.getFraction((float)var11_3.widthPixels, (float)var11_3.widthPixels);
lbl15: // 2 sources:
                        var5_5 = (int)var3_10;
                    } else {
                        var5_5 = 0;
                    }
                    if (var5_5 > 0) {
                        var6_11 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var5_5 - (this.g.left + this.g.right), View.MeasureSpec.getSize((int)var1_1)), (int)1073741824);
                        var1_1 = 1;
                    } else lbl-1000: // 2 sources:
                    {
                        var6_11 = var1_1;
                        var1_1 = 0;
                    }
                    var5_5 = var2_2;
                    if (var7_8 != Integer.MIN_VALUE) break block13;
                    var10_9 = var4_4 != 0 ? this.e : this.f;
                    var5_5 = var2_2;
                    if (var10_9 == null) break block13;
                    var5_5 = var2_2;
                    if (var10_9.type == 0) break block13;
                    if (var10_9.type != 5) break block14;
                    var3_10 = var10_9.getDimension(var11_3);
                    ** GOTO lbl37
                }
                if (var10_9.type == 6) {
                    var3_10 = var10_9.getFraction((float)var11_3.heightPixels, (float)var11_3.heightPixels);
lbl37: // 2 sources:
                    var7_8 = (int)var3_10;
                } else {
                    var7_8 = 0;
                }
                var5_5 = var2_2;
                if (var7_8 > 0) {
                    var5_5 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var7_8 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize((int)var2_2)), (int)1073741824);
                }
            }
            super.onMeasure(var6_11, var5_5);
            var7_8 = this.getMeasuredWidth();
            var6_11 = View.MeasureSpec.makeMeasureSpec((int)var7_8, (int)1073741824);
            if (var1_1 != 0 || var9_7 != Integer.MIN_VALUE || (var10_9 = var4_4 != 0 ? this.b : this.a) == null || var10_9.type == 0) ** GOTO lbl-1000
            if (var10_9.type != 5) break block15;
            var3_10 = var10_9.getDimension(var11_3);
            ** GOTO lbl54
        }
        if (var10_9.type == 6) {
            var3_10 = var10_9.getFraction((float)var11_3.widthPixels, (float)var11_3.widthPixels);
lbl54: // 2 sources:
            var1_1 = (int)var3_10;
        } else {
            var1_1 = 0;
        }
        var2_2 = var1_1;
        if (var1_1 > 0) {
            var2_2 = var1_1 - (this.g.left + this.g.right);
        }
        if (var7_8 < var2_2) {
            var2_2 = View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)1073741824);
            var1_1 = var8_6;
        } else lbl-1000: // 2 sources:
        {
            var1_1 = 0;
            var2_2 = var6_11;
        }
        if (var1_1 == 0) return;
        super.onMeasure(var2_2, var5_5);
    }

    public void setAttachListener(a a2) {
        this.h = a2;
    }

    public static interface a {
        public void a();

        public void b();
    }

}

