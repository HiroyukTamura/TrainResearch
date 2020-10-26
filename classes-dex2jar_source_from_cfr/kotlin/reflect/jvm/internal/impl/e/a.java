/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class a {
    static final /* synthetic */ boolean a;
    private final b b;
    private final b c;
    private final boolean d;

    static {
        a = a.class.desiredAssertionStatus() ^ true;
    }

    public a(b object, b object2, boolean bl2) {
        this.b = object;
        if (!a && ((b)object2).c()) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Class name must not be root: ");
            ((StringBuilder)object2).append(object);
            object = bl2 ? " (local)" : "";
            ((StringBuilder)object2).append((String)object);
            throw new AssertionError((Object)((StringBuilder)object2).toString());
        }
        this.c = object2;
        this.d = bl2;
    }

    public a(b b2, f f2) {
        this(b2, b.c(f2), false);
    }

    public static a a(String string2) {
        return a.a(string2, false);
    }

    public static a a(String string2, boolean bl2) {
        String string3 = n.c(string2, '/', "").replace('/', '.');
        string2 = n.d(string2, '/', string2);
        return new a(new b(string3), new b(string2), bl2);
    }

    public static a a(b b2) {
        return new a(b2.d(), b2.e());
    }

    public a a(f f2) {
        return new a(this.a(), this.c.a(f2), this.d);
    }

    public b a() {
        return this.b;
    }

    public b b() {
        return this.c;
    }

    public f c() {
        return this.c.e();
    }

    public boolean d() {
        return this.d;
    }

    public a e() {
        b b2 = this.c.d();
        if (b2.c()) {
            return null;
        }
        return new a(this.a(), b2, this.d);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (a)object;
            return this.b.equals(((a)object).b) && this.c.equals(((a)object).c) && this.d == ((a)object).d;
        }
        return false;
    }

    public boolean f() {
        return this.c.d().c() ^ true;
    }

    public b g() {
        if (this.b.c()) {
            return this.c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.a());
        stringBuilder.append(".");
        stringBuilder.append(this.c.a());
        return new b(stringBuilder.toString());
    }

    public String h() {
        if (this.b.c()) {
            return this.c.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.a().replace('.', '/'));
        stringBuilder.append("/");
        stringBuilder.append(this.c.a());
        return stringBuilder.toString();
    }

    public int hashCode() {
        return (this.b.hashCode() * 31 + this.c.hashCode()) * 31 + Boolean.valueOf(this.d).hashCode();
    }

    public String toString() {
        if (this.b.c()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/");
            stringBuilder.append(this.h());
            return stringBuilder.toString();
        }
        return this.h();
    }
}

