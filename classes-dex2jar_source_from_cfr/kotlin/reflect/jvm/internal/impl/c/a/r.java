/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.n;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.k.a.a;
import kotlin.y;

public final class r {
    public static final f a(f f2) {
        j.b(f2, "methodName");
        f f3 = r.a(f2, "get", false, null, 12, null);
        if (f3 != null) {
            return f3;
        }
        return r.a(f2, "is", false, null, 8, null);
    }

    private static final f a(f object, String string2, boolean bl2, String string3) {
        if (((f)object).c()) {
            return null;
        }
        String string4 = ((f)object).b();
        j.a((Object)string4, "identifier");
        if (!kotlin.i.n.a(string4, string2, false, 2, null)) {
            return null;
        }
        if (string4.length() == string2.length()) {
            return null;
        }
        char c2 = string4.charAt(string2.length());
        if ('a' <= c2 && 'z' >= c2) {
            return null;
        }
        if (string3 != null) {
            if (y.a && !bl2) {
                throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(kotlin.i.n.a(string4, string2));
            return f.a(((StringBuilder)object).toString());
        }
        if (!bl2) {
            return object;
        }
        object = a.a(kotlin.i.n.a(string4, string2), true);
        if (!f.b((String)object)) {
            return null;
        }
        return f.a((String)object);
    }

    static /* bridge */ /* synthetic */ f a(f f2, String string2, boolean bl2, String string3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = true;
        }
        if ((n2 & 8) != 0) {
            string3 = null;
        }
        return r.a(f2, string2, bl2, string3);
    }

    public static final f a(f f2, boolean bl2) {
        String string2;
        j.b(f2, "methodName");
        string2 = bl2 ? "is" : null;
        return r.a(f2, "set", false, string2, 4, null);
    }

    public static final List<f> b(f f2) {
        j.b(f2, "methodName");
        return m.h((Iterable)m.b(r.a(f2, false), r.a(f2, true)));
    }

    public static final List<f> c(f f2) {
        j.b(f2, "name");
        String string2 = f2.a();
        if (n.a(string2)) {
            return m.b(r.a(f2));
        }
        if (n.b(string2)) {
            return r.b(f2);
        }
        return e.a.a(f2);
    }
}

