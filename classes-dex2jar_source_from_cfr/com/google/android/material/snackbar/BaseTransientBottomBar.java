/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.FrameLayout
 */
package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.ab;
import androidx.core.h.p;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.f;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.material.snackbar.b;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler a;
    private static final boolean d;
    private static final int[] e;
    protected final e b;
    final b.a c = new b.a(){

        @Override
        public void a() {
            BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(0, (Object)BaseTransientBottomBar.this));
        }

        @Override
        public void a(int n2) {
            BaseTransientBottomBar.a.sendMessage(BaseTransientBottomBar.a.obtainMessage(1, n2, 0, (Object)BaseTransientBottomBar.this));
        }
    };
    private final ViewGroup f;
    private final Context g;
    private final com.google.android.material.snackbar.a h;
    private int i;
    private View j;
    private final int k;
    private int l;
    private int m;
    private List<a<B>> n;
    private Behavior o;
    private final AccessibilityManager p;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19;
        d = bl2;
        e = new int[]{a.b.snackbarStyle};
        a = new Handler(Looper.getMainLooper(), new Handler.Callback(){

            public boolean handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        return false;
                    }
                    case 1: {
                        ((BaseTransientBottomBar)message.obj).c(message.arg1);
                        return true;
                    }
                    case 0: 
                }
                ((BaseTransientBottomBar)message.obj).i();
                return true;
            }
        });
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a a2) {
        if (viewGroup != null) {
            if (view != null) {
                if (a2 != null) {
                    this.f = viewGroup;
                    this.h = a2;
                    this.g = viewGroup.getContext();
                    f.a(this.g);
                    this.b = (e)LayoutInflater.from((Context)this.g).inflate(this.a(), this.f, false);
                    if (this.b.getBackground() == null) {
                        t.a((View)this.b, this.n());
                    }
                    if (view instanceof SnackbarContentLayout) {
                        ((SnackbarContentLayout)view).a(this.b.getActionTextColorAlpha());
                    }
                    this.b.addView(view);
                    this.k = ((ViewGroup.MarginLayoutParams)this.b.getLayoutParams()).bottomMargin;
                    t.c((View)this.b, 1);
                    t.b((View)this.b, 1);
                    t.b((View)this.b, true);
                    t.a((View)this.b, new p(){

                        @Override
                        public ab a(View view, ab ab2) {
                            BaseTransientBottomBar.this.l = ab2.d();
                            BaseTransientBottomBar.this.o();
                            return ab2;
                        }
                    });
                    t.a((View)this.b, new androidx.core.h.a(){

                        @Override
                        public void a(View view, androidx.core.h.a.b b2) {
                            super.a(view, b2);
                            b2.a(1048576);
                            b2.d(true);
                        }

                        @Override
                        public boolean a(View view, int n2, Bundle bundle) {
                            if (n2 == 1048576) {
                                BaseTransientBottomBar.this.f();
                                return true;
                            }
                            return super.a(view, n2, bundle);
                        }
                    });
                    this.p = (AccessibilityManager)this.g.getSystemService("accessibility");
                    return;
                }
                throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
            }
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    private /* varargs */ ValueAnimator a(float ... valueAnimator) {
        valueAnimator = ValueAnimator.ofFloat((float[])valueAnimator);
        valueAnimator.setInterpolator(com.google.android.material.a.a.a);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.b.setAlpha(((Float)valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimator;
    }

    private /* varargs */ ValueAnimator b(float ... valueAnimator) {
        valueAnimator = ValueAnimator.ofFloat((float[])valueAnimator);
        valueAnimator.setInterpolator(com.google.android.material.a.a.d);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.b.setScaleX(f2);
                BaseTransientBottomBar.this.b.setScaleY(f2);
            }
        });
        return valueAnimator;
    }

    private void e(int n2) {
        if (this.b.getAnimationMode() == 1) {
            this.f(n2);
            return;
        }
        this.g(n2);
    }

    private void f(final int n2) {
        ValueAnimator valueAnimator = this.a(1.0f, 0.0f);
        valueAnimator.setDuration(75L);
        valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(n2);
            }
        });
        valueAnimator.start();
    }

    private void g(final int n2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, this.s()});
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(n2);
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.b(0, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            private int b = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int n2 = (Integer)valueAnimator.getAnimatedValue();
                if (d) {
                    t.e((View)BaseTransientBottomBar.this.b, n2 - this.b);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY((float)n2);
                }
                this.b = n2;
            }
        });
        valueAnimator.start();
    }

    private Drawable n() {
        int n2 = com.google.android.material.e.a.a((View)this.b, a.b.colorSurface, a.b.colorOnSurface, 0.8f);
        float f2 = this.b.getResources().getDimension(a.c.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(n2);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }

    private void o() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
        marginLayoutParams.bottomMargin = this.k + this.l + this.m;
        this.b.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    }

    private int p() {
        if (this.j == null) {
            return 0;
        }
        int[] arrn = new int[2];
        this.j.getLocationOnScreen(arrn);
        int n2 = arrn[1];
        arrn = new int[2];
        this.f.getLocationOnScreen(arrn);
        return arrn[1] + this.f.getHeight() - n2;
    }

    private void q() {
        ValueAnimator valueAnimator = this.a(0.0f, 1.0f);
        ValueAnimator valueAnimator2 = this.b(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2});
        animatorSet.setDuration(150L);
        animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }
        });
        animatorSet.start();
    }

    private void r() {
        final int n2 = this.s();
        if (d) {
            t.e((View)this.b, n2);
        } else {
            this.b.setTranslationY((float)n2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{n2, 0});
        valueAnimator.setInterpolator(com.google.android.material.a.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.a(70, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            private int c;
            {
                this.c = n2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int n22 = (Integer)valueAnimator.getAnimatedValue();
                if (d) {
                    t.e((View)BaseTransientBottomBar.this.b, n22 - this.c);
                } else {
                    BaseTransientBottomBar.this.b.setTranslationY((float)n22);
                }
                this.c = n22;
            }
        });
        valueAnimator.start();
    }

    private int s() {
        int n2 = this.b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        int n3 = n2;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            n3 = n2 + ((ViewGroup.MarginLayoutParams)layoutParams).bottomMargin;
        }
        return n3;
    }

    protected int a() {
        if (this.b()) {
            return a.g.mtrl_layout_snackbar;
        }
        return a.g.design_layout_snackbar;
    }

    public B a(int n2) {
        this.i = n2;
        return (B)this;
    }

    protected void b(int n2) {
        com.google.android.material.snackbar.b.a().a(this.c, n2);
    }

    protected boolean b() {
        TypedArray typedArray = this.g.obtainStyledAttributes(e);
        boolean bl2 = false;
        int n2 = typedArray.getResourceId(0, -1);
        typedArray.recycle();
        if (n2 != -1) {
            bl2 = true;
        }
        return bl2;
    }

    public int c() {
        return this.i;
    }

    final void c(int n2) {
        if (this.l() && this.b.getVisibility() == 0) {
            this.e(n2);
            return;
        }
        this.d(n2);
    }

    public View d() {
        return this.b;
    }

    void d(int n2) {
        ViewParent viewParent;
        com.google.android.material.snackbar.b.a().a(this.c);
        if (this.n != null) {
            for (int i2 = this.n.size() - 1; i2 >= 0; --i2) {
                this.n.get(i2).a(this, n2);
            }
        }
        if ((viewParent = this.b.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView((View)this.b);
        }
    }

    public void e() {
        com.google.android.material.snackbar.b.a().a(this.c(), this.c);
    }

    public void f() {
        this.b(3);
    }

    public boolean g() {
        return com.google.android.material.snackbar.b.a().e(this.c);
    }

    protected SwipeDismissBehavior<? extends View> h() {
        return new Behavior();
    }

    final void i() {
        if (this.b.getParent() == null) {
            Object object = this.b.getLayoutParams();
            if (object instanceof CoordinatorLayout.e) {
                CoordinatorLayout.e e2 = (CoordinatorLayout.e)((Object)object);
                object = this.o == null ? this.h() : this.o;
                if (object instanceof Behavior) {
                    ((Behavior)object).a(this);
                }
                ((SwipeDismissBehavior)object).a(new SwipeDismissBehavior.a(){

                    @Override
                    public void a(int n2) {
                        switch (n2) {
                            default: {
                                return;
                            }
                            case 1: 
                            case 2: {
                                com.google.android.material.snackbar.b.a().c(BaseTransientBottomBar.this.c);
                                return;
                            }
                            case 0: 
                        }
                        com.google.android.material.snackbar.b.a().d(BaseTransientBottomBar.this.c);
                    }

                    @Override
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.b(0);
                    }
                });
                e2.a((CoordinatorLayout.b)object);
                if (this.j == null) {
                    e2.g = 80;
                }
            }
            this.m = this.p();
            this.o();
            this.f.addView((View)this.b);
        }
        this.b.setOnAttachStateChangeListener(new c(){

            @Override
            public void a(View view) {
            }

            @Override
            public void b(View view) {
                if (BaseTransientBottomBar.this.g()) {
                    BaseTransientBottomBar.a.post(new Runnable(){

                        @Override
                        public void run() {
                            BaseTransientBottomBar.this.d(3);
                        }
                    });
                }
            }

        });
        if (t.y((View)this.b)) {
            if (this.l()) {
                this.j();
                return;
            }
            this.k();
            return;
        }
        this.b.setOnLayoutChangeListener(new d(){

            @Override
            public void a(View view, int n2, int n3, int n4, int n5) {
                BaseTransientBottomBar.this.b.setOnLayoutChangeListener(null);
                if (BaseTransientBottomBar.this.l()) {
                    BaseTransientBottomBar.this.j();
                    return;
                }
                BaseTransientBottomBar.this.k();
            }
        });
    }

    void j() {
        if (this.b.getAnimationMode() == 1) {
            this.q();
            return;
        }
        this.r();
    }

    void k() {
        com.google.android.material.snackbar.b.a().b(this.c);
        if (this.n != null) {
            for (int i2 = this.n.size() - 1; i2 >= 0; --i2) {
                this.n.get(i2).a(this);
            }
        }
    }

    boolean l() {
        List list = this.p.getEnabledAccessibilityServiceList(1);
        return list != null && list.isEmpty();
    }

    public static class Behavior
    extends SwipeDismissBehavior<View> {
        private final b g = new b(this);

        private void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.g.a(baseTransientBottomBar);
        }

        @Override
        public boolean a(View view) {
            return this.g.a(view);
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.g.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, view, motionEvent);
        }
    }

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int n2) {
        }
    }

    public static class b {
        private b.a a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int n2 = motionEvent.getActionMasked();
            if (n2 != 3) {
                switch (n2) {
                    default: {
                        return;
                    }
                    case 0: {
                        if (!coordinatorLayout.a(view, (int)motionEvent.getX(), (int)motionEvent.getY())) return;
                        com.google.android.material.snackbar.b.a().c(this.a);
                        return;
                    }
                    case 1: 
                }
            }
            com.google.android.material.snackbar.b.a().d(this.a);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.c;
        }

        public boolean a(View view) {
            return view instanceof e;
        }
    }

    protected static interface c {
        public void a(View var1);

        public void b(View var1);
    }

    protected static interface d {
        public void a(View var1, int var2, int var3, int var4, int var5);
    }

    protected static class e
    extends FrameLayout {
        private static final View.OnTouchListener a = new View.OnTouchListener(){

            @SuppressLint(value={"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        private d b;
        private c c;
        private int d;
        private final float e;

        protected e(Context context) {
            this(context, null);
        }

        protected e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.i.SnackbarLayout);
            if (context.hasValue(a.i.SnackbarLayout_elevation)) {
                t.c((View)this, (float)context.getDimensionPixelSize(a.i.SnackbarLayout_elevation, 0));
            }
            this.d = context.getInt(a.i.SnackbarLayout_animationMode, 0);
            this.e = context.getFloat(a.i.SnackbarLayout_actionTextColorAlpha, 1.0f);
            context.recycle();
            this.setOnTouchListener(a);
            this.setFocusable(true);
        }

        float getActionTextColorAlpha() {
            return this.e;
        }

        int getAnimationMode() {
            return this.d;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.c != null) {
                this.c.a((View)this);
            }
            t.q((View)this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.c != null) {
                this.c.b((View)this);
            }
        }

        protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
            super.onLayout(bl2, n2, n3, n4, n5);
            if (this.b != null) {
                this.b.a((View)this, n2, n3, n4, n5);
            }
        }

        void setAnimationMode(int n2) {
            this.d = n2;
        }

        void setOnAttachStateChangeListener(c c2) {
            this.c = c2;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener = onClickListener != null ? null : a;
            this.setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(d d2) {
            this.b = d2;
        }

    }

}

