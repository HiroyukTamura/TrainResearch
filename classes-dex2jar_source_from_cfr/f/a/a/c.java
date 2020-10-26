/*
 * Decompiled with CFR 0.139.
 */
package f.a.a;

import b.a.e;
import b.a.g;
import f.b;
import f.m;

final class c<T>
extends e<m<T>> {
    private final b<T> a;

    c(b<T> b2) {
        this.a = b2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void b(g<? super m<T>> g2) {
        a a2;
        boolean bl2;
        void var4_6;
        block8 : {
            boolean bl3;
            Object object = this.a.d();
            a2 = new a((b<?>)object);
            g2.a(a2);
            object = object.a();
            if (!a2.b()) {
                g2.a_((m<Object>)object);
            }
            if (bl3 = a2.b()) return;
            try {
                g2.b_();
                return;
            }
            catch (Throwable throwable) {
                bl2 = true;
            }
            break block8;
            catch (Throwable throwable) {
                bl2 = false;
            }
        }
        b.a.c.b.b((Throwable)var4_6);
        if (bl2) {
            b.a.f.a.a((Throwable)var4_6);
            return;
        }
        if (a2.b()) return;
        try {
            g2.a((Throwable)var4_6);
            return;
        }
        catch (Throwable throwable) {
            b.a.c.b.b(throwable);
            b.a.f.a.a(new b.a.c.a(new Throwable[]{var4_6, throwable}));
        }
    }

    private static final class a
    implements b.a.b.b {
        private final b<?> a;
        private volatile boolean b;

        a(b<?> b2) {
            this.a = b2;
        }

        @Override
        public void a() {
            this.b = true;
            this.a.b();
        }

        public boolean b() {
            return this.b;
        }
    }

}

