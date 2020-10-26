/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/DepartureOrArrival;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEPARTURE", "ARRIVAL", "LAST_TRAIN", "FIRST_TRAIN", "UNSELECTED", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends Enum<c> {
    public static final /* enum */ c a;
    public static final /* enum */ c b;
    public static final /* enum */ c c;
    public static final /* enum */ c d;
    public static final /* enum */ c e;
    private static final /* synthetic */ c[] f;
    private final int g;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        c c6;
        a = c6 = new c(0);
        b = c5 = new c(1);
        c = c3 = new c(2);
        d = c2 = new c(3);
        e = c4 = new c(4);
        f = new c[]{c6, c5, c3, c2, c4};
    }

    protected c(int n3) {
        this.g = n3;
    }

    public static c valueOf(String string2) {
        return Enum.valueOf(c.class, string2);
    }

    public static c[] values() {
        return (c[])f.clone();
    }

    public final int a() {
        return this.g;
    }
}

