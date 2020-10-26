/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.OverScroller
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.appbar.c;

abstract class a<V extends View>
extends c<V> {
    OverScroller a;
    private Runnable b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    public a() {
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    int a(V v2) {
        return v2.getHeight();
    }

    int a(CoordinatorLayout coordinatorLayout, V v2, int n2, int n3, int n4) {
        int n5 = this.c();
        if (n3 != 0 && n5 >= n3 && n5 <= n4 && n5 != (n2 = androidx.core.c.a.a(n2, n3, n4))) {
            this.a(n2);
            return n5 - n2;
        }
        return 0;
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v2, int n2, int n3, float f2) {
        if (this.b != null) {
            v2.removeCallbacks(this.b);
            this.b = null;
        }
        if (this.a == null) {
            this.a = new OverScroller(v2.getContext());
        }
        this.a.fling(0, this.c(), 0, Math.round(f2), 0, 0, n2, n3);
        if (this.a.computeScrollOffset()) {
            this.b = new a(this, coordinatorLayout, v2);
            t.a(v2, this.b);
            return true;
        }
        this.e(coordinatorLayout, v2);
        return false;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            default: {
                break;
            }
            case 2: {
                int n2 = this.d;
                if (n2 == -1 || (n2 = motionEvent.findPointerIndex(n2)) == -1 || Math.abs((n2 = (int)motionEvent.getY(n2)) - this.e) <= this.f) break;
                this.c = true;
                this.e = n2;
                break;
            }
            case 1: 
            case 3: {
                this.c = false;
                this.d = -1;
                if (this.g == null) break;
                this.g.recycle();
                this.g = null;
                break;
            }
            case 0: {
                this.c = false;
                int n3 = (int)motionEvent.getX();
                int n4 = (int)motionEvent.getY();
                if (!this.c(v2) || !coordinatorLayout.a((View)v2, n3, n4)) break;
                this.e = n4;
                this.d = motionEvent.getPointerId(0);
                this.d();
            }
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        return this.a(coordinatorLayout, v2, n2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int b() {
        return this.c();
    }

    int b(V v2) {
        return -v2.getHeight();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v2, int n2, int n3, int n4) {
        return this.a(coordinatorLayout, v2, this.b() - n2, n3, n4);
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (motionEvent.getActionMasked()) {
            default: {
                break;
            }
            case 2: {
                int n2;
                int n3 = motionEvent.findPointerIndex(this.d);
                if (n3 == -1) {
                    return false;
                }
                int n4 = (int)motionEvent.getY(n3);
                n3 = n2 = this.e - n4;
                if (!this.c) {
                    n3 = n2;
                    if (Math.abs(n2) > this.f) {
                        this.c = true;
                        n3 = n2 > 0 ? n2 - this.f : n2 + this.f;
                    }
                }
                if (!this.c) break;
                this.e = n4;
                this.b(coordinatorLayout, v2, n3, this.b(v2), 0);
                break;
            }
            case 1: {
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                    this.g.computeCurrentVelocity(1000);
                    float f2 = this.g.getYVelocity(this.d);
                    this.a(coordinatorLayout, v2, -this.a(v2), 0, f2);
                }
            }
            case 3: {
                this.c = false;
                this.d = -1;
                if (this.g == null) break;
                this.g.recycle();
                this.g = null;
                break;
            }
            case 0: {
                int n5 = (int)motionEvent.getX();
                int n6 = (int)motionEvent.getY();
                if (coordinatorLayout.a((View)v2, n5, n6) && this.c(v2)) {
                    this.e = n6;
                    this.d = motionEvent.getPointerId(0);
                    this.d();
                    break;
                }
                return false;
            }
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return true;
    }

    boolean c(V v2) {
        return false;
    }

    void e(CoordinatorLayout coordinatorLayout, V v2) {
    }

    private class a
    implements Runnable {
        private final CoordinatorLayout b;
        private final V c;

        a(CoordinatorLayout coordinatorLayout, V v2) {
            this.b = coordinatorLayout;
            this.c = v2;
        }

        @Override
        public void run() {
            if (this.c != null && a.a != null) {
                if (a.a.computeScrollOffset()) {
                    a.a_(this.b, this.c, a.a.getCurrY());
                    t.a(this.c, this);
                    return;
                }
                a.e(this.b, this.c);
            }
        }
    }

}

