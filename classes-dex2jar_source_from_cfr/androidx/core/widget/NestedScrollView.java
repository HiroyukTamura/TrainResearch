/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 *  android.view.animation.AnimationUtils
 *  android.widget.EdgeEffect
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.OverScroller
 *  android.widget.ScrollView
 */
package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.h.k;
import androidx.core.h.l;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.core.widget.d;
import java.util.ArrayList;

public class NestedScrollView
extends FrameLayout
implements k,
n {
    private static final a w = new a();
    private static final int[] x = new int[]{16843130};
    private float A;
    private b B;
    private long a;
    private final Rect b = new Rect();
    private OverScroller c;
    private EdgeEffect d;
    private EdgeEffect e;
    private int f;
    private boolean g = true;
    private boolean h = false;
    private View i = null;
    private boolean j = false;
    private VelocityTracker k;
    private boolean l;
    private boolean m = true;
    private int n;
    private int o;
    private int p;
    private int q = -1;
    private final int[] r = new int[2];
    private final int[] s = new int[2];
    private int t;
    private int u;
    private c v;
    private final o y;
    private final l z;

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a();
        context = context.obtainStyledAttributes(attributeSet, x, n2, 0);
        this.setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.y = new o((ViewGroup)this);
        this.z = new l((View)this);
        this.setNestedScrollingEnabled(true);
        t.a((View)this, w);
    }

    private View a(boolean bl2, int n2, int n3) {
        ArrayList arrayList = this.getFocusables(2);
        int n4 = arrayList.size();
        View view = null;
        boolean bl3 = false;
        for (int i2 = 0; i2 < n4; ++i2) {
            boolean bl4;
            View view2;
            block3 : {
                View view3;
                block6 : {
                    int n5;
                    block7 : {
                        boolean bl5;
                        block5 : {
                            int n6;
                            block4 : {
                                view3 = (View)arrayList.get(i2);
                                n5 = view3.getTop();
                                n6 = view3.getBottom();
                                view2 = view;
                                bl4 = bl3;
                                if (n2 >= n6) break block3;
                                view2 = view;
                                bl4 = bl3;
                                if (n5 >= n3) break block3;
                                bl5 = n2 < n5 && n6 < n3;
                                if (view != null) break block4;
                                view2 = view3;
                                bl4 = bl5;
                                break block3;
                            }
                            n5 = bl2 && n5 < view.getTop() || !bl2 && n6 > view.getBottom() ? 1 : 0;
                            if (!bl3) break block5;
                            view2 = view;
                            bl4 = bl3;
                            if (!bl5) break block3;
                            view2 = view;
                            bl4 = bl3;
                            if (n5 == 0) break block3;
                            break block6;
                        }
                        if (!bl5) break block7;
                        view2 = view3;
                        bl4 = true;
                        break block3;
                    }
                    view2 = view;
                    bl4 = bl3;
                    if (n5 == 0) break block3;
                }
                view2 = view3;
                bl4 = bl3;
            }
            view = view2;
            bl3 = bl4;
        }
        return view;
    }

    private void a() {
        this.c = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void a(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n2) == this.q) {
            n2 = n2 == 0 ? 1 : 0;
            this.f = (int)motionEvent.getY(n2);
            this.q = motionEvent.getPointerId(n2);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private boolean a(int n2, int n3, int n4) {
        View view;
        int n5 = this.getHeight();
        int n6 = this.getScrollY();
        n5 += n6;
        boolean bl2 = false;
        boolean bl3 = n2 == 33;
        Object object = view = this.a(bl3, n3, n4);
        if (view == null) {
            object = this;
        }
        if (n3 >= n6 && n4 <= n5) {
            bl3 = bl2;
        } else {
            n3 = bl3 ? (n3 -= n6) : n4 - n5;
            this.g(n3);
            bl3 = true;
        }
        if (object != this.findFocus()) {
            object.requestFocus(n2);
        }
        return bl3;
    }

    private boolean a(Rect rect, boolean bl2) {
        int n2 = this.a(rect);
        boolean bl3 = n2 != 0;
        if (bl3) {
            if (bl2) {
                this.scrollBy(0, n2);
                return bl3;
            }
            this.b(0, n2);
        }
        return bl3;
    }

    private boolean a(View view) {
        return this.a(view, 0, this.getHeight()) ^ true;
    }

    private boolean a(View view, int n2, int n3) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + n2 >= this.getScrollY() && this.b.top - n2 <= this.getScrollY() + n3;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        return (view = view.getParent()) instanceof ViewGroup && NestedScrollView.a(view, view2);
    }

    private static int b(int n2, int n3, int n4) {
        if (n3 < n4 && n2 >= 0) {
            if (n3 + n2 > n4) {
                return n4 - n3;
            }
            return n2;
        }
        return 0;
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        int n2 = this.a(this.b);
        if (n2 != 0) {
            this.scrollBy(0, n2);
        }
    }

    private boolean b() {
        boolean bl2;
        int n2 = this.getChildCount();
        boolean bl3 = bl2 = false;
        if (n2 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            bl3 = bl2;
            if (view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) {
                bl3 = true;
            }
        }
        return bl3;
    }

    private void c() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
            return;
        }
        this.k.clear();
    }

    private void d() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private boolean d(int n2, int n3) {
        boolean bl2;
        int n4 = this.getChildCount();
        boolean bl3 = bl2 = false;
        if (n4 > 0) {
            n4 = this.getScrollY();
            View view = this.getChildAt(0);
            bl3 = bl2;
            if (n3 >= view.getTop() - n4) {
                bl3 = bl2;
                if (n3 < view.getBottom() - n4) {
                    bl3 = bl2;
                    if (n2 >= view.getLeft()) {
                        bl3 = bl2;
                        if (n2 < view.getRight()) {
                            bl3 = true;
                        }
                    }
                }
            }
        }
        return bl3;
    }

    private void e() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    private void f() {
        this.j = false;
        this.e();
        this.a(0);
        if (this.d != null) {
            this.d.onRelease();
            this.e.onRelease();
        }
    }

    private void g() {
        if (this.getOverScrollMode() != 2) {
            if (this.d == null) {
                Context context = this.getContext();
                this.d = new EdgeEffect(context);
                this.e = new EdgeEffect(context);
                return;
            }
        } else {
            this.d = null;
            this.e = null;
        }
    }

    private void g(int n2) {
        if (n2 != 0) {
            if (this.m) {
                this.b(0, n2);
                return;
            }
            this.scrollBy(0, n2);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = this.getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.A;
    }

    private void h(int n2) {
        int n3 = this.getScrollY();
        boolean bl2 = !(n3 <= 0 && n2 <= 0 || n3 >= this.getScrollRange() && n2 >= 0);
        float f2 = n2;
        if (!this.dispatchNestedPreFling(0.0f, f2)) {
            this.dispatchNestedFling(0.0f, f2, bl2);
            this.f(n2);
        }
    }

    protected int a(Rect rect) {
        int n2 = this.getChildCount();
        int n3 = 0;
        if (n2 == 0) {
            return 0;
        }
        int n4 = this.getHeight();
        int n5 = this.getScrollY();
        int n6 = n5 + n4;
        int n7 = this.getVerticalFadingEdgeLength();
        n2 = n5;
        if (rect.top > 0) {
            n2 = n5 + n7;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n5 = rect.bottom < view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin ? n6 - n7 : n6;
        if (rect.bottom > n5 && rect.top > n2) {
            n2 = rect.height() > n4 ? rect.top - n2 : rect.bottom - n5;
            return Math.min(n2 + 0, view.getBottom() + layoutParams.bottomMargin - n6);
        }
        n6 = n3;
        if (rect.top < n2) {
            n6 = n3;
            if (rect.bottom < n5) {
                n2 = rect.height() > n4 ? 0 - (n5 - rect.bottom) : 0 - (n2 - rect.top);
                n6 = Math.max(n2, -this.getScrollY());
            }
        }
        return n6;
    }

    @Override
    public void a(int n2) {
        this.z.c(n2);
    }

    @Override
    public void a(View view, int n2, int n3, int n4, int n5, int n6) {
        n2 = this.getScrollY();
        this.scrollBy(0, n5);
        n2 = this.getScrollY() - n2;
        this.a(0, n2, 0, n5 - n2, null, n6);
    }

    @Override
    public void a(View view, int n2, int n3, int[] arrn, int n4) {
        this.a(n2, n3, arrn, null, n4);
    }

    public boolean a(int n2, int n3) {
        return this.z.a(n2, n3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean a(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, boolean var9_9) {
        block5 : {
            var12_10 = this.getOverScrollMode();
            var10_11 = this.computeHorizontalScrollRange();
            var11_12 = this.computeHorizontalScrollExtent();
            var14_13 = false;
            var10_11 = var10_11 > var11_12 ? 1 : 0;
            var11_12 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent() ? 1 : 0;
            var10_11 = var12_10 != 0 && (var12_10 != 1 || var10_11 == 0) ? 0 : 1;
            var11_12 = var12_10 != 0 && (var12_10 != 1 || var11_12 == 0) ? 0 : 1;
            var1_1 = var10_11 == 0 ? 0 : var7_7;
            var4_4 += var2_2;
            var2_2 = var11_12 == 0 ? 0 : var8_8;
            var7_7 = -var1_1;
            var5_5 = -var2_2;
            var6_6 = var2_2 + var6_6;
            if ((var3_3 += var1_1) > (var1_1 += var5_5)) ** GOTO lbl18
            if (var3_3 < var7_7) {
                var1_1 = var7_7;
lbl18: // 2 sources:
                var9_9 = true;
                var2_2 = var1_1;
            } else {
                var2_2 = var3_3;
                var9_9 = false;
            }
            if (var4_4 <= var6_6) break block5;
            var1_1 = var6_6;
            ** GOTO lbl29
        }
        if (var4_4 < var5_5) {
            var1_1 = var5_5;
lbl29: // 2 sources:
            var13_14 = true;
        } else {
            var1_1 = var4_4;
            var13_14 = false;
        }
        if (var13_14 && !this.b(1)) {
            this.c.springBack(var2_2, var1_1, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(var2_2, var1_1, var9_9, var13_14);
        if (var9_9 != false) return true;
        var9_9 = var14_13;
        if (var13_14 == false) return var9_9;
        return true;
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn, int n6) {
        return this.z.a(n2, n3, n4, n5, arrn, n6);
    }

    public boolean a(int n2, int n3, int[] arrn, int[] arrn2, int n4) {
        return this.z.a(n2, n3, arrn, arrn2, n4);
    }

    public boolean a(KeyEvent keyEvent) {
        this.b.setEmpty();
        boolean bl2 = this.b();
        boolean bl3 = false;
        int n2 = 130;
        if (!bl2) {
            bl2 = bl3;
            if (this.isFocused()) {
                bl2 = bl3;
                if (keyEvent.getKeyCode() != 4) {
                    View view = this.findFocus();
                    keyEvent = view;
                    if (view == this) {
                        keyEvent = null;
                    }
                    keyEvent = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)keyEvent, 130);
                    bl2 = bl3;
                    if (keyEvent != null) {
                        bl2 = bl3;
                        if (keyEvent != this) {
                            bl2 = bl3;
                            if (keyEvent.requestFocus(130)) {
                                bl2 = true;
                            }
                        }
                    }
                }
            }
            return bl2;
        }
        if (keyEvent.getAction() == 0) {
            int n3 = keyEvent.getKeyCode();
            if (n3 != 62) {
                switch (n3) {
                    default: {
                        return false;
                    }
                    case 20: {
                        if (!keyEvent.isAltPressed()) {
                            return this.e(130);
                        }
                        return this.d(130);
                    }
                    case 19: 
                }
                if (!keyEvent.isAltPressed()) {
                    return this.e(33);
                }
                return this.d(33);
            }
            if (keyEvent.isShiftPressed()) {
                n2 = 33;
            }
            this.c(n2);
        }
        return false;
    }

    @Override
    public boolean a(View view, View view2, int n2, int n3) {
        return (n2 & 2) != 0;
    }

    public void addView(View view) {
        if (this.getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int n2) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void b(int n2, int n3) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n4 = view.getHeight();
            int n5 = layoutParams.topMargin;
            int n6 = layoutParams.bottomMargin;
            int n7 = this.getHeight();
            int n8 = this.getPaddingTop();
            int n9 = this.getPaddingBottom();
            n2 = this.getScrollY();
            n3 = Math.max(0, Math.min(n3 + n2, Math.max(0, n4 + n5 + n6 - (n7 - n8 - n9))));
            this.u = this.getScrollY();
            this.c.startScroll(this.getScrollX(), n2, 0, n3 - n2);
            t.d((View)this);
        } else {
            if (!this.c.isFinished()) {
                this.c.abortAnimation();
            }
            this.scrollBy(n2, n3);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override
    public void b(View view, View view2, int n2, int n3) {
        this.y.a(view, view2, n2, n3);
        this.a(2, n3);
    }

    public boolean b(int n2) {
        return this.z.a(n2);
    }

    public final void c(int n2, int n3) {
        this.b(n2 - this.getScrollX(), n3 - this.getScrollY());
    }

    @Override
    public void c(View view, int n2) {
        this.y.a(view, n2);
        this.a(n2);
    }

    public boolean c(int n2) {
        int n3;
        block3 : {
            int n4;
            block4 : {
                Rect rect;
                int n5;
                block2 : {
                    n5 = 0;
                    n4 = n2 == 130 ? 1 : 0;
                    n3 = this.getHeight();
                    if (n4 == 0) break block2;
                    this.b.top = this.getScrollY() + n3;
                    n4 = this.getChildCount();
                    if (n4 <= 0) break block3;
                    rect = this.getChildAt(n4 - 1);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)rect.getLayoutParams();
                    n4 = rect.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
                    if (this.b.top + n3 <= n4) break block3;
                    rect = this.b;
                    n4 -= n3;
                    break block4;
                }
                this.b.top = this.getScrollY() - n3;
                if (this.b.top >= 0) break block3;
                rect = this.b;
                n4 = n5;
            }
            rect.top = n4;
        }
        this.b.bottom = this.b.top + n3;
        return this.a(n2, this.b.top, this.b.bottom);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void computeScroll() {
        block5 : {
            int n2;
            block6 : {
                EdgeEffect edgeEffect;
                block8 : {
                    int n3;
                    int n4;
                    block7 : {
                        if (!this.c.computeScrollOffset()) break block5;
                        this.c.getCurrX();
                        n2 = this.c.getCurrY();
                        int n5 = n4 = n2 - this.u;
                        if (this.a(0, n4, this.s, null, 1)) {
                            n5 = n4 - this.s[1];
                        }
                        if (n5 == 0) break block6;
                        n4 = this.getScrollRange();
                        n3 = this.getScrollY();
                        this.a(0, n5, this.getScrollX(), n3, 0, n4, 0, 0, false);
                        int n6 = this.getScrollY() - n3;
                        if (this.a(0, n6, 0, n5 - n6, null, 1)) break block6;
                        n5 = this.getOverScrollMode();
                        n5 = n5 != 0 && (n5 != 1 || n4 <= 0) ? 0 : 1;
                        if (n5 == 0) break block6;
                        this.g();
                        if (n2 > 0 || n3 <= 0) break block7;
                        edgeEffect = this.d;
                        break block8;
                    }
                    if (n2 < n4 || n3 >= n4) break block6;
                    edgeEffect = this.e;
                }
                edgeEffect.onAbsorb((int)this.c.getCurrVelocity());
            }
            this.u = n2;
            t.d((View)this);
            return;
        }
        if (this.b(1)) {
            this.a(1);
        }
        this.u = 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int n2 = this.getChildCount();
        int n3 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (n2 == 0) {
            return n3;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n2 = view.getBottom() + layoutParams.bottomMargin;
        int n4 = this.getScrollY();
        int n5 = Math.max(0, n2 - n3);
        if (n4 < 0) {
            return n2 - n4;
        }
        n3 = n2;
        if (n4 > n5) {
            n3 = n2 + (n4 - n5);
        }
        return n3;
    }

    public boolean d(int n2) {
        int n3 = n2 == 130 ? 1 : 0;
        int n4 = this.getHeight();
        this.b.top = 0;
        this.b.bottom = n4;
        if (n3 != 0 && (n3 = this.getChildCount()) > 0) {
            View view = this.getChildAt(n3 - 1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            this.b.bottom = view.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
            this.b.top = this.b.bottom - n4;
        }
        return this.a(n2, this.b.top, this.b.bottom);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.a(keyEvent);
        {
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean bl2) {
        return this.z.a(f2, f3, bl2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.z.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.a(n2, n3, arrn, arrn2, 0);
    }

    public boolean dispatchNestedScroll(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.a(n2, n3, n4, n5, arrn, 0);
    }

    public void draw(Canvas canvas) {
        block12 : {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            block14 : {
                block13 : {
                    super.draw(canvas);
                    if (this.d == null) break block12;
                    int n9 = this.getScrollY();
                    boolean bl2 = this.d.isFinished();
                    int n10 = 0;
                    if (!bl2) {
                        n5 = canvas.save();
                        n4 = this.getWidth();
                        n8 = this.getHeight();
                        n7 = Math.min(0, n9);
                        if (Build.VERSION.SDK_INT >= 21 && !this.getClipToPadding()) {
                            n6 = 0;
                        } else {
                            n4 -= this.getPaddingLeft() + this.getPaddingRight();
                            n6 = this.getPaddingLeft() + 0;
                        }
                        n3 = n8;
                        n2 = n7;
                        if (Build.VERSION.SDK_INT >= 21) {
                            n3 = n8;
                            n2 = n7;
                            if (this.getClipToPadding()) {
                                n3 = n8 - (this.getPaddingTop() + this.getPaddingBottom());
                                n2 = n7 + this.getPaddingTop();
                            }
                        }
                        canvas.translate((float)n6, (float)n2);
                        this.d.setSize(n4, n3);
                        if (this.d.draw(canvas)) {
                            t.d((View)this);
                        }
                        canvas.restoreToCount(n5);
                    }
                    if (this.e.isFinished()) break block12;
                    n5 = canvas.save();
                    n2 = this.getWidth();
                    n7 = this.getHeight();
                    n8 = Math.max(this.getScrollRange(), n9) + n7;
                    if (Build.VERSION.SDK_INT < 21) break block13;
                    n6 = n10;
                    n4 = n2;
                    if (!this.getClipToPadding()) break block14;
                }
                n4 = n2 - (this.getPaddingLeft() + this.getPaddingRight());
                n6 = 0 + this.getPaddingLeft();
            }
            n3 = n8;
            n2 = n7;
            if (Build.VERSION.SDK_INT >= 21) {
                n3 = n8;
                n2 = n7;
                if (this.getClipToPadding()) {
                    n2 = n7 - (this.getPaddingTop() + this.getPaddingBottom());
                    n3 = n8 - this.getPaddingBottom();
                }
            }
            canvas.translate((float)(n6 - n4), (float)n3);
            canvas.rotate(180.0f, (float)n4, 0.0f);
            this.e.setSize(n4, n2);
            if (this.e.draw(canvas)) {
                t.d((View)this);
            }
            canvas.restoreToCount(n5);
        }
    }

    public boolean e(int n2) {
        View view;
        View view2 = view = this.findFocus();
        if (view == this) {
            view2 = null;
        }
        view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view2, n2);
        int n3 = this.getMaxScrollAmount();
        if (view != null && this.a(view, n3, this.getHeight())) {
            view.getDrawingRect(this.b);
            this.offsetDescendantRectToMyCoords(view, this.b);
            this.g(this.a(this.b));
            view.requestFocus(n2);
        } else {
            int n4;
            if (n2 == 33 && this.getScrollY() < n3) {
                n4 = this.getScrollY();
            } else {
                n4 = n3;
                if (n2 == 130) {
                    n4 = n3;
                    if (this.getChildCount() > 0) {
                        view = this.getChildAt(0);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                        n4 = Math.min(view.getBottom() + layoutParams.bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), n3);
                    }
                }
            }
            if (n4 == 0) {
                return false;
            }
            if (n2 != 130) {
                n4 = -n4;
            }
            this.g(n4);
        }
        if (view2 != null && view2.isFocused() && this.a(view2)) {
            n2 = this.getDescendantFocusability();
            this.setDescendantFocusability(131072);
            this.requestFocus();
            this.setDescendantFocusability(n2);
        }
        return true;
    }

    public void f(int n2) {
        if (this.getChildCount() > 0) {
            this.a(2, 1);
            this.c.fling(this.getScrollX(), this.getScrollY(), 0, n2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.u = this.getScrollY();
            t.d((View)this);
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n2 = this.getVerticalFadingEdgeLength();
        int n3 = this.getHeight();
        int n4 = this.getPaddingBottom();
        n3 = view.getBottom() + layoutParams.bottomMargin - this.getScrollY() - (n3 - n4);
        if (n3 < n2) {
            return (float)n3 / (float)n2;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int)((float)this.getHeight() * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    int getScrollRange() {
        int n2 = this.getChildCount();
        int n3 = 0;
        if (n2 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n3 = Math.max(0, view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }
        return n3;
    }

    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        int n2 = this.getVerticalFadingEdgeLength();
        int n3 = this.getScrollY();
        if (n3 < n2) {
            return (float)n3 / (float)n2;
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.b(0);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return this.z.a();
    }

    protected void measureChild(View view, int n2, int n3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
    }

    protected void measureChildWithMargins(View view, int n2, int n3, int n4, int n5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n3), (int)marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec((int)(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin), (int)0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            float f2;
            if (motionEvent.getAction() != 8) {
                return false;
            }
            if (!this.j && (f2 = motionEvent.getAxisValue(9)) != 0.0f) {
                int n2 = (int)(f2 * this.getVerticalScrollFactorCompat());
                int n3 = this.getScrollRange();
                int n4 = this.getScrollY();
                int n5 = n4 - n2;
                if (n5 < 0) {
                    n2 = 0;
                } else {
                    n2 = n5;
                    if (n5 > n3) {
                        n2 = n3;
                    }
                }
                if (n2 != n4) {
                    super.scrollTo(this.getScrollX(), n2);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        block12 : {
            block11 : {
                int n2 = object.getAction();
                if (n2 == 2 && this.j) {
                    return true;
                }
                if ((n2 &= 255) == 6) break block11;
                switch (n2) {
                    default: {
                        break;
                    }
                    case 2: {
                        n2 = this.q;
                        if (n2 == -1) break;
                        int n3 = object.findPointerIndex(n2);
                        if (n3 == -1) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Invalid pointerId=");
                            ((StringBuilder)object).append(n2);
                            ((StringBuilder)object).append(" in onInterceptTouchEvent");
                            Log.e((String)"NestedScrollView", (String)((StringBuilder)object).toString());
                            break;
                        }
                        n2 = (int)object.getY(n3);
                        if (Math.abs(n2 - this.f) > this.n && (2 & this.getNestedScrollAxes()) == 0) {
                            this.j = true;
                            this.f = n2;
                            this.d();
                            this.k.addMovement((MotionEvent)object);
                            this.t = 0;
                            object = this.getParent();
                            if (object != null) {
                                object.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                        break block12;
                    }
                    case 1: 
                    case 3: {
                        this.j = false;
                        this.q = -1;
                        this.e();
                        if (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                            t.d((View)this);
                        }
                        this.a(0);
                        break;
                    }
                    case 0: {
                        n2 = (int)object.getY();
                        if (!this.d((int)object.getX(), n2)) {
                            this.j = false;
                            this.e();
                            break;
                        }
                        this.f = n2;
                        this.q = object.getPointerId(0);
                        this.c();
                        this.k.addMovement((MotionEvent)object);
                        this.c.computeScrollOffset();
                        this.j = this.c.isFinished() ^ true;
                        this.a(2, 0);
                        break;
                    }
                }
                break block12;
            }
            this.a((MotionEvent)object);
        }
        return this.j;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        n2 = 0;
        this.g = false;
        if (this.i != null && NestedScrollView.a(this.i, (View)this)) {
            this.b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.v != null) {
                this.scrollTo(this.getScrollX(), this.v.a);
                this.v = null;
            }
            if (this.getChildCount() > 0) {
                View view = this.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                n2 = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int n6 = this.getPaddingTop();
            int n7 = this.getPaddingBottom();
            n4 = this.getScrollY();
            n2 = NestedScrollView.b(n4, n5 - n3 - n6 - n7, n2);
            if (n2 != n4) {
                this.scrollTo(this.getScrollX(), n2);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.h = true;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (!this.l) {
            return;
        }
        if (View.MeasureSpec.getMode((int)n3) == 0) {
            return;
        }
        if (this.getChildCount() > 0) {
            int n4;
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n3 = view.getMeasuredHeight();
            if (n3 < (n4 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - layoutParams.topMargin - layoutParams.bottomMargin)) {
                view.measure(NestedScrollView.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824));
            }
        }
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        if (!bl2) {
            this.h((int)f3);
            return true;
        }
        return false;
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return this.dispatchNestedPreFling(f2, f3);
    }

    @Override
    public void onNestedPreScroll(View view, int n2, int n3, int[] arrn) {
        this.a(view, n2, n3, arrn, 0);
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        this.a(view, n2, n3, n4, n5, 0);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.b(view, view2, n2, 0);
    }

    protected void onOverScrolled(int n2, int n3, boolean bl2, boolean bl3) {
        super.scrollTo(n2, n3);
    }

    protected boolean onRequestFocusInDescendants(int n2, Rect rect) {
        int n3;
        if (n2 == 2) {
            n3 = 130;
        } else {
            n3 = n2;
            if (n2 == 1) {
                n3 = 33;
            }
        }
        View view = rect == null ? FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, n3) : FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n3);
        if (view == null) {
            return false;
        }
        if (this.a(view)) {
            return false;
        }
        return view.requestFocus(n3, rect);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (!(object instanceof c)) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (c)((Object)object);
        super.onRestoreInstanceState(object.getSuperState());
        this.v = object;
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        c c2 = new c(super.onSaveInstanceState());
        c2.a = this.getScrollY();
        return c2;
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
        super.onScrollChanged(n2, n3, n4, n5);
        if (this.B != null) {
            this.B.a(this, n2, n3, n4, n5);
        }
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        View view = this.findFocus();
        if (view != null) {
            if (this == view) {
                return;
            }
            if (this.a(view, 0, n5)) {
                view.getDrawingRect(this.b);
                this.offsetDescendantRectToMyCoords(view, this.b);
                this.g(this.a(this.b));
            }
        }
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        return this.a(view, view2, n2, 0);
    }

    @Override
    public void onStopNestedScroll(View view) {
        this.c(view, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block29 : {
            this.d();
            var9_2 = MotionEvent.obtain((MotionEvent)var1_1);
            var2_3 = var1_1.getActionMasked();
            if (var2_3 == 0) {
                this.t = 0;
            }
            var9_2.offsetLocation(0.0f, (float)this.t);
            switch (var2_3) {
                default: {
                    ** break;
                }
                case 6: {
                    this.a((MotionEvent)var1_1);
                    this.f = (int)var1_1.getY(var1_1.findPointerIndex(this.q));
                    ** break;
                }
                case 5: {
                    var2_3 = var1_1.getActionIndex();
                    this.f = (int)var1_1.getY(var2_3);
                    this.q = var1_1.getPointerId(var2_3);
                    ** break;
                }
                case 3: {
                    if (!this.j || this.getChildCount() <= 0 || !this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) ** GOTO lbl85
                    ** GOTO lbl84
                }
                case 2: {
                    var4_4 = var1_1.findPointerIndex(this.q);
                    if (var4_4 == -1) {
                        var1_1 = new StringBuilder();
                        var1_1.append("Invalid pointerId=");
                        var1_1.append(this.q);
                        var1_1.append(" in onTouchEvent");
                        Log.e((String)"NestedScrollView", (String)var1_1.toString());
                        ** break;
                    }
                    var5_5 = (int)var1_1.getY(var4_4);
                    var3_6 = var2_3 = this.f - var5_5;
                    if (this.a(0, var2_3, this.s, this.r, 0)) {
                        var3_6 = var2_3 - this.s[1];
                        var9_2.offsetLocation(0.0f, (float)this.r[1]);
                        this.t += this.r[1];
                    }
                    var2_3 = var3_6;
                    if (!this.j) {
                        var2_3 = var3_6;
                        if (Math.abs(var3_6) > this.n) {
                            var10_7 = this.getParent();
                            if (var10_7 != null) {
                                var10_7.requestDisallowInterceptTouchEvent(true);
                            }
                            this.j = true;
                            var2_3 = var3_6 > 0 ? var3_6 - this.n : var3_6 + this.n;
                        }
                    }
                    if (!this.j) break block29;
                    this.f = var5_5 - this.r[1];
                    var6_9 = this.getScrollY();
                    var5_5 = this.getScrollRange();
                    var3_6 = this.getOverScrollMode();
                    var3_6 = var3_6 != 0 && (var3_6 != 1 || var5_5 <= 0) ? 0 : 1;
                    if (this.a(0, var2_3, 0, this.getScrollY(), 0, var5_5, 0, 0, true) && !this.b(0)) {
                        this.k.clear();
                    }
                    if (this.a(0, var7_10 = this.getScrollY() - var6_9, 0, var2_3 - var7_10, this.r, 0)) {
                        this.f -= this.r[1];
                        var9_2.offsetLocation(0.0f, (float)this.r[1]);
                        this.t += this.r[1];
                        ** break;
                    }
                    if (var3_6 == 0) break block29;
                    this.g();
                    var3_6 = var6_9 + var2_3;
                    if (var3_6 >= 0) ** GOTO lbl67
                    d.a(this.d, (float)var2_3 / (float)this.getHeight(), var1_1.getX(var4_4) / (float)this.getWidth());
                    if (this.e.isFinished()) ** GOTO lbl72
                    var1_1 = this.e;
                    ** GOTO lbl71
lbl67: // 1 sources:
                    if (var3_6 <= var5_5) ** GOTO lbl72
                    d.a(this.e, (float)var2_3 / (float)this.getHeight(), 1.0f - var1_1.getX(var4_4) / (float)this.getWidth());
                    if (this.d.isFinished()) ** GOTO lbl72
                    var1_1 = this.d;
lbl71: // 2 sources:
                    var1_1.onRelease();
lbl72: // 4 sources:
                    if (!(this.d == null || this.d.isFinished() && this.e.isFinished())) {
                        t.d((View)this);
                        ** break;
                    }
                    break block29;
                }
                case 1: {
                    var1_1 = this.k;
                    var1_1.computeCurrentVelocity(1000, (float)this.p);
                    var2_3 = (int)var1_1.getYVelocity(this.q);
                    if (Math.abs(var2_3) <= this.o) ** GOTO lbl83
                    this.h(-var2_3);
                    ** GOTO lbl85
lbl83: // 1 sources:
                    if (!this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) ** GOTO lbl85
lbl84: // 2 sources:
                    t.d((View)this);
lbl85: // 4 sources:
                    this.q = -1;
                    this.f();
                    ** break;
                }
                case 0: 
            }
            if (this.getChildCount() == 0) {
                return false;
            }
            this.j = var8_11 = this.c.isFinished() ^ true;
            if (var8_11 && (var10_8 = this.getParent()) != null) {
                var10_8.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.c.isFinished()) {
                this.c.abortAnimation();
            }
            this.f = (int)var1_1.getY();
            this.q = var1_1.getPointerId(0);
            this.a(2, 0);
        }
        if (this.k != null) {
            this.k.addMovement(var9_2);
        }
        var9_2.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.g) {
            this.b(view2);
        } else {
            this.i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.a(rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        if (bl2) {
            this.e();
        }
        super.requestDisallowInterceptTouchEvent(bl2);
    }

    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    public void scrollTo(int n2, int n3) {
        if (this.getChildCount() > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n4 = this.getWidth();
            int n5 = this.getPaddingLeft();
            int n6 = this.getPaddingRight();
            int n7 = view.getWidth();
            int n8 = layoutParams.leftMargin;
            int n9 = layoutParams.rightMargin;
            int n10 = this.getHeight();
            int n11 = this.getPaddingTop();
            int n12 = this.getPaddingBottom();
            int n13 = view.getHeight();
            int n14 = layoutParams.topMargin;
            int n15 = layoutParams.bottomMargin;
            n2 = NestedScrollView.b(n2, n4 - n5 - n6, n7 + n8 + n9);
            n3 = NestedScrollView.b(n3, n10 - n11 - n12, n13 + n14 + n15);
            if (n2 != this.getScrollX() || n3 != this.getScrollY()) {
                super.scrollTo(n2, n3);
            }
        }
    }

    public void setFillViewport(boolean bl2) {
        if (bl2 != this.l) {
            this.l = bl2;
            this.requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.z.a(bl2);
    }

    public void setOnScrollChangeListener(b b2) {
        this.B = b2;
    }

    public void setSmoothScrollingEnabled(boolean bl2) {
        this.m = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int n2) {
        return this.a(n2, 0);
    }

    @Override
    public void stopNestedScroll() {
        this.a(0);
    }

    static class a
    extends androidx.core.h.a {
        a() {
        }

        @Override
        public void a(View object, androidx.core.h.a.b b2) {
            int n2;
            super.a((View)object, b2);
            object = (NestedScrollView)object;
            b2.a(ScrollView.class.getName());
            if (object.isEnabled() && (n2 = ((NestedScrollView)object).getScrollRange()) > 0) {
                b2.c(true);
                if (object.getScrollY() > 0) {
                    b2.a(8192);
                }
                if (object.getScrollY() < n2) {
                    b2.a(4096);
                }
            }
        }

        @Override
        public boolean a(View object, int n2, Bundle bundle) {
            if (super.a((View)object, n2, bundle)) {
                return true;
            }
            if (!(object = (NestedScrollView)object).isEnabled()) {
                return false;
            }
            if (n2 != 4096) {
                if (n2 != 8192) {
                    return false;
                }
                n2 = object.getHeight();
                int n3 = object.getPaddingBottom();
                int n4 = object.getPaddingTop();
                n2 = Math.max(object.getScrollY() - (n2 - n3 - n4), 0);
                if (n2 != object.getScrollY()) {
                    ((NestedScrollView)object).c(0, n2);
                    return true;
                }
                return false;
            }
            n2 = object.getHeight();
            int n5 = object.getPaddingBottom();
            int n6 = object.getPaddingTop();
            n2 = Math.min(object.getScrollY() + (n2 - n5 - n6), ((NestedScrollView)object).getScrollRange());
            if (n2 != object.getScrollY()) {
                ((NestedScrollView)object).c(0, n2);
                return true;
            }
            return false;
        }

        @Override
        public void d(View object, AccessibilityEvent accessibilityEvent) {
            super.d((View)object, accessibilityEvent);
            object = (NestedScrollView)object;
            accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
            boolean bl2 = ((NestedScrollView)object).getScrollRange() > 0;
            accessibilityEvent.setScrollable(bl2);
            accessibilityEvent.setScrollX(object.getScrollX());
            accessibilityEvent.setScrollY(object.getScrollY());
            androidx.core.h.a.d.a((AccessibilityRecord)accessibilityEvent, object.getScrollX());
            androidx.core.h.a.d.b((AccessibilityRecord)accessibilityEvent, ((NestedScrollView)object).getScrollRange());
        }
    }

    public static interface b {
        public void a(NestedScrollView var1, int var2, int var3, int var4, int var5);
    }

    static class c
    extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

            public c a(Parcel parcel) {
                return new c(parcel);
            }

            public c[] a(int n2) {
                return new c[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        public int a;

        c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeInt(this.a);
        }

    }

}

