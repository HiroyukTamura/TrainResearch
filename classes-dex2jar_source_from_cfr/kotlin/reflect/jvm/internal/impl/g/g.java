/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.a.m;

public final class g
extends Enum<g> {
    public static final /* enum */ g a;
    public static final /* enum */ g b;
    public static final /* enum */ g c;
    public static final /* enum */ g d;
    public static final /* enum */ g e;
    public static final /* enum */ g f;
    public static final /* enum */ g g;
    public static final /* enum */ g h;
    public static final /* enum */ g i;
    public static final /* enum */ g j;
    public static final Set<g> k;
    public static final Set<g> l;
    public static final a m;
    private static final /* synthetic */ g[] n;
    private final boolean o;

    static {
        g g2;
        g g32;
        g g4;
        g g5;
        g g6;
        g g7;
        g g8;
        g g9;
        g[] arrg = new g[](true);
        a = arrg;
        Object object = new g(true);
        b = object;
        c = g32 = new g(true);
        d = g6 = new g(false);
        e = g5 = new g(true);
        f = g2 = new g(true);
        g = g4 = new g(true);
        h = g7 = new g(true);
        i = g9 = new g(true);
        j = g8 = new g(true);
        n = new g[]{arrg, object, g32, g6, g5, g2, g4, g7, g9, g8};
        m = new a(null);
        arrg = g.values();
        object = new ArrayList();
        for (g g32 : arrg) {
            if (!g32.o) continue;
            object.add(g32);
        }
        k = m.m((List)object);
        l = kotlin.a.g.j(g.values());
    }

    protected g(boolean bl2) {
        this.o = bl2;
    }

    public static g valueOf(String string2) {
        return Enum.valueOf(g.class, string2);
    }

    public static g[] values() {
        return (g[])n.clone();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

