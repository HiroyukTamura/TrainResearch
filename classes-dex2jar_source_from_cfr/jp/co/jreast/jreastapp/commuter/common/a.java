/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ApiArgumentKeys;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "FROM", "TO", "DATE", "TIME", "DEPARTURE_OR_ARRIVAL", "EXPRESS", "TRANSFER_TIME", "VIA1", "VIA2", "LINE_ID", "AREA_ID", "PREVIOUS_NEXT_KEY", "USER_ID", "REGISTRATION_TOKEN", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    public static final /* enum */ a d;
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    public static final /* enum */ a i;
    public static final /* enum */ a j;
    public static final /* enum */ a k;
    public static final /* enum */ a l;
    public static final /* enum */ a m;
    public static final /* enum */ a n;
    private static final /* synthetic */ a[] o;
    private final String p;

    static {
        a a2;
        a a3;
        a a4;
        a a5;
        a a6;
        a a7;
        a a8;
        a a9;
        a a10;
        a a11;
        a a12;
        a a13;
        a a14;
        a a15;
        a = a9 = new a("from");
        b = a5 = new a("to");
        c = a8 = new a("date");
        d = a12 = new a("time");
        e = a3 = new a("departureOrArrival");
        f = a11 = new a("express");
        g = a14 = new a("transferTime");
        h = a2 = new a("via1");
        i = a10 = new a("via2");
        j = a6 = new a("lineId");
        k = a4 = new a("areaId");
        l = a15 = new a("previousNextKey");
        m = a13 = new a("uid");
        n = a7 = new a("token");
        o = new a[]{a9, a5, a8, a12, a3, a11, a14, a2, a10, a6, a4, a15, a13, a7};
    }

    protected a(String string3) {
        j.b(string3, "key");
        this.p = string3;
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])o.clone();
    }

    public final String a() {
        return this.p;
    }
}

