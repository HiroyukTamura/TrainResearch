/*
 * Decompiled with CFR 0.139.
 */
package d;

import java.nio.charset.Charset;

final class v {
    public static final Charset a = Charset.forName("UTF-8");

    public static int a(int n2) {
        return (n2 & 255) << 24 | ((-16777216 & n2) >>> 24 | (16711680 & n2) >>> 8 | (65280 & n2) << 8);
    }

    public static short a(short s2) {
        s2 = (short)(s2 & 65535);
        return (short)((s2 & 255) << 8 | (65280 & s2) >>> 8);
    }

    public static void a(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", l2, l3, l4));
    }

    public static void a(Throwable throwable) {
        v.b(throwable);
    }

    public static boolean a(byte[] arrby, int n2, byte[] arrby2, int n3, int n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            if (arrby[i2 + n2] == arrby2[i2 + n3]) continue;
            return false;
        }
        return true;
    }

    private static <T extends Throwable> void b(Throwable throwable) {
        throw throwable;
    }
}

