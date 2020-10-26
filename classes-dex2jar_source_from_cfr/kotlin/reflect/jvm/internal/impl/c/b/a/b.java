/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.d.c.a.d;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.e.f;

public class b
implements n.c {
    private static final boolean a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<kotlin.reflect.jvm.internal.impl.e.a, a.a> b = new HashMap<kotlin.reflect.jvm.internal.impl.e.a, a.a>();
    private g c = null;
    private d d = null;
    private String e = null;
    private int f = 0;
    private String g = null;
    private String[] h = null;
    private String[] i = null;
    private String[] j = null;
    private a.a k = null;

    static {
        b.put(kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.internal.KotlinClass")), a.a.b);
        b.put(kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.internal.KotlinFileFacade")), a.a.c);
        b.put(kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.internal.KotlinMultifileClass")), a.a.e);
        b.put(kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.a.f);
        b.put(kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.a.d);
    }

    private boolean c() {
        return this.k == a.a.b || this.k == a.a.c || this.k == a.a.f;
        {
        }
    }

    @Override
    public n.a a(kotlin.reflect.jvm.internal.impl.e.a object, an an2) {
        if (object.g().equals(o.a)) {
            return new b();
        }
        if (a) {
            return null;
        }
        if (this.k != null) {
            return null;
        }
        if ((object = b.get(object)) != null) {
            this.k = object;
            return new c();
        }
        return null;
    }

    @Override
    public void a() {
    }

    public kotlin.reflect.jvm.internal.impl.c.b.a.a b() {
        d d2;
        a.a a2;
        g g2;
        if (this.k == null) {
            return null;
        }
        if (!this.c.a()) {
            this.j = this.h;
        }
        if (this.c != null && this.c.a()) {
            if (this.c() && this.h == null) {
                return null;
            }
        } else {
            this.h = null;
        }
        a2 = this.k;
        g2 = this.c != null ? this.c : g.b;
        d2 = this.d != null ? this.d : d.b;
        return new kotlin.reflect.jvm.internal.impl.c.b.a.a(a2, g2, d2, this.h, this.j, this.i, this.e, this.f, this.g);
    }

    private static abstract class a
    implements n.b {
        private final List<String> a = new ArrayList<String>();

        @Override
        public void a() {
            this.a(this.a.toArray(new String[this.a.size()]));
        }

        @Override
        public void a(Object object) {
            if (object instanceof String) {
                this.a.add((String)object);
            }
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.e.a a2, f f2) {
        }

        protected abstract void a(String[] var1);
    }

    private class b
    implements n.a {
        private b() {
        }

        private n.b b() {
            return new a(){

                @Override
                protected void a(String[] arrstring) {
                    b.this.h = arrstring;
                }
            };
        }

        private n.b c() {
            return new a(){

                @Override
                protected void a(String[] arrstring) {
                    b.this.i = arrstring;
                }
            };
        }

        @Override
        public n.a a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2) {
            return null;
        }

        @Override
        public n.b a(f object) {
            if ("d1".equals(object = ((f)object).a())) {
                return this.b();
            }
            if ("d2".equals(object)) {
                return this.c();
            }
            return null;
        }

        @Override
        public void a() {
        }

        @Override
        public void a(f object, Object object2) {
            if (object == null) {
                return;
            }
            if ("k".equals(object = ((f)object).a())) {
                if (object2 instanceof Integer) {
                    b.this.k = a.a.a((Integer)object2);
                    return;
                }
            } else if ("mv".equals(object)) {
                if (object2 instanceof int[]) {
                    b.this.c = new g((int[])object2);
                    return;
                }
            } else if ("bv".equals(object)) {
                if (object2 instanceof int[]) {
                    b.this.d = new d((int[])object2);
                    return;
                }
            } else if ("xs".equals(object)) {
                if (object2 instanceof String) {
                    b.this.e = (String)object2;
                    return;
                }
            } else if ("xi".equals(object)) {
                if (object2 instanceof Integer) {
                    b.this.f = (Integer)object2;
                    return;
                }
            } else if ("pn".equals(object) && object2 instanceof String) {
                b.this.g = (String)object2;
            }
        }

        @Override
        public void a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2, f f3) {
        }

    }

    private class c
    implements n.a {
        private c() {
        }

        private n.b b() {
            return new a(){

                @Override
                protected void a(String[] arrstring) {
                    b.this.h = arrstring;
                }
            };
        }

        private n.b c() {
            return new a(){

                @Override
                protected void a(String[] arrstring) {
                    b.this.i = arrstring;
                }
            };
        }

        @Override
        public n.a a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2) {
            return null;
        }

        @Override
        public n.b a(f object) {
            if (!"data".equals(object = ((f)object).a()) && !"filePartClassNames".equals(object)) {
                if ("strings".equals(object)) {
                    return this.c();
                }
                return null;
            }
            return this.b();
        }

        @Override
        public void a() {
        }

        @Override
        public void a(f object, Object arrn) {
            if (object == null) {
                return;
            }
            if ("version".equals(object = ((f)object).a())) {
                if (arrn instanceof int[]) {
                    object = b.this;
                    arrn = arrn;
                    ((b)object).c = new g(arrn);
                    if (b.this.d == null) {
                        b.this.d = new d(arrn);
                        return;
                    }
                }
            } else if ("multifileClassName".equals(object)) {
                b b2 = b.this;
                object = arrn instanceof String ? (String)arrn : null;
                b2.e = (String)object;
            }
        }

        @Override
        public void a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2, f f3) {
        }

    }

}

