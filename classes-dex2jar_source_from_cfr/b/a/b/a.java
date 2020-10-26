/*
 * Decompiled with CFR 0.139.
 */
package b.a.b;

import b.a.b.b;
import java.util.ArrayList;

public final class a
implements b,
b.a.e.a.a {
    b.a.e.h.b<b> a;
    volatile boolean b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        b.a.e.h.b<b> b2;
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            b2 = this.a;
            this.a = null;
        }
        this.a(b2);
    }

    void a(b.a.e.h.b<b> b2) {
        if (b2 == null) {
            return;
        }
        Object[] arrobject = b2.b();
        int n2 = arrobject.length;
        b2 = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            Object object2 = b2;
            if (object instanceof b) {
                try {
                    ((b)object).a();
                    object2 = b2;
                }
                catch (Throwable throwable) {
                    b.a.c.b.b(throwable);
                    object2 = b2;
                    if (b2 == null) {
                        object2 = new ArrayList();
                    }
                    object2.add((Throwable)throwable);
                }
            }
            b2 = object2;
        }
        if (b2 != null) {
            if (b2.size() == 1) {
                throw b.a.e.h.a.a((Throwable)b2.get(0));
            }
            throw new b.a.c.a((Iterable<? extends Throwable>)((Object)b2));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(b b2) {
        b.a.e.b.b.a(b2, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    b.a.e.h.b<b> b3;
                    b.a.e.h.b<b> b4 = b3 = this.a;
                    if (b3 == null) {
                        this.a = b4 = new b.a.e.h.b();
                    }
                    b4.a(b2);
                    return true;
                }
            }
        }
        b2.a();
        return false;
    }

    public boolean b() {
        return this.b;
    }

    @Override
    public boolean b(b b2) {
        if (this.c(b2)) {
            b2.a();
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        b.a.e.h.b<b> b2;
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            b2 = this.a;
            this.a = null;
        }
        this.a(b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean c(b b2) {
        b.a.e.b.b.a(b2, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            b.a.e.h.b<b> b3 = this.a;
            return b3 != null && b3.b(b2);
            {
            }
        }
    }
}

