/*
 * Decompiled with CFR 0.139.
 */
package c;

import java.io.IOException;

public enum y {
    a("http/1.0"),
    b("http/1.1"),
    c("spdy/3.1"),
    d("h2"),
    e("quic");
    
    private final String f;

    private y(String string3) {
        this.f = string3;
    }

    public static y a(String string2) {
        if (string2.equals(y.a.f)) {
            return a;
        }
        if (string2.equals(y.b.f)) {
            return b;
        }
        if (string2.equals(y.d.f)) {
            return d;
        }
        if (string2.equals(y.c.f)) {
            return c;
        }
        if (string2.equals(y.e.f)) {
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected protocol: ");
        stringBuilder.append(string2);
        throw new IOException(stringBuilder.toString());
    }

    public String toString() {
        return this.f;
    }
}

