package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.C1196d;
import java.lang.ref.WeakReference;
import java.util.List;
import p009e.p028d.p030b.p054b.C1533b;
import p009e.p028d.p030b.p054b.p055c.C1534a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    private int f999a;

    /* renamed from: b */
    private int f1000b;

    /* renamed from: c */
    private int f1001c;

    /* renamed from: d */
    private boolean f1002d;

    /* renamed from: e */
    private int f1003e;

    /* renamed from: f */
    private WindowInsetsCompat f1004f;

    /* renamed from: g */
    private boolean f1005g;

    /* renamed from: h */
    private boolean f1006h;

    /* renamed from: i */
    private boolean f1007i;

    /* renamed from: l */
    private int[] f1008l;

    protected static class BaseBehavior<T extends AppBarLayout> extends C1150b<T> {
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f1009k;

        /* renamed from: l */
        private int f1010l;

        /* renamed from: m */
        private ValueAnimator f1011m;

        /* renamed from: n */
        private int f1012n = -1;

        /* renamed from: o */
        private boolean f1013o;

        /* renamed from: p */
        private float f1014p;

        /* renamed from: q */
        private WeakReference<View> f1015q;

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new C1146a();

            /* renamed from: a */
            int f1016a;

            /* renamed from: b */
            float f1017b;

            /* renamed from: c */
            boolean f1018c;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$a */
            static class C1146a implements Parcelable.ClassLoaderCreator<SavedState> {
                C1146a() {
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
                this.f1016a = parcel.readInt();
                this.f1017b = parcel.readFloat();
                this.f1018c = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f1016a);
                parcel.writeFloat(this.f1017b);
                parcel.writeByte(this.f1018c ? (byte) 1 : 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        private void m1680a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int b = mo25330b();
                if ((i < 0 && b == 0) || (i > 0 && b == (-t.mo25304b()))) {
                    ViewCompat.stopNestedScroll(view, 1);
                }
            }
        }

        /* renamed from: a */
        private void m1681a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int abs = Math.abs(mo25330b() - i);
            float abs2 = Math.abs(f);
            int round = abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            int b = mo25330b();
            if (b == i) {
                ValueAnimator valueAnimator = this.f1011m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f1011m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f1011m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f1011m = valueAnimator3;
                valueAnimator3.setInterpolator(C1534a.f1772d);
                this.f1011m.addUpdateListener(new C1149a(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.f1011m.setDuration((long) Math.min(round, 600));
            this.f1011m.setIntValues(new int[]{b, i});
            this.f1011m.start();
        }

        /* renamed from: a */
        private static boolean m1683a(int i, int i2) {
            return (i & i2) == i2;
        }

        /* renamed from: a */
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            int a = mo25345a();
            int childCount = t.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + a;
                if (childAt.getTop() + a > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f1016a = i;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t.mo25308e()) {
                        z = true;
                    }
                    savedState.f1018c = z;
                    savedState.f1017b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* renamed from: a */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t, savedState.getSuperState());
                this.f1012n = savedState.f1016a;
                this.f1014p = savedState.f1017b;
                this.f1013o = savedState.f1018c;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.f1012n = -1;
        }

        /* renamed from: a */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.f1010l == 0 || i == 1) {
                m1684b(coordinatorLayout, t);
            }
            this.f1015q = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                mo25337a(coordinatorLayout, t, i4, -t.mo25304b(), 0);
                m1680a(i4, t, view, i5);
            }
            if (t.mo25314h()) {
                t.mo25303a(view.getScrollY() > 0);
            }
        }

        /* renamed from: a */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.LayoutParams) t.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t, i, i2, i3, i4);
            }
            coordinatorLayout.onMeasureChild(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo25330b() {
            return mo25345a() + this.f1009k;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a5  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo25331b(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                r2 = r9
                com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
                int r9 = r7.mo25330b()
                r0 = 0
                if (r11 == 0) goto L_0x00af
                if (r9 < r11) goto L_0x00af
                if (r9 > r12) goto L_0x00af
                int r3 = androidx.core.math.MathUtils.clamp((int) r10, (int) r11, (int) r12)
                if (r9 == r3) goto L_0x00b1
                boolean r10 = r2.mo25310g()
                if (r10 == 0) goto L_0x0087
                int r10 = java.lang.Math.abs(r3)
                int r11 = r2.getChildCount()
                r12 = 0
            L_0x0023:
                if (r12 >= r11) goto L_0x0087
                android.view.View r1 = r2.getChildAt(r12)
                android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r4 = (com.google.android.material.appbar.AppBarLayout.C1148b) r4
                android.view.animation.Interpolator r5 = r4.f1021b
                int r6 = r1.getTop()
                if (r10 < r6) goto L_0x0084
                int r6 = r1.getBottom()
                if (r10 > r6) goto L_0x0084
                if (r5 == 0) goto L_0x0087
                int r11 = r4.f1020a
                r12 = r11 & 1
                if (r12 == 0) goto L_0x0059
                int r12 = r1.getHeight()
                int r6 = r4.topMargin
                int r12 = r12 + r6
                int r4 = r4.bottomMargin
                int r12 = r12 + r4
                int r0 = r0 + r12
                r11 = r11 & 2
                if (r11 == 0) goto L_0x0059
                int r11 = androidx.core.view.ViewCompat.getMinimumHeight(r1)
                int r0 = r0 - r11
            L_0x0059:
                boolean r11 = androidx.core.view.ViewCompat.getFitsSystemWindows(r1)
                if (r11 == 0) goto L_0x0064
                int r11 = r2.mo25308e()
                int r0 = r0 - r11
            L_0x0064:
                if (r0 <= 0) goto L_0x0087
                int r11 = r1.getTop()
                int r10 = r10 - r11
                float r11 = (float) r0
                float r10 = (float) r10
                float r10 = r10 / r11
                float r10 = r5.getInterpolation(r10)
                float r10 = r10 * r11
                int r10 = java.lang.Math.round(r10)
                int r11 = java.lang.Integer.signum(r3)
                int r12 = r1.getTop()
                int r12 = r12 + r10
                int r12 = r12 * r11
                goto L_0x0088
            L_0x0084:
                int r12 = r12 + 1
                goto L_0x0023
            L_0x0087:
                r12 = r3
            L_0x0088:
                boolean r10 = r7.mo25346a(r12)
                int r11 = r9 - r3
                int r12 = r3 - r12
                r7.f1009k = r12
                if (r10 != 0) goto L_0x009d
                boolean r10 = r2.mo25310g()
                if (r10 == 0) goto L_0x009d
                r8.dispatchDependentViewsChanged(r2)
            L_0x009d:
                r7.mo25345a()
                if (r3 >= r9) goto L_0x00a5
                r9 = -1
                r4 = -1
                goto L_0x00a7
            L_0x00a5:
                r9 = 1
                r4 = 1
            L_0x00a7:
                r5 = 0
                r0 = r7
                r1 = r8
                r0.m1682a(r1, r2, r3, r4, r5)
                r0 = r11
                goto L_0x00b1
            L_0x00af:
                r7.f1009k = r0
            L_0x00b1:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.mo25331b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo25326a(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference<View> weakReference = this.f1015q;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            return view2 != null && view2.isShown() && !view2.canScrollVertically(-1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25321a(CoordinatorLayout coordinatorLayout, View view) {
            m1684b(coordinatorLayout, (AppBarLayout) view);
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t, int i) {
            int i2;
            super.onLayoutChild(coordinatorLayout, t, i);
            int d = t.mo25307d();
            int i3 = this.f1012n;
            if (i3 < 0 || (d & 8) != 0) {
                if (d != 0) {
                    boolean z = (d & 4) != 0;
                    if ((d & 2) != 0) {
                        i2 = -t.mo25309f();
                        if (z) {
                            m1681a(coordinatorLayout, t, i2, 0.0f);
                        }
                    } else if ((d & 1) != 0) {
                        if (z) {
                            m1681a(coordinatorLayout, t, 0, 0.0f);
                        } else {
                            mo25338b(coordinatorLayout, t, 0);
                        }
                    }
                }
                t.mo25315i();
                this.f1012n = -1;
                mo25346a(MathUtils.clamp(mo25345a(), -t.mo25309f(), 0));
                m1682a(coordinatorLayout, t, mo25345a(), 0, true);
                mo25345a();
                return true;
            }
            View childAt = t.getChildAt(i3);
            i2 = (this.f1013o ? ViewCompat.getMinimumHeight(childAt) + t.mo25308e() : Math.round(((float) childAt.getHeight()) * this.f1014p)) + (-childAt.getBottom());
            mo25338b(coordinatorLayout, t, i2);
            t.mo25315i();
            this.f1012n = -1;
            mo25346a(MathUtils.clamp(mo25345a(), -t.mo25309f(), 0));
            m1682a(coordinatorLayout, t, mo25345a(), 0, true);
            mo25345a();
            return true;
        }

        /* renamed from: a */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.mo25309f();
                    i5 = i6;
                    i4 = t.mo25300a() + i6;
                } else {
                    i5 = -t.mo25309f();
                    i4 = 0;
                }
                if (i5 != i4) {
                    iArr[1] = mo25337a(coordinatorLayout, t, i2, i5, i4);
                    m1680a(i2, t, view, i3);
                }
            }
        }

        /* renamed from: b */
        private void m1684b(CoordinatorLayout coordinatorLayout, T t) {
            int b = mo25330b();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                C1148b bVar = (C1148b) childAt.getLayoutParams();
                if (m1683a(bVar.f1020a, 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i2 = -b;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                C1148b bVar2 = (C1148b) childAt2.getLayoutParams();
                int i3 = bVar2.f1020a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == t.getChildCount() - 1) {
                        i5 += t.mo25308e();
                    }
                    if (m1683a(i3, 2)) {
                        i5 += ViewCompat.getMinimumHeight(childAt2);
                    } else if (m1683a(i3, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt2) + i5;
                        if (b < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if (m1683a(i3, 32)) {
                        i4 += bVar2.topMargin;
                        i5 -= bVar2.bottomMargin;
                    }
                    if (b < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    m1681a(coordinatorLayout, t, MathUtils.clamp(i4, -t.mo25309f(), 0), 0.0f);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (((r3.mo25309f() != 0) && r2.getHeight() - r4.getHeight() <= r3.getHeight()) != false) goto L_0x002d;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, T r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                r5 = r6 & 2
                r6 = 1
                r0 = 0
                if (r5 == 0) goto L_0x002c
                boolean r5 = r3.mo25314h()
                if (r5 != 0) goto L_0x002d
                int r5 = r3.mo25309f()
                if (r5 == 0) goto L_0x0014
                r5 = 1
                goto L_0x0015
            L_0x0014:
                r5 = 0
            L_0x0015:
                if (r5 == 0) goto L_0x0028
                int r2 = r2.getHeight()
                int r4 = r4.getHeight()
                int r2 = r2 - r4
                int r3 = r3.getHeight()
                if (r2 > r3) goto L_0x0028
                r2 = 1
                goto L_0x0029
            L_0x0028:
                r2 = 0
            L_0x0029:
                if (r2 == 0) goto L_0x002c
                goto L_0x002d
            L_0x002c:
                r6 = 0
            L_0x002d:
                if (r6 == 0) goto L_0x0036
                android.animation.ValueAnimator r2 = r1.f1011m
                if (r2 == 0) goto L_0x0036
                r2.cancel()
            L_0x0036:
                r2 = 0
                r1.f1015q = r2
                r1.f1010l = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, android.view.View, int, int):boolean");
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0088  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m1682a(androidx.coordinatorlayout.widget.CoordinatorLayout r8, T r9, int r10, int r11, boolean r12) {
            /*
                r7 = this;
                int r0 = java.lang.Math.abs(r10)
                int r1 = r9.getChildCount()
                r2 = 0
                r3 = 0
            L_0x000a:
                r4 = 0
                if (r3 >= r1) goto L_0x0021
                android.view.View r5 = r9.getChildAt(r3)
                int r6 = r5.getTop()
                if (r0 < r6) goto L_0x001e
                int r6 = r5.getBottom()
                if (r0 > r6) goto L_0x001e
                goto L_0x0022
            L_0x001e:
                int r3 = r3 + 1
                goto L_0x000a
            L_0x0021:
                r5 = r4
            L_0x0022:
                if (r5 == 0) goto L_0x00bb
                android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r0 = (com.google.android.material.appbar.AppBarLayout.C1148b) r0
                int r0 = r0.f1020a
                r1 = r0 & 1
                r3 = 1
                if (r1 == 0) goto L_0x005c
                int r1 = androidx.core.view.ViewCompat.getMinimumHeight(r5)
                if (r11 <= 0) goto L_0x004a
                r11 = r0 & 12
                if (r11 == 0) goto L_0x004a
                int r10 = -r10
                int r11 = r5.getBottom()
                int r11 = r11 - r1
                int r0 = r9.mo25308e()
                int r11 = r11 - r0
                if (r10 < r11) goto L_0x005c
            L_0x0048:
                r10 = 1
                goto L_0x005d
            L_0x004a:
                r11 = r0 & 2
                if (r11 == 0) goto L_0x005c
                int r10 = -r10
                int r11 = r5.getBottom()
                int r11 = r11 - r1
                int r0 = r9.mo25308e()
                int r11 = r11 - r0
                if (r10 < r11) goto L_0x005c
                goto L_0x0048
            L_0x005c:
                r10 = 0
            L_0x005d:
                boolean r11 = r9.mo25314h()
                if (r11 == 0) goto L_0x0082
                int r11 = r8.getChildCount()
                r0 = 0
            L_0x0068:
                if (r0 >= r11) goto L_0x0077
                android.view.View r1 = r8.getChildAt(r0)
                boolean r5 = r1 instanceof androidx.core.view.NestedScrollingChild
                if (r5 == 0) goto L_0x0074
                r4 = r1
                goto L_0x0077
            L_0x0074:
                int r0 = r0 + 1
                goto L_0x0068
            L_0x0077:
                if (r4 == 0) goto L_0x0082
                int r10 = r4.getScrollY()
                if (r10 <= 0) goto L_0x0081
                r10 = 1
                goto L_0x0082
            L_0x0081:
                r10 = 0
            L_0x0082:
                boolean r10 = r9.mo25303a((boolean) r10)
                if (r12 != 0) goto L_0x00b8
                if (r10 == 0) goto L_0x00bb
                java.util.List r8 = r8.getDependents(r9)
                int r10 = r8.size()
                r11 = 0
            L_0x0093:
                if (r11 >= r10) goto L_0x00b6
                java.lang.Object r12 = r8.get(r11)
                android.view.View r12 = (android.view.View) r12
                android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r12 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r12
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r12 = r12.getBehavior()
                boolean r0 = r12 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r0 == 0) goto L_0x00b3
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r12 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r12
                int r8 = r12.mo25342b()
                if (r8 == 0) goto L_0x00b6
                r2 = 1
                goto L_0x00b6
            L_0x00b3:
                int r11 = r11 + 1
                goto L_0x0093
            L_0x00b6:
                if (r2 == 0) goto L_0x00bb
            L_0x00b8:
                r9.jumpDrawablesToCurrentState()
            L_0x00bb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.m1682a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends C1152c {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1533b.f1765h);
            mo25343b(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public AppBarLayout mo25335a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f1009k) + mo25344c()) - mo25340a(view2));
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.mo25314h()) {
                    appBarLayout.mo25303a(view.getScrollY() > 0);
                }
            }
            return false;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = mo25335a(coordinatorLayout.getDependencies(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f1035d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.mo25302a(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$a */
    class C1147a implements OnApplyWindowInsetsListener {
        C1147a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout.this.mo25301a(windowInsetsCompat);
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$b */
    public static class C1148b extends LinearLayout.LayoutParams {

        /* renamed from: a */
        int f1020a = 1;

        /* renamed from: b */
        Interpolator f1021b;

        public C1148b(int i, int i2) {
            super(i, i2);
        }

        public C1148b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1533b.f1759b);
            this.f1020a = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.f1021b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C1148b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1148b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public C1148b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f999a = -1;
        this.f1000b = -1;
        this.f1001c = -1;
        this.f1003e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
            C1155f.m1717a(this, attributeSet, 0, C2092R.style.Widget_Design_AppBarLayout);
        }
        TypedArray a = C1196d.m1820a(context, attributeSet, C1533b.f1758a, 0, C2092R.style.Widget_Design_AppBarLayout, new int[0]);
        ViewCompat.setBackground(this, a.getDrawable(0));
        if (a.hasValue(4)) {
            m1665a(a.getBoolean(4, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a.hasValue(3)) {
            int integer = getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = (long) integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -2130903540}, ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(this, "elevation", new float[]{(float) a.getDimensionPixelSize(3, 0)}).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", new float[]{0.0f}).setDuration(0));
            setStateListAnimator(stateListAnimator);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a.hasValue(2)) {
                setKeyboardNavigationCluster(a.getBoolean(2, false));
            }
            if (a.hasValue(1)) {
                setTouchscreenBlocksFocus(a.getBoolean(1, false));
            }
        }
        this.f1007i = a.getBoolean(5, false);
        a.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new C1147a());
    }

    /* renamed from: a */
    private void m1665a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i = 8;
        }
        this.f1003e = i2 | i;
        requestLayout();
    }

    /* renamed from: j */
    private void m1666j() {
        this.f999a = -1;
        this.f1000b = -1;
        this.f1001c = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo25300a() {
        int i = this.f1000b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            C1148b bVar = (C1148b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = bVar.f1020a;
            if ((i3 & 5) == 5) {
                int i4 = bVar.topMargin + bVar.bottomMargin + i2;
                if ((i3 & 8) != 0) {
                    i2 = ViewCompat.getMinimumHeight(childAt) + i4;
                } else {
                    i2 = (measuredHeight - ((i3 & 2) != 0 ? ViewCompat.getMinimumHeight(childAt) : mo25308e())) + i4;
                }
            } else if (i2 > 0) {
                break;
            }
        }
        int max = Math.max(0, i2);
        this.f1000b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsetsCompat mo25301a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f1004f, windowInsetsCompat2)) {
            this.f1004f = windowInsetsCompat2;
            m1666j();
        }
        return windowInsetsCompat;
    }

    /* renamed from: a */
    public void mo25302a(boolean z, boolean z2) {
        m1665a(z, z2, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25303a(boolean z) {
        if (this.f1006h == z) {
            return false;
        }
        this.f1006h = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo25304b() {
        int i = this.f1001c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C1148b bVar = (C1148b) childAt.getLayoutParams();
            int measuredHeight = bVar.topMargin + bVar.bottomMargin + childAt.getMeasuredHeight();
            int i4 = bVar.f1020a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt) + mo25308e();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f1001c = max;
        return max;
    }

    /* renamed from: c */
    public final int mo25305c() {
        int e = mo25308e();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + e;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1148b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo25307d() {
        return this.f1003e;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: e */
    public final int mo25308e() {
        WindowInsetsCompat windowInsetsCompat = this.f1004f;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: f */
    public final int mo25309f() {
        int i = this.f999a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C1148b bVar = (C1148b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = bVar.f1020a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - mo25308e());
        this.f999a = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo25310g() {
        return this.f1002d;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1148b(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1148b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C1148b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new C1148b((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1148b((ViewGroup.MarginLayoutParams) layoutParams) : new C1148b(layoutParams);
    }

    /* renamed from: h */
    public boolean mo25314h() {
        return this.f1007i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo25315i() {
        this.f1003e = 0;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        if (this.f1008l == null) {
            this.f1008l = new int[4];
        }
        int[] iArr = this.f1008l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f1005g ? R.attr.state_liftable : -2130903539;
        iArr[1] = (!this.f1005g || !this.f1006h) ? -2130903540 : R.attr.state_lifted;
        iArr[2] = this.f1005g ? R.attr.state_collapsible : -2130903538;
        iArr[3] = (!this.f1005g || !this.f1006h) ? -2130903537 : R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r3 != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            r1.m1666j()
            r2 = 0
            r1.f1002d = r2
            int r3 = r1.getChildCount()
            r4 = 0
        L_0x000e:
            r5 = 1
            if (r4 >= r3) goto L_0x0025
            android.view.View r6 = r1.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$b r6 = (com.google.android.material.appbar.AppBarLayout.C1148b) r6
            android.view.animation.Interpolator r6 = r6.f1021b
            if (r6 == 0) goto L_0x0022
            r1.f1002d = r5
            goto L_0x0025
        L_0x0022:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0025:
            boolean r3 = r1.f1007i
            if (r3 != 0) goto L_0x0051
            int r3 = r1.getChildCount()
            r4 = 0
        L_0x002e:
            if (r4 >= r3) goto L_0x004e
            android.view.View r6 = r1.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$b r6 = (com.google.android.material.appbar.AppBarLayout.C1148b) r6
            int r6 = r6.f1020a
            r0 = r6 & 1
            if (r0 != r5) goto L_0x0046
            r6 = r6 & 10
            if (r6 == 0) goto L_0x0046
            r6 = 1
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            if (r6 == 0) goto L_0x004b
            r3 = 1
            goto L_0x004f
        L_0x004b:
            int r4 = r4 + 1
            goto L_0x002e
        L_0x004e:
            r3 = 0
        L_0x004f:
            if (r3 == 0) goto L_0x0052
        L_0x0051:
            r2 = 1
        L_0x0052:
            boolean r3 = r1.f1005g
            if (r3 == r2) goto L_0x005b
            r1.f1005g = r2
            r1.refreshDrawableState()
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m1666j();
    }

    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* access modifiers changed from: protected */
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m4622generateDefaultLayoutParams() {
        return new C1148b(-1, -2);
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams m4623generateLayoutParams(AttributeSet attributeSet) {
        return new C1148b(getContext(), attributeSet);
    }
}
