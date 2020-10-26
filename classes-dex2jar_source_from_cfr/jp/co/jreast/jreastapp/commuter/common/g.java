/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LineViewType;", "", "(Ljava/lang/String;I)V", "TOP", "MIDDLE", "BOTTOM", "NO_TRANSFER", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends Enum<g> {
    public static final /* enum */ g a;
    public static final /* enum */ g b;
    public static final /* enum */ g c;
    public static final /* enum */ g d;
    private static final /* synthetic */ g[] e;

    static {
        g g2;
        g g3;
        g g4;
        g g5;
        a = g5 = new g();
        b = g4 = new g();
        c = g2 = new g();
        d = g3 = new g();
        e = new g[]{g5, g4, g2, g3};
    }

    public static g valueOf(String string2) {
        return Enum.valueOf(g.class, string2);
    }

    public static g[] values() {
        return (g[])e.clone();
    }
}

