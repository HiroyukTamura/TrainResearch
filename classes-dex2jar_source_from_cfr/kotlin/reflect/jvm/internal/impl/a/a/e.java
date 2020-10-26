/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.t;

public final class e
extends Enum<e> {
    public static final /* enum */ e a;
    public static final /* enum */ e b;
    public static final /* enum */ e c;
    public static final /* enum */ e d;
    public static final /* enum */ e e;
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    public static final /* enum */ e i;
    public static final a j;
    private static final /* synthetic */ e[] k;
    private final String l;

    static {
        e e2;
        e e3;
        e e4;
        e e5;
        e e6;
        e e7;
        e e8;
        e e9;
        e e10;
        a = e2 = new e("FIELD", 0, null, 1, null);
        b = e10 = new e("FILE", 1, null, 1, null);
        c = e3 = new e("PROPERTY", 2, null, 1, null);
        d = e7 = new e("get");
        e = e9 = new e("set");
        f = e5 = new e("RECEIVER", 5, null, 1, null);
        g = e8 = new e("param");
        h = e6 = new e("setparam");
        i = e4 = new e("delegate");
        k = new e[]{e2, e10, e3, e7, e9, e5, e8, e6, e4};
        j = new a(null);
    }

    protected e(String string3) {
        block3 : {
            block2 : {
                if (string3 != null) break block2;
                string2 = this.name();
                if (string2 == null) break block3;
                string3 = string2.toLowerCase();
                j.a((Object)string3, "(this as java.lang.String).toLowerCase()");
            }
            this.l = string3;
            return;
        }
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    /* synthetic */ e(String string2, int n2, String string3, int n3, g g2) {
        if ((n3 & 1) != 0) {
            string3 = null;
        }
        this(string3);
    }

    public static e valueOf(String string2) {
        return Enum.valueOf(e.class, string2);
    }

    public static e[] values() {
        return (e[])k.clone();
    }

    public final String a() {
        return this.l;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final e a(m m2) {
            j.b(m2, "descriptor");
            if (m2 instanceof ai) {
                return e.c;
            }
            if (m2 instanceof av) {
                return e.g;
            }
            if (m2 instanceof aj) {
                return e.d;
            }
            if (m2 instanceof ak) {
                return e.e;
            }
            return null;
        }
    }

}

