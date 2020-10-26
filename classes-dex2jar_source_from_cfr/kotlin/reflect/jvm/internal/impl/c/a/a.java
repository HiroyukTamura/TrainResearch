/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.c.a.c.k;
import kotlin.reflect.jvm.internal.impl.c.a.f.h;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.i.d;

public final class a {
    private final d<kotlin.reflect.jvm.internal.impl.a.e, kotlin.reflect.jvm.internal.impl.a.a.c> a;
    private final boolean b;
    private final kotlin.reflect.jvm.internal.impl.l.e c;

    public a(kotlin.reflect.jvm.internal.impl.i.i i2, kotlin.reflect.jvm.internal.impl.l.e e2) {
        j.b(i2, "storageManager");
        j.b(e2, "jsr305State");
        this.c = e2;
        this.a = i2.b((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.e, kotlin.reflect.jvm.internal.impl.a.a.c>(this){

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.a.c a(kotlin.reflect.jvm.internal.impl.a.e e2) {
                j.b(e2, "p1");
                return ((a)this.a).a(e2);
            }

            @Override
            public final e f() {
                return v.a(a.class);
            }

            @Override
            public final String g() {
                return "computeTypeQualifierNickname";
            }

            @Override
            public final String h() {
                return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
            }
        });
        this.b = this.c.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final List<a> a(kotlin.reflect.jvm.internal.impl.h.b.f<?> object) {
        void var1_9;
        if (object instanceof kotlin.reflect.jvm.internal.impl.h.b.b) {
            Object object2 = (Iterable)((kotlin.reflect.jvm.internal.impl.h.b.b)object).a();
            Collection collection = new ArrayList();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                m.a(collection, (Iterable)this.a((kotlin.reflect.jvm.internal.impl.h.b.f)object2.next()));
            }
            return (List)collection;
        }
        if (!(object instanceof i)) return m.a();
        String string2 = ((i)object).b().b();
        int n2 = string2.hashCode();
        if (n2 != -2024225567) {
            if (n2 != 66889946) {
                if (n2 != 107598562) {
                    if (n2 == 446088073 && string2.equals("PARAMETER")) {
                        a a2 = a.b;
                        return m.b(var1_9);
                    }
                } else if (string2.equals("TYPE_USE")) {
                    a a3 = a.d;
                    return m.b(var1_9);
                }
            } else if (string2.equals("FIELD")) {
                a a4 = a.c;
                return m.b(var1_9);
            }
        } else if (string2.equals("METHOD")) {
            a a5 = a.a;
            return m.b(var1_9);
        }
        Object var1_8 = null;
        return m.b(var1_9);
    }

    private final kotlin.reflect.jvm.internal.impl.a.a.c a(kotlin.reflect.jvm.internal.impl.a.e object) {
        if (!object.x().b(kotlin.reflect.jvm.internal.impl.c.a.b.a())) {
            return null;
        }
        for (kotlin.reflect.jvm.internal.impl.a.a.c c2 : (Iterable)object.x()) {
            if ((c2 = this.a(c2)) == null) continue;
            return c2;
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.a.a.c b(kotlin.reflect.jvm.internal.impl.a.e e2) {
        if (e2.l() != kotlin.reflect.jvm.internal.impl.a.f.e) {
            return null;
        }
        return (kotlin.reflect.jvm.internal.impl.a.a.c)this.a.a(e2);
    }

    private final kotlin.reflect.jvm.internal.impl.l.h c(kotlin.reflect.jvm.internal.impl.a.e object) {
        object = object.x().a(kotlin.reflect.jvm.internal.impl.c.a.b.d());
        Object var4_2 = null;
        object = object != null ? kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.a.c)object) : null;
        Object object2 = object;
        if (!(object instanceof i)) {
            object2 = null;
        }
        object2 = (i)object2;
        object = var4_2;
        if (object2 != null) {
            object = this.c.c();
            if (object != null) {
                return object;
            }
            int n2 = ((String)(object2 = ((i)object2).b().a())).hashCode();
            if (n2 != -2137067054) {
                if (n2 != -1838656823) {
                    if (n2 != 2656902) {
                        return null;
                    }
                    object = var4_2;
                    if (((String)object2).equals("WARN")) {
                        return kotlin.reflect.jvm.internal.impl.l.h.b;
                    }
                } else {
                    object = var4_2;
                    if (((String)object2).equals("STRICT")) {
                        return kotlin.reflect.jvm.internal.impl.l.h.c;
                    }
                }
            } else {
                object = var4_2;
                if (((String)object2).equals("IGNORE")) {
                    object = kotlin.reflect.jvm.internal.impl.l.h.a;
                }
            }
        }
        return object;
    }

    public final kotlin.reflect.jvm.internal.impl.a.a.c a(kotlin.reflect.jvm.internal.impl.a.a.c c2) {
        j.b(c2, "annotationDescriptor");
        if (this.c.a()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.a.e e2 = kotlin.reflect.jvm.internal.impl.h.c.a.a(c2);
        if (e2 != null) {
            if (kotlin.reflect.jvm.internal.impl.c.a.b.a(e2)) {
                return c2;
            }
            return this.b(e2);
        }
        return null;
    }

    public final boolean a() {
        return this.b;
    }

    public final k b(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        j.b(object, "annotationDescriptor");
        if (this.c.a()) {
            return null;
        }
        Object object2 = (k)kotlin.reflect.jvm.internal.impl.c.a.b.b().get(object.b());
        if (object2 != null) {
            h h2 = ((k)object2).a();
            object2 = ((k)object2).b();
            boolean bl2 = (object = this.d((kotlin.reflect.jvm.internal.impl.a.a.c)object)) != kotlin.reflect.jvm.internal.impl.l.h.a;
            if (!bl2) {
                object = null;
            }
            if (object != null) {
                return new k(h.a(h2, null, ((kotlin.reflect.jvm.internal.impl.l.h)((Object)object)).a(), 1, null), (Collection<? extends a>)object2);
            }
            return null;
        }
        return null;
    }

    public final b c(kotlin.reflect.jvm.internal.impl.a.a.c list22) {
        j.b(list22, "annotationDescriptor");
        if (this.c.a()) {
            return null;
        }
        Object object = kotlin.reflect.jvm.internal.impl.h.c.a.a(list22);
        if (object != null) {
            if (!object.x().b(kotlin.reflect.jvm.internal.impl.c.a.b.c())) {
                object = null;
            }
            if (object != null) {
                int n2;
                block10 : {
                    if ((list22 = kotlin.reflect.jvm.internal.impl.h.c.a.a(list22)) == null) {
                        j.a();
                    }
                    if ((list22 = list22.x().a(kotlin.reflect.jvm.internal.impl.c.a.b.c())) == null) {
                        j.a();
                    }
                    list22 = list22.c();
                    Collection collection = new ArrayList();
                    for (Map.Entry<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> entry : list22.entrySet()) {
                        list22 = entry.getKey();
                        kotlin.reflect.jvm.internal.impl.h.b.f<?> object2 = entry.getValue();
                        list22 = j.a((Object)list22, (Object)o.c) ? this.a(object2) : m.a();
                        m.a(collection, (Iterable)list22);
                    }
                    list22 = ((Iterable)((List)collection)).iterator();
                    n2 = 0;
                    while (list22.hasNext()) {
                        n2 |= 1 << ((a)((Object)list22.next())).ordinal();
                    }
                    for (List<a> list22 : (Iterable)object.x()) {
                        boolean bl2 = this.a((kotlin.reflect.jvm.internal.impl.a.a.c)((Object)list22)) != null;
                        if (!bl2) continue;
                        break block10;
                    }
                    list22 = null;
                }
                list22 = (kotlin.reflect.jvm.internal.impl.a.a.c)((Object)list22);
                if (list22 != null) {
                    return new b((kotlin.reflect.jvm.internal.impl.a.a.c)((Object)list22), n2);
                }
            }
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.l.h d(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        j.b(object, "annotationDescriptor");
        object = this.e((kotlin.reflect.jvm.internal.impl.a.a.c)object);
        if (object != null) {
            return object;
        }
        return this.c.b();
    }

    public final kotlin.reflect.jvm.internal.impl.l.h e(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        j.b(object, "annotationDescriptor");
        Map<String, kotlin.reflect.jvm.internal.impl.l.h> map = this.c.d();
        Object object2 = object.b();
        Object var3_4 = null;
        object2 = object2 != null ? ((kotlin.reflect.jvm.internal.impl.e.b)object2).a() : null;
        object2 = map.get(object2);
        if (object2 != null) {
            return object2;
        }
        object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a(object);
        object = var3_4;
        if (object2 != null) {
            object = this.c((kotlin.reflect.jvm.internal.impl.a.e)object2);
        }
        return object;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        private static final /* synthetic */ a[] e;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a = a3 = new a();
            b = a4 = new a();
            c = a2 = new a();
            d = a5 = new a();
            e = new a[]{a3, a4, a2, a5};
        }

        public static a valueOf(String string2) {
            return Enum.valueOf(a.class, string2);
        }

        public static a[] values() {
            return (a[])e.clone();
        }
    }

    public static final class b {
        private final kotlin.reflect.jvm.internal.impl.a.a.c a;
        private final int b;

        public b(kotlin.reflect.jvm.internal.impl.a.a.c c2, int n2) {
            j.b(c2, "typeQualifier");
            this.a = c2;
            this.b = n2;
        }

        private final boolean a(a a2) {
            return this.b(a.d) || this.b(a2);
            {
            }
        }

        private final boolean b(a a2) {
            int n2 = this.b;
            return (1 << a2.ordinal() & n2) != 0;
        }

        public final kotlin.reflect.jvm.internal.impl.a.a.c a() {
            return this.a;
        }

        public final List<a> b() {
            a[] arra = a.values();
            Collection collection = new ArrayList();
            for (a a2 : arra) {
                if (!this.a(a2)) continue;
                collection.add(a2);
            }
            return (List)collection;
        }
    }

}

