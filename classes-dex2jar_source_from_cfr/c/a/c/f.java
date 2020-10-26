/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

public final class f {
    public static boolean a(String string2) {
        return string2.equals("POST") || string2.equals("PATCH") || string2.equals("PUT") || string2.equals("DELETE") || string2.equals("MOVE");
        {
        }
    }

    public static boolean b(String string2) {
        return string2.equals("POST") || string2.equals("PUT") || string2.equals("PATCH") || string2.equals("PROPPATCH") || string2.equals("REPORT");
        {
        }
    }

    public static boolean c(String string2) {
        return !string2.equals("GET") && !string2.equals("HEAD");
    }

    public static boolean d(String string2) {
        return string2.equals("PROPFIND");
    }

    public static boolean e(String string2) {
        return string2.equals("PROPFIND") ^ true;
    }
}

