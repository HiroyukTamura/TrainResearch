/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.a;

import android.os.Handler;
import jp.a.a;
import jp.co.bug.sst.b;
import jp.co.bug.sst.e;
import jp.co.bug.sst.f;
import jp.co.bug.sst.j;

class c
extends jp.a.a
implements e.a {
    a.h a = a.h.a;
    a b = a.a;
    int c = -1;
    int d = -1;
    private Handler e = new Handler();
    private f f = new j();
    private e g;
    private boolean h = false;
    private a.g i = new b();
    private a.a j;

    private boolean c() {
        if (this.g == null) {
            this.g = this.f.a();
            this.g.a(this);
        }
        if (this.c == -1 && this.d == -1) {
            try {
                boolean bl2 = this.g.a(this.e, -1, -1);
                return bl2;
            }
            catch (b.b b2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load Audio Class. : ");
                stringBuilder.append(b2.getLocalizedMessage());
                throw new a.c(stringBuilder.toString(), b2);
            }
        }
        return this.g.a(this.e, this.c, this.d);
    }

    @Override
    public a.h a() {
        return this.a;
    }

    a.h a(a a2) {
        if (1.a[a2.ordinal()] != 1) {
            return a.h.a;
        }
        return a.h.c;
    }

    @Override
    public void a(a.g g2) {
        a.g g3 = g2;
        if (g2 == null) {
            g3 = new b();
        }
        this.i = g3;
    }

    @Override
    public void a(jp.co.bug.sst.a.b b2) {
        block4 : {
            int n2;
            a.f f2;
            block6 : {
                int n3;
                block5 : {
                    if (this.b != a.b) break block4;
                    if (this.j != a.a.b && b2.a() == 129) {
                        return;
                    }
                    n3 = b2.a();
                    f2 = this.c(n3);
                    n2 = b2.b();
                    if (this.j == a.a.b) break block5;
                    if (!this.a(n3)) break block4;
                    this.g.a();
                    this.g = null;
                    this.b(a.a);
                    break block6;
                }
                this.b(a.b);
                if (!this.b(n3)) break block4;
            }
            this.i.a(f2, n2, b2.a(0L), null);
        }
    }

    @Override
    public void a(e.c exception) {
        if (this.b == a.b) {
            exception = exception instanceof e.b ? new a.d(exception.getMessage(), exception) : new a.e(exception.getMessage(), exception);
            this.b(a.a);
            this.i.a((a.b)exception);
        }
    }

    protected boolean a(int n2) {
        return n2 == 128;
    }

    @Override
    public boolean a(a.a a2) {
        if (this.h) {
            return false;
        }
        this.j = a2;
        if (this.b == a.a) {
            if (this.c()) {
                this.b(a.b);
                return true;
            }
            this.b(a.a);
        }
        return false;
    }

    @Override
    public void b() {
        if (this.h) {
            return;
        }
        if (this.b == a.b) {
            if (this.g != null) {
                this.g.a();
                this.g.a(null);
                this.g = null;
            }
            this.b(a.a);
        }
    }

    void b(a a2) {
        a.h h2 = this.a;
        this.b = a2;
        this.a = this.a(a2);
        if (this.a != h2) {
            try {
                this.h = true;
                this.i.a(this.a);
                return;
            }
            finally {
                this.h = false;
            }
        }
    }

    protected boolean b(int n2) {
        switch (n2) {
            default: {
                return false;
            }
            case 128: 
            case 129: 
        }
        return true;
    }

    protected a.f c(int n2) {
        if (n2 != 0) {
            switch (n2) {
                default: {
                    switch (n2) {
                        default: {
                            return a.f.a;
                        }
                        case 129: {
                            return a.f.g;
                        }
                        case 128: 
                    }
                    return a.f.f;
                }
                case 5: {
                    return a.f.e;
                }
                case 4: {
                    return a.f.d;
                }
                case 3: 
            }
            return a.f.c;
        }
        return a.f.b;
    }

    static enum a {
        a,
        b;
        
    }

    private static class b
    implements a.g {
        private b() {
        }

        @Override
        public void a(a.b b2) {
        }

        @Override
        public void a(a.f f2, int n2, String string2, String string3) {
        }

        @Override
        public void a(a.h h2) {
        }
    }

}

