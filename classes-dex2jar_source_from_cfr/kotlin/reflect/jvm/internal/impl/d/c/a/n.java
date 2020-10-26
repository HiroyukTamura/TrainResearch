/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import kotlin.e.b.j;
import kotlin.y;

public final class n {
    public static final byte[] a(String[] arrstring) {
        int n2;
        j.b(arrstring, "strings");
        int n3 = arrstring.length;
        int n4 = 0;
        int n5 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            n5 += arrstring[n2].length();
        }
        byte[] arrby = new byte[n5];
        int n6 = arrstring.length;
        n2 = 0;
        for (n5 = 0; n5 < n6; ++n5) {
            String string2 = arrstring[n5];
            int n7 = string2.length() - 1;
            n3 = n2;
            if (n7 >= 0) {
                int n8;
                n3 = 0;
                do {
                    n8 = n2 + 1;
                    arrby[n2] = (byte)string2.charAt(n3);
                    if (n3 == n7) break;
                    ++n3;
                    n2 = n8;
                } while (true);
                n3 = n8;
            }
            n2 = n3;
        }
        n5 = n4;
        if (n2 == arrby.length) {
            n5 = 1;
        }
        if (y.a) {
            if (n5 != 0) {
                return arrby;
            }
            throw (Throwable)((Object)new AssertionError((Object)"Should have reached the end"));
        }
        return arrby;
    }
}

