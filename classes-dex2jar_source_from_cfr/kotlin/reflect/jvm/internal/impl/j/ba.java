/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;

public final class ba
extends Enum<ba> {
    public static final /* enum */ ba a;
    public static final /* enum */ ba b;
    public static final /* enum */ ba c;
    private static final /* synthetic */ ba[] d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final int h;

    static {
        ba ba2;
        ba ba3;
        ba ba4;
        a = ba2 = new ba("", true, true, 0);
        b = ba3 = new ba("in", true, false, -1);
        c = ba4 = new ba("out", false, true, 1);
        d = new ba[]{ba2, ba3, ba4};
    }

    protected ba(String string3, boolean bl2, boolean bl3, int n3) {
        j.b(string3, "label");
        this.e = string3;
        this.f = bl2;
        this.g = bl3;
        this.h = n3;
    }

    public static ba valueOf(String string2) {
        return Enum.valueOf(ba.class, string2);
    }

    public static ba[] values() {
        return (ba[])d.clone();
    }

    public final String a() {
        return this.e;
    }

    public final boolean b() {
        return this.g;
    }

    public String toString() {
        return this.e;
    }
}

