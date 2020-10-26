/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.i;
import androidx.c.g;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.r;
import androidx.core.h.t;
import androidx.core.widget.k;
import com.google.android.material.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.h;
import java.util.List;

@CoordinatorLayout.c(a=Behavior.class)
public class FloatingActionButton
extends h
implements r,
k,
com.google.android.material.f.a {
    boolean a;
    final Rect b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private ColorStateList g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final Rect l;
    private final androidx.appcompat.widget.k m;
    private final com.google.android.material.f.c n;
    private com.google.android.material.floatingactionbutton.a o;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a(int n2) {
        if (this.i != 0) {
            return this.i;
        }
        Resources resources = this.getResources();
        if (n2 != -1) {
            if (n2 != 1) {
                n2 = a.c.design_fab_size_normal;
                do {
                    return resources.getDimensionPixelSize(n2);
                    break;
                } while (true);
            }
            n2 = a.c.design_fab_size_mini;
            return resources.getDimensionPixelSize(n2);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) >= 470) return this.a(0);
        return this.a(1);
    }

    private static int a(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n3);
        n3 = View.MeasureSpec.getSize((int)n3);
        if (n4 != Integer.MIN_VALUE) {
            if (n4 != 0) {
                if (n4 == 1073741824) {
                    return n3;
                }
                throw new IllegalArgumentException();
            }
        } else {
            n2 = Math.min(n2, n3);
        }
        return n2;
    }

    private a.e c(final a a2) {
        if (a2 == null) {
            return null;
        }
        return new a.e(){

            @Override
            public void a() {
                a2.b(FloatingActionButton.this);
            }

            @Override
            public void b() {
                a2.a(FloatingActionButton.this);
            }
        };
    }

    private void c(Rect rect) {
        rect.left += this.b.left;
        rect.top += this.b.top;
        rect.right -= this.b.right;
        rect.bottom -= this.b.bottom;
    }

    private void e() {
        PorterDuff.Mode mode;
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        if (this.e == null) {
            androidx.core.graphics.drawable.a.f(drawable2);
            return;
        }
        int n2 = this.e.getColorForState(this.getDrawableState(), 0);
        PorterDuff.Mode mode2 = mode = this.f;
        if (mode == null) {
            mode2 = PorterDuff.Mode.SRC_IN;
        }
        drawable2.mutate().setColorFilter((ColorFilter)i.a(n2, mode2));
    }

    private com.google.android.material.floatingactionbutton.a f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.b(this, new b());
        }
        return new com.google.android.material.floatingactionbutton.a(this, new b());
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.o == null) {
            this.o = this.f();
        }
        return this.o;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.getImpl().a(animatorListener);
    }

    public void a(com.google.android.material.a.k<FloatingActionButton> k2) {
        this.getImpl().a(new c(k2));
    }

    public void a(a a2) {
        this.a(a2, true);
    }

    void a(a a2, boolean bl2) {
        this.getImpl().b(this.c(a2), bl2);
    }

    @Override
    public boolean a() {
        return this.n.a();
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (t.y((View)this)) {
            rect.set(0, 0, this.getWidth(), this.getHeight());
            this.c(rect);
            return true;
        }
        return false;
    }

    public void b() {
        this.a((a)null);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.getImpl().b(animatorListener);
    }

    public void b(Rect rect) {
        rect.set(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
        this.c(rect);
    }

    public void b(a a2) {
        this.b(a2, true);
    }

    void b(a a2, boolean bl2) {
        this.getImpl().a(this.c(a2), bl2);
    }

    public boolean c() {
        return this.getImpl().r();
    }

    public boolean d() {
        return this.getImpl().q();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().a(this.getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    public float getCompatElevation() {
        return this.getImpl().a();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return this.getImpl().b();
    }

    public float getCompatPressedTranslationZ() {
        return this.getImpl().c();
    }

    public Drawable getContentBackground() {
        return this.getImpl().j();
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        return this.n.c();
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return this.getImpl().f();
    }

    @Deprecated
    public int getRippleColor() {
        if (this.g != null) {
            return this.g.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return this.getImpl().e();
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return this.a(this.h);
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        return this.getBackgroundTintList();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.getBackgroundTintMode();
    }

    @Override
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().g();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().m();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().n();
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = this.getSizeDimension();
        this.j = (n4 - this.k) / 2;
        this.getImpl().l();
        n2 = Math.min(FloatingActionButton.a(n4, n2), FloatingActionButton.a(n4, n3));
        this.setMeasuredDimension(this.b.left + n2 + this.b.right, n2 + this.b.top + this.b.bottom);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.m.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (com.google.android.material.m.a)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        this.n.a(parcelable.a.get("expandableWidgetHelper"));
    }

    protected Parcelable onSaveInstanceState() {
        com.google.android.material.m.a a2 = new com.google.android.material.m.a(super.onSaveInstanceState());
        a2.a.put("expandableWidgetHelper", this.n.b());
        return a2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.a(this.l) && !this.l.contains((int)motionEvent.getX(), (int)motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int n2) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int n2) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            this.getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            this.getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        this.getImpl().a(f2);
    }

    public void setCompatElevationResource(int n2) {
        this.setCompatElevation(this.getResources().getDimension(n2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        this.getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int n2) {
        this.setCompatHoveredFocusedTranslationZ(this.getResources().getDimension(n2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        this.getImpl().c(f2);
    }

    public void setCompatPressedTranslationZResource(int n2) {
        this.setCompatPressedTranslationZ(this.getResources().getDimension(n2));
    }

    public void setCustomSize(int n2) {
        if (n2 >= 0) {
            this.i = n2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int n2) {
        this.n.a(n2);
    }

    public void setHideMotionSpec(com.google.android.material.a.h h2) {
        this.getImpl().b(h2);
    }

    public void setHideMotionSpecResource(int n2) {
        this.setHideMotionSpec(com.google.android.material.a.h.a(this.getContext(), n2));
    }

    public void setImageDrawable(Drawable drawable2) {
        if (this.getDrawable() != drawable2) {
            super.setImageDrawable(drawable2);
            this.getImpl().d();
            if (this.e != null) {
                this.e();
            }
        }
    }

    public void setImageResource(int n2) {
        this.m.a(n2);
        this.e();
    }

    public void setRippleColor(int n2) {
        this.setRippleColor(ColorStateList.valueOf((int)n2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            this.getImpl().b(this.g);
        }
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        this.getImpl().i();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        this.getImpl().i();
    }

    public void setShowMotionSpec(com.google.android.material.a.h h2) {
        this.getImpl().a(h2);
    }

    public void setShowMotionSpecResource(int n2) {
        this.setShowMotionSpec(com.google.android.material.a.h.a(this.getContext(), n2));
    }

    public void setSize(int n2) {
        this.i = 0;
        if (n2 != this.h) {
            this.h = n2;
            this.requestLayout();
        }
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        this.setBackgroundTintList(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        this.setBackgroundTintMode(mode);
    }

    @Override
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            this.e();
        }
    }

    @Override
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            this.e();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        this.getImpl().h();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        this.getImpl().h();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        this.getImpl().h();
    }

    public void setUseCompatPadding(boolean bl2) {
        if (this.a != bl2) {
            this.a = bl2;
            this.getImpl().k();
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.b<T> {
        private Rect a;
        private a b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.i.FloatingActionButton_Behavior_Layout);
            this.c = context.getBoolean(a.i.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            context.recycle();
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.b;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.e e2 = (CoordinatorLayout.e)floatingActionButton.getLayoutParams();
                int n2 = floatingActionButton.getRight();
                int n3 = coordinatorLayout.getWidth();
                int n4 = e2.rightMargin;
                int n5 = 0;
                n2 = n2 >= n3 - n4 ? rect.right : (floatingActionButton.getLeft() <= e2.leftMargin ? -rect.left : 0);
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - e2.bottomMargin) {
                    n5 = rect.bottom;
                } else if (floatingActionButton.getTop() <= e2.topMargin) {
                    n5 = -rect.top;
                }
                if (n5 != 0) {
                    t.e((View)floatingActionButton, n5);
                }
                if (n2 != 0) {
                    t.f((View)floatingActionButton, n2);
                }
            }
        }

        private static boolean a(View view) {
            if ((view = view.getLayoutParams()) instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e)view).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.e e2 = (CoordinatorLayout.e)floatingActionButton.getLayoutParams();
            if (!this.c) {
                return false;
            }
            if (e2.a() != view.getId()) {
                return false;
            }
            return floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!this.a((View)appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            com.google.android.material.internal.c.b(coordinatorLayout, (View)appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!this.a(view, floatingActionButton)) {
                return false;
            }
            CoordinatorLayout.e e2 = (CoordinatorLayout.e)floatingActionButton.getLayoutParams();
            if (view.getTop() < floatingActionButton.getHeight() / 2 + e2.topMargin) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        @Override
        public void a(CoordinatorLayout.e e2) {
            if (e2.h == 0) {
                e2.h = 80;
            }
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int n2) {
            View view;
            List<View> list = coordinatorLayout.c((View)floatingActionButton);
            int n3 = list.size();
            for (int i2 = 0; i2 < n3 && !((view = list.get(i2)) instanceof AppBarLayout ? this.a(coordinatorLayout, (AppBarLayout)view, floatingActionButton) : BaseBehavior.a(view) && this.b(view, floatingActionButton)); ++i2) {
            }
            coordinatorLayout.a((View)floatingActionButton, n2);
            this.a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            coordinatorLayout = floatingActionButton.b;
            rect.set(floatingActionButton.getLeft() + ((Rect)coordinatorLayout).left, floatingActionButton.getTop() + ((Rect)coordinatorLayout).top, floatingActionButton.getRight() - ((Rect)coordinatorLayout).right, floatingActionButton.getBottom() - ((Rect)coordinatorLayout).bottom);
            return true;
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                this.a(coordinatorLayout, (AppBarLayout)view, floatingActionButton);
            } else if (BaseBehavior.a(view)) {
                this.b(view, floatingActionButton);
            }
            return false;
        }

        @Override
        public /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return this.a(coordinatorLayout, (FloatingActionButton)view, view2);
        }
    }

    public static class Behavior
    extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class b
    implements com.google.android.material.k.c {
        b() {
        }

        @Override
        public float a() {
            return (float)FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override
        public void a(int n2, int n3, int n4, int n5) {
            FloatingActionButton.this.b.set(n2, n3, n4, n5);
            FloatingActionButton.this.setPadding(n2 + FloatingActionButton.this.j, n3 + FloatingActionButton.this.j, n4 + FloatingActionButton.this.j, n5 + FloatingActionButton.this.j);
        }

        @Override
        public void a(Drawable drawable2) {
            FloatingActionButton.super.setBackgroundDrawable(drawable2);
        }

        @Override
        public boolean b() {
            return FloatingActionButton.this.a;
        }
    }

    class c
    implements a.d {
        private final com.google.android.material.a.k<FloatingActionButton> b;

        c(com.google.android.material.a.k<FloatingActionButton> k2) {
            this.b = k2;
        }

        @Override
        public void a() {
            this.b.a(FloatingActionButton.this);
        }

        @Override
        public void b() {
            this.b.b(FloatingActionButton.this);
        }

        public boolean equals(Object object) {
            return object instanceof c && ((c)object).b.equals(this.b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }
    }

}

