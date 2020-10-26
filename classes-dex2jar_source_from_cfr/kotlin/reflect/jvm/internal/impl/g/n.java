/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import kotlin.e.b.j;

public abstract class n
extends Enum<n> {
    public static final /* enum */ n a;
    public static final /* enum */ n b;
    private static final /* synthetic */ n[] c;

    static {
        b b2 = new b("PLAIN", 0);
        a = b2;
        a a2 = new a("HTML", 1);
        b = a2;
        c = new n[]{b2, a2};
    }

    public static n valueOf(String string2) {
        return Enum.valueOf(n.class, string2);
    }

    public static n[] values() {
        return (n[])c.clone();
    }

    public abstract String a(String var1);

    public static final class a
    extends n {
        a() {
        }

        @Override
        public String a(String string2) {
            j.b(string2, "string");
            return kotlin.i.n.a(kotlin.i.n.a(string2, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    }

    public static final class b
    extends n {
        b() {
        }

        @Override
        public String a(String string2) {
            j.b(string2, "string");
            return string2;
        }
    }

}

