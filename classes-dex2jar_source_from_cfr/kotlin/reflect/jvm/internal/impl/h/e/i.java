/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;

public abstract class i
implements h {
    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return kotlin.a.m.a();
    }

    @Override
    public Collection<m> a(d d2, b<? super f, Boolean> b2) {
        j.b(d2, "kindFilter");
        j.b(b2, "nameFilter");
        return kotlin.a.m.a();
    }

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return kotlin.a.m.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return null;
    }

    public void d(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        h.b.a(this, f2, b2);
    }

    @Override
    public Set<f> l_() {
        Iterator iterator = this.a(d.h, kotlin.reflect.jvm.internal.impl.l.d.a());
        Collection collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!(e2 instanceof am)) continue;
            collection.add(e2);
        }
        iterator = (List)collection;
        collection = new LinkedHashSet();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection.add(((am)iterator.next()).h_());
        }
        return (Set)collection;
    }

    @Override
    public Set<f> o_() {
        Iterator iterator = this.a(d.i, kotlin.reflect.jvm.internal.impl.l.d.a());
        Collection collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!(e2 instanceof ax)) continue;
            collection.add(e2);
        }
        iterator = (List)collection;
        collection = new LinkedHashSet();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection.add(((ax)iterator.next()).h_());
        }
        return (Set)collection;
    }
}

