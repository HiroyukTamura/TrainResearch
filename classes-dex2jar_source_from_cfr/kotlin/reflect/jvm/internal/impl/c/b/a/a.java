/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b.a;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.c.a.d;

public final class a {
    private final a a;
    private final kotlin.reflect.jvm.internal.impl.d.c.a.g b;
    private final d c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String g;
    private final int h;
    private final String i;

    public a(a a2, kotlin.reflect.jvm.internal.impl.d.c.a.g g2, d d2, String[] arrstring, String[] arrstring2, String[] arrstring3, String string2, int n2, String string3) {
        j.b((Object)a2, "kind");
        j.b(g2, "metadataVersion");
        j.b(d2, "bytecodeVersion");
        this.a = a2;
        this.b = g2;
        this.c = d2;
        this.d = arrstring;
        this.e = arrstring2;
        this.f = arrstring3;
        this.g = string2;
        this.h = n2;
        this.i = string3;
    }

    public final String a() {
        String string2 = this.g;
        boolean bl2 = this.a == a.f;
        if (bl2) {
            return string2;
        }
        return null;
    }

    public final List<String> b() {
        String[] arrstring = this.d;
        boolean bl2 = this.a == a.e;
        List<String> list = null;
        if (!bl2) {
            arrstring = null;
        }
        if (arrstring != null) {
            list = g.a(arrstring);
        }
        if (list != null) {
            return list;
        }
        return m.a();
    }

    public final boolean c() {
        return (this.h & 2) != 0;
    }

    public final a d() {
        return this.a;
    }

    public final kotlin.reflect.jvm.internal.impl.d.c.a.g e() {
        return this.b;
    }

    public final String[] f() {
        return this.d;
    }

    public final String[] g() {
        return this.e;
    }

    public final String[] h() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.a);
        stringBuilder.append(" version=");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }

    public static final class kotlin.reflect.jvm.internal.impl.c.b.a.a$a
    extends Enum<kotlin.reflect.jvm.internal.impl.c.b.a.a$a> {
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a a;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a b;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a c;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a d;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a e;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a f;
        public static final a g;
        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.c.b.a.a$a[] h;
        private static final Map<Integer, kotlin.reflect.jvm.internal.impl.c.b.a.a$a> j;
        private final int i;

        static {
            kotlin.reflect.jvm.internal.impl.c.b.a.a$a a2;
            kotlin.reflect.jvm.internal.impl.c.b.a.a$a a3;
            kotlin.reflect.jvm.internal.impl.c.b.a.a$a a42;
            kotlin.reflect.jvm.internal.impl.c.b.a.a$a a5;
            kotlin.reflect.jvm.internal.impl.c.b.a.a$a[] arra = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a[](0);
            a = arra;
            Object object = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a(1);
            b = object;
            c = a42 = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a(2);
            d = a2 = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a(3);
            e = a5 = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a(4);
            f = a3 = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a(5);
            h = new kotlin.reflect.jvm.internal.impl.c.b.a.a$a[]{arra, object, a42, a2, a5, a3};
            g = new a(null);
            arra = kotlin.reflect.jvm.internal.impl.c.b.a.a$a.values();
            object = new LinkedHashMap(kotlin.g.d.c(af.a(arra.length), 16));
            for (kotlin.reflect.jvm.internal.impl.c.b.a.a$a a42 : arra) {
                object.put(a42.i, a42);
            }
            j = object;
        }

        protected kotlin.reflect.jvm.internal.impl.c.b.a.a$a(int n3) {
            this.i = n3;
        }

        public static final kotlin.reflect.jvm.internal.impl.c.b.a.a$a a(int n2) {
            return g.a(n2);
        }

        public static kotlin.reflect.jvm.internal.impl.c.b.a.a$a valueOf(String string2) {
            return Enum.valueOf(kotlin.reflect.jvm.internal.impl.c.b.a.a$a.class, string2);
        }

        public static kotlin.reflect.jvm.internal.impl.c.b.a.a$a[] values() {
            return (kotlin.reflect.jvm.internal.impl.c.b.a.a$a[])h.clone();
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.e.b.g g2) {
                this();
            }

            public final kotlin.reflect.jvm.internal.impl.c.b.a.a$a a(int n2) {
                kotlin.reflect.jvm.internal.impl.c.b.a.a$a a2 = (kotlin.reflect.jvm.internal.impl.c.b.a.a$a)((Object)j.get(n2));
                if (a2 != null) {
                    return a2;
                }
                return kotlin.reflect.jvm.internal.impl.c.b.a.a$a.a;
            }
        }

    }

}

