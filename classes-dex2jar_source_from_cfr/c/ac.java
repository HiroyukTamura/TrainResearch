/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.aa;
import c.ad;
import c.d;
import c.r;
import c.s;
import c.t;
import c.y;
import java.io.Closeable;
import javax.annotation.Nullable;

public final class ac
implements Closeable {
    final aa a;
    final y b;
    final int c;
    final String d;
    @Nullable
    final r e;
    final s f;
    @Nullable
    final ad g;
    @Nullable
    final ac h;
    @Nullable
    final ac i;
    @Nullable
    final ac j;
    final long k;
    final long l;
    private volatile d m;

    ac(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        this.f = a2.f.a();
        this.g = a2.g;
        this.h = a2.h;
        this.i = a2.i;
        this.j = a2.j;
        this.k = a2.k;
        this.l = a2.l;
    }

    public aa a() {
        return this.a;
    }

    @Nullable
    public String a(String string2) {
        return this.a(string2, null);
    }

    @Nullable
    public String a(String string2, @Nullable String string3) {
        if ((string2 = this.f.a(string2)) != null) {
            return string2;
        }
        return string3;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.c >= 200 && this.c < 300;
    }

    @Override
    public void close() {
        if (this.g != null) {
            this.g.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String d() {
        return this.d;
    }

    public r e() {
        return this.e;
    }

    public s f() {
        return this.f;
    }

    @Nullable
    public ad g() {
        return this.g;
    }

    public a h() {
        return new a(this);
    }

    @Nullable
    public ac i() {
        return this.j;
    }

    public d j() {
        d d2 = this.m;
        if (d2 != null) {
            return d2;
        }
        this.m = d2 = d.a(this.f);
        return d2;
    }

    public long k() {
        return this.k;
    }

    public long l() {
        return this.l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", code=");
        stringBuilder.append(this.c);
        stringBuilder.append(", message=");
        stringBuilder.append(this.d);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a.a());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        aa a;
        y b;
        int c = -1;
        String d;
        @Nullable
        r e;
        s.a f;
        ad g;
        ac h;
        ac i;
        ac j;
        long k;
        long l;

        public a() {
            this.f = new s.a();
        }

        a(ac ac2) {
            this.a = ac2.a;
            this.b = ac2.b;
            this.c = ac2.c;
            this.d = ac2.d;
            this.e = ac2.e;
            this.f = ac2.f.b();
            this.g = ac2.g;
            this.h = ac2.h;
            this.i = ac2.i;
            this.j = ac2.j;
            this.k = ac2.k;
            this.l = ac2.l;
        }

        private void a(String string2, ac object) {
            if (((ac)object).g == null) {
                if (((ac)object).h == null) {
                    if (((ac)object).i == null) {
                        if (((ac)object).j == null) {
                            return;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(".priorResponse != null");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(".cacheResponse != null");
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(".networkResponse != null");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(".body != null");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        private void d(ac ac2) {
            if (ac2.g == null) {
                return;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public a a(int n2) {
            this.c = n2;
            return this;
        }

        public a a(long l2) {
            this.k = l2;
            return this;
        }

        public a a(aa aa2) {
            this.a = aa2;
            return this;
        }

        public a a(@Nullable ac ac2) {
            if (ac2 != null) {
                this.a("networkResponse", ac2);
            }
            this.h = ac2;
            return this;
        }

        public a a(@Nullable ad ad2) {
            this.g = ad2;
            return this;
        }

        public a a(@Nullable r r2) {
            this.e = r2;
            return this;
        }

        public a a(s s2) {
            this.f = s2.b();
            return this;
        }

        public a a(y y2) {
            this.b = y2;
            return this;
        }

        public a a(String string2) {
            this.d = string2;
            return this;
        }

        public a a(String string2, String string3) {
            this.f.a(string2, string3);
            return this;
        }

        public ac a() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.d != null) {
                            return new ac(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("code < 0: ");
                    stringBuilder.append(this.c);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public a b(long l2) {
            this.l = l2;
            return this;
        }

        public a b(@Nullable ac ac2) {
            if (ac2 != null) {
                this.a("cacheResponse", ac2);
            }
            this.i = ac2;
            return this;
        }

        public a c(@Nullable ac ac2) {
            if (ac2 != null) {
                this.d(ac2);
            }
            this.j = ac2;
            return this;
        }
    }

}

