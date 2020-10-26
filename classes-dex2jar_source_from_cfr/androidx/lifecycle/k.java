/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.lifecycle;

import android.util.Log;
import androidx.a.a.b.b;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.j;
import androidx.lifecycle.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class k
extends g {
    private androidx.a.a.b.a<i, a> a = new androidx.a.a.b.a();
    private g.b b;
    private final WeakReference<j> c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<g.b> g = new ArrayList();

    public k(j j2) {
        this.c = new WeakReference<j>(j2);
        this.b = g.b.b;
    }

    static g.b a(g.b b2, g.b b3) {
        g.b b4 = b2;
        if (b3 != null) {
            b4 = b2;
            if (b3.compareTo(b2) < 0) {
                b4 = b3;
            }
        }
        return b4;
    }

    private void a(j j2) {
        b.d d2 = this.a.c();
        while (d2.hasNext() && !this.f) {
            Map.Entry entry = (Map.Entry)d2.next();
            a a2 = (a)entry.getValue();
            while (a2.a.compareTo(this.b) < 0 && !this.f && this.a.c((i)entry.getKey())) {
                this.c(a2.a);
                a2.a(j2, k.e(a2.a));
                this.c();
            }
        }
    }

    static g.b b(g.a a2) {
        switch (a2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append((Object)a2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case ON_DESTROY: {
                return g.b.a;
            }
            case ON_RESUME: {
                return g.b.e;
            }
            case ON_START: 
            case ON_PAUSE: {
                return g.b.d;
            }
            case ON_CREATE: 
            case ON_STOP: 
        }
        return g.b.c;
    }

    private void b(g.b b2) {
        if (this.b == b2) {
            return;
        }
        this.b = b2;
        if (!this.e && this.d == 0) {
            this.e = true;
            this.d();
            this.e = false;
            return;
        }
        this.f = true;
    }

    private void b(j j2) {
        Iterator iterator = this.a.b();
        while (iterator.hasNext() && !this.f) {
            Map.Entry entry = iterator.next();
            a a2 = (a)entry.getValue();
            while (a2.a.compareTo(this.b) > 0 && !this.f && this.a.c((i)entry.getKey())) {
                g.a a3 = k.d(a2.a);
                this.c(k.b(a3));
                a2.a(j2, a3);
                this.c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        g.b b2 = ((a)this.a.d().getValue()).a;
        g.b b3 = ((a)this.a.e().getValue()).a;
        return b2 == b3 && this.b == b3;
    }

    private g.b c(i object) {
        object = this.a.d((i)object);
        g.b b2 = null;
        object = object != null ? ((a)object.getValue()).a : null;
        if (!this.g.isEmpty()) {
            b2 = this.g.get(this.g.size() - 1);
        }
        return k.a(k.a(this.b, (g.b)((Object)object)), b2);
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(g.b b2) {
        this.g.add(b2);
    }

    private static g.a d(g.b b2) {
        switch (b2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append((Object)b2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case a: {
                throw new IllegalArgumentException();
            }
            case e: {
                return g.a.ON_PAUSE;
            }
            case d: {
                return g.a.ON_STOP;
            }
            case c: {
                return g.a.ON_DESTROY;
            }
            case b: 
        }
        throw new IllegalArgumentException();
    }

    private void d() {
        j j2 = (j)this.c.get();
        if (j2 == null) {
            Log.w((String)"LifecycleRegistry", (String)"LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!this.b()) {
            this.f = false;
            if (this.b.compareTo(((a)this.a.d().getValue()).a) < 0) {
                this.b(j2);
            }
            Map.Entry entry = this.a.e();
            if (this.f || entry == null || this.b.compareTo(((a)entry.getValue()).a) <= 0) continue;
            this.a(j2);
        }
        this.f = false;
    }

    private static g.a e(g.b b2) {
        switch (b2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append((Object)b2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case e: {
                throw new IllegalArgumentException();
            }
            case d: {
                return g.a.ON_RESUME;
            }
            case c: {
                return g.a.ON_START;
            }
            case b: 
            case a: 
        }
        return g.a.ON_CREATE;
    }

    @Override
    public g.b a() {
        return this.b;
    }

    public void a(g.a a2) {
        this.b(k.b(a2));
    }

    public void a(g.b b2) {
        this.b(b2);
    }

    @Override
    public void a(i i2) {
        g.b b2 = this.b == g.b.a ? g.b.a : g.b.b;
        a a2 = new a(i2, b2);
        if (this.a.a(i2, a2) != null) {
            return;
        }
        j j2 = (j)this.c.get();
        if (j2 == null) {
            return;
        }
        boolean bl2 = this.d != 0 || this.e;
        b2 = this.c(i2);
        ++this.d;
        while (a2.a.compareTo(b2) < 0 && this.a.c(i2)) {
            this.c(a2.a);
            a2.a(j2, k.e(a2.a));
            this.c();
            b2 = this.c(i2);
        }
        if (!bl2) {
            this.d();
        }
        --this.d;
    }

    @Override
    public void b(i i2) {
        this.a.b(i2);
    }

    static class a {
        g.b a;
        f b;

        a(i i2, g.b b2) {
            this.b = m.a(i2);
            this.a = b2;
        }

        void a(j j2, g.a a2) {
            g.b b2 = k.b(a2);
            this.a = k.a(this.a, b2);
            this.b.a(j2, a2);
            this.a = b2;
        }
    }

}

