/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.aa;
import c.ac;
import c.l;
import c.m;
import c.s;
import c.t;
import java.util.List;
import java.util.regex.Pattern;

public final class e {
    private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static int a(String string2, int n2) {
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (c2 != ' ' && c2 != '\t') {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static int a(String string2, int n2, String string3) {
        while (n2 < string2.length()) {
            if (string3.indexOf(string2.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static long a(ac ac2) {
        return e.a(ac2.f());
    }

    public static long a(s s2) {
        return e.a(s2.a("Content-Length"));
    }

    private static long a(String string2) {
        if (string2 == null) {
            return -1L;
        }
        try {
            long l2 = Long.parseLong(string2);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return -1L;
        }
    }

    public static void a(m m2, t t2, s object) {
        if (m2 == m.a) {
            return;
        }
        if ((object = l.a(t2, (s)object)).isEmpty()) {
            return;
        }
        m2.a(t2, (List<l>)object);
    }

    public static int b(String string2, int n2) {
        long l2;
        block3 : {
            try {
                l2 = Long.parseLong(string2);
                if (l2 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (l2 >= 0L) break block3;
                return 0;
            }
            catch (NumberFormatException numberFormatException) {
                return n2;
            }
        }
        return (int)l2;
    }

    public static boolean b(ac ac2) {
        if (ac2.a().b().equals("HEAD")) {
            return false;
        }
        int n2 = ac2.b();
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        if (e.a(ac2) == -1L) {
            return "chunked".equalsIgnoreCase(ac2.a("Transfer-Encoding"));
        }
        return true;
    }
}

