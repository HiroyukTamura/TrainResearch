/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

public final class m
extends Enum<m> {
    public static final /* enum */ m a;
    public static final /* enum */ m b;
    public static final /* enum */ m c;
    private static final /* synthetic */ m[] d;

    static {
        m m2;
        m m3;
        m m4;
        a = m4 = new m();
        b = m3 = new m();
        c = m2 = new m();
        d = new m[]{m4, m3, m2};
    }

    public static m valueOf(String string2) {
        return Enum.valueOf(m.class, string2);
    }

    public static m[] values() {
        return (m[])d.clone();
    }
}

