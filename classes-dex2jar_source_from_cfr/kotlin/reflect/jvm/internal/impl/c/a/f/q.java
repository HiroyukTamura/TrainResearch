/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

final class q
extends Enum<q> {
    public static final /* enum */ q a;
    public static final /* enum */ q b;
    public static final /* enum */ q c;
    private static final /* synthetic */ q[] d;

    static {
        q q2;
        q q3;
        q q4;
        a = q3 = new q();
        b = q2 = new q();
        c = q4 = new q();
        d = new q[]{q3, q2, q4};
    }

    public static q valueOf(String string2) {
        return Enum.valueOf(q.class, string2);
    }

    public static q[] values() {
        return (q[])d.clone();
    }
}

