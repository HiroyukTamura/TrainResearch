/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.h.e.c;
import kotlin.t;

public final class d {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final a k;
    private static int n;
    private static final int o;
    private static final int p;
    private static final int q;
    private static final int r;
    private static final int s;
    private static final int t;
    private static final int u;
    private static final int v;
    private static final int w;
    private static final int x;
    private static final List<a.a> y;
    private static final List<a.a> z;
    private final int l;
    private final List<c> m;

    static {
        int n2;
        Iterator iterator2;
        k = new a(null);
        n = 1;
        o = d.k.i();
        p = d.k.i();
        q = d.k.i();
        r = d.k.i();
        s = d.k.i();
        t = d.k.i();
        u = d.k.i() - 1;
        v = o | p | q;
        w = p | s | t;
        x = s | t;
        a = new d(u, null, 2, null);
        b = new d(x, null, 2, null);
        c = new d(o, null, 2, null);
        d = new d(p, null, 2, null);
        e = new d(q, null, 2, null);
        f = new d(v, null, 2, null);
        g = new d(r, null, 2, null);
        h = new d(s, null, 2, null);
        i = new d(t, null, 2, null);
        j = new d(w, null, 2, null);
        Object object = k;
        object = d.class.getFields();
        j.a(object, "T::class.java.fields");
        Object object2 = new ArrayList();
        for (Iterator iterator2 : object) {
            j.a((Object)iterator2, "it");
            if (!Modifier.isStatic(((Field)((Object)iterator2)).getModifiers())) continue;
            object2.add(iterator2);
        }
        object = (List)object2;
        iterator2 = new ArrayList();
        Object object3 = object.iterator();
        while (object3.hasNext()) {
            Field field = (Field)object3.next();
            object = object2 = field.get(null);
            if (!(object2 instanceof d)) {
                object = null;
            }
            if ((object = (d)object) != null) {
                n2 = ((d)object).l;
                j.a((Object)field, "field");
                object = field.getName();
                j.a(object, "field.name");
                object = new a.a(n2, (String)object);
            } else {
                object = null;
            }
            if (object == null) continue;
            iterator2.add(object);
        }
        y = m.k((List)((Object)iterator2));
        object = k;
        object = d.class.getFields();
        j.a(object, "T::class.java.fields");
        object2 = new ArrayList();
        for (Iterator iterator2 : object) {
            j.a((Object)iterator2, "it");
            if (!Modifier.isStatic(((Field)((Object)iterator2)).getModifiers())) continue;
            object2.add((Object)iterator2);
        }
        object2 = (List)object2;
        object = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            iterator2 = object2.next();
            object3 = (Field)((Object)iterator2);
            j.a(object3, "it");
            if (!j.a(((Field)object3).getType(), Integer.TYPE)) continue;
            object.add(iterator2);
        }
        object = (List)object;
        object2 = new ArrayList();
        iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = (Field)iterator2.next();
            object3 = ((Field)object).get(null);
            if (object3 != null) {
                int n3 = (Integer)object3;
                n2 = n3 == (-n3 & n3) ? 1 : 0;
                if (n2 != 0) {
                    j.a(object, "field");
                    object = ((Field)object).getName();
                    j.a(object, "field.name");
                    object = new a.a(n3, (String)object);
                } else {
                    object = null;
                }
                if (object == null) continue;
                object2.add(object);
                continue;
            }
            throw new t("null cannot be cast to non-null type kotlin.Int");
        }
        z = m.k((List)object2);
    }

    public d(int n2, List<? extends c> object) {
        j.b(object, "excludes");
        this.m = object;
        object = ((Iterable)this.m).iterator();
        while (object.hasNext()) {
            n2 &= ((c)object.next()).a();
        }
        this.l = n2;
    }

    public /* synthetic */ d(int n2, List list, int n3, g g2) {
        if ((n3 & 2) != 0) {
            list = m.a();
        }
        this(n2, list);
    }

    public static final /* synthetic */ void c(int n2) {
        n = n2;
    }

    public final int a() {
        return this.l;
    }

    public final boolean a(int n2) {
        return (n2 & this.l) != 0;
    }

    public final List<c> b() {
        return this.m;
    }

    public final d b(int n2) {
        if ((n2 &= this.l) == 0) {
            return null;
        }
        return new d(n2, this.m);
    }

    public String toString() {
        Object object;
        Object object22;
        block3 : {
            for (Object object22 : (Iterable)y) {
                boolean bl2 = ((a.a)object22).a() == this.l;
                if (!bl2) continue;
                break block3;
            }
            object22 = null;
        }
        object22 = (a.a)object22;
        object22 = object22 != null ? ((a.a)object22).b() : null;
        if (object22 == null) {
            object22 = z;
            object = new ArrayList();
            Iterator iterator = object22.iterator();
            while (iterator.hasNext()) {
                object22 = (a.a)iterator.next();
                object22 = this.a(((a.a)object22).a()) ? ((a.a)object22).b() : null;
                if (object22 == null) continue;
                object.add(object22);
            }
            object22 = m.a((List)object, " | ", null, null, 0, null, null, 62, null);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("DescriptorKindFilter(");
        ((StringBuilder)object).append((String)object22);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(this.m);
        ((StringBuilder)object).append(')');
        return ((StringBuilder)object).toString();
    }

    public static final class kotlin.reflect.jvm.internal.impl.h.e.d$a {
        private kotlin.reflect.jvm.internal.impl.h.e.d$a() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.d$a(g g2) {
            this();
        }

        private final int i() {
            int n2 = n;
            d.c(n << 1);
            return n2;
        }

        public final int a() {
            return o;
        }

        public final int b() {
            return p;
        }

        public final int c() {
            return q;
        }

        public final int d() {
            return r;
        }

        public final int e() {
            return s;
        }

        public final int f() {
            return t;
        }

        public final int g() {
            return u;
        }

        public final int h() {
            return v;
        }

        private static final class a {
            private final int a;
            private final String b;

            public a(int n2, String string2) {
                j.b(string2, "name");
                this.a = n2;
                this.b = string2;
            }

            public final int a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }
        }

    }

}

