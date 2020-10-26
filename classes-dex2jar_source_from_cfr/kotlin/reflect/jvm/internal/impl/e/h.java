/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import kotlin.reflect.jvm.internal.impl.e.f;

public class h {
    public static final f a = f.c("<no name provided>");
    public static final f b = f.c("<root package>");
    public static final f c = f.a("Companion");
    public static final f d = f.a("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
    public static final f e = f.c("<anonymous>");

    public static f a(f f2) {
        if (f2 != null && !f2.c()) {
            return f2;
        }
        return d;
    }

    public static boolean b(f f2) {
        return !f2.a().isEmpty() && !f2.c();
    }
}

