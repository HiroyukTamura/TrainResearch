/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.r;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptureViewType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "HEADER", "FOOTER", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends Enum<h> {
    public static final /* enum */ h a;
    public static final /* enum */ h b;
    private static final /* synthetic */ h[] c;
    private final int d;

    static {
        h h2;
        h h3;
        a = h3 = new h(Integer.MAX_VALUE);
        b = h2 = new h(2147483646);
        c = new h[]{h3, h2};
    }

    protected h(int n3) {
        this.d = n3;
    }

    public static h valueOf(String string2) {
        return Enum.valueOf(h.class, string2);
    }

    public static h[] values() {
        return (h[])c.clone();
    }

    public final int a() {
        return this.d;
    }
}

