/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import kotlin.e.b.g;
import kotlin.e.b.j;

public final class h
extends Enum<h> {
    public static final /* enum */ h a;
    public static final /* enum */ h b;
    public static final /* enum */ h c;
    public static final a d;
    private static final /* synthetic */ h[] e;
    private final String f;

    static {
        h h2;
        h h3;
        h h4;
        a = h4 = new h("ignore");
        b = h3 = new h("warn");
        c = h2 = new h("strict");
        e = new h[]{h4, h3, h2};
        d = new a(null);
    }

    protected h(String string3) {
        j.b(string3, "description");
        this.f = string3;
    }

    public static h valueOf(String string2) {
        return Enum.valueOf(h.class, string2);
    }

    public static h[] values() {
        return (h[])e.clone();
    }

    public final boolean a() {
        return this == b;
    }

    public final boolean b() {
        return this == a;
    }

    public final String c() {
        return this.f;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

