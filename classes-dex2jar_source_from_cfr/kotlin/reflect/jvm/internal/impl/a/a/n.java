/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

public final class n
extends Enum<n> {
    public static final /* enum */ n a;
    public static final /* enum */ n b;
    public static final /* enum */ n c;
    private static final /* synthetic */ n[] d;

    static {
        n n2;
        n n3;
        n n4;
        a = n4 = new n();
        b = n2 = new n();
        c = n3 = new n();
        d = new n[]{n4, n2, n3};
    }

    public static n valueOf(String string2) {
        return Enum.valueOf(n.class, string2);
    }

    public static n[] values() {
        return (n[])d.clone();
    }
}

