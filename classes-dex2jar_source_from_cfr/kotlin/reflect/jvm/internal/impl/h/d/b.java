/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.d;

import kotlin.reflect.jvm.internal.impl.e.a;

public class b {
    private final String a;
    private kotlin.reflect.jvm.internal.impl.e.b b;

    private b(String string2) {
        this.a = string2;
    }

    public static b a(String string2) {
        return new b(string2);
    }

    public static b a(a object) {
        kotlin.reflect.jvm.internal.impl.e.b b2 = ((a)object).a();
        object = ((a)object).b().a().replace('.', '$');
        if (b2.c()) {
            return new b((String)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b2.a().replace('.', '/'));
        stringBuilder.append("/");
        stringBuilder.append((String)object);
        return new b(stringBuilder.toString());
    }

    public static b a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        b b3 = new b(b2.a().replace('.', '/'));
        b3.b = b2;
        return b3;
    }

    public kotlin.reflect.jvm.internal.impl.e.b a() {
        return new kotlin.reflect.jvm.internal.impl.e.b(this.a.replace('/', '.'));
    }

    public kotlin.reflect.jvm.internal.impl.e.b b() {
        int n2 = this.a.lastIndexOf("/");
        if (n2 == -1) {
            return kotlin.reflect.jvm.internal.impl.e.b.a;
        }
        return new kotlin.reflect.jvm.internal.impl.e.b(this.a.substring(0, n2).replace('/', '.'));
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            return this.a.equals(((b)object).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}

