/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class b {
    public static final b a = new b("");
    private final c b;
    private transient b c;

    public b(String string2) {
        this.b = new c(string2, this);
    }

    public b(c c2) {
        this.b = c2;
    }

    private b(c c2, b b2) {
        this.b = c2;
        this.c = b2;
    }

    public static b c(f f2) {
        return new b(c.c(f2));
    }

    public String a() {
        return this.b.a();
    }

    public b a(f f2) {
        return new b(this.b.a(f2), this);
    }

    public c b() {
        return this.b;
    }

    public boolean b(f f2) {
        return this.b.b(f2);
    }

    public boolean c() {
        return this.b.d();
    }

    public b d() {
        if (this.c != null) {
            return this.c;
        }
        if (!this.c()) {
            this.c = new b(this.b.e());
            return this.c;
        }
        throw new IllegalStateException("root");
    }

    public f e() {
        return this.b.f();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return this.b.equals(((b)object).b);
    }

    public f f() {
        return this.b.g();
    }

    public List<f> g() {
        return this.b.h();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString();
    }
}

