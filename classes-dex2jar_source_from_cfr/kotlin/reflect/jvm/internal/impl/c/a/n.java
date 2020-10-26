/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.k.a.a;

public final class n {
    public static final b a = new b("kotlin.jvm.JvmField");
    public static final kotlin.reflect.jvm.internal.impl.e.a b = kotlin.reflect.jvm.internal.impl.e.a.a(new b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    public static boolean a(String string2) {
        return string2.startsWith("get") || string2.startsWith("is");
        {
        }
    }

    public static boolean a(ai ai2) {
        if (ai2.n() == b.a.b) {
            return false;
        }
        if (n.a(ai2.b())) {
            return true;
        }
        return c.i(ai2.b()) && n.a((kotlin.reflect.jvm.internal.impl.a.b)ai2);
    }

    public static boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
        for (g g2 : b2.x().b()) {
            if (!e.a.equals((Object)g2.b()) || !a.equals(g2.a().b())) continue;
            return true;
        }
        return b2.x().b(a);
    }

    public static boolean a(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject(e2);
    }

    public static boolean a(m m2) {
        return c.i(m2) && c.q(m2.b()) && !n.a((kotlin.reflect.jvm.internal.impl.a.e)m2);
    }

    public static boolean b(String string2) {
        return string2.startsWith("set");
    }

    public static String c(String string2) {
        if (n.e(string2)) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(a.a(string2));
        return stringBuilder.toString();
    }

    public static String d(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        string2 = n.e(string2) ? string2.substring("is".length()) : a.a(string2);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static boolean e(String string2) {
        boolean bl2 = string2.startsWith("is");
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        if (string2.length() == "is".length()) {
            return false;
        }
        char c2 = string2.charAt("is".length());
        if ('a' > c2 || c2 > 'z') {
            bl3 = true;
        }
        return bl3;
    }
}

