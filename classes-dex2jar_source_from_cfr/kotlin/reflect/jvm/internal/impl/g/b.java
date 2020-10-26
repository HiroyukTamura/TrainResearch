/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.g.o;

public interface b {
    public String a(h var1, kotlin.reflect.jvm.internal.impl.g.c var2);

    public static final class a
    implements b {
        public static final a a = new a();

        private a() {
        }

        @Override
        public String a(h object, kotlin.reflect.jvm.internal.impl.g.c c2) {
            j.b(object, "classifier");
            j.b(c2, "renderer");
            if (object instanceof as) {
                object = ((as)object).h_();
                j.a(object, "classifier.name");
                return c2.a((f)object, false);
            }
            object = kotlin.reflect.jvm.internal.impl.h.c.d((m)object);
            j.a(object, "DescriptorUtils.getFqName(classifier)");
            return c2.a((kotlin.reflect.jvm.internal.impl.e.c)object);
        }
    }

    public static final class b
    implements b {
        public static final b a = new b();

        private b() {
        }

        @Override
        public String a(h object, kotlin.reflect.jvm.internal.impl.g.c object2) {
            j.b(object, "classifier");
            j.b(object2, "renderer");
            if (object instanceof as) {
                object = ((as)object).h_();
                j.a(object, "classifier.name");
                return ((kotlin.reflect.jvm.internal.impl.g.c)object2).a((f)object, false);
            }
            ArrayList<f> arrayList = new ArrayList<f>();
            object = (m)object;
            do {
                arrayList.add(object.h_());
                object = object2 = object.b();
            } while (object2 instanceof e);
            return o.a(kotlin.a.m.d((List)arrayList));
        }
    }

    public static final class c
    implements b {
        public static final c a = new c();

        private c() {
        }

        private final String a(h object) {
            Object object2 = object.h_();
            j.a(object2, "descriptor.name");
            object2 = o.a((f)object2);
            if (object instanceof as) {
                return object2;
            }
            object = object.b();
            j.a(object, "descriptor.containingDeclaration");
            String string2 = this.a((m)object);
            object = object2;
            if (string2 != null) {
                object = object2;
                if (j.a((Object)string2, (Object)"") ^ true) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(".");
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                }
            }
            return object;
        }

        private final String a(m object) {
            if (object instanceof e) {
                return this.a((h)object);
            }
            if (object instanceof ab) {
                object = ((ab)object).f().b();
                j.a(object, "descriptor.fqName.toUnsafe()");
                return o.a((kotlin.reflect.jvm.internal.impl.e.c)object);
            }
            return null;
        }

        @Override
        public String a(h h2, kotlin.reflect.jvm.internal.impl.g.c c2) {
            j.b(h2, "classifier");
            j.b(c2, "renderer");
            return this.a(h2);
        }
    }

}

