/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

final class i
extends Enum<i> {
    public static final /* enum */ i a;
    public static final /* enum */ i b;
    public static final /* enum */ i c;
    private static final /* synthetic */ i[] d;

    static {
        i i2;
        i i3;
        i i4;
        a = i3 = new i();
        b = i2 = new i();
        c = i4 = new i();
        d = new i[]{i3, i2, i4};
    }

    public static i valueOf(String string2) {
        return Enum.valueOf(i.class, string2);
    }

    public static i[] values() {
        return (i[])d.clone();
    }
}

