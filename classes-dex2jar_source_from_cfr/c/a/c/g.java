/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.a.c.c;
import c.aa;
import c.ac;
import c.ad;
import c.e;
import c.i;
import c.p;
import c.t;
import c.u;
import java.util.List;

public final class g
implements u.a {
    private final List<u> a;
    private final c.a.b.g b;
    private final c c;
    private final c.a.b.c d;
    private final int e;
    private final aa f;
    private final e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<u> list, c.a.b.g g2, c c2, c.a.b.c c3, int n2, aa aa2, e e2, p p2, int n3, int n4, int n5) {
        this.a = list;
        this.d = c3;
        this.b = g2;
        this.c = c2;
        this.e = n2;
        this.f = aa2;
        this.g = e2;
        this.h = p2;
        this.i = n3;
        this.j = n4;
        this.k = n5;
    }

    @Override
    public aa a() {
        return this.f;
    }

    @Override
    public ac a(aa aa2) {
        return this.a(aa2, this.b, this.c, this.d);
    }

    public ac a(aa object, c.a.b.g object2, c c2, c.a.b.c object3) {
        if (this.e < this.a.size()) {
            ++this.l;
            if (this.c != null && !this.d.a(((aa)object).a())) {
                object = new StringBuilder();
                ((StringBuilder)object).append("network interceptor ");
                ((StringBuilder)object).append(this.a.get(this.e - 1));
                ((StringBuilder)object).append(" must retain the same host and port");
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            if (this.c != null && this.l > 1) {
                object = new StringBuilder();
                ((StringBuilder)object).append("network interceptor ");
                ((StringBuilder)object).append(this.a.get(this.e - 1));
                ((StringBuilder)object).append(" must call proceed() exactly once");
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            object2 = new g(this.a, (c.a.b.g)object2, c2, (c.a.b.c)object3, this.e + 1, (aa)object, this.g, this.h, this.i, this.j, this.k);
            object = this.a.get(this.e);
            object3 = object.a((u.a)object2);
            if (c2 != null && this.e + 1 < this.a.size() && ((g)object2).l != 1) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("network interceptor ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" must call proceed() exactly once");
                throw new IllegalStateException(((StringBuilder)object2).toString());
            }
            if (object3 != null) {
                if (((ac)object3).g() != null) {
                    return object3;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("interceptor ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" returned a response with no body");
                throw new IllegalStateException(((StringBuilder)object2).toString());
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("interceptor ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" returned null");
            throw new NullPointerException(((StringBuilder)object2).toString());
        }
        throw new AssertionError();
    }

    @Override
    public int b() {
        return this.i;
    }

    @Override
    public int c() {
        return this.j;
    }

    @Override
    public int d() {
        return this.k;
    }

    public i e() {
        return this.d;
    }

    public c.a.b.g f() {
        return this.b;
    }

    public c g() {
        return this.c;
    }

    public e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }
}

