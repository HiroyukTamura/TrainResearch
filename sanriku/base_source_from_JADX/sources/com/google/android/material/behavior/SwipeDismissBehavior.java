package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    ViewDragHelper f1052a;

    /* renamed from: b */
    C1158b f1053b;

    /* renamed from: c */
    private boolean f1054c;

    /* renamed from: d */
    private float f1055d = 0.0f;

    /* renamed from: e */
    int f1056e = 2;

    /* renamed from: f */
    float f1057f = 0.5f;

    /* renamed from: g */
    float f1058g = 0.0f;

    /* renamed from: h */
    float f1059h = 0.5f;

    /* renamed from: i */
    private final ViewDragHelper.Callback f1060i = new C1157a();

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$a */
    class C1157a extends ViewDragHelper.Callback {

        /* renamed from: a */
        private int f1061a;

        /* renamed from: b */
        private int f1062b = -1;

        C1157a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            r5 = r2.f1061a;
            r3 = r3.getWidth() + r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int clampViewPositionHorizontal(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = androidx.core.view.ViewCompat.getLayoutDirection(r3)
                r0 = 1
                if (r5 != r0) goto L_0x0009
                r5 = 1
                goto L_0x000a
            L_0x0009:
                r5 = 0
            L_0x000a:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f1056e
                if (r1 != 0) goto L_0x0024
                if (r5 == 0) goto L_0x001c
            L_0x0012:
                int r5 = r2.f1061a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f1061a
                goto L_0x0037
            L_0x001c:
                int r5 = r2.f1061a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L_0x0037
            L_0x0024:
                if (r1 != r0) goto L_0x0029
                if (r5 == 0) goto L_0x0012
                goto L_0x001c
            L_0x0029:
                int r5 = r2.f1061a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f1061a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L_0x0037:
                int r4 = java.lang.Math.max(r5, r4)
                int r3 = java.lang.Math.min(r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.C1157a.clampViewPositionHorizontal(android.view.View, int, int):int");
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public void onViewCaptured(View view, int i) {
            this.f1062b = i;
            this.f1061a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i) {
            C1158b bVar = SwipeDismissBehavior.this.f1053b;
            if (bVar != null) {
                bVar.mo25358a(i);
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.f1058g) + ((float) this.f1061a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.f1059h) + ((float) this.f1061a);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m1722a(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
            if (java.lang.Math.abs(r7.getLeft() - r6.f1061a) >= java.lang.Math.round(((float) r7.getWidth()) * r6.f1063c.f1057f)) goto L_0x002c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r7, float r8, float r9) {
            /*
                r6 = this;
                r9 = -1
                r6.f1062b = r9
                int r9 = r7.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x003e
                int r3 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
                if (r3 != r2) goto L_0x0016
                r3 = 1
                goto L_0x0017
            L_0x0016:
                r3 = 0
            L_0x0017:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.f1056e
                r5 = 2
                if (r4 != r5) goto L_0x001f
                goto L_0x002c
            L_0x001f:
                if (r4 != 0) goto L_0x0030
                if (r3 == 0) goto L_0x0028
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 >= 0) goto L_0x002e
                goto L_0x002c
            L_0x0028:
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 <= 0) goto L_0x002e
            L_0x002c:
                r8 = 1
                goto L_0x005b
            L_0x002e:
                r8 = 0
                goto L_0x005b
            L_0x0030:
                if (r4 != r2) goto L_0x002e
                if (r3 == 0) goto L_0x0039
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 <= 0) goto L_0x002e
                goto L_0x003d
            L_0x0039:
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 >= 0) goto L_0x002e
            L_0x003d:
                goto L_0x002c
            L_0x003e:
                int r8 = r7.getLeft()
                int r0 = r6.f1061a
                int r8 = r8 - r0
                int r0 = r7.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.f1057f
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r8 = java.lang.Math.abs(r8)
                if (r8 < r0) goto L_0x002e
                goto L_0x002c
            L_0x005b:
                if (r8 == 0) goto L_0x006a
                int r8 = r7.getLeft()
                int r0 = r6.f1061a
                if (r8 >= r0) goto L_0x0067
                int r0 = r0 - r9
                goto L_0x0068
            L_0x0067:
                int r0 = r0 + r9
            L_0x0068:
                r1 = 1
                goto L_0x006c
            L_0x006a:
                int r0 = r6.f1061a
            L_0x006c:
                com.google.android.material.behavior.SwipeDismissBehavior r8 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r8 = r8.f1052a
                int r9 = r7.getTop()
                boolean r8 = r8.settleCapturedViewAt(r0, r9)
                if (r8 == 0) goto L_0x0085
                com.google.android.material.behavior.SwipeDismissBehavior$c r8 = new com.google.android.material.behavior.SwipeDismissBehavior$c
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r8.<init>(r7, r1)
                androidx.core.view.ViewCompat.postOnAnimation(r7, r8)
                goto L_0x0090
            L_0x0085:
                if (r1 == 0) goto L_0x0090
                com.google.android.material.behavior.SwipeDismissBehavior r8 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$b r8 = r8.f1053b
                if (r8 == 0) goto L_0x0090
                r8.mo25359a((android.view.View) r7)
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.C1157a.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(View view, int i) {
            return this.f1062b == -1 && SwipeDismissBehavior.this.mo25356a(view);
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$b */
    public interface C1158b {
        /* renamed from: a */
        void mo25358a(int i);

        /* renamed from: a */
        void mo25359a(View view);
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$c */
    private class C1159c implements Runnable {

        /* renamed from: a */
        private final View f1064a;

        /* renamed from: b */
        private final boolean f1065b;

        C1159c(View view, boolean z) {
            this.f1064a = view;
            this.f1065b = z;
        }

        public void run() {
            C1158b bVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f1052a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f1064a, this);
            } else if (this.f1065b && (bVar = SwipeDismissBehavior.this.f1053b) != null) {
                bVar.mo25359a(this.f1064a);
            }
        }
    }

    /* renamed from: a */
    static float m1722a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* renamed from: a */
    public void mo25354a(float f) {
        this.f1059h = m1722a(0.0f, f, 1.0f);
    }

    /* renamed from: a */
    public void mo25355a(int i) {
        this.f1056e = i;
    }

    /* renamed from: a */
    public boolean mo25356a(@NonNull View view) {
        return true;
    }

    /* renamed from: b */
    public void mo25357b(float f) {
        this.f1058g = m1722a(0.0f, f, 1.0f);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f1054c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f1054c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1054c = false;
        }
        if (!z) {
            return false;
        }
        if (this.f1052a == null) {
            this.f1052a = ViewDragHelper.create(coordinatorLayout, this.f1060i);
        }
        return this.f1052a.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f1052a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }
}
