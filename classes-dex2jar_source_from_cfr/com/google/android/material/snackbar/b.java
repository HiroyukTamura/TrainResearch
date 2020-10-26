/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class b {
    private static b a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback(){

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((b)message.obj);
            return true;
        }
    });
    private b d;
    private b e;

    private b() {
    }

    static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private boolean a(b b2, int n2) {
        a a2 = (a)b2.a.get();
        if (a2 != null) {
            this.c.removeCallbacksAndMessages((Object)b2);
            a2.a(n2);
            return true;
        }
        return false;
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            a a2 = (a)this.d.a.get();
            if (a2 != null) {
                a2.a();
                return;
            }
            this.d = null;
        }
    }

    private void b(b b2) {
        if (b2.b == -2) {
            return;
        }
        int n2 = 2750;
        if (b2.b > 0) {
            n2 = b2.b;
        } else if (b2.b == -1) {
            n2 = 1500;
        }
        this.c.removeCallbacksAndMessages((Object)b2);
        this.c.sendMessageDelayed(Message.obtain((Handler)this.c, (int)0, (Object)b2), (long)n2);
    }

    private boolean f(a a2) {
        return this.d != null && this.d.a(a2);
    }

    private boolean g(a a2) {
        return this.e != null && this.e.a(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2, a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2)) {
                this.d.b = n2;
                this.c.removeCallbacksAndMessages((Object)this.d);
                this.b(this.d);
                return;
            }
            if (this.g(a2)) {
                this.e.b = n2;
            } else {
                this.e = new b(n2, a2);
            }
            if (this.d != null && this.a(this.d, 4)) {
                return;
            }
            this.d = null;
            this.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2)) {
                this.d = null;
                if (this.e != null) {
                    this.b();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a object, int n2) {
        Object object2 = this.b;
        synchronized (object2) {
            block6 : {
                block5 : {
                    block4 : {
                        if (!this.f((a)object)) break block4;
                        object = this.d;
                        break block5;
                    }
                    if (!this.g((a)object)) break block6;
                    object = this.e;
                }
                this.a((b)object, n2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(b b2) {
        Object object = this.b;
        synchronized (object) {
            if (this.d == b2 || this.e == b2) {
                this.a(b2, 2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2)) {
                this.b(this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages((Object)this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2) && this.d.c) {
                this.d.c = false;
                this.b(this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean e(a a2) {
        Object object = this.b;
        synchronized (object) {
            if (this.f(a2)) return true;
            if (!this.g(a2)) return false;
            return true;
        }
    }

    static interface a {
        public void a();

        public void a(int var1);
    }

    private static class b {
        final WeakReference<a> a;
        int b;
        boolean c;

        b(int n2, a a2) {
            this.a = new WeakReference<a>(a2);
            this.b = n2;
        }

        boolean a(a a2) {
            return a2 != null && this.a.get() == a2;
        }
    }

}

