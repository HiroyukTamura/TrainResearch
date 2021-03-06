/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewDebug
 *  android.view.ViewDebug$ExportedProperty
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.au;

public class ActionMenuView
extends ab
implements h.b,
p {
    h.a a;
    e b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private androidx.appcompat.widget.c g;
    private o.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.k = (int)(56.0f * f2);
        this.l = (int)(f2 * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int n2, int n3, int n4, int n5) {
        c c2 = (c)view.getLayoutParams();
        int n6 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n4) - n5), (int)View.MeasureSpec.getMode((int)n4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView)view : null;
        boolean bl2 = true;
        n4 = actionMenuItemView != null && actionMenuItemView.b() ? 1 : 0;
        n5 = 2;
        if (n3 > 0 && (n4 == 0 || n3 >= 2)) {
            int n7;
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 * n2), (int)Integer.MIN_VALUE), n6);
            int n8 = view.getMeasuredWidth();
            n3 = n7 = n8 / n2;
            if (n8 % n2 != 0) {
                n3 = n7 + 1;
            }
            if (n4 != 0 && n3 < 2) {
                n3 = n5;
            }
        } else {
            n3 = 0;
        }
        if (c2.a || n4 == 0) {
            bl2 = false;
        }
        c2.d = bl2;
        c2.b = n3;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)(n2 * n3), (int)1073741824), n6);
        return n3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void c(int var1_1, int var2_2) {
        block33 : {
            var20_3 = View.MeasureSpec.getMode((int)var2_2);
            var1_1 = View.MeasureSpec.getSize((int)var1_1);
            var7_4 = View.MeasureSpec.getSize((int)var2_2);
            var5_5 = this.getPaddingLeft();
            var6_6 = this.getPaddingRight();
            var14_7 = this.getPaddingTop() + this.getPaddingBottom();
            var10_8 = ActionMenuView.getChildMeasureSpec((int)var2_2, (int)var14_7, (int)-2);
            var11_9 = var1_1 - (var5_5 + var6_6);
            var1_1 = var11_9 / this.k;
            var2_2 = this.k;
            if (var1_1 == 0) {
                this.setMeasuredDimension(var11_9, 0);
                return;
            }
            var21_10 = this.k + var11_9 % var2_2 / var1_1;
            var16_11 = this.getChildCount();
            var8_13 = 0;
            var5_5 = 0;
            var13_14 = 0;
            var12_15 = 0;
            var6_6 = 0;
            var22_16 = 0L;
            var2_2 = var7_4;
            for (var9_12 = 0; var9_12 < var16_11; ++var9_12) {
                var31_20 = this.getChildAt(var9_12);
                if (var31_20.getVisibility() == 8) continue;
                var30_19 = var31_20 instanceof ActionMenuItemView;
                ++var13_14;
                if (var30_19) {
                    var31_20.setPadding(this.l, 0, this.l, 0);
                }
                var32_17 = (c)var31_20.getLayoutParams();
                var32_17.f = false;
                var32_17.c = 0;
                var32_17.b = 0;
                var32_17.d = false;
                var32_17.leftMargin = 0;
                var32_17.rightMargin = 0;
                var30_19 = var30_19 != false && ((ActionMenuItemView)var31_20).b() != false;
                var32_17.e = var30_19;
                var7_4 = var32_17.a != false ? 1 : var1_1;
                var15_18 = ActionMenuView.a(var31_20, var21_10, var7_4, var10_8, var14_7);
                var12_15 = Math.max(var12_15, var15_18);
                var7_4 = var6_6;
                if (var32_17.d) {
                    var7_4 = var6_6 + 1;
                }
                if (var32_17.a) {
                    var5_5 = 1;
                }
                var1_1 -= var15_18;
                var8_13 = Math.max(var8_13, var31_20.getMeasuredHeight());
                if (var15_18 == 1) {
                    var22_16 |= (long)(1 << var9_12);
                }
                var6_6 = var7_4;
            }
            var14_7 = var5_5 != 0 && var13_14 == 2 ? 1 : 0;
            var17_28 = 0;
            var15_18 = var1_1;
            var7_4 = var16_11;
            var9_12 = var10_8;
            var1_1 = var17_28;
            while (var6_6 > 0 && var15_18 > 0) {
                var18_29 = 0;
                var16_11 = Integer.MAX_VALUE;
                var26_32 = 0L;
                for (var17_28 = 0; var17_28 < var7_4; ++var17_28) {
                    var31_22 = (c)this.getChildAt(var17_28).getLayoutParams();
                    if (!var31_22.d) {
                        var10_8 = var18_29;
                        var19_30 = var16_11;
                        var24_31 = var26_32;
                    } else if (var31_22.b < var16_11) {
                        var19_30 = var31_22.b;
                        var24_31 = 1L << var17_28;
                        var10_8 = 1;
                    } else {
                        var10_8 = var18_29;
                        var19_30 = var16_11;
                        var24_31 = var26_32;
                        if (var31_22.b == var16_11) {
                            var24_31 = var26_32 | 1L << var17_28;
                            var10_8 = var18_29 + 1;
                            var19_30 = var16_11;
                        }
                    }
                    var18_29 = var10_8;
                    var16_11 = var19_30;
                    var26_32 = var24_31;
                }
                var22_16 |= var26_32;
                if (var18_29 > var15_18) break;
                for (var1_1 = 0; var1_1 < var7_4; ++var1_1) {
                    var31_23 = this.getChildAt(var1_1);
                    var32_17 = (c)var31_23.getLayoutParams();
                    var28_33 = 1 << var1_1;
                    if ((var26_32 & var28_33) == 0L) {
                        var10_8 = var15_18;
                        var24_31 = var22_16;
                        if (var32_17.b == var16_11 + 1) {
                            var24_31 = var22_16 | var28_33;
                            var10_8 = var15_18;
                        }
                    } else {
                        if (var14_7 != 0 && var32_17.e && var15_18 == 1) {
                            var31_23.setPadding(this.l + var21_10, 0, this.l, 0);
                        }
                        ++var32_17.b;
                        var32_17.f = true;
                        var10_8 = var15_18 - 1;
                        var24_31 = var22_16;
                    }
                    var15_18 = var10_8;
                    var22_16 = var24_31;
                }
                var1_1 = 1;
            }
            var5_5 = var5_5 == 0 && var13_14 == 1 ? 1 : 0;
            if (var15_18 <= 0 || var22_16 == 0L || var15_18 >= var13_14 - 1 && var5_5 == 0 && var12_15 <= true) break block33;
            var4_34 = Long.bitCount(var22_16);
            if (var5_5 == 0) {
                if ((var22_16 & 1L) != 0L) {
                    var3_35 = var4_34;
                    if (!((c)this.getChildAt((int)0).getLayoutParams()).e) {
                        var3_35 = var4_34 - 0.5f;
                    }
                } else {
                    var3_35 = var4_34;
                }
                var5_5 = var7_4 - 1;
                var4_34 = var3_35;
                if ((var22_16 & (long)(1 << var5_5)) != 0L) {
                    var4_34 = var3_35;
                    if (!((c)this.getChildAt((int)var5_5).getLayoutParams()).e) {
                        var4_34 = var3_35 - 0.5f;
                    }
                }
            }
            var5_5 = var4_34 > 0.0f ? (int)((float)(var15_18 * var21_10) / var4_34) : 0;
            var12_15 = var7_4;
            for (var6_6 = 0; var6_6 < var12_15; ++var6_6) {
                block35 : {
                    block36 : {
                        block34 : {
                            if ((var22_16 & (long)(1 << var6_6)) != 0L) break block34;
                            var10_8 = var1_1;
                            break block35;
                        }
                        var31_25 = this.getChildAt(var6_6);
                        var32_17 = (c)var31_25.getLayoutParams();
                        if (!(var31_25 instanceof ActionMenuItemView)) break block36;
                        var32_17.c = var5_5;
                        var32_17.f = true;
                        if (var6_6 == 0 && !var32_17.e) {
                            var32_17.leftMargin = -var5_5 / 2;
                        }
                        ** GOTO lbl146
                    }
                    if (var32_17.a) {
                        var32_17.c = var5_5;
                        var32_17.f = true;
                        var32_17.rightMargin = -var5_5 / 2;
lbl146: // 2 sources:
                        var10_8 = 1;
                    } else {
                        if (var6_6 != 0) {
                            var32_17.leftMargin = var5_5 / 2;
                        }
                        var10_8 = var1_1;
                        if (var6_6 != var12_15 - 1) {
                            var32_17.rightMargin = var5_5 / 2;
                            var10_8 = var1_1;
                        }
                    }
                }
                var1_1 = var10_8;
            }
        }
        var5_5 = 0;
        if (var1_1 != 0) {
            for (var1_1 = var5_5; var1_1 < var7_4; ++var1_1) {
                var31_27 = this.getChildAt(var1_1);
                var32_17 = (c)var31_27.getLayoutParams();
                if (!var32_17.f) continue;
                var31_27.measure(View.MeasureSpec.makeMeasureSpec((int)(var32_17.b * var21_10 + var32_17.c), (int)1073741824), var9_12);
            }
        }
        if (var20_3 != 1073741824) {
            var2_2 = var8_13;
        }
        this.setMeasuredDimension(var11_9, var2_2);
    }

    public c a(AttributeSet attributeSet) {
        return new c(this.getContext(), attributeSet);
    }

    protected c a(ViewGroup.LayoutParams object) {
        if (object != null) {
            object = object instanceof c ? new c((c)((Object)object)) : new c((ViewGroup.LayoutParams)object);
            if (object.h <= 0) {
                object.h = 16;
            }
            return object;
        }
        return this.b();
    }

    @Override
    public void a(h h2) {
        this.c = h2;
    }

    public void a(o.a a2, h.a a3) {
        this.h = a2;
        this.a = a3;
    }

    public boolean a() {
        return this.f;
    }

    protected boolean a(int n2) {
        boolean bl2 = false;
        if (n2 == 0) {
            return false;
        }
        View view = this.getChildAt(n2 - 1);
        View view2 = this.getChildAt(n2);
        boolean bl3 = bl2;
        if (n2 < this.getChildCount()) {
            bl3 = bl2;
            if (view instanceof a) {
                bl3 = false | ((a)view).d();
            }
        }
        bl2 = bl3;
        if (n2 > 0) {
            bl2 = bl3;
            if (view2 instanceof a) {
                bl2 = bl3 | ((a)view2).c();
            }
        }
        return bl2;
    }

    @Override
    public boolean a(j j2) {
        return this.c.a(j2, 0);
    }

    protected c b() {
        c c2 = new c(-2, -2);
        c2.h = 16;
        return c2;
    }

    @Override
    public /* synthetic */ ab.a b(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    @Override
    protected /* synthetic */ ab.a b(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public c c() {
        c c2 = this.b();
        c2.a = true;
        return c2;
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && layoutParams instanceof c;
    }

    public h d() {
        return this.c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.d();
    }

    public boolean f() {
        return this.g != null && this.g.e();
    }

    public boolean g() {
        return this.g != null && this.g.h();
    }

    @Override
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.b();
    }

    @Override
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    @Override
    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public Menu getMenu() {
        if (this.c == null) {
            Object object = this.getContext();
            this.c = new h((Context)object);
            this.c.a(new d());
            this.g = new androidx.appcompat.widget.c((Context)object);
            this.g.b(true);
            androidx.appcompat.widget.c c2 = this.g;
            object = this.h != null ? this.h : new b();
            c2.a((o.a)object);
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.g != null && this.g.i();
    }

    public void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    @Override
    protected /* synthetic */ ab.a j() {
        return this.b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.a(false);
            if (this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i();
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6;
        c c2;
        View view;
        int n7;
        if (!this.i) {
            super.onLayout(bl2, n2, n3, n4, n5);
            return;
        }
        int n8 = this.getChildCount();
        int n9 = (n5 - n3) / 2;
        int n10 = this.getDividerWidth();
        int n11 = n4 - n2;
        n2 = this.getPaddingRight();
        n3 = this.getPaddingLeft();
        bl2 = au.a((View)this);
        n2 = n11 - n2 - n3;
        n5 = 0;
        n4 = 0;
        for (n3 = 0; n3 < n8; ++n3) {
            view = this.getChildAt(n3);
            if (view.getVisibility() == 8) continue;
            c2 = (c)view.getLayoutParams();
            if (c2.a) {
                n5 = n6 = view.getMeasuredWidth();
                if (this.a(n3)) {
                    n5 = n6 + n10;
                }
                int n12 = view.getMeasuredHeight();
                if (bl2) {
                    n7 = this.getPaddingLeft() + c2.leftMargin;
                    n6 = n7 + n5;
                } else {
                    n6 = this.getWidth() - this.getPaddingRight() - c2.rightMargin;
                    n7 = n6 - n5;
                }
                int n13 = n9 - n12 / 2;
                view.layout(n7, n13, n6, n12 + n13);
                n2 -= n5;
                n5 = 1;
                continue;
            }
            n2 -= view.getMeasuredWidth() + c2.leftMargin + c2.rightMargin;
            this.a(n3);
            ++n4;
        }
        if (n8 == 1 && n5 == 0) {
            view = this.getChildAt(0);
            n2 = view.getMeasuredWidth();
            n3 = view.getMeasuredHeight();
            n4 = n11 / 2 - n2 / 2;
            n5 = n9 - n3 / 2;
            view.layout(n4, n5, n2 + n4, n3 + n5);
            return;
        }
        n3 = n4 - (n5 ^ 1);
        n2 = n3 > 0 ? (n2 /= n3) : 0;
        n5 = 0;
        n4 = 0;
        n6 = Math.max(0, n2);
        if (bl2) {
            n3 = this.getWidth() - this.getPaddingRight();
            for (n2 = n4; n2 < n8; ++n2) {
                view = this.getChildAt(n2);
                c2 = (c)view.getLayoutParams();
                n4 = n3;
                if (view.getVisibility() != 8) {
                    if (c2.a) {
                        n4 = n3;
                    } else {
                        n4 = view.getMeasuredWidth();
                        n5 = view.getMeasuredHeight();
                        n7 = n9 - n5 / 2;
                        view.layout((n3 -= c2.rightMargin) - n4, n7, n3, n5 + n7);
                        n4 = n3 - (n4 + c2.leftMargin + n6);
                    }
                }
                n3 = n4;
            }
        } else {
            n3 = this.getPaddingLeft();
            for (n2 = n5; n2 < n8; ++n2) {
                view = this.getChildAt(n2);
                c2 = (c)view.getLayoutParams();
                n4 = n3;
                if (view.getVisibility() != 8) {
                    if (c2.a) {
                        n4 = n3;
                    } else {
                        n4 = view.getMeasuredWidth();
                        n5 = view.getMeasuredHeight();
                        n7 = n9 - n5 / 2;
                        view.layout(n3 += c2.leftMargin, n7, n3 + n4, n5 + n7);
                        n4 = n3 + (n4 + c2.rightMargin + n6);
                    }
                }
                n3 = n4;
            }
        }
    }

    @Override
    protected void onMeasure(int n2, int n3) {
        boolean bl2 = this.i;
        boolean bl3 = View.MeasureSpec.getMode((int)n2) == 1073741824;
        this.i = bl3;
        if (bl2 != this.i) {
            this.j = 0;
        }
        int n4 = View.MeasureSpec.getSize((int)n2);
        if (this.i && this.c != null && n4 != this.j) {
            this.j = n4;
            this.c.b(true);
        }
        int n5 = this.getChildCount();
        if (this.i && n5 > 0) {
            this.c(n2, n3);
            return;
        }
        for (n4 = 0; n4 < n5; ++n4) {
            c c2 = (c)this.getChildAt(n4).getLayoutParams();
            c2.rightMargin = 0;
            c2.leftMargin = 0;
        }
        super.onMeasure(n2, n3);
    }

    public void setExpandedActionViewsExclusive(boolean bl2) {
        this.g.c(bl2);
    }

    public void setOnMenuItemClickListener(e e2) {
        this.b = e2;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.getMenu();
        this.g.a(drawable2);
    }

    public void setOverflowReserved(boolean bl2) {
        this.f = bl2;
    }

    public void setPopupTheme(int n2) {
        if (this.e != n2) {
            this.e = n2;
            if (n2 == 0) {
                this.d = this.getContext();
                return;
            }
            this.d = new ContextThemeWrapper(this.getContext(), n2);
        }
    }

    public void setPresenter(androidx.appcompat.widget.c c2) {
        this.g = c2;
        this.g.a(this);
    }

    public static interface a {
        public boolean c();

        public boolean d();
    }

    private static class b
    implements o.a {
        b() {
        }

        @Override
        public void a(h h2, boolean bl2) {
        }

        @Override
        public boolean a(h h2) {
            return false;
        }
    }

    public static class c
    extends ab.a {
        @ViewDebug.ExportedProperty
        public boolean a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty
        public boolean d;
        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(int n2, int n3) {
            super(n2, n3);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c c2) {
            super((ViewGroup.LayoutParams)c2);
            this.a = c2.a;
        }
    }

    private class d
    implements h.a {
        d() {
        }

        @Override
        public void a(h h2) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(h2);
            }
        }

        @Override
        public boolean a(h h2, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }
    }

    public static interface e {
        public boolean a(MenuItem var1);
    }

}

