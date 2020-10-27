package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
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
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.bottomsheet.C1166b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1533b;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f1072a = true;

    /* renamed from: b */
    private float f1073b;

    /* renamed from: c */
    private int f1074c;

    /* renamed from: d */
    private boolean f1075d;

    /* renamed from: e */
    private int f1076e;

    /* renamed from: f */
    private int f1077f;

    /* renamed from: g */
    int f1078g;

    /* renamed from: h */
    int f1079h;

    /* renamed from: i */
    int f1080i;

    /* renamed from: j */
    boolean f1081j;

    /* renamed from: k */
    private boolean f1082k;

    /* renamed from: l */
    int f1083l = 4;

    /* renamed from: m */
    ViewDragHelper f1084m;

    /* renamed from: n */
    private boolean f1085n;

    /* renamed from: o */
    private int f1086o;

    /* renamed from: p */
    private boolean f1087p;

    /* renamed from: q */
    int f1088q;

    /* renamed from: r */
    WeakReference<V> f1089r;

    /* renamed from: s */
    WeakReference<View> f1090s;

    /* renamed from: t */
    private C1163b f1091t;

    /* renamed from: u */
    private VelocityTracker f1092u;

    /* renamed from: v */
    int f1093v;

    /* renamed from: w */
    private int f1094w;

    /* renamed from: x */
    boolean f1095x;

    /* renamed from: y */
    private Map<View, Integer> f1096y;

    /* renamed from: z */
    private final ViewDragHelper.Callback f1097z = new C1162a();

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1161a();

        /* renamed from: a */
        final int f1098a;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$a */
        static class C1161a implements Parcelable.ClassLoaderCreator<SavedState> {
            C1161a() {
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
            this.f1098a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f1098a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1098a);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$a */
    class C1162a extends ViewDragHelper.Callback {
        C1162a() {
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            int b = BottomSheetBehavior.this.m1741b();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i, b, bottomSheetBehavior.f1081j ? bottomSheetBehavior.f1088q : bottomSheetBehavior.f1080i);
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f1081j ? bottomSheetBehavior.f1088q : bottomSheetBehavior.f1080i;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.mo25370c(1);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.mo25365a(i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a0, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.f1080i)) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.f1099a.f1080i)) goto L_0x00b4;
         */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00c8  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                r1 = 0
                r2 = 4
                r3 = 6
                r4 = 3
                int r5 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r5 >= 0) goto L_0x0029
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.f1072a
                if (r9 == 0) goto L_0x0018
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f1078g
                r2 = 3
                goto L_0x00ba
            L_0x0018:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f1079h
                if (r9 <= r10) goto L_0x0025
                r0 = r10
            L_0x0023:
                r2 = 6
                goto L_0x0026
            L_0x0025:
                r2 = 3
            L_0x0026:
                r9 = r0
                goto L_0x00ba
            L_0x0029:
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = r5.f1081j
                if (r6 == 0) goto L_0x0051
                boolean r5 = r5.mo25368a((android.view.View) r8, (float) r10)
                if (r5 == 0) goto L_0x0051
                int r5 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r6.f1080i
                if (r5 > r6) goto L_0x004b
                float r5 = java.lang.Math.abs(r9)
                float r6 = java.lang.Math.abs(r10)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 >= 0) goto L_0x0051
            L_0x004b:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f1088q
                r2 = 5
                goto L_0x00ba
            L_0x0051:
                int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x0067
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x0062
                goto L_0x0067
            L_0x0062:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f1080i
                goto L_0x00ba
            L_0x0067:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.f1072a
                if (r10 == 0) goto L_0x0092
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f1078g
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f1080i
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x008d
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f1078g
                goto L_0x0025
            L_0x008d:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f1080i
                goto L_0x0026
            L_0x0092:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r10.f1079h
                if (r9 >= r1) goto L_0x00a3
                int r10 = r10.f1080i
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x00b4
                goto L_0x0025
            L_0x00a3:
                int r10 = r9 - r1
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f1080i
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x008d
            L_0x00b4:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f1079h
                goto L_0x0023
            L_0x00ba:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                androidx.customview.widget.ViewDragHelper r10 = r10.f1084m
                int r0 = r8.getLeft()
                boolean r9 = r10.settleCapturedViewAt(r0, r9)
                if (r9 == 0) goto L_0x00d9
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r10 = 2
                r9.mo25370c(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior$c r9 = new com.google.android.material.bottomsheet.BottomSheetBehavior$c
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r9.<init>(r8, r2)
                androidx.core.view.ViewCompat.postOnAnimation(r8, r9)
                goto L_0x00de
            L_0x00d9:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r8.mo25370c(r2)
            L_0x00de:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C1162a.onViewReleased(android.view.View, float, float):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            r7 = (android.view.View) r0.f1090s.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            r7 = r5.f1099a.f1089r;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryCaptureView(@androidx.annotation.NonNull android.view.View r6, int r7) {
            /*
                r5 = this;
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r0.f1083l
                r2 = 1
                r3 = 0
                if (r1 != r2) goto L_0x0009
                return r3
            L_0x0009:
                boolean r4 = r0.f1095x
                if (r4 == 0) goto L_0x000e
                return r3
            L_0x000e:
                r4 = 3
                if (r1 != r4) goto L_0x0027
                int r1 = r0.f1093v
                if (r1 != r7) goto L_0x0027
                java.lang.ref.WeakReference<android.view.View> r7 = r0.f1090s
                java.lang.Object r7 = r7.get()
                android.view.View r7 = (android.view.View) r7
                if (r7 == 0) goto L_0x0027
                r0 = -1
                boolean r7 = r7.canScrollVertically(r0)
                if (r7 == 0) goto L_0x0027
                return r3
            L_0x0027:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                java.lang.ref.WeakReference<V> r7 = r7.f1089r
                if (r7 == 0) goto L_0x0034
                java.lang.Object r7 = r7.get()
                if (r7 != r6) goto L_0x0034
                goto L_0x0035
            L_0x0034:
                r2 = 0
            L_0x0035:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C1162a.tryCaptureView(android.view.View, int):boolean");
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$b */
    public static abstract class C1163b {
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$c */
    private class C1164c implements Runnable {

        /* renamed from: a */
        private final View f1100a;

        /* renamed from: b */
        private final int f1101b;

        C1164c(View view, int i) {
            this.f1100a = view;
            this.f1101b = i;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.f1084m;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.mo25370c(this.f1101b);
            } else {
                ViewCompat.postOnAnimation(this.f1100a, this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1533b.f1760c);
        TypedValue peekValue = obtainStyledAttributes.peekValue(2);
        if (peekValue == null || (i = peekValue.data) != -1) {
            mo25369b(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        } else {
            mo25369b(i);
        }
        this.f1081j = obtainStyledAttributes.getBoolean(1, false);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        if (this.f1072a != z) {
            this.f1072a = z;
            if (this.f1089r != null) {
                m1738a();
            }
            mo25370c((!this.f1072a || this.f1083l != 6) ? this.f1083l : 3);
        }
        this.f1082k = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        this.f1073b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m1738a() {
        this.f1080i = this.f1072a ? Math.max(this.f1088q - this.f1077f, this.f1078g) : this.f1088q - this.f1077f;
    }

    /* renamed from: a */
    private void m1739a(boolean z) {
        int i;
        WeakReference<V> weakReference = this.f1089r;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.f1096y == null) {
                        this.f1096y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.f1089r.get()) {
                        Map<View, Integer> map = this.f1096y;
                        if (z) {
                            map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            i = 4;
                        } else if (map != null && map.containsKey(childAt)) {
                            i = this.f1096y.get(childAt).intValue();
                        }
                        ViewCompat.setImportantForAccessibility(childAt, i);
                    }
                }
                if (!z) {
                    this.f1096y = null;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m1741b() {
        if (this.f1072a) {
            return this.f1078g;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public View mo25364a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a = mo25364a(viewGroup.getChildAt(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25365a(int i) {
        C1163b bVar;
        if (((View) this.f1089r.get()) != null && (bVar = this.f1091t) != null) {
            int i2 = this.f1080i;
            C1166b.C1170d dVar = (C1166b.C1170d) bVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25366a(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.f1080i;
        } else if (i == 6) {
            i2 = this.f1079h;
            if (this.f1072a && i2 <= (i3 = this.f1078g)) {
                i = 3;
                i2 = i3;
            }
        } else if (i == 3) {
            i2 = m1741b();
        } else if (!this.f1081j || i != 5) {
            throw new IllegalArgumentException(C0681a.m316a("Illegal state argument: ", i));
        } else {
            i2 = this.f1088q;
        }
        if (this.f1084m.smoothSlideViewTo(view, view.getLeft(), i2)) {
            mo25370c(2);
            ViewCompat.postOnAnimation(view, new C1164c(view, i));
            return;
        }
        mo25370c(i);
    }

    /* renamed from: a */
    public void mo25367a(C1163b bVar) {
        this.f1091t = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25368a(View view, float f) {
        if (this.f1082k) {
            return true;
        }
        if (view.getTop() < this.f1080i) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.f1080i)) / ((float) this.f1074c) > 0.5f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo25369b(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f1075d
            if (r4 != 0) goto L_0x0015
            r3.f1075d = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.f1075d
            if (r2 != 0) goto L_0x0017
            int r2 = r3.f1074c
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.f1075d = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.f1074c = r1
            int r1 = r3.f1088q
            int r1 = r1 - r4
            r3.f1080i = r1
        L_0x0024:
            if (r0 == 0) goto L_0x003a
            int r4 = r3.f1083l
            r0 = 4
            if (r4 != r0) goto L_0x003a
            java.lang.ref.WeakReference<V> r4 = r3.f1089r
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003a
            r4.requestLayout()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.mo25369b(int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25370c(int r3) {
        /*
            r2 = this;
            int r0 = r2.f1083l
            if (r0 != r3) goto L_0x0005
            return
        L_0x0005:
            r2.f1083l = r3
            r0 = 6
            r1 = 5
            if (r3 == r0) goto L_0x0016
            r0 = 3
            if (r3 != r0) goto L_0x000f
            goto L_0x0016
        L_0x000f:
            if (r3 == r1) goto L_0x0014
            r0 = 4
            if (r3 != r0) goto L_0x001a
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            r2.m1739a((boolean) r0)
        L_0x001a:
            java.lang.ref.WeakReference<V> r0 = r2.f1089r
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x0036
            com.google.android.material.bottomsheet.BottomSheetBehavior$b r0 = r2.f1091t
            if (r0 == 0) goto L_0x0036
            com.google.android.material.bottomsheet.b$d r0 = (com.google.android.material.bottomsheet.C1166b.C1170d) r0
            if (r0 == 0) goto L_0x0034
            if (r3 != r1) goto L_0x0036
            com.google.android.material.bottomsheet.b r3 = com.google.android.material.bottomsheet.C1166b.this
            r3.cancel()
            goto L_0x0036
        L_0x0034:
            r3 = 0
            throw r3
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.mo25370c(int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            r8 = this;
            boolean r0 = r10.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r8.f1085n = r2
            return r1
        L_0x000b:
            int r0 = r11.getActionMasked()
            r3 = 0
            r4 = -1
            if (r0 != 0) goto L_0x001e
            r8.f1093v = r4
            android.view.VelocityTracker r5 = r8.f1092u
            if (r5 == 0) goto L_0x001e
            r5.recycle()
            r8.f1092u = r3
        L_0x001e:
            android.view.VelocityTracker r5 = r8.f1092u
            if (r5 != 0) goto L_0x0028
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r8.f1092u = r5
        L_0x0028:
            android.view.VelocityTracker r5 = r8.f1092u
            r5.addMovement(r11)
            if (r0 == 0) goto L_0x0040
            if (r0 == r2) goto L_0x0035
            r10 = 3
            if (r0 == r10) goto L_0x0035
            goto L_0x007f
        L_0x0035:
            r8.f1095x = r1
            r8.f1093v = r4
            boolean r10 = r8.f1085n
            if (r10 == 0) goto L_0x007f
            r8.f1085n = r1
            return r1
        L_0x0040:
            float r5 = r11.getX()
            int r5 = (int) r5
            float r6 = r11.getY()
            int r6 = (int) r6
            r8.f1094w = r6
            java.lang.ref.WeakReference<android.view.View> r6 = r8.f1090s
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L_0x0058
        L_0x0057:
            r6 = r3
        L_0x0058:
            if (r6 == 0) goto L_0x006e
            int r7 = r8.f1094w
            boolean r6 = r9.isPointInChildBounds(r6, r5, r7)
            if (r6 == 0) goto L_0x006e
            int r6 = r11.getActionIndex()
            int r6 = r11.getPointerId(r6)
            r8.f1093v = r6
            r8.f1095x = r2
        L_0x006e:
            int r6 = r8.f1093v
            if (r6 != r4) goto L_0x007c
            int r4 = r8.f1094w
            boolean r10 = r9.isPointInChildBounds(r10, r5, r4)
            if (r10 != 0) goto L_0x007c
            r10 = 1
            goto L_0x007d
        L_0x007c:
            r10 = 0
        L_0x007d:
            r8.f1085n = r10
        L_0x007f:
            boolean r10 = r8.f1085n
            if (r10 != 0) goto L_0x008e
            androidx.customview.widget.ViewDragHelper r10 = r8.f1084m
            if (r10 == 0) goto L_0x008e
            boolean r10 = r10.shouldInterceptTouchEvent(r11)
            if (r10 == 0) goto L_0x008e
            return r2
        L_0x008e:
            java.lang.ref.WeakReference<android.view.View> r10 = r8.f1090s
            if (r10 == 0) goto L_0x0099
            java.lang.Object r10 = r10.get()
            r3 = r10
            android.view.View r3 = (android.view.View) r3
        L_0x0099:
            r10 = 2
            if (r0 != r10) goto L_0x00d2
            if (r3 == 0) goto L_0x00d2
            boolean r10 = r8.f1085n
            if (r10 != 0) goto L_0x00d2
            int r10 = r8.f1083l
            if (r10 == r2) goto L_0x00d2
            float r10 = r11.getX()
            int r10 = (int) r10
            float r0 = r11.getY()
            int r0 = (int) r0
            boolean r9 = r9.isPointInChildBounds(r3, r10, r0)
            if (r9 != 0) goto L_0x00d2
            androidx.customview.widget.ViewDragHelper r9 = r8.f1084m
            if (r9 == 0) goto L_0x00d2
            int r9 = r8.f1094w
            float r9 = (float) r9
            float r10 = r11.getY()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            androidx.customview.widget.ViewDragHelper r10 = r8.f1084m
            int r10 = r10.getTouchSlop()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00d2
            r1 = 1
        L_0x00d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.getFitsSystemWindows(r5)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.ViewCompat.getFitsSystemWindows(r6)
            if (r0 != 0) goto L_0x0010
            r6.setFitsSystemWindows(r1)
        L_0x0010:
            int r0 = r6.getTop()
            r5.onLayoutChild(r6, r7)
            int r7 = r5.getHeight()
            r4.f1088q = r7
            boolean r7 = r4.f1075d
            if (r7 == 0) goto L_0x0044
            int r7 = r4.f1076e
            if (r7 != 0) goto L_0x0032
            android.content.res.Resources r7 = r5.getResources()
            r2 = 2131099755(0x7f06006b, float:1.7811872E38)
            int r7 = r7.getDimensionPixelSize(r2)
            r4.f1076e = r7
        L_0x0032:
            int r7 = r4.f1076e
            int r2 = r4.f1088q
            int r3 = r5.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            goto L_0x0046
        L_0x0044:
            int r7 = r4.f1074c
        L_0x0046:
            r4.f1077f = r7
            r7 = 0
            int r2 = r4.f1088q
            int r3 = r6.getHeight()
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            r4.f1078g = r7
            int r7 = r4.f1088q
            r2 = 2
            int r7 = r7 / r2
            r4.f1079h = r7
            r4.m1738a()
            int r7 = r4.f1083l
            r3 = 3
            if (r7 != r3) goto L_0x006c
            int r7 = r4.m1741b()
        L_0x0068:
            androidx.core.view.ViewCompat.offsetTopAndBottom(r6, r7)
            goto L_0x0090
        L_0x006c:
            r3 = 6
            if (r7 != r3) goto L_0x0072
            int r7 = r4.f1079h
            goto L_0x0068
        L_0x0072:
            boolean r3 = r4.f1081j
            if (r3 == 0) goto L_0x007c
            r3 = 5
            if (r7 != r3) goto L_0x007c
            int r7 = r4.f1088q
            goto L_0x0068
        L_0x007c:
            int r7 = r4.f1083l
            r3 = 4
            if (r7 != r3) goto L_0x0084
            int r7 = r4.f1080i
            goto L_0x0068
        L_0x0084:
            if (r7 == r1) goto L_0x0088
            if (r7 != r2) goto L_0x0090
        L_0x0088:
            int r7 = r6.getTop()
            int r0 = r0 - r7
            androidx.core.view.ViewCompat.offsetTopAndBottom(r6, r0)
        L_0x0090:
            androidx.customview.widget.ViewDragHelper r7 = r4.f1084m
            if (r7 != 0) goto L_0x009c
            androidx.customview.widget.ViewDragHelper$Callback r7 = r4.f1097z
            androidx.customview.widget.ViewDragHelper r5 = androidx.customview.widget.ViewDragHelper.create(r5, r7)
            r4.f1084m = r5
        L_0x009c:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r4.f1089r = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r6 = r4.mo25364a((android.view.View) r6)
            r5.<init>(r6)
            r4.f1090s = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
        return view == this.f1090s.get() && (this.f1083l != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        int i4;
        if (i3 != 1 && view == ((View) this.f1090s.get())) {
            int top = v.getTop();
            int i5 = top - i2;
            if (i2 <= 0) {
                if (i2 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.f1080i;
                    if (i5 <= i6 || this.f1081j) {
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        mo25370c(1);
                    } else {
                        iArr[1] = top - i6;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        i4 = 4;
                    }
                }
                mo25365a(v.getTop());
                this.f1086o = i2;
                this.f1087p = true;
            } else if (i5 < m1741b()) {
                iArr[1] = top - m1741b();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                i4 = 3;
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                mo25370c(1);
                mo25365a(v.getTop());
                this.f1086o = i2;
                this.f1087p = true;
            }
            mo25370c(i4);
            mo25365a(v.getTop());
            this.f1086o = i2;
            this.f1087p = true;
        }
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        int i = savedState.f1098a;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.f1083l = i;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.f1083l);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.f1086o = 0;
        this.f1087p = false;
        return (i & 2) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.f1080i)) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r4, @androidx.annotation.NonNull V r5, @androidx.annotation.NonNull android.view.View r6, int r7) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r7 = r3.m1741b()
            r0 = 3
            if (r4 != r7) goto L_0x000f
            r3.mo25370c(r0)
            return
        L_0x000f:
            java.lang.ref.WeakReference<android.view.View> r4 = r3.f1090s
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto L_0x00b1
            boolean r4 = r3.f1087p
            if (r4 != 0) goto L_0x001d
            goto L_0x00b1
        L_0x001d:
            int r4 = r3.f1086o
            r6 = 0
            r7 = 4
            if (r4 <= 0) goto L_0x0029
            int r4 = r3.m1741b()
            goto L_0x0093
        L_0x0029:
            boolean r4 = r3.f1081j
            if (r4 == 0) goto L_0x004c
            android.view.VelocityTracker r4 = r3.f1092u
            if (r4 != 0) goto L_0x0033
            r4 = 0
            goto L_0x0042
        L_0x0033:
            r1 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.f1073b
            r4.computeCurrentVelocity(r1, r2)
            android.view.VelocityTracker r4 = r3.f1092u
            int r1 = r3.f1093v
            float r4 = r4.getYVelocity(r1)
        L_0x0042:
            boolean r4 = r3.mo25368a((android.view.View) r5, (float) r4)
            if (r4 == 0) goto L_0x004c
            int r4 = r3.f1088q
            r0 = 5
            goto L_0x0093
        L_0x004c:
            int r4 = r3.f1086o
            if (r4 != 0) goto L_0x0090
            int r4 = r5.getTop()
            boolean r1 = r3.f1072a
            r2 = 6
            if (r1 == 0) goto L_0x006d
            int r1 = r3.f1078g
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f1080i
            int r4 = r4 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r1 >= r4) goto L_0x0090
            int r4 = r3.f1078g
            goto L_0x0093
        L_0x006d:
            int r1 = r3.f1079h
            if (r4 >= r1) goto L_0x007d
            int r7 = r3.f1080i
            int r7 = r4 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r4 >= r7) goto L_0x008c
            r4 = 0
            goto L_0x0093
        L_0x007d:
            int r0 = r4 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.f1080i
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto L_0x0090
        L_0x008c:
            int r4 = r3.f1079h
            r0 = 6
            goto L_0x0093
        L_0x0090:
            int r4 = r3.f1080i
            r0 = 4
        L_0x0093:
            androidx.customview.widget.ViewDragHelper r7 = r3.f1084m
            int r1 = r5.getLeft()
            boolean r4 = r7.smoothSlideViewTo(r5, r1, r4)
            if (r4 == 0) goto L_0x00ac
            r4 = 2
            r3.mo25370c(r4)
            com.google.android.material.bottomsheet.BottomSheetBehavior$c r4 = new com.google.android.material.bottomsheet.BottomSheetBehavior$c
            r4.<init>(r5, r0)
            androidx.core.view.ViewCompat.postOnAnimation(r5, r4)
            goto L_0x00af
        L_0x00ac:
            r3.mo25370c(r0)
        L_0x00af:
            r3.f1087p = r6
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f1083l == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f1084m;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.f1093v = -1;
            VelocityTracker velocityTracker = this.f1092u;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1092u = null;
            }
        }
        if (this.f1092u == null) {
            this.f1092u = VelocityTracker.obtain();
        }
        this.f1092u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f1085n && Math.abs(((float) this.f1094w) - motionEvent.getY()) > ((float) this.f1084m.getTouchSlop())) {
            this.f1084m.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f1085n;
    }
}
