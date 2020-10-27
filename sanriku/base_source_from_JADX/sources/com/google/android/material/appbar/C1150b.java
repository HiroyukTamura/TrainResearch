package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* renamed from: com.google.android.material.appbar.b */
abstract class C1150b<V extends View> extends C1153d<V> {

    /* renamed from: d */
    private Runnable f1025d;

    /* renamed from: e */
    OverScroller f1026e;

    /* renamed from: f */
    private boolean f1027f;

    /* renamed from: g */
    private int f1028g = -1;

    /* renamed from: h */
    private int f1029h;

    /* renamed from: i */
    private int f1030i = -1;

    /* renamed from: j */
    private VelocityTracker f1031j;

    /* renamed from: com.google.android.material.appbar.b$a */
    private class C1151a implements Runnable {

        /* renamed from: a */
        private final CoordinatorLayout f1032a;

        /* renamed from: b */
        private final V f1033b;

        C1151a(CoordinatorLayout coordinatorLayout, V v) {
            this.f1032a = coordinatorLayout;
            this.f1033b = v;
        }

        public void run() {
            OverScroller overScroller;
            if (this.f1033b != null && (overScroller = C1150b.this.f1026e) != null) {
                if (overScroller.computeScrollOffset()) {
                    C1150b bVar = C1150b.this;
                    bVar.mo25338b(this.f1032a, this.f1033b, bVar.f1026e.getCurrY());
                    ViewCompat.postOnAnimation(this.f1033b, this);
                    return;
                }
                C1150b.this.mo25321a(this.f1032a, this.f1033b);
            }
        }
    }

    public C1150b() {
    }

