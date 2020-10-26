/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;

public interface h
extends Iterable<c>,
kotlin.e.b.a.a {
    public static final a a = a.a;

    public c a(kotlin.reflect.jvm.internal.impl.e.b var1);

    public boolean a();

    public List<g> b();

    public boolean b(kotlin.reflect.jvm.internal.impl.e.b var1);

    public List<g> c();

    public static final class kotlin.reflect.jvm.internal.impl.a.a.h$a {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a.h$a a;
        private static final h b;

        static {
            a = new kotlin.reflect.jvm.internal.impl.a.a.h$a();
            b = new h(){

                @Override
                public /* synthetic */ c a(kotlin.reflect.jvm.internal.impl.e.b b2) {
                    return (c)((Object)this.c(b2));
                }

                @Override
                public boolean a() {
                    return true;
                }

                @Override
                public List<g> b() {
                    return m.a();
                }

                @Override
                public boolean b(kotlin.reflect.jvm.internal.impl.e.b b2) {
                    j.b(b2, "fqName");
                    return b.b(this, b2);
                }

                public Void c(kotlin.reflect.jvm.internal.impl.e.b b2) {
                    j.b(b2, "fqName");
                    return null;
                }

                @Override
                public List<g> c() {
                    return m.a();
                }

                @Override
                public Iterator<c> iterator() {
                    return m.a().iterator();
                }

                public String toString() {
                    return "EMPTY";
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.a.a.h$a() {
        }

        private final List<c> a(h object, e e2) {
            object = object.b();
            Collection collection = new ArrayList();
            Iterator<c> iterator = object.iterator();
            while (iterator.hasNext()) {
                g g2 = (g)((Object)iterator.next());
                object = g2.c();
                boolean bl2 = e2 == g2.d();
                if (!bl2) {
                    object = null;
                }
                if (object == null) continue;
                collection.add(object);
            }
            return (List)collection;
        }

        public final c a(h h22, e object, kotlin.reflect.jvm.internal.impl.e.b b2) {
            block1 : {
                j.b(h22, "annotations");
                j.b(object, "target");
                j.b(b2, "fqName");
                for (h h22 : (Iterable)this.a(h22, (e)((Object)object))) {
                    if (!j.a((Object)((c)((Object)h22)).b(), (Object)b2)) continue;
                    break block1;
                }
                h22 = null;
            }
            return (c)((Object)h22);
        }

        public final h a() {
            return b;
        }

    }

    public static final class b {
        public static c a(h h22, kotlin.reflect.jvm.internal.impl.e.b b2) {
            block1 : {
                j.b(b2, "fqName");
                for (h h22 : (Iterable)h22) {
                    if (!j.a((Object)((c)((Object)h22)).b(), (Object)b2)) continue;
                    break block1;
                }
                h22 = null;
            }
            return (c)((Object)h22);
        }

        public static boolean b(h h2, kotlin.reflect.jvm.internal.impl.e.b b2) {
            j.b(b2, "fqName");
            return h2.a(b2) != null;
        }
    }

}

