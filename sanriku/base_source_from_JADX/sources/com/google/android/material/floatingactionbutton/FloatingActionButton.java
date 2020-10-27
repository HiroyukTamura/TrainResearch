package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.C1178b;
import com.google.android.material.internal.C1191a;
import com.google.android.material.internal.C1197e;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import p009e.p028d.p030b.p054b.C1533b;
import p009e.p028d.p030b.p054b.p057e.C1552a;
import p009e.p028d.p030b.p054b.p060h.C1557b;
import p043jp.reifrontier.sanriku.R;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends C1197e implements TintableBackgroundView, TintableImageSourceView, C1552a {

    /* renamed from: b */
    private ColorStateList f1150b;

    /* renamed from: c */
    private PorterDuff.Mode f1151c;
    @Nullable

    /* renamed from: d */
    private ColorStateList f1152d;
    @Nullable

    /* renamed from: e */
    private PorterDuff.Mode f1153e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f1154f;

    /* renamed from: g */
    boolean f1155g;

    /* renamed from: h */
    final Rect f1156h;

    /* renamed from: i */
    private C1178b f1157i;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a */
        private Rect f1158a;

        /* renamed from: b */
        private boolean f1159b;

        public BaseBehavior() {
            this.f1159b = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1533b.f1761d);
            this.f1159b = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        private static boolean m1783a(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m1784a(View view, FloatingActionButton floatingActionButton) {
            return this.f1159b && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.mo25481b() == 0;
        }

        /* renamed from: a */
        private boolean m1785a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m1784a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f1158a == null) {
                this.f1158a = new Rect();
            }
            Rect rect = this.f1158a;
            C1191a.m1815a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.mo25305c()) {
                floatingActionButton.mo25405a((C1175a) null, false);
                return true;
            }
            floatingActionButton.mo25409b((C1175a) null, false);
            return true;
        }

        /* renamed from: b */
        private boolean m1786b(View view, FloatingActionButton floatingActionButton) {
            if (!m1784a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.mo25405a((C1175a) null, false);
                return true;
            }
            floatingActionButton.mo25409b((C1175a) null, false);
            return true;
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (m1783a(view) && m1786b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m1785a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            Rect rect = floatingActionButton.f1156h;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin ? rect.right : floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i4 == 0) {
                return true;
            }
            ViewCompat.offsetLeftAndRight(floatingActionButton, i4);
            return true;
        }

        /* renamed from: a */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f1156h;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m1785a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!m1783a(view)) {
                return false;
            } else {
                m1786b(view, floatingActionButton);
                return false;
            }
        }

        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$a */
    public static abstract class C1175a {
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$b */
    private class C1176b implements C1557b {
        C1176b() {
        }
    }

    /* renamed from: a */
    private int m1768a(int i) {
        Resources resources = getResources();
        if (i == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? m1768a(1) : m1768a(0);
        }
        return resources.getDimensionPixelSize(i != 1 ? R.dimen.design_fab_size_normal : R.dimen.design_fab_size_mini);
    }

    /* renamed from: a */
    private static int m1769a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    private C1178b m1772d() {
        if (this.f1157i == null) {
            this.f1157i = Build.VERSION.SDK_INT >= 21 ? new C1188d(this, new C1176b()) : new C1178b(this, new C1176b());
        }
        return this.f1157i;
    }

    /* renamed from: e */
    private void m1773e() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f1152d;
            if (colorStateList == null) {
                DrawableCompat.clearColorFilter(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f1153e;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
        }
    }

    /* renamed from: a */
    public void mo25404a(@NonNull Animator.AnimatorListener animatorListener) {
        m1772d().mo25434a(animatorListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25405a(@Nullable C1175a aVar, boolean z) {
        m1772d().mo25436a((C1178b.C1184f) null, z);
    }

    /* renamed from: a */
    public boolean mo25406a() {
        throw null;
    }

    @Deprecated
    /* renamed from: a */
    public boolean mo25407a(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    /* renamed from: b */
    public void mo25408b(@NonNull Animator.AnimatorListener animatorListener) {
        m1772d().mo25440b(animatorListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25409b(C1175a aVar, boolean z) {
        m1772d().mo25442b((C1178b.C1184f) null, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo25410c() {
        return m1768a(0);
    }

    /* renamed from: c */
    public void mo25411c(@NonNull Animator.AnimatorListener animatorListener) {
        m1772d().mo25444c(animatorListener);
    }

    /* renamed from: d */
    public void mo25412d(@NonNull Animator.AnimatorListener animatorListener) {
        m1772d().mo25446d(animatorListener);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m1772d().mo25437a(getDrawableState());
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f1150b;
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f1151c;
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return this.f1150b;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.f1151c;
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f1152d;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f1153e;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        m1772d().mo25439b();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1772d().mo25443c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1772d().mo25445d();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int a = m1768a(0);
        this.f1154f = (a + 0) / 2;
        m1772d().mo25449g();
        Math.min(m1769a(a, i), m1769a(a, i2));
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        Bundle bundle = extendableSavedState.f1244a.get("expandableWidgetHelper");
        throw null;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        new ExtendableSavedState(super.onSaveInstanceState());
        throw null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            mo25407a((Rect) null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1150b != colorStateList) {
            this.f1150b = colorStateList;
            if (m1772d() == null) {
                throw null;
            }
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f1151c != mode) {
            this.f1151c = mode;
            if (m1772d() == null) {
                throw null;
            }
        }
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        C1178b d = m1772d();
        d.mo25433a(d.f1177j);
    }

    public void setImageResource(@DrawableRes int i) {
        throw null;
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f1152d != colorStateList) {
            this.f1152d = colorStateList;
            m1773e();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f1153e != mode) {
            this.f1153e = mode;
            m1773e();
        }
    }
}
