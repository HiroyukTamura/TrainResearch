/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

public final class e
extends Enum<e> {
    public static final /* enum */ e a;
    public static final /* enum */ e b;
    private static final /* synthetic */ e[] c;

    static {
        e e2;
        e e3;
        a = e3 = new e();
        b = e2 = new e();
        c = new e[]{e3, e2};
    }

    public static e valueOf(String string2) {
        return Enum.valueOf(e.class, string2);
    }

    public static e[] values() {
        return (e[])c.clone();
    }
}

