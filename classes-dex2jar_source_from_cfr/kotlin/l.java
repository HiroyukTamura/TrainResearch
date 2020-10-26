/*
 * Decompiled with CFR 0.139.
 */
package kotlin;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/LazyThreadSafetyMode;", "", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class l
extends Enum<l> {
    public static final /* enum */ l a;
    public static final /* enum */ l b;
    public static final /* enum */ l c;
    private static final /* synthetic */ l[] d;

    static {
        l l2;
        l l3;
        l l4;
        a = l2 = new l();
        b = l4 = new l();
        c = l3 = new l();
        d = new l[]{l2, l4, l3};
    }

    public static l valueOf(String string2) {
        return Enum.valueOf(l.class, string2);
    }

    public static l[] values() {
        return (l[])d.clone();
    }
}

