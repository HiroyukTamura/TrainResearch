/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.h.e.i;

public final class f
extends i {
    private final h a;

    public f(h h2) {
        j.b(h2, "workerScope");
        this.a = h2;
    }

    public /* synthetic */ Collection a(d d2, b b2) {
        return this.b(d2, b2);
    }

    public List<kotlin.reflect.jvm.internal.impl.a.h> b(d object, b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> iterator) {
        j.b(object, "kindFilter");
        j.b(iterator, "nameFilter");
        object = ((d)object).b(d.k.h());
        if (object != null) {
            iterator = this.a.a((d)object, (b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean>)((Object)iterator));
            object = new ArrayList();
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                Object t2 = iterator.next();
                if (!(t2 instanceof kotlin.reflect.jvm.internal.impl.a.i)) continue;
                object.add(t2);
            }
            return (List)object;
        }
        return kotlin.a.m.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f object, kotlin.reflect.jvm.internal.impl.b.a.b object2) {
        j.b(object, "name");
        j.b(object2, "location");
        object = this.a.c((kotlin.reflect.jvm.internal.impl.e.f)object, (kotlin.reflect.jvm.internal.impl.b.a.b)object2);
        object2 = null;
        if (object != null) {
            object2 = !(object instanceof e) ? null : object;
            if ((object2 = (e)object2) != null) {
                return (kotlin.reflect.jvm.internal.impl.a.h)object2;
            }
            object2 = object;
            if (!(object instanceof ar)) {
                object2 = null;
            }
            object2 = (ar)object2;
        }
        return object2;
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
        return this.a.l_();
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
        return this.a.o_();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classes from ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}

