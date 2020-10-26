/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.c.a.f.r;

public final class j {
    private final r a;
    private final List<r> b;

    public j() {
        this(null, null, 3, null);
    }

    public j(r r2, List<r> list) {
        kotlin.e.b.j.b(list, "parametersInfo");
        this.a = r2;
        this.b = list;
    }

    public /* synthetic */ j(r r2, List list, int n2, g g2) {
        if ((n2 & 1) != 0) {
            r2 = null;
        }
        if ((n2 & 2) != 0) {
            list = m.a();
        }
        this(r2, list);
    }

    public final r a() {
        return this.a;
    }

    public final List<r> b() {
        return this.b;
    }
}

