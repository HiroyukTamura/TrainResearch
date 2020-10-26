/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package androidx.b.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.b.a.b;
import androidx.b.a.c;
import androidx.b.a.d;
import androidx.b.a.e;
import androidx.b.a.f;

public class a
extends FrameLayout {
    private static final int[] d;
    private static final f e;
    int a;
    int b;
    final Rect c;
    private boolean f;
    private boolean g;
    private final e h;

    /*
     * Enabled aggressive block sorting
     */
    static {
        void var0_1;
        d = new int[]{16842801};
        if (Build.VERSION.SDK_INT >= 21) {
            c c2 = new c();
        } else if (Build.VERSION.SDK_INT >= 17) {
            b b2 = new b();
        } else {
            d d2 = new d();
        }
        e = var0_1;
        e.a();
    }

    public ColorStateList getCardBackgroundColor() {
        return e.i(this.h);
    }

    public float getCardElevation() {
        return e.e(this.h);
    }

    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.c.left;
    }

    public int getContentPaddingRight() {
        return this.c.right;
    }

    public int getContentPaddingTop() {
        return this.c.top;
    }

    public float getMaxCardElevation() {
        return e.a(this.h);
    }

    public boolean getPreventCornerOverlap() {
        return this.g;
    }

    public float getRadius() {
        return e.d(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.f;
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = n2;
        int n5 = n3;
        if (!(e instanceof c)) {
            n5 = View.MeasureSpec.getMode((int)n2);
            if (n5 == Integer.MIN_VALUE || n5 == 1073741824) {
                n2 = View.MeasureSpec.makeMeasureSpec((int)Math.max((int)Math.ceil(e.b(this.h)), View.MeasureSpec.getSize((int)n2)), (int)n5);
            }
            n5 = View.MeasureSpec.getMode((int)n3);
            if (n5 != Integer.MIN_VALUE && n5 != 1073741824) {
                n4 = n2;
                n5 = n3;
            } else {
                n5 = View.MeasureSpec.makeMeasureSpec((int)Math.max((int)Math.ceil(e.c(this.h)), View.MeasureSpec.getSize((int)n3)), (int)n5);
                n4 = n2;
            }
        }
        super.onMeasure(n4, n5);
    }

    public void setCardBackgroundColor(int n2) {
        e.a(this.h, ColorStateList.valueOf((int)n2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        e.a(this.h, colorStateList);
    }

    public void setCardElevation(float f2) {
        e.c(this.h, f2);
    }

    public void setMaxCardElevation(float f2) {
        e.b(this.h, f2);
    }

    public void setMinimumHeight(int n2) {
        this.b = n2;
        super.setMinimumHeight(n2);
    }

    public void setMinimumWidth(int n2) {
        this.a = n2;
        super.setMinimumWidth(n2);
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
    }

    public void setPaddingRelative(int n2, int n3, int n4, int n5) {
    }

    public void setPreventCornerOverlap(boolean bl2) {
        if (bl2 != this.g) {
            this.g = bl2;
            e.h(this.h);
        }
    }

    public void setRadius(float f2) {
        e.a(this.h, f2);
    }

    public void setUseCompatPadding(boolean bl2) {
        if (this.f != bl2) {
            this.f = bl2;
            e.g(this.h);
        }
    }
}

