/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class i
implements ac {
    private final List<ac> a;

    public i(List<? extends ac> list) {
        j.b(list, "providers");
        this.a = list;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.e.b> a(kotlin.reflect.jvm.internal.impl.e.b b2, b<? super f, Boolean> b3) {
        j.b(b2, "fqName");
        j.b(b3, "nameFilter");
        HashSet<kotlin.reflect.jvm.internal.impl.e.b> hashSet = new HashSet<kotlin.reflect.jvm.internal.impl.e.b>();
        Iterator<ac> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            hashSet.addAll(iterator.next().a(b2, b3));
        }
        return hashSet;
    }

    @Override
    public List<ab> a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<ac> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            arrayList.addAll(iterator.next().a(b2));
        }
        return m.k(arrayList);
    }
}

