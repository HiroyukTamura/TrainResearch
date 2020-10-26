/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

public final class g
extends Enum<g> {
    public static final /* enum */ g a;
    public static final /* enum */ g b;
    public static final /* enum */ g c;
    private static final /* synthetic */ g[] d;

    static {
        g g2;
        g g3;
        g g4;
        a = g2 = new g();
        b = g4 = new g();
        c = g3 = new g();
        d = new g[]{g2, g4, g3};
    }

    public static g valueOf(String string2) {
        return Enum.valueOf(g.class, string2);
    }

    public static g[] values() {
        return (g[])d.clone();
    }
}

