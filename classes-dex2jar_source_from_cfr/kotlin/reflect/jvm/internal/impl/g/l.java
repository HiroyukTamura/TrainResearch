/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

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
        a = l4 = new l();
        b = l3 = new l();
        c = l2 = new l();
        d = new l[]{l4, l3, l2};
    }

    public static l valueOf(String string2) {
        return Enum.valueOf(l.class, string2);
    }

    public static l[] values() {
        return (l[])d.clone();
    }
}

