/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.c;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.i;
import kotlin.reflect.jvm.internal.impl.l.a;

public class ad
extends i {
    private final y a;
    private final kotlin.reflect.jvm.internal.impl.e.b b;

    public ad(y y2, kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(y2, "moduleDescriptor");
        j.b(b2, "fqName");
        this.a = y2;
        this.b = b2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Collection<m> a(d arrayList, b<? super f, Boolean> b2) {
        j.b(arrayList, "kindFilter");
        j.b(b2, "nameFilter");
        if (!((d)((Object)arrayList)).a(d.k.d())) {
            return kotlin.a.m.a();
        }
        if (this.b.c() && ((d)((Object)arrayList)).b().contains(c.b.a)) {
            return kotlin.a.m.a();
        }
        Object object = this.a.a(this.b, b2);
        arrayList = new ArrayList(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            f f2 = ((kotlin.reflect.jvm.internal.impl.e.b)object.next()).e();
            j.a((Object)f2, "shortName");
            if (!b2.a(f2).booleanValue()) continue;
            a.a(arrayList, this.a(f2));
        }
        return arrayList;
    }

    protected final ae a(f object) {
        j.b(object, "name");
        if (((f)object).c()) {
            return null;
        }
        y y2 = this.a;
        object = this.b.a((f)object);
        j.a(object, "fqName.child(name)");
        object = y2.a((kotlin.reflect.jvm.internal.impl.e.b)object);
        if (object.g()) {
            return null;
        }
        return object;
    }
}

