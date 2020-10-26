/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.c;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.t;

public class s
implements j {
    private static final s i = new s();
    t.a a = new t.a(){

        @Override
        public void a() {
        }

        @Override
        public void b() {
            s.this.b();
        }

        @Override
        public void c() {
            s.this.c();
        }
    };
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private boolean e = true;
    private Handler f;
    private final k g = new k(this);
    private Runnable h = new Runnable(){

        @Override
        public void run() {
            s.this.f();
            s.this.h();
        }
    };

    private s() {
    }

    public static j a() {
        return i;
    }

    static void a(Context context) {
        i.b(context);
    }

    void b() {
        ++this.b;
        if (this.b == 1 && this.e) {
            this.g.a(g.a.ON_START);
            this.e = false;
        }
    }

    void b(Context context) {
        this.f = new Handler();
        this.g.a(g.a.ON_CREATE);
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new c(){

            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                t.b(activity).a(s.this.a);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                s.this.d();
            }

            @Override
            public void onActivityStopped(Activity activity) {
                s.this.e();
            }
        });
    }

    void c() {
        ++this.c;
        if (this.c == 1) {
            if (this.d) {
                this.g.a(g.a.ON_RESUME);
                this.d = false;
                return;
            }
            this.f.removeCallbacks(this.h);
        }
    }

    void d() {
        --this.c;
        if (this.c == 0) {
            this.f.postDelayed(this.h, 700L);
        }
    }

    void e() {
        --this.b;
        this.h();
    }

    void f() {
        if (this.c == 0) {
            this.d = true;
            this.g.a(g.a.ON_PAUSE);
        }
    }

    @Override
    public g g() {
        return this.g;
    }

    void h() {
        if (this.b == 0 && this.d) {
            this.g.a(g.a.ON_STOP);
            this.e = true;
        }
    }

}

