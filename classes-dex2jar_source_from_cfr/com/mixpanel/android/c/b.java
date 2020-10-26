/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.c;

public class b {
    private static char[] a = new char[64];
    private static byte[] b;

    static {
        int n2 = 0;
        int n3 = 65;
        int n4 = 0;
        while (n3 <= 90) {
            b.a[n4] = n3;
            n3 = (char)(n3 + 1);
            ++n4;
        }
        n3 = 97;
        while (n3 <= 122) {
            b.a[n4] = n3;
            n3 = (char)(n3 + 1);
            ++n4;
        }
        n3 = 48;
        while (n3 <= 57) {
            b.a[n4] = n3;
            n3 = (char)(n3 + 1);
            ++n4;
        }
        b.a[n4] = 43;
        b.a[n4 + 1] = 47;
        b = new byte[128];
        n4 = 0;
        do {
            if (n4 >= b.length) break;
            b.b[n4] = -1;
            ++n4;
        } while (true);
        for (int i2 = n2; i2 < 64; ++i2) {
            b.b[b.a[i2]] = (byte)i2;
        }
    }

    public static String a(String string2) {
        return new String(b.a(string2.getBytes()));
    }

    public static char[] a(byte[] arrby) {
        return b.a(arrby, arrby.length);
    }

    public static char[] a(byte[] arrby, int n2) {
        int n3 = (n2 * 4 + 2) / 3;
        char[] arrc = new char[(n2 + 2) / 3 * 4];
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            int n6;
            int n7;
            int n8 = n4 + 1;
            int n9 = arrby[n4] & 255;
            if (n8 < n2) {
                n4 = n8 + 1;
                n8 = arrby[n8] & 255;
            } else {
                n4 = n8;
                n8 = 0;
            }
            if (n4 < n2) {
                n7 = n4 + 1;
                n6 = arrby[n4] & 255;
                n4 = n7;
            } else {
                n6 = 0;
            }
            n7 = n5 + 1;
            arrc[n5] = a[n9 >>> 2];
            n5 = n7 + 1;
            arrc[n7] = a[(n9 & 3) << 4 | n8 >>> 4];
            int n10 = 61;
            int n11 = n5 < n3 ? a[(n8 & 15) << 2 | n6 >>> 6] : 61;
            arrc[n5] = n11;
            n11 = n10;
            if (++n5 < n3) {
                n11 = a[n6 & 63];
            }
            arrc[n5] = n11;
            ++n5;
        }
        return arrc;
    }
}

