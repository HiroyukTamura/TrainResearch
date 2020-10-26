/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.sst.a;

import java.io.ByteArrayInputStream;
import jp.co.bug.sst.a.b;
import jp.co.bug.sst.a.c;
import jp.co.bug.sst.a.d;
import jp.co.bug.sst.a.e;

public class a {
    private static int a(ByteArrayInputStream byteArrayInputStream, int n2) {
        byte[] arrby = new byte[n2];
        if (byteArrayInputStream.read(arrby, 0, n2) == n2) {
            return a.a(arrby, n2);
        }
        throw new a("data length error");
    }

    private static int a(byte[] arrby, int n2) {
        return a.a(arrby, 0, n2);
    }

    private static int a(byte[] arrby, int n2, int n3) {
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n4 |= (arrby[n2 + i2] & 255) << i2 * 8;
        }
        return n4;
    }

    public static b a(byte[] arrby) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        int n2 = a.a(byteArrayInputStream, 1);
        switch (n2) {
            default: {
                return new e(n2, a.a(byteArrayInputStream, 3));
            }
            case 129: {
                n2 = a.a(byteArrayInputStream, 3);
                if (arrby.length == 6) {
                    return new c(n2);
                }
                throw new a("data length error");
            }
            case 128: 
        }
        n2 = a.a(byteArrayInputStream, 3);
        arrby = new byte[7];
        if (byteArrayInputStream.read(arrby, 0, 7) == 7) {
            return new d(n2, arrby);
        }
        throw new a("data length error");
    }

    public static class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }
    }

}

