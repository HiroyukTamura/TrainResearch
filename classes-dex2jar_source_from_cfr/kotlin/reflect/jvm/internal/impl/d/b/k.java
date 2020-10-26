/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;

public final class k {
    public static final a a = new a(null);
    private static final k c = new k(m.<a.am>a());
    private final List<a.am> b;

    private k(List<a.am> list) {
        this.b = list;
    }

    public /* synthetic */ k(List list, g g2) {
        this(list);
    }

    public final a.am a(int n2) {
        return m.c(this.b, n2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final k a() {
            return c;
        }

        public final k a(a.ao object) {
            j.b(object, "table");
            if (((a.ao)object).e() == 0) {
                return this.a();
            }
            object = ((a.ao)object).d();
            j.a(object, "table.requirementList");
            return new k((List)object, null);
        }
    }

}

