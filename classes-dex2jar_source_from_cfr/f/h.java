/*
 * Decompiled with CFR 0.139.
 */
package f;

import f.m;
import f.p;

public class h
extends RuntimeException {
    private final int a;
    private final String b;
    private final transient m<?> c;

    public h(m<?> m2) {
        super(h.a(m2));
        this.a = m2.a();
        this.b = m2.b();
        this.c = m2;
    }

    private static String a(m<?> m2) {
        p.a(m2, "response == null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(m2.a());
        stringBuilder.append(" ");
        stringBuilder.append(m2.b());
        return stringBuilder.toString();
    }
}

