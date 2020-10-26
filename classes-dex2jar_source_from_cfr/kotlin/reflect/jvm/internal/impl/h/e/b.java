/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;

public final class b
implements h {
    public static final a a = new a(null);
    private final String b;
    private final List<h> d;

    public b(String string2, List<? extends h> list) {
        j.b(string2, "debugName");
        j.b(list, "scopes");
        this.b = string2;
        this.d = list;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        Collection<ai> collection;
        block4 : {
            block3 : {
                j.b(f2, "name");
                j.b(b2, "location");
                Object object = this.d;
                if (object.isEmpty()) break block3;
                collection = null;
                object = object.iterator();
                while (object.hasNext()) {
                    collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((h)object.next()).a(f2, b2));
                }
                if (collection != null) break block4;
            }
            return al.a();
        }
        return collection;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(d d2, kotlin.e.a.b<? super f, Boolean> b2) {
        Collection<kotlin.reflect.jvm.internal.impl.a.m> collection;
        block4 : {
            block3 : {
                j.b(d2, "kindFilter");
                j.b(b2, "nameFilter");
                Object object = this.d;
                if (object.isEmpty()) break block3;
                collection = null;
                object = object.iterator();
                while (object.hasNext()) {
                    collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((h)object.next()).a(d2, b2));
                }
                if (collection != null) break block4;
            }
            return al.a();
        }
        return collection;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        Collection<am> collection;
        block4 : {
            block3 : {
                j.b(f2, "name");
                j.b(b2, "location");
                Object object = this.d;
                if (object.isEmpty()) break block3;
                collection = null;
                object = object.iterator();
                while (object.hasNext()) {
                    collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((h)object.next()).b(f2, b2));
                }
                if (collection != null) break block4;
            }
            return al.a();
        }
        return collection;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        Object object = this.d;
        Object object2 = null;
        Iterator<h> iterator = object.iterator();
        do {
            object = object2;
            if (!iterator.hasNext()) break;
            object = iterator.next().c(f2, b2);
            if (object == null) continue;
            if (!(object instanceof i) || !((i)object).u()) break;
            if (object2 != null) continue;
            object2 = object;
        } while (true);
        return object;
    }

    @Override
    public Set<f> l_() {
        Object object = this.d;
        Collection collection = new LinkedHashSet();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((h)object.next()).l_());
        }
        return (Set)collection;
    }

    @Override
    public Set<f> o_() {
        Object object = this.d;
        Collection collection = new LinkedHashSet();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((h)object.next()).o_());
        }
        return (Set)collection;
    }

    public String toString() {
        return this.b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

