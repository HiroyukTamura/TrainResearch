/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

public final class b
extends Enum<b> {
    public static final /* enum */ b a;
    public static final /* enum */ b b;
    public static final /* enum */ b c;
    private static final /* synthetic */ b[] d;

    static {
        b b2;
        b b3;
        b b4;
        a = b2 = new b();
        b = b4 = new b();
        c = b3 = new b();
        d = new b[]{b2, b4, b3};
    }

    public static b valueOf(String string2) {
        return Enum.valueOf(b.class, string2);
    }

    public static b[] values() {
        return (b[])d.clone();
    }
}

