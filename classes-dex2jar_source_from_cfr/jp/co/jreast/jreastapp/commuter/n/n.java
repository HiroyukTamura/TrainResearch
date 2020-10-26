/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.n;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "LINE", "WALKING", "WALKING_IN_MIDDLE", "DIRECT_ARRIVAL", "BOTTOM", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class n
extends Enum<n> {
    public static final /* enum */ n a;
    public static final /* enum */ n b;
    public static final /* enum */ n c;
    public static final /* enum */ n d;
    public static final /* enum */ n e;
    private static final /* synthetic */ n[] f;
    private final int g;

    static {
        n n2;
        n n3;
        n n4;
        n n5;
        n n6;
        a = n5 = new n(0);
        b = n6 = new n(1);
        c = n2 = new n(2);
        d = n3 = new n(3);
        e = n4 = new n(4);
        f = new n[]{n5, n6, n2, n3, n4};
    }

    protected n(int n3) {
        this.g = n3;
    }

    public static n valueOf(String string2) {
        return Enum.valueOf(n.class, string2);
    }

    public static n[] values() {
        return (n[])f.clone();
    }

    public final int a() {
        return this.g;
    }
}

