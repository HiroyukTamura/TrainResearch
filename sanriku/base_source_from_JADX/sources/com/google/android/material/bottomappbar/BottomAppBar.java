package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p009e.p028d.p030b.p054b.p055c.C1534a;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: a */
    private int f1067a;

    /* renamed from: b */
    private boolean f1068b;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d */
        private final Rect f1069d = new Rect();

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo25351a(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.mo25351a(bottomAppBar);
            FloatingActionButton a = bottomAppBar.m1729a();
            if (a != null) {
                a.mo25407a(this.f1069d);
                a.clearAnimation();
                a.animate().translationY(((float) (-a.getPaddingBottom())) + ((float) (a.getMeasuredHeight() - this.f1069d.height()))).setInterpolator(C1534a.f1770b).setDuration(175);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo25352b(View view) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            super.mo25352b(bottomAppBar);
            FloatingActionButton a = bottomAppBar.m1729a();
            if (a != null) {
                a.clearAnimation();
                ViewPropertyAnimator animate = a.animate();
                float unused = bottomAppBar.m1734c();
                animate.translationY(0.0f).setInterpolator(C1534a.f1771c).setDuration(225);
            }
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            FloatingActionButton a = bottomAppBar.m1729a();
            if (a != null) {
                ((CoordinatorLayout.LayoutParams) a.getLayoutParams()).anchorGravity = 17;
                BottomAppBar.m1731a(bottomAppBar, a);
                this.f1069d.set(0, 0, a.getMeasuredWidth(), a.getMeasuredHeight());
                throw null;
            } else if (bottomAppBar != null) {
                BottomAppBar.m1733b(bottomAppBar);
                throw null;
            } else {
                throw null;
            }
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (((BottomAppBar) view) != null) {
                return false;
            }
            throw null;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1160a();

        /* renamed from: a */
        int f1070a;

        /* renamed from: b */
        boolean f1071b;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$a */
        static class C1160a implements Parcelable.ClassLoaderCreator<SavedState> {
            C1160a() {
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1070a = parcel.readInt();
            this.f1071b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1070a);
            parcel.writeInt(this.f1071b ? 1 : 0);
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: a */
    public FloatingActionButton m1729a() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if (next instanceof FloatingActionButton) {
                return (FloatingActionButton) next;
            }
        }
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m1731a(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        if (bottomAppBar != null) {
            floatingActionButton.mo25411c((Animator.AnimatorListener) null);
            floatingActionButton.mo25412d((Animator.AnimatorListener) null);
            floatingActionButton.mo25404a((Animator.AnimatorListener) null);
            floatingActionButton.mo25408b((Animator.AnimatorListener) null);
            return;
        }
        throw null;
    }

    /* renamed from: b */
    static /* synthetic */ void m1733b(BottomAppBar bottomAppBar) {
        bottomAppBar.m1732b();
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public float m1734c() {
        FloatingActionButton a = m1729a();
        if (a == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        a.mo25407a(rect);
        if (((float) rect.height()) == 0.0f) {
            a.getMeasuredHeight();
        }
        a.getHeight();
        a.getHeight();
        rect.height();
        throw null;
    }

    @NonNull
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1732b();
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1067a = savedState.f1070a;
        this.f1068b = savedState.f1071b;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1070a = this.f1067a;
        savedState.f1071b = this.f1068b;
        return savedState;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    /* renamed from: b */
    private float m1732b() {
        int i = this.f1067a;
        int i2 = 1;
        int i3 = 0;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i == 1) {
            int measuredWidth = (getMeasuredWidth() / 2) - 0;
            if (z) {
                i2 = -1;
            }
            i3 = measuredWidth * i2;
        }
        return (float) i3;
    }
}
