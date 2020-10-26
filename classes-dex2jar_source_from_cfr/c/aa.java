/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c.f;
import c.ab;
import c.d;
import c.s;
import c.t;
import javax.annotation.Nullable;

public final class aa {
    final t a;
    final String b;
    final s c;
    @Nullable
    final ab d;
    final Object e;
    private volatile d f;

    aa(a object) {
        this.a = ((a)object).a;
        this.b = ((a)object).b;
        this.c = ((a)object).c.a();
        this.d = ((a)object).d;
        object = ((a)object).e != null ? ((a)object).e : this;
        this.e = object;
    }

    public t a() {
        return this.a;
    }

    @Nullable
    public String a(String string2) {
        return this.c.a(string2);
    }

    public String b() {
        return this.b;
    }

    public s c() {
        return this.c;
    }

    @Nullable
    public ab d() {
        return this.d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d d2 = this.f;
        if (d2 != null) {
            return d2;
        }
        this.f = d2 = d.a(this.c);
        return d2;
    }

    public boolean g() {
        return this.a.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tag=");
        Object object = this.e != this ? this.e : null;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        t a;
        String b;
        s.a c;
        ab d;
        Object e;

        public a() {
            this.b = "GET";
            this.c = new s.a();
        }

        a(aa aa2) {
            this.a = aa2.a;
            this.b = aa2.b;
            this.d = aa2.d;
            this.e = aa2.e;
            this.c = aa2.c.b();
        }

        public a a(s s2) {
            this.c = s2.b();
            return this;
        }

        public a a(t t2) {
            if (t2 != null) {
                this.a = t2;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a a(String string2) {
            this.c.b(string2);
            return this;
        }

        public a a(String string2, @Nullable ab object) {
            if (string2 != null) {
                if (string2.length() != 0) {
                    if (object != null && !f.c(string2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("method ");
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(" must not have a request body.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    if (object == null && f.b(string2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("method ");
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(" must have a request body.");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    this.b = string2;
                    this.d = object;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a a(String string2, String string3) {
            this.c.c(string2, string3);
            return this;
        }

        public aa a() {
            if (this.a != null) {
                return new aa(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(String string2, String string3) {
            this.c.a(string2, string3);
            return this;
        }
    }

}