    public C1150b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo25337a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo25331b(coordinatorLayout, v, mo25330b() - i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo25321a(CoordinatorLayout coordinatorLayout, V v);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo25326a(V v);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract int mo25330b();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo25338b(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo25331b(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract int mo25331b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f1030i
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f1030i = r0
        L_0x0012:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x001f
            boolean r0 = r4.f1027f
            if (r0 == 0) goto L_0x001f
            return r2
        L_0x001f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L_0x0060
            r5 = -1
            if (r0 == r2) goto L_0x0051
            if (r0 == r1) goto L_0x002f
            r6 = 3
            if (r0 == r6) goto L_0x0051
            goto L_0x008a
        L_0x002f:
            int r6 = r4.f1028g
            if (r6 != r5) goto L_0x0034
            goto L_0x008a
        L_0x0034:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L_0x003b
            goto L_0x008a
        L_0x003b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f1029h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f1030i
            if (r6 <= r0) goto L_0x008a
            r4.f1027f = r2
            r4.f1029h = r5
            goto L_0x008a
        L_0x0051:
            r4.f1027f = r3
            r4.f1028g = r5
            android.view.VelocityTracker r5 = r4.f1031j
            if (r5 == 0) goto L_0x008a
            r5.recycle()
            r5 = 0
            r4.f1031j = r5
            goto L_0x008a
        L_0x0060:
            r4.f1027f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.mo25326a(r6)
            if (r2 == 0) goto L_0x008a
            boolean r5 = r5.isPointInChildBounds(r6, r0, r1)
            if (r5 == 0) goto L_0x008a
            r4.f1029h = r1
            int r5 = r7.getPointerId(r3)
            r4.f1028g = r5
            android.view.VelocityTracker r5 = r4.f1031j
            if (r5 != 0) goto L_0x008a
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r4.f1031j = r5
        L_0x008a:
            android.view.VelocityTracker r5 = r4.f1031j
            if (r5 == 0) goto L_0x0091
            r5.addMovement(r7)
        L_0x0091:
            boolean r5 = r4.f1027f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.C1150b.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r0 != 3) goto L_0x0104;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r20, V r21, android.view.MotionEvent r22) {
        /*
            r19 = this;
            r6 = r19
            r1 = r20
            r2 = r21
            r7 = r22
            int r0 = r6.f1030i
            if (r0 >= 0) goto L_0x001a
            android.content.Context r0 = r20.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r6.f1030i = r0
        L_0x001a:
            int r0 = r22.getActionMasked()
            r8 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00dc
            r4 = 0
            r5 = -1
            if (r0 == r8) goto L_0x006c
            r9 = 2
            if (r0 == r9) goto L_0x002e
            r1 = 3
            if (r0 == r1) goto L_0x00ce
            goto L_0x0104
        L_0x002e:
            int r0 = r6.f1028g
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r5) goto L_0x0037
            return r3
        L_0x0037:
            float r0 = r7.getY(r0)
            int r0 = (int) r0
            int r3 = r6.f1029h
            int r3 = r3 - r0
            boolean r4 = r6.f1027f
            if (r4 != 0) goto L_0x0052
            int r4 = java.lang.Math.abs(r3)
            int r5 = r6.f1030i
            if (r4 <= r5) goto L_0x0052
            r6.f1027f = r8
            if (r3 <= 0) goto L_0x0051
            int r3 = r3 - r5
            goto L_0x0052
        L_0x0051:
            int r3 = r3 + r5
        L_0x0052:
            boolean r4 = r6.f1027f
            if (r4 == 0) goto L_0x0104
            r6.f1029h = r0
            r0 = r2
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            int r0 = r0.mo25304b()
            int r4 = -r0
            r5 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r0.mo25337a(r1, r2, r3, r4, r5)
            goto L_0x0104
        L_0x006c:
            android.view.VelocityTracker r0 = r6.f1031j
            if (r0 == 0) goto L_0x00ce
            r0.addMovement(r7)
            android.view.VelocityTracker r0 = r6.f1031j
            r9 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r9)
            android.view.VelocityTracker r0 = r6.f1031j
            int r9 = r6.f1028g
            float r0 = r0.getYVelocity(r9)
            r9 = r2
            com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
            int r9 = r9.mo25309f()
            int r9 = -r9
            r18 = 0
            java.lang.Runnable r10 = r6.f1025d
            if (r10 == 0) goto L_0x0095
            r2.removeCallbacks(r10)
            r6.f1025d = r4
        L_0x0095:
            android.widget.OverScroller r10 = r6.f1026e
            if (r10 != 0) goto L_0x00a4
            android.widget.OverScroller r10 = new android.widget.OverScroller
            android.content.Context r11 = r21.getContext()
            r10.<init>(r11)
            r6.f1026e = r10
        L_0x00a4:
            android.widget.OverScroller r10 = r6.f1026e
            r11 = 0
            int r12 = r19.mo25345a()
            r13 = 0
            int r14 = java.lang.Math.round(r0)
            r15 = 0
            r16 = 0
            r17 = r9
            r10.fling(r11, r12, r13, r14, r15, r16, r17, r18)
            android.widget.OverScroller r0 = r6.f1026e
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L_0x00cb
            com.google.android.material.appbar.b$a r0 = new com.google.android.material.appbar.b$a
            r0.<init>(r1, r2)
            r6.f1025d = r0
            androidx.core.view.ViewCompat.postOnAnimation(r2, r0)
            goto L_0x00ce
        L_0x00cb:
            r19.mo25321a(r20, r21)
        L_0x00ce:
            r6.f1027f = r3
            r6.f1028g = r5
            android.view.VelocityTracker r0 = r6.f1031j
            if (r0 == 0) goto L_0x0104
            r0.recycle()
            r6.f1031j = r4
            goto L_0x0104
        L_0x00dc:
            float r0 = r22.getX()
            int r0 = (int) r0
            float r4 = r22.getY()
            int r4 = (int) r4
            boolean r0 = r1.isPointInChildBounds(r2, r0, r4)
            if (r0 == 0) goto L_0x010c
            boolean r0 = r6.mo25326a(r2)
            if (r0 == 0) goto L_0x010c
            r6.f1029h = r4
            int r0 = r7.getPointerId(r3)
            r6.f1028g = r0
            android.view.VelocityTracker r0 = r6.f1031j
            if (r0 != 0) goto L_0x0104
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f1031j = r0
        L_0x0104:
            android.view.VelocityTracker r0 = r6.f1031j
            if (r0 == 0) goto L_0x010b
            r0.addMovement(r7)
        L_0x010b:
            return r8
        L_0x010c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.C1150b.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
