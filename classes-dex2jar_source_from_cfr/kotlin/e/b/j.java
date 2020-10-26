/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.util.Arrays;
import java.util.List;
import kotlin.f;
import kotlin.v;

public class j {
    private j() {
    }

    public static int a(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        return n2 != n3;
    }

    public static String a(String string2, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    private static <T extends Throwable> T a(T t2) {
        return j.a(t2, j.class.getName());
    }

    static <T extends Throwable> T a(T t2, String object) {
        StackTraceElement[] arrstackTraceElement = ((Throwable)t2).getStackTrace();
        int n2 = arrstackTraceElement.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((String)object).equals(arrstackTraceElement[i2].getClassName())) continue;
            n3 = i2;
        }
        object = Arrays.asList(arrstackTraceElement).subList(n3 + 1, n2);
        ((Throwable)t2).setStackTrace(object.toArray(new StackTraceElement[object.size()]));
        return t2;
    }

    public static void a() {
        throw j.a(new f());
    }

    public static void a(Object object, String string2) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" must not be null");
        throw j.a(new IllegalStateException(((StringBuilder)object).toString()));
    }

    public static void a(String string2) {
        throw j.a(new v(string2));
    }

    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void b(Object object, String string2) {
        if (object == null) {
            j.c(string2);
        }
    }

    public static void b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string2);
        stringBuilder.append(" has not been initialized");
        j.a(stringBuilder.toString());
    }

    private static void c(String string2) {
        Object object = Thread.currentThread().getStackTrace()[3];
        String string3 = ((StackTraceElement)object).getClassName();
        object = ((StackTraceElement)object).getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(string3);
        stringBuilder.append(".");
        stringBuilder.append((String)object);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string2);
        throw j.a(new IllegalArgumentException(stringBuilder.toString()));
    }
}

