/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import kotlin.e.b.g;

public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    private static final /* synthetic */ a[] d;
    private final boolean e;
    private final boolean f;

    static {
        a a2;
        a a3;
        a a4;
        a = a2 = new a("NO_ARGUMENTS", 0, false, false, 3, null);
        b = a4 = new a("UNLESS_EMPTY", 1, true, false, 2, null);
        c = a3 = new a(true, true);
        d = new a[]{a2, a4, a3};
    }

    protected a(boolean bl2, boolean bl3) {
        this.e = bl2;
        this.f = bl3;
    }

    /* synthetic */ a(String string2, int n2, boolean bl2, boolean bl3, int n3, g g2) {
        if ((n3 & 1) != 0) {
            bl2 = false;
        }
        if ((n3 & 2) != 0) {
            bl3 = false;
        }
        this(bl2, bl3);
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])d.clone();
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }
}

