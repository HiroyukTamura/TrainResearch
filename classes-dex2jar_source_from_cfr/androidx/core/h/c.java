/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 */
package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class c {
    private final a a;

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public c(Context object, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        void var1_3;
        void var2_5;
        void var3_6;
        if (Build.VERSION.SDK_INT > 17) {
            c c2 = new c((Context)object, (GestureDetector.OnGestureListener)var2_5, (Handler)var3_6);
        } else {
            b b2 = new b((Context)object, (GestureDetector.OnGestureListener)var2_5, (Handler)var3_6);
        }
        this.a = var1_3;
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    static interface a {
        public boolean a(MotionEvent var1);
    }

    static class b
    implements androidx.core.h.c$a {
        private static final int j = ViewConfiguration.getLongPressTimeout();
        private static final int k = ViewConfiguration.getTapTimeout();
        private static final int l = ViewConfiguration.getDoubleTapTimeout();
        final GestureDetector.OnGestureListener a;
        GestureDetector.OnDoubleTapListener b;
        boolean c;
        boolean d;
        MotionEvent e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler m;
        private boolean n;
        private boolean o;
        private boolean p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.m = handler != null ? new a(handler) : new a();
            this.a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                this.a((GestureDetector.OnDoubleTapListener)onGestureListener);
            }
            this.a(context);
        }

        private void a(Context context) {
            if (context != null) {
                if (this.a != null) {
                    this.w = true;
                    context = ViewConfiguration.get((Context)context);
                    int n2 = context.getScaledTouchSlop();
                    int n3 = context.getScaledDoubleTapSlop();
                    this.h = context.getScaledMinimumFlingVelocity();
                    this.i = context.getScaledMaximumFlingVelocity();
                    this.f = n2 * n2;
                    this.g = n3 * n3;
                    return;
                }
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            int n2;
            boolean bl2 = this.p;
            boolean bl3 = false;
            if (!bl2) {
                return false;
            }
            if (motionEvent3.getEventTime() - motionEvent2.getEventTime() > (long)l) {
                return false;
            }
            int n3 = (int)motionEvent.getX() - (int)motionEvent3.getX();
            if (n3 * n3 + (n2 = (int)motionEvent.getY() - (int)motionEvent3.getY()) * n2 < this.g) {
                bl3 = true;
            }
            return bl3;
        }

        private void b() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.c = false;
            this.o = false;
            this.p = false;
            this.d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private void c() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.r = false;
            this.o = false;
            this.p = false;
            this.d = false;
            if (this.n) {
                this.n = false;
            }
        }

        void a() {
            this.m.removeMessages(3);
            this.d = false;
            this.n = true;
            this.a.onLongPress(this.e);
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.b = onDoubleTapListener;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public boolean a(MotionEvent var1_1) {
            var6_2 = var1_1.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(var1_1);
            var10_3 = var6_2 & 255;
            var12_4 = 0;
            var6_2 = var10_3 == 6 ? 1 : 0;
            var7_5 = var6_2 != 0 ? var1_1.getActionIndex() : -1;
            var9_6 = var1_1.getPointerCount();
            var3_8 = 0.0f;
            var2_9 = 0.0f;
            for (var8_7 = 0; var8_7 < var9_6; ++var8_7) {
                if (var7_5 == var8_7) continue;
                var3_8 += var1_1.getX(var8_7);
                var2_9 += var1_1.getY(var8_7);
            }
            var6_2 = var6_2 != 0 ? var9_6 - 1 : var9_6;
            var4_10 = var6_2;
            var3_8 /= var4_10;
            var2_9 /= var4_10;
            switch (var10_3) {
                default: {
                    return false;
                }
                case 6: {
                    this.s = var3_8;
                    this.u = var3_8;
                    this.t = var2_9;
                    this.v = var2_9;
                    this.x.computeCurrentVelocity(1000, (float)this.i);
                    var7_5 = var1_1.getActionIndex();
                    var6_2 = var1_1.getPointerId(var7_5);
                    var2_9 = this.x.getXVelocity(var6_2);
                    var3_8 = this.x.getYVelocity(var6_2);
                    var6_2 = 0;
                    do {
                        var11_11 = var12_4;
                        if (var6_2 >= var9_6) return (boolean)var11_11;
                        if (var6_2 != var7_5 && this.x.getXVelocity(var8_7 = var1_1.getPointerId(var6_2)) * var2_9 + this.x.getYVelocity(var8_7) * var3_8 < 0.0f) {
                            this.x.clear();
                            return false;
                        }
                        ++var6_2;
                    } while (true);
                }
                case 5: {
                    this.s = var3_8;
                    this.u = var3_8;
                    this.t = var2_9;
                    this.v = var2_9;
                    this.c();
                    return false;
                }
                case 3: {
                    this.b();
                    return false;
                }
                case 2: {
                    if (this.n) {
                        return false;
                    }
                    var4_10 = this.s - var3_8;
                    var5_14 = this.t - var2_9;
                    if (this.r) {
                        return false | this.b.onDoubleTapEvent(var1_1);
                    }
                    if (this.o) {
                        var6_2 = (int)(var3_8 - this.u);
                        var7_5 = (int)(var2_9 - this.v);
                        if ((var6_2 = var6_2 * var6_2 + var7_5 * var7_5) > this.f) {
                            var11_12 = this.a.onScroll(this.e, var1_1, var4_10, var5_14);
                            this.s = var3_8;
                            this.t = var2_9;
                            this.o = false;
                            this.m.removeMessages(3);
                            this.m.removeMessages(1);
                            this.m.removeMessages(2);
                        } else {
                            var11_12 = 0;
                        }
                        var12_4 = var11_12;
                        if (var6_2 <= this.f) return (boolean)var12_4;
                        this.p = false;
                        return (boolean)var11_12;
                    }
                    if (!(Math.abs(var4_10) >= 1.0f)) {
                        var11_11 = var12_4;
                        if (!(Math.abs(var5_14) >= 1.0f)) return (boolean)var11_11;
                    }
                    var11_11 = this.a.onScroll(this.e, var1_1, var4_10, var5_14);
                    this.s = var3_8;
                    this.t = var2_9;
                    return (boolean)var11_11;
                }
                case 1: {
                    this.c = false;
                    var13_15 = MotionEvent.obtain((MotionEvent)var1_1);
                    if (!this.r) ** GOTO lbl90
                    var11_13 = this.b.onDoubleTapEvent(var1_1) | false;
                    ** GOTO lbl108
lbl90: // 1 sources:
                    if (!this.n) ** GOTO lbl94
                    this.m.removeMessages(3);
                    this.n = false;
                    ** GOTO lbl-1000
lbl94: // 1 sources:
                    if (this.o) {
                        var11_13 = this.a.onSingleTapUp(var1_1);
                        if (this.d && this.b != null) {
                            this.b.onSingleTapConfirmed(var1_1);
                        }
                    } else {
                        var14_16 = this.x;
                        var6_2 = var1_1.getPointerId(0);
                        var14_16.computeCurrentVelocity(1000, (float)this.i);
                        var2_9 = var14_16.getYVelocity(var6_2);
                        var3_8 = var14_16.getXVelocity(var6_2);
                        if (!(Math.abs(var2_9) > (float)this.h) && !(Math.abs(var3_8) > (float)this.h)) lbl-1000: // 2 sources:
                        {
                            var11_13 = 0;
                        } else {
                            var11_13 = this.a.onFling(this.e, var1_1, var3_8, var2_9);
                        }
                    }
lbl108: // 4 sources:
                    if (this.q != null) {
                        this.q.recycle();
                    }
                    this.q = var13_15;
                    if (this.x != null) {
                        this.x.recycle();
                        this.x = null;
                    }
                    this.r = false;
                    this.d = false;
                    this.m.removeMessages(1);
                    this.m.removeMessages(2);
                    return (boolean)var11_13;
                }
                case 0: 
            }
            if (this.b == null) ** GOTO lbl129
            var11_11 = this.m.hasMessages(3);
            if (var11_11 != 0) {
                this.m.removeMessages(3);
            }
            if (this.e != null && this.q != null && var11_11 != 0 && this.a(this.e, this.q, var1_1)) {
                this.r = true;
                var6_2 = this.b.onDoubleTap(this.e) | false | this.b.onDoubleTapEvent(var1_1);
            } else {
                this.m.sendEmptyMessageDelayed(3, (long)b.l);
lbl129: // 2 sources:
                var6_2 = 0;
            }
            this.s = var3_8;
            this.u = var3_8;
            this.t = var2_9;
            this.v = var2_9;
            if (this.e != null) {
                this.e.recycle();
            }
            this.e = MotionEvent.obtain((MotionEvent)var1_1);
            this.o = true;
            this.p = true;
            this.c = true;
            this.n = false;
            this.d = false;
            if (this.w) {
                this.m.removeMessages(2);
                this.m.sendEmptyMessageAtTime(2, this.e.getDownTime() + (long)b.k + (long)b.j);
            }
            this.m.sendEmptyMessageAtTime(1, this.e.getDownTime() + (long)b.k);
            return (boolean)(var6_2 | this.a.onDown(var1_1));
        }

        private class a
        extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown message ");
                        stringBuilder.append((Object)message);
                        throw new RuntimeException(stringBuilder.toString());
                    }
                    case 3: {
                        if (b.this.b == null) break;
                        if (!b.this.c) {
                            b.this.b.onSingleTapConfirmed(b.this.e);
                            return;
                        }
                        b.this.d = true;
                        return;
                    }
                    case 2: {
                        b.this.a();
                        return;
                    }
                    case 1: {
                        b.this.a.onShowPress(b.this.e);
                    }
                }
            }
        }

    }

    static class c
    implements a {
        private final GestureDetector a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

}

