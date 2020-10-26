/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/FragmentsTag;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "RouteSearch", "TrainService", "TrainLocation", "Other", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends Enum<d> {
    public static final /* enum */ d a;
    public static final /* enum */ d b;
    public static final /* enum */ d c;
    public static final /* enum */ d d;
    private static final /* synthetic */ d[] e;
    private final int f;

    static {
        d d2;
        d d3;
        d d4;
        d d5;
        a = d4 = new d(0);
        b = d3 = new d(1);
        c = d2 = new d(2);
        d = d5 = new d(3);
        e = new d[]{d4, d3, d2, d5};
    }

    protected d(int n3) {
        this.f = n3;
    }

    public static d valueOf(String string2) {
        return Enum.valueOf(d.class, string2);
    }

    public static d[] values() {
        return (d[])e.clone();
    }

    public final int a() {
        return this.f;
    }
}

