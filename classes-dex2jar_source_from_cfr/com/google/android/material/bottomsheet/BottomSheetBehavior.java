/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.e.b.a;
import com.google.android.material.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
extends CoordinatorLayout.b<V> {
    int a;
    int b;
    int c;
    boolean d;
    int e = 4;
    androidx.e.b.a f;
    int g;
    WeakReference<V> h;
    WeakReference<View> i;
    int j;
    boolean k;
    private boolean l = true;
    private float m;
    private int n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private a v;
    private VelocityTracker w;
    private int x;
    private Map<View, Integer> y;
    private final a.a z = new a.a(){

        @Override
        public int a(View view, int n2, int n3) {
            return view.getLeft();
        }

        @Override
        public void a(int n2) {
            if (n2 == 1) {
                BottomSheetBehavior.this.b(1);
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void a(View var1_1, float var2_2, float var3_3) {
            block8 : {
                block11 : {
                    block5 : {
                        block6 : {
                            block10 : {
                                block9 : {
                                    block7 : {
                                        block3 : {
                                            block4 : {
                                                var5_4 = 4;
                                                if (!(var3_3 < 0.0f)) break block3;
                                                if (!BottomSheetBehavior.a(BottomSheetBehavior.this)) break block4;
                                                var4_5 = BottomSheetBehavior.this.a;
                                                break block5;
                                            }
                                            if (var1_1.getTop() <= BottomSheetBehavior.this.b) break block6;
                                            ** GOTO lbl-1000
                                        }
                                        if (!BottomSheetBehavior.this.d || !BottomSheetBehavior.this.a(var1_1, var3_3) || var1_1.getTop() <= BottomSheetBehavior.this.c && !(Math.abs(var2_2) < Math.abs(var3_3))) break block7;
                                        var4_5 = BottomSheetBehavior.this.g;
                                        var5_4 = 5;
                                        break block8;
                                    }
                                    if (var3_3 == 0.0f || Math.abs(var2_2) > Math.abs(var3_3)) break block9;
                                    var4_5 = BottomSheetBehavior.this.c;
                                    break block8;
                                }
                                var4_5 = var1_1.getTop();
                                if (!BottomSheetBehavior.a(BottomSheetBehavior.this)) break block10;
                                if (Math.abs(var4_5 - BottomSheetBehavior.this.a) >= Math.abs(var4_5 - BottomSheetBehavior.this.c)) ** GOTO lbl-1000
                                var4_5 = BottomSheetBehavior.this.a;
                                break block5;
                            }
                            if (var4_5 >= BottomSheetBehavior.this.b) break block11;
                            if (var4_5 >= Math.abs(var4_5 - BottomSheetBehavior.this.c)) ** GOTO lbl-1000
                        }
                        var4_5 = 0;
                    }
                    var5_4 = 3;
                    break block8;
                }
                if (Math.abs(var4_5 - BottomSheetBehavior.this.b) < Math.abs(var4_5 - BottomSheetBehavior.this.c)) lbl-1000: // 3 sources:
                {
                    var4_5 = BottomSheetBehavior.this.b;
                    var5_4 = 6;
                } else lbl-1000: // 2 sources:
                {
                    var4_5 = BottomSheetBehavior.this.c;
                }
            }
            if (BottomSheetBehavior.this.f.a(var1_1.getLeft(), var4_5)) {
                BottomSheetBehavior.this.b(2);
                t.a(var1_1, new c(var1_1, var5_4));
                return;
            }
            BottomSheetBehavior.this.b(var5_4);
        }

        @Override
        public void a(View view, int n2, int n3, int n4, int n5) {
            BottomSheetBehavior.this.c(n3);
        }

        @Override
        public int b(View view) {
            if (BottomSheetBehavior.this.d) {
                return BottomSheetBehavior.this.g;
            }
            return BottomSheetBehavior.this.c;
        }

        @Override
        public int b(View view, int n2, int n3) {
            int n4 = BottomSheetBehavior.this.e();
            n3 = BottomSheetBehavior.this.d ? BottomSheetBehavior.this.g : BottomSheetBehavior.this.c;
            return androidx.core.c.a.a(n2, n4, n3);
        }

        @Override
        public boolean b(View view, int n2) {
            View view2;
            if (BottomSheetBehavior.this.e == 1) {
                return false;
            }
            if (BottomSheetBehavior.this.k) {
                return false;
            }
            if (BottomSheetBehavior.this.e == 3 && BottomSheetBehavior.this.j == n2 && (view2 = BottomSheetBehavior.this.i != null ? (View)BottomSheetBehavior.this.i.get() : null) != null && view2.canScrollVertically(-1)) {
                return false;
            }
            return BottomSheetBehavior.this.h != null && BottomSheetBehavior.this.h.get() == view;
        }
    };

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, a.i.BottomSheetBehavior_Layout);
        TypedValue typedValue = attributeSet.peekValue(a.i.BottomSheetBehavior_Layout_behavior_peekHeight);
        int n2 = typedValue != null && typedValue.data == -1 ? typedValue.data : attributeSet.getDimensionPixelSize(a.i.BottomSheetBehavior_Layout_behavior_peekHeight, -1);
        this.a(n2);
        this.b(attributeSet.getBoolean(a.i.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.a(attributeSet.getBoolean(a.i.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        this.c(attributeSet.getBoolean(a.i.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        attributeSet.recycle();
        this.m = ViewConfiguration.get((Context)context).getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ boolean a(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.l;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        int n2 = this.l ? Math.max(this.g - this.q, this.a) : this.g - this.q;
        this.c = n2;
    }

    private void c() {
        this.j = -1;
        if (this.w != null) {
            this.w.recycle();
            this.w = null;
        }
    }

    private float d() {
        if (this.w == null) {
            return 0.0f;
        }
        this.w.computeCurrentVelocity(1000, this.m);
        return this.w.getYVelocity(this.j);
    }

    private void d(final int n2) {
        final View view = (View)this.h.get();
        if (view == null) {
            return;
        }
        ViewParent viewParent = view.getParent();
        if (viewParent != null && viewParent.isLayoutRequested() && t.B(view)) {
            view.post(new Runnable(){

                @Override
                public void run() {
                    BottomSheetBehavior.this.a(view, n2);
                }
            });
            return;
        }
        this.a(view, n2);
    }

    private void d(boolean bl2) {
        if (this.h == null) {
            return;
        }
        Object object = ((View)this.h.get()).getParent();
        if (!(object instanceof CoordinatorLayout)) {
            return;
        }
        object = (CoordinatorLayout)object;
        int n2 = object.getChildCount();
        if (Build.VERSION.SDK_INT >= 16 && bl2) {
            if (this.y == null) {
                this.y = new HashMap<View, Integer>(n2);
            } else {
                return;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            View view = object.getChildAt(i2);
            if (view == this.h.get()) continue;
            if (!bl2) {
                if (this.y == null || !this.y.containsKey((Object)view)) continue;
                n3 = this.y.get((Object)view);
            } else {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.y.put(view, view.getImportantForAccessibility());
                }
                n3 = 4;
            }
            t.b(view, n3);
        }
        if (!bl2) {
            this.y = null;
        }
    }

    private int e() {
        if (this.l) {
            return this.a;
        }
        return 0;
    }

    View a(View view) {
        if (t.w(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            view = (ViewGroup)view;
            int n2 = view.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = this.a(view.getChildAt(i2));
                if (view2 == null) continue;
                return view2;
            }
        }
        return null;
    }

    public final void a(int n2) {
        this.a(n2, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void a(int n2, boolean bl2) {
        int n3 = 1;
        if (n2 == -1) {
            if (this.o) return;
            this.o = true;
            n2 = n3;
        } else {
            if (!this.o) {
                if (this.n == n2) return;
            }
            this.o = false;
            this.n = Math.max(0, n2);
            this.c = this.g - n2;
            n2 = n3;
        }
        if (n2 == 0) return;
        if (this.e != 4) return;
        if (this.h == null) return;
        View view = (View)this.h.get();
        if (view == null) return;
        if (bl2) {
            this.d(this.e);
            return;
        }
        view.requestLayout();
    }

    void a(View object, int n2) {
        block10 : {
            int n3;
            block7 : {
                block9 : {
                    block8 : {
                        block6 : {
                            if (n2 != 4) break block6;
                            n3 = this.c;
                            break block7;
                        }
                        if (n2 != 6) break block8;
                        n3 = this.b;
                        if (this.l && n3 <= this.a) {
                            n3 = this.a;
                            n2 = 3;
                        }
                        break block7;
                    }
                    if (n2 != 3) break block9;
                    n3 = this.e();
                    break block7;
                }
                if (!this.d || n2 != 5) break block10;
                n3 = this.g;
            }
            if (this.f.a((View)object, object.getLeft(), n3)) {
                this.b(2);
                t.a((View)object, new c((View)object, n2));
                return;
            }
            this.b(n2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Illegal state argument: ");
        ((StringBuilder)object).append(n2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @Override
    public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        parcelable = (b)parcelable;
        super.a(coordinatorLayout, v2, parcelable.a());
        int n2 = parcelable.a != 1 && parcelable.a != 2 ? parcelable.a : 4;
        this.e = n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(CoordinatorLayout var1_1, V var2_2, View var3_3, int var4_4) {
        block7 : {
            block10 : {
                block9 : {
                    block8 : {
                        block6 : {
                            var4_4 = var2_2.getTop();
                            var6_5 = this.e();
                            var5_6 = 3;
                            if (var4_4 == var6_5) {
                                this.b(3);
                                return;
                            }
                            if (this.i == null) return;
                            if (var3_3 != this.i.get()) return;
                            if (!this.u) {
                                return;
                            }
                            if (this.t <= 0) break block6;
                            var4_4 = this.e();
                            break block7;
                        }
                        if (!this.d || !this.a((View)var2_2, this.d())) break block8;
                        var4_4 = this.g;
                        var5_6 = 5;
                        break block7;
                    }
                    if (this.t != 0) ** GOTO lbl-1000
                    var4_4 = var2_2.getTop();
                    if (!this.l) break block9;
                    if (Math.abs(var4_4 - this.a) >= Math.abs(var4_4 - this.c)) ** GOTO lbl-1000
                    var4_4 = this.a;
                    break block7;
                }
                if (var4_4 >= this.b) break block10;
                if (var4_4 >= Math.abs(var4_4 - this.c)) ** GOTO lbl-1000
                var4_4 = 0;
                break block7;
            }
            if (Math.abs(var4_4 - this.b) < Math.abs(var4_4 - this.c)) lbl-1000: // 2 sources:
            {
                var4_4 = this.b;
                var5_6 = 6;
            } else lbl-1000: // 3 sources:
            {
                var4_4 = this.c;
                var5_6 = 4;
            }
        }
        if (this.f.a((View)var2_2, var2_2.getLeft(), var4_4)) {
            this.b(2);
            t.a(var2_2, new c((View)var2_2, var5_6));
        } else {
            this.b(var5_6);
        }
        this.u = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(CoordinatorLayout var1_1, V var2_2, View var3_3, int var4_4, int var5_5, int[] var6_6, int var7_7) {
        block11 : {
            block9 : {
                block10 : {
                    if (var7_10 == 1) {
                        return;
                    }
                    if (this.i != null) {
                        var1_2 = (View)this.i.get();
                    } else {
                        var1_3 = null;
                    }
                    if (var3_6 != var1_4) {
                        return;
                    }
                    var4_7 = var2_5.getTop();
                    var7_10 = var4_7 - var5_8;
                    if (var5_8 <= 0) break block9;
                    if (var7_10 >= this.e()) break block10;
                    var6_9[1] = var4_7 - this.e();
                    t.e((View)var2_5, (int)(-var6_9[1]));
                    var4_7 = 3;
                    ** GOTO lbl26
                }
                var6_9[1] = var5_8;
                ** GOTO lbl29
            }
            if (var5_8 >= 0 || var3_6.canScrollVertically(-1)) break block11;
            if (var7_10 > this.c && !this.d) {
                var6_9[1] = var4_7 - this.c;
                t.e((View)var2_5, (int)(-var6_9[1]));
                var4_7 = 4;
lbl26: // 2 sources:
                this.b(var4_7);
            } else {
                var6_9[1] = var5_8;
lbl29: // 2 sources:
                t.e((View)var2_5, (int)(-var5_8));
                this.b(1);
            }
        }
        this.c(var2_5.getTop());
        this.t = var5_8;
        this.u = true;
    }

    public void a(boolean bl2) {
        if (this.l == bl2) {
            return;
        }
        this.l = bl2;
        if (this.h != null) {
            this.b();
        }
        int n2 = this.l && this.e == 6 ? 3 : this.e;
        this.b(n2);
    }

    boolean a(View view, float f2) {
        if (this.r) {
            return true;
        }
        if (view.getTop() < this.c) {
            return false;
        }
        return Math.abs((float)view.getTop() + f2 * 0.1f - (float)this.c) / (float)this.n > 0.5f;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean a(CoordinatorLayout var1_1, V var2_2, int var3_3) {
        block10 : {
            block9 : {
                block8 : {
                    if (t.r((View)var1_1) && !t.r(var2_2)) {
                        var2_2.setFitsSystemWindows(true);
                    }
                    var4_4 = var2_2.getTop();
                    var1_1.a((View)var2_2, var3_3);
                    this.g = var1_1.getHeight();
                    if (this.o) {
                        if (this.p == 0) {
                            this.p = var1_1.getResources().getDimensionPixelSize(a.c.design_bottom_sheet_peek_height_min);
                        }
                        var3_3 = Math.max(this.p, this.g - var1_1.getWidth() * 9 / 16);
                    } else {
                        var3_3 = this.n;
                    }
                    this.q = var3_3;
                    this.a = Math.max(0, this.g - var2_2.getHeight());
                    this.b = this.g / 2;
                    this.b();
                    if (this.e != 3) break block8;
                    var3_3 = this.e();
                    ** GOTO lbl30
                }
                if (this.e != 6) break block9;
                var3_3 = this.b;
                ** GOTO lbl30
            }
            if (!this.d || this.e != 5) break block10;
            var3_3 = this.g;
            ** GOTO lbl30
        }
        if (this.e == 4) {
            var3_3 = this.c;
lbl30: // 4 sources:
            t.e(var2_2, var3_3);
        } else if (this.e == 1 || this.e == 2) {
            t.e(var2_2, var4_4 - var2_2.getTop());
        }
        if (this.f == null) {
            this.f = androidx.e.b.a.a(var1_1, this.z);
        }
        this.h = new WeakReference<V>(var2_2);
        this.i = new WeakReference<View>(this.a((View)var2_2));
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean a(CoordinatorLayout var1_1, V var2_2, MotionEvent var3_3) {
        var6_7 = var2_2 /* !! */ .isShown();
        var7_8 = false;
        if (!var6_7) {
            this.s = true;
            return false;
        }
        var4_9 = var3_6.getActionMasked();
        if (var4_9 == 0) {
            this.c();
        }
        if (this.w == null) {
            this.w = VelocityTracker.obtain();
        }
        this.w.addMovement((MotionEvent)var3_6);
        var9_10 = null;
        if (var4_9 != 3) {
            switch (var4_9) {
                default: {
                    ** break;
                }
                case 0: {
                    var5_11 = (int)var3_6.getX();
                    this.x = (int)var3_6.getY();
                    var8_12 = this.i != null ? (View)this.i.get() : null;
                    if (var8_12 != null && var1_1.a(var8_12, var5_11, this.x)) {
                        this.j = var3_6.getPointerId(var3_6.getActionIndex());
                        this.k = true;
                    }
                    var6_7 = this.j == -1 && var1_1.a((View)var2_2 /* !! */ , var5_11, this.x) == false;
                    this.s = var6_7;
                    ** break;
                }
                case 1: 
            }
        }
        this.k = false;
        this.j = -1;
        if (this.s) {
            this.s = false;
            return false;
        }
lbl33: // 4 sources:
        if (!this.s && this.f != null && this.f.a((MotionEvent)var3_6)) {
            return true;
        }
        var2_3 = var9_10;
        if (this.i != null) {
            var2_4 = (View)this.i.get();
        }
        var6_7 = var7_8;
        if (var4_9 != 2) return var6_7;
        var6_7 = var7_8;
        if (var2_5 == null) return var6_7;
        var6_7 = var7_8;
        if (this.s != false) return var6_7;
        var6_7 = var7_8;
        if (this.e == 1) return var6_7;
        var6_7 = var7_8;
        if (var1_1.a((View)var2_5, (int)var3_6.getX(), (int)var3_6.getY()) != false) return var6_7;
        var6_7 = var7_8;
        if (this.f == null) return var6_7;
        var6_7 = var7_8;
        if (!(Math.abs((float)this.x - var3_6.getY()) > (float)this.f.a())) return var6_7;
        return true;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        boolean bl2;
        block2 : {
            block3 : {
                boolean bl3;
                WeakReference<View> weakReference = this.i;
                bl2 = bl3 = false;
                if (weakReference == null) break block2;
                bl2 = bl3;
                if (view != this.i.get()) break block2;
                if (this.e != 3) break block3;
                bl2 = bl3;
                if (!super.a(coordinatorLayout, v2, view, f2, f3)) break block2;
            }
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2, int n3) {
        boolean bl2 = false;
        this.t = 0;
        this.u = false;
        if ((n2 & 2) != 0) {
            bl2 = true;
        }
        return bl2;
    }

    void b(int n2) {
        View view;
        block3 : {
            boolean bl2;
            block4 : {
                block2 : {
                    if (this.e == n2) {
                        return;
                    }
                    this.e = n2;
                    if (n2 == 6 || n2 == 3) break block2;
                    if (n2 != 5 && n2 != 4) break block3;
                    bl2 = false;
                    break block4;
                }
                bl2 = true;
            }
            this.d(bl2);
        }
        if (this.h != null && (view = (View)this.h.get()) != null && this.v != null) {
            this.v.a(view, n2);
        }
    }

    public void b(boolean bl2) {
        this.d = bl2;
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int n2 = motionEvent.getActionMasked();
        if (this.e == 1 && n2 == 0) {
            return true;
        }
        if (this.f != null) {
            this.f.b(motionEvent);
        }
        if (n2 == 0) {
            this.c();
        }
        if (this.w == null) {
            this.w = VelocityTracker.obtain();
        }
        this.w.addMovement(motionEvent);
        if (n2 == 2 && !this.s && Math.abs((float)this.x - motionEvent.getY()) > (float)this.f.a()) {
            this.f.a((View)v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return this.s ^ true;
    }

    /*
     * Enabled aggressive block sorting
     */
    void c(int n2) {
        View view = (View)this.h.get();
        if (view != null && this.v != null) {
            a a2;
            int n3;
            float f2;
            if (n2 > this.c) {
                a2 = this.v;
                f2 = this.c - n2;
                n2 = this.g;
                n3 = this.c;
            } else {
                a2 = this.v;
                f2 = this.c - n2;
                n2 = this.c;
                n3 = this.e();
            }
            a2.a(view, f2 / (float)(n2 - n3));
            return;
        }
    }

    public void c(boolean bl2) {
        this.r = bl2;
    }

    @Override
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
        return new b(super.d(coordinatorLayout, v2), this.e);
    }

    public static abstract class a {
        public abstract void a(View var1, float var2);

        public abstract void a(View var1, int var2);
    }

    protected static class b
    extends androidx.e.a.a {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>(){

            public b a(Parcel parcel) {
                return new b(parcel, null);
            }

            public b a(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            public b[] a(int n2) {
                return new b[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return this.a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        final int a;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public b(Parcelable parcelable, int n2) {
            super(parcelable);
            this.a = n2;
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeInt(this.a);
        }

    }

    private class c
    implements Runnable {
        private final View b;
        private final int c;

        c(View view, int n2) {
            this.b = view;
            this.c = n2;
        }

        @Override
        public void run() {
            if (BottomSheetBehavior.this.f != null && BottomSheetBehavior.this.f.a(true)) {
                t.a(this.b, this);
                return;
            }
            BottomSheetBehavior.this.b(this.c);
        }
    }

}

