/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewPropertyAnimator
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.a.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.l.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BottomAppBar
extends Toolbar
implements CoordinatorLayout.a {
    private static final int g = a.h.Widget_MaterialComponents_BottomAppBar;
    AnimatorListenerAdapter e;
    k<FloatingActionButton> f;
    private final int h;
    private final c i;
    private final com.google.android.material.bottomappbar.a j;
    private Animator k;
    private Animator l;
    private final int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private Behavior r;

    private void a(int n2) {
        if (this.n != n2) {
            if (!t.y((View)this)) {
                return;
            }
            if (this.k != null) {
                this.k.cancel();
            }
            ArrayList<Animator> arrayList = new ArrayList<Animator>();
            if (this.o == 1) {
                this.b(n2, arrayList);
            } else {
                this.a(n2, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.k = animatorSet;
            this.k.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.k = null;
                }
            });
            this.k.start();
        }
    }

    private void a(int n2, boolean bl2) {
        if (!t.y((View)this)) {
            return;
        }
        if (this.l != null) {
            this.l.cancel();
        }
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        if (!this.n()) {
            n2 = 0;
            bl2 = false;
        }
        this.a(n2, bl2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.l = animatorSet;
        this.l.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.l = null;
            }
        });
        this.l.start();
    }

    private void a(final int n2, final boolean bl2, List<Animator> list) {
        final ActionMenuView actionMenuView = this.getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)actionMenuView, (String)"alpha", (float[])new float[]{1.0f});
        if (Math.abs(actionMenuView.getTranslationX() - (float)this.b(actionMenuView, n2, bl2)) > 1.0f) {
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)actionMenuView, (String)"alpha", (float[])new float[]{0.0f});
            objectAnimator2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){
                public boolean a;

                public void onAnimationCancel(Animator animator) {
                    this.a = true;
                }

                public void onAnimationEnd(Animator animator) {
                    if (!this.a) {
                        BottomAppBar.this.a(actionMenuView, n2, bl2);
                    }
                }
            });
            actionMenuView = new AnimatorSet();
            actionMenuView.setDuration(150L);
            actionMenuView.playSequentially(new Animator[]{objectAnimator2, objectAnimator});
            list.add((Animator)actionMenuView);
            return;
        }
        if (actionMenuView.getAlpha() < 1.0f) {
            list.add((Animator)objectAnimator);
        }
    }

    private void a(ActionMenuView actionMenuView, int n2, boolean bl2) {
        actionMenuView.setTranslationX((float)this.b(actionMenuView, n2, bl2));
    }

    private void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.b((Animator.AnimatorListener)this.e);
        floatingActionButton.a((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationStart(Animator object) {
                BottomAppBar.this.e.onAnimationStart((Animator)object);
                object = BottomAppBar.this.m();
                if (object != null) {
                    ((FloatingActionButton)object).setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.a(this.f);
    }

    private float b(int n2) {
        int n3 = t.f((View)this);
        int n4 = 1;
        n3 = n3 == 1 ? 1 : 0;
        if (n2 == 1) {
            int n5 = this.getMeasuredWidth() / 2;
            int n6 = this.h;
            n2 = n4;
            if (n3 != 0) {
                n2 = -1;
            }
            return (n5 - n6) * n2;
        }
        return 0.0f;
    }

    private int b(ActionMenuView actionMenuView, int n2, boolean bl2) {
        int n3 = t.f((View)this) == 1 ? 1 : 0;
        int n4 = 0;
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            View view = this.getChildAt(i2);
            boolean bl3 = view.getLayoutParams() instanceof Toolbar.b && (((Toolbar.b)view.getLayoutParams()).a & 8388615) == 8388611;
            int n5 = n4;
            if (bl3) {
                n5 = n3 != 0 ? view.getLeft() : view.getRight();
                n5 = Math.max(n4, n5);
            }
            n4 = n5;
        }
        n3 = n3 != 0 ? actionMenuView.getRight() : actionMenuView.getLeft();
        if (n2 == 1 && bl2) {
            return n4 - n3;
        }
        return 0;
    }

    private void b(int n2, List<Animator> list) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.m(), (String)"translationX", (float[])new float[]{this.b(n2)});
        objectAnimator.setDuration(300L);
        list.add((Animator)objectAnimator);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            View view = this.getChildAt(i2);
            if (!(view instanceof ActionMenuView)) continue;
            return (ActionMenuView)view;
        }
        return null;
    }

    private float getFabTranslationX() {
        return this.b(this.n);
    }

    private float getFabTranslationY() {
        return -this.m;
    }

    private FloatingActionButton m() {
        if (!(this.getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout)this.getParent()).d((View)this)) {
            if (!(view instanceof FloatingActionButton)) continue;
            return (FloatingActionButton)view;
        }
        return null;
    }

    private boolean n() {
        FloatingActionButton floatingActionButton = this.m();
        return floatingActionButton != null && floatingActionButton.d();
    }

    private void o() {
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
    }

    private void p() {
        this.j.a(this.getFabTranslationX());
        Object object = this.m();
        c c2 = this.i;
        float f2 = this.q && this.n() ? 1.0f : 0.0f;
        c2.a(f2);
        if (object != null) {
            ((FloatingActionButton)object).setTranslationY(this.getFabTranslationY());
            ((FloatingActionButton)object).setTranslationX(this.getFabTranslationX());
        }
        if ((object = this.getActionMenuView()) != null) {
            object.setAlpha(1.0f);
            if (!this.n()) {
                this.a((ActionMenuView)object, 0, false);
                return;
            }
            this.a((ActionMenuView)object, this.n, this.q);
        }
    }

    protected void a(final int n2, List<Animator> object) {
        object = this.m();
        if (object != null) {
            if (((FloatingActionButton)object).c()) {
                return;
            }
            ((FloatingActionButton)object).b(new FloatingActionButton.a(){

                @Override
                public void a(FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.b(n2));
                    floatingActionButton.b();
                }
            });
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.i.b();
    }

    @Override
    public CoordinatorLayout.b<BottomAppBar> getBehavior() {
        if (this.r == null) {
            this.r = new Behavior();
        }
        return this.r;
    }

    public float getCradleVerticalOffset() {
        return this.j.a();
    }

    public int getFabAlignmentMode() {
        return this.n;
    }

    public int getFabAnimationMode() {
        return this.o;
    }

    public float getFabCradleMargin() {
        return this.j.c();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.j.d();
    }

    public boolean getHideOnScroll() {
        return this.p;
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (bl2) {
            this.o();
            this.p();
        }
    }

    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (a)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        this.n = parcelable.a;
        this.q = parcelable.b;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        a a2 = new a(super.onSaveInstanceState());
        a2.a = this.n;
        a2.b = this.q;
        return a2;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a((Drawable)this.i, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != this.getCradleVerticalOffset()) {
            this.j.b(f2);
            this.i.invalidateSelf();
        }
    }

    public void setElevation(float f2) {
        this.i.a((int)f2);
    }

    public void setFabAlignmentMode(int n2) {
        this.a(n2);
        this.a(n2, this.q);
        this.n = n2;
    }

    public void setFabAnimationMode(int n2) {
        this.o = n2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != this.getFabCradleMargin()) {
            this.j.d(f2);
            this.i.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != this.getFabCradleRoundedCornerRadius()) {
            this.j.e(f2);
            this.i.invalidateSelf();
        }
    }

    void setFabDiameter(int n2) {
        float f2 = n2;
        if (f2 != this.j.b()) {
            this.j.c(f2);
            this.i.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean bl2) {
        this.p = bl2;
    }

    @Override
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override
    public void setTitle(CharSequence charSequence) {
    }

    public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect a = new Rect();

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override
        public void a(BottomAppBar bottomAppBar) {
            super.a(bottomAppBar);
            FloatingActionButton floatingActionButton = bottomAppBar.m();
            if (floatingActionButton != null) {
                floatingActionButton.clearAnimation();
                floatingActionButton.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.d).setDuration(225L);
            }
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int n2) {
            FloatingActionButton floatingActionButton = bottomAppBar.m();
            if (floatingActionButton != null && !t.y((View)floatingActionButton)) {
                ((CoordinatorLayout.e)floatingActionButton.getLayoutParams()).d = 49;
                bottomAppBar.a(floatingActionButton);
                floatingActionButton.b(this.a);
                bottomAppBar.setFabDiameter(this.a.height());
                bottomAppBar.p();
            }
            coordinatorLayout.a((View)bottomAppBar, n2);
            return super.a(coordinatorLayout, bottomAppBar, n2);
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int n2, int n3) {
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, bottomAppBar, view, view2, n2, n3);
        }

        @Override
        public void b(BottomAppBar object) {
            super.b(object);
            object = ((BottomAppBar)object).m();
            if (object != null) {
                ((FloatingActionButton)object).a(this.a);
                float f2 = object.getMeasuredHeight() - this.a.height();
                object.clearAnimation();
                object.animate().translationY((float)(-object.getPaddingBottom()) + f2).setInterpolator(com.google.android.material.a.a.c).setDuration(175L);
            }
        }
    }

    static class a
    extends androidx.e.a.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>(){

            public a a(Parcel parcel) {
                return new a(parcel, null);
            }

            public a a(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            public a[] a(int n2) {
                return new a[n2];
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
        int a;
        boolean b;

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            boolean bl2 = parcel.readInt() != 0;
            this.b = bl2;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            RuntimeException runtimeException;
            super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            throw runtimeException;
        }

    }

}

