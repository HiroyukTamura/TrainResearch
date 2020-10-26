/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.List;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.c.s;
import kotlin.reflect.jvm.internal.impl.a.c.u;

public final class t
implements s {
    private final List<u> a;
    private final Set<u> b;
    private final List<u> c;

    public t(List<u> list, Set<u> set, List<u> list2) {
        j.b(list, "allDependencies");
        j.b(set, "modulesWhoseInternalsAreVisible");
        j.b(list2, "expectedByDependencies");
        this.a = list;
        this.b = set;
        this.c = list2;
    }

    @Override
    public List<u> a() {
        return this.a;
    }

    @Override
    public Set<u> b() {
        return this.b;
    }

    @Override
    public List<u> c() {
        return this.c;
    }
}

