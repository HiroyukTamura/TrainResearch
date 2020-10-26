/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.sst.a;

import jp.co.bug.a.a;
import jp.co.bug.sst.a.b;

public class d
implements b {
    int a;
    byte[] b;

    public d(int n2, byte[] arrby) {
        this.a = n2;
        this.b = arrby;
    }

    public static String a(int n2, String string2) {
        return String.format("%s%01X%06d", string2, (byte)(n2 >> 20), n2 & 1048575);
    }

    @Override
    public int a() {
        return 128;
    }

    @Override
    public String a(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v=d1&x=");
        stringBuilder.append(this.d());
        stringBuilder.append("&y=");
        stringBuilder.append(a.a(this.c()));
        return stringBuilder.toString();
    }

    @Override
    public int b() {
        return this.a;
    }

    public byte[] c() {
        return this.b;
    }

    public String d() {
        return d.a(this.a, "D");
    }
}

