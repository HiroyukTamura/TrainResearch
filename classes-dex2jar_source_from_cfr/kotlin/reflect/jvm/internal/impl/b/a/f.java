/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.b.a;

public final class f
extends Enum<f> {
    public static final /* enum */ f a;
    public static final /* enum */ f b;
    private static final /* synthetic */ f[] c;

    static {
        f f2;
        f f3;
        a = f2 = new f();
        b = f3 = new f();
        c = new f[]{f2, f3};
    }

    public static f valueOf(String string2) {
        return Enum.valueOf(f.class, string2);
    }

    public static f[] values() {
        return (f[])c.clone();
    }
}

