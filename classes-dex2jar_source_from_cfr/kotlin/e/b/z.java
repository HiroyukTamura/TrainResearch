/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.e.b.a.a;
import kotlin.e.b.a.e;
import kotlin.e.b.a.f;
import kotlin.e.b.a.g;
import kotlin.e.b.j;

public class z {
    public static ClassCastException a(ClassCastException classCastException) {
        throw z.a(classCastException);
    }

    private static <T extends Throwable> T a(T t2) {
        return j.a(t2, z.class.getName());
    }

    public static List a(Object object) {
        if (object instanceof a && !(object instanceof e)) {
            z.a(object, "kotlin.collections.MutableList");
        }
        return z.b(object);
    }

    public static void a(Object object, String string2) {
        object = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string2);
        z.a(stringBuilder.toString());
    }

    public static void a(String string2) {
        throw z.a(new ClassCastException(string2));
    }

    public static List b(Object object) {
        try {
            object = (List)object;
            return object;
        }
        catch (ClassCastException classCastException) {
            throw z.a(classCastException);
        }
    }

    public static Set c(Object object) {
        if (object instanceof a && !(object instanceof g)) {
            z.a(object, "kotlin.collections.MutableSet");
        }
        return z.d(object);
    }

    public static Set d(Object object) {
        try {
            object = (Set)object;
            return object;
        }
        catch (ClassCastException classCastException) {
            throw z.a(classCastException);
        }
    }

    public static Map e(Object object) {
        if (object instanceof a && !(object instanceof f)) {
            z.a(object, "kotlin.collections.MutableMap");
        }
        return z.f(object);
    }

    public static Map f(Object object) {
        try {
            object = (Map)object;
            return object;
        }
        catch (ClassCastException classCastException) {
            throw z.a(classCastException);
        }
    }
}

