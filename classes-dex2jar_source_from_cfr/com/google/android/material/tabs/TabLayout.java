/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.text.Layout
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.IBinder;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.aq;
import androidx.core.g.d;
import androidx.core.h.q;
import androidx.core.h.t;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout
extends HorizontalScrollView {
    private static final d.a<f> w = new d.c<f>(16);
    private final e A;
    private final int B;
    private final int C;
    private final int D;
    private int E;
    private b F;
    private final ArrayList<b> G;
    private b H;
    private ValueAnimator I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private g L;
    private a M;
    private boolean N;
    private final d.a<h> O;
    int a;
    int b;
    int c;
    int d;
    int e;
    ColorStateList f;
    ColorStateList g;
    ColorStateList h;
    Drawable i;
    PorterDuff.Mode j;
    float k;
    float l;
    final int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    boolean u;
    ViewPager v;
    private final ArrayList<f> x;
    private f y;
    private final RectF z;

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.tabStyle);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int n2) {
        TypedArray typedArray;
        block4 : {
            super(context, attributeSet, n2);
            this.x = new ArrayList();
            this.z = new RectF();
            this.n = Integer.MAX_VALUE;
            this.G = new ArrayList();
            this.O = new d.b<h>(12);
            this.setHorizontalScrollBarEnabled(false);
            this.A = new e(context);
            super.addView((View)this.A, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
            typedArray = com.google.android.material.internal.f.a(context, attributeSet, a.i.TabLayout, n2, a.h.Widget_Design_TabLayout, a.i.TabLayout_tabTextAppearance);
            this.A.b(typedArray.getDimensionPixelSize(a.i.TabLayout_tabIndicatorHeight, -1));
            this.A.a(typedArray.getColor(a.i.TabLayout_tabIndicatorColor, 0));
            this.setSelectedTabIndicator(com.google.android.material.i.b.b(context, typedArray, a.i.TabLayout_tabIndicator));
            this.setSelectedTabIndicatorGravity(typedArray.getInt(a.i.TabLayout_tabIndicatorGravity, 0));
            this.setTabIndicatorFullWidth(typedArray.getBoolean(a.i.TabLayout_tabIndicatorFullWidth, true));
            this.d = n2 = typedArray.getDimensionPixelSize(a.i.TabLayout_tabPadding, 0);
            this.c = n2;
            this.b = n2;
            this.a = n2;
            this.a = typedArray.getDimensionPixelSize(a.i.TabLayout_tabPaddingStart, this.a);
            this.b = typedArray.getDimensionPixelSize(a.i.TabLayout_tabPaddingTop, this.b);
            this.c = typedArray.getDimensionPixelSize(a.i.TabLayout_tabPaddingEnd, this.c);
            this.d = typedArray.getDimensionPixelSize(a.i.TabLayout_tabPaddingBottom, this.d);
            this.e = typedArray.getResourceId(a.i.TabLayout_tabTextAppearance, a.h.TextAppearance_Design_Tab);
            attributeSet = context.obtainStyledAttributes(this.e, a.j.TextAppearance);
            this.k = attributeSet.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
            this.f = com.google.android.material.i.b.a(context, (TypedArray)attributeSet, a.j.TextAppearance_android_textColor);
            if (!typedArray.hasValue(a.i.TabLayout_tabTextColor)) break block4;
            this.f = com.google.android.material.i.b.a(context, typedArray, a.i.TabLayout_tabTextColor);
        }
        if (typedArray.hasValue(a.i.TabLayout_tabSelectedTextColor)) {
            n2 = typedArray.getColor(a.i.TabLayout_tabSelectedTextColor, 0);
            this.f = TabLayout.a(this.f.getDefaultColor(), n2);
        }
        this.g = com.google.android.material.i.b.a(context, typedArray, a.i.TabLayout_tabIconTint);
        this.j = com.google.android.material.internal.g.a(typedArray.getInt(a.i.TabLayout_tabIconTintMode, -1), null);
        this.h = com.google.android.material.i.b.a(context, typedArray, a.i.TabLayout_tabRippleColor);
        this.p = typedArray.getInt(a.i.TabLayout_tabIndicatorAnimationDuration, 300);
        this.B = typedArray.getDimensionPixelSize(a.i.TabLayout_tabMinWidth, -1);
        this.C = typedArray.getDimensionPixelSize(a.i.TabLayout_tabMaxWidth, -1);
        this.m = typedArray.getResourceId(a.i.TabLayout_tabBackground, 0);
        this.E = typedArray.getDimensionPixelSize(a.i.TabLayout_tabContentStart, 0);
        this.r = typedArray.getInt(a.i.TabLayout_tabMode, 1);
        this.o = typedArray.getInt(a.i.TabLayout_tabGravity, 0);
        this.s = typedArray.getBoolean(a.i.TabLayout_tabInlineLabel, false);
        this.u = typedArray.getBoolean(a.i.TabLayout_tabUnboundedRipple, false);
        typedArray.recycle();
        context = this.getResources();
        this.l = context.getDimensionPixelSize(a.c.design_tab_text_size_2line);
        this.D = context.getDimensionPixelSize(a.c.design_tab_scrollable_min_width);
        this.h();
        return;
        finally {
            attributeSet.recycle();
        }
    }

    private int a(int n2, float f2) {
        int n3 = this.r;
        int n4 = 0;
        if (n3 == 0) {
            View view = this.A.getChildAt(n2);
            View view2 = ++n2 < this.A.getChildCount() ? this.A.getChildAt(n2) : null;
            n2 = view != null ? view.getWidth() : 0;
            if (view2 != null) {
                n4 = view2.getWidth();
            }
            n3 = view.getLeft() + n2 / 2 - this.getWidth() / 2;
            n2 = (int)((float)(n2 + n4) * 0.5f * f2);
            if (t.f((View)this) == 0) {
                return n3 + n2;
            }
            return n3 - n2;
        }
        return 0;
    }

    private static ColorStateList a(int n2, int n3) {
        return new ColorStateList((int[][])new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{n3, n2});
    }

    private void a(View view) {
        if (view instanceof com.google.android.material.tabs.a) {
            this.a((com.google.android.material.tabs.a)view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.r == 1 && this.o == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    private void a(ViewPager viewPager, boolean bl2, boolean bl3) {
        if (this.v != null) {
            if (this.L != null) {
                this.v.b(this.L);
            }
            if (this.M != null) {
                this.v.b(this.M);
            }
        }
        if (this.H != null) {
            this.b(this.H);
            this.H = null;
        }
        if (viewPager != null) {
            this.v = viewPager;
            if (this.L == null) {
                this.L = new g(this);
            }
            this.L.a();
            viewPager.a(this.L);
            this.H = new i(viewPager);
            this.a(this.H);
            androidx.viewpager.widget.a a2 = viewPager.getAdapter();
            if (a2 != null) {
                this.a(a2, bl2);
            }
            if (this.M == null) {
                this.M = new a();
            }
            this.M.a(bl2);
            viewPager.a(this.M);
            this.a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.v = null;
            this.a((androidx.viewpager.widget.a)null, false);
        }
        this.N = bl3;
    }

    private void a(f f2, int n2) {
        f2.b(n2);
        this.x.add(n2, f2);
        int n3 = this.x.size();
        while (++n2 < n3) {
            this.x.get(n2).b(n2);
        }
    }

    private void a(com.google.android.material.tabs.a a2) {
        f f2 = this.a();
        if (a2.a != null) {
            f2.a(a2.a);
        }
        if (a2.b != null) {
            f2.a(a2.b);
        }
        if (a2.c != 0) {
            f2.a(a2.c);
        }
        if (!TextUtils.isEmpty((CharSequence)a2.getContentDescription())) {
            f2.b(a2.getContentDescription());
        }
        this.a(f2);
    }

    private void c(int n2) {
        h h2 = (h)this.A.getChildAt(n2);
        this.A.removeViewAt(n2);
        if (h2 != null) {
            h2.a();
            this.O.a(h2);
        }
        this.requestLayout();
    }

    /*
     * Enabled aggressive block sorting
     */
    private h d(f object) {
        h h2 = this.O != null ? this.O.a() : null;
        h h3 = h2;
        if (h2 == null) {
            h3 = new h(this.getContext());
        }
        h3.a((f)object);
        h3.setFocusable(true);
        h3.setMinimumWidth(this.getTabMinWidth());
        object = TextUtils.isEmpty((CharSequence)((f)object).f) ? ((f)object).e : ((f)object).f;
        h3.setContentDescription((CharSequence)object);
        return h3;
    }

    private void d(int n2) {
        if (n2 == -1) {
            return;
        }
        if (this.getWindowToken() != null && t.y((View)this) && !this.A.a()) {
            int n3;
            int n4 = this.getScrollX();
            if (n4 != (n3 = this.a(n2, 0.0f))) {
                this.g();
                this.I.setIntValues(new int[]{n4, n3});
                this.I.start();
            }
            this.A.b(n2, this.p);
            return;
        }
        this.a(n2, 0.0f, true);
    }

    private void e() {
        int n2 = this.x.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.x.get(i2).g();
        }
    }

    private void e(f f2) {
        h h2 = f2.b;
        h2.setSelected(false);
        h2.setActivated(false);
        this.A.addView((View)h2, f2.c(), (ViewGroup.LayoutParams)this.f());
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.a(layoutParams);
        return layoutParams;
    }

    private void f(f f2) {
        for (int i2 = this.G.size() - 1; i2 >= 0; --i2) {
            this.G.get(i2).a(f2);
        }
    }

    private void g() {
        if (this.I == null) {
            this.I = new ValueAnimator();
            this.I.setInterpolator(com.google.android.material.a.a.b);
            this.I.setDuration((long)this.p);
            this.I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer)valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void g(f f2) {
        for (int i2 = this.G.size() - 1; i2 >= 0; --i2) {
            this.G.get(i2).b(f2);
        }
    }

    private int getDefaultHeight() {
        boolean bl2;
        int n2 = this.x.size();
        boolean bl3 = false;
        int n3 = 0;
        do {
            bl2 = bl3;
            if (n3 >= n2) break;
            f f2 = this.x.get(n3);
            if (f2 != null && f2.b() != null && !TextUtils.isEmpty((CharSequence)f2.d())) {
                bl2 = true;
                break;
            }
            ++n3;
        } while (true);
        if (bl2 && !this.s) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.B != -1) {
            return this.B;
        }
        if (this.r == 0) {
            return this.D;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, this.A.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }

    private void h() {
        int n2 = this.r == 0 ? Math.max(0, this.E - this.a) : 0;
        t.a((View)this.A, n2, 0, 0, 0);
        switch (this.r) {
            default: {
                break;
            }
            case 1: {
                this.A.setGravity(1);
                break;
            }
            case 0: {
                this.A.setGravity(8388611);
            }
        }
        this.a(true);
    }

    private void h(f f2) {
        for (int i2 = this.G.size() - 1; i2 >= 0; --i2) {
            this.G.get(i2).c(f2);
        }
    }

    private void setSelectedTabView(int n2) {
        int n3 = this.A.getChildCount();
        if (n2 < n3) {
            for (int i2 = 0; i2 < n3; ++i2) {
                View view = this.A.getChildAt(i2);
                boolean bl2 = true;
                boolean bl3 = i2 == n2;
                view.setSelected(bl3);
                bl3 = i2 == n2 ? bl2 : false;
                view.setActivated(bl3);
            }
        }
    }

    public f a() {
        f f2 = this.b();
        f2.a = this;
        f2.b = this.d(f2);
        return f2;
    }

    public f a(int n2) {
        if (n2 >= 0 && n2 < this.getTabCount()) {
            return this.x.get(n2);
        }
        return null;
    }

    public void a(int n2, float f2, boolean bl2) {
        this.a(n2, f2, bl2, true);
    }

    void a(int n2, float f2, boolean bl2, boolean bl3) {
        int n3 = Math.round((float)n2 + f2);
        if (n3 >= 0) {
            if (n3 >= this.A.getChildCount()) {
                return;
            }
            if (bl3) {
                this.A.a(n2, f2);
            }
            if (this.I != null && this.I.isRunning()) {
                this.I.cancel();
            }
            this.scrollTo(this.a(n2, f2), 0);
            if (bl2) {
                this.setSelectedTabView(n3);
            }
        }
    }

    public void a(ViewPager viewPager, boolean bl2) {
        this.a(viewPager, bl2, false);
    }

    void a(androidx.viewpager.widget.a a2, boolean bl2) {
        if (this.J != null && this.K != null) {
            this.J.b(this.K);
        }
        this.J = a2;
        if (bl2 && a2 != null) {
            if (this.K == null) {
                this.K = new d();
            }
            a2.a(this.K);
        }
        this.d();
    }

    public void a(b b2) {
        if (!this.G.contains(b2)) {
            this.G.add(b2);
        }
    }

    public void a(f f2) {
        this.a(f2, this.x.isEmpty());
    }

    public void a(f f2, int n2, boolean bl2) {
        if (f2.a == this) {
            this.a(f2, n2);
            this.e(f2);
            if (bl2) {
                f2.e();
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void a(f f2, boolean bl2) {
        this.a(f2, this.x.size(), bl2);
    }

    void a(boolean bl2) {
        for (int i2 = 0; i2 < this.A.getChildCount(); ++i2) {
            View view = this.A.getChildAt(i2);
            view.setMinimumWidth(this.getTabMinWidth());
            this.a((LinearLayout.LayoutParams)view.getLayoutParams());
            if (!bl2) continue;
            view.requestLayout();
        }
    }

    public void addView(View view) {
        this.a(view);
    }

    public void addView(View view, int n2) {
        this.a(view);
    }

    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        this.a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a(view);
    }

    int b(int n2) {
        return Math.round(this.getResources().getDisplayMetrics().density * (float)n2);
    }

    protected f b() {
        f f2;
        f f3 = f2 = w.a();
        if (f2 == null) {
            f3 = new f();
        }
        return f3;
    }

    public void b(b b2) {
        this.G.remove(b2);
    }

    void b(f f2, boolean bl2) {
        f f3 = this.y;
        if (f3 == f2) {
            if (f3 != null) {
                this.h(f2);
                this.d(f2.c());
                return;
            }
        } else {
            int n2 = f2 != null ? f2.c() : -1;
            if (bl2) {
                if ((f3 == null || f3.c() == -1) && n2 != -1) {
                    this.a(n2, 0.0f, true);
                } else {
                    this.d(n2);
                }
                if (n2 != -1) {
                    this.setSelectedTabView(n2);
                }
            }
            this.y = f2;
            if (f3 != null) {
                this.g(f3);
            }
            if (f2 != null) {
                this.f(f2);
            }
        }
    }

    protected boolean b(f f2) {
        return w.a(f2);
    }

    public void c() {
        for (int i2 = this.A.getChildCount() - 1; i2 >= 0; --i2) {
            this.c(i2);
        }
        Iterator<f> iterator = this.x.iterator();
        while (iterator.hasNext()) {
            f f2 = iterator.next();
            iterator.remove();
            f2.h();
            this.b(f2);
        }
        this.y = null;
    }

    void c(f f2) {
        this.b(f2, true);
    }

    void d() {
        this.c();
        if (this.J != null) {
            int n2;
            int n3 = this.J.b();
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(this.a().a(this.J.c(n2)), false);
            }
            if (this.v != null && n3 > 0 && (n2 = this.v.getCurrentItem()) != this.getSelectedTabPosition() && n2 < this.getTabCount()) {
                this.c(this.a(n2));
            }
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        if (this.y != null) {
            return this.y.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.x.size();
    }

    public int getTabGravity() {
        return this.o;
    }

    public ColorStateList getTabIconTint() {
        return this.g;
    }

    public int getTabIndicatorGravity() {
        return this.q;
    }

    int getTabMaxWidth() {
        return this.n;
    }

    public int getTabMode() {
        return this.r;
    }

    public ColorStateList getTabRippleColor() {
        return this.h;
    }

    public Drawable getTabSelectedIndicator() {
        return this.i;
    }

    public ColorStateList getTabTextColors() {
        return this.f;
    }

    protected void onAttachedToWindow() {
        ViewParent viewParent;
        super.onAttachedToWindow();
        if (this.v == null && (viewParent = this.getParent()) instanceof ViewPager) {
            this.a((ViewPager)viewParent, true, true);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            this.setupWithViewPager(null);
            this.N = false;
        }
    }

    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.A.getChildCount(); ++i2) {
            View view = this.A.getChildAt(i2);
            if (!(view instanceof h)) continue;
            ((h)view).a(canvas);
        }
        super.onDraw(canvas);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onMeasure(int var1_1, int var2_2) {
        block9 : {
            var3_3 = this.b(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
            var4_4 = View.MeasureSpec.getMode((int)var2_2);
            if (var4_4 != Integer.MIN_VALUE) {
                if (var4_4 == 0) {
                    var2_2 = View.MeasureSpec.makeMeasureSpec((int)var3_3, (int)1073741824);
                }
            } else {
                var2_2 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var3_3, View.MeasureSpec.getSize((int)var2_2)), (int)1073741824);
            }
            var3_3 = View.MeasureSpec.getSize((int)var1_1);
            if (View.MeasureSpec.getMode((int)var1_1) != 0) {
                var3_3 = this.C > 0 ? this.C : (var3_3 -= this.b(56));
                this.n = var3_3;
            }
            super.onMeasure(var1_1, var2_2);
            if (this.getChildCount() != 1) return;
            var1_1 = 0;
            var5_5 = this.getChildAt(0);
            switch (this.r) {
                default: {
                    ** break;
                }
                case 1: {
                    if (var5_5.getMeasuredWidth() != this.getMeasuredWidth()) {
                        break;
                    }
                    break block9;
                }
                case 0: {
                    if (var5_5.getMeasuredWidth() >= this.getMeasuredWidth()) break block9;
                }
            }
            var1_1 = 1;
            ** break;
        }
        if (var1_1 == 0) return;
        var1_1 = TabLayout.getChildMeasureSpec((int)var2_2, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)var5_5.getLayoutParams().height);
        var5_5.measure(View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824), var1_1);
    }

    public void setInlineLabel(boolean bl2) {
        if (this.s != bl2) {
            this.s = bl2;
            for (int i2 = 0; i2 < this.A.getChildCount(); ++i2) {
                View view = this.A.getChildAt(i2);
                if (!(view instanceof h)) continue;
                ((h)view).c();
            }
            this.h();
        }
    }

    public void setInlineLabelResource(int n2) {
        this.setInlineLabel(this.getResources().getBoolean(n2));
    }

    @Deprecated
    public void setOnTabSelectedListener(b b2) {
        if (this.F != null) {
            this.b(this.F);
        }
        this.F = b2;
        if (b2 != null) {
            this.a(b2);
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.g();
        this.I.addListener(animatorListener);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSelectedTabIndicator(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.appcompat.a.a.a.b(this.getContext(), n2) : null;
        this.setSelectedTabIndicator(drawable2);
    }

    public void setSelectedTabIndicator(Drawable drawable2) {
        if (this.i != drawable2) {
            this.i = drawable2;
            t.d((View)this.A);
        }
    }

    public void setSelectedTabIndicatorColor(int n2) {
        this.A.a(n2);
    }

    public void setSelectedTabIndicatorGravity(int n2) {
        if (this.q != n2) {
            this.q = n2;
            t.d((View)this.A);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int n2) {
        this.A.b(n2);
    }

    public void setTabGravity(int n2) {
        if (this.o != n2) {
            this.o = n2;
            this.h();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            this.e();
        }
    }

    public void setTabIconTintResource(int n2) {
        this.setTabIconTint(androidx.appcompat.a.a.a.a(this.getContext(), n2));
    }

    public void setTabIndicatorFullWidth(boolean bl2) {
        this.t = bl2;
        t.d((View)this.A);
    }

    public void setTabMode(int n2) {
        if (n2 != this.r) {
            this.r = n2;
            this.h();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            for (int i2 = 0; i2 < this.A.getChildCount(); ++i2) {
                colorStateList = this.A.getChildAt(i2);
                if (!(colorStateList instanceof h)) continue;
                ((h)colorStateList).a(this.getContext());
            }
        }
    }

    public void setTabRippleColorResource(int n2) {
        this.setTabRippleColor(androidx.appcompat.a.a.a.a(this.getContext(), n2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            this.e();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a a2) {
        this.a(a2, false);
    }

    public void setUnboundedRipple(boolean bl2) {
        if (this.u != bl2) {
            this.u = bl2;
            for (int i2 = 0; i2 < this.A.getChildCount(); ++i2) {
                View view = this.A.getChildAt(i2);
                if (!(view instanceof h)) continue;
                ((h)view).a(this.getContext());
            }
        }
    }

    public void setUnboundedRippleResource(int n2) {
        this.setUnboundedRipple(this.getResources().getBoolean(n2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.a(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return this.getTabScrollRange() > 0;
    }

    private class a
    implements ViewPager.e {
        private boolean b;

        a() {
        }

        @Override
        public void a(ViewPager viewPager, androidx.viewpager.widget.a a2, androidx.viewpager.widget.a a3) {
            if (TabLayout.this.v == viewPager) {
                TabLayout.this.a(a3, this.b);
            }
        }

        void a(boolean bl2) {
            this.b = bl2;
        }
    }

    public static interface b<T extends f> {
        public void a(T var1);

        public void b(T var1);

        public void c(T var1);
    }

    public static interface c
    extends b {
    }

    private class d
    extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            TabLayout.this.d();
        }

        public void onInvalidated() {
            TabLayout.this.d();
        }
    }

    private class e
    extends LinearLayout {
        int a;
        float b;
        private int d;
        private final Paint e;
        private final GradientDrawable f;
        private int g;
        private int h;
        private int i;
        private ValueAnimator j;

        e(Context context) {
            super(context);
            this.a = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.setWillNotDraw(false);
            this.e = new Paint();
            this.f = new GradientDrawable();
        }

        private void a(h h2, RectF rectF) {
            int n2;
            int n3 = n2 = h2.d();
            if (n2 < TabLayout.this.b(24)) {
                n3 = TabLayout.this.b(24);
            }
            n2 = (h2.getLeft() + h2.getRight()) / 2;
            rectF.set((float)(n2 - (n3 /= 2)), 0.0f, (float)(n2 + n3), 0.0f);
        }

        private void b() {
            int n2;
            int n3;
            View view = this.getChildAt(this.a);
            if (view != null && view.getWidth() > 0) {
                n3 = view.getLeft();
                n2 = view.getRight();
                int n4 = n3;
                int n5 = n2;
                if (!TabLayout.this.t) {
                    n4 = n3;
                    n5 = n2;
                    if (view instanceof h) {
                        this.a((h)view, TabLayout.this.z);
                        n4 = (int)TabLayout.a((TabLayout)TabLayout.this).left;
                        n5 = (int)TabLayout.a((TabLayout)TabLayout.this).right;
                    }
                }
                n3 = n4;
                n2 = n5;
                if (this.b > 0.0f) {
                    n3 = n4;
                    n2 = n5;
                    if (this.a < this.getChildCount() - 1) {
                        view = this.getChildAt(this.a + 1);
                        int n6 = view.getLeft();
                        int n7 = view.getRight();
                        n2 = n6;
                        n3 = n7;
                        if (!TabLayout.this.t) {
                            n2 = n6;
                            n3 = n7;
                            if (view instanceof h) {
                                this.a((h)view, TabLayout.this.z);
                                n2 = (int)TabLayout.a((TabLayout)TabLayout.this).left;
                                n3 = (int)TabLayout.a((TabLayout)TabLayout.this).right;
                            }
                        }
                        n4 = (int)(this.b * (float)n2 + (1.0f - this.b) * (float)n4);
                        n2 = (int)(this.b * (float)n3 + (1.0f - this.b) * (float)n5);
                        n3 = n4;
                    }
                }
            } else {
                n3 = -1;
                n2 = -1;
            }
            this.a(n3, n2);
        }

        void a(int n2) {
            if (this.e.getColor() != n2) {
                this.e.setColor(n2);
                t.d((View)this);
            }
        }

        void a(int n2, float f2) {
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
            }
            this.a = n2;
            this.b = f2;
            this.b();
        }

        void a(int n2, int n3) {
            if (n2 != this.h || n3 != this.i) {
                this.h = n2;
                this.i = n3;
                t.d((View)this);
            }
        }

        boolean a() {
            int n2 = this.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.getChildAt(i2).getWidth() > 0) continue;
                return true;
            }
            return false;
        }

        void b(int n2) {
            if (this.d != n2) {
                this.d = n2;
                t.d((View)this);
            }
        }

        void b(final int n2, int n3) {
            View view;
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
            }
            if ((view = this.getChildAt(n2)) == null) {
                this.b();
                return;
            }
            final int n4 = view.getLeft();
            final int n5 = view.getRight();
            final int n6 = n4;
            final int n7 = n5;
            if (!TabLayout.this.t) {
                n6 = n4;
                n7 = n5;
                if (view instanceof h) {
                    this.a((h)view, TabLayout.this.z);
                    n6 = (int)TabLayout.a((TabLayout)TabLayout.this).left;
                    n7 = (int)TabLayout.a((TabLayout)TabLayout.this).right;
                }
            }
            n4 = this.h;
            n5 = this.i;
            if (n4 != n6 || n5 != n7) {
                view = new ValueAnimator();
                this.j = view;
                view.setInterpolator(com.google.android.material.a.a.b);
                view.setDuration((long)n3);
                view.setFloatValues(new float[]{0.0f, 1.0f});
                view.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float f2 = valueAnimator.getAnimatedFraction();
                        e.this.a(com.google.android.material.a.a.a(n4, n6, f2), com.google.android.material.a.a.a(n5, n7, f2));
                    }
                });
                view.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                    public void onAnimationEnd(Animator animator) {
                        e.this.a = n2;
                        e.this.b = 0.0f;
                    }
                });
                view.start();
            }
        }

        public void draw(Canvas canvas) {
            Object object = TabLayout.this.i;
            int n2 = 0;
            int n3 = 0;
            int n4 = object != null ? TabLayout.this.i.getIntrinsicHeight() : 0;
            if (this.d >= 0) {
                n4 = this.d;
            }
            int n5 = n4;
            int n6 = n2;
            switch (TabLayout.this.q) {
                default: {
                    n5 = 0;
                    n6 = n2;
                    break;
                }
                case 1: {
                    n6 = (this.getHeight() - n4) / 2;
                    n5 = (this.getHeight() + n4) / 2;
                    break;
                }
                case 0: {
                    n3 = this.getHeight() - n4;
                }
                case 3: {
                    n5 = this.getHeight();
                    n6 = n3;
                }
                case 2: 
            }
            if (this.h >= 0 && this.i > this.h) {
                object = TabLayout.this.i != null ? TabLayout.this.i : this.f;
                object = androidx.core.graphics.drawable.a.g(object);
                object.setBounds(this.h, n6, this.i, n5);
                if (this.e != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        object.setColorFilter(this.e.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(object, this.e.getColor());
                    }
                }
                object.draw(canvas);
            }
            super.draw(canvas);
        }

        protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
            super.onLayout(bl2, n2, n3, n4, n5);
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
                long l2 = this.j.getDuration();
                this.b(this.a, Math.round((1.0f - this.j.getAnimatedFraction()) * (float)l2));
                return;
            }
            this.b();
        }

        protected void onMeasure(int n2, int n3) {
            super.onMeasure(n2, n3);
            if (View.MeasureSpec.getMode((int)n2) != 1073741824) {
                return;
            }
            int n4 = TabLayout.this.r;
            int n5 = 1;
            if (n4 == 1 && TabLayout.this.o == 1) {
                int n6;
                View view;
                int n7 = this.getChildCount();
                int n8 = 0;
                int n9 = 0;
                for (n4 = 0; n4 < n7; ++n4) {
                    view = this.getChildAt(n4);
                    n6 = n9;
                    if (view.getVisibility() == 0) {
                        n6 = Math.max(n9, view.getMeasuredWidth());
                    }
                    n9 = n6;
                }
                if (n9 <= 0) {
                    return;
                }
                n4 = TabLayout.this.b(16);
                if (n9 * n7 <= this.getMeasuredWidth() - n4 * 2) {
                    n4 = 0;
                    for (n6 = n8; n6 < n7; ++n6) {
                        view = (LinearLayout.LayoutParams)this.getChildAt(n6).getLayoutParams();
                        if (view.width == n9 && view.weight == 0.0f) continue;
                        view.width = n9;
                        view.weight = 0.0f;
                        n4 = 1;
                    }
                } else {
                    TabLayout.this.o = 0;
                    TabLayout.this.a(false);
                    n4 = n5;
                }
                if (n4 != 0) {
                    super.onMeasure(n2, n3);
                }
            }
        }

        public void onRtlPropertiesChanged(int n2) {
            super.onRtlPropertiesChanged(n2);
            if (Build.VERSION.SDK_INT < 23 && this.g != n2) {
                this.requestLayout();
                this.g = n2;
            }
        }

    }

    public static class f {
        public TabLayout a;
        public h b;
        private Object c;
        private Drawable d;
        private CharSequence e;
        private CharSequence f;
        private int g = -1;
        private View h;
        private int i = 1;

        public View a() {
            return this.h;
        }

        public f a(int n2) {
            return this.a(LayoutInflater.from((Context)this.b.getContext()).inflate(n2, (ViewGroup)this.b, false));
        }

        public f a(Drawable drawable2) {
            this.d = drawable2;
            this.g();
            return this;
        }

        public f a(View view) {
            this.h = view;
            this.g();
            return this;
        }

        public f a(CharSequence charSequence) {
            if (TextUtils.isEmpty((CharSequence)this.f) && !TextUtils.isEmpty((CharSequence)charSequence)) {
                this.b.setContentDescription(charSequence);
            }
            this.e = charSequence;
            this.g();
            return this;
        }

        public Drawable b() {
            return this.d;
        }

        public f b(CharSequence charSequence) {
            this.f = charSequence;
            this.g();
            return this;
        }

        void b(int n2) {
            this.g = n2;
        }

        public int c() {
            return this.g;
        }

        public CharSequence d() {
            return this.e;
        }

        public void e() {
            if (this.a != null) {
                this.a.c(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean f() {
            if (this.a != null) {
                return this.a.getSelectedTabPosition() == this.g;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void g() {
            if (this.b != null) {
                this.b.b();
            }
        }

        void h() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    public static class g
    implements ViewPager.f {
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        public g(TabLayout tabLayout) {
            this.a = new WeakReference<TabLayout>(tabLayout);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override
        public void a(int n2) {
            TabLayout tabLayout = (TabLayout)((Object)this.a.get());
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != n2 && n2 < tabLayout.getTabCount()) {
                boolean bl2 = this.c == 0 || this.c == 2 && this.b == 0;
                tabLayout.b(tabLayout.a(n2), bl2);
            }
        }

        @Override
        public void a(int n2, float f2, int n3) {
            TabLayout tabLayout = (TabLayout)((Object)this.a.get());
            if (tabLayout != null) {
                n3 = this.c;
                boolean bl2 = false;
                boolean bl3 = n3 != 2 || this.b == 1;
                if (this.c != 2 || this.b != 0) {
                    bl2 = true;
                }
                tabLayout.a(n2, f2, bl3, bl2);
            }
        }

        @Override
        public void b(int n2) {
            this.b = this.c;
            this.c = n2;
        }
    }

    class h
    extends LinearLayout {
        private f b;
        private TextView c;
        private ImageView d;
        private View e;
        private TextView f;
        private ImageView g;
        private Drawable h;
        private int i;

        public h(Context context) {
            super(context);
            this.i = 2;
            this.a(context);
            t.a((View)this, TabLayout.this.a, TabLayout.this.b, TabLayout.this.c, TabLayout.this.d);
            this.setGravity(17);
            this.setOrientation(TabLayout.this.s ^ true);
            this.setClickable(true);
            t.a((View)this, q.a(this.getContext(), 1002));
        }

        private float a(Layout layout2, int n2, float f2) {
            return layout2.getLineWidth(n2) * (f2 / layout2.getPaint().getTextSize());
        }

        private void a(Context context) {
            if (TabLayout.this.m != 0) {
                this.h = androidx.appcompat.a.a.a.b(context, TabLayout.this.m);
                if (this.h != null && this.h.isStateful()) {
                    this.h.setState(this.getDrawableState());
                }
            } else {
                this.h = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            context = gradientDrawable;
            if (TabLayout.this.h != null) {
                context = new GradientDrawable();
                context.setCornerRadius(1.0E-5f);
                context.setColor(-1);
                ColorStateList colorStateList = com.google.android.material.j.a.a(TabLayout.this.h);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.u) {
                        gradientDrawable = null;
                    }
                    if (TabLayout.this.u) {
                        context = null;
                    }
                    context = new RippleDrawable(colorStateList, (Drawable)gradientDrawable, (Drawable)context);
                } else {
                    context = androidx.core.graphics.drawable.a.g((Drawable)context);
                    androidx.core.graphics.drawable.a.a((Drawable)context, colorStateList);
                    context = new LayerDrawable(new Drawable[]{gradientDrawable, context});
                }
            }
            t.a((View)this, (Drawable)context);
            TabLayout.this.invalidate();
        }

        private void a(Canvas canvas) {
            if (this.h != null) {
                this.h.setBounds(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
                this.h.draw(canvas);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(TextView object, ImageView imageView) {
            boolean bl2;
            void var1_8;
            block14 : {
                void var2_9;
                ViewGroup.MarginLayoutParams marginLayoutParams;
                block16 : {
                    int n2;
                    block15 : {
                        Drawable drawable2 = this.b != null && this.b.b() != null ? androidx.core.graphics.drawable.a.g(this.b.b()).mutate() : null;
                        CharSequence charSequence = this.b != null ? this.b.d() : null;
                        if (var2_9 != null) {
                            if (drawable2 != null) {
                                var2_9.setImageDrawable(drawable2);
                                var2_9.setVisibility(0);
                                this.setVisibility(0);
                            } else {
                                var2_9.setVisibility(8);
                                var2_9.setImageDrawable(null);
                            }
                        }
                        bl2 = TextUtils.isEmpty((CharSequence)charSequence) ^ true;
                        if (object != null) {
                            if (bl2) {
                                object.setText(charSequence);
                                if (this.b.i == 1) {
                                    object.setVisibility(0);
                                } else {
                                    object.setVisibility(8);
                                }
                                this.setVisibility(0);
                            } else {
                                object.setVisibility(8);
                                object.setText(null);
                            }
                        }
                        if (var2_9 == null) break block14;
                        marginLayoutParams = (ViewGroup.MarginLayoutParams)var2_9.getLayoutParams();
                        n2 = bl2 && var2_9.getVisibility() == 0 ? TabLayout.this.b(8) : 0;
                        if (!TabLayout.this.s) break block15;
                        if (n2 == androidx.core.h.g.b(marginLayoutParams)) break block14;
                        androidx.core.h.g.a(marginLayoutParams, n2);
                        marginLayoutParams.bottomMargin = 0;
                        break block16;
                    }
                    if (n2 == marginLayoutParams.bottomMargin) break block14;
                    marginLayoutParams.bottomMargin = n2;
                    androidx.core.h.g.a(marginLayoutParams, 0);
                }
                var2_9.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
                var2_9.requestLayout();
            }
            if (this.b != null) {
                CharSequence charSequence = this.b.f;
            } else {
                Object var1_5 = null;
            }
            if (bl2) {
                Object var1_7 = null;
            }
            aq.a((View)this, (CharSequence)var1_8);
        }

        private int d() {
            View[] arrview = new View[3];
            TextView textView = this.c;
            arrview[0] = textView;
            arrview[1] = this.d;
            arrview[2] = this.e;
            int n2 = arrview.length;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                textView = arrview[i2];
                int n6 = n3;
                int n7 = n4;
                int n8 = n5;
                if (textView != null) {
                    n6 = n3;
                    n7 = n4;
                    n8 = n5;
                    if (textView.getVisibility() == 0) {
                        n4 = n5 != 0 ? Math.min(n4, textView.getLeft()) : textView.getLeft();
                        n5 = n5 != 0 ? Math.max(n3, textView.getRight()) : textView.getRight();
                        n8 = 1;
                        n7 = n4;
                        n6 = n5;
                    }
                }
                n3 = n6;
                n4 = n7;
                n5 = n8;
            }
            return n3 - n4;
        }

        void a() {
            this.a((f)null);
            this.setSelected(false);
        }

        void a(f f2) {
            if (f2 != this.b) {
                this.b = f2;
                this.b();
            }
        }

        final void b() {
            boolean bl2;
            f f2;
            block23 : {
                ImageView imageView;
                View view;
                block22 : {
                    block21 : {
                        f2 = this.b;
                        imageView = null;
                        view = f2 != null ? f2.a() : null;
                        if (view != null) {
                            ViewParent viewParent = view.getParent();
                            if (viewParent != this) {
                                if (viewParent != null) {
                                    ((ViewGroup)viewParent).removeView(view);
                                }
                                this.addView(view);
                            }
                            this.e = view;
                            if (this.c != null) {
                                this.c.setVisibility(8);
                            }
                            if (this.d != null) {
                                this.d.setVisibility(8);
                                this.d.setImageDrawable(null);
                            }
                            this.f = (TextView)view.findViewById(16908308);
                            if (this.f != null) {
                                this.i = androidx.core.widget.i.a(this.f);
                            }
                            this.g = (ImageView)view.findViewById(16908294);
                        } else {
                            if (this.e != null) {
                                this.removeView(this.e);
                                this.e = null;
                            }
                            this.f = null;
                            this.g = null;
                        }
                        view = this.e;
                        bl2 = false;
                        if (view != null) break block21;
                        if (this.d == null) {
                            view = (ImageView)LayoutInflater.from((Context)this.getContext()).inflate(a.g.design_layout_tab_icon, (ViewGroup)this, false);
                            this.addView(view, 0);
                            this.d = view;
                        }
                        view = imageView;
                        if (f2 != null) {
                            view = imageView;
                            if (f2.b() != null) {
                                view = androidx.core.graphics.drawable.a.g(f2.b()).mutate();
                            }
                        }
                        if (view != null) {
                            androidx.core.graphics.drawable.a.a((Drawable)view, TabLayout.this.g);
                            if (TabLayout.this.j != null) {
                                androidx.core.graphics.drawable.a.a((Drawable)view, TabLayout.this.j);
                            }
                        }
                        if (this.c == null) {
                            view = (TextView)LayoutInflater.from((Context)this.getContext()).inflate(a.g.design_layout_tab_text, (ViewGroup)this, false);
                            this.addView(view);
                            this.c = view;
                            this.i = androidx.core.widget.i.a(this.c);
                        }
                        androidx.core.widget.i.a(this.c, TabLayout.this.e);
                        if (TabLayout.this.f != null) {
                            this.c.setTextColor(TabLayout.this.f);
                        }
                        view = this.c;
                        imageView = this.d;
                        break block22;
                    }
                    if (this.f == null && this.g == null) break block23;
                    view = this.f;
                    imageView = this.g;
                }
                this.a((TextView)view, imageView);
            }
            if (f2 != null && !TextUtils.isEmpty((CharSequence)f2.f)) {
                this.setContentDescription(f2.f);
            }
            boolean bl3 = bl2;
            if (f2 != null) {
                bl3 = bl2;
                if (f2.f()) {
                    bl3 = true;
                }
            }
            this.setSelected(bl3);
        }

        final void c() {
            ImageView imageView;
            TextView textView;
            this.setOrientation(TabLayout.this.s ^ true);
            if (this.f == null && this.g == null) {
                textView = this.c;
                imageView = this.d;
            } else {
                textView = this.f;
                imageView = this.g;
            }
            this.a(textView, imageView);
        }

        protected void drawableStateChanged() {
            boolean bl2;
            super.drawableStateChanged();
            int[] arrn = this.getDrawableState();
            Drawable drawable2 = this.h;
            boolean bl3 = bl2 = false;
            if (drawable2 != null) {
                bl3 = bl2;
                if (this.h.isStateful()) {
                    bl3 = false | this.h.setState(arrn);
                }
            }
            if (bl3) {
                this.invalidate();
                TabLayout.this.invalidate();
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)a.c.class.getName());
        }

        @TargetApi(value=14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)a.c.class.getName());
        }

        public void onMeasure(int n2, int n3) {
            block13 : {
                int n4;
                float f2;
                int n5;
                block14 : {
                    block15 : {
                        int n6;
                        int n7;
                        block11 : {
                            block12 : {
                                n4 = View.MeasureSpec.getSize((int)n2);
                                n6 = View.MeasureSpec.getMode((int)n2);
                                n7 = TabLayout.this.getTabMaxWidth();
                                n5 = n2;
                                if (n7 <= 0) break block11;
                                if (n6 == 0) break block12;
                                n5 = n2;
                                if (n4 <= n7) break block11;
                            }
                            n5 = View.MeasureSpec.makeMeasureSpec((int)TabLayout.this.n, (int)Integer.MIN_VALUE);
                        }
                        super.onMeasure(n5, n3);
                        if (this.c == null) break block13;
                        float f3 = TabLayout.this.k;
                        n4 = this.i;
                        ImageView imageView = this.d;
                        n6 = 1;
                        if (imageView != null && this.d.getVisibility() == 0) {
                            n2 = 1;
                            f2 = f3;
                        } else {
                            f2 = f3;
                            n2 = n4;
                            if (this.c != null) {
                                f2 = f3;
                                n2 = n4;
                                if (this.c.getLineCount() > 1) {
                                    f2 = TabLayout.this.l;
                                    n2 = n4;
                                }
                            }
                        }
                        f3 = this.c.getTextSize();
                        n7 = this.c.getLineCount();
                        n4 = androidx.core.widget.i.a(this.c);
                        float f4 = f2 FCMPL f3;
                        if (f4 == false && (n4 < 0 || n2 == n4)) break block13;
                        n4 = n6;
                        if (TabLayout.this.r != 1) break block14;
                        n4 = n6;
                        if (f4 <= 0) break block14;
                        n4 = n6;
                        if (n7 != 1) break block14;
                        imageView = this.c.getLayout();
                        if (imageView == null) break block15;
                        n4 = n6;
                        if (!(this.a((Layout)imageView, 0, f2) > (float)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()))) break block14;
                    }
                    n4 = 0;
                }
                if (n4 != 0) {
                    this.c.setTextSize(0, f2);
                    this.c.setMaxLines(n2);
                    super.onMeasure(n5, n3);
                }
            }
        }

        public boolean performClick() {
            boolean bl2;
            boolean bl3 = bl2 = super.performClick();
            if (this.b != null) {
                if (!bl2) {
                    this.playSoundEffect(0);
                }
                this.b.e();
                bl3 = true;
            }
            return bl3;
        }

        public void setSelected(boolean bl2) {
            boolean bl3 = this.isSelected() != bl2;
            super.setSelected(bl2);
            if (bl3 && bl2 && Build.VERSION.SDK_INT < 16) {
                this.sendAccessibilityEvent(4);
            }
            if (this.c != null) {
                this.c.setSelected(bl2);
            }
            if (this.d != null) {
                this.d.setSelected(bl2);
            }
            if (this.e != null) {
                this.e.setSelected(bl2);
            }
        }
    }

    public static class i
    implements c {
        private final ViewPager a;

        public i(ViewPager viewPager) {
            this.a = viewPager;
        }

        public void a(f f2) {
            this.a.setCurrentItem(f2.c());
        }

        public void b(f f2) {
        }

        public void c(f f2) {
        }
    }

}

