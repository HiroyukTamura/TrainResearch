/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.aa;
import c.t;
import java.net.Proxy;

public final class i {
    public static String a(aa aa2, Proxy.Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aa2.b());
        stringBuilder.append(' ');
        if (i.b(aa2, type)) {
            stringBuilder.append(aa2.a());
        } else {
            stringBuilder.append(i.a(aa2.a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    public static String a(t object) {
        String string2 = ((t)object).h();
        String string3 = ((t)object).k();
        object = string2;
        if (string3 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append('?');
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
        }
        return object;
    }

    private static boolean b(aa aa2, Proxy.Type type) {
        return !aa2.g() && type == Proxy.Type.HTTP;
    }
}

