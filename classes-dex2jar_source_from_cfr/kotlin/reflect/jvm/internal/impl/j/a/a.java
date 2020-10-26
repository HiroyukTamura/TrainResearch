/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    private static final /* synthetic */ a[] d;

    static {
        a a2;
        a a3;
        a a4;
        a = a2 = new a();
        b = a3 = new a();
        c = a4 = new a();
        d = new a[]{a2, a3, a4};
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])d.clone();
    }
}

