/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;

public final class h {
    private final List<a.ac> a;

    public h(a.ai object) {
        j.b(object, "typeTable");
        Object object2 = this;
        object2 = ((a.ai)object).d();
        if (((a.ai)object).f()) {
            int n2 = ((a.ai)object).g();
            object = ((a.ai)object).d();
            j.a(object, "typeTable.typeList");
            object = (Iterable)object;
            Collection collection = new ArrayList(m.a(object, 10));
            int n3 = 0;
            Iterator<a.ac> iterator = object.iterator();
            while (iterator.hasNext()) {
                object = object2 = iterator.next();
                if (n3 >= n2) {
                    object = ((a.ac)object2).M().a(true).c();
                }
                collection.add(object);
                ++n3;
            }
            object = (List)collection;
        } else {
            j.a(object2, "originalTypes");
            object = object2;
        }
        this.a = object;
    }

    public final a.ac a(int n2) {
        return this.a.get(n2);
    }
}

