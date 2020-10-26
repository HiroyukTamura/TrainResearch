/*
 * Decompiled with CFR 0.139.
 */
package d;

import java.io.UnsupportedEncodingException;

final class b {
    private static final byte[] a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] arrby) {
        return b.a(arrby, a);
    }

    private static String a(byte[] object, byte[] arrby) {
        int n2;
        int n3;
        byte[] arrby2 = new byte[(((byte[])object).length + 2) / 3 * 4];
        int n4 = ((byte[])object).length - ((byte[])object).length % 3;
        int n5 = 0;
        for (n3 = 0; n3 < n4; n3 += 3) {
            n2 = n5 + 1;
            arrby2[n5] = arrby[(object[n3] & 255) >> 2];
            n5 = n2 + 1;
            byte by2 = object[n3];
            int n6 = n3 + 1;
            arrby2[n2] = arrby[(by2 & 3) << 4 | (object[n6] & 255) >> 4];
            n2 = n5 + 1;
            by2 = object[n6];
            n6 = n3 + 2;
            arrby2[n5] = arrby[(by2 & 15) << 2 | (object[n6] & 255) >> 6];
            n5 = n2 + 1;
            arrby2[n2] = arrby[object[n6] & 63];
        }
        switch (((byte[])object).length % 3) {
            default: {
                break;
            }
            case 2: {
                n3 = n5 + 1;
                arrby2[n5] = arrby[(object[n4] & 255) >> 2];
                n5 = n3 + 1;
                n2 = object[n4];
                arrby2[n3] = arrby[(n2 & 3) << 4 | (object[++n4] & 255) >> 4];
                arrby2[n5] = arrby[(object[n4] & 15) << 2];
                arrby2[n5 + 1] = 61;
                break;
            }
            case 1: {
                n3 = n5 + 1;
                arrby2[n5] = arrby[(object[n4] & 255) >> 2];
                n5 = n3 + 1;
                arrby2[n3] = arrby[(object[n4] & 3) << 4];
                arrby2[n5] = 61;
                arrby2[n5 + 1] = 61;
            }
        }
        try {
            object = new String(arrby2, "US-ASCII");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError(unsupportedEncodingException);
        }
    }
}

