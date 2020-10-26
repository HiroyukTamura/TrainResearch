/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import kotlin.e.b.g;

public final class w
extends Enum<w> {
    public static final /* enum */ w a;
    public static final /* enum */ w b;
    public static final /* enum */ w c;
    public static final /* enum */ w d;
    public static final a e;
    private static final /* synthetic */ w[] f;

    static {
        w w2;
        w w3;
        w w4;
        w w5;
        a = w2 = new w();
        b = w5 = new w();
        c = w3 = new w();
        d = w4 = new w();
        f = new w[]{w2, w5, w3, w4};
        e = new a(null);
    }

    public static w valueOf(String string2) {
        return Enum.valueOf(w.class, string2);
    }

    public static w[] values() {
        return (w[])f.clone();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final w a(boolean bl2, boolean bl3) {
            if (bl2) {
                return w.d;
            }
            if (bl3) {
                return w.c;
            }
            return w.a;
        }
    }

}

