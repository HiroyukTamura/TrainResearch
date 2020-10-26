/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.r;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2={"Ljp/co/jreast/jreastapp/commuter/util/CommuterActivityRequestCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "COMMUTER_PAGER", "CANDIDATE_STATION", "DEPARTURE_ARRIVAL_TIME_SELECT", "ROUTE_SEARCH_RESULT", "ROUTE_DETAIL", "FAVORITE_ROUTE_REGISTRATION", "SERVICE_STATUS_DETAIL", "WEB_VIEW", "ACKNOWLEDGEMENT", "TIMETABLE", "OTHERS", "COMMON_WEB_VIEW", "CANDIDATE_LINE", "SETTINGS_EXPRESS", "SETTINGS_FARE", "SETTINGS_TRANSFER_TIME", "FAVORITE_ROUTE_EDIT", "REMOVE_ACCESS_LOG", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends Enum<c> {
    public static final /* enum */ c a;
    public static final /* enum */ c b;
    public static final /* enum */ c c;
    public static final /* enum */ c d;
    public static final /* enum */ c e;
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    public static final /* enum */ c k;
    public static final /* enum */ c l;
    public static final /* enum */ c m;
    public static final /* enum */ c n;
    public static final /* enum */ c o;
    public static final /* enum */ c p;
    public static final /* enum */ c q;
    public static final /* enum */ c r;
    private static final /* synthetic */ c[] s;
    private final int t;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        c c6;
        c c7;
        c c8;
        c c9;
        c c10;
        c c11;
        c c12;
        c c13;
        c c14;
        c c15;
        c c16;
        c c17;
        c c18;
        c c19;
        a = c17 = new c(0);
        b = c12 = new c(1);
        c = c13 = new c(2);
        d = c5 = new c(3);
        e = c10 = new c(4);
        f = c19 = new c(5);
        g = c6 = new c(6);
        h = c11 = new c(7);
        i = c3 = new c(8);
        j = c16 = new c(9);
        k = c9 = new c(10);
        l = c7 = new c(11);
        m = c2 = new c(12);
        n = c15 = new c(13);
        o = c18 = new c(14);
        p = c14 = new c(15);
        q = c4 = new c(16);
        r = c8 = new c(17);
        s = new c[]{c17, c12, c13, c5, c10, c19, c6, c11, c3, c16, c9, c7, c2, c15, c18, c14, c4, c8};
    }

    protected c(int n3) {
        this.t = n3;
    }

    public static c valueOf(String string2) {
        return Enum.valueOf(c.class, string2);
    }

    public static c[] values() {
        return (c[])s.clone();
    }

    public final int a() {
        return this.t;
    }
}

