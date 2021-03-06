/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 *  android.widget.ListView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.y;

public abstract class aa
implements View.OnAttachStateChangeListener,
View.OnTouchListener {
    private final float a;
    private final int b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    public aa(View view) {
        this.c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.a = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            default: {
                return false;
            }
            case 2: {
                int n2 = motionEvent.findPointerIndex(this.h);
                if (n2 < 0 || aa.a(view, motionEvent.getX(n2), motionEvent.getY(n2), this.a)) break;
                this.e();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            case 1: 
            case 3: {
                this.e();
                return false;
            }
            case 0: {
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, (long)this.b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, (long)this.d);
            }
        }
        return false;
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < (float)(view.getRight() - view.getLeft()) + f4 && f3 < (float)(view.getBottom() - view.getTop()) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] arrn = this.i;
        view.getLocationOnScreen(arrn);
        motionEvent.offsetLocation((float)(-arrn[0]), (float)(-arrn[1]));
        return true;
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.c;
        Object object = this.a();
        if (object != null) {
            if (!object.d()) {
                return false;
            }
            if ((object = (y)object.e()) != null) {
                if (!object.isShown()) {
                    return false;
                }
                MotionEvent motionEvent2 = MotionEvent.obtainNoHistory((MotionEvent)motionEvent);
                this.b(view, motionEvent2);
                this.a((View)object, motionEvent2);
                boolean bl2 = ((y)((Object)object)).a(motionEvent2, this.h);
                motionEvent2.recycle();
                int n2 = motionEvent.getActionMasked();
                n2 = n2 != 1 && n2 != 3 ? 1 : 0;
                return bl2 && n2 != 0;
            }
        }
        return false;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] arrn = this.i;
        view.getLocationOnScreen(arrn);
        motionEvent.offsetLocation((float)arrn[0], (float)arrn[1]);
        return true;
    }

    private void e() {
        if (this.f != null) {
            this.c.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    public abstract s a();

    protected boolean b() {
        s s2 = this.a();
        if (s2 != null && !s2.d()) {
            s2.a();
        }
        return true;
    }

    protected boolean c() {
        s s2 = this.a();
        if (s2 != null && s2.d()) {
            s2.c();
        }
        return true;
    }

    void d() {
        this.e();
        View view = this.c;
        if (view.isEnabled()) {
            if (view.isLongClickable()) {
                return;
            }
            if (!this.b()) {
                return;
            }
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long l2 = SystemClock.uptimeMillis();
            MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
            view.onTouchEvent(motionEvent);
            motionEvent.recycle();
            this.g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl2;
        block7 : {
            block6 : {
                boolean bl3;
                boolean bl4 = this.g;
                boolean bl5 = false;
                if (bl4) {
                    bl3 = this.b(motionEvent) || !this.c();
                } else {
                    bl2 = this.a(motionEvent) && this.b();
                    bl3 = bl2;
                    if (bl2) {
                        long l2 = SystemClock.uptimeMillis();
                        view = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
                        this.c.onTouchEvent((MotionEvent)view);
                        view.recycle();
                        bl3 = bl2;
                    }
                }
                this.g = bl3;
                if (bl3) break block6;
                bl2 = bl5;
                if (!bl4) break block7;
            }
            bl2 = true;
        }
        return bl2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    private class a
    implements Runnable {
        a() {
        }

        @Override
        public void run() {
            ViewParent viewParent = aa.this.c.getParent();
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b
    implements Runnable {
        b() {
        }

        @Override
        public void run() {
            aa.this.d();
        }
    }

}

